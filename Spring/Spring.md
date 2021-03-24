## Spring

### IOC & DI

#### IoC

传统应用程序都是由我们在类内部主动创建依赖对象，从而导致类与类之间高耦合，难于测试；有了IoC容器后，把创建和查找依赖对象的控制权交给了容器，由容器进行注入组合对象，所以对象与对象之间是 松散耦合，这样也方便测试，利于功能复用，更重要的是使得程序的整个体系结构变得非常灵活。所谓IoC，对于spring框架来说，就是由spring来负责控制对象的生命周期和对象间的关系。<u>所有的类都会在spring容器中登记，告诉spring你是个什么东西，你需要什么东西，然后spring会在系统运行到适当的时候，把你要的东西主动给你，同时也把你交给其他需要你的东西。所有的类的创建、销毁都由 spring来控制，也就是说控制对象生存周期的不再是引用它的对象，而是spring。对于某个具体的对象而言，以前是它控制其他对象，现在是所有对象都被spring控制，所以这叫控制反转。</u>

所有的IoC容器都需要实现接口`BeanFactory`，它是一个顶级容器接口。

`BeanFactory`接口方法：

![image-20201203220406559](C:\Users\chy\AppData\Roaming\Typora\typora-user-images\image-20201203220406559.png)

其中`isSingleton`方法是判断Bean是否在Spring IoC中为单例，默认情况下为true，即Bean都是以单例存在的。还有一个方法是`isPrototype`方法，如果是true，则每当使用getBean方法时，Spring IoC容器都会创建一个新的Bean返回。

![image-20201203221927539](C:\Users\chy\AppData\Roaming\Typora\typora-user-images\image-20201203221927539.png)

由于BeanFactory的功能还不够强大，因此Spring在BeanFactory的基础上，还设计了一个更高级的接口ApplicationContext。

从上图可以看到ApplicationContext通过继承上级接口，进而继承BeanFactory，同时扩展了消息国际化接口（MessageSource）、环境可配置接口（EnvironmenCapable）、应用事件发布接口（ApplicationEventPublisher）和资源模式解析接口（ResourcePatternResolver）。

#### DI

IoC的一个重点是在系统运行中，动态的向某个对象提供它所需要的其他对象。这一点是通过DI（Dependency Injection，依赖注入）来实现的。如下面一段代码：

```java
public interface Person {
    //使用动物服务
    public void service();
    
    //设置动物
    public void setAnimal(Animal animal);
}

public interface Animal {
    public void use();
}

@Componet
public class BussinessPerson implements Person {
    @Autowired
    private Animal animal = null;
    
    @Override
    public void service() {
        this.animal.use();
    }
    
    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}

@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗是看门用的")；
    }
}

//测试代码
ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
Person person = ctx.getBean(BussinessPerson.class);
person.service();
```

上述代码中BussinessPerson需要一个animal对象，有了容器后，只需要告诉容器BussinessPerson需要一个Animal，至于这个Animal是怎么构造的，什么时候构造的，BussinessPerson都不需要知道，在运行时，容器会在适当的时候制造一个Animal，然后像打针一样注射到BussinessPerson中，这样就完成了各个对象之间关系控制。（借助反射机制来实现注入的）

#### Bean的生命周期：

![image-20201203223738542](C:\Users\chy\AppData\Roaming\Typora\typora-user-images\image-20201203223738542.png)

![image-20201203223753697](C:\Users\chy\AppData\Roaming\Typora\typora-user-images\image-20201203223753697.png)

上面两幅图则是IoC容器初始化Bean的流程。

1. setBeanName(String beanName)

   属性注入后调用，该方法作用是让bean类知道自己所在的Bean的name或id属性。
   实现：bean类实现BeanNameAware接口，重写该方法。

2. setBeanFactory(BeanFactory factory)

   setBeanName后调用，该方法作用是让bean类知道自己所在的BeanFactory的属性（传入bean所在BeanFactory类型参数）。
   实现：bean类实现BeanFactoryAware接口，实现该方法。

3. postProcessBeforeInitialization(Object bean,String beanName)

   BeanPostProcessor作用是对bean实例化、初始化做些预处理操作（注2）。
   实现：写一个类，实现BeanPostProcessor接口，注意返回类型为Object，默认返回null，需要返回参数中bean。

4. 自定义初始化方法

5. afterPropertiesSet()

   实现：bean类实现InitializingBean接口，重写该方法。初始化工作，但实现该接口这种方法和Spring耦合，不推荐（这一点DisposableBean一样）。

6. postProcessAfterInitialization(Object bean,Strign beanName)

   同postProcessBeforeInitialization

7. 程序执行，bean工作

8. 自定义销毁方法

9. destroy()

   bean销毁前执行
   实现：bean类实现DisposableBean接口

代码测试如下：

```java
//Person interface
public interface Person {
    //使用动物服务
    public void service();

    //设置动物
    public void setAnimal(Animal animal);
}

//Animal interface
public interface Animal {
    public void use();
}

//Dog 定义
@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗[" + Dog.class.getSimpleName() + "]是看门用的");
    }
}

//Cat 定义
@Component
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫[" + Cat.class.getSimpleName() + "]是抓老鼠");
    }
}

//BussinessPerson 定义,继承了BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializationBean,DisposableBean接口
@Component
public class BussinessPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    Animal animal = null;

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    @Autowired
    @Qualifier("dog")
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用BeanFactoryAware的setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用BeanNameAware的setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[" + this.getClass().getSimpleName() + "]DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用的InitializingBean的afterPropertiesSet方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用ApplicationContextAware的setBeanFactory的setApplicationContext");
    }

    @PostConstruct
    public void init() {
        System.out.println("[" + this.getClass().getSimpleName() + "]注解@PostConstruct定义的自定义初始化方法");
    }

    @PreDestroy
    public void destroy1() {
        System.out.println("[" + this.getClass().getSimpleName() + "]注解@PreDestroy定义的自定义销毁方法");
    }
}

//后置Bean初始化器
@Component
public class BeanPostProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("BeanPostProcessor调用" + "PostProcessorBeforeInitialization方法，参数["
        + bean.getClass().getSimpleName() + "][" + beanName + "]");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("BeanPostProcessor调用" + "PostProcessorAfterInitialization方法，参数["
                + bean.getClass().getSimpleName() + "][" + beanName + "]");
        return bean;
    }
}

//扫描器
@Configuration
@ComponentScan
public class AppConfig {
}

//测试
public class test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = ctx.getBean(BussinessPerson.class);
        person.service();
        ctx.close();
    }
}

//结果
BeanPostProcessor调用PostProcessorBeforeInitialization方法，参数[AppConfig$$EnhancerBySpringCGLIB$$d115bb43][appConfig]
BeanPostProcessor调用PostProcessorAfterInitialization方法，参数[AppConfig$$EnhancerBySpringCGLIB$$d115bb43][appConfig]
BeanPostProcessor调用PostProcessorBeforeInitialization方法，参数[Dog][dog]
BeanPostProcessor调用PostProcessorAfterInitialization方法，参数[Dog][dog]
延迟依赖注入
[BussinessPerson]调用BeanNameAware的setBeanName
[BussinessPerson]调用BeanFactoryAware的setBeanFactory
[BussinessPerson]调用ApplicationContextAware的setBeanFactory的setApplicationContext
BeanPostProcessor调用PostProcessorBeforeInitialization方法，参数[BussinessPerson][bussinessPerson]
[BussinessPerson]注解@PostConstruct定义的自定义初始化方法
[BussinessPerson]调用的InitializingBean的afterPropertiesSet方法
BeanPostProcessor调用PostProcessorAfterInitialization方法，参数[BussinessPerson][bussinessPerson]
BeanPostProcessor调用PostProcessorBeforeInitialization方法，参数[Cat][cat]
BeanPostProcessor调用PostProcessorAfterInitialization方法，参数[Cat][cat]
狗[Dog]是看门用的
[BussinessPerson]注解@PreDestroy定义的自定义销毁方法
[BussinessPerson]DisposableBean

Process finished with exit code 0
```

以上则是Bean的生命周期。

#### IOC源码分析

IOC中的重要组件：

1. BeanFactory
2. ApplicationContext
3. BeanDefinition

当我们使用ioc时，首先申明一个context对象，将我们的配置文件传到里面去。context构造函数做了两件事，一件事设置配置文件，第二件就是刷新容器，其中的refresh方法是这里面最重要的方法，他是整个IOC容器初始化的所有逻辑。

在这其中，它调用了一个ConfigurableListableBeanFactory来创建了一个Beanfactory，在这里面他首先判断了这个beanFactory是否存在，存在则销毁，然后开始创建beanfactory，然后她会调用一个loadBeanDefinition的方法，来加载bean的定义，这里面会涉及到对配置文件的读取，然后加载bean的定义，并将beanname和beandefinition保存到一个concurrenthashmap中，这里完成了bean的注册。

在解析xml文件时，回创建beanDefinition并将其保存到一个holder中，并且这个holder也持有从xml文件中配置的Class对象。

在这里完成了bean工厂的创建，生成了bean的定义，但是还没有实例化bean。

创建Bean并且构建Bean的依赖关系是在finishBeanFactoryInitialization()方法中实现的，其中有一个beanFactory.preInstantiateSingletons()来实例化bean'的。其中回调用getBean，然后到doGetBean，在这里面会处理依赖关系，她会递归的调用getBean来获取依赖的bean对象。

在getBean中回调用genSingleton方法，从而在使用doCreateBean方法，其中有两个关键步骤，一是创建实例，二是填充Bean，也是发生依赖注入的地方。第一步他会得到类的构造器，然后通过反射的方式先创建实例，然后再获取bean'的所有属性，然后如果有依赖的bean，他会递归的调用getBean来获取这个bean，然后再使用setPropertyValue方法，来完成属性的注入，也是使用反射机制来实现的。

总结一下 IOC 的初始化过程吧:

1. 资源(Resource)定位;
2. BeanDefinition 的载入和 BeanFactory 的构造.
3. 想 IOC 容器(BeanFactory)注册 BeanDefinition.
4. 根据 lazy-init 属性初始化 Bean 实例和依赖注入.

### AOP

#### 引入

**代理：**

首先定义一个service接口：

```java
public interface HelloService {
    public void sayHello(String name);
}
```

然后一个实现接口实现类

```java
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException("parameter is null !!!");
        }
        System.out.println("hello " + name);
    }
}
```

定义一个拦截器接口

```java
public interface Interceptor {
    //事前方法
    public boolean before();

    //事后方法
    public void after();

    /**
     * 取代原有事件方法
     * @param invocation -- 回调函数，可以通过它的proceed方法，回调原有事件
     * @return 原有事件返回对象
     * @throws java.lang.reflect.InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object around(Invocation invocation) throws Throwable;

    //事后返回方法。事件没有发生异常执行
    public void afterReturning();

    //事后异常方法，当事件发生异常后执行
    public void afterThrowing();

    //是否使用around方法取代原有方法
    boolean useAround();
}
```

其中invocation源代码如下

```java
public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;

    public Invocation(Object target, Method method, Object[] params) {
        this.target = target;
        this.method = method;
        this.params = params;
    }

    //反射方法
    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
```

其中proceed方法会以反射的形式去调用原有的方法。

定义一个拦截器接口实现类

```java
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("before...");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after...");
    }

    @Override
    public Object around(Invocation invocation) throws Throwable {
        System.out.println("around before...");
        Object obj = invocation.proceed();
        System.out.println("around after...");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing..");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
```

定义一个ProxyBean，获得代理类

```java
public class ProxyBean implements InvocationHandler {
    private Object target = null;

    private Interceptor interceptor = null;

    /**
     * 绑定代理对象
     * @param target 被代理对象
     * @param interceptor 拦截器
     * @return 代理对象
     */
    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        //保存被代理对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interceptor = interceptor;
        //生成代理对象
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        //返回代理对象
        return proxy;
    }

    /**
     * 处理代理对象方法逻辑
     * @param proxy 代理对象
     * @param method 当前方法
     * @param args 运行参数
     * @return 方法调用结果
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(target, method, args);
        this.interceptor.before();
        Object retObj = null;
        try {
            if(this.interceptor.useAround()) {
                retObj = this.interceptor.around(invocation);
            } else {
                retObj = method.invoke(target, args);
            }
        } catch (Exception ex) {
            //产生异常
            exceptionFlag = true;
        }
        this.interceptor.after();
        if(exceptionFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}
```

其中有一个静态方法，也是Spring AOP的本质

```java
public static Object getProxyBean(Object target, Interceptor interceptor)
```

* 要求参数target对象存在接口，而interceptor对象是上面拦截器定义的接口对象

* 它将返回一个对象proxy，可以使用target对象实现的接口类型对它进行强制转换，其中生成的proxy对象是继承了Proxy对象，并实现了target实现的接口，[其中调用方法说明见链接](https://blog.csdn.net/zcc_0015/article/details/22695647?utm_source=tuicool&utm_medium=referral),[Porxy解析](https://www.cnblogs.com/benwu/articles/8283549.html)，如下生成的代理对象$Proxy0的源代码，调用sayHello时会调用其父对象的invocationHandler的invoke方法。

  ```java
  //
  // Source code recreated from a .class file by IntelliJ IDEA
  // (powered by Fernflower decompiler)
  //
  
  import com.chy.testAOP.service.HelloService;
  import java.lang.reflect.InvocationHandler;
  import java.lang.reflect.Method;
  import java.lang.reflect.Proxy;
  import java.lang.reflect.UndeclaredThrowableException;
  
  public final class $Proxy0 extends Proxy implements HelloService {
      private static Method m1;
      private static Method m3;
      private static Method m2;
      private static Method m0;
  
      public $Proxy0(InvocationHandler var1) throws  {
          super(var1);
      }
  
      public final boolean equals(Object var1) throws  {
          try {
              return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
          } catch (RuntimeException | Error var3) {
              throw var3;
          } catch (Throwable var4) {
              throw new UndeclaredThrowableException(var4);
          }
      }
  
      public final void sayHello(String var1) throws  {
          try {
              super.h.invoke(this, m3, new Object[]{var1});
          } catch (RuntimeException | Error var3) {
              throw var3;
          } catch (Throwable var4) {
              throw new UndeclaredThrowableException(var4);
          }
      }
  
      public final String toString() throws  {
          try {
              return (String)super.h.invoke(this, m2, (Object[])null);
          } catch (RuntimeException | Error var2) {
              throw var2;
          } catch (Throwable var3) {
              throw new UndeclaredThrowableException(var3);
          }
      }
  
      public final int hashCode() throws  {
          try {
              return (Integer)super.h.invoke(this, m0, (Object[])null);
          } catch (RuntimeException | Error var2) {
              throw var2;
          } catch (Throwable var3) {
              throw new UndeclaredThrowableException(var3);
          }
      }
  
      static {
          try {
              m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
              m3 = Class.forName("com.chy.testAOP.service.HelloService").getMethod("sayHello", Class.forName("java.lang.String"));
              m2 = Class.forName("java.lang.Object").getMethod("toString");
              m0 = Class.forName("java.lang.Object").getMethod("hashCode");
          } catch (NoSuchMethodException var2) {
              throw new NoSuchMethodError(var2.getMessage());
          } catch (ClassNotFoundException var3) {
              throw new NoClassDefFoundError(var3.getMessage());
          }
      }
  }
  
  ```

  

  

* 其中`nerProxyInstace(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)`参数解释如下：
  * loader：一个classloader对象，定义了由哪个classloader对象对生成的代理类进行加载
  * interfaces：一个interface对象数组，表示我们将要给我们的代理对象提供一组什么样的接口，如果我们提供了这样一个接口对象数组，那么也就是声明了代理类实现了这些接口，代理类就可以调用接口中声明的所有方法。
  * h：一个InvocationHandler对象，表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并最终由其调用。

上述代码流程如下：

1. 使用proxy调用方法时会先执行拦截器的before方法
2. 如果拦截器useAround方法返回true，则执行拦截器的around方法，而不调用target对应的方法，但around方法的参数invocation对象存在一个proceed方法，它可以调用target对象对应的方法；如果useAround方法返回false，则调用target对象的事件方法
3. 执行过程中若发生异常，则执行afterThrowing方法，否则执行afterReturning方法

测试代码

```java
public class test {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("chy");
        System.out.println("\n############### name is null!!! ###############\n");
        proxy.sayHello(null);
    }
}
```

测试结果

```java
before...
around before...
hello chy
around after...
after...
afterReturning...

############### name is null!!! ###############

before...
around before...
after...
afterThrowing..
```

#### 概念

AOP编程可不是Spring独有的，Spring只是支持AOP编程的框架之一，这一点非常重要，切勿搞反了关系

AOP可以将分散在各个业务逻辑代码中的相同（通用）代码，通过横向切割的方式抽取到一个独立的模块中，让业务逻辑类依然保存最初的单纯，这样可以使开发者的代码更加简短，同时可维护性也提高。

#### AOP术语和流程

1. **连接点（join point）**：对应的是具体被拦截的对象，因为Spring只能支持方法，所以被拦截的对象往往就是指特定的方法，例如之前例子中的sayHello方法就是一个连接点，AOP将通过动态代理技术把它织入对应的流程中。
2. **切点（point cut）**：我们的切面不单单应用于单个方法，也可能是多个类的不同方法，这时，可以通过正则式和指示器的规则去定义，从而适配连接点。
3. **通知（advice）**：就是按照约定的流程下的方法，分为前置通知（before advice）、后置通知（after advice）、环绕通知（around advice）、事后返回通知（afterReturning advice）和异常通知（afterThrowing advice），它会根据约定织入流程中，需要弄明白他们在流程中的顺序和运行的条件。
4. **目标对象（target）**：即被代理对象。
5. **引入（introduction）**：是指引入新的类和方法，增强现有Bean的功能。
6. **织入（weaving）**：它是一个通过动态代理技术，为原有服务对象生成代理对象，然后将与切点定义匹配的连接点拦截，并按约定将各类通知织入约定流程的过程。
7. **切面（aspect）**：是一个可以定义切点、各类通知和引入的内容，SpringAOP将通过它的信息来增强Bean的功能或者将对应的方法织入流程。

![image-20201208165052330](C:\Users\chy\AppData\Roaming\Typora\typora-user-images\image-20201208165052330.png)

#### 开发详解

**定义切面切点**

```java
@Aspect
@EnableAspectJAutoProxy
public class MyAspect {

    @Pointcut("execution(* org.example.service.Impl.UserServiceImpl.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before() {
        System.out.println("before...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before...");
        jp.proceed();
        System.out.println("around after...");
    }
}
```

其中环绕通知around是最为强大的通知，但是也难以控制，使用提供的场景需要大幅度修改原有目标对象的服务逻辑时，否则尽量使用其他通知。

* `excution`表示在执行的时候，拦截里面的正则匹配方法
* `*`表示任意返回类型的方法
* `org.example.service.Impl.UserServiceImpl`指定目标对象的全类名
* `*`表示类里面的所有方法
* `(..)`表示任意参数进行匹配

**定义service**

```java
public interface UserService {
    public void printUser(User user);
}

public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("检查用户参数是否为空...");
        }
        System.out.println(user);
    }
}
```

**添加bean**

```java
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AppConfig {
    @Bean(name="user")
    public User initUser() {
        User user = new User();
        user.setId(1L);
        user.setName("chy");
        return user;
    }

    @Bean(name="userService")
    public UserService initUserService() {
        return new UserServiceImpl();
    }

    @Bean(name="myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }
}
```

**测试**

```java
public class test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        UserService userService = ctx.getBean(UserServiceImpl.class);
        userService.printUser(user);
        ctx.close();
    }
}
```

**测试结果**

```java
around before...
before...
User{id=1, name='chy'}
around after...
after...
afterReturning...
```

可以创建多个切面指向同一个切点，并可以使用@order来指定切面执行的先后顺序。





```c++
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main() {
    int n, l;
    cin>>n>>l;
    vector<int> a(n);
    for(int i=0; i<n; i++) {
        cin>>a[i];
    }
    sort(a.begin(), a.end());
    double distance = 0;
    for(int i=1; i<n; i++) {
        distance = max(distance, (a[i]-a[i-1])*1.0/2);
    }
    distance = max(distance, (l - a[0]) / 1.0);
	//distance = max(distance, a[n - 1] / 1.0);
    cout.setf(ios::fixed);
    cout.precision(2);
    cout<<distance<<endl;
} 
```


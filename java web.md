## 当你在地址栏输入一个URL地址回车后，将会发生什么事情

1. 首先在浏览器中输入要访问的网址，即url。在没有明确告知浏览器用那个协议的时候，默认使用http协议。

2. http协议是基于tcp协议的，需要知道这个url的ip地址才能发送请求。

   * 首先查看浏览器的DNS缓存中是否有这个url的ip地址。

   * 若浏览器缓存中未找到这个url对应的ip，则查找操作系统的DNS缓存，即hosts文件中的域名与ip的映射关系

   * 若在hosts文件中也没有找到，浏览器就会发起一个DNS的系统调用，就会向本地配置的首选DNS服务器（一般是电信运营商提供的，也可以使用像Google提供的DNS服务器）发起域名解析请求（通过的是UDP协议向DNS的53端口发起请求，这个请求是**递归的请求**，也就是运营商的DNS服务器必须得提供给我们该域名的IP地址），运营商的DNS服务器首先查找自身的缓存，找到对应的条目，且没有过期，则解析成功。如果没有找到对应的条目，则有运营商的DNS代我们的浏览器发起**迭代DNS解析请求**，它首先是会找根域的DNS的IP地址（这个DNS服务器都内置13台根域的DNS的IP地址），找打根域的DNS地址，就会向其发起请求（请问www.cnblogs.com这个域名的IP地址是多少啊？），根域发现这是一个顶级域com域的一个域名，于是就告诉运营商的DNS我不知道这个域名的IP地址，但是我知道com域的IP地址，你去找它去，于是运营商的DNS就得到了com域的IP地址，又向com域的IP地址发起了请求（请问www.cnblogs.com这个域名的IP地址是多少?）,com域这台服务器告诉运营商的DNS我不知道www.cnblogs.com这个域名的IP地址，但是我知道www.cnblogs.com这个域的DNS地址，你去找它去，于是运营商的DNS又向www.cnblogs.com这个域名的DNS地址（这个一般就是由域名注册商提供的，像万网，新网等）发起请求（请问www.cnblogs.com这个域名的IP地址是多少？），这个时候cnblogs.com域的DNS服务器一查，果真在我这里，于是就把找到的结果发送给运营商的DNS服务器，这个时候运营商的DNS服务器就拿到了www.cnblogs.com这个域名对应的IP地址，并返回给Windows系统内核，内核又把结果返回给浏览器，终于浏览器拿到了www.cnblogs.com对应的IP地址，该进行一步的动作了。

     ![image-20210304101600610](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210304101600610.png)

     ![image-20210304101610520](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210304101610520.png)

3. 拿到ip地址后建立tcp连接

   发送tcp三次握手。拿到域名对应的IP地址之后，User-Agent（一般是指浏览器）会以一个随机端口（1024 < 端口 < 65535）向服务器的WEB程序（常用的有tomcat,nginx等）80端口发起TCP的连接请求。这个连接请求（原始的http请求经过TCP/IP4层模型的层层封包）到达服务器端后（这中间通过各种路由设备，局域网内除外），进入到网卡，然后是进入到内核的TCP/IP协议栈（用于识别该连接请求，解封包，一层一层的剥开），还有可能要经过Netfilter防火墙（属于内核的模块）的过滤，最终到达WEB程序，最终建立了TCP/IP的连接。

4. 建立TCP连接后发起http请求

   HTTP请求报文的方法是get方式，如果浏览器存储了该域名下的Cookies，那么会把Cookies放入HTTP请求头里发给服务器。

5. 服务器端响应http请求，浏览器得到html代码

6. 浏览器解析html代码，并请求html代码中的资源

7. 浏览器对页面进行渲染呈现给用户



## Servlet

### Servlet生命周期

Servlet生命周期包括三部分：

* 初始化：Web容器加载servlet，调用init()方法

  在下列时刻Servlet容器装载Servlet：

  1. Servlet容器启动时自动装载某些Servlet，实现它只需要在web.XML文件中的<Servlet></Servlet>之间添加如下代码：

     `<loadon-startup>1</loadon-startup>`

  2. 在Servlet容器启动后，客户首次向Servlet发送请求

  3. Servlet类文件被更新后，重新装载Servlet

  Servlet被装载后，Servlet容器创建一个Servlet实例并且调用Servlet的init()方法进行初始化。在Servlet的整个生命周期内，init()方法只被调用一次。

* 处理请求：当请求到达时，运行其service()方法。service()自动派遣运行与请求相对应的doXXX（doGet或者doPost）方法。

  对于用户到达Servlet的请求，Servlet容器会创建特定于这个请求的ServletRequest对象和ServletResponse对象，然后调用Servlet的service方法。service方法从ServletRequest对象获得客户请求信息，处理该请求，并通过ServletResponse对象向客户返回响应信息。

  对于Tomcat来说，它会将传递过来的参数放在一个Hashtable中

* 销毁：服务结束，web容器会调用servlet的distroy()方法销毁servlet。

  当WEB应用被终止，或Servlet容器终止运行，或Servlet容器重新装载Servlet新实例时，Servlet容器会先调用Servlet的destroy()方法，在destroy()方法中可以释放掉Servlet所占用的资源。

Tomcat与Servlet的工作流程：

![image-20210304104715106](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210304104715106.png)

步骤：

1. Web Client 向Servlet容器（Tomcat）发出Http请求
2. Servlet容器接收Web Client的请求
3. Servlet容器创建一个HttpRequest对象，将Web Client请求的信息封装到这个对象中。
4. Servlet容器创建一个HttpResponse对象
5. Servlet容器调用HttpServlet对象的service方法，把HttpRequest对象与HttpResponse对象作为参数传给 HttpServlet 对象。
6. HttpServlet调用HttpRequest对象的有关方法，获取Http请求信息。
7. HttpServlet调用HttpResponse对象的有关方法，生成响应数据。
8. Servlet容器把HttpServlet的响应结果传给Web Client。

### Servlet工作原理

1. 首先简单解释一下Servlet接收和响应客户请求的过程，首先客户发送一个请求，Servlet是调用service()方法对请求进行响应的，通过源代码可见，service()方法中对请求的方式进行了匹配，选择调用doGet,doPost等这些方法，然后再进入对应的方法中调用逻辑层的方法，实现对客户的响应。在Servlet接口和GenericServlet中是没有doGet,doPost等等这些方法的，HttpServlet中定义了这些方法，但是都是返回error信息，所以，我们每次定义一个Servlet的时候，都必须实现doGet或doPost等这些方法。

```java
package javax.servlet;

import java.io.IOException;

public interface Servlet {
    void init(ServletConfig var1) throws ServletException;

    ServletConfig getServletConfig();

    void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;

    String getServletInfo();

    void destroy();
}
```

```java
public abstract class HttpServlet extends GenericServlet {
    ...
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        if (req instanceof HttpServletRequest && res instanceof HttpServletResponse) {
            HttpServletRequest request = (HttpServletRequest)req;
            HttpServletResponse response = (HttpServletResponse)res;
            this.service(request, response);
        } else {
            throw new ServletException("non-HTTP request or response");
        }
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        long lastModified;
        if (method.equals("GET")) {
            lastModified = this.getLastModified(req);
            if (lastModified == -1L) {
                this.doGet(req, resp);
            } else {
                long ifModifiedSince = req.getDateHeader("If-Modified-Since");
                if (ifModifiedSince < lastModified) {
                    this.maybeSetLastModified(resp, lastModified);
                    this.doGet(req, resp);
                } else {
                    resp.setStatus(304);
                }
            }
        } else if (method.equals("HEAD")) {
            lastModified = this.getLastModified(req);
            this.maybeSetLastModified(resp, lastModified);
            this.doHead(req, resp);
        } else if (method.equals("POST")) {
            this.doPost(req, resp);
        } else if (method.equals("PUT")) {
            this.doPut(req, resp);
        } else if (method.equals("DELETE")) {
            this.doDelete(req, resp);
        } else if (method.equals("OPTIONS")) {
            this.doOptions(req, resp);
        } else if (method.equals("TRACE")) {
            this.doTrace(req, resp);
        } else {
            String errMsg = lStrings.getString("http.method_not_implemented");
            Object[] errArgs = new Object[]{method};
            errMsg = MessageFormat.format(errMsg, errArgs);
            resp.sendError(501, errMsg);
        }

    }
    ...
}
```

2. 每一个自定义的Servlet都必须实现Servlet的接口，Servlet接口中定义了五个方法，其中比较重要的三个方法涉及到Servlet的生命周期，分别是上文提到的init(),service(),destroy()方法。GenericServlet是一个通用的，不特定于任何协议的Servlet,它实现了Servlet接口。而HttpServlet继承于GenericServlet，因此HttpServlet也实现了Servlet接口。所以我们定义Servlet的时候只需要继承HttpServlet即可。
3. Servlet接口和GenericServlet是不特定于任何协议的，而HttpServlet是特定于HTTP协议的类，所以HttpServlet中实现了service()方法，并将请求ServletRequest,ServletResponse强转为HttpRequest和HttpResponse。

### get提交和post提交有何区别

* 请求的时候参数的位置有区别，get的参数是拼接在url后面，用户在浏览器地址栏可以看到。post是放在http包的包体中。

* 能提交的数据有区别，get方式能提交的数据只能是文本，且大小不超过1024个字节，而post不仅可以提交文本还有二进制文件。

  所以说想上传文件的话，那我们就需要使用post请求方式

### JSP与Servlet有什么区别

JSP就是Servlet，每次运行的时候JSP都首先被编译成servlet文件，然后再被编译成.class文件运行。jsp文件中可以嵌套java语句。

### doGet与doPost方法的两个参数是什么

HttpServletRequest：封装了与请求相关的信息

HttpServletResponse：封装了与响应相关的信息

### JSP有哪些内置对象，作用是什么？

![image-20210304104410328](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210304104410328.png)

### 四种会话跟踪技术作用域

（1）page：一个页面

（2）request：：一次请求

（3）session：一次会话

（4）application：服务器从启动到停止。

### forward和redirect的区别

转发与重定向

（1）从地址栏显示来说 

forward是服务器请求资源,服务器直接访问目标地址的URL,把那个URL的响应内容读取过来,然后把这些内容再发给浏览器.浏览器根本不知道服务器发送

的内容从哪里来的,所以它的地址栏还是原来的地址.redirect是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是

新的URL.

（2）从数据共享来说 

forward:转发页面和转发到的页面可以共享request里面的数据.

redirect:不能共享数据.

（3）从运用地方来说 

forward:一般用于用户登陆的时候,根据角色转发到相应的模块.

redirect:一般用于用户注销登陆时返回主页面和跳转到其它的网站等.

（4）从效率来说 

forward:高.

redirect:低.


## Spring

Spring是一种轻量级框架。

我们一般说的Spring框架就是Spring Framework，它是很多模块的集合，使用这些模块可以很方便地协助我们进行开发。这些模块是核心容器、数据访问/集成、Web、AOP（面向切面编程）、工具、消息和测试模块。比如Core Container中的Core组件是Spring所有组件的核心，Beans组件和Context组件是实现IOC和DI的基础，AOP组件用来实现面向切面编程。

### IOC

IOC（Inversion Of Controll，控制反转）是一种设计思想，就是将原本在程序中手动创建对象的控制权，交由给Spring框架来管理。IOC在其他语言中也有应用，并非Spring特有。

将对象之间的相互依赖关系交给IOC容器来管理，并由IOC容器完成对象的注入。这样可以很大程度上简化应用的开发，把应用从复杂的依赖关系中解放出来。IOC容器就像是一个工厂一样，当我们需要创建一个对象的时候，只需要配置好配置文件/注解即可，完全不用考虑对象是如何被创建出来的。

### AOP

AOP（Aspect-Oriented Programming，面向切面编程）能够将那些与业务无关，却为业务模块所共同调用的逻辑或责任（例如事务处理、日志管理、权限控制等）封装起来，便于减少系统的重复代码，降低模块间的耦合度，并有利于未来的可扩展性和可维护性。

Spring AOP是基于动态代理的，如果要代理的对象实现了某个接口，那么Spring AOP就会使用JDK动态代理去创建代理对象；而对于没有实现接口的对象，就无法使用JDK动态代理，转而使用CGlib动态代理生成一个被代理对象的子类来作为代理。

#### Spring AOP和AspectJ

![image-20210304165704849](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210304165704849.png)

Spring AOP的通知是基于该对象是SpringBean对象才可以，而AspectJ可以在任何Java对象上应用通知。

**Spring AOP**

1、基于动态代理来实现，默认如果使用接口的，用JDK提供的动态代理实现，如果是方法则使用CGLIB实现

2、Spring AOP需要依赖IOC容器来管理，并且只能作用于Spring容器，使用纯Java代码实现

3、在性能上，由于Spring AOP是基于动态代理来实现的，在容器启动时需要生成代理实例，在方法调用上也会增加栈的深度，使得Spring AOP的性能不如AspectJ的那么好

**AspectJ**

- AspectJ来自于Eclipse基金会
- AspectJ属于静态织入，通过修改代码来实现，有如下几个织入的时机：

 1、编译期织入（Compile-time weaving）： 如类 A 使用 AspectJ 添加了一个属性，类 B 引用了它，这个场景就需要编译期的时候就进行织入，否则没法编译类 B。

 2、编译后织入（Post-compile weaving）： 也就是已经生成了 .class 文件，或已经打成 jar 包了，这种情况我们需要增强处理的话，就要用到编译后织入。

3、类加载后织入（Load-time weaving）： 指的是在加载类的时候进行织入，要实现这个时期的织入，有几种常见的方法。1、自定义类加载器来干这个，这个应该是最容易想到的办法，在被织入类加载到 JVM 前去对它进行加载，这样就可以在加载的时候定义行为了。2、在 JVM 启动的时候指定 AspectJ 提供的 agent：`-javaagent:xxx/xxx/aspectjweaver.jar`。

- AspectJ可以做Spring AOP干不了的事情，它是AOP编程的完全解决方案，Spring AOP则致力于解决企业级开发中最普遍的AOP（方法织入）。而不是成为像AspectJ一样的AOP方案
- 因为AspectJ在实际运行之前就完成了织入，所以说它生成的类是没有额外运行时开销的

### 事务

#### Spring事务的配置方式

1. 编程式事务管理

   编程式事务管理是侵入性事务管理

2. 声明式事务管理

   声明式事务管理建立在AOP之上，其本质是对方法前后进行拦截，然后在目标方法开始之前创建或者加入一个事务，执行完目标方法之后根据执行的情况提交或者回滚。

编程式事务每次实现都要单独实现，但业务量大功能复杂时，使用编程式事务无疑是痛苦的，而声明式事务不同，声明式事务属于无侵入式，不会影响业务逻辑的实现，只需要在配置文件中做相关的事务规则声明或者通过注解的方式，便可以将事务规则应用到业务逻辑中。
显然声明式事务管理要优于编程式事务管理，这正是Spring倡导的非侵入式的编程方式。唯一不足的地方就是声明式事务管理的粒度是方法级别，而编程式事务管理是可以到代码块的，但是可以通过提取方法的方式完成声明式事务管理的配置。

#### 事务的传播机制

- PROPAGATION_REQUIRED
  Spring默认的传播机制，能满足绝大部分业务需求，如果外层有事务，则当前事务加入到外层事务，一块提交，一块回滚。如果外层没有事务，新建一个事务执行
- PROPAGATION_REQUES_NEW
  该事务传播机制是每次都会新开启一个事务，同时把外层事务挂起，当当前事务执行完毕，恢复上层事务的执行。如果外层没有事务，执行当前新开启的事务即可
- PROPAGATION_SUPPORT
  如果外层有事务，则加入外层事务，如果外层没有事务，则直接使用非事务方式执行。完全依赖外层的事务
- PROPAGATION_NOT_SUPPORT
  该传播机制不支持事务，如果外层存在事务则挂起，执行完当前代码，则恢复外层事务，无论是否异常都不会回滚当前的代码
- PROPAGATION_NEVER
  该传播机制不支持外层事务，即如果外层有事务就抛出异常
- PROPAGATION_MANDATORY
  与NEVER相反，如果外层没有事务，则抛出异常
- PROPAGATION_NESTED
  该传播机制的特点是可以保存状态保存点，当前事务回滚到某一个点，从而避免所有的嵌套事务都回滚，即各自回滚各自的，如果子事务没有把异常吃掉，基本还是会引起全部回滚的。

#### 事务的隔离级别

![image-20210305100933044](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210305100933044.png)

### bean

#### bean的作用域

1.singleton：唯一bean实例，Spring中的bean默认都是单例的。

2.prototype：每次请求都会创建一个新的bean实例。

3.request：每一次HTTP请求都会产生一个新的bean，该bean仅在当前HTTP request内有效。

4.session：每一次HTTP请求都会产生一个新的bean，该bean仅在当前HTTP session内有效。

5.global session

#### Spring为社么默认bean为单例

> 单例bean与原型bean的区别

单例：一个bean被声明为单例时，处理多次请求时spring容器里只实例化一个bean，后续的请求公用这个对象，这个对象存储在一个map中，当有请求时，先在缓存中（map）查找是否存在，存在则使用，不存在才实例化一个对象

原型：每当有请求来就实例化一个新的bean，没有缓存以及从缓存中查

**单例bean的优势：**

- 为了提高性能
- 少创建实例*
- 垃圾回收
- 缓存快速获取

**单例bean的劣势：**

在并发环境下线程不安全

#### bean的线程安全问题

大部分时候我们并没有在系统中使用多线程，所以很少有人会关注这个问题。单例bean存在线程问题，主要是因为当多个线程操作同一个对象的时候，对这个对象的非静态成员变量的写操作会存在线程安全问题。

有两种常见的解决方案：

1.在bean对象中尽量避免定义可变的成员变量（不太现实）。

2.在类中定义一个ThreadLocal成员变量，将需要的可变成员变量保存在ThreadLocal中（推荐的一种方式）。

**ThreadLocal**

1）ThreadLocal是干什么的

多线程访问**同一个共享变量**的时候容易出现并发问题，特别是多个线程对一个变量进行写入的时候，为了保证线程安全，一般在访问共享变量的时候需要进行额外的同步措施才能保证线程安全性。**`ThreadLocal`是除了加锁这种同步方式之外的另一种保证多线程访问变量时的线程安全的方法**；如果每个线程对变量的访问都是基于**线程自己的变量**这样就不会存在线程不安全问题。

在Java的多线程编程中，为保证多个线程对共享变量的安全访问，通常会使用`synchronized`来保证同一时刻只有一个线程对共享变量进行操作。这种情况下其实还可以将变量放到`ThreadLocal`类型的对象中，使变量在每个线程中都有**独立拷贝**，**在一个线程中对变量的任何操作都不会影响到其它线程的变量**。在很多情况下，`ThreadLocal`比直接使用`synchronized`同步机制解决线程安全问题更简单，更方便，同时还能保证程序的性能。

2）ThreadLocal的实现原理

Java中的`ThreadLocal`是用哈希表实现的，每个线程里都有一个`ThreadLocalMap`属性，里面就以`Map`的形式存储了多个`ThreadLocal`对象。**当在线程中调用`ThreadLocal`操作方法时，都会通过当前`Thread`线程对象拿到线程里的`ThreadLocalMap`，再通过`ThreadLocal`对象从`ThreadLocalMap`中锁定数据实体（`ThreadLocalMap.Entry`）**。

3）ThreadLocal中的基本方法

3.1）ThreadLocal构造方法

3.2）设值方法set

要保存的数据通过`set`方法设置，多次调用`set`方法并不会保存多个数据，而是发生覆盖，一个`ThreadLocal`正常只能保存一个数据：

3.3）取值方法get

3.4）资源回收remove

当我们不再需要保存的数据时，应该通过`remove`方法将当前线程中保存的值移除掉使对象得到`GC`（调用`remove`方法将把`ThreadLocal`对象从当前线程的`ThreadLocalMap`移除）：

3.5）静态的设置初始值的方法`withInitial`

4）总结

其实`ThreadLocal`并没有那么的神秘莫测，但它在多线程编程中的地位却是毋庸置疑的，用好了`ThreadLocal`能够帮助你写出优雅简洁的多线程代码。在使用`synchronized`同步代码的时候，如果没法保证同步代码的（细）粒度，则会使得程序的性能下降，而使用`ThreadLocal`时完全不用考虑性能问题，因为没有了多线程的竞争，也就不用额外的同步判断等开销。总而言之，当**遇到多线程操作同一个共享变量需要保证线程安全**的时候，你应该首先考虑使用`ThreadLocal`而不是`synchronized`！

#### Spring中的bean生命周期

1.Bean容器找到配置文件中Spring Bean的定义。

2.Bean容器利用Java Reflection API创建一个Bean的实例。

3.如果涉及到一些属性值，利用set()方法设置一些属性值。

4.如果Bean实现了BeanNameAware接口，调用setBeanName()方法，传入Bean的名字。

5.如果Bean实现了BeanClassLoaderAware接口，调用setBeanClassLoader()方法，传入ClassLoader对象的实例。

6.如果Bean实现了BeanFactoryAware接口，调用setBeanClassFacotory()方法，传入ClassLoader对象的实例。

7.与上面的类似，如果实现了其他*Aware接口，就调用相应的方法。

8.如果有和加载这个Bean的Spring容器相关的BeanPostProcessor对象，执行postProcessBeforeInitialization()方法。

9.如果Bean实现了InitializingBean接口，执行afeterPropertiesSet()方法。

10.如果Bean在配置文件中的定义包含init-method属性，执行指定的方法。

11.如果有和加载这个Bean的Spring容器相关的BeanPostProcess对象，执行postProcessAfterInitialization()方法。

12.当要销毁Bean的时候，如果Bean实现了DisposableBean接口，执行destroy()方法。

13.当要销毁Bean的时候，如果Bean在配置文件中的定义包含destroy-method属性，执行指定的方法。

![image-20210305103951665](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210305103951665.png)

#### 循环依赖

> 什么是循环依赖？

循环依赖其实就是循环引用，也就是两个或则两个以上的bean互相持有对方，最终形成闭环。比如A依赖于B，B依赖于C，C又依赖于A。如下图：

![image-20210305112124136](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210305112124136.png)

Spring中的循环依赖有两种：

- 构造器循环依赖
- field属性注入循环依赖（分为单例和原型）

通过**构造函数的注入**方式其实表达了2个对象间的一种**强的聚合关系：组合关系**。就比如一辆车如果没有轮子、引擎等部件那么车也就不存在了。而且车是由若干重 要部件组成的，在这些部件没有的情况下车也不可能存在。这里车和他的重要部件就时组合的关系。如果你的应用中有这样类似的场景那么你应该使用“构造函数注 入”的方式管理他们的关系。“构造函数注入”可以保证合作者先创建，在后在创建自己。
通过**set方法注入**的方式表达了2个对象间较**弱的**依赖关系：聚合关系。就像一辆车，如果没有车内音像车也时可以工作的。当你不要求合作者于自己被创建时，“set方法注入”注入比较合适。

虽然在理论上“构造函数注入”和“set方法注入”代表2种不同的依赖强度，但是在spring中，spring并不会把无效的合作者传递给一个 bean。如果合作者无效或不存在spring会抛出异常，这样spring保证一个对象的合作者都是可用的。所以在spring中，“构造函数注入”和 “set方法注入”唯一的区别在于2种方式创建合作者的顺序不同。
　　使用构造函数依赖注入时，Spring保证所有一个对象所有依赖的对象先实例化后，才实例化这个对象。（没有他们就没有我原则）
　　使用set方法依赖注入时，Spring首先实例化对象，然后才实例化所有依赖的对象。

spring中循环依赖有三种情况：

1. **构造器注入形成的循环依赖。**也就是beanB需要在beanA的构造函数中完成初始化，beanA也需要在beanB的构造函数中完成舒适化，这种情况的结果就是两个bean都不能完成初始化，循环依赖难以解决。
2. **setter注入构成的循环依赖。**beanA需要在beanB的setter方法中完成初始化，beanB也需要在beanA的setter方法中完成初始化，spring设计的机制主要就是解决这种循环依赖
3. **prototype作用域bean的循环依赖。**这种循环依赖同样无法解决，因为spring不会缓存‘prototype’作用域的bean，而spring中循环依赖的解决正是通过缓存来实现的。

Spring的单例对象的初始化主要分为三步：

![image-20210305143807056](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210305143807056.png)

（1）createBeanInstance：实例化，其实也就是调用对象的构造方法实例化对象

（2）populateBean：填充属性，这一步主要是多bean的依赖属性进行填充

（3）initializeBean：调用spring xml中的init 方法。

从上面讲述的单例bean初始化步骤我们可以知道，循环依赖主要发生在第一、第二部。也就是构造器循环依赖和field循环依赖。

那么我们要解决循环引用也应该从初始化过程着手，对于单例来说，在Spring容器整个生命周期内，有且只有一个对象，所以很容易想到这个对象应该存在Cache中，Spring为了解决单例的循环依赖问题，使用了**三级缓存**。

三级缓存主要指：

```java
/** Cache of singleton objects: bean name to bean instance. */
private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

/** Cache of singleton factories: bean name to ObjectFactory. */
private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

/** Cache of early singleton objects: bean name to bean instance. */
private final Map<String, Object> earlySingletonObjects = new HashMap<>(16);
```

这三级缓存分别指：
singletonFactories ： 单例对象工厂的cache
earlySingletonObjects ：提前暴光的单例对象的Cache
singletonObjects：单例对象的cache

一级缓存（单例池）：singletionObjects     ConcurrentHashMap<beanName,bean对象>
二级缓存（早期单例对象）：earlySingletionObjects     HashMap<beanName,不完整bean对象>(主要用于解决循环依赖问题)
三级缓存（单例的工厂）：singletonFactories  HashMap<beanName,ObjectFactory(lambda表达式)> （当出现了循环依赖，并且需要进行aop时才使用，相当于做一个准备工作）

一级缓存里存的是成品对象，实例化和初始化都完成了，我们的应用中使用的对象就是一级缓存中的

二级缓存中存的是半成品，用来解决对象创建过程中的循环依赖问题

三级缓存中存的是 ObjectFactory<?> 类型的 lambda 表达式，用于处理存在 AOP 时的循环依赖问题

`singletonObject`：一级缓存，该缓存`key = beanName, value = bean;`这里的bean是已经创建完成的，该bean经历过**实例化->属性填充->初始化**以及各类的后置处理。因此，一旦需要获取bean时，我们第一时间就会寻找一级缓存

`earlySingletonObjects`：二级缓存，该缓存`key = beanName, value = bean;`这里跟一级缓存的区别在于，该缓存所获取到的bean是提前曝光出来的，是还没创建完成的。也就是说获取到的bean只能确保已经进行了实例化，但是属性填充跟初始化肯定还没有做完，因此该bean还没创建完成，仅仅能作为指针提前曝光，被其他bean所引用

`singletonFactories`：三级缓存，该缓存`key = beanName, value = beanFactory;`在bean实例化完之后，属性填充以及初始化之前，如果允许提前曝光，spring会将实例化后的bean提前曝光，也就是把该bean转换成`beanFactory`并加入到三级缓存。在需要引用提前曝光对象时再通过`singletonFactory.getObject()`获取。

**顺便提一下为什么一级缓存用ConcurrentHashMap，而二三级缓存却使用HashMap？**

因为一级缓存保存的是单例bean，必须要保证线程安全的。

而二三级缓存是一对的，所有用到它们的地方已经加了synchronized锁保证了线程安全，所以为了保证性能可以直接使用HashMap。

我们在创建bean的时候，首先想到的是从cache中获取这个单例的bean，这个缓存就是singletonObjects。主要调用方法就就是：

```java
protected Object getSingleton(String beanName, boolean allowEarlyReference) {
    Object singletonObject = this.singletonObjects.get(beanName);
    if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
        synchronized (this.singletonObjects) {
            singletonObject = this.earlySingletonObjects.get(beanName);
            if (singletonObject == null && allowEarlyReference) {
                ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
                if (singletonFactory != null) {
                    singletonObject = singletonFactory.getObject();
                    this.earlySingletonObjects.put(beanName, singletonObject);
                    this.singletonFactories.remove(beanName);
                }
            }
        }
    }
    return singletonObject;
}
```

上面的代码需要解释两个参数：

- isSingletonCurrentlyInCreation()判断当前单例bean是否正在创建中，也就是没有初始化完成(比如A的构造器依赖了B对象所以得先去创建B对象， 或则在A的populateBean过程中依赖了B对象，得先去创建B对象，这时的A就是处于创建中的状态。)
- allowEarlyReference 是否允许从singletonFactories中通过getObject拿到对象

分析getSingleton()的整个过程，Spring首先从一级缓存singletonObjects中获取。如果获取不到，并且对象正在创建中，就再从二级缓存earlySingletonObjects中获取。如果还是获取不到且允许singletonFactories通过getObject()获取，就从三级缓存singletonFactory.getObject()(三级缓存)获取，如果获取到了则从singletonFactories中移除，并放入earlySingletonObjects中。其实也就是从三级缓存移动到了二级缓存。

这里就是解决循环依赖的关键，这段代码发生在createBeanInstance之后，也就是说单例对象此时已经被创建出来(调用了构造器)。这个对象已经被生产出来了，虽然还不完美（还没有进行初始化的第二步和第三步），但是已经能被人认出来了（根据对象引用能定位到堆中的对象），所以Spring此时将这个对象提前曝光出来让大家认识，让大家使用。

**如何解决？**

增加一个中间人（缓存）。这里就是二级缓存。

此时aService的生命周期就变成了如下：

     1、实例化得到aService对象 --> 放入二级缓存Map<aService,aService不完整对象>。
    
     2、填充bService属性 --> 从单例池(一级缓存)查询 --> 找不到则去二级缓存查询 --> 找不到则实例化bService
    
               下面开始bService的生命周期：
    
                 2.1、实例化bService对象 --> 放入二级缓存Map<bService,bService不完整对象>。
    
                 2.2、填充aService对象 --> 从单例池(一级缓存)查询 --> 找不到去二级缓存查询 --> 找到了 。
    
                 2.3、进行其他操作
    
                 2.4、把bService对象放入单例池
    
     3、进行其他操作
    
     4、把aService对象放入单例池

此时循环依赖问题就已经解决。
**为什么spring还需要三级缓存，不要不行吗？**

当bean出现循环依赖并且需要进行aop的时候，二级缓存就不行了。

但是经过Spring AOP代理后的bean就已经不再是原来的bean了，经过代理后的bean是一个全新的bean，也就是说代理前后的2个bean连内存地址都不一样了。这时将再引出新的问题：**B提前引用A将引用到A的代理，这是符合常理的，但是最原始的bean A在B完成创建后将继续创建，那么Spring Ioc最后返回的Bean是Bean A呢还是经过代理后的Bean呢？**



为了处理 AOP 时的循环依赖，Spring 引入第三级缓存来处理循环依赖时的代理对象的创建

例如：aService正常进行aop操作的生命周期：

实例化得到bean对象。
填充属性。
进行其他操作（包括aop）
放入单例池（一级缓存）
可以看到正常的aop操作是在第三步进行。但是bService需要aService属性，所以出现了循环依赖，就需要提前进行aop，放到第二步进行。

### **如何判断bean出现了循环依赖问题？**

无论单例还是原型模式(下文①代表图中步骤1)，spring都有对应的集合保存当前正在创建的beanName，标识该beanName正在被创建。在bean创建前，①检测当前bean是否在创建中，如果不在创建中则②将beanName加入集合，往下创建bean。在bean创建前，检测到当前的bean正在创建，则说明发生循环依赖，抛出异常。最后记得当bean创建完时将beanName移出集合。

### **spring是如何防止在多线程环境下读取到不完整的bean？**

**加了两把锁。**

**1、一把锁加在了整个bean的创建过程。**

**2、另一把加在了从缓存中取数据**

因为一开始getBean时要先查缓存，如果没有才创建bean

![img](https://upload-images.jianshu.io/upload_images/8190955-982ed2cabfa2ee76?imageMogr2/auto-orient/strip|imageView2/2/format/webp)



## Spring MVC

Spring MVC是一个基于Java的实现了MVC设计模式的请求驱动类型的轻量级Web框架，通过把Model，View，Controller分离，将web层进行职责解耦，把复杂的web应用分成逻辑清晰的几部分，简化开发，减少出错，方便组内开发人员之间的配合。

### **SpringMVC的流程**

（1）用户发送请求至前端控制器DispatcherServlet；
（2）DispatcherServlet收到请求后，调用HandlerMapping处理器映射器，请求获取Handler；
（3）处理器映射器根据请求url找到具体的处理器Handler，生成处理器对象及处理器拦截器(如果有则生成)，一并返回给DispatcherServlet；
（4）DispatcherServlet 调用 HandlerAdapter处理器适配器，请求执行Handler；
（5）HandlerAdapter 经过适配调用 具体处理器进行处理业务逻辑；
（6）Handler执行完成返回ModelAndView；
（7）HandlerAdapter将Handler执行结果ModelAndView返回给DispatcherServlet；
（8）DispatcherServlet将ModelAndView传给ViewResolver视图解析器进行解析；
（9）ViewResolver解析后返回具体View；
（10）DispatcherServlet对View进行渲染视图（即将模型数据填充至视图中）
（11）DispatcherServlet响应用户。

![image-20210305145340203](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210305145340203.png)

前端控制器 DispatcherServlet：接收请求、响应结果，相当于转发器，有了DispatcherServlet 就减少了其它组件之间的耦合度。
处理器映射器 HandlerMapping：根据请求的URL来查找Handler
处理器适配器 HandlerAdapter：负责执行Handler
处理器 Handler：处理器，需要程序员开发
视图解析器 ViewResolver：进行视图的解析，根据视图逻辑名将ModelAndView解析成真正的视图（view）
视图View：View是一个接口， 它的实现类支持不同的视图类型，如jsp，freemarker，pdf等等

### **Springmvc的优点**

（1）可以支持各种视图技术，而不仅仅局限于JSP；

（2）与Spring框架集成（如IoC容器、AOP等）；

（3）清晰的角色分配：前端控制器(dispatcherServlet) ，请求到处理器映射（handlerMapping)，处理器适配器（HandlerAdapter)，视图解析器（ViewResolver）。

（4） 支持各种请求资源的映射策略。

### **SpringMVC怎么样设定重定向和转发的**

（1）转发：在返回值前面加"forward:"，譬如"forward:user.do?name=method4"

（2）重定向：在返回值前面加"redirect:"，譬如"redirect:http://www.baidu.com"

### **SpringMvc的控制器是不是单例模式？如果是，有什么问题？怎么解决**

是单例模式，在多线程访问的时候有线程安全问题，解决方案是在控制器里面不能写可变状态量，如果需要使用这些可变状态，可以使用ThreadLocal机制解决，为每个线程单独生成一份变量副本，独立操作，互不影响。

## session和cookie

* session在服务器端，cookie在客户端（浏览器）
* session的运行依赖session id，而session id是存在cookie中的，也就是说，如果浏览器禁用了cookie，同时session也会失效（但是可以通过其他方式实现，比如在url中传递session id）
* session可以放在文件、数据库、或内存中
* 用户验证一般用session
* cookie不是很安全，别人可以分析存放在本地的cookie并进行cookie欺骗
* session会在一定时间内保存在服务器上，当访问增多，会比较占用服务器的性能。
* 单个cookie保存的数据不能超过4k，很多浏览器都限制一个站点最多保存20个cookie
## JAVA基础

### java基础常识

#### java8新特性

- **Lambda 表达式** − Lambda 允许把函数作为一个方法的参数（函数作为参数传递到方法中）。
- **方法引用** − 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
- **默认方法** − 默认方法就是一个在接口里面有了一个实现的方法。
- **新工具** − 新的编译工具，如：Nashorn引擎 jjs、 类依赖分析器jdeps。
- **Stream API** −新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。
- **Date Time API** − 加强对日期与时间的处理。
- **Optional 类** − Optional 类已经成为 Java 8 类库的一部分，用来解决空指针异常。
- **Nashorn, JavaScript 引擎** − Java 8提供了一个新的Nashorn javascript引擎，它允许我们在JVM上运行特定的javascript应用。

**Java 语言有哪些特点?**

1. 简单易学；
2. 面向对象（封装，继承，多态）；
3. 平台无关性（ Java 虚拟机实现平台无关性）；
4. 可靠性；
5. 安全性；
6. 支持多线程（ C++ 语言没有内置的多线程机制，因此必须调用操作系统的多线程功能来进行多线程程序设计，而 Java 语言却提供了多线程支持）；
7. 支持网络编程并且很方便（ Java 语言诞生本身就是为简化网络编程设计的，因此 Java 语言不仅支持网络编程而且很方便）；
8. 编译与解释并存；

**JVM**

Java 虚拟机（JVM）是运行 Java 字节码的虚拟机。JVM 有针对不同系统的特定实现（Windows，Linux，macOS），目的是使用相同的字节码，它们都会给出相同的结果。

**什么是字节码?采用字节码的好处是什么?**

> 在 Java 中，JVM 可以理解的代码就叫做`字节码`（即扩展名为 `.class` 的文件），它不面向任何特定的处理器，只面向虚拟机。Java 语言通过字节码的方式，在一定程度上解决了传统解释型语言执行效率低的问题，同时又保留了解释型语言可移植的特点。所以 Java 程序运行时比较高效，而且，由于字节码并不针对一种特定的机器，因此，Java 程序无须重新编译便可在多种不同操作系统的计算机上运行。

**Java 程序从源代码到运行一般有下面 3 步：**

![Java程序运行过程](https://camo.githubusercontent.com/4ec0854d8185eef38ea925515f65eadffad6508cf6dc58c6fafd72ea6ae8670e/68747470733a2f2f6d792d626c6f672d746f2d7573652e6f73732d636e2d6265696a696e672e616c6979756e63732e636f6d2f4a6176612532302545372541382538422545352542412538462545382542462539302545382541312538432545382542462538372545372541382538422e706e67)

**JDK和JRE**

JDK 是 Java Development Kit 缩写，它是功能齐全的 Java SDK。它拥有 JRE 所拥有的一切，还有编译器（javac）和工具（如 javadoc 和 jdb）。它能够创建和编译程序。

JRE 是 Java 运行时环境。它是运行已编译 Java 程序所需的所有内容的集合，包括 Java 虚拟机（JVM），Java 类库，java 命令和其他的一些基础构件。但是，它不能用于创建新程序。

如果你只是为了运行一下 Java 程序的话，那么你只需要安装 JRE 就可以了。如果你需要进行一些 Java 编程方面的工作，那么你就需要安装 JDK 了。但是，这不是绝对的。有时，即使您不打算在计算机上进行任何 Java 开发，仍然需要安装 JDK。例如，如果要使用 JSP 部署 Web 应用程序，那么从技术上讲，您只是在应用程序服务器中运行 Java 程序。那你为什么需要 JDK 呢？因为应用程序服务器会将 JSP 转换为 Java servlet，并且需要使用 JDK 来编译 servlet。

**Java 和 C++的区别?**

- 都是面向对象的语言，都支持封装、继承和多态
- Java 不提供指针来直接访问内存，程序内存更加安全
- Java 的类是单继承的，C++ 支持多重继承；虽然 Java 的类不可以多继承，但是接口可以多继承。
- Java 有自动内存管理垃圾回收机制(GC)，不需要程序员手动释放无用内存
- **在 C 语言中，字符串或字符数组最后都会有一个额外的字符`'\0'`来表示结束。但是，Java 语言中没有结束符这一概念。**

**为什么说 Java 语言“编译与解释并存”？**

高级编程语言按照程序的执行方式分为编译型和解释型两种。简单来说，编译型语言是指编译器针对特定的操作系统将源代码一次性翻译成可被该平台执行的机器码；解释型语言是指解释器对源程序逐行解释成特定平台的机器码并立即执行。

Java 语言既具有编译型语言的特征，也具有解释型语言的特征，因为 Java 程序要经过先编译，后解释两个步骤，由 Java 编写的程序需要先经过编译步骤，生成字节码（*.class 文件），这种字节码必须由 Java 解释器来解释执行。因此，我们可以认为 Java 语言编译与解释并存。

 **Java 常见的关键字**

![image-20210312164647141](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210312164647141.png)

### 泛型

Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。

#### 类型擦除

**Java 的泛型是伪泛型，这是因为 Java 在编译期间，所有的泛型信息都会被擦掉，这也就是通常所说类型擦除 。Java的泛型基本上都是在编译器这个层次上实现的，在生成的字节码中是不包含泛型中的类型信息的，使用泛型的时候加上类型参数，在编译器编译的时候会去掉，这个过程成为类型擦除。**类型擦除后保留的原始类型。

#### 类型擦除引起的问题及解决方法

* **先检查，再编译以及编译的对象和引用传递问题**

* **自动类型转换**

* **泛型类型变量不能是基本数据类型**

  不能用类型参数替换基本类型。就比如，没有`ArrayList<double>`，只有`ArrayList<Double>`。因为当类型擦除后，`ArrayList`的原始类型变为`Object`，但是`Object`类型不能存储`double`值，只能引用`Double`的值。

泛型一般有三种使用方式:泛型类、泛型接口、泛型方法。

**1.泛型类**：

```
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T>{

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }
}
```

如何实例化泛型类：

```
Generic<Integer> genericInteger = new Generic<Integer>(123456);
```

**2.泛型接口** ：

```
public interface Generator<T> {
    public T method();
}
```

实现泛型接口，不指定类型：

```
class GeneratorImpl<T> implements Generator<T>{
    @Override
    public T method() {
        return null;
    }
}
```

实现泛型接口，指定类型：

```
class GeneratorImpl<T> implements Generator<String>{
    @Override
    public String method() {
        return "hello";
    }
}
```

**3.泛型方法** ：

```
public static < E > void printArray( E[] inputArray ) {
    for ( E element : inputArray ){
    	System.out.printf( "%s ", element );
    }
    System.out.println();
}
```

使用：

```
// 创建不同类型数组： Integer, Double 和 Character
Integer[] intArray = { 1, 2, 3 };
String[] stringArray = { "Hello", "World" };
printArray( intArray  );
printArray( stringArray  );
```

**常用的通配符为： T，E，K，V，？**

- ？ 表示不确定的 java 类型
- T (type) 表示具体的一个 java 类型
- K V (key value) 分别代表 java 键值中的 Key Value
- E (element) 代表 Element

### ==和 equals 的区别

**`==`** : 它的作用是判断两个对象的地址是不是相等。即判断两个对象是不是同一个对象。(**基本数据类型==比较的是值，引用数据类型==比较的是内存地址**)

> 因为 Java 只有值传递，所以，对于 == 来说，不管是比较基本数据类型，还是引用数据类型的变量，其本质比较的都是值，只是引用类型变量存的值是对象的地址。

**`equals()`** : 它的作用也是判断两个对象是否相等，它不能用于比较基本数据类型的变量。`equals()`方法存在于`Object`类中，而`Object`类是所有类的直接或间接父类。

`Object`类`equals()`方法：

```
public boolean equals(Object obj) {
     return (this == obj);
}
```

`equals()` 方法存在两种使用情况：

- 情况 1：类没有覆盖 `equals()`方法。则通过`equals()`比较该类的两个对象时，等价于通过“==”比较这两个对象。使用的默认是 `Object`类`equals()`方法。
- 情况 2：类覆盖了 `equals()`方法。一般，我们都覆盖 `equals()`方法来两个对象的内容相等；若它们的内容相等，则返回 true(即，认为这两个对象相等)。

### 基本数据类型

Java**中**有 8 种基本数据类型，分别为：

1. 6 种数字类型 ：byte、short、int、long、float、double
2. 1 种字符类型：char
3. 1 种布尔型：boolean。

#### 装箱与拆箱

在前面的文章中提到，Java为每种基本数据类型都提供了对应的包装器类型，至于为什么会为每种基本数据类型提供包装器类型在此不进行阐述，有兴趣的朋友可以查阅相关资料。在Java SE5之前，如果要生成一个数值为10的Integer对象，必须这样进行：

```
Integer i = ``new` `Integer(``10``);
```

　　而在从Java SE5开始就提供了自动装箱的特性，如果要生成一个数值为10的Integer对象，只需要这样就可以了：

```
Integer i = ``10``;
```

　　这个过程中会自动根据数值创建对应的 Integer对象，这就是装箱。

　　那什么是拆箱呢？顾名思义，跟装箱对应，就是自动将包装器类型转换为基本数据类型：

```
Integer i = ``10``; ``//装箱``int` `n = i;  ``//拆箱
```

　　简单一点说，装箱就是 自动将基本数据类型转换为包装器类型；拆箱就是 自动将包装器类型转换为基本数据类型。

从反编译得到的字节码内容可以看出，在装箱的时候自动调用的是Integer的valueOf(int)方法。而在拆箱的时候自动调用的是Integer的intValue方法。

### int和Integer

- Integer是int的包装类，int则是java的一种基本数据类型
- Integer变量必须实例化后才能使用，而int变量不需要
- Integer实际是对象的引用，当new一个Integer时，实际上是生成一个指针指向此对象；而int则是直接存储数据值
- Integer的默认值是null，int的默认值是0

### String StringBuffer 和 StringBuilder

* 都是final类，都不允许被继承

* String长度是不可变的，StringBuffer、StringBuilder长度是可变的

  简单的来说：`String` 类中使用 final 关键字修饰字符数组来保存字符串，`private final char value[]`，所以`String` 对象是不可变的。

  > 补充（来自[issue 675](https://github.com/Snailclimb/JavaGuide/issues/675)）：在 Java 9 之后，String 、`StringBuilder` 与 `StringBuffer` 的实现改用 byte 数组存储字符串 `private final byte[] value`

  而 `StringBuilder` 与 `StringBuffer` 都继承自 `AbstractStringBuilder` 类，在 `AbstractStringBuilder` 中也是使用字符数组保存字符串`char[]value` 但是没有用 `final` 关键字修饰，所以这两种对象都是可变的。

  `StringBuilder` 与 `StringBuffer` 的构造方法都是调用父类构造方法也就是`AbstractStringBuilder` 实现的。

* StringBuffer是线程安全的，StringBuilder不是线程安全的，但他们两个中的所有方法是相同的，StringBuffer在StringBuilder的方法上添加了synchronized修饰，保证线程安全

  `String` 中的对象是不可变的，也就可以理解为常量，线程安全。`AbstractStringBuilder` 是 `StringBuilder` 与 `StringBuffer` 的公共父类，定义了一些字符串的基本操作，如 `expandCapacity`、`append`、`insert`、`indexOf` 等公共方法。`StringBuffer` 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。`StringBuilder` 并没有对方法进行加同步锁，所以是非线程安全的。

* StringBuilder比StringBuffer拥有更好的性能

* 如果一个String类型的字符串，在编译时就可以确定是一个字符串常量，在编译完成之后，字符串会自动拼接乘一个常量，此时String的速度比StringBuffer和StringBuilder的性能好得多。

  每次对 `String` 类型进行改变的时候，都会生成一个新的 `String` 对象，然后将指针指向新的 `String` 对象。`StringBuffer` 每次都会对 `StringBuffer` 对象本身进行操作，而不是生成新的对象并改变对象引用。相同情况下使用 `StringBuilder` 相比使用 `StringBuffer` 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险。

  **对于三者使用的总结：**

  1. 操作少量的数据: 适用 `String`
  2. 单线程操作字符串缓冲区下操作大量数据: 适用 `StringBuilder`
  3. 多线程操作字符串缓冲区下操作大量数据: 适用 `StringBuffer`

### 重载和重写的区别

> 重载就是同样的一个方法能够根据输入数据的不同，做出不同的处理
>
> 重写就是当子类继承自父类的相同方法，输入数据一样，但要做出有别于父类的响应时，你就要覆盖父类方法

**重载：**

发生在同一个类中（或者父类和子类之间），方法名必须相同，参数类型不同、个数不同、顺序不同，方法返回值和访问修饰符可以不同。

**重写：**

重写发生在运行期，是子类对父类的允许访问的方法的实现过程进行重新编写。

1. 返回值类型、方法名、参数列表必须相同，抛出的异常范围小于等于父类，访问修饰符范围大于等于父类。
2. 如果父类方法访问修饰符为 `private/final/static` 则子类就不能重写该方法，但是被 static 修饰的方法能够被再次声明。
3. 构造方法无法被重写

![image-20210315095820334](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315095820334.png)

#### Java中是否可以覆盖(override)一个private或者是static的方法

Java中static方法不能被覆盖，因为方法覆盖是基于运行时动态绑定的，而static方法是编译时静态绑定的。static方法跟类的任何实例都不相关，所以概念上不适用。java中也不可以覆盖private的方法，因为private修饰的变量和方法只能在当前类中使用，如果是其他的类继承当前类是不能访问到private变量或方法的，当然也不能覆盖。

### 深拷贝 vs 浅拷贝

1. **浅拷贝**：对基本数据类型进行值传递，对引用数据类型进行引用传递般的拷贝，此为浅拷贝。
2. **深拷贝**：对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容，此为深拷贝。

### static和final

**static**

* 修饰变量：静态变量随着类加载时被完成初始化，内存中只有一个，且JVM也只会为它分配一次内存，所有类共享静态变量
* 修饰方法：在类加载的时候就存在，不依赖任何实例；static方法必须实现，不能用abstract修饰
* 修饰代码块：在类加载完之后会执行代码块中的内容
* 父类静态代码块->子类静态代码块->父类非静态代码块->父类构造方法->子类非静态代码块->子类构造方法

**final**

* 修饰变量：
  * 编译器常量：类加载的过程完成初始化，编译后带入到任何计算式中，只能是基本类型
  * 运行时常量：基本数据类型或引用数据类型，引用不可变，但引用的对象内容可变
* 修饰方法：不能被继承，不能被子类修改
* 修饰类：不能被继承
* 修饰形参：形参不可变

#### final的好处：

1. final关键字提高了性能。JVM和Java应用都会缓存final变量。 
2. final变量可以安全的在多线程环境下进行共享，而不需要额外的同步开销。 
3. 使用final关键字，JVM会对方法、变量及类进行优化。

### Object 类的常见方法总结

```java
public final native Class<?> getClass()//native方法，用于返回当前运行时对象的Class对象，使用了final关键字修饰，故不允许子类重写。

public native int hashCode() //native方法，用于返回对象的哈希码，主要使用在哈希表中，比如JDK中的HashMap。
public boolean equals(Object obj)//用于比较2个对象的内存地址是否相等，String类对该方法进行了重写用户比较字符串的值是否相等。

protected native Object clone() throws CloneNotSupportedException//naitive方法，用于创建并返回当前对象的一份拷贝。一般情况下，对于任何对象 x，表达式 x.clone() != x 为true，x.clone().getClass() == x.getClass() 为true。Object本身没有实现Cloneable接口，所以不重写clone方法并且进行调用的话会发生CloneNotSupportedException异常。

public String toString()//返回类的名字@实例的哈希码的16进制的字符串。建议Object所有的子类都重写这个方法。

public final native void notify()//native方法，并且不能重写。唤醒一个在此对象监视器上等待的线程(监视器相当于就是锁的概念)。如果有多个线程在等待只会任意唤醒一个。

public final native void notifyAll()//native方法，并且不能重写。跟notify一样，唯一的区别就是会唤醒在此对象监视器上等待的所有线程，而不是一个线程。

public final native void wait(long timeout) throws InterruptedException//native方法，并且不能重写。暂停线程的执行。注意：sleep方法没有释放锁，而wait方法释放了锁 。timeout是等待时间。

public final void wait(long timeout, int nanos) throws InterruptedException//多了nanos参数，这个参数表示额外时间（以毫微秒为单位，范围是 0-999999）。 所以超时的时间还需要加上nanos毫秒。

public final void wait() throws InterruptedException//跟之前的2个wait方法一样，只不过该方法一直等待，没有超时时间这个概念

protected void finalize() throws Throwable { }//实例被垃圾回收器回收的时候触发的操作
```

### Java的四个基本特性及多态的理解

#### 封装

封装是指把一个对象的状态信息（也就是属性）隐藏在对象内部，不允许外部对象直接访问对象的内部信息。但是可以提供一些可以被外界访问的方法来操作属性。

#### 继承

不同类型的对象，相互之间经常有一定数量的共同点。继承是使用已存在的类的定义作为基础建立新类的技术，新类的定义可以增加新的数据或新的功能，也可以用父类的功能，但不能选择性地继承父类。通过使用继承，可以快速地创建新的类，可以提高代码的重用，程序的可维护性，节省大量创建新类的时间 ，提高我们的开发效率。

**关于继承如下 3 点请记住：**

1. 子类拥有父类对象所有的属性和方法（包括私有属性和私有方法），但是父类中的私有属性和方法子类是无法访问，**只是拥有**。
2. 子类可以拥有自己属性和方法，即子类可以对父类进行扩展。
3. 子类可以用自己的方式实现父类的方法。（以后介绍）。

#### 多态

多态，顾名思义，表示一个对象具有多种的状态。具体表现为父类的引用指向子类的实例。

**多态的特点:**

- 对象类型和引用类型之间具有继承（类）/实现（接口）的关系；
- 引用类型变量发出的方法调用的到底是哪个类中的方法，必须在程序运行期间才能确定；
- 多态不能调用“只在子类存在但在父类不存在”的方法；
- 如果子类重写了父类的方法，真正执行的是子类覆盖的方法，如果子类没有覆盖父类的方法，执行的是父类的方法。

### 反射

JAVA 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为 java 语言的反射机制。

#### 静态编译和动态编译

- **静态编译：** 在编译时确定类型，绑定对象
- **动态编译：** 运行时确定类型，绑定对象

#### 反射机制优缺点

- **优点：** 运行期类型的判断，动态加载类，提高代码灵活度。
- **缺点：** 1,性能瓶颈：反射相当于一系列解释操作，通知 JVM 要做的事情，性能比直接的 java 代码要慢很多。2,安全问题，让我们可以动态操作改变类的属性同时也增加了类的安全隐患。

### Java 创建对象的四种方式

1. 使用new创建对象
2. 使用反射机制创建对象，即Class类中的newInstance方法
3. 使用clone，调用clone方法需要实现Cloneable接口
4. 采用序列化机制

#### 面试

https://m.nowcoder.com/discuss/619955

## JAVA collection

![collectionfamily](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\collectionfamily.jpg)

### List

- ArrayList： Object[]数组
- Vector：Object[]数组
- CopyOnWriteArrayList：使用了读写分离的思想，在写数据的时候上ReentrantLock锁并新建一个数组，读数据仍从旧数组中读取，而新数据在新增或删除完成之后直接替换旧数组。虽然线程安全，对于频繁写数据的场景效率很低。
- ListIterator： 更强大的Iterator的子类，用于各种List类的访问，并支持双向移动。
- LinkedList：双向链表(JDK1.6 之前为循环链表，JDK1.7 取消了循环)
  - getFirst() 和element() 完全一样，都返回第一个元素。如果为空，抛NoSuchElementException.
  - peek() 方法与上诉类似，只时列表为空返回null
  - removeFirst() 和 remove() 类似，移除并返回列表的头，只是列表为空抛出NoSuchElementException。
  - poll() 同样移除并返回列表头，只是列表为空返回Null
- Stack：pop()、push()、 peek()方法，其中peek()返回栈顶元素，而不将其移除。

#### ArrayList

底层是数组实现的。Object[]数组

默认初始化容量：10

- ```
  private static final int DEFAULT_CAPACITY = 10;
  ```

但是在jdk1.7之后，创建出来的是一个空数组，初试容量为0.

```java
/**
     * Shared empty array instance used for empty instances.
     */
private static final Object[] EMPTY_ELEMENTDATA = {};

/**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

public ArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    }
}

/**
     * Constructs an empty list with an initial capacity of ten.
     */
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
```

从构造函数和扩容函数中可以看出，根据不同情况使用DEFAULTCAPACITY_EMPTY_ELEMENTDATA和EMPTY_ELEMENTDATA（带参构造器中传入0）.

```java
//计算最小长度
private static int calculateCapacity(Object[] elementData, int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        return Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    return minCapacity;
}
```

在初次添加数据时使用扩容机制。先计算当前插入数据时，数组需要的最小长度，然后对比自生数组长度和最小长度大小看是否扩容，如果是初始化阶段，DEFAULTCAPACITY_EMPTY_ELEMENTDATA则将其扩容到10，EMPTY_ELEMENTDATA则扩容为1或2.

```java
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```



**扩容**

- 添加元素时使用 ensureCapacityInternal() 方法来保证容量足够，如果不够时，需要使用 grow() 方法进行扩容，新容量的大小为 oldCapacity + (oldCapacity >> 1)，也就是旧容量的 1.5 倍。
- 主要一个超精度负数判断，如果经度过长，则默认使用当前长度
- 数据复制使用Arrays.copyOf(elementData, newCapacity);

> 扩容因子为什么是1.5？

有一个很通俗的解释，扩容因子最适合范围为(1, 2)。

k=1.5时，就能充分利用前面已经释放的空间。如果k >= 2，新容量刚刚好永远大于过去所有废弃的数组容量。

- 为什么不取扩容固定容量呢？
  扩容的目的需要综合考虑这两种情况：

1. 扩容容量不能太小，防止频繁扩容，频繁申请内存空间 + 数组频繁复制
2. 扩容容量不能太大，需要充分利用空间，避免浪费过多空间；

而扩容固定容量，很难决定到底取多少值合适，取任何具体值都不太合适，因为所需数据量往往由数组的客户端在具体应用场景决定。

- 为什么是1.5，而不是1.2，1.25，1.8或者1.75？
  因为1.5 可以充分利用移位操作，减少浮点数或者运算时间和运算次数。

**快速失败**

- 快速失败(fail-fast) 是 Java 集合的一种错误检测机制。在使用迭代器对集合进行遍历的时候，我们在多线程下操作非安全失败(fail-safe)的集合类可能就会触发 fail-fast 机制，导致抛出 ConcurrentModificationException 异常。fail-fast机制并不保证在不同步的修改下一定会抛出异常，它只是尽最大努力去抛出，所以这种机制一般仅用于检测bug。
  - 另外，在单线程下，如果在遍历过程中对集合对象的内容进行了修改的话也会触发 fail-fast 机制。
- modCount 用来记录 ArrayList 结构发生变化的次数。结构发生变化是指添加或者删除至少一个元素的所有操作，或者是调整内部数组的大小，仅仅只是设置元素的值不算结构发生变化。
  - 使用迭代器遍历时默认会传入当前的数组的modCount，每次操作进行检测

```
    private class Itr implements Iterator<E> {
        int expectedModCount = modCount;
    ····

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
```

- 内存空间占用： ArrayList 的空间浪费主要体现在在 list 列表的结尾会预留一定的容量空间，而 LinkedList 的空间花费则体现在它的每一个元素都需要消耗比 ArrayList 更多的空间（因为要存放直接后继和直接前驱以及数据）。

**总结**

- ArrayList底层的数据结构是数组
- ArrayList可以自动扩容，不传初始容量或者初始容量是`0`，都会初始化一个空数组，但是如果添加元素，会自动进行扩容，所以，创建ArrayList的时候，给初始容量是必要的
- `Arrays.asList()`方法返回的是的`Arrays`内部的ArrayList，用的时候需要注意
- `subList()`返回内部类，不能序列化，和ArrayList共用同一个数组
- 迭代删除要用，迭代器的`remove`方法，或者可以用倒序的`for`循环
- ArrayList重写了序列化、反序列化方法，避免序列化、反序列化全部数组，浪费时间和空间
- `elementData`不使用`private`修饰，可以简化内部类的访问

#### CopyOnWriteArrayList 读写分离list

- 写操作在一个复制的数组上进行，读操作还是在原始数组中进行，读写分离，互不影响。
  - 写操作需要加锁，防止并发写入时导致写入数据丢失。
  - 写操作结束之后需要把原始数组指向新的复制数组
- 适用于读多写少的场景

```java
    public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    private E get(Object[] a, int index) {
        return (E) a[index];
    }
```

#### LinkedList

- 定义了一个内部的Node 节点，基于双向链表实现，使用 Node 存储链表节点信息。
- 相关操作：
  - getFirst() 和element() 完全一样，都返回第一个元素。如果为空，抛NoSuchElementException.
  - peek() 方法与上诉类似，只时列表为空返回null
  - removeFirst() 和 remove() 类似，移除并返回列表的头，只是列表为空抛出NoSuchElementException。
  - poll() 同样移除并返回列表头，只是列表为空返回Null

```java
 private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
```

### Map

- HashMap： JDK1.8 之前 HashMap 由数组+链表组成的，数组是 HashMap 的主体，链表则是主要为了解决哈希冲突而存在的（“拉链法”解决冲突）。JDK1.8 以后在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为 8）（将链表转换成红黑树前会判断，如果当前数组的长度小于 64，那么会选择先进行数组扩容，而不是转换为红黑树）时，将链表转化为红黑树，以减少搜索时间
- LinkedHashMap： LinkedHashMap 继承自 HashMap，所以它的底层仍然是基于拉链式散列结构即由数组和链表或红黑树组成。另外，LinkedHashMap 在上面结构的基础上，增加了一条双向链表，使得上面的结构可以保持键值对的插入顺序。同时通过对链表进行相应的操作，实现了访问顺序相关逻辑。详细可以查看：《LinkedHashMap 源码详细分析（JDK1.8）》
- Hashtable： 数组+链表组成的，数组是 HashMap 的主体，链表则是主要为了解决哈希冲突而存在的
- ConcurrentHashMap: 线程安全的Map.
- TreeMap: 基于红黑树的实现（自平衡的排序二叉树）。“键”或“键值对”的次序是由Comparable或Comparator决定的。TreeMap是唯一带有subMap()方法的Map，可以返回一个子树。
- WeakHashMap： 弱键映射，允许设释放射所指对象。被垃圾收集器回收。
- IdentityHashMap：使用==代替equals()对“键”进行比较的散列映射。
- sortedMap: 排序的Map，现阶段TreeMap是其唯一实现。
- EnumMap:要求键必须来自一个Enum。



#### HashMap

底层：数组+链表

**java8之前是头插法**，就是说新来的值会取代原有的值，原有的值就顺推到链表中去，就像上面的例子一样，因为写这个代码的作者认为后来的值被查找的可能性更大一点，提升查找的效率。

但是，**在java8之后，都是所用尾部插入了。**

> 为什么改成尾插法

首先我们看下HashMap的扩容机制：

数组容量是有限的，数据多次插入的，到达一定的数量就会进行扩容，也就是resize。

有两个因素：

- Capacity：HashMap当前长度。
- LoadFactor：负载因子，默认值0.75f。

> 扩容？它是怎么扩容的呢？

分为两步

- 扩容：创建一个新的Entry空数组，长度是原数组的2倍。
- ReHash：遍历原Entry数组，把所有的Entry重新Hash到新数组。

> 为什么要重新Hash呢，直接复制过去不香么？

是因为长度扩大以后，Hash的规则也随之改变。

回到原来的问题，在使用头插法是，在多线程的情况下，在扩容时有可能产生循环。

> 那我问你HashMap的默认初始化长度是多少？

我记得我在看源码的时候初始化大小是16

> 你那知道为啥是16么？

这样是为了位运算的方便，**位与运算比算数计算的效率高了很多**，之所以选择16，是为了服务将Key映射到index的算法。

我前面说了所有的key我们都会拿到他的hash，但是我们怎么尽可能的得到一个均匀分布的hash呢？

是的我们通过Key的HashCode值去做位运算。

我打个比方，key为”帅丙“的十进制为766132那二进制就是 10111011000010110100

我们再看下index的计算公式：index = HashCode（Key） & （Length- 1）

15的的二进制是1111，那10111011000010110100 &1111 十进制就是4

之所以用位与运算效果与取模一样，性能也提高了不少！

> 那为啥用16不用别的呢？

因为在使用不是2的幂的数字的时候，Length-1的值是所有二进制位全为1，这种情况下，index的结果等同于HashCode后几位的值。

只要输入的HashCode本身分布均匀，Hash算法的结果就是均匀的。

这是为了**实现均匀分布**。

> 为啥我们重写equals方法的时候需要重写hashCode方法呢？

如果我们对equals方法进行了重写，建议一定要对hashCode方法重写，以保证相同的对象返回相同的hash值，不同的对象返回不同的hash值。

#### ConcurrentHashMap

实现Hashmap线程安全的方式：

- 使用Collections.synchronizedMap(Map)创建线程安全的map集合；
- Hashtable
- ConcurrentHashMap

> Collections.synchronizedMap是怎么实现线程安全

在SynchronizedMap内部维护了一个普通对象Map，还有排斥锁mutex

![image-20210317162658030](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210317162658030.png)

Hashtable:在对数据操作的时候都会使用synchronized上锁，所以效率比较低下。

**Hashtable与HashMap的区别：**

* Hashtable 是不允许键或值为 null 的，HashMap 的键值则都可以为 null。

  因为Hashtable使用的是**安全失败机制（fail-safe）**，这种机制会使你此次读到的数据不一定是最新的数据。

  如果你使用null值，就会使得其无法判断对应的key是不存在还是为空，因为你无法再调用一次contain(key）来对key是否存在进行判断，ConcurrentHashMap同理。

* **实现方式不同**：Hashtable 继承了 Dictionary类，而 HashMap 继承的是 AbstractMap 类。

* **初始化容量不同**：HashMap 的初始容量为：16，Hashtable 初始容量为：11，两者的负载因子默认都是：0.75。

* **扩容机制不同**：当现有容量大于总容量 * 负载因子时，HashMap 扩容规则为当前容量翻倍，Hashtable 扩容规则为当前容量翻倍 + 1。

* **迭代器不同**：HashMap 中的 Iterator 迭代器是 fail-fast 的，而 Hashtable 的 Enumerator 不是 fail-fast 的。

**ConcurrentHashMap**

**jdk1.7** 由 Segment 数组、HashEntry 组成，和 HashMap 一样，仍然是**数组加链表**。

原理上来说，ConcurrentHashMap 采用了**分段锁**技术，其中 Segment 继承于 ReentrantLock。

不会像 HashTable 那样不管是 put 还是 get 操作都需要做同步处理，理论上 ConcurrentHashMap 支持 CurrencyLevel (Segment 数组数量)的线程并发。

每当一个线程占用锁访问一个 Segment 时，不会影响到其他的 Segment。

就是说如果容量大小是16他的并发度就是16，可以同时允许16个线程操作16个Segment而且还是线程安全的。

**put操作：**

先定位到Segment，然后再进行put操作。

首先第一步的时候会尝试获取锁，如果获取失败肯定就有其他线程存在竞争，则利用`scanAndLockForPut()` 自旋获取锁。

1. 尝试自旋获取锁。
2. 如果重试的次数达到了 `MAX_SCAN_RETRIES` 则改为阻塞锁获取，保证能获取成功。

**get操作：**

get 逻辑比较简单，只需要将 Key 通过 Hash 之后定位到具体的 Segment ，再通过一次 Hash 定位到具体的元素上。

由于 HashEntry 中的 value 属性是用 volatile 关键词修饰的，保证了内存可见性，所以每次获取时都是最新值。

ConcurrentHashMap 的 get 方法是非常高效的，**因为整个过程都不需要加锁**。

**问题：**

因为基本上还是数组加链表的方式，我们去查询的时候，还得遍历链表，会导致效率很低，这个跟jdk1.7的HashMap是存在的一样问题，所以他在jdk1.8完全优化了。

**jdk1.8** 抛弃了原有的 Segment 分段锁，而采用了 `CAS + synchronized` 来保证并发安全性。

跟HashMap很像，也把之前的HashEntry改成了Node，但是作用不变，把值和next采用了volatile去修饰，保证了可见性，并且也引入了红黑树，在链表大于一定值的时候会转换（默认是8）。

ConcurrentHashMap在进行put操作的还是比较复杂的，大致可以分为以下步骤：

1. 根据 key 计算出 hashcode 。
2. 判断是否需要进行初始化。
3. 即为当前 key 定位出的 Node，如果为空表示当前位置可以写入数据，利用 CAS 尝试写入，失败则自旋保证成功。
4. 如果当前位置的 `hashcode == MOVED == -1`,则需要进行扩容。
5. 如果都不满足，则利用 synchronized 锁写入数据。
6. 如果数量大于 `TREEIFY_THRESHOLD` 则要转换为红黑树。

**get：**

- 根据计算出来的 hashcode 寻址，如果就在桶上那么直接返回值。
- 如果是红黑树那就按照树的方式获取值。
- 如果是链表那就按照链表的方式遍历获取值。

#### LinkedHashMap

基于HashMap的基础Node的节点做拓展，添加头尾指针，因此支持顺序访问。双链表加数组的实现。

```
static class Entry<K,V> extends HashMap.Node<K,V> {
    Entry<K,V> before, after;
    Entry(int hash, K key, V value, Node<K,V> next) {
        super(hash, key, value, next);
    }
}
```

主要用于LRU的构建

### Set

HashSet（无序，唯一）: 基于 HashMap 实现的，底层采用 HashMap 来保存元素

LinkedHashSet：LinkedHashSet 是 HashSet 的子类，并且其内部是通过 LinkedHashMap 来实现的。有点类似于我们之前说的 LinkedHashMap 其内部是基于 HashMap 实现一样，不过还是有一点点区别的

TreeSet（有序，唯一）： 红黑树(自平衡的排序二叉树)

#### HashSet

```java
public HashSet() {
        map = new HashMap<>();
    }
```

- HashSet是基于HashMap实现的，HashSet中的元素都存放在HashMap的key上面，而value中的值都是统一的一个固定对象private static final Object PRESENT = new Object();
- 为什么没有get方法？ 因为map的get方法是通过Key获取的，而HashSet的应用里面，key都用来存值了。

#### LinkedHashSet实现

- 底层使用LinkedHashMap

### 其他

#### hash 冲突解决方案

1. 开放地址法
2. 再哈希法
3. 链地址法（拉链法）

## JAVA多线程

> #### 什么是线程？

线程是操作系统能够进行运算调度的最小单位，它被包含在进程之中，是进程中的实际运作单位。

> 什么是进程?

进程是程序的一次执行过程，是系统运行程序的基本单位，因此进程是动态的。

> #### 线程和进程有什么区别？

线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务。不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间。

### 线程的状态

![image-20210315142639163](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315142639163.png)



### 多线程的实现方式

1. 继承Thread类实现多线程，重写run方法。（Thread实现Runnable接口）
2. 实现Runnable接口实现多线程，同样重写run方法，run没有返回值
3. 继承Callable接口实现多线程，重写call方法，call有返回值

### 线程方法与状态切换

sleep 导致当前线程休眠，与 wait 方法不同的是 sleep 不会释放当前占有的锁,sleep(long)会导致线程进入 **TIMED-WATING** 状态，而 wait()方法会导致当前线程进入 WATING 状态

wait 方法，主动让出锁。

1. 不带时间常数的wait 方法进入WAITING状态。
2. 带时间常数的wait 进入TIME-WAITING状态。

yield 方法，线程让步。

> yield 会使当前线程让出 CPU 执行时间片，与其他线程一起重新竞争 CPU 时间片。一般情况下，优先级高的线程有更大的可能性成功竞争得到 CPU 时间片

join方法，当前线程转为阻塞状态，等到另一个线程结束，当前线程再由阻塞状态变为就绪状态，等待 cpu 的宠幸。

> join方法可用于多线程的协作，如主子线程的协作，主线程等待子线程完成任务。
>
> - join 方法的状态转换与wait方法相同，带时间的进入TIME-WAITING状态，不带时间的进入WAITING状态。

### CAS（Compare And Swap）

![image-20210315151909710](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315151909710.png)

#### CAS的问题

* ABA问题

  使用`AtomicStampedReference`解决ABA问题

* 开销问题

  如果CAS运算长期不成功,处在自旋状态,将会增加CPU的开销

* 只能保证一个共享变量的原子操作

**应用：**

1. 原子类
2. 自旋锁

### synchronized

**`synchronized` 关键字解决的是多个线程之间访问资源的同步性，`synchronized`关键字可以保证被它修饰的方法或者代码块在任意时刻只能有一个线程执行。**

另外，在 Java 早期版本中，`synchronized` 属于 **重量级锁**，效率低下。

**为什么呢？**

因为监视器锁（monitor）是依赖于底层的操作系统的 `Mutex Lock` 来实现的，Java 的线程是映射到操作系统的原生线程之上的。如果要挂起或者唤醒一个线程，都需要操作系统帮忙完成，而操作系统实现线程之间的切换时需要从用户态转换到内核态，这个状态之间的转换需要相对比较长的时间，时间成本相对较高。

庆幸的是在 Java 6 之后 Java 官方对从 JVM 层面对 `synchronized` 较大优化，所以现在的 `synchronized` 锁效率也优化得很不错了。JDK1.6 对锁的实现引入了大量的优化，如自旋锁、适应性自旋锁、锁消除、锁粗化、偏向锁、轻量级锁等技术来减少锁操作的开销。

所以，你会发现目前的话，不论是各种开源框架还是 JDK 源码都大量使用了 `synchronized` 关键字。

**Java对象的构成**

在 JVM 中，对象在内存中分为三块区域：

- 对象头

- - **Mark Word（标记字段）**：默认存储对象的HashCode，分代年龄和锁标志位信息。它会根据对象的状态复用自己的存储空间，也就是说在运行期间Mark Word里存储的数据会随着锁标志位的变化而变化。
  - **Klass Point（类型指针）**：对象指向它的类元数据的指针，虚拟机通过这个指针来确定这个对象是哪个类的实例。

- 实例数据

- - 这部分主要是存放类的数据信息，父类的信息。

- 对其填充

- - 由于虚拟机要求对象起始地址必须是8字节的整数倍，填充数据不是必须存在的，仅仅是为了字节对齐。

    Tip：不知道大家有没有被问过一个空对象占多少个字节？就是8个字节，是因为对齐填充的关系哈，不到8个字节对其填充会帮我们自动补齐。

![image-20210315155002263](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315155002263.png)

#### synchronized 关键字最主要的三种使用方式：

**1.修饰实例方法:** 作用于当前对象实例加锁，进入同步代码前要获得 **当前对象实例的锁**

**2.修饰静态方法:** 也就是给当前类加锁，会作用于类的所有对象实例 ，进入同步代码前要获得 **当前 class 的锁**。因为静态成员不属于任何一个实例对象，是类成员（ *static 表明这是该类的一个静态资源，不管 new 了多少个对象，只有一份*）。所以，如果一个线程 A 调用一个实例对象的非静态 `synchronized` 方法，而线程 B 需要调用这个实例对象所属类的静态 `synchronized` 方法，是允许的，不会发生互斥现象，**因为访问静态 `synchronized` 方法占用的锁是当前类的锁，而访问非静态 `synchronized` 方法占用的锁是当前实例对象锁**。

**3.修饰代码块** ：指定加锁对象，对给定对象/类加锁。`synchronized(this|object)` 表示进入同步代码库前要获得**给定对象的锁**。`synchronized(类.class)` 表示进入同步代码前要获得 **当前 class 的锁**

**总结：**

- `synchronized` 关键字加到 `static` 静态方法和 `synchronized(class)` 代码块上都是是给 Class 类上锁。
- `synchronized` 关键字加到实例方法上是给对象实例上锁。
- 尽量不要使用 `synchronized(String a)` 因为 JVM 中，字符串常量池具有缓存功能！

#### 讲一下 synchronized 关键字的底层原理

**synchronized 关键字底层原理属于 JVM 层面。**

**synchronized 同步语句块的情况**

```java
public class SynchronizedDemo {
	public void method() {
		synchronized (this) {
			System.out.println("synchronized 代码块");
		}
	}
}
```

![image-20210315154440782](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315154440782.png)

从上面我们可以看出：

**`synchronized` 同步语句块的实现使用的是 `monitorenter` 和 `monitorexit` 指令，其中 `monitorenter` 指令指向同步代码块的开始位置，`monitorexit` 指令则指明同步代码块的结束位置。**

当执行 `monitorenter` 指令时，线程试图获取锁也就是获取 **对象监视器 `monitor`** 的持有权。

> 在 Java 虚拟机(HotSpot)中，Monitor 是基于 C++实现的，由[ObjectMonitor](https://github.com/openjdk-mirror/jdk7u-hotspot/blob/50bdefc3afe944ca74c3093e7448d6b889cd20d1/src/share/vm/runtime/objectMonitor.cpp)实现的。每个对象中都内置了一个 `ObjectMonitor`对象。
>
> 另外，**`wait/notify`等方法也依赖于`monitor`对象，这就是为什么只有在同步的块或者方法中才能调用`wait/notify`等方法，否则会抛出`java.lang.IllegalMonitorStateException`的异常的原因。**

在执行`monitorenter`时，会尝试获取对象的锁，如果锁的计数器为 0 则表示锁可以被获取，获取后将锁计数器加 1。

在执行 `monitorexit` 指令后，将锁计数器减一 ，计数器为0时表明锁被释放。如果获取对象锁失败，那当前线程就要阻塞等待，直到锁被另外一个线程释放为止。

**`synchronized` 修饰方法的的情况**

```java
public class SynchronizedDemo2 {
	public synchronized void method() {
		System.out.println("synchronized 方法");
	}
}
```

![image-20210315154611440](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315154611440.png)

`synchronized` 修饰的方法并没有 `monitorenter` 指令和 `monitorexit` 指令，取得代之的确实是 `ACC_SYNCHRONIZED` 标识，该标识指明了该方法是一个同步方法。JVM 通过该 `ACC_SYNCHRONIZED` 访问标志来辨别一个方法是否声明为同步方法，从而执行相应的同步调用。同步方法的时候，一旦执行到这个方法，就会先判断是否有标志位，然后，ACC_SYNCHRONIZED会去隐式调用刚才的两个指令：monitorenter和monitorexit。

#### 说说 JDK1.6 之后的 synchronized 关键字底层做了哪些优化，可以详细介绍一下这些优化吗

锁主要存在四种状态，依次是：无锁状态、偏向锁状态、轻量级锁状态、重量级锁状态，他们会随着竞争的激烈而逐渐升级。注意锁可以升级不可降级，这种策略是为了提高获得锁和释放锁的效率。

![image-20210315155050984](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315155050984.png)

升级方向：

![image-20210315155059529](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315155059529.png)

Tip：切记这个升级过程是不可逆的，最后我会说明他的影响，涉及使用场景。

![image-20210319095607818](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210319095607818.png)

**偏向锁**

偏向锁是针对于一个线程而言的, 线程获得锁之后就不会再有解锁等操作了, 这样可以省略很多开销. 假如有两个线程来竞争该锁话, 那么偏向锁就失效了, 进而升级成轻量级锁了。

锁争夺也就是对象头指向的Monitor对象的争夺，一旦有线程持有了这个对象，标志位修改为1，就进入偏向模式，同时会把这个线程的ID记录在对象的Mark Word中。

这个过程是采用了CAS操作的，每次同一线程进入，虚拟机就不进行任何同步的操作了，对标志位+1就好了，不同线程过来，CAS会失败，也就意味着获取锁失败。

**轻量级锁**

当出现有两个线程来竞争锁的话, 那么偏向锁就失效了, 此时锁就会膨胀, 升级为轻量级锁。

还是跟Mark Work 相关，如果这个对象是无锁的，jvm就会在当前线程的栈帧中建立一个叫锁记录（Lock Record）的空间，用来存储锁对象的Mark Word 拷贝，然后把Lock Record中的owner指向当前对象。

JVM接下来会利用CAS尝试把对象原本的Mark Word 更新会Lock Record的指针，成功就说明加锁成功，改变锁标志位，执行相关同步操作。

如果失败了，就会判断当前对象的Mark Word是否指向了当前线程的栈帧，是则表示当前的线程已经持有了这个对象的锁，否则说明被其他线程持有了，继续锁升级，修改锁的状态，之后等待的线程也阻塞。

**自旋锁**

Linux系统的用户态和内核态的切换很耗资源，其实就是线程的等待唤起过程，那怎么才能减少这种消耗呢？

自旋，过来的现在就不断自旋，防止线程被挂起，一旦可以获取资源，就直接尝试成功，直到超出阈值，自旋锁的默认大小是10次

![image-20210315160339281](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315160339281.png)

#### 谈谈 synchronized 和 ReentrantLock 的区别

1. **两者都是可重入锁**

   **“可重入锁”** 指的是自己可以再次获取自己的内部锁。比如一个线程获得了某个对象的锁，此时这个对象锁还没有释放，当其再次想要获取这个对象的锁的时候还是可以获取的，如果不可锁重入的话，就会造成死锁。同一个线程每次获取锁，锁的计数器都自增 1，所以要等到锁的计数器下降为 0 时才能释放锁。

2. **synchronized 依赖于 JVM 而 ReentrantLock 依赖于 API**

   `synchronized` 是依赖于 JVM 实现的，前面我们也讲到了 虚拟机团队在 JDK1.6 为 `synchronized` 关键字进行了很多优化，但是这些优化都是在虚拟机层面实现的，并没有直接暴露给我们。`ReentrantLock` 是 JDK 层面实现的（也就是 API 层面，需要 lock() 和 unlock() 方法配合 try/finally 语句块来完成），所以我们可以通过查看它的源代码，来看它是如何实现的。

3. **ReentrantLock 比 synchronized 增加了一些高级功能**

4. 相比`synchronized`，`ReentrantLock`增加了一些高级功能。主要来说主要有三点：

   - **等待可中断** : `ReentrantLock`提供了一种能够中断等待锁的线程的机制，通过 `lock.lockInterruptibly()` 来实现这个机制。也就是说正在等待的线程可以选择放弃等待，改为处理其他事情。
   - **可实现公平锁** : `ReentrantLock`可以指定是公平锁还是非公平锁。而`synchronized`只能是非公平锁。所谓的公平锁就是先等待的线程先获得锁。`ReentrantLock`默认情况是非公平的，可以通过 `ReentrantLock`类的`ReentrantLock(boolean fair)`构造方法来制定是否是公平的。
   - **可实现选择性通知（锁可以绑定多个条件）**: `synchronized`关键字与`wait()`和`notify()`/`notifyAll()`方法相结合可以实现等待/通知机制。`ReentrantLock`类当然也可以实现，但是需要借助于`Condition`接口与`newCondition()`方法。

5. synchronized会自动释放锁，而Lock必须手动释放锁。

6. synchronized能锁住方法和代码块，而Lock只能锁住代码块。

### volatile

从 **CPU 缓存模型** 说起！

#### CPU 缓存模型

**为什么要弄一个 CPU 高速缓存呢？**

类比我们开发网站后台系统使用的缓存（比如 Redis）是为了解决程序处理速度和访问常规关系型数据库速度不对等的问题。 **CPU 缓存则是为了解决 CPU 处理速度和内存处理速度不对等的问题。**

我们甚至可以把 **内存可以看作外存的高速缓存**，程序运行的时候我们把外存的数据复制到内存，由于内存的处理速度远远高于外存，这样提高了处理速度。

总结：**CPU Cache 缓存的是内存数据用于解决 CPU 处理速度和内存不匹配的问题，内存缓存的是硬盘数据用于解决硬盘访问速度过慢的问题。**

为了更好地理解，我画了一个简单的 CPU Cache 示意图如下

![image-20210315201945676](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315201945676.png)

**CPU Cache 的工作方式：**

先复制一份数据到 CPU Cache 中，当 CPU 需要用到的时候就可以直接从 CPU Cache 中读取数据，当运算完成后，再将运算得到的数据写回 Main Memory 中。但是，这样存在 **内存缓存不一致性的问题** ！比如我执行一个 i++操作的话，如果两个线程同时执行的话，假设两个线程从 CPU Cache 中读取的 i=1，两个线程做了 1++运算完之后再写回 Main Memory 之后 i=2，而正确结果应该是 i=3。

**CPU 为了解决内存缓存不一致性问题可以通过制定缓存一致协议或者其他手段来解决。**

####  JMM(Java 内存模型)

在 JDK1.2 之前，Java 的内存模型实现总是从**主存**（即共享内存）读取变量，是不需要进行特别的注意的。而在当前的 Java 内存模型下，线程可以把变量保存**本地内存**（比如机器的寄存器）中，而不是直接在主存中进行读写。这就可能造成一个线程在主存中修改了一个变量的值，而另外一个线程还继续使用它在寄存器中的变量值的拷贝，造成**数据的不一致**。正是因为这样的机制，才导致了可见性问题的存在。

![image-20210315201933006](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315201933006.png)

#### 解决可见性问题

1. 加锁

   ![image-20210315202703116](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315202703116.png)

   某一个线程进入synchronized代码块前后，线程会获得锁，清空工作内存，从主内存拷贝共享变量最新的值到工作内存成为副本，执行代码，将修改后的副本的值刷新回主内存中，线程释放锁。

   而获取不到锁的线程会阻塞等待，所以变量的值肯定一直都是最新的。

2. Volatile修饰共享变量

   每个线程操作数据的时候会把数据从主内存读取到自己的工作内存，如果他操作了数据并且写回了，他其他已经读取的线程的变量副本就会失效了，需要都数据进行操作又要再次去主内存中读取了。

   volatile保证不同线程对共享变量操作的可见性，也就是说一个线程修改了volatile修饰的变量，当修改写回主内存时，另外一个线程立即看到最新的值。

为了解决一致性的问题，需要各个处理器访问缓存时都遵循一些协议，在读写时要根据协议来进行操作，这类协议有MSI、`MESI（IllinoisProtocol）`、MOSI、Synapse、Firefly及DragonProtocol等。

#### MSI

当CPU写数据时，如果发现操作的变量是共享变量，即在其他CPU中也存在该变量的副本，会发出信号通知其他CPU将该变量的缓存行置为无效状态，因此当其他CPU需要读取这个变量时，发现自己缓存中缓存该变量的缓存行是无效的，那么它就会从内存重新读取。

做法：**嗅探**

每个处理器通过嗅探在总线上传播的数据来检查自己缓存的值是不是过期了，当处理器发现自己缓存行对应的内存地址被修改，就会将当前处理器的缓存行设置成无效状态，当处理器对这个数据进行修改操作的时候，会重新从系统内存中把数据读到处理器缓存里。

**嗅探的缺点：**

总线风暴，由于Volatile的MESI缓存一致性协议，需要不断的从主内存嗅探和cas不断循环，无效交互会导致总线带宽达到峰值。

所以不要大量使用Volatile，至于什么时候去使用Volatile什么时候使用锁，根据场景区分。

#### volatile禁止指令重排

**什么是重排序**

为了提高性能，编译器和处理器常常会对既定的代码执行顺序进行指令重排序。

![image-20210315205717620](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315205717620.png)

一个好的内存模型实际上会放松对处理器和编译器规则的束缚，也就是说软件技术和硬件技术都为同一个目标，而进行奋斗：在不改变程序执行结果的前提下，尽可能提高执行效率。

JMM对底层尽量减少约束，使其能够发挥自身优势。

因此，在执行程序时，为了提高性能，编译器和处理器常常会对指令进行重排序。

一般重排序可以分为如下三种：

- 编译器优化的重排序。编译器在不改变单线程程序语义的前提下，可以重新安排语句的执行顺序;
- 指令级并行的重排序。现代处理器采用了指令级并行技术来将多条指令重叠执行。如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序;
- 内存系统的重排序。由于处理器使用缓存和读/写缓冲区，这使得加载和存储操作看上去可能是在乱序执行的。

这里还得提一个概念，`as-if-serial`。

**as-if-serial**

不管怎么重排序，单线程下的执行结果不能被改变。

编译器、runtime和处理器都必须遵守as-if-serial语义。

**Volatile是怎么保证不会被执行重排序的**

**内存屏障：**

内存屏障共分为四种类型：

* LoadLoad屏障：抽象场景：Load1; LoadLoad;Load2

  Load1 和 Load2 代表两条读取指令。在Load2要读取的数据被访问前，保证Load1要读取的数据被读取完毕。

* StoreStore屏障：抽象场景：Store1; StoreStore; Store2，

  Store1 和 Store2代表两条写入指令。在Store2写入执行前，保证Store1的写入操作对其它处理器可见

* LoadStore屏障：抽象场景：Load1; LoadStore; Store2

  在Store2被写入前，保证Load1要读取的数据被读取完毕。

* StoreLoad屏障：抽象场景：Store1; StoreLoad; Load2

  在Load2读取操作执行前，保证Store1的写入对所有处理器可见。StoreLoad屏障的开销是四种屏障中最大的。

volatile特性之一：

保证变量在线程之间的可见性。可见性的保证是基于CPU的内存屏障指令，被JSR-133抽象为happens-before原则。

volatile特性之二：

阻止编译时和运行时的指令重排。编译时JVM编译器遵循内存屏障的约束，运行时依靠CPU屏障指令来阻止重排。



1.在每个volatile写操作前插入StoreStore屏障，在写操作后插入StoreLoad屏障。

2.在每个volatile读操作前插入LoadLoad屏障，在读操作后插入LoadStore屏障。



java编译器会在生成指令系列时在适当的位置会插入`内存屏障`指令来禁止特定类型的处理器重排序。

为了实现volatile的内存语义，JMM会限制特定类型的编译器和处理器重排序，JMM会针对编译器制定volatile重排序规则表：

需要注意的是：volatile写是在前面和后面**分别插入内存屏障**，而volatile读操作是在**后面插入两个内存屏障**。

**写：**

![image-20210315210234329](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315210234329.png)

**读：**

![image-20210315210251774](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315210251774.png)

上面的我提过重排序原则，为了提高处理速度，JVM会对代码进行编译优化，也就是指令重排序优化，并发编程下指令重排序会带来一些安全隐患：如指令重排序导致的多个线程操作之间的不可见性。

如果让程序员再去了解这些底层的实现以及具体规则，那么程序员的负担就太重了，严重影响了并发编程的效率。

从JDK5开始，提出了`happens-before`的概念，通过这个概念来阐述操作之间的内存可见性。

**happens-before：**

如果一个操作执行的结果需要对另一个操作可见，那么这两个操作之间必须存在happens-before关系。

```
volatile域规则：对一个volatile域的写操作，happens-before于任意线程后续对这个volatile域的读。
```

如果现在我的变了flag变成了false，那么后面的那个操作，一定要知道我变了。

聊了这么多，我们要知道Volatile是没办法保证原子性的，一定要保证原子性，可以使用其他方法。

#### volatile与synchronized的区别

volatile只能修饰实例变量和类变量，而synchronized可以修饰方法，以及代码块。

volatile保证数据的可见性，但是不保证原子性(多线程进行写操作，不保证线程安全);而synchronized是一种排他(互斥)的机制。

volatile用于禁止指令重排序：可以解决单例双重检查对象初始化代码执行乱序问题。

### CountDownLatch,CyclicBarrier,Semaphore

#### CountDownLatch

当一个线程调用await方法时，就会阻塞当前线程。每当有线程调用一次 countDown 方法时，计数就会减 1。当 count 的值等于 0 的时候，被阻塞的线程才会继续运行。

#### CyclicBarrier

一组线程会互相等待，直到所有线程都到达一个同步点。

#### Semaphore

Semaphore 信号量，用来控制同一时间，资源可被访问的线程数量，一般可用于流量的控制。

#### 总结

1. CountDownLatch 是一个线程等待其他线程， CyclicBarrier 是多个线程互相等待。
2. CountDownLatch 的计数是减 1 直到 0，CyclicBarrier 是加 1，直到指定值。
3. CountDownLatch 是一次性的， CyclicBarrier  可以循环利用。
4. CyclicBarrier 可以在最后一个线程达到屏障之前，选择先执行一个操作。
5. Semaphore ，需要拿到许可才能执行，并可以选择公平和非公平模式。

### 面试题：实现并发线程按顺序输出1234

#### ReentrantLock

```java
public class test {
    public static void main(String[] args) {
        Print1234 print1234 = new Print1234();
        new Thread(()-> {
            print1234.print1();
        }).start();
        new Thread(()-> {
            print1234.print2();
        }).start();
        new Thread(()-> {
            print1234.print3();
        }).start();
        new Thread(()-> {
            print1234.print4();
        }).start();
    }
}


class Print1234 {
    private Lock lock= new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private Condition condition4 = lock.newCondition();
    private int number = 1;

    public void print1() {
        lock.lock();
        try {
            while(number!=1) {
                condition1.await();
            }
            System.out.println(1);
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print2() {
        lock.lock();
        try {
            while(number!=2) {
                condition2.await();
            }
            System.out.println(2);
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print3() {
        lock.lock();
        try {
            while(number!=3) {
                condition3.await();
            }
            System.out.println(3);
            number = 4;
            condition4.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print4() {
        lock.lock();
        try {
            while(number!=4) {
                condition4.await();
            }
            System.out.println(4);
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
```



#### Semphore

```java
public class Print1234 {
    public static Semaphore sem1;
    public static Semaphore sem2;
    public static Semaphore sem3;
    public static Semaphore sem4;
 
    static class FirstThread extends Thread {
        public void run() {
            try {
                while (true) {
                    sem1.acquire();
                    System.out.println("1");
                    sem2.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 
    static class SecondThread extends Thread {
        public void run() {
            try {
                while (true) {
                    sem2.acquire();
                    System.out.println("2");
                    sem3.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 
    static class ThirdThread extends Thread {
        public void run() {
            try {
                while (true) {
                    sem3.acquire();
                    System.out.println("3");
                    sem4.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 
    static class ForthThread extends Thread {
        public void run() {
            try {
                while (true) {
                    sem4.acquire();
                    System.out.println("4");
                    sem1.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(1);
        sem3 = new Semaphore(1);
        sem4 = new Semaphore(1);
        try {
            // 不要有sem1.acquire()
            sem2.acquire();
            sem3.acquire();
            sem4.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        new FirstThread().start();
        new SecondThread().start();
        new ThirdThread().start();
        new ForthThread().start();
 
    }
}
```



#### volatile

```java
public class PrintThree {
    volatile static int state = 0;
 
    static class First extends Thread {
        @Override
        public void run() {
            while (true) {
                if (state % 4 == 0) {
                    System.out.println("1");
                    state++;
                }
            }
        }
    }
 
    static class Second extends Thread {
        @Override
        public void run() {
            while (true) {
                if (state % 4 == 1) {
                    System.out.println("2");
                    state++;
                }
            }
        }
    }
 
    static class Third extends Thread {
        @Override
        public void run() {
            while (true) {
                if (state % 4 == 2) {
                    System.out.println("3");
                    state++;
                }
            }
        }
    }
 
    static class Forth extends Thread {
        @Override
        public void run() {
            while (true) {
                if (state % 4 == 3) {
                    System.out.println("4");
                    state++;
                }
            }
        }
    }
 
    public static void main(String[] args) {
        First first = new First();
        Second second = new Second();
        Third third = new Third();
        Forth forth = new Forth();
        first.start();
        second.start();
        third.start();
        forth.start();
    }
}
```

#### Condition

`Condition`是在`java 1.5`中才出现的，它用来替代传统的`Object`的`wait()`、`notify()`实现线程间的协作，相比使用`Object`的`wait()`、`notify()`，使用`Condition`中的`await()`、`signal()`这种方式实现线程间协作更加安全和高效。

其中`AbstractQueueSynchronizer`中实现了`Condition`中的方法，主要对外提供`awaite(Object.wait())`和`signal(Object.notify())`调用。

- Condition 可以精准的对多个不同条件进行控制，wait/notify 只能和 synchronized 关键字一起使用，并且只能唤醒一个或者全部的等待队列；
- Condition 需要使用 Lock 进行控制，使用的时候要注意 lock() 后及时的 unlock()，Condition 有类似于 await 的机制，因此不会产生加锁方式而产生的死锁出现，同时底层实现的是 park/unpark 的机制，因此也不会产生先唤醒再挂起的死锁，一句话就是不会产生死锁，但是 wait/notify 会产生先唤醒再挂起的死锁。

### Atomic原子类

`Atomic` 翻译成中文是原子的意思。在化学上，我们知道原子是构成一般物质的最小单位，在化学反应中是不可分割的。在我们这里 Atomic 是指一个操作是不可中断的。即使是在多个线程一起执行的时候，一个操作一旦开始，就不会被其他线程干扰。

所以，所谓原子类说简单点就是具有原子/原子操作特征的类。

并发包 `java.util.concurrent` 的原子类都存放在`java.util.concurrent.atomic`下,如下图所示。

![image-20210315214321810](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210315214321810.png)

#### JUC 包中的原子类是哪 4 类

**基本类型**

使用原子的方式更新基本类型

- `AtomicInteger`：整形原子类
- `AtomicLong`：长整型原子类
- `AtomicBoolean`：布尔型原子类

**数组类型**

使用原子的方式更新数组里的某个元素

- `AtomicIntegerArray`：整形数组原子类
- `AtomicLongArray`：长整形数组原子类
- `AtomicReferenceArray`：引用类型数组原子类

**引用类型**

- `AtomicReference`：引用类型原子类
- `AtomicStampedReference`：原子更新带有版本号的引用类型。该类将整数值与引用关联起来，可用于解决原子的更新数据和数据的版本号，可以解决使用 CAS 进行原子更新时可能出现的 ABA 问题。
- `AtomicMarkableReference` ：原子更新带有标记位的引用类型

**对象的属性修改类型**

- `AtomicIntegerFieldUpdater`：原子更新整形字段的更新器
- `AtomicLongFieldUpdater`：原子更新长整形字段的更新器
- `AtomicReferenceFieldUpdater`：原子更新引用类型字段的更新器

#### 讲讲 AtomicInteger 的使用

**AtomicInteger 类常用方法**

```
public final int get() //获取当前的值
public final int getAndSet(int newValue)//获取当前的值，并设置新的值
public final int getAndIncrement()//获取当前的值，并自增
public final int getAndDecrement() //获取当前的值，并自减
public final int getAndAdd(int delta) //获取当前的值，并加上预期的值
boolean compareAndSet(int expect, int update) //如果输入的数值等于预期值，则以原子方式将该值设置为输入值（update）
public final void lazySet(int newValue)//最终设置为newValue,使用 lazySet 设置之后可能导致其他线程在之后的一小段时间内还是可以读到旧的值。
```

#### 能不能给我简单介绍一下 AtomicInteger 类的原理

AtomicInteger 线程安全原理简单分析

AtomicInteger 类的部分源码：

```
    // setup to use Unsafe.compareAndSwapInt for updates（更新操作时提供“比较并替换”的作用）
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                (AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private volatile int value;
```

AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，从而避免 synchronized 的高开销，执行效率大为提升。

CAS 的原理是拿期望的值和原本的一个值作比较，如果相同则更新成新的值。UnSafe 类的 objectFieldOffset() 方法是一个本地方法，这个方法是用来拿到“原来的值”的内存地址，返回值是 valueOffset。另外 value 是一个 volatile 变量，在内存中可见，因此 JVM 可以保证任何时刻任何线程总能拿到该变量的最新值。

### 虚假唤醒

当一个条件满足时，很多线程都被唤醒了，但是只有其中部分是有用的唤醒，其它的唤醒都是无用功 1.比如说买货，如果商品本来没有货物，突然进了一件商品，这是所有的线程都被唤醒了 ，但是只能一个人买，所以其他人都是假唤醒，获取不到对象的锁

**解决方法**

使用while判断.

### 锁

#### 互斥锁、自旋锁

最底层的两种锁就是「互斥锁和自旋锁」，有很多高级的锁都是基于它们实现的，你可以认为它们是各种锁的地基，所以我们必须清楚它俩之间的区别和应用。

加锁的目的就是保证共享资源在任意时间里，只有一个线程访问，这样就可以避免多线程导致共享数据错乱的问题。

当已经有一个线程加锁后，其他线程加锁则就会失败，互斥锁和自旋锁对于加锁失败后的处理方式是不一样的：

- **互斥锁**加锁失败后，线程会**释放 CPU** ，给其他线程；
- **自旋锁**加锁失败后，线程会**忙等待**，直到它拿到锁；

互斥锁是一种「独占锁」，比如当线程 A 加锁成功后，此时互斥锁已经被线程 A 独占了，只要线程 A 没有释放手中的锁，线程 B 加锁就会失败，于是就会释放 CPU 让给其他线程，**既然线程 B 释放掉了 CPU，自然线程 B 加锁的代码就会被阻塞**。

**对于互斥锁加锁失败而阻塞的现象，是由操作系统内核实现的**。当加锁失败时，内核会将线程置为「睡眠」状态，等到锁被释放后，内核会在合适的时机唤醒线程，当这个线程成功获取到锁后，于是就可以继续执行。

![image-20210316093719841](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210316093719841.png)

所以，互斥锁加锁失败时，会从用户态陷入到内核态，让内核帮我们切换线程，虽然简化了使用锁的难度，但是存在一定的性能开销成本。

那这个开销成本是什么呢？会有**两次线程上下文切换的成本**：

- 当线程加锁失败时，内核会把线程的状态从「运行」状态设置为「睡眠」状态，然后把 CPU 切换给其他线程运行；
- 接着，当锁被释放时，之前「睡眠」状态的线程会变为「就绪」状态，然后内核会在合适的时间，把 CPU 切换给该线程运行。

线程的上下文切换的是什么？当两个线程是属于同一个进程，**因为虚拟内存是共享的，所以在切换时，虚拟内存这些资源就保持不动，只需要切换线程的私有数据、寄存器等不共享的数据。**

**如果你能确定被锁住的代码执行时间很短，就不应该用互斥锁，而应该选用自旋锁，否则使用互斥锁。**

自旋锁是通过 CPU 提供的 `CAS` 函数（*Compare And Swap*），在「用户态」完成加锁和解锁操作，不会主动产生线程上下文切换，所以相比互斥锁来说，会快一些，开销也小一些。

一般加锁的过程，包含两个步骤：

- 第一步，查看锁的状态，如果锁是空闲的，则执行第二步；
- 第二步，将锁设置为当前线程持有；

CAS 函数就把这两个步骤合并成一条硬件级指令，形成**原子指令**，这样就保证了这两个步骤是不可分割的，要么一次性执行完两个步骤，要么两个步骤都不执行。

使用自旋锁的时候，当发生多线程竞争锁的情况，加锁失败的线程会「忙等待」，直到它拿到锁。这里的「忙等待」可以用 `while` 循环等待实现，不过最好是使用 CPU 提供的 `PAUSE` 指令来实现「忙等待」，因为可以减少循环等待时的耗电量。

自旋锁是最比较简单的一种锁，一直自旋，利用 CPU 周期，直到锁可用。**需要注意，在单核 CPU 上，需要抢占式的调度器（即不断通过时钟中断一个线程，运行其他线程）。否则，自旋锁在单 CPU 上无法使用，因为一个自旋的线程永远不会放弃 CPU。**

#### 读写锁

读优先锁期望的是，读锁能被更多的线程持有，以便提高读线程的并发性，它的工作方式是：当读线程 A 先持有了读锁，写线程 B 在获取写锁的时候，会被阻塞，并且在阻塞过程中，后续来的读线程 C 仍然可以成功获取读锁，最后直到读线程 A 和 C 释放读锁后，写线程 B 才可以成功获取读锁。如下图：

写优先锁是优先服务写线程，其工作方式是：当读线程 A 先持有了读锁，写线程 B 在获取写锁的时候，会被阻塞，并且在阻塞过程中，后续来的读线程 C 获取读锁时会失败，于是读线程 C 将被阻塞在获取读锁的操作，这样只要读线程 A 释放读锁后，写线程 B 就可以成功获取读锁。

都会造成饿死现象。

**公平读写锁比较简单的一种方式是：用队列把获取锁的线程排队，不管是写线程还是读线程都按照先进先出的原则加锁即可，这样读线程仍然可以并发，也不会出现「饥饿」的现象。**

#### 乐观锁和悲观锁

互斥锁、自旋锁、读写锁，都是属于悲观锁。

悲观锁做事比较悲观，它认为**多线程同时修改共享资源的概率比较高，于是很容易出现冲突，所以访问共享资源前，先要上锁**。

那相反的，如果多线程同时修改共享资源的概率比较低，就可以采用乐观锁。

乐观锁做事比较乐观，它假定冲突的概率很低，它的工作方式是：**先修改完共享资源，再验证这段时间内有没有发生冲突，如果没有其他线程在修改资源，那么操作完成，如果发现有其他线程已经修改过这个资源，就放弃本次操作**。

这里举一个场景例子：在线文档。

我们都知道在线文档可以同时多人编辑的，如果使用了悲观锁，那么只要有一个用户正在编辑文档，此时其他用户就无法打开相同的文档了，这用户体验当然不好了。

那实现多人同时编辑，实际上是用了乐观锁，它允许多个用户打开同一个文档进行编辑，编辑完提交之后才验证修改的内容是否有冲突。

怎么样才算发生冲突？这里举个例子，比如用户 A 先在浏览器编辑文档，之后用户 B 在浏览器也打开了相同的文档进行编辑，但是用户 B 比用户 A 提交改动，这一过程用户 A 是不知道的，当 A 提交修改完的内容时，那么 A 和 B 之间并行修改的地方就会发生冲突。

服务端要怎么验证是否冲突了呢？通常方案如下：

- 由于发生冲突的概率比较低，所以先让用户编辑文档，但是浏览器在下载文档时会记录下服务端返回的文档版本号；
- 当用户提交修改时，发给服务端的请求会带上原始文档版本号，服务器收到后将它与当前版本号进行比较，如果版本号一致则修改成功，否则提交失败。

实际上，我们常见的 SVN 和 Git 也是用了乐观锁的思想，先让用户编辑代码，然后提交的时候，通过版本号来判断是否产生了冲突，发生了冲突的地方，需要我们自己修改后，再重新提交。

乐观锁虽然去除了加锁解锁的操作，但是一旦发生冲突，重试的成本非常高，所以**只有在冲突概率非常低，且加锁成本非常高的场景时，才考虑使用乐观锁。**

### AQS

`AQS`中 维护了一个`volatile int state`（代表共享资源）和一个`FIFO`线程等待队列（多线程争用资源被阻塞时会进入此队列）。

这里`volatile`能够保证多线程下的可见性，当`state=1`则代表当前对象锁已经被占有，其他线程来加锁时则会失败，加锁失败的线程会被放入一个`FIFO`的等待队列中，比列会被`UNSAFE.park()`操作挂起，等待其他获取锁的线程释放锁才能够被唤醒。

另外`state`的操作都是通过`CAS`来保证其并发修改的安全性。

#### 抢占锁成功

```java
static final class NonfairSync extends Sync {
    
    final void lock() {
        if (compareAndSetState(0, 1))
            setExclusiveOwnerThread(Thread.currentThread());
        else
            acquire(1);
    }

    protected final boolean tryAcquire(int acquires) {
        return nonfairTryAcquire(acquires);
    }
}
```

这里使用的**ReentrantLock非公平锁**，线程进来直接利用`CAS`尝试抢占锁，如果抢占成功`state`值回被改为1，且设置对象独占锁线程为当前线程。如下所示：

#### 抢占锁失败

我们按照真实场景来分析，**线程一**抢占锁成功后，`state`变为1，**线程二**通过`CAS`修改`state`变量必然会失败。此时`AQS`中`FIFO`(First In First Out 先进先出)队列中数据如图所示：

![image-20210316151322009](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210316151322009.png)

我们将**线程二**执行的逻辑一步步拆解来看：

`java.util.concurrent.locks.AbstractQueuedSynchronizer.acquire()`:

```java
public final void acquire(int arg) {
    if (!tryAcquire(arg) &&
        acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
        selfInterrupt();
}
```

首先执行`tryAcquire()`，会获取`state`的值，如果不为0则说明当前对象的锁已经被其他线程所占有，接着判断占有锁的线程是否为当前线程，如果是则累加`state`值，这就是可重入锁的具体实现，累加`state`值，释放锁的时候也要依次递减`state`值。

如果`state`为0，则执行`CAS`操作，尝试更新`state`值为1，如果更新成功则代表当前线程加锁成功。

以**线程二**为例，因为**线程一**已经将`state`修改为1，所以**线程二**通过`CAS`修改`state`的值不会成功。加锁失败。

**线程二**执行`tryAcquire()`后会返回false，接着执行`addWaiter(Node.EXCLUSIVE)`逻辑，将自己加入到一个`FIFO`等待队列中.

首先会创建一个和当前线程绑定的`Node`节点，`Node`为双向链表。此时等待对内中的`tail`指针为空，直接调用`enq(node)`方法将当前线程加入等待队列尾部.

enq:第一遍循环时`tail`指针为空，进入if逻辑，使用`CAS`操作设置`head`指针，将`head`指向一个新创建的`Node`节点。此时`AQS`中数据：

然后执行`acquireQueued()`,这个方法会先判断当前传入的`Node`对应的前置节点是否为`head`，如果是则尝试加锁。加锁成功过则将当前节点设置为`head`节点，然后空置之前的`head`节点，方便后续被垃圾回收掉。

如果加锁失败或者`Node`的前置节点不是`head`节点，就会通过`shouldParkAfterFailedAcquire`方法 将`head`节点的`waitStatus`变为了`SIGNAL=-1`，最后执行`parkAndChecknIterrupt`方法，调用`LockSupport.park()`挂起当前线程。

#### 释放锁

```java
public final boolean release(int arg) {
    if (tryRelease(arg)) {
        Node h = head;
        if (h != null && h.waitStatus != 0)
            unparkSuccessor(h);
        return true;
    }
    return false;
}
```

这里首先会执行`tryRelease()`方法，这个方法具体实现在`ReentrantLock`中，如果`tryRelease`执行成功，则继续判断`head`节点的`waitStatus`是否为0，前面我们已经看到过，`head`的`waitStatue`为`SIGNAL(-1)`，这里就会执行`unparkSuccessor()`方法来唤醒`head`的后置节点，也就是我们上面图中**线程二**对应的`Node`节点。

执行完`ReentrantLock.tryRelease()`后，`state`被设置成0，Lock对象的独占锁被设置为null。

接着执行`java.util.concurrent.locks.AbstractQueuedSynchronizer.unparkSuccessor()`方法，唤醒`head`的后置节点：

这里主要是将`head`节点的`waitStatus`设置为0，然后解除`head`节点`next`的指向，使`head`节点空置，等待着被垃圾回收。

此时重新将`head`指针指向**线程二**对应的`Node`节点，且使用`LockSupport.unpark`方法来唤醒**线程二**。

被唤醒的**线程二**会接着尝试获取锁，用`CAS`指令修改`state`数据。

**以上是非公平锁抢占方式**

#### 公平锁抢占：

公平锁在加锁的时候，会先判断`AQS`等待队列中是存在节点，如果存在节点则会直接入队等待

```java
protected final boolean tryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();
    if (c == 0) {
        if (!hasQueuedPredecessors() &&
            compareAndSetState(0, acquires)) {
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    else if (current == getExclusiveOwnerThread()) {
        int nextc = c + acquires;
        if (nextc < 0)
            throw new Error("Maximum lock count exceeded");
        setState(nextc);
        return true;
    }
    return false;
}
```

这里会先判断`state`值，如果不为0且获取锁的线程不是当前线程，直接返回false代表获取锁失败，被加入等待队列。如果是当前线程则可重入获取锁。

如果`state=0`则代表此时没有线程持有锁，执行`hasQueuedPredecessors()`判断`AQS`等待队列中是否有元素存在，如果存在其他等待线程，那么自己也会加入到等待队列尾部，做到真正的先来后到，有序加锁。

#### 非公平锁和公平锁

**非公平锁**和**公平锁**的区别：**非公平锁**性能高于**公平锁**性能。**非公平锁**可以减少`CPU`唤醒线程的开销，整体的吞吐效率会高点，`CPU`也不必取唤醒所有线程，会减少唤起线程的数量

**非公平锁**性能虽然优于**公平锁**，但是会存在导致**线程饥饿**的情况。在最坏的情况下，可能存在某个线程**一直获取不到锁**。不过相比性能而言，饥饿问题可以暂时忽略，这可能就是`ReentrantLock`默认创建非公平锁的原因之一了。



### ThreadLocal

通常情况下，我们创建的变量是可以被任何一个线程访问并修改的。**如果想实现每一个线程都有自己的专属本地变量该如何解决呢？** **`ThreadLocal`类主要解决的就是让每个线程绑定自己的值，可以将`ThreadLocal`类形象的比喻成存放数据的盒子，盒子中可以存储每个线程的私有数据。**

**如果你创建了一个`ThreadLocal`变量，那么访问这个变量的每个线程都会有这个变量的本地副本，这也是`ThreadLocal`变量名的由来。他们可以使用 `get（）` 和 `set（）` 方法来获取默认值或将其值更改为当前线程所存的副本的值，从而避免了线程安全问题。**

#### ThreadLocal 原理

从 `Thread`类源代码入手。

```
public class Thread implements Runnable {
 ......
//与此线程有关的ThreadLocal值。由ThreadLocal类维护
ThreadLocal.ThreadLocalMap threadLocals = null;

//与此线程有关的InheritableThreadLocal值。由InheritableThreadLocal类维护
ThreadLocal.ThreadLocalMap inheritableThreadLocals = null;
 ......
}
```

从上面`Thread`类 源代码可以看出`Thread` 类中有一个 `threadLocals` 和 一个 `inheritableThreadLocals` 变量，它们都是 `ThreadLocalMap` 类型的变量,我们可以把 `ThreadLocalMap` 理解为`ThreadLocal` 类实现的定制化的 `HashMap`。默认情况下这两个变量都是 null，只有当前线程调用 `ThreadLocal` 类的 `set`或`get`方法时才创建它们，实际上调用这两个方法的时候，我们调用的是`ThreadLocalMap`类对应的 `get()`、`set()`方法。

`ThreadLocal`类的`set()`方法

```
    public void set(T value) {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null)
            map.set(this, value);
        else
            createMap(t, value);
    }
    ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;
    }
```

通过上面这些内容，我们足以通过猜测得出结论：**最终的变量是放在了当前线程的 `ThreadLocalMap` 中，并不是存在 `ThreadLocal` 上，`ThreadLocal` 可以理解为只是`ThreadLocalMap`的封装，传递了变量值。** `ThrealLocal` 类中可以通过`Thread.currentThread()`获取到当前线程对象后，直接通过`getMap(Thread t)`可以访问到该线程的`ThreadLocalMap`对象。

**每个`Thread`中都具备一个`ThreadLocalMap`，而`ThreadLocalMap`可以存储以`ThreadLocal`为 key ，Object 对象为 value 的键值对。**

```
ThreadLocalMap(ThreadLocal<?> firstKey, Object firstValue) {
 ......
}
```

比如我们在同一个线程中声明了两个 `ThreadLocal` 对象的话，会使用 `Thread`内部都是使用仅有那个`ThreadLocalMap` 存放数据的，`ThreadLocalMap`的 key 就是 `ThreadLocal`对象，value 就是 `ThreadLocal` 对象调用`set`方法设置的值。

#### ThreadLocal 内存泄露问题

`ThreadLocalMap` 中使用的 key 为 `ThreadLocal` 的弱引用,而 value 是强引用。所以，如果 `ThreadLocal` 没有被外部强引用的情况下，在垃圾回收的时候，key 会被清理掉，而 value 不会被清理掉。这样一来，`ThreadLocalMap` 中就会出现 key 为 null 的 Entry。假如我们不做任何措施的话，value 永远无法被 GC 回收，这个时候就可能会产生内存泄露。ThreadLocalMap 实现中已经考虑了这种情况，在调用 `set()`、`get()`、`remove()` 方法的时候，会清理掉 key 为 null 的记录。使用完 `ThreadLocal`方法后 最好手动调用`remove()`方法

```
      static class Entry extends WeakReference<ThreadLocal<?>> {
            /** The value associated with this ThreadLocal. */
            Object value;

            Entry(ThreadLocal<?> k, Object v) {
                super(k);
                value = v;
            }
        }
```

### 线程池`ThreadPoolExecutor`

**线程池的好处**：

- **降低资源消耗**。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
- **提高响应速度**。当任务到达时，任务可以不需要的等到线程创建就能立即执行。
- **提高线程的可管理性**。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。

**`ThreadPoolExecutor` 3 个最重要的参数：**

- **`corePoolSize` :** 核心线程数线程数定义了最小可以同时运行的线程数量。
- **`maximumPoolSize` :** 当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
- **`workQueue`:** 当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中。

`ThreadPoolExecutor`其他常见参数:

1. **`keepAliveTime`**:当线程池中的线程数量大于 `corePoolSize` 的时候，如果这时没有新的任务提交，核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 `keepAliveTime`才会被回收销毁；
2. **`unit`** : `keepAliveTime` 参数的时间单位。
3. **`threadFactory`** :executor 创建新线程的时候会用到。
4. **`handler`** :饱和策略。

#### BlockingQueue

* 有界队列：ArrayBlockingQueue
* 无界队列：LinkedBlockingQueue
* 同步移交队列：SynchronousQueue
* 优先级队列：PriorityBlockingQueue
* 延迟队列：DelayedWorkQueue

#### ThreadFactory 线程工厂

ThreadFactory 主要用于创建新线程对象，使用线程工厂就无需再手工编写对 new Thread 的调用了。

- 对于区分业务的线程池，就可以用到到命名线程工厂的实现，针对不同线程池资源定义不同的线程名
- 或者设置一个创建守护线程的线程工厂。

优点：

- 很容易改变的类创建的对象或我们创建这些对象的方式。
- 很容易用有限的资源限制的创建对象，例如,我们只能有N个对象。
- 很容易生成统计数据对创建的对象。

#### `ThreadPoolExecutor` 饱和策略

**`ThreadPoolExecutor` 饱和策略定义:**

如果当前同时运行的线程数量达到最大线程数量并且队列也已经被放满了任时，`ThreadPoolTaskExecutor` 定义一些策略:

- **`ThreadPoolExecutor.AbortPolicy`**：抛出 `RejectedExecutionException`来拒绝新任务的处理。
- **`ThreadPoolExecutor.CallerRunsPolicy`**：调用执行自己的线程运行任务，也就是直接在调用`execute`方法的线程中运行(`run`)被拒绝的任务，如果执行程序已关闭，则会丢弃该任务。因此这种策略会降低对于新任务提交速度，影响程序的整体性能。如果您的应用程序可以承受此延迟并且你要求任何一个任务请求都要被执行的话，你可以选择这个策略。
- **`ThreadPoolExecutor.DiscardPolicy`：** 不处理新任务，直接丢弃掉。
- **`ThreadPoolExecutor.DiscardOldestPolicy`：** 此策略将丢弃最早的未处理的任务请求。

### 面试题

#### wait和sleep

- 两者最主要的区别在于：**`sleep()` 方法没有释放锁，而 `wait()` 方法释放了锁** 。
- 两者都可以暂停线程的执行。
- `wait()` 通常被用于线程间交互/通信，`sleep() `通常被用于暂停执行。
- `wait()` 方法被调用后，线程不会自动苏醒，需要别的线程调用同一个对象上的 `notify() `或者 `notifyAll()` 方法。`sleep() `方法执行完成后，线程会自动苏醒。或者可以使用 `wait(long timeout)` 超时后线程会自动苏醒。
- wait是Object中的方法，而sleep则是Thread中的方法。
- sleep可以在任何地方使用，而wait只可以在synchronized方法或synchronized块中使用。

#### start和run

**start() :**

它的作用是启动一个新线程。

**run() :**

run()就和普通的成员方法一样，可以被重复调用。

https://m.nowcoder.com/discuss/619967



## 数据库——mysql

### mysql基本架构

![image](https://github.com/rbmonster/learning-note/raw/master/src/main/java/com/learning/mysql/picture/mysqlprocess.jpg)

MySQL可以分为Server层和存储引擎层两部分

- Server层包括连接器、查询缓存、分析器、优化器、执行器等，涵盖MySQL的大多数核心服务功能，以及所有的内置函数（如日期、时间、数学和加密函数等），所有跨存储引擎的功能都在这一层实现，比如存储过程、触发器、视图等。
- 存储引擎层负责数据的存储和提取。其架构模式是插件式的，支持InnoDB、MyISAM、Memory等多个存储引擎。现在最常用的存储引擎是InnoDB，它从MySQL5.5.5版本开始成为了默认存储引擎

数据库执行流程：

1. 连接器：登陆数据库的连接验证，完成经典的TCP握手后，连接器就要开始认证你的身份。 `mysql -h$ip -P$port -u$user -p`

2. 查询缓存：连接建立完成之后，会到查询缓存中查询数据。查询缓存的存储默认key为查询语句，而value为结果。查询缓存弊大于利，因为只要有表更新，这个表相关的缓存就会被清除。

3. 分析器：主要做语法解析，并判断语法是否合规。

4. 优化器：对语法的执行流程进行优化，决定使用哪个索引。

   - `mysql> select * from t1 join t2 using(ID) where t1.c=10 and t2.d=20;`

   - > 既可以先从表t1里面取出c=10的记录的ID值，再根据ID值关联到表t2，再判断t2里面d的值是否等于20。也可以先从表t2里面取出d=20的记录的ID值，再根据ID值关联到t1，再判断t1里面c的值是否等于10。 这两种执行方法的逻辑结果是一样的，但是执行的效率会有不同，而优化器的作用就是决定选择效率高的方案。

5. 执行器: 负责具体语句的执行，首先判断是否有权限。

   ```
   mysql> select * from T where ID=10;
   ```

   - > - 比如我们这个例子中的表T中，ID字段没有索引，那么执行器的执行流程是这样的：
     > - 1.调用InnoDB引擎接口取这个表的第一行，判断ID值是不是10，如果不是则跳过，如果是则将这行存在结果集中；
     > - 2.调用引擎接口取“下一行”，重复相同的判断逻辑，直到取到这个表的最后一行。
     > - 3.执行器将上述遍历过程中所有满足条件的行组成的记录集作为结果集返回给客户端。

### 索引

索引的出现其实就是为了提高数据查询的效率， 就像书的目录一样。 一本500页的书，对于数据库的表而言， 索引其实就是它的“目录”。

- > 若一张表中无主键索引，mysql会默认创建一个长度为6字节的rowid主键。

#### 主键索引、唯一索引、普通索引

索引分类：唯一索引，主键（聚集）索引，非聚集索引(普通索引)

**主键索引与普通索引区别**

1. 一个表中只能有一个主键索引，但是可以有多个普通索引
2. 主键(聚集)索引存储记录是物理上连续存在，而非聚集索引是逻辑上的连续，物理存储并不连续
3. 查询区别：主要在于若执行的查询中需要较多的信息，普通索引会执行回表操作。

- 如果语句是select * from T where ID=500， 即主键查询方式， 则只需要搜索ID这棵B+树。
- 如果语句是select * from T where k=5， 即普通索引查询方式， 则需要先搜索k索引树， 得到ID的值为500， 再到ID索引树搜索一次。 这个过程称为回表。 回到主键索引树搜索的过程， 我们称为**回表**。

**唯一索引与普通索引**

1. 两者查询性能差不多。
2. 主要区别在于，更新的记录目标页不在内存中时。普通索引更新会使用change Buffer。唯一索引，由于需要校验数据的唯一性，因此每次更新操作都需要读磁盘把数据载进内存，涉及IO操作。

- 在不影响数据一致性的前提下， InooDB会将这些更新操作缓存在change buffer中， 这样就不需要从磁盘中读入这个数据页了。 在下次查询需要访问这个数据页的时候， 将数据页读入内存， 然后执行change buffer中与这个页有关的操作。 通过这种方式就能保证这个数据逻辑的正确性

> change buffer中的操作应用到原数据页， 得到最新结果的过程称为merge。
>
> 1. 访问这个数据页会触发merge。
> 2. 系统有后台线程会定期merge。
> 3. 在数据库正常关闭（shutdown） 的过程中，也会执行merge操作。

change Buffer与redo log 区别

- change Buffer主要用于减少读磁盘的次数，在必要读磁盘时再更新数据。
- redo log 则是减少内存更新后，写磁盘的次数。

#### 索引数据结构

InnoDB里面索引对应一棵B+树

**B树**

B树和平衡二叉树稍有不同的是，B树属于多叉树又名平衡多路查找树

- 树中每个节点最多包含m个孩子。
- 除根节点与叶子节点外，每个节点至少有[ceil(m/2)]个孩子（ceil()为向上取整）。
- 若根节点不是叶子节点，则至少有两个孩子。
- 所有的叶子节点都在同一层。
- 每个非叶子节点由n个key与n+1个指针组成，其中[ceil(m/2)-1] <= n <= m-1 。

![image-20210310193214117](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210310193214117.png)

这是一个3叉（只是举例，真实会有很多叉）的BTree结构图，每一个方框块我们称之为一个磁盘块或者叫做一个block块，这是操作系统一次IO往内存中读的内容，一个块对应四个扇区，紫色代表的是磁盘块中的数据key，黄色代表的是数据data，蓝色代表的是指针p，指向下一个磁盘块的位置。

来模拟下查找key为29的data的过程：

1、根据根结点指针读取文件目录的根磁盘块1。【磁盘IO操作**1次**】

2、磁盘块1存储17，35和三个指针数据。我们发现17<29<35，因此我们找到指针p2。

3、根据p2指针，我们定位并读取磁盘块3。【磁盘IO操作**2次**】

4、磁盘块3存储26，30和三个指针数据。我们发现26<29<30，因此我们找到指针p2。

5、根据p2指针，我们定位并读取磁盘块8。【磁盘IO操作**3次**】

6、磁盘块8中存储28，29。我们找到29，获取29所对应的数据data。

> 由此可见，BTree索引使每次磁盘I/O取到内存的数据都发挥了作用，从而提高了查询效率。

**B+树**

与B树的区别

1. 非叶子节点不保存关键字记录的指针，只进行数据索引，这样使得B+树每个非叶子节点所能保存的关键字大大增加；
2. 叶子节点保存了父节点的所有关键字记录的指针，所有数据地址必须要到叶子节点才能获取到。所以每次数据查询的次数都一样；
3. B+树叶子节点的关键字从小到大有序排列，左边结尾数据都会保存右边节点开始数据的指针。
4. 非叶子节点的子节点数=关键字数（节点里面的关键字）

特点

1. B+树的层级更少：相较于B树B+每个非叶子节点存储的关键字数更多，同样大小的磁盘页可以容纳更多的节点元素。树的层级更少所以查询数据更快。（非叶子节点不保存数据）
2. B+树查询速度更稳定：每次查找都要找到子节点
3. B+树天然具备排序功能：B+树所有的叶子节点数据构成了一个有序链表，在查询大小区间的数据时候更方便，数据紧密性很高，缓存的命中率也会比B树高

>  **为什么使用B+树数据结构**

使用B+树而不是二叉搜索树或者红黑树的原因是，由于存储介质的特性，磁盘本身存取就比主存慢很多，每次搜索的磁盘IO的开销过大，而B+树可以使用较少次的磁盘IO搜索到对象。

- B-Tree中一次检索最多需要h-1次I/O（根节点常驻内存），渐进复杂度为O(h)=O(logdN)。
- 红黑树这种结构，h明显要深的多。效率明显比B-Tree差很多。

#### 索引规则

**覆盖索引**

InnoDB存储引擎支持覆盖索引，即从辅助索引中就可以得到查询的记录，而不需要查询聚集索引中的记录。

- 如： `select id, b from t where b = xxx (id为主键，b为索引)` 由于覆盖索引可以减少树的搜索次数（减少IO）， 显著提升查询性能， 所以使用覆盖索引是一个常用的性能优化手段。

sql select * from table where name = '丙丙'

执行的流程是先查询到name索引上的“丙丙”，然后找到他的id是2，最后去主键索引，找到id为2对应的值。

回到主键索引树搜索的过程，就是**回表**。不过也有方法避免回表，那就是**覆盖索引**。

刚才我们是 select * ，查询所有的，我们如果只查询ID那，其实在Name字段的索引上就已经有了，那就不需要回表了。

覆盖索引可以减少树的搜索次数，提升性能，他也是我们在实际开发过程中经常用来优化查询效率的手段。

很多联合索引的建立，就是为了支持覆盖索引，特定的业务能极大的提升效率。

**最左前缀匹配原则**

在MySQL建立联合索引时会遵守最左前缀匹配原则，即最左优先，在检索数据时从联合索引的最左边开始匹配。

举例：创建一个（a,b）的联合索引，那么它的索引树就是下图的样子。

![img](https://img2020.cnblogs.com/blog/1804577/202005/1804577-20200521182659976-48843100.png)

可以看到a的值是有顺序的，1，1，2，2，3，3，而b的值是没有顺序的1，2，1，4，1，2。但是我们又可发现a在等值的情况下，b值又是按顺序排列的，但是这种顺序是相对的。这是因为MySQL创建联合索引的规则是首先会对联合索引的最左边第一个字段排序，在第一个字段的排序基础上，然后在对第二个字段进行排序。所以b=2这种查询条件没有办法利用索引。

索引只能用于查找key是否**存在（相等）**，遇到范围查询 (>、<、between、like左匹配)等就**不能进一步匹配**了，后续退化为线性查找。

**索引下推**

在开始之前先先准备一张用户表(user)，其中主要几个字段有：id、name、age、address。建立联合索引（name，age）。

- 假设有一个需求，要求匹配姓名第一个为陈的所有用户，sql语句如下：

```sql
SELECT * from user where  name like '陈%'
```

- 根据 "最佳左前缀" 的原则，这里使用了联合索引（name，age）进行了查询，性能要比全表扫描肯定要高。
- 问题来了，如果有其他的条件呢？假设又有一个需求，要求匹配姓名第一个字为陈，年龄为20岁的用户，此时的sql语句如下：

```sql
SELECT * from user where  name like '陈%' and age=20
```

- 这条sql语句应该如何执行呢？下面对Mysql5.6之前版本和之后版本进行分析。

**Mysql5.6之前的版本**

- 5.6之前的版本是没有索引下推这个优化的，因此执行的过程如下图：

![img](https://pic3.zhimg.com/80/v2-04b4a496ab53eccc5feba150bf9fb7ea_720w.jpg)

会忽略age这个字段，直接通过name进行查询，在(name,age)这课树上查找到了两个结果，id分别为2,1，然后拿着取到的id值一次次的回表查询，因此这个过程需要**回表两次**。

**Mysql5.6及之后版本**

- 5.6版本添加了索引下推这个优化，执行的过程如下图：

![img](https://pic1.zhimg.com/80/v2-211aaba883221c81d5d7578783a80764_720w.jpg)

InnoDB并没有忽略age这个字段，而是在索引内部就判断了age是否等于20，对于不等于20的记录直接跳过，因此在(name,age)这棵索引树中只匹配到了一个记录，此时拿着这个id去主键索引树中回表查询全部数据，这个过程只需要回表一次。

- 索引遍历过程中，对**索引中包含的字段先做判断**，直接过滤掉不满足条件的记录，减少回表次数
- 旧版本中会进行回表操作，取得相关信息再做判断。

**导致索引失效情况**

1. where语句中包含or时，可能会导致索引失效。

   - > 若or的条件中包含非索引，就会只用全表扫描的。如果or的条件两边都是索引，那么会使用index_merge的优化技术。

2. where语句中索引列使用了负向查询，可能会导致索引失效

   - > 负向查询包括：NOT、!=、<>、!<、!>、NOT IN、NOT LIKE等。

3. 对索引列进行运算，一定会导致索引失效

   - > EXPLAIN SELECT * from container_load where materiel_id+1 = 152899293852729344

4. 在索引列上使用内置函数，一定会导致索引失效

   - `EXPLAIN SELECT *, SUBSTR(materiel_id,10) from container_load where SUBSTR(materiel_id,10) = 852729344`

5. like通配符可能会导致索引失效，未满足最左匹配原则。

6. 隐式类型转换导致的索引失效，如索引列user_id为varchar类型，使用int做条件关联。或者关联表字符集编码不一致。

7. 索引字段可以为null，使用is null或is not null时，可能会导致索引失效

   - 默认为Null的列，存在Null值会导致mysql优化器处理起来比较复杂,当命中结果数量小于40%的时候,会走索引。

8. 联合索引未满足最左匹配原则

   - > (k1,k2,k3)，相当于创建了(k1)、(k1,k2)和(k1,k2,k3)三个索引

### undo log, redo log, binlog

#### undo log与MVCC

undo log主要有两个作用：回滚和多版本控制(MVCC)

在数据修改的时候，不仅记录了redo log，还记录undo log，如果因为某些原因导致事务失败或回滚了，可以用undo log进行回滚

undo log主要存储的也是逻辑日志，比如我们要insert一条数据了，那undo log会记录的一条对应的delete日志。我们要update一条记录时，它会记录一条对应相反的update记录。

**MVCC**

内部使用的一致性读快照称为Read View，在不同的隔离级别下，事务启动时或者SQL语句开始时，看到的数据快照版本可能也不同，在RR、RC隔离级别下会用到 Read view。MVCC 使用到的快照存储在 Undo 日志中，该日志通过回滚指针把一个数据行（Record）的所有快照连接起来。

> 当执行sql语句的时候会创建一致性视图，保证在本事务中可以做到可重复读。

实现机制：InnoDB在每行数据都增加三个隐藏字段，一个唯一行号，一个记录DB_TRX_ID事务id，一个记录DB_ROLL_PTR回滚指针。

- 创建版本号：insert操作时事务的id
- 删除版本号：insert时为null，删除时为当前事务的id 当读操作时，读取的是删除版本号为null，或者创建版本号最大的数据，保证我们读取的是最新的数据

**SELECT**

多个事务必须读取到同一个数据行的快照，并且这个快照是距离现在最近的一个有效快照。

**INSERT**

将当前系统版本号作为数据行快照的创建版本号。

**DELETE**

将当前系统版本号作为数据行快照的删除版本号。

**UPDATE**

将当前系统版本号作为更新前的数据行快照的删除版本号，并将当前系统版本号作为更新后的数据行快照的创建版本号。可以理解为先执行 DELETE 后执行 INSERT。

#### redo log

MySQL里经常说到的WAL技术，WAL的全称是WriteAheadLogging，它的关键点就是先写日志，再写磁盘，也就是先写粉板，等不忙的时候再写账本。

- 当有一条记录需要更新的时候， InnoDB引擎就会先把记录写到redo log（粉板） 里面， 并更新内存， 这个时候更新就算完成了。 同时， InnoDB引擎会在适当的时候， 将这个操作记录更新到磁盘里面， 而这个更新往往是在系统比较空闲的时候做， 这就像打烊以后掌柜做的事。(由于磁盘连接开销大，)

- InnoDB的redo log是固定大小的， 比如可以配置为一组4个文件， 每个文件的大小是1GB， 那么这块“粉板”总共就可以记录4GB的操作。 从头开始写， 写到末尾就又回到开头循环写， 如下面这个图所示

  ![redologwrite](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\redologwrite.jpg)

  redo log buffer ：redo log buffer就是一块内存， 用来先存redo日志的。 在执行事务的时候，如insert、update会先存在buffer中。等事务commit，再一起写入redo log

InnoDB写盘的三种情况：

1. InnoDB有一个后台线程， 每隔1秒， 就会把redo log buffer中的日志， 调用write写到文件系统的page cache， 然后调用fsync持久化到磁盘。
2. redo log buffer占用的空间即将达到 innodb_log_buffer_size一半的时候，后台线程会主动写盘。
3. 并行的事务提交的时候， 顺带将这个事务的redo log buffer持久化到磁盘。

#### binlog

MySQL整体来看， 其实就有两块： 一块是Server层， 它主要做的是MySQL功能层面的事情； 还有一块是引擎层， 负责存储相关的具体事宜。 上面我们聊到的粉板redo log是InnoDB引擎特有的日志， 而Server层也有自己的日志， 称为binlog（归档日志） 。

![binlogwrite](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\binlogwrite.jpg)

每个线程有自己binlog cache， 但是共用同一份binlog文件。

1. 图中的write， 指的就是指把日志写入到文件系统的page cache， 并没有把数据持久化到磁盘， 所以速度比较快。
2. 图中的fsync， 才是将数据持久化到磁盘的操作。 一般情况下，我们认为fsync才占磁盘的IOPS

bin log 三种数据格式，主要区别于在存储bin log 的格式区别 越来越多的场景要求把MySQL的binlog格式设置成row，有利于恢复数据。

**binlog的作用？（说的是监控，其实主要是主从复制或者备份）**

- 用于复制，在主从复制中，从库利用主库上的binlog进行重播，实现主从同步。
- 用于数据库的基于时间点的还原。

#### 两种日志区别

1. redo log是InnoDB引擎特有的； binlog是MySQL的Server层实现的， 所有引擎都可以使用。
2. redo log是物理日志， 记录的是“在某个数据页上做了什么修改”； binlog是逻辑日志， 记录的是这个语句的原始逻辑， 比如“给ID=2这一行的c字段加1 ”。
3. redo log是循环写的， 空间固定会用完； binlog是可以追加写入的。 “追加写”是指binlog文件写到一定大小后会切换到下一个， 并不会覆盖以前的日志。
4. 事务提交的时候，一次性将事务中的sql语句（一个事物可能对应多个sql语句）按照一定的格式记录到binlog中。这里与redo log很明显的差异就是redo log并不一定是在事务提交的时候刷新到磁盘，redo log是在事务开始之后就开始逐步写入磁盘。

### 事务隔离级别

- `读未提交（READ UNCOMMITTED）`：一个事务还没提交时，它做的变更就能被别的事务看到。
- `读提交（READ COMMITTED）`：一个事务提交之后，它做的变更才会被其他事务看到。
- `可重复读（REPEATABLE READ）`：一个事务执行过程中看到的数据，总是跟这个事务在启动时看到的数据是一致的。当然在可重复读隔离级别下，未提交变更对其他事务也是不可见的。
- `串行化（SERIALIZABLE）`：对于同一行记录，“写”会加“写锁”，“读”会加“读锁”，当出现读写锁冲突的时候，后访问的事务必须等前一个事务执行完成，才能继续执行。

隔离级别解决了哪些问题大家也应该都是知道的分别有：

* `脏读（dirty read）`：如果一个事务读到了另一个未提交事务修改过的数据。
* `不可重复读（non-repeatable read）`：如果一个事务只能读到另一个已经提交的事务修改过的数据，并且其他事务每对该数据进行一次修改并提交后，该事务都能查询得到最新值。
* `幻读（phantom read）`：如果一个事务先根据某些条件查询出一些记录，之后另一个事务又向表中插入了符合这些条件的记录，原先的事务再次按照该条件查询时，能把另一个事务插入的记录也读出来。

> #### 如何解决幻读?

InnoDB引入新的锁， 也就是间隙锁(Gap Lock)。在一行行扫描的过程中， 不仅将给行加上了行锁， 还给行两边的空隙， 也加上了间隙锁。

间隙锁之间的冲突：跟间隙锁存在冲突关系的，是“往这个间隙中插入一个记录”这个操作。 间隙锁之间都不存在冲突关系。

间隙锁和行锁合称next-key lock， 每个next-key lock是前开后闭区间。

- 如果用select * from t for update要把整个表所有记录锁起来， 就形成了7个next-key lock， 分别是 (-∞,0]、 (0,5]、 (5,10]、 (10,15]、 (15,20]、 (20, 25]、 (25, +supremum]。
- InnoDB给每个索引加了一个不存在的最大值supremum。

间隙锁的引入， 可能会导致同样的语句锁住更大的范围， 这其实是影响了并发度的。

### 存储引擎

#### InnoDB

**InnoDB存储引擎架构**

![img](http://img.blog.itpub.net/blog/2019/11/04/5890997c0bb09cf5.jpeg?x-oss-process=style/bb)



#### InnoDB 和 MyIsam 数据库引擎的区别

1. 事务处理：MyISAM是非事务安全型的，而InnoDB是事务安全型的（支持事务处理等高级处理）；
2. 外键支持: mysiam表不支持外键，而InnoDB支持
3. 锁机制不同：MyISAM是表级锁，而InnoDB是行级锁；
4. select查询的区别：
   - count优化： MyISAM只要简单的读出保存好的行数，InnoDB要选择表的索引进而计算行数计算。
   - 缓存区别：InnoDB要缓存数据块，MyISAM只缓存索引，加载索引更快
   - InnoDB要维护MVCC一致
5. 数据存储方式不同：
   - MyISAM索引文件和数据文件是分离的（.myi索引文件和.myd数据文件）
   - InnoDB的数据文件按主键聚集（.idb数据文件）
   - 由于数据存储的方式区别，MyISAM主键索引是非聚簇索引，InnoDB主键索引是聚簇索引；
6. 崩溃恢复，InnoDB特有的redo log 可以保证崩溃安全，

> - DELETE FROM table时，InnoDB不会重新建立表，而是一行一行的删除。
> - 索引的支持:InnoDB不支持FULLTEXT类型的索引
> - InnoDB表的行锁也不是绝对的，假如在执行一个SQL语句时MySQL不能确定要扫描的范围，InnoDB表同样会锁全表，例如update table set num=1 where name like “%aaa%”

应用场景

- MyISAM适合：(1)做很多count 的计算；(2)插入不频繁，查询非常频繁；(3)没有事务。
- InnoDB适合：(1)可靠性要求比较高，或者要求事务；(2)表更新和查询都相当的频繁，并且行锁定的机会比较大的情况。

### 面试问题

#### MySQL 是如何保证一致性、原子性的？

**原子性**

事务被视为不可分割的最小单元，事务的所有操作要么全部成功，要么全部失败回滚。

**一致性**

数据库在事务执行前后都保持一致性状态，在一致性状态下，所有事务对一个数据的读取结果都是相同的。

**隔离性**

一个事务所做的修改在最终提交以前，对其他事务是不可见的。

**持久性**

一旦事务提交，则其所做的修改将会永远保存到数据库中。即使系统发生崩溃，事务执行的结果也不能丢。

##### **保证原子性**

利用Innodb的undo log。undo log名为回滚日志，是实现原子性的关键，当事务回滚时能够撤销所有已经成功执行的sql语句，他需要记录你要回滚的相应日志信息。undo log主要存储的也是逻辑日志，比如我们要insert一条数据了，那undo log会记录的一条对应的delete日志。我们要update一条记录时，它会记录一条对应相反的update记录。当事务执行失败或调用了rollback，导致事务需要回滚，便可以利用undo log中的信息将数据回滚到修改之前的样子。

##### **保证一致性**

- 通过redolog 与binlog 两阶段提交 保证事务一致性。

为确保innodb的redo与MySQL的binlog一致，innodb的事务提交采用了two-phase commit的二阶段提交机制。

所谓二阶段就是指server层写binlog和innodb层写redo的阶段。

##### 两阶段提交是什么？

- prepare阶段：此阶段innodb将事务 trx_id洗入redo_log，将事务状态置为prepare状态

- commit阶段：

  - 写入bin_log
  - 写入redo_log,将事务状态置为commit

  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20201008175019624.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NoZWh1aW5pZGF5ZQ==,size_16,color_FFFFFF,t_70#pic_center)

**1.prepare阶段：**

此阶段负责：

在Innodb层获取独占模式的prepare_commit_mutex，将事务的trx_id写入redo log(redo日志的写机制为WAL所以在事务修改前就会写redo buffer而不是commit时一次性写入)。

**2.commit阶段：**

**2.1：第一步，写binlog**

此阶段调用两个方法write()和fsync()，前者负责将binlog从binlog cache写入文件系统缓存，后者负责将文件系统缓存中的binlog写入disk

关于**sync_binlog**参数:

- sync_binlog=0:表示fsync()的调用完全交给操作系统，即文件系统缓存中的binlog是否刷新到disk完全由操作系统控制。
- sync_binlog=1:表示在发出事务提交请求时，binlog一定会被固化到disk，write()跳过文件系统缓存直接写入disk。
- sync_binlog=N(N>1):数据库崩溃时，可能会丢失N-1个事务。

**2.2：第二步，innodb进行commit**

在Innodb层写入commit flag，调用write和fsync将commit信息的redo写入磁盘，然后释放prepare_commit_mutex。

引擎层将redo log buffer中的redo写入文件系统缓存（write），然后将文件系统缓存中的redo log写入disk(fsync)，写入机制取决于innodb_flush_log_at_trx_commit参数。

innodb_flush_log_at_trx_commit：(默认值为1)

- 此值为0表示：redo log buffer的内容每秒会被写入文件系统缓存的redo log里，同时被flush（固化）到disk上的redo log file中。
- 此值为1表示：redo log buffer的内容会在事务commit时被写入文件系统缓存的redo log里，同时被flush（固化）到disk上的redo log file中。
- 此值为2表示：redo log buffer的内容会在事务commit时被写入文件系统缓存的redo log里，而文件系统缓存的redo log每秒一次被flush（固化）到disk上的redo log file中。

注意redo和undo是在事务执行过程中就即时生成的，且早于数据库真正被修改，这被称作write ahead logging(WAL)。

**故障恢复解读**

**Innodb进行crash recovery时是根据binlog来进行前滚回滚的，只有记录了binlog才会根据redo log前滚或回滚事务。**

crash recovery的流程其实是：先扫描binlog，提取出xid，然后比较redo中checkpoint之后的xid，如果在binlog存在，那么提交，如果不存在那么回滚。

**对于主从复制的影响：**

上面讨论的二阶段日志提交解决了mysql server与innodb层的日志一致性的问题，单实例的情况下最多因为sync_binlog和innodb_flush_log_at_trx_commit的设置问题导致事务丢失，但是对于主从复制事务丢失却是很严重的问题-->主从不一致。

在主从复制的情况下如果innodb_flush_log_at_trx_commit不为1则有可能出现binlog已写但是redo log未写的情况，此时主库崩溃后在事务前滚时会出现找不到redo的情况导致前滚失败，而从库已经应用binlog，导致主从不一致。

而sync_binlog不为1则可能出现主库直接丢失事务的情况。

因此，为保证主从完全一致且事务不丢失，主库的innodb_flush_log_at_trx_commit和sync_binlog都必须设置为1。



#### 读已提交和可重复读是如何实现的

1. ReadView：
   - 当进行查询操作时，事务会生成一个ReadView，ReadView是一个事务快照，准确来说是当前时间点系统内活跃的事务列表，也就是说系统内所有未提交的事务，都会记录在这个Readview内，事务就根据它来判断哪些数据是可见的，哪些是不可见的。
   - 查询一条数据时，事务会拿到这个ReadView，去到undo log中进行判断。若查询到某一条数据：
2. undo log
   - 当事务对数据行进行一次更新操作时，会把旧数据行记录在一个叫做undo log的记录中，在undo log中除了记录数据行，还会记录下该行数据的对应的创建版本号，也就是生成这行数据的事务id。并连接原纪录

#### truncate与drop,delete的对比

上面说过truncate与delete，drop很相似，其实这三者还是与很大的不同的，下面简单对比下三者的异同。

- truncate与drop是DDL语句，执行后无法回滚；delete是DML语句，可回滚。
- truncate只能作用于表；delete，drop可作用于表、视图等。
- truncate会清空表中的所有行，但表结构及其约束、索引等保持不变；drop会删除表的结构及其所依赖的约束、索引等。
- truncate会重置表的自增值；delete不会。
- truncate不会激活与表有关的删除触发器；delete可以。
- truncate后会使表和索引所占用的空间会恢复到初始大小；delete操作不会减少表或索引所占用的空间，drop语句将表所占用的空间全释放掉。

#### truncate使用场景及注意事项

该表数据完全不需要时可以用truncate。如果想删除部分数据用delete，注意带上where子句；如果想删除表，当然用drop；如果想保留表而将所有数据删除且和事务无关，用truncate即可；如果和事务有关，或者想触发trigger，还是用delete；如果是整理表内部的碎片，可以用truncate然后再重新插入数据。

无论怎样，truncate表都是高危操作，特别是在生产环境要更加小心，下面列出几点注意事项，希望大家使用时可以做下参考。

- truncate无法通过binlog回滚。
- truncate会清空所有数据且执行速度很快。
- truncate不能对有外键约束引用的表使用。
- 执行truncate需要drop权限，不建议给账号drop权限。
- 执行truncate前一定要再三检查确认，最好提前备份下表数据。

#### UNION ALL 与 UNION 的区别

- UNION和UNION ALL关键字都是将两个结果集合并为一个。
- UNION在进行表链接后会筛选掉重复的记录，所以在表链接后会对所产生的结果集进行排序运算，删除重复的记录再返回结果。
- 而UNION ALL只是简单的将两个结果合并后就返回。
- 由于UNION需要排序去重，所以 UNION ALL 的效率比 UNION 好很多。



## 操作系统

### 进程

#### 进程和线程有什么区别

- 进程（Process）是系统进行资源分配和调度的基本单位，线程（Thread）是CPU调度和分派的基本单位；
- 线程依赖于进程而存在，一个进程至少有一个线程；
- 进程有自己的独立地址空间，线程共享所属进程的地址空间；
- 进程是拥有系统资源的一个独立单位，而线程自己基本上不拥有系统资源，只拥有一点在运行中必不可少的资源(如程序计数器,一组寄存器和栈)，和其他线程共享本进程的相关资源如内存、I/O、cpu等；
- 在进程切换时，涉及到整个当前进程CPU环境的保存环境的设置以及新被调度运行的CPU环境的设置，而线程切换只需保存和设置少量的寄存器的内容，并不涉及存储器管理方面的操作，可见，进程切换的开销远大于线程切换的开销；
- 线程之间的通信更方便，同一进程下的线程共享全局变量等数据，而进程之间的通信需要以进程间通信(IPC)的方式进行；
- 多线程程序只要有一个线程崩溃，整个程序就崩溃了，但多进程程序中一个进程崩溃并不会对其它进程造成影响，因为进程有自己的独立地址空间，因此多进程更加健壮

#### 进程间通信

![image-20210322141736866](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210322141736866.png)

1. 管道pipe：管道是一种半双工的通信方式，数据只能单向流动，而且只能在具有亲缘关系的进程间使用。进程的亲缘关系通常是指父子进程关系。如果想实现双方通信，那么需要建立两个管道。管道适合于**传输大量信息**。管道发送的内容是以字节为单位的，没有格式的**字节流**。

   * 管道是半双工的，数据只能向一个方向流动；需要双方通信时，需要建立起两个管道。
   * 只能用于父子进程或者兄弟进程之间(具有亲缘关系的进程);
   * 单独构成一种独立的文件系统：管道对于管道两端的进程而言，就是一个文件，但它不是普通的文件，它不属于某种文件系统，而是自立门户，单独构成一种文件系统，并且只存在与内存中。
   * 数据的读出和写入：一个进程向管道中写的内容被管道另一端的进程读出。写入的内容每次都添加在管道缓冲区的末尾，并且每次都是从缓冲区的头部读出数据。

   **管道的实质：** 管道的实质是一个内核缓冲区，进程以先进先出的方式从缓冲区存取数据，管道一端的进程顺序的将数据写入缓冲区，另一端的进程则顺序的读出数据。 该缓冲区可以看做是一个循环队列，读和写的位置都是自动增长的，不能随意改变，一个数据只能被读一次，读出来以后在缓冲区就不复存在了。

   **管道的局限：**
    管道的主要局限性正体现在它的特点上：

   - 只支持单向数据流；
   - 只能用于具有亲缘关系的进程之间；
   - 没有名字；
   - 管道的缓冲区是有限的（管道制存在于内存中，在管道创建时，为缓冲区分配一个页面大小）；

2. 命名管道FIFO：有名管道也是半双工的通信方式，但是它允许无亲缘关系进程间的通信。

   匿名管道，由于没有名字，只能用于亲缘关系的进程间通信。为了克服这个缺点，提出了有名管道(FIFO)。

   有名管道不同于匿名管道之处在于它提供了一个路径名与之关联，**以有名管道的文件形式存在于文件系统中**，这样，**即使与有名管道的创建进程不存在亲缘关系的进程，只要可以访问该路径，就能够彼此通过有名管道相互通信**。

   > **匿名管道和有名管道总结：**
   >  （1）管道是特殊类型的文件，在满足先入先出的原则条件下可以进行读写，但不能进行定位读写。
   >  （2）匿名管道是单向的，只能在有亲缘关系的进程间通信；有名管道以磁盘文件的方式存在，可以实现本机任意两个进程通信。
   >
   >  （3）**无名管道阻塞问题：**无名管道无需显示打开，创建时直接返回文件描述符，在读写时需要确定对方的存在，否则将退出。
   >
   >  （4）**有名管道阻塞问题：**有名管道在打开时需要确实对方的存在，否则将阻塞。即以读方式打开某管道，在此之前必须一个进程以写方式打开管道，否则阻塞。此外，可以以读写（O_RDWR）模式打开有名管道，即当前进程读，当前进程写，不会阻塞。

3. 消息队列MessageQueue：**消息队列是一个消息的链表**，保存在内核中。消息队列中的每个消息都是一个**数据块**，具有特定的格式。操作系统中可以存在多个消息队列，每个消息队列有唯一的 **key**，称为消息队列标识符。消息队列克服了信号传递信息少、管道只能承载无格式字节流以及缓冲区大小受限等缺点。

   消息队列允许一个或多个进程向它写入与读取消息。消息的发送者和接收者不需要同时与消息队列交互。消息会保存在队列中，直到接收者取回它。也就是说，消息队列是异步的，但这也造成了一个缺点，就是接收者必须**轮询**消息队列，才能收到最近的消息。

   

4. 共享存储SharedMemory：共享内存就是映射一段能被其他进程所访问的内存，这段共享内存由一个进程创建，但多个进程都可以访问。共享内存是最快的 IPC 方式，原因是不需要系统调用，不涉及用户态到内核态的转换，也不需要对数据不必要的复制。它是针对其他进程间通信方式运行效率低而专门设计的。它往往与其他通信机制，如信号量，配合使用，来实现进程间的同步和通信。**共享内存的缺点是存在并发问题**，有可能出现多个进程修改同一块内存，因此共享内存一般与信号量结合使用。

5. 信号量Semaphore：信号量是一个计数器，可以用来控制多个进程对共享资源的访问。它常作为一种锁机制，防止某进程正在访问共享资源时，其他进程也访问该资源。因此，主要作为进程间以及同一进程内不同线程之间的同步手段。

   信号量是一种特殊的变量，对它的操作都是原子的，有两种操作：V（`signal()`）和 P（`wait()`）。V 操作会增加信号量 S 的数值，P 操作会减少它。

   - V(S)：如果有其他进程因等待 S 而被挂起，就让它恢复运行，否则 S 加 1
   - P(S)：如果 S 为 0，则挂起进程，否则 S 减 1

   

6. 套接字Socket：套接字是一种通信机制，凭借这种机制，客户/服务器（即要进行通信的进程）系统的开发工作既可以在本地单机上进行，也可以跨网络进行。也就是说它可以让不在同一台计算机但通过网络连接计算机上的进程进行通信。

   套接字是支持TCP/IP的网络通信的基本操作单元，可以看做是不同主机之间的进程进行双向通信的端点，简单的说就是通信的两方的一种约定，用套接字中的相关函数来完成通信过程。

7. 信号 ( sinal ) ： 信号是一种比较复杂的通信方式，用于通知接收进程某个事件已经发生。

   信号事件主要有两个来源：

   - 硬件来源：用户按键输入`Ctrl+C`退出、硬件异常如无效的存储访问等。
   - 软件终止：终止进程信号、其他进程调用kill函数、软件异常产生信号。

   进程如何发送信号？

   - 操作系统提供发送信号的系统调用
   - 该系统调用会将信号放到目标进程的信号队列中
   - 如果目标进程未处于执行状态，则该信号就由内核保存起来，直到该进程恢复执行并传递给它为止。如果一个信号被进程设置为阻塞，则该信号的传递被延迟，直到其阻塞被取消时才被传递给进程

   进程如何接收信号？

   - 每个进程有一个信号队列，放其他进程发给它、等待它处理的信号
   - 进程在执行过程中的特定时刻，检查并处理自己的信号队列。如从系统空间返回到用户空间之前
   - 发送信号时，必须指明发送目标进程的id。

   有的信号，用户进程是无法处理也无法忽略的，比如`SIGSTOP`、`SIGKILL` 等。

#### 临界区的概念

各个进程中对临界资源（互斥资源/共享变量，一次只能给一个进程使用）进行操作的程序片段

#### 同步与互斥的概念？

- 同步：多个进程因为合作而使得进程的执行有一定的先后顺序。比如某个进程需要另一个进程提供的消息，获得消息之前进入阻塞态；
- 互斥：多个进程在同一时刻只有一个进程能进入临界区

**互斥：**是指某一资源同时只允许一个访问者对其进行访问，具有唯一性和排它性。但互斥无法限制访问者对资源的访问顺序，即访问是无序的。
 **同步：**是指在互斥的基础上（大多数情况），通过其它机制实现访问者对资源的有序访问。

#### 并发、并行、异步的区别？

并发：在一个时间段中同时有多个程序在运行，但其实任一时刻，只有一个程序在CPU上运行，宏观上的并发是通过不断的切换实现的；

多线程：并发运行的一段代码。是实现异步的手段

并行（和串行相比）：在多CPU系统中，多个程序无论宏观还是微观上都是同时执行的

异步（和同步相比）：同步是顺序执行，异步是在等待某个资源的时候继续做自己的事

#### 进程调度策略有哪些

* 先来先服务 first-come first-serverd（FCFS）
* 最短作业优先 shortest job first（SJF）
* 最短剩余时间优先 shortest remaining time next（SRTN）
* 最高响应比优先 Highest Response Ratio Next（HRRN）
* 时间片轮转 Round Robin
* 优先级调度算法
* 多级反馈队列调度算法 Multilevel Feedback Queue

#### 如何实现线程同步

* 互斥量
* 信号量
* 临界区

#### IO多路复用

**I/O多路复用，I/O就是指的我们网络I/O,多路指多个TCP连接(或多个Channel)，复用指复用一个或少量线程。串起来理解就是很多个网络I/O复用一个或少量的线程来处理这些连接。**

select/poll/epoll三者的区别？

`select`：将文件描述符放入一个集合中，调用select时，将这个集合从用户空间拷贝到内核空间（缺点1：每次都要复制，**开销大**），由内核根据就绪状态修改该集合的内容。（缺点2）**集合大小有限制**，32位机默认是1024（64位：2048）；采用水平触发机制。select函数返回后，需要通过遍历这个集合，找到就绪的文件描述符（缺点3：**轮询的方式效率较低**），当文件描述符的数量增加时，效率会线性下降；

`poll`：和select几乎没有区别，区别在于文件描述符的存储方式不同，poll采用链表的方式存储，没有最大存储数量的限制；

`epoll`：通过内核和用户空间共享内存，避免了不断复制的问题；支持的同时连接数上限很高（1G左右的内存支持10W左右的连接数）；文件描述符就绪时，采用回调机制，避免了轮询（回调函数将就绪的描述符添加到一个链表中，执行epoll_wait时，返回这个链表）；支持水平触发和边缘触发，采用边缘触发机制时，只有活跃的描述符才会触发回调函数。

#### 死锁

**死锁产生的必要条件**

- **互斥**：一个资源一次只能被一个进程使用；
- **占有并等待**：一个进程至少占有一个资源，并在等待另一个被其它进程占用的资源；
- **非抢占**：已经分配给一个进程的资源不能被强制性抢占，只能由进程完成任务之后自愿释放；
- **循环等待**：若干进程之间形成一种头尾相接的环形等待资源关系，该环路中的每个进程都在等待下一个进程所占有的资源。

**死锁有哪些处理方法**

* **死锁预防：**

  - 破坏互斥条件：允许某些资源同时被多个进程访问。但是有些资源本身并不具有这种属性，因此这种方案实用性有限；
  - 破坏占有并等待条件：
    - 实行资源预先分配策略（当一个进程开始运行之前，必须一次性向系统申请它所需要的全部资源，否则不运行）；
    - 或者只允许进程在没有占用资源的时候才能申请资源（申请资源前先释放占有的资源）；
    - 缺点：很多时候无法预知一个进程所需的全部资源；同时，会降低资源利用率，降低系统的并发性；
  - 破坏非抢占条件：允许进程强行抢占被其它进程占有的资源。会降低系统性能；
  - 破坏循环等待条件：对所有资源统一编号，所有进程对资源的请求必须按照序号递增的顺序提出，即只有占有了编号较小的资源才能申请编号较大的资源。这样避免了占有大号资源的进程去申请小号资源。

* **死锁避免**

  动态地检测资源分配状态，以确保系统处于安全状态，只有处于安全状态时才会进行资源的分配。所谓安全状态是指：即使所有进程突然请求需要的所有资源，也能存在某种对进程的资源分配顺序，使得每一个进程运行完毕。

  > 银行家算法

* **死锁解除**

  > 如何检测死锁：检测有向图是否存在环；或者使用类似死锁避免的检测算法。

  死锁解除的方法：

  - 利用抢占：挂起某些进程，并抢占它的资源。但应防止某些进程被长时间挂起而处于饥饿状态；
  - 利用回滚：让某些进程回退到足以解除死锁的地步，进程回退时自愿释放资源。要求系统保持进程的历史信息，设置还原点；
  - 利用杀死进程：强制杀死某些进程直到死锁解除为止，可以按照优先级进行。

## JVM

### JAVA内存区域

![image-20210322154901432](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210322154901432.png)

#### 程序计数器

程序计数器是一个很小的内存区域，不在RAM上，而是直接划分在CPU上，程序猿无法操作它，它的作用是：JVM在解释字节码（.class）文件时，存储当前线程执行的字节码行号，只是一种概念模型，各种JVM所采用的方式不一样。**字节码解释器工作时，就是通过改变程序计数器的值来取下一条要执行的指令，分支、循环、跳转等基础功能都是依赖此技术区完成的。**

       每个程序计数器只能记录一个线程的行号，因此它是线程私有的。
    
       如果程序当前正在执行的是一个java方法，则程序计数器记录的是正在执行的虚拟机字节码指令地址，如果执行的是native方法，则计数器的值为空，此内存区是唯一不会抛出OutOfMemoryError的区域。
#### 虚拟机栈

虚拟机栈占用的是操作系统内存，每个线程对应一个虚拟机栈，它是线程私有的，每个方法被执行时产生一个**栈帧（Statck Frame）**，栈帧用于存储局部变量表、动态链接、操作数和方法出口等信息，当方法被调用时，栈帧入栈，当方法调用结束时，栈帧出栈。

**局部变量表**中存储着方法相关的局部变量，包括各种基本数据类型及对象的引用地址等，因此他有个特点：内存空间可以在编译期间就确定，运行时不再改变。

虚拟机栈定义了两种**异常类型**：**StackOverFlowError(栈溢出)和OutOfMemoryError（内存溢出）**

#### 本地方法栈

**本地方法栈**用于支持native方法的执行，存储了每个native方法的执行状态。本地方法栈和虚拟机栈他们的运行机制一致，唯一的区别是，虚拟机栈执行Java方法，本地方法栈执行native方法。

本地方法栈也会在栈深度溢出或者扩展失败时分别抛出：**StackOverFlowError(栈溢出)和OutOfMemoryError（内存溢出）**

#### JAVA堆

堆区是GC最频繁的，也是理解GC机制最重要的区域。堆区由所有线程共享，在虚拟机启动时创建。堆区主要用于存放对象实例及数组，所有new出来的对象都存储在该区域。

#### 方法区

方法区存放了要加载的类的信息（如类名、修饰符等）、静态变量、构造函数、final定义的常量、类中的字段和方法等信息。方法区是全局共享的，在一定条件下也会被GC。当方法区超过它允许的大小时，就会抛出OutOfMemory：PermGen Space异常。

**运行时常量池（Runtime Constant Pool）**是方法区的一部分，用于存储编译器生成的常量和引用。一般来说，常量的分配在编译时就能确定，但也不全是，也可以存储在运行时期产生的常量。比如String类的intern（）方法，作用是String类维护了一个常量池，如果调用的字符”hello”已经在常量池中，则直接返回常量池中的地址，否则新建一个常量加入池中，并返回地址。


### GC

 在上面介绍的五个内存区域中，有3个是不需要进行垃圾回收的：本地方法栈、程序计数器、虚拟机栈。因为他们的生命周期是和线程同步的，随着线程的销毁，他们占用的内存会自动释放。所以，只有方法区和堆区需要进行垃圾回收，回收的对象就是那些不存在任何引用的对象。

#### CG Roots

* 在虚拟机栈中引用的对象，譬如各个线程被调用的方法堆栈中使用到的参数、局部变量、临时变量等
* 在方法区中类静态属性引用的对象，如Java类的引用类型静态变量
* 在方法区中常量引用的对象，如字符串常量池里的引用
* 在本地方法栈中JNI（即常说的Native方法）引用的对象
* Java虚拟机内部的引用，如基本数据类型对应的Class对象
* 所有被同步锁持有的对象

#### 引用

**强引用：**new出来的对象都是强引用，GC无论如何都不会回收，即使抛出OOM异常。
**软引用：**只有当JVM内存不足时才会被回收。
**弱引用：**只要GC,就会立马回收，不管内存是否充足。
**虚引用：**可以忽略不计，JVM完全不会在乎虚引用，你可以理解为它是来凑数的，凑够”四大天王”。它唯一的作用就是做一些跟踪记录，辅助finalize函数的使用。

> 什么样的类需要被回收：

```
a.该类的所有实例都已经被回收；
b.加载该类的ClassLoad已经被回收；
c.该类对应的反射类java.lang.Class对象没有被任何地方引用。
```

#### 分代收集理论

一般会把Java堆划分为新生代和老年代。

新生代：每次回收时只关注如何保留少量存活而不是去标记那些大量将要被回收的对象，就能以较低代价回收到大量的空间。

老年代：使用较低的频率来回收这个区域。

**跨代引用：**新生代中的对象是有可能被老年代引用的。

**跨代引用假说：**存在互相引用关系的两个对象，是应该倾向于同时生存或者同时消亡的。因此不应再为少量的跨代引用去扫描整个老年代，也不必浪费空间专门记录每一个对象是否存在及存在哪些跨代引用，只需在新生代上建立一个全局变量的数据结构，标识出老年代的哪一块内存会存在跨代引用。

#### 垃圾收集算法

垃圾收集算法可以划分为“引用计数式垃圾收集”和“追踪式垃圾收集”两大类，JVM使用的后者。

##### 标记-清除算法

“标记-清除”算法是出现最早也是最基础的垃圾收集算法。

算法分为“标记”和“清除”两个阶段：首先标记出所有需要回收的对象，在标记完成后，统一回收掉所有被标记的对象，也可反过来标记存活对象。

**缺点：**

1. 执行效率不稳定，标记、清除两个过程的执行效率都随对象数量增长而降低。
2. 内存空间的碎片化问题，标记、清除之后会产生大量不连续的内存碎片，空间碎片太多可能会导致当以后在程序运行过程中需要分配较大对象时无法找到足够的连续内存而不得不提前出发下一次垃圾收集动作。

##### 标记-复制算法

标记-复制算法是为了解决标记-清除算法面对大量可回收对象时执行效率低的问题。

思路：将可用内存按容量划分为大小相等的两块，每次只使用其中的一块。当这一块的内存快用完了，就将还存活着的对象复制到另外一块上面，然后再把已使用过的内存空间一次清理掉。

**优点：**实现简单，运行高效，算法需要复制的就是占少数的存活对象，分配内存时也就不用考虑有空间碎片的复杂情况，只要移动栈顶执政，按顺序分配即可。

**缺点：**

1. 如果内存中多数对象都是存活的，这种算法将会产生大量的内存间复制的开销，但对于多数对象都是可回收的情况。
2. 代价是将可用内存缩小为了原来的一半，空间浪费太多了。

现在商用Java虚拟机大多都优先采用了这种收集算法去回收新生代，之后的研究也表明新生代的对象有98%熬不过第一轮收集，因此不需要按照1：1的比例来划分新生代的内存空间。但是需要额外的空间进行分配担保。

##### 标记-整理算法

标记-复制算法在对象存活率较高时就要进行较多的复制操作，效率将会降低，所以在老年代一般不能直接选用这种算法。

标记-整理算法：其中的标记过程仍然与“标记-清除”算法一样，但后续步骤不是直接对可回收对象进行清理，而是让所有存活的对象都想内存空间一端移动，然后直接清理掉边界以外的内存。

**优点：**可以消除内存空间碎片化问题

**缺点：**在老年代中每次回收都有大量对象存活区域，移动存活对象并更新所有引用这些对象的地方将会是一种极为负重的操作，而且这种对象移动操作必须全程暂停用户应用程序才能进行。

#### 经典垃圾收集器

![image-20210323140152131](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210323140152131.png)

##### Serial收集器

在JDK1.3.1之前，单线程回收器是唯一的选择。它的单线程意义不仅仅是说它只会使用一个CPU或一个收集线程去完成垃圾收集工作。而且它进行垃圾回收的时候，必须暂停其他所有的工作线程，直到它收集完成。它适合Client模式的应用，在单CPU环境下，它简单高效，由于没有线程交互的开销，专心垃圾收集自然可以获得最高的单线程效率。

![image-20210323140428308](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210323140428308.png)

##### ParNew收集器

ParNew收集器实质上时Serial收集器的多线程并行版本，除了同时使用多条线程进行垃圾收集之外，其余的行为包括Serial收集器可用的所有控制参数、收集算法、Stop The World、对象分配规则、回收策略等斗鱼Serial收集器完全一致。

ParNew收集器除了支持多线程并行收集之外，其他与Serial收集器相比并没有太多创新之处，但它是JDK之前的遗留系统中首选的新生代收集器，其中有一个与功能、性能无关但其实很重要的原因是：除了Serial收集器外，目前只有他能与CMS收集器配合工作。

![image-20210323141259702](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210323141259702.png)

##### Parallel Scavenge收集器

Parallel Scavenge收集器的特点是它的关注点与其他收集器不同，CMS等收集器的关注点是尽可能的缩短收集时用户线程的停顿时间，而Parallel Scavenge收集器的目标则是达到一个可控制的吞吐量。吞吐量=代码运行时间/(代码运行时间+垃圾收集时间),也就是高效率利用cpu时间。

![image-20210323142145836](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210323142145836.png)

##### Serial Old收集器

Serial Old时Serial收集器的老年代版本，它同样是一个单线程收集器，使用标记-整理算法。这个收集器的主要意义也是供客户端模式下的HotSpot虚拟机使用。如果在服务端模式下，他也可能有两种用途：一种是在JDK5以及之前的版本中与Parrallel Scavenge收集器搭配使用，另外一种就是作为CMS收集器发生失败时的后备预案，在并发收集发生Concurrent Mode Failure时使用。

##### Parallel Old收集器

Parrallel Old是Parallel Scavenge收集器的老年版本，支持多线程并发收集，基于标记-整理算法实现。这个收集器是直到JDK6时才开始提供的，在此之前，新生代的Parallel Scavenge收集器一直处于相当尴尬的状态，原因时入关新生代选择了Parallel Scavenge收集器，老年代除了Serial Old收集器以外别无选择，其他表现良好的老年代收集器，如CMS无法与他配合工作。由于Serial old收集器在服务端应用上的“拖累”，使用Parallel Scavenge收集器也未必能在整体上获得吞吐量最大化的效果。

##### CMS收集器

CMS（Concurrent Mark Sweep）从米子中就可以看出CMS收i九七是基于标记-清除算法实现的，他的运行过程分为四个步骤;

1. 初试标记，标记一下GC Roots能直接关联到的对象，速度很快，会Stop The World
2. 并发标记，从GC Roots的直接关联对象开始遍历整个对象图的过程，这个过程耗时较长但是不需要停顿用户线程，可以与垃圾收集线程一起并发运行
3. 重新标记，为了修正并发标记期间，因用户程序继续运行而导致标记产生变动的那一部分对象的标记记录，标记期间产生的对象存活的再次判断，会Stop The World，这个阶段的停顿时间通常会比初始标记阶段稍长一些，但也远比并发标记阶段的时间段
4. 并发清除，清理删除掉标记阶段判断的已经死亡的对象，由于不需要移动存活对象，所以这个阶段也是可以与用户线程同时并发的

![image-20210323145222210](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210323145222210.png)

**缺点：**

1. CMS收集器对处理器资源非常敏感，在并发阶段，他虽然不会导致用户线程停顿，但是会因为占用了一部分线程而导致应用程序变慢，降低总吞吐量。CMS默认启动的回收线程数是（CPU数量+3）/ 4，当CPU<4个时，并发回收是垃圾收集线程就不会少于25%，而且随着CPU减少而增加，这样会影响用户线程的执行。
2. CMS收集器无法处理“浮动垃圾”，有可能出现“Concurrent Mode Failure”失败进而导致另外一次完全“Stop The World”的Full GC的产生。所谓浮动垃圾，在CMS并发清理阶段用户线程还在运行着，伴随程序运行自然还会有新的垃圾不断产生，这一部分垃圾出现在标记过程之后，CMS无法在当次收集中处理掉它们，只能留待下一次GC时再清理掉。
3. 由于它是基于标记-清除算法的，那么就无法避免空间碎片的产生。

##### Garbage First收集器（G1）

G1还是分代收集的，但是G1不再像上文所述的垃圾收集器，需要分代配合不同的垃圾收集器，因为G1中的垃圾收集区域是“分区”（Region）的。G1不再坚持固定大小以及固定数量的分代区域划分，而是把连续的Java堆划分为多个大小相等的独立区域（Region），每一个Region都可以根据需要，扮演新生代的Eden空间、Survivor空间或者老年代空间。Region中还有一类特殊的Humongous区域，专门用来存储大对象。G1认为只要大小超过了一个Region容量一半的对象即可判定为大对象。

分区可以有效利用内存空间，因为收集整体是使用“标记-整理”，Region之间基于“复制”算法，GC后会将存活对象复制到可用分区（未分配的分区），所以不会产生空间碎片。

G1收集器的运作可分为以下四个步骤：

1. 初始标记：标记一下GC Roots能直接关联到的对象，并且修改TAMS（Top at Mark Start）指针的值，让下一阶段用户线程并发运行时，能正确地在可用的Region中分配新对象。这个阶段需要停顿现场，但耗时很短。
2. 并发标记：从GC Roots开始堆队中对象进行可达性分析，递归扫描整个堆里的对象图，找出要回收的对象，这个阶段耗时较长，但可与用户程序并发执行。对象图扫描完成以后，还要重新处理SATB记录下的在并发时有引用变动的对象。
3. 最终标记：对用户线程做一个短暂的暂停，用于处理并发阶段结束后仍遗留下来的最后那少量的SATB记录。
4. 筛选回收：负责更新Region的统计数据，对各个Region的回收价值和成本进行排序，根据用户所期望的停顿时间来制定回收计划，可任意自由选择任意多个Region构成会收集，然后把决定回收的那一部分Region的存活对象复制到空的Region中，再清理掉整个旧Region的全部空间。这里的操作涉及存活对象的移动，是必须暂停用户线程 ，有多条收集器线程并行完成的。

![image-20210323154452823](C:\Users\chy\Desktop\研究生相关信息\学习\计算机网络\img\image-20210323154452823.png)

从G1开始，最先进的垃圾收集器的设计导向都开始变为追求能够应付应用的内存分配速率，而不追求一次把整个Java堆全部清理干净。这样应用再分配同时，收集器在手机，只要收集的速度能跟的上对象分配的速度，那一切就能运作的很完美。

##### CMS和G1的比较

G1的优点：

1. 可以指定最大停顿时间
2. 分Region的内存布局
3. 按收益动态确定回收集
4. 与CMS的标记-清除算法不同，G1从整体上看是基于标记-整理算法实现的收集器，从局部上看有事基于标记-复制算法实现

G1的缺点：

G1无论是为了垃圾收集产生的内存占用还是程序运行时的额外执行负载都比CMS高。

1. 内存占用：虽然G1和CMS都要使用卡表来处理跨代指针，但G1的卡表实现更为复杂，而且堆中每个Region都必须有一份卡表，导致G1的记忆集会占更多的内存空间
2. 执行负载：他们都会使用到写屏蔽。。。这个不清楚，不看了

#### 低延迟垃圾收集器

##### Shenandoah

与G1的区别：

1. 支持并发的整理算法，G1的回收阶段可以多线程并行，但是不能与用户线程比广发
2. Shenandoah目前是默认不使用分代收集，不会有专门的新生代Region和老年代Region的存在
3. 不用去维护记忆集，该使用连接举证来记录跨Region的引用关系

工作过程大致分为九个阶段：

1. 初始标记：和G1一样
2. 并发标记：和G1一样
3. 最终标记：和G1一样
4. 并发清理：用于清理那些整个区域内连一个存活对象都没有找到的Region
5. 并发回收：核心差异。
6. 初始引用更新
7. 并发引用更新
8. 最终引用更新
9. 并发清理

##### ZGC

ZGC收集器是一款基于Region内存布局的，目前不设粉黛的，使用了读屏障、染色指针和内存多重映射等技术来实现可并发的标记-整理算法。



### 类加载




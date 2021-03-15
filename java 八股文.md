## JAVA基础

### java基础常识

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

### int和Integer

### String StringBuffer 和 StringBuilder

### 重载和重写的区别

#### Java中是否可以覆盖(override)一个private或者是static的方法

### 深拷贝 vs 浅拷贝

### Java的四个基本特性及多态的理解

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
- ConcurrentHashMap: 线程安全的Map.
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

> #### 线程和进程有什么区别？

线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务。不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间。



### synchronized

### volatile

### 锁

### AQS

### 线程池

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

实现机制：InnoDB在每行数据都增加三个隐藏字段，一个唯一行号，一个记录创建的版本号，一个记录删除的版本号。

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
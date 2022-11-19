# XML与JSON

# 一、XML

​		w3c万维网联盟：https://www.w3school.com.cn

## 1. xml概述

​			XML(Extensible Markup Language 可扩展标记语言)是一个以文本来描述数据的文档

​			是一种数据表示格式，可以用于自定义数据格式，常用于网络传输数据或存储数据或作为软件的配置文件

## 2. xml用途

​		1. 存储数据

​		2. 作为系统与系统之间的传输数据的格式

​		3. 作为项目的配置文件

​		4. 保存有结构关系型的数据

## 3. xml与html的比较

​		1. xml标签都是自定义的，html标签是预定义

​		2. xml的语法严格，html语法松散（例如：xml区分大小写，html不区分大小写）

​		3. xml是存储数据的，html是展示数据

​		4. html中，空格会自动过滤，而xml不会

​		5. html中可以有多个根节点，在xml里面只有一个

## 3. xml具体语法

```
语法要求：
	1. xml文档的后缀名 .xml
	2. xml第一行必须定义为文档声明
	3. 必须存在一个根标签，且只能有一个
	4. 属性值必须使用引号(单双都可)引起来
	5. 标签必须正确关闭
	6. xml标签名称区分大小写
	7. xml的标记不能以数字或_下划线或标点符号或以字母xml（或XML、Xml等）开头
	8. 名称不能包含空格
	9. XML文件中某些字符需要实体引用，如下：
			&lt;	<	小于
			&gt;	>	大于
			&amp;	&	和号
			&apos;	'	单引号
			&quot;	"	引号
```

### 			1. XML文档声明

​				文档声明必须是第一行第一列

​				语法：

​						<?xml version="1.0" encoding="UTF-8" standalone="yes”?>

​				属性：

​					version：版本号，必须属性

​					encoding：编码方式，告知解析引擎当前文档使用的字符集，默认编码：ISO-8859-1，一般编码取UTF-8,不必须属性

​					standalone：描述XML文件是否依赖外部的文件，不必须属性

​				注意：第一个？号必须与`xml`紧张贴着，`?`与`<` `>`不能有空格

### 		2. XML元素定义

​				语法： <元素名></元素>

### 		3. 属性定义

​				语法： <元素名 属性="属性值" 属性2="属性值2"></元素>

​				其中id属性值唯一

### 		4. 注释

​				语法：<!-- 这是一条注释-->

### 		5. 指令：结合css的

​				<?xml-stylesheet type="text/css" href="a.css" ?>

### 		6. 文本

​				CDATA区：在该区域中的数据会被原样展示

​				格式： <![CDATA[   …数据…  ]]>

## 		4. xml文档约束

### 		1. xml为什么需要文档约束？

​				由于XML文件可以自定义标签，导致XML文件可以随意定义，程序在解析的时候可能出现问题

### 		2. 什么是文档约束

​				文档约束是用来限定xml文件中的标签以及属性应该怎么写，以此强制约束程序员必须按照文档约束的规定来编写xml文件

### 		3. 文档约束分类

​				1. DTD:一种简单的约束技术

​				2. Schema:一种复杂的约束技术

### 	4. DTD约束

```
DTD约束三种定义：（未涉及的，现学现用即可）
	1. 元素定义
	2. 属性定义
	3. 实体定义 

DTD：
	dtd引入到xml文档中三种方案
		1. 引入本地dtd
			<!DOCTYPE 根元素名称 SYSTEM ‘DTD文件的路径'>
		2. 在xml文件内部引入
			<!DOCTYPE 根元素名称 [ dtd文件内容 ]>
		3. 引入网络dtd
			<!DOCTYPE 根元素的名称 PUBLIC "DTD文件名称" "DTD文档的URL"
案例：
student.dtd
	<!ELEMENT students (student*) >
	<!ELEMENT student (name,age,sex)>
	<!ELEMENT name (#PCDATA)>
	<!ELEMENT age (#PCDATA)>
	<!ELEMENT sex (#PCDATA)>
	<!ATTLIST student number ID #REQUIRED>
	
DTD的使用步骤
	1. 编写DTD约束文档，后缀必须是.dtd
	2. 在需要编写的XML文件中导入该DTD约束文档
	3. 按照约束的规定编写XML文件的内容

```

#### 	DTD语法规则：

![image-20221027230256652](assets\image-20221027230256652.png)

### 5. Schema约束

```
1. schema约束规范
	
	1. 所有标签和属性都要schema文件来定义

	2. 所有schema文件都需要一个id，但是在这个它叫namespace

	3. namespace的值由什么来指定？
		由targetNamespace属性来指定，它的值是一个url（很有可能不存在）
	
	4. 如何引入一个Schema约束？
		
		属性：用xmlns属性
		属性值：对应的schema文件的id（namespace的值）

	5. 如果引入的schema不是w3c组织定义，必须指定schema文件的位置

	6. schema文件的位置由什么属性来指定？
		
		属性：schemaLocation
		属性值：.xsd文件中targetNamespace标签中的url

	7. 如果引入了N个约束，需要给n-1个取别名
```

#### Shema使用步骤：

​	![image-20221027230811347](assets\image-20221027230811347.png)

### 6. schema和dtd的区别

```
1. Schema和DTD主要的作用是来约束xml，定义xml标记的使用规范

2. Schema本身也是XML文档，DTD使用的是自己特殊的语法，因此只要知道XML的语法规则就可以编写Schema了不需要再学习其他的语法

3. 利用命名空间将文件中特殊的节点与Schema说明相联系，一个xml可以有多个schema，但只能有一个dtd

4.Schema的内容模型是开放的，可以随意扩充，而DTD不能扩充

5.DTD只能把文件定义为一个字符串，而XML Scheam允许把文件类型定义为整数，浮点，字符串，布尔等等

6.Schema支持include和import两种引用命名空间的方法

因此schema约束比dtd约束应用更广泛
```

## 4. xml解析技术相关

### 		1. Sax解析xml

#### 				1. Sax技术介绍

​					SAX 是读取和操作 XML 数据更快速、更轻量的方法

​					SAX 允许读取文档时处理，不必等待整个文档被存储之后才采取操作

​					SAX不涉及 DOM 所必需的开销和概念跳跃

​	 				SAX API是一个基于事件的API ，适用于处理数据流，即随着数据的流动而依次处理数据

​					SAX API 在其解析文档时发生一定事件的时候会通知，在您对其响应时，不作保存的数据将会被抛弃

#### 				2. SAX API中主要有四种处理事件的接口	

​					ContentHandler，DTDHandler、EntityResolver 和 ErrorHandler

​					DefaultHandler实现了这四个事件处理器接口，然后提供了每个抽象方法的默认实现

#### 				3. SAX解析步骤

```
1.创建 SAXParserFactory 的对象

2.创建 SAXParser 对象 (解析器)

3.创建一个 DefaultHandler 的子类，需要重写5个方法
	1)解析xml文档开始时调用
		startDocument()
	2)解析xml文档结束时调用
		endDocument()
	3)解析xml文档中的开始节点时调用
		startElement(String uri, String localName, String qName, Attributes attributes)
	4)解析xml文档中的结束节点时调用
		endElement(String uri, String localName, String qName)
	5)解析xml文档中的节点中的文本值时调用
		characters(char[] ch, int start, int length)
4.调用 parse 方法
```

### 		2. DOM解析xml

#### 				1. DOM技术

​				DOM：Document Object Model（文档对象模型）

​				 就是把文档的各个组成部分看做成对应的对象

#### 				2. DOM的特性

​				会把xml文件全部加载到内存， 在内存中形成一个树形结构，再获取对应的值

#### 				3. DOM技术的优点

​				DOM的优点，由于树在内存中是持久的，因此可以修改后更新

​				它还可以在任何时候在树中上下导航，API使用起来也较简单

#### 				4. DOM解析步骤

```
1. 创建一个DOM解析器工厂对象

2. 通过工厂对象创建解析器对象

3. 解析文档

4. 从内存中读取数据
```

### 		3. JDOM解析xml

#### 				1. JDOM技术介绍

​					JDOM 简化了与 XML 的交互并且比使用 DOM 实现更快，JDOM 与 DOM 主要有两方面不同

​						第一：

​								JDOM 仅使用具体类而不使用接口。这在某些方面简化了 API，但是也限制了灵活性

​						第二：

​								API 大量使用了 Collections 类，简化了那些已经熟悉这些类的 Java开发者的使用

#### 				2. 下载地址

​					下载地址：http://www.jdom.org/downloads/index.html

#### 				3. 解析步骤

```
1.建立解析器

2. DOM处理

3. DOM结果处理(输出/保存)
```

### 		4. DOM4J解析xml

#### 				1. DOM4J介绍

​				dom4j是一个优秀的Java XML API，具有性能优异、功能强大和极端易用使用的特点

​				dom4j也是一个开放源代码的软件，可以在SourceForge上找到它，

​				下载地址：https://dom4j.github.io/

#### 				2. 解析步骤

```
1. 创建SAXReader

2. 使用SAXReader读取XML文档并生成Document对象

3. 通过Document对象获取根元素;

4. 从根元素开始逐级获取子元素已达到遍历XML文档的目的
```

### 	5. Jsoup解析XML

​			封装了爬取xml/html信息内容

```
这一部分可以步骤：
	1. 导入jar包
	2. 获取Document对象
	3. 获取对应的标签Element对象
	4. 获取数据

Jsoup是一款Java的HTML解析器，可直接解析某个URL地址、HTML文本内容

提供了一套非常省力的API，可通过DOM、CSS以及类似于jQuery的操作方法来取出和操作数据
```

### 		6. 各种解析方法比较

```
JDOM 和 DOM 在性能测试时表现不佳，在测试 10M 文档时内存溢出

SAX表现较好，这要依赖于它特定的解析方式
一个 SAX 检测即将到来的XML流，但并没有载入到内存（当然当XML流被读入时，会有部分文档暂时隐藏在内存中）

DOM4J是这场测试的获胜者，目前许多开源项目中大量采用 DOM4J

Jsoup是一款Java的HTML解析器，可直接解析某个URL地址、HTML文本内容
用来解析获取网页代码（即html网页代码）是不错的选择
```

### 	7. xml文件与Java对象之间的转换

​		通过Java提供的java.beans.XMLEncoder和java.beans.XMLDecoder类可以生成XML文件

​			1. 把对象转成XML文件写入		

​			2. 从XML文件中读取对象

### 	8. 使用第三方xstream组件实现XML的解析与生成

## 5. XML检索技术：Xpath

​		XPath使用路径表达式来定位XML文档中的元素节点或属性节点

### 	1. 相关API

​			Node selectSingleNode("表达式") ：获取符合表达式的唯一元素

​			List<Node> selectNodes("表达式")：获取符合表达式的元素集合

### 	2. Xpath的四大检索方案：

#### 		1. 绝对路径

​				采用绝对路径获取从根节点开始逐层的查找/contactList/contact/name节点列表并打印信息

| 方法名                | 说明                                     |
| --------------------- | ---------------------------------------- |
| /根元素/子元素/孙元素 | 从根元素开始，一级一级向下查找，不能跨级 |

#### 		2. 相对路径

​				1. 先得到根节点contactList

​				2. 再采用相对路径获取下一级contact 节点的name子节点并打印信息

| 方法名          | 说明                                       |
| --------------- | ------------------------------------------ |
| ./子元素/孙元素 | 从当前元素开始，一级一级向下查找，不能跨级 |

#### 		3. 全文检索

​				直接全文搜索所有的name元素并打印

| 方法名          | 说明                                                       |
| --------------- | ---------------------------------------------------------- |
| //contact       | 找contact元素，无论元素在哪里                              |
| //contact/name  | 找contact，无论在哪一级，但name一定是contact的子节点       |
| //contact//name | contact无论在哪一种，name只要是contact的子孙元素都可以找到 |

#### 		4. 属性查找

​				在全文中搜索属性，或者带属性的元素

| 方法名                 | 说明                                                       |
| ---------------------- | ---------------------------------------------------------- |
| //@属性名              | 查找属性对象，无论是哪个元素，只要有这个属性即可。         |
| //元素[@属性名]        | 查找元素对象，全文搜索指定元素名和属性名。                 |
| //元素//[@属性名=‘值’] | 查找元素对象，全文搜索指定元素名和属性名，并且属性值相等。 |

## 6. XML解析技术的作用

​	用Java代码读取xml中的数据

# 二、JSON

## 1. 什么是JSON

​		JSON(JavaScript Object Notation) 是一种轻量级的数据交换格式

​		JSON 官方:	http://www.json.org

## 2. JSON 数据格式的特点

### 		JSON两种结构形式：

#### 				1. “名称/值”对的集合 

​				{ "firstName": "vince", "lastName":"ma", "email": "finally_m@foxmail.com" } 

#### 				2. 值的有序列表（数组）

​				{ "user": [{ "firstName": "vince", "lastName":"ma", "email": "finally_m@foxmail.com" }, 

​				{ "firstName": "lin", "lastName":"jacks", "email": “jacks@qq.com”}] }

## 3. GSON组件用于转换JSON数据和Java对象

​			GSON是Google开发的Java API，用于转换Java对象和Json对象

​			下载地址：http://www.mvnrepository.com/artifact/com.google.code.gson/gson	

# 三、XML与JSON的比较与应用场景

## 1. XML与JSON的比较

​			1. JSON和XML的数据可读性基本相同

​			2. JSON和XML同样拥有丰富的解析手段

​			3. JSON相对于XML来讲，数据的体积小

​			4. JSON与JavaScript的交互更加方便

​			5. JSON对数据的描述性比XML较差

​			6. JSON的速度要远远快于XML

## 2. 适合的场景

​			1. 数据传输：JSON要比XML更有优势

​			2. 存储数据：XML描述性更强

​			3. XML通常用做配置文件

# 四、配置文件

## 1. 配置文件的作用

​		配置文件是用于给应用程序提供配置参数以及初始化设置的一些有特殊格式的文件

## 2. 常见的配置文件类型

### 2.1 properties文件

> 例如：

​		druid连接池就是使用properties文件作为配置文件

> 文件示例：

```
username=root
password=root
url=jdbc:mysql://localhost:3306/test03?useSSL=false&requireSSL=false&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
driverClassName=com.mysql.cj.jdbc.Driver
```

> 语法规范：
>
> ​	1. 由键值对组成
>
> ​	2. 键和值之间的符号是等号
>
> ​	3. 每一行都必须顶格写，前面不能有空格之类的其他符号

### 2.2 XML文件

> 例如：

​		Tomcat就是使用XML文件作为配置文件

> 语法规范：这章节已总结

### 2.3 YAML文件

> 例如：

​		SpringBoot就是使用YAML作为配置文件

> 语法规范：SpringBoot章节会总结

### 2.4 json文件

​		通常用来做文件传输，也可以用来做前端或者移动端的配置文件

> 语法规范：这章节已经总结


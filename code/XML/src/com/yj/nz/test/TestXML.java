package com.yj.nz.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 包名:com.xml
 *
 * @author yj
 * 日期2021-05-08  09:51
 * 使用DOM4J解析xml
 * 步骤:
 *  1. 引入jar包
 *  2. 创建解析器对象: new SAXReader()
 *  3. 使用解析器对象读取xml配置文件，从而得到一个Document对象
 *  4. 使用Document对象获取根标签
 *  5. 获取根标签里面的子标签
 */
public class TestXML {
    @Test
    public void test01() throws Exception {
        //目标: 获取demo01.xml文件的根标签的标签名
        //1. 创建解析器对象
        SAXReader saxReader = new SAXReader();
        //2. 使用解析器对象读取xml配置文件，从而得到一个Document对象
        //2.1 将demo01.xml文件转成字节输入流
        InputStream is = TestXML.class.getClassLoader().getResourceAsStream("demo01.xml");
        System.out.println(is);
        //2.2 使用解析器读取流
        Document document = saxReader.read(is);

        //3. 使用document对象获取当前xml文档的根标签
        Element rootElement = document.getRootElement();

        //4. 使用根标签获取标签名
        String elementName = rootElement.getName();
        System.out.println(elementName);
    }

    @Test
    public void test02() throws Exception {
        //目标: 获取根标签下的所有子标签
        //第一大步: 获取bookstore.xml文件的根标签
        //1. 创建解析器对象
        SAXReader saxReader = new SAXReader();
        //2. 使用解析器对象读取xml配置文件，从而得到一个Document对象
        //2.1 将demo01.xml文件转成字节输入流
        InputStream is = TestXML.class.getClassLoader().getResourceAsStream("bookstore.xml");
        //2.2 使用解析器读取流
        Document document = saxReader.read(is);

        //3. 使用document对象获取当前xml文档的根标签
        Element rootElement = document.getRootElement();

        //第二大步: 获取根标签下的所有子标签
        List<Element> elements = rootElement.elements();

        //遍历出每一个子标签，获取子标签的标签名
        for (Element element : elements) {
            System.out.println(element.getName());
        }
    }

    @Test
    public void test03() throws Exception {
        //目标: 获取根标签下的所有的book子标签，并且获取每个book下的所有子标签的标签名
        //第一大步: 获取bookstore.xml文件的根标签
        //1. 创建解析器对象
        SAXReader saxReader = new SAXReader();
        //2. 使用解析器对象读取xml配置文件，从而得到一个Document对象
        //2.1 将demo01.xml文件转成字节输入流
        InputStream is = TestXML.class.getClassLoader().getResourceAsStream("bookstore.xml");
        //2.2 使用解析器读取流
        Document document = saxReader.read(is);

        //3. 使用document对象获取当前xml文档的根标签
        Element rootElement = document.getRootElement();

        //第二大步: 获取根标签下的所有名字叫做book的子标签
        List<Element> elements = rootElement.elements("book");

        //遍历出每一个book
        for (Element element : elements) {
            System.out.println(element.getName());

            //再次获取每一个book的子标签
            List<Element> subElements = element.elements();
            for (Element subElement : subElements) {
                System.out.println(subElement.getName());
            }

            System.out.println("-----------------------------------");
        }
    }

    @Test
    public void test04() throws Exception {
        //目标: 获取每一份报纸paper的id属性值，以及每份报纸的子标签以及其子标签的内容
        //第一大步: 获取bookstore.xml文件的根标签
        //1. 创建解析器对象
        SAXReader saxReader = new SAXReader();
        //2. 使用解析器对象读取xml配置文件，从而得到一个Document对象
        //2.1 将demo01.xml文件转成字节输入流
        InputStream is = TestXML.class.getClassLoader().getResourceAsStream("bookstore.xml");
        //2.2 使用解析器读取流
        Document document = saxReader.read(is);

        //3. 使用document对象获取当前xml文档的根标签
        Element rootElement = document.getRootElement();

        //第二大步: 获取根标签下的所有名字叫做book的子标签
        List<Element> elements = rootElement.elements("paper");
        for (Element element : elements) {
            //每一个element就是一个paper标签
            String id = element.attributeValue("id");
            System.out.println("paper的id为:" + id);

            //获取paper的子标签
            List<Element> subElements = element.elements();
            for (Element subElement : subElements) {
                String elementName = subElement.getName();
                //获取子标签的内容
                String textTrim = subElement.getTextTrim();
                System.out.println(elementName + "标签里面的内容是:" + textTrim);
            }
            System.out.println("-------------------------------");
        }
    }

    @Test
    public void test05() throws DocumentException {
        //目标: 获取第三本书的作者的名字
        //使用XPATH解析:
        //方法一: document.selectSingleNode("标签的路径规则")查找某一个标签
        //方法二: document.selectNodes("标签路径规则")查找多个标签

        //第一大步: 加载xml文件，获取Document对象
        //1. 创建解析器对象
        SAXReader saxReader = new SAXReader();
        //2. 使用解析器对象读取xml配置文件，从而得到一个Document对象
        //2.1 将demo01.xml文件转成字节输入流
        InputStream is = TestXML.class.getClassLoader().getResourceAsStream("bookstore.xml");
        //2.2 使用解析器读取流
        Document document = saxReader.read(is);

        // 使用XPATH获取需要的标签
        Element element = (Element) document.selectSingleNode("/books/book[4]/author");

        //获取标签的文本
        System.out.println(element.getText());
    }
}

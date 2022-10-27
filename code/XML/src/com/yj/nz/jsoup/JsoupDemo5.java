package com.yj.nz.jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 *选择器查询
 */
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        //1.获取student.xml的path
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println(path);
        path = java.net.URLDecoder.decode(path,"utf-8");//解决中文解码问题
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.查询name标签
        /*
            div{

            }
         */
        Elements elements = document.select("name");
        System.out.println(elements);
        System.out.println("=----------------");
        //4.查询id值为10001的元素
        Elements elements1 = document.select("#yjxz01");
        System.out.println(elements1);
        System.out.println("----------------");
        //5.获取student标签并且number属性值为yjxz01的age子标签
        //5.1.获取student标签并且number属性值为yjxz01
        Elements elements2 = document.select("student[number=yjxz01]");
        System.out.println(elements2);
        System.out.println("----------------");

        //5.2获取student标签并且number属性值为yjxz01的age子标签
        Elements elements3 = document.select("student[number=yjxz01] > age");
        System.out.println(elements3);

    }

}

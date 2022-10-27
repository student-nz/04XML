package com.yj.nz.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonDemo3 {

    /**
     * 把一组JSON对象转换成一个JAVA对象集合，或者把一个JAVA对象集合转换成JSON数组
     */
    @Test
    public void gson2(){
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/yj/nz/json/names.json");
        InputStreamReader in = new InputStreamReader(is);
        TypeToken<List<Name>> typeToken = new TypeToken<List<Name>>(){};
        // MyTypeToken myTypeToken = new MyTypeToken();
        List<Name> list = gson.fromJson(in, typeToken.getType());
        System.out.println(list);


        String json = gson.toJson(list, typeToken.getType());
        System.out.println(json);
    }

    class MyTypeToken extends TypeToken<List<Name>>{}

    /**
     * 把一个JSON对象转换成JAVA对象，或把一个JAVA对象转换成JSON对象
     */
    @Test
    public void gson1(){
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/yj/nz/json/name.json");
        InputStreamReader in = new InputStreamReader(is);
        Name name = gson.fromJson(in, Name.class);
        System.out.println(name);

        String json = gson.toJson(name);
        System.out.println(json);
    }

    @Test
    public void createJSON(){
        List<Name> list = new ArrayList<>();
        list.add(new Name("10007","10008","yjxz01"));
        list.add(new Name("10009","10010","yjxz02"));
        JsonArray array = new JsonArray();
        for (Name n: list){
            JsonObject obj = new JsonObject();
            obj.addProperty("firstName",n.getFirstName());
            obj.addProperty("lastName",n.getLastName());
            obj.addProperty("email",n.getEmail());
            array.add(obj);
        }
        System.out.println(array.toString());
    }
}

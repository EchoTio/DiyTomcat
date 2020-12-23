package cn.diytomcat.test;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomizedURLClassLoader extends URLClassLoader {

    public CustomizedURLClassLoader(URL[] urls){
        super(urls);
    }

    public static void main(String[] args) throws Exception{
        URL url = new URL("/Users/yangjingbo/IdeaProjects/DiyTomcat/classes_4_test/test.jar");
        URL[] urls = new URL[] {url};

        CustomizedURLClassLoader loader = new CustomizedURLClassLoader(urls);

        Class<?> how2jclass = loader.loadClass("cn.diytomcat.test.HOW2J");

        Object o = how2jclass.newInstance();
        Method m = how2jclass.getMethod("hello");
        m.invoke(o);

        System.out.println(how2jclass.getClassLoader());

    }
}

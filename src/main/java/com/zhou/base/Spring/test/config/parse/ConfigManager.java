package com.zhou.base.Spring.test.config.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhou.base.Spring.test.config.Bean;
import com.zhou.base.Spring.test.config.Property;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/1 15:16
 */
public class ConfigManager {

    private static Map<String,Bean> map=new HashMap<String,Bean>();

    //读取配置文件并返回读取结果
    //返回Map集合便于注入,key是每个Bean的name属性,value是对应的那个Bean对象
    public static Map<String, Bean> getConfig(String path){
        /*dom4j实现
         *  1.创建解析器
         *  2.加载配置文件,得到document对象
         *  3.定义xpath表达式,取出所有Bean元素
         *  4.对Bean元素继续遍历
         *      4.1将Bean元素的name/class属性封装到bean类属性中
         *      4.2获得bean下的所有property子元素
         *      4.3将属性name/value/ref分装到类Property类中
         *  5.将property对象封装到bean对象中
         *  6.将bean对象封装到Map集合中,返回map
            */
        //1.创建解析器
        SAXReader reader=new SAXReader();
        //2.加载配置文件,得到document对象
    //    InputStream is = ConfigManager.class.getResourceAsStream(path);
        Document doc =null;
        try {
            File f = new File(path);
            InputStream in = new FileInputStream(f);
            doc = reader.read(in);
//            doc = reader.read(is);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请检查您的xml配置是否正确");
        }
        // 3.定义xpath表达式,取出所有Bean元素
        String xpath="//bean";

        //4.对Bean元素继续遍历
        List<Element> list = doc.selectNodes(xpath);
        if(list!=null){
            //4.1将Bean元素的name/class属性封装到bean类属性中

            // 4.3将属性name/value/ref分装到类Property类中
            for (Element bean : list) {
                Bean b=new Bean();
                String name=bean.attributeValue("name");
                String clazz=bean.attributeValue("class");
                String scope=bean.attributeValue("scope");
                b.setName(name);
                b.setClassName(clazz);
                if(scope!=null){
                    b.setScope(scope);
                }
                //  4.2获得bean下的所有property子元素
                List<Element> children = bean.elements("property");

                // 4.3将属性name/value/ref分装到类Property类中
                if(children!=null){
                    for (Element child : children) {
                        Property prop=new Property();
                        String pName=child.attributeValue("name");
                        String pValue=child.attributeValue("value");
                        String pRef=child.attributeValue("ref");
                        prop.setName(pName);
                        prop.setRef(pRef);
                        prop.setValue(pValue);
                        // 5.将property对象封装到bean对象中
                        b.getProperties().add(prop);
                    }
                }
                //6.将bean对象封装到Map集合中,返回map
                map.put(name, b);
            }
        }

        return map;
    }
}

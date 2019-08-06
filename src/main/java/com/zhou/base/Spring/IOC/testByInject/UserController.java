package com.zhou.base.Spring.IOC.testByInject;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @Description 用户Controller实现
 * @Author xiaohu
 * @Date 2019/8/5 12:51
 */
@Component
public class UserController {

    @Inject
    private UserService userService;

    @Inject
    private TestNoAnnotationClass annotationClass;

    private TestNoInjectClass injectClass;

    public void getUser() {
        User user = userService.getUser();
        System.out.println(user);
    }

    public void testNoAnnotation(){
        annotationClass.test();
    }

    public void testNoInject(){
        injectClass.test();
    }

    public void testInject() throws Exception {
        Map<Class<?>, Object> map = IocContext.applicationContext;
        for (Map.Entry<Class<?>, Object> entry : map.entrySet()) {
            if(entry.getKey().getName().equals("com.zhou.base.Spring.IOC.testByInject.UserController")){
                Class<?> clazz = entry.getKey();
                Object obj = entry.getValue();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if(field.getName().equals("injectClass")){
                        Class<?> fieldClazz = field.getType();
                        field.setAccessible(true);
                        Object fieldObj = map.get(fieldClazz);
                        field.set(obj, fieldObj);
                    }
                }
            }
        }
        injectClass.test();
    }

}

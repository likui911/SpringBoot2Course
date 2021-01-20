package com.spring;

import com.spring.pojo.Hello;
import com.spring.services.PetStoreService;
import com.spring.services.PetStoreServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());

        PetStoreService service = context.getBean("petStore", PetStoreServiceImpl.class);
        List<String> userList = service.getUsernameList();
        System.out.println(userList);
    }
}

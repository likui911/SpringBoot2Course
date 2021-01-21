package com.spring;

import com.spring.pojo.Hello;
import com.spring.pojo.ThingThree;
import com.spring.services.ClientService;
import com.spring.services.PetStoreService;
import com.spring.services.PetStoreServiceImpl;
import com.sun.security.ntlm.Client;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml","pojos.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());

        PetStoreService service = context.getBean("petStore", PetStoreServiceImpl.class);
        List<String> userList = service.getUsernameList();
        System.out.println(userList);

        ClientService clientService =  (ClientService)context.getBean(ClientService.class);
        clientService.doSomething();

        ThingThree three = (ThingThree) context.getBean("beanThree");
        System.out.println(three.toString());


    }
}

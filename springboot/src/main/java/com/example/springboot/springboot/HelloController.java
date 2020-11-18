package com.example.springboot.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-zuul
 * @ClassName: HelloController
 * @description: TODO
 * @author zxh
 * @date 2020-11-18 23:00:44
 * @version 1.0
 */
 @RestController
 @RequestMapping("/demo")
public class HelloController {

     @GetMapping("/hello")
     public String sayHello(String name){
         return "Hello " + name;
     }
}

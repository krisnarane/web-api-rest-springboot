package br.com.krisnarane.webApi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController //le o controller
public class WelcomeController {
    @GetMapping //mapear metodos 
    public String welcome(){
        return "Welcome to my Spring Boot API";
    }
}

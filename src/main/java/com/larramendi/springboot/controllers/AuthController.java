package com.larramendi.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Classe que captura a requisicao e retorna uma view

@Controller
public class AuthController {

    @GetMapping("/index")
    public String home() {
        return "index";
    }
}

package com.web.librery.controller;

import com.web.librery.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private LibroService libroService;

    public HomeController(LibroService libroService){
        this.libroService=libroService;
    }

    @GetMapping("")
    public String home(Model model){
        model.addAttribute("libros",libroService.findAll());
        return "usuario/home";
    }
}

package com.web.librery.controller;

import com.web.librery.domain.Libro;
import com.web.librery.service.LibroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private LibroService libroService;

    public HomeController(LibroService libroService){
        this.libroService=libroService;
    }

    @GetMapping("")
    public String home(Model model){
        model.addAttribute("libros",libroService.findAll());
        return "usuario/home";
    }

    @GetMapping("libroHome/{id}")
    public String libroHome(@PathVariable Long id, Model model){
        LOGGER.info("Id Libro enviado como parámetro {}",id);
        Libro libro = new Libro();
        Optional<Libro> libroOptional = libroService.get(id);
        libro = libroOptional.get();
        model.addAttribute("libro", libro);
        return "usuario/libroHome";
    }
}

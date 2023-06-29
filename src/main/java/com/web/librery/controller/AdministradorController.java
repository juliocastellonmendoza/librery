package com.web.librery.controller;

import com.web.librery.domain.Libro;
import com.web.librery.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    private LibroService libroService;

    public AdministradorController(LibroService libroService){
        this.libroService=libroService;
    }

    @GetMapping("")
    public String home(Model model){
        List <Libro> libros = libroService.findAll();
        model.addAttribute("libros",libros);
        return "administrador/home";
    }
}

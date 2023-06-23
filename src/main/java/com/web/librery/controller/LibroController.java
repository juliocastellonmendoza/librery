package com.web.librery.controller;

import com.web.librery.domain.Libro;
import com.web.librery.domain.Usuario;
import com.web.librery.service.LibroService;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libros")
public class LibroController {

    private final Logger LOGGER = LoggerFactory.getLogger(LibroController.class);

    private LibroService libroService;

    public LibroController(LibroService libroService){
        this.libroService=libroService;
    }

    @GetMapping("")
    public String show(Model model){

        model.addAttribute("libros",libroService.findAll());
        return "libros/show";
    }

    @GetMapping("/create")
    public String create(){
        return "libros/create";
    }

    @PostMapping("/save")
    public String save(Libro libro){
        LOGGER.info("El objeto libro {}",libro);
        Usuario usuario = new Usuario(1L,"","","","","","","");
        libro.setUsuario(usuario);
        libroService.save(libro);

        return "redirect:/libros";
    }

}

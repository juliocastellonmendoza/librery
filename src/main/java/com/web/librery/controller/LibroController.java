package com.web.librery.controller;

import com.web.librery.domain.Libro;
import com.web.librery.domain.Usuario;
import com.web.librery.service.LibroService;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){

        Libro libro = new Libro();
        Optional<Libro> optionalLibro=libroService.get(id);
        libro=optionalLibro.get();

        LOGGER.info("Libro buscado: {}",libro);
        model.addAttribute("libro",libro);

        return "libros/edit";
    }

    @PostMapping ("/update")
    public String update(Libro libro){
        libroService.update(libro);
        return "redirect:/libros";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        libroService.delete(id);
        return "redirect:/libros";
    }
}

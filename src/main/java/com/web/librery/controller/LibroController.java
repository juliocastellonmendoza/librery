package com.web.librery.controller;

import com.web.librery.domain.Libro;
import com.web.librery.domain.Usuario;
import com.web.librery.service.LibroService;
import com.web.librery.service.UPloadFileService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/libros")
public class LibroController {

    private final Logger LOGGER = LoggerFactory.getLogger(LibroController.class);

    private LibroService libroService;

    @Autowired
    private UPloadFileService upload;

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
    public String save(Libro libro,@RequestParam(name = "img") MultipartFile file) throws IOException {
        LOGGER.info("El objeto libro {}",libro);
        Usuario usuario = new Usuario(1L,"","","","","","","");
        libro.setUsuario(usuario);

        //imagen
        if(libro.getId_libro()==null){ //Cuando se crea un libro
            String nombreImagen = upload.saveImages(file);
            libro.setRuta(nombreImagen);
        }else{

        }
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
    public String update(Libro libro,@RequestParam(name = "img") MultipartFile file) throws IOException {
        if(file.isEmpty()){ //Cuando editamos el libro , pero no cambiamos la imagen
            Libro l = new Libro();
            l=libroService.get(libro.getId_libro()).get();
            libro.setRuta(l.getRuta());
        }else{//Cuando se edtia tambien la imagen

            Libro l = new Libro();
            l=libroService.get(libro.getId_libro()).get();

            if(!l.getRuta().equals("default.jpg")){
                upload.deleteImages(l.getRuta());
            }

            String nombreImagen = upload.saveImages(file);
            libro.setRuta(nombreImagen);
        }
        libroService.update(libro);
        return "redirect:/libros";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        Libro l = new Libro();
        l=libroService.get(id).get();
        //Eliminar cuando la imagen no sea por defecto
        if(!l.getRuta().equals("default.jpg")){
            upload.deleteImages(l.getRuta());
        }

        libroService.delete(id);
        return "redirect:/libros";
    }
}

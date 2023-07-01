package com.web.librery.controller;

import com.web.librery.domain.DetalleOrden;
import com.web.librery.domain.Libro;
import com.web.librery.domain.Orden;
import com.web.librery.service.LibroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private LibroService libroService;

    //Para almacenar los detalles de la orden
    private List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    //datos de la orden
    Orden orden = new Orden();

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

    @PostMapping("/cart")
    public String addCart(@RequestParam Long id, @RequestParam int cantidad,Model model){
        DetalleOrden detalleOrden = new DetalleOrden();
        Libro libro = new Libro();
        double sumaTotal=0;

        Optional<Libro> optionalLibro = libroService.get(id);
        LOGGER.info("Libro añadido: {}",optionalLibro.get());
        LOGGER.info("Cantidad: {}",cantidad);
        libro = optionalLibro.get();

        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(libro.getPrecio());
        detalleOrden.setNombre(libro.getTitulo());
        detalleOrden.setTotal(libro.getPrecio()*cantidad);
        detalleOrden.setLibro(libro);

        detalles.add(detalleOrden);

        sumaTotal=detalles.stream().mapToDouble(dt->dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart",detalles);
        model.addAttribute("orden",orden);

        return "usuario/carrito";
    }
}

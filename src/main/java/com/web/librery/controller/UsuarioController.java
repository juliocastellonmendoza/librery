package com.web.librery.controller;

import com.web.librery.domain.Usuario;
import com.web.librery.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    // /usuario/registro
    @GetMapping("/registro")
    public String create(){
        return "usuario/registro";
    }

    @PostMapping("/save")
    public String save(Usuario usuario){
        LOGGER.info("Usuario registro: {}",usuario);
        usuario.setTipo("USER");
        usuarioService.save(usuario);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "usuario/login";
    }
    //problema con el findByEmail


    @PostMapping("/acceder")
    public String acceder(Usuario usuario, HttpSession session){
        LOGGER.info("Accesos : {}",usuario);
        Optional<Usuario> user = usuarioService.fndUsuarioByEmail(usuario.getEmail());
        //LOGGER.info("Obteniendo session de usuario : {}",user.get());

        if(user.isPresent()){
            session.setAttribute("idUsuaro",user.get().getId_usuario());
            if(user.get().getTipo().equals("ADMIN")){
                return "redirect:/administrador";
            }else{
                return "redirect:/";
            }
        }else{
            LOGGER.info("Usuario no existe");
        }

        return "redirect:/";
    }



}

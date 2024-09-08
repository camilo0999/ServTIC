package com.servtic.aplicacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.servtic.aplicacion.models.Usuario;
import com.servtic.aplicacion.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
@RequestMapping("/servtic")
public class IncioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String registrarCliente(Model modelos) {

        modelos.addAttribute("cliente", new Usuario());

        return "public/registrarCliente";
    }

    @GetMapping("/inicio")
    public String incioServtic() {
        return "public/inicio";
    }

    @GetMapping("/login")
    public String login() {
        return "public/login";
    }

    @GetMapping("/sobre")
    public String paginaSobre() {
        return "public/servtic";
    }
    
    @GetMapping("/servicios")
    public String paginaServicios() {
        return "public/servicios";
    }

    @GetMapping("/contacto")
    public String getMethodName() {
        return "public/contacto";
    }
    

    @PostMapping("/registrarCliente")
    public String postMethodName( @ModelAttribute("cliente") Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/servtic/registro";
    }
    
    

}

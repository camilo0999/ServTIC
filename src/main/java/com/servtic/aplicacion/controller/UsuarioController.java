package com.servtic.aplicacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servtic.aplicacion.models.Usuario;
import com.servtic.aplicacion.service.UsuarioService;
import com.servtic.aplicacion.service.UsuarioServiceImp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public String cuentaUsuario(@PathVariable Long id, Model model) {
        try {
            // Se obtiene el usuario utilizando el servicio y se añade al modelo
            model.addAttribute("cliente", usuarioService.tomarUsuario(id));
        } catch (Exception e) {
            // Si ocurre una excepción, se podría añadir un mensaje de error al modelo para mostrarlo en la vista
            model.addAttribute("error", "No se pudo obtener la información del usuario.");
            // También puedes registrar el error si tienes un logger configurado
            logger.error("Error al obtener el usuario con id: " + id, e);
        }

        // Se retorna la vista correspondiente
        return "client/inicio";
    }

    @GetMapping("/{id}/reporte")
    public String reporteUsuario(@PathVariable Long id, Model model) {
        try {
            // Se obtiene el usuario utilizando el servicio y se añade al modelo
            model.addAttribute("cliente", usuarioService.tomarUsuario(id));
        } catch (Exception e) {
            // Si ocurre una excepción, se podría añadir un mensaje de error al modelo para mostrarlo en la vista
            model.addAttribute("error", "No se pudo obtener la información del usuario.");
            // También puedes registrar el error si tienes un logger configurado
            logger.error("Error al obtener el usuario con id: " + id, e);
        }

        // Se retorna la vista correspondiente
        return "client/reporte";
    }


    

}

package com.servtic.aplicacion.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servtic.aplicacion.models.Usuario;
import com.servtic.aplicacion.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioServiceImp implements UsuarioService{

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImp.class);

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public void registrarUsuario(Usuario usuario) {

        try {

            usuario.setRol("Cliente");

            usuarioRepository.save(usuario);

            logger.info("SE REGISTRÓ CORRECTAMENTE EL USUARIO: {}", usuario.getCorreo());
            
        } catch (Exception e) {
            
            logger.warn("SE GENERO UN ERROR AL REGISTRAR AL REGISTRAR EL CLIENTE: {}",usuario.getCorreo());

        }
       
    }


    @Override
    public Usuario tomarUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    

}

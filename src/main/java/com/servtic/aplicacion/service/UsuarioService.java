package com.servtic.aplicacion.service;

import com.servtic.aplicacion.models.Usuario;

public interface UsuarioService {

    public void registrarUsuario(Usuario usuario);

    public Usuario tomarUsuario(Long id);

}

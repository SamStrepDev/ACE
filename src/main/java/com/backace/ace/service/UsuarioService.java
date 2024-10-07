package com.backace.ace.service;

import com.backace.ace.model.Usuario;
import com.backace.ace.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String nombre, String correo, String cedula) {
        return usuarioRepository.findByNombreAndCorreoAndCedula(nombre, correo, cedula)
                .orElseThrow(() -> new IllegalArgumentException("Credenciales incorrectas"));
    }
}


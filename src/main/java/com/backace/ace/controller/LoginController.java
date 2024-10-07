package com.backace.ace.controller;

import com.backace.ace.model.Usuario;
import com.backace.ace.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        try {
            Usuario authenticatedUser = usuarioService.autenticar(
                    usuario.getNombre(),
                    usuario.getCorreo(),
                    usuario.getCedula()
            );
            return ResponseEntity.ok("Inicio de sesión exitoso. Bienvenido, " + authenticatedUser.getNombre());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas.");
        }
    }
}
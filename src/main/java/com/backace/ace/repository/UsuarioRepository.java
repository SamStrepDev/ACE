package com.backace.ace.repository;

import com.backace.ace.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreAndCorreoAndCedula(String nombre, String correo, String cedula);
}

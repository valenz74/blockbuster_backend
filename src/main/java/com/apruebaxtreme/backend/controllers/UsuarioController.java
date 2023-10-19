package com.apruebaxtreme.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apruebaxtreme.backend.dto.UsuarioDTO;
import com.apruebaxtreme.backend.models.Usuario;
import com.apruebaxtreme.backend.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/usuario")
    public UsuarioDTO registrarUsuario(@RequestBody Usuario usuario) {

        if (usuario.getPassword().length() < 8) {
            return new UsuarioDTO(usuario.getEmail(), "longitud de contraseña menor a 8");
        }

        usuario.setRol("USER");
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        return usuarioService.registrarUsuario(usuario);
    }
}

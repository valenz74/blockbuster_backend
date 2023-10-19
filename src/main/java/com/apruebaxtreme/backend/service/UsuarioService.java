package com.apruebaxtreme.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apruebaxtreme.backend.dto.UsuarioDTO;
import com.apruebaxtreme.backend.models.Usuario;
import com.apruebaxtreme.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioDTO registrarUsuario(Usuario usuario){

        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(usuario.getEmail());

        if(optionalUsuario.isEmpty()){
            usuarioRepository.save(usuario);
            return new UsuarioDTO(usuario.getEmail(),"registrado");
        }else{
            return new UsuarioDTO(usuario.getEmail(),"duplicado");
        }

    }
    
}

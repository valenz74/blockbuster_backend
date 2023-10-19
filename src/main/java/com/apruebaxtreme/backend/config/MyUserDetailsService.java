package com.apruebaxtreme.backend.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.apruebaxtreme.backend.models.Usuario;
import com.apruebaxtreme.backend.repository.UsuarioRepository;

@Configuration
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(username);

        if(!optionalUsuario.isPresent()){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        Usuario usuario = optionalUsuario.get();

        authorities.add(new SimpleGrantedAuthority(usuario.getRol()));

        User user = new User(username, optionalUsuario.get().getPassword(), authorities);
        
        return user;
    }
    
}

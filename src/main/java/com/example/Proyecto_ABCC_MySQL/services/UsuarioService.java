package com.example.Proyecto_ABCC_MySQL.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Proyecto_ABCC_MySQL.models.UsuarioModel;
import com.example.Proyecto_ABCC_MySQL.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, 
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void guardarUsuario(UsuarioModel usuario) {
        // Encripta la contraseña antes de guardarla en BD
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRole("USER");
        usuarioRepository.save(usuario);
    }

    public boolean existeUsername(String username) {
        return usuarioRepository.findByUsername(username).isPresent();
    }
}
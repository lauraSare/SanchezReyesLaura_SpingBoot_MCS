package com.example.Proyecto_ABCC_MySQL.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Proyecto_ABCC_MySQL.models.UsuarioModel;
import com.example.Proyecto_ABCC_MySQL.services.UsuarioService;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Mostrar formulario de login
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    // Mostrar formulario de registro
    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new UsuarioModel());
        return "registro";
    }

    // Procesar registro
    @PostMapping("/registro")
    public String procesarRegistro(@ModelAttribute("usuario") UsuarioModel usuario,
                                   Model model) {
        // Verificar si el username ya existe
        if (usuarioService.existeUsername(usuario.getUsername())) {
            model.addAttribute("error", "El usuario ya existe, elige otro nombre");
            return "registro";
        }

        usuarioService.guardarUsuario(usuario);
        return "redirect:/login?registroExitoso";
    }
}
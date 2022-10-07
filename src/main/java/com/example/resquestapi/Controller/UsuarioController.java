package com.example.resquestapi.Controller;

import Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.UsuarioRepository;
import request.models.Usuario;

import java.util.List;

@RestController
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String listAll(Model model) {
        List<Usuario> listStudents = usuarioService.getAllUsuarios();
        model.addAttribute("listUsuarios");

        return "students";
    }

}

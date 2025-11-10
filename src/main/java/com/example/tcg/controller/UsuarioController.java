package com.example.tcg.controller;

import com.example.tcg.model.Usuario;
import com.example.tcg.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/usuarios")
@Tag    (name = "", description = "")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Listado de Usuarios Registrados", description = "")
    public List<Usuario>getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por id", description = "")
    public Usuario getUsuarioById(@PathVariable String id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    @Operation(summary = "Añadir nuevo Usuario", description = "")
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar Usuario Existente", description = "")
    public Usuario updateUsuario(@RequestBody Usuario usuario,@PathVariable String id){
        Usuario UsuarioRegistrado = usuarioService.getUsuarioById(id);

        if(UsuarioRegistrado != null){
            UsuarioRegistrado.setCorreo(usuario.getCorreo());
            UsuarioRegistrado.setNombreApellido(usuario.getNombreApellido());
            UsuarioRegistrado.setPassword(usuario.getPassword());
            UsuarioRegistrado.setDireccion(usuario.getDireccion());
            return usuarioService.saveUsuario(UsuarioRegistrado);
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar Usuario", description = "")
    public void borrarUsuario(@PathVariable String id){
        usuarioService.deleteUsuario(id);
    }

    
    
}

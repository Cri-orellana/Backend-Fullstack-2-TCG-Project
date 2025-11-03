package com.example.tcg.controller;

import com.example.tcg.model.Usuario;
import com.example.tcg.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/usuarios")
@Api(value = "Administracion Usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @ApiOperation(value = "Listado de Usuarios Registrados", response = List.class)
    public List<Usuario>getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener usuario por id")
    public Usuario getUsuarioById(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    @ApiOperation(value = "Añadir nuevo Usuario")
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping
    @ApiOperation(value = "Modificar Usuario Existente")
    public Usuario updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
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
    @ApiOperation(value = "Borrar Usuario")
    public void borrarUsuario(@PathVariable Integer id){
        usuarioService.deleteUsuario(id);
    }

    
    
}

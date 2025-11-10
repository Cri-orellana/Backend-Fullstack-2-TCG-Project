package com.example.tcg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tcg.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,String> {

    
}
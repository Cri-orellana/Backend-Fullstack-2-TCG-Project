package com.example.tcg.model;



import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String correo;
    private String password;
    private String nombreApellido;
    private String direccion;
    public Usuario(Integer id, String correo, String password, String nombreApellido, String direccion) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.nombreApellido = nombreApellido;
        this.direccion = direccion;
    }

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNombreApellido() {
        return nombreApellido;
    }
    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    @Override
    public String toString() {
        return "Usuario [id=" + id + ", correo=" + correo + ", password=" + password + ", nombreApellido="
                + nombreApellido + ", direccion=" + direccion + "]";
    }

     
}

package com.emergentes;

public class Registro {
    
    private int id;
    private String nombre;
    private int peso;
    private int talla;
    private String vacuna;

    public Registro() {
        this.id=0;
        this.nombre = "";
        this.peso = 0;
        this.talla = 0;
        this.vacuna = "";
    }

    public String getNombre() {
        return nombre;
    }

    public int getPeso() {
        return peso;
    }

    public int getTalla() {
        return talla;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }
    
}

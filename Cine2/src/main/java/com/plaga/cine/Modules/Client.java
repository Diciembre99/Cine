package com.plaga.cine.Modules;

public class Client {
     private int id;
    private String nombre;
    private String dni;
    private int edad;

    public Client(int id, String nombre, String dni, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Client(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return " Cliente (" +
                " nombre: '" + nombre + '\'' +
                ", dni: '" + dni + '\'' +
                ", edad: " + edad +
                ")\n";
    }

}

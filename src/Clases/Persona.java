package Clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable {
 
    private int id;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    
    ArrayList<Campamento> campamentos = new ArrayList();

    public Persona() {
    }

    public Persona(int id, String dni, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public Persona(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public ArrayList<Campamento> getCampamentos() {
        return campamentos;
    }

    public void setCampamentos(Campamento c) {
        this.campamentos.add(c);
    }

}

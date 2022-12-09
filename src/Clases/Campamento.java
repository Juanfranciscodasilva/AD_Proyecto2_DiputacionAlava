package Clases;

import Converters.CampamentoConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Campamento{
        
    public int id;
    public String nombre;
    public String lugar;
    public Date fechaI;
    public Date fechaF;
    public int capacidad;
    
    List<Persona> personas = new ArrayList();

    public Campamento() {
    }

    public Campamento(int id, String nombre, String lugar, Date fechaI, Date fechaF, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.lugar = lugar;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.capacidad = capacidad;
    }
    
    public Campamento(String nombre, String lugar, Date fechaI, Date fechaF, int capacidad) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.capacidad = capacidad;
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Persona> getPersonas() {
        return personas;
    }
    
    public void setPersonas(List<Persona> p) {
        this.personas = p;
    }

    public void setPersona(Persona p) {
        this.personas.add(p);
    }
    
    public static XStream generarXStreamPreparado(){
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new CampamentoConverter());
        xStream.alias("campamento", Campamento.class);
        xStream.allowTypes(new Class[] {Campamento.class});
        return xStream;
    }
    
}

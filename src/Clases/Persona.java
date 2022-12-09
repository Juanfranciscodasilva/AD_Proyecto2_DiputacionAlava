package Clases;

import Converters.PersonaConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Persona {
 
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public Persona(){
    }

    public Persona(String dni, String nombre, String apellido1, String apellido2) {
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
    
    public String toString2(){
        return "- "+dni+" - "+nombre+" "+apellido1+" "+apellido2;
    }
    
    public static XStream generarXStreamPreparado(){
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new PersonaConverter());
        xStream.alias("persona", Persona.class);
        xStream.allowTypes(new Class[] {Persona.class});
        return xStream;
    }

}

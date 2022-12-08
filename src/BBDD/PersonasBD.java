package BBDD;

import Clases.Campamento;
import Clases.Persona;
import Clases.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonasBD {
    public static File bdPersonas = null;
    
    public static Response registrarPersona(Persona per){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            insertarPersona(per); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al registrar a la persona. Intentalo de nuevo.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static List<Persona> getAllPersonas() throws Exception{
        try{
            instanciarFichero();
            return getListaPersonasFromBD();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private static void instanciarFichero() throws Exception{
        try{
            bdPersonas = new File("personas.dat");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static Persona buscarPersonaByDni(String dni) throws Exception{
        try{
            FileInputStream input = new FileInputStream(bdPersonas);
            ObjectInputStream objIS = new ObjectInputStream(input);
            while(input.available() != 0){
                Persona persona = (Persona)objIS.readObject();
                if(persona.getDni().equalsIgnoreCase(dni)){
                    return persona;
                }
            }
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    private static void insertarPersona(Persona per) throws Exception{
        try {
            List<Persona> personas = getListaPersonasFromBD();
            per.setId(generarIdFromList(personas));
            personas.add(per);
            insertarListaPersonas(personas);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void insertarListaPersonas(List<Persona> personas) throws Exception{
        try {
            FileOutputStream fileout = new FileOutputStream(bdPersonas);
            ObjectOutputStream objOS = new ObjectOutputStream(fileout);
            for(Persona p : personas){
                objOS.writeObject(p);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static int generarIdFromList(List<Persona> personas){
        int id = 0;
        if(personas == null || personas.isEmpty()){
            return 0;
        }
        for(Persona p : personas){
            if(p.getId() > id){
                id = p.getId();
            }
        }
        return id+1;
    }
    
    private static List<Persona> getListaPersonasFromBD() throws Exception{
        try{
            List<Persona> personas = new ArrayList<>();
            if(bdPersonas.exists()){
                FileInputStream input = new FileInputStream(bdPersonas);
                ObjectInputStream objIS = new ObjectInputStream(input);
                while(input.available() != 0){
                    Persona camp = (Persona)objIS.readObject();
                    personas.add(camp);
                }
            }
            return personas;
        }catch(Exception ex){
            throw ex;
        }
    }
}

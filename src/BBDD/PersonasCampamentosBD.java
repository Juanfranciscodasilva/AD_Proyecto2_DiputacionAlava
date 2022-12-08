package BBDD;

import Clases.Campamento;
import Clases.CampamentoPersona;
import Clases.Persona;
import Clases.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonasCampamentosBD {
    public static File bdPersonasCampamentos = null;
    
    public static Response registrarInscripcion(Campamento camp, Persona per){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            if(!existeInscripcion(camp.getId(), per.getId())){
                insertarInscripcion(camp.getId(), per.getId()); 
            }else{
                respuesta.setCorrecto(false);
                respuesta.setMensajeError("Esta persona ya está inscrita en el campamento.");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al registrar la inscripción. Intentalo de nuevo.");
        }
        return respuesta;
    }
    
    public static int countOfPersonasInCampamento(Campamento camp){
        try{
            instanciarFichero();
            return getListaInscripcionesFromBD().size();
        }catch(Exception ex){
            return 0;
        }
    }
    
    public static Response eliminarInscripcionByCampamentoId(int idCampamento){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            deleteByCampamentoId(idCampamento); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al eliminar las personas inscritas.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static Response eliminarInscripcionByPersonaId(int idPersona){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            deleteByPersonaId(idPersona); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al eliminar las personas inscritas.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static Response eliminarInscripcionByCampamentoIdAndPersonaId(int idCampamento, int idPersona){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            deleteByCampamentoIdAndPersonaId(idCampamento,idPersona); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al eliminar la inscripción.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static List<CampamentoPersona> getAllByCampamentoId(int idCampamento){
        try{
            List<CampamentoPersona> inscripciones = getListaInscripcionesFromBD();
            return inscripciones.stream().filter(ins -> ins.getIdCampamento() == idCampamento).collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }
    
    public static List<CampamentoPersona> getAllByPersonaId(int idPersona){
        try{
            instanciarFichero();
            List<CampamentoPersona> inscripciones = getListaInscripcionesFromBD();
            return inscripciones.stream().filter(ins -> ins.getIdPersona() == idPersona).collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }
    
    private static void deleteByCampamentoId(int idCampamento) throws Exception{
        try {
            List<CampamentoPersona> inscripciones = getListaInscripcionesFromBD();
            inscripciones = inscripciones.stream().filter(cp -> cp.getIdCampamento() != idCampamento).collect(Collectors.toList());
            insertarListaInscripciones(inscripciones);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void deleteByPersonaId(int idPersona) throws Exception{
        try {
            List<CampamentoPersona> inscripciones = getListaInscripcionesFromBD();
            inscripciones = inscripciones.stream().filter(cp -> cp.getIdPersona() != idPersona).collect(Collectors.toList());
            insertarListaInscripciones(inscripciones);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void deleteByCampamentoIdAndPersonaId(int idCampamento, int idPersona) throws Exception{
        try {
            List<CampamentoPersona> inscripciones = getListaInscripcionesFromBD();
            inscripciones = inscripciones.stream().filter(cp -> !(cp.getIdPersona() == idPersona && cp.getIdCampamento() == idCampamento)).collect(Collectors.toList());
            insertarListaInscripciones(inscripciones);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void instanciarFichero() throws Exception{
        try{
            bdPersonasCampamentos = new File("campamentoPersona.dat");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private static void insertarInscripcion(int idCampamento, int idPersona) throws Exception{
        try {
            List<CampamentoPersona> inscripciones = getListaInscripcionesFromBD();
            CampamentoPersona campPer = new CampamentoPersona(idCampamento,idPersona);
            inscripciones.add(campPer);
            insertarListaInscripciones(inscripciones);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void insertarListaInscripciones(List<CampamentoPersona> inscripciones) throws Exception{
        try {
            FileOutputStream fileout = new FileOutputStream(bdPersonasCampamentos);
            ObjectOutputStream objOS = new ObjectOutputStream(fileout);
            for(CampamentoPersona inscripcion : inscripciones){
                objOS.writeObject(inscripcion);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static boolean existeInscripcion(int idCampamento, int idPersona){
        try{
            List<CampamentoPersona> inscripciones = getListaInscripcionesFromBD();
            return inscripciones.stream().anyMatch(cp -> cp.getIdCampamento() == idCampamento && cp.getIdPersona() == idPersona);
        }catch(Exception ex){
            return false;
        }
    }
    
    private static List<CampamentoPersona> getListaInscripcionesFromBD() throws Exception{
        try{
            List<CampamentoPersona> campamentosPersonas = new ArrayList<>();
            if(bdPersonasCampamentos.exists()){
                FileInputStream input = new FileInputStream(bdPersonasCampamentos);
                ObjectInputStream objIS = new ObjectInputStream(input);
                while(input.available() != 0){
                    CampamentoPersona inscripcion = (CampamentoPersona)objIS.readObject();
                    campamentosPersonas.add(inscripcion);
                }
            }
            return campamentosPersonas;
        }catch(Exception ex){
            throw ex;
        }
    }
}

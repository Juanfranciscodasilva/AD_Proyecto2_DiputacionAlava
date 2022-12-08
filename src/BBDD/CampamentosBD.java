package BBDD;

import Clases.Campamento;
import Clases.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CampamentosBD {
    public static File bdCampamentos = null;
    
    public static Response registrarCampamento(Campamento camp){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            insertarCampamento(camp); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al crear el campamento. Intentalo de nuevo.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static Response eliminarCampamento(Campamento camp){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            //TODO eliminar la relacion de la gente que esté inscrita en el campamento
            deleteCampamento(camp); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al eliminar el campamento. Intentalo de nuevo.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static Response modificarCampamento(Campamento camp){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            PersonasCampamentosBD.eliminarInscripcionByCampamentoId(camp.getId());
            updateCampamento(camp); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al eliminar el campamento. Intentalo de nuevo.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static Campamento findCampamentoById(Campamento camp){
        try{
            instanciarFichero();
            return buscarCampamentoById(camp);
        }catch(Exception ex){
            return null;
        }
    }
    
    private static void instanciarFichero() throws Exception{
        try{
            bdCampamentos = new File("campamentos.dat");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static List<Campamento> getAllCampamentos() throws Exception{
        try{
            instanciarFichero();
            return getListaCampamentosFromBD();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private static Campamento buscarCampamentoById(Campamento camp) throws Exception{
        try{
            FileInputStream input = new FileInputStream(bdCampamentos);
            ObjectInputStream objIS = new ObjectInputStream(input);
            while(input.available() != 0){
                Campamento campamento = (Campamento)objIS.readObject();
                if(campamento.getId() == camp.getId()){
                    return campamento;
                }
            }
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    private static void insertarCampamento(Campamento camp) throws Exception{
        try {
            List<Campamento> campamentos = getListaCampamentosFromBD();
            camp.setId(generarIdFromList(campamentos));
            campamentos.add(camp);
            insertarListaCampamentos(campamentos);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void deleteCampamento(Campamento camp) throws Exception{
        try {
            List<Campamento> campamentos = getListaCampamentosFromBD();
            campamentos = campamentos.stream().filter(c -> c.getId() != camp.getId()).collect(Collectors.toList());
            insertarListaCampamentos(campamentos);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static Response updateCampamento(Campamento camp) throws Exception{
        Response respuesta = new Response();
        try {
            List<Campamento> campamentos = getListaCampamentosFromBD();
            List<Campamento> campamentosEncontrados = campamentos.stream().filter(c -> c.getId() == camp.getId()).collect(Collectors.toList());
            Campamento encontrado = null;
            if(campamentosEncontrados != null && !campamentosEncontrados.isEmpty()){
                encontrado = campamentosEncontrados.get(0);
            }
            
            if(encontrado != null){
                if(PersonasCampamentosBD.countOfPersonasInCampamento(encontrado) > camp.getCapacidad()){
                    respuesta.setCorrecto(false);
                    respuesta.setMensajeError("Ya hay mas personas inscritas que la nueva capacidad del campamento indicada. Por favor"
                            + " indica una capacidad adecuada o reduce el número de inscripciones para poder continuar.");
                    return respuesta;
                }
                encontrado.setCapacidad(camp.getCapacidad());
                encontrado.setNombre(camp.getNombre());
                encontrado.setLugar(camp.getLugar());
                encontrado.setFechaI(camp.getFechaI());
                encontrado.setFechaF(camp.getFechaF());
            }
            insertarListaCampamentos(campamentos);
            return respuesta;
        } catch (Exception e) {
            return respuesta;
        }
    }
    
    private static void insertarListaCampamentos(List<Campamento> campamentos) throws Exception{
        try {
            FileOutputStream fileout = new FileOutputStream(bdCampamentos);
            ObjectOutputStream objOS = new ObjectOutputStream(fileout);
            for(Campamento c : campamentos){
                objOS.writeObject(c);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static int generarIdFromList(List<Campamento> campamentos){
        int id = 0;
        if(campamentos == null || campamentos.isEmpty()){
            return 0;
        }
        for(Campamento c : campamentos){
            if(c.getId() > id){
                id = c.getId();
            }
        }
        return id+1;
    }
    
    private static List<Campamento> getListaCampamentosFromBD() throws Exception{
        try{
            List<Campamento> campamentos = new ArrayList<>();
            if(bdCampamentos.exists()){
                FileInputStream input = new FileInputStream(bdCampamentos);
                ObjectInputStream objIS = new ObjectInputStream(input);
                while(input.available() != 0){
                    Campamento camp = (Campamento)objIS.readObject();
                    campamentos.add(camp);
                }
            }
            return campamentos;
        }catch(Exception ex){
            throw ex;
        }
    }
}

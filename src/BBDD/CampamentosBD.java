package BBDD;

import static BBDD.BBDDConfig.col;
import Clases.Campamento;
import Clases.Persona;
import Clases.Response;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

public class CampamentosBD {
    
    public static void comprobarXMLPrincipal() throws Exception{
        try{
            if (BBDDConfig.conectarBD() != null) {
                if(col.getResource("campamentos.xml") == null){
                    System.out.println("Se ha detectado que no está registrado el XML de campamentos.\nInsertando XML plantilla...");
                    XMLResource res = null;
                    res = (XMLResource)col.createResource("campamentos.xml", "XMLResource");
                    File f = new File(".\\ficherosBase\\plantillaCampamentos.xml");
                    res.setContent(f);
                    col.storeResource(res);
                    col.close();
                    System.out.println("Se ha registrado el XML de campamentos.");
                }
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if(col != null){
                try{
                    col.close();
                }catch(Exception ex){
                    System.out.println("Error al cerrar la colección, es posible que ya estuviese cerrada.");
                }
            }
        }
    }
    
    public static Response registrarCampamento(Campamento camp){
        Response respuesta = new Response();
        try{
            if (BBDDConfig.conectarBD() != null) {
                int idGenerado = generarIdCampamento();
                camp.setId(idGenerado);
                insertarCampamento(camp);
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al registrar el campamento. Intentalo de nuevo.");
            return respuesta;
        }finally{
            if(col != null){
                try{
                    col.close();
                }catch(Exception ex){
                    System.out.println("Error al cerrar la colección, es posible que ya estuviese cerrada.");
                }
            }
        }
        return respuesta;
    }
    
    public static Response registrarInscripcion(Campamento camp, Persona per){
        Response respuesta = new Response();
        try{
            if (BBDDConfig.conectarBD() != null) {
                respuesta = insertarInscripcionCampamento(camp,per);
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al registrar la inscripción. Intentalo de nuevo.");
            return respuesta;
        }finally{
            if(col != null){
                try{
                    col.close();
                }catch(Exception ex){
                    System.out.println("Error al cerrar la colección, es posible que ya estuviese cerrada.");
                }
            }
        }
        return respuesta;
    }
    
    public static Response retirarInscripcion(Campamento camp, Persona per){
        Response respuesta = new Response();
        try{
            if (BBDDConfig.conectarBD() != null) {
                respuesta = retirarInscripcionCampamento(camp,per);
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al retirar la inscripción. Intentalo de nuevo.");
            return respuesta;
        }finally{
            if(col != null){
                try{
                    col.close();
                }catch(Exception ex){
                    System.out.println("Error al cerrar la colección, es posible que ya estuviese cerrada.");
                }
            }
        }
        return respuesta;
    }
    
    public static Response eliminarCampamento(Campamento camp){
        Response respuesta = new Response();
        try{
            if (BBDDConfig.conectarBD() != null) {
                respuesta = deleteCampamento(camp); 
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al eliminar el campamento. Intentalo de nuevo.");
            return respuesta;
        }finally{
            if(col != null){
                try{
                    col.close();
                }catch(Exception ex){
                    System.out.println("Error al cerrar la colección, es posible que ya estuviese cerrada.");
                }
            }
        }
        return respuesta;
    }
    
    public static Response modificarCampamento(Campamento camp){
        Response respuesta = new Response();
        try{
            if (BBDDConfig.conectarBD() != null) {
                respuesta = updateCampamento(camp); 
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al modificar el campamento. Intentalo de nuevo.");
            return respuesta;
        }finally{
            if(col != null){
                try{
                    col.close();
                }catch(Exception ex){
                    System.out.println("Error al cerrar la colección, es posible que ya estuviese cerrada.");
                }
            }
        }
        return respuesta;
    }
    
    public static List<Campamento> getAllCampamentos() throws Exception{
        try{
            if (BBDDConfig.conectarBD() != null) {
                return getListaCampamentosFromBD();
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if(col != null){
                try{
                    col.close();
                }catch(Exception ex){
                    System.out.println("Error al cerrar la colección, es posible que ya estuviese cerrada.");
                }
            }
        }
    }
    
    public static List<Campamento> getAllCampamentosFromPersona(String dni) throws Exception{
        try{
            if (BBDDConfig.conectarBD() != null) {
                return getListaCampamentosDePersonaFromBD(dni);
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if(col != null){
                try{
                    col.close();
                }catch(Exception ex){
                    System.out.println("Error al cerrar la colección, es posible que ya estuviese cerrada.");
                }
            }
        }
    }
    
    private static void insertarCampamento(Campamento camp) throws Exception{
        try {
            XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            XStream xStream = Campamento.generarXStreamPreparado();
            String campXML = xStream.toXML(camp);
            ResourceSet result = servicio.query("update insert " + campXML + " into /campamentos");
            col.close();
        } catch (Exception e) {
            System.out.println("Error al registrar el campamento.");
            throw e;
        }
    }
    
    private static Response insertarInscripcionCampamento(Campamento camp, Persona per){
        Response respuesta = new Response();
        try {
            Campamento campBusqueda = getCampamentoById(camp.getId());
            if(campBusqueda != null){
                if(campBusqueda.getPersonas() != null && campBusqueda.getPersonas().size() >= campBusqueda.getCapacidad()){
                    respuesta.setCorrecto(false);
                    respuesta.setMensajeError("El campamento ha llegado al número máximo de personas inscritas");
                    return respuesta;
                }
                if(PersonasBD.existePersona(per)){
                    Persona inscripcionExistente = campBusqueda.getPersonas().stream()
                            .filter(p -> p.getDni().equalsIgnoreCase(per.getDni()))
                            .findFirst()
                            .orElse(null);
                    if(inscripcionExistente == null){
                        deleteCampamento(camp);
                        camp.getPersonas().add(per);
                        insertarCampamento(camp);
                    }else{
                        System.out.println("La persona ya está inscrita en este campamento");
                        respuesta.setCorrecto(false);
                        respuesta.setMensajeError("La persona ya está inscrita en este campamento");
                    }
                }else{
                    System.out.println("No se ha encontrado la persona que se quiere inscribir al campamento");
                    respuesta.setCorrecto(false);
                    respuesta.setMensajeError("No se ha encontrado la persona para inscribir");
                }
            } else {
                System.out.println("No se ha encontrado el campamento al que se quiere inscribir la persona");
                respuesta.setCorrecto(false);
                respuesta.setMensajeError("No se ha encontrado el campamento");
            }
            return respuesta;
        } catch (Exception e) {
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al modificar el campamento");
            return respuesta;
        }
    }
    
    private static Response retirarInscripcionCampamento(Campamento camp, Persona per){
        Response respuesta = new Response();
        try {
            Campamento campBusqueda = getCampamentoById(camp.getId());
            if(campBusqueda != null){
                if(PersonasBD.existePersona(per)){
                    deleteCampamento(camp);
                    List<Persona> listaModificada = camp.getPersonas().stream()
                            .filter(p -> !p.getDni().equalsIgnoreCase(per.getDni()))
                            .collect(Collectors.toList());
                    camp.setPersonas(listaModificada);
                    insertarCampamento(camp);
                }else{
                    System.out.println("No se ha encontrado la persona que se quiere retirar del campamento");
                    respuesta.setCorrecto(false);
                    respuesta.setMensajeError("No se ha encontrado la persona para retirar");
                }
            } else {
                System.out.println("No se ha encontrado el campamento del que se quiere retirar la persona");
                respuesta.setCorrecto(false);
                respuesta.setMensajeError("No se ha encontrado el campamento");
            }
            return respuesta;
        } catch (Exception e) {
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al modificar el campamento");
            return respuesta;
        }
    }
    
    private static Response deleteCampamento(Campamento camp) throws Exception{
        Response respuesta = new Response();
        try {
            Campamento busqueda = getCampamentoById(camp.getId());
            if (busqueda != null) {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query("update delete /campamentos/campamento[id=" + camp.getId() + "]");
                col.close();
            } else {
                System.out.println("No se ha encontrado el campamento a eliminar");
                respuesta.setCorrecto(false);
                respuesta.setMensajeError("No se ha encontrado el campamento");
            }
            return respuesta;
        } catch (Exception e) {
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al eliminar el campamento");
            return respuesta;
        }
    }
    
    private static Response updateCampamento(Campamento camp) throws Exception{
        Response respuesta = new Response();
        try {
            Campamento busqueda = getCampamentoById(camp.getId());
            if(busqueda != null){
                if(busqueda.getPersonas() != null && busqueda.getPersonas().size() > camp.getCapacidad()){
                    respuesta.setCorrecto(false);
                    respuesta.setMensajeError("Ya hay mas personas inscritas que la nueva capacidad del campamento indicada. Por favor"
                            + " indica una capacidad adecuada o reduce el número de inscripciones para poder continuar.");
                    return respuesta;
                }
                deleteCampamento(camp);
                camp.setPersonas(busqueda.getPersonas());
                insertarCampamento(camp);
            } else {
                System.out.println("No se ha encontrado el campamento a modificar");
                respuesta.setCorrecto(false);
                respuesta.setMensajeError("No se ha encontrado el campamento");
            }
            return respuesta;
        } catch (Exception e) {
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al modificar el campamento");
            return respuesta;
        }
    }
    
    private static Campamento getCampamentoById(int idCampamento){
        Campamento camp = null;
        try{
            XPathQueryService servicio;
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            StringBuilder query = new StringBuilder();
            query.append("for $c in /campamentos/campamento ");
            query.append("where $c/id=").append(idCampamento);
            query.append("return $c ");
            ResourceSet result = servicio.query(query.toString());
            ResourceIterator i;
            i = result.getIterator();
            XStream xStream = Campamento.generarXStreamPreparado();
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                String campXML = (String) r.getContent();
                Campamento campamento = (Campamento)xStream.fromXML(campXML);
                return campamento;
            }
            col.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return camp;
    }
    
    private static int generarIdCampamento() throws Exception{
        try{
            XPathQueryService servicio;
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            StringBuilder query = new StringBuilder();
            query.append("/campamentos/campamento[id = max(id)]/id/text()");
            ResourceSet result = servicio.query(query.toString());
            ResourceIterator i;
            i = result.getIterator();
            XStream xStream = Campamento.generarXStreamPreparado();
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                String idMasAlto = (String) r.getContent();
                return Integer.parseInt(idMasAlto)+1;
            }
            col.close();
            return 0;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
    
    private static List<Campamento> getListaCampamentosFromBD() throws Exception{
        try{
            List<Campamento> campamentos = new ArrayList<>();
            XPathQueryService servicio;
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            StringBuilder query = new StringBuilder();
            query.append("/campamentos/campamento");
            ResourceSet result = servicio.query(query.toString());
            ResourceIterator i;
            i = result.getIterator();
            XStream xStream = Campamento.generarXStreamPreparado();
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                String campXML = (String) r.getContent();
                Campamento camp = (Campamento)xStream.fromXML(campXML);
                campamentos.add(camp);
            }
            col.close();
            return campamentos;
        }catch (XMLDBException e) {
            System.out.println("Error al consultar el documento.");
            e.printStackTrace();
            throw e;
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    private static List<Campamento> getListaCampamentosDePersonaFromBD(String dni) throws Exception{
        try{
            List<Campamento> campamentos = new ArrayList<>();
            XPathQueryService servicio;
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            StringBuilder query = new StringBuilder();
            query.append("/campamentos/campamento[personas/persona/@dni = \"%%%%\"]");
            ResourceSet result = servicio.query(query.toString().replaceAll("%%%%", dni.toUpperCase()));
            ResourceIterator i;
            i = result.getIterator();
            XStream xStream = Campamento.generarXStreamPreparado();
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                String campXML = (String) r.getContent();
                Campamento camp = (Campamento)xStream.fromXML(campXML);
                campamentos.add(camp);
            }
            col.close();
            return campamentos;
        }catch (XMLDBException e) {
            System.out.println("Error al consultar el documento.");
            e.printStackTrace();
            throw e;
        }
        catch(Exception ex){
            throw ex;
        }
    }
}

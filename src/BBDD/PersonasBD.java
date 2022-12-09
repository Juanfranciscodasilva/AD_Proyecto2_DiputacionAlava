package BBDD;

import static BBDD.BBDDConfig.col;
import Clases.Persona;
import Clases.Response;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

public class PersonasBD {
    public static File bdPersonas = null;
    
    public static void comprobarXMLPrincipal() throws Exception{
        try{
            if (BBDDConfig.conectarBD() != null) {
                if(col.getResource("personas.xml") == null){
                    System.out.println("Se ha detectado que no está registrado el XML de personas.\nInsertando XML plantilla...");
                    XMLResource res = null;
                    res = (XMLResource)col.createResource("personas.xml", "XMLResource");
                    File f = new File(".\\ficherosBase\\plantillaPersonas.xml");
                    res.setContent(f);
                    col.storeResource(res);
                    col.close();
                    System.out.println("Se ha registrado el XML de personas.");
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
    
    public static Response registrarPersona(Persona per){
        Response respuesta = new Response();
        try{
            if (BBDDConfig.conectarBD() != null) {
                if(!existePersona(per)){
                    insertarPersona(per);
                }else{
                    respuesta.setCorrecto(false);
                    respuesta.setMensajeError("Ya hay una persona registrada con DNI: \""+per.getDni().toUpperCase()+"\"");
                }
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al registrar la persona. Intentalo de nuevo.");
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
    
    public static List<Persona> getAllPersonas() throws Exception{
        try{
            if (BBDDConfig.conectarBD() != null) {
                return getListaPersonasFromBD();
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
    
    public static boolean existePersona(Persona per) throws Exception{
        try{
            Persona busqueda = buscarPersonaByDni(per.getDni());
            return busqueda != null;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static Persona buscarPersonaByDni(String dni) throws Exception{
        try{
            XPathQueryService servicio;
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            StringBuilder query = new StringBuilder();
            query.append("for $p in /personas/persona ");
            query.append("where $p/dni=\"").append(dni.toUpperCase()).append("\" ");
            query.append("return $p ");
            ResourceSet result = servicio.query(query.toString());
            ResourceIterator i;
            i = result.getIterator();
            XStream xStream = Persona.generarXStreamPreparado();
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                String usuXML = (String) r.getContent();
                Persona persona = (Persona)xStream.fromXML(usuXML);
                return persona;
            }
            col.close();
            return null;
        }catch (XMLDBException e) {
            System.out.println("Error al consultar el documento.");
            e.printStackTrace();
            throw e;
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    private static void insertarPersona(Persona per) throws Exception{
        try {
            XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            XStream xStream = Persona.generarXStreamPreparado();
            String perXML = xStream.toXML(per);
            ResourceSet result = servicio.query("update insert " + perXML + " into /personas");
            col.close();
        } catch (Exception e) {
            System.out.println("Error al registrar la persona.");
            throw e;
        }
    }
    
    private static List<Persona> getListaPersonasFromBD() throws Exception{
        try{
            List<Persona> personas = new ArrayList<>();
            XPathQueryService servicio;
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            StringBuilder query = new StringBuilder();
            query.append("/personas/persona");
            ResourceSet result = servicio.query(query.toString());
            ResourceIterator i;
            i = result.getIterator();
            XStream xStream = Persona.generarXStreamPreparado();
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                String usuXML = (String) r.getContent();
                Persona persona = (Persona)xStream.fromXML(usuXML);
                personas.add(persona);
            }
            col.close();
            return personas;
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

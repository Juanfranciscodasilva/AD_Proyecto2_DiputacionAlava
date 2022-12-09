package BBDD;

import static BBDD.BBDDConfig.URI;
import static BBDD.BBDDConfig.col;
import static BBDD.BBDDConfig.driver;
import static BBDD.BBDDConfig.pass;
import static BBDD.BBDDConfig.usu;
import Clases.Response;
import Clases.Usuario;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

public class UsuariosAplicacionBD {
    
    public static void comprobarXMLPrincipal() throws Exception{
        try{
            if (BBDDConfig.conectarBD() != null) {
                if(col.getResource("usuarios.xml") == null){
                    System.out.println("Se ha detectado que no está registrado el XML de usuarios.\nInsertando XML plantilla...");
                    XMLResource res = null;
                    res = (XMLResource)col.createResource("usuarios.xml", "XMLResource");
                    File f = new File(".\\ficherosBase\\plantillaUsuarios.xml");
                    res.setContent(f);
                    col.storeResource(res);
                    col.close();
                    System.out.println("Se ha registrado el XML de usuarios.");
                }
            }else {
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
    
    public static Response iniciarSesion(Usuario usu){
        Response respuesta = new Response();
        try{
            if (BBDDConfig.conectarBD() != null) {
                Usuario usuario = buscarUsuarioByUsuarioYPassword(usu);
                if(usuario == null){
                    respuesta.setCorrecto(false);
                    respuesta.setMensajeError("No se ha encontrado el usuario con esas credenciales");
                }
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al iniciar sesión. Intentalo de nuevo.");
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
    
    public static Response registrarUsuario(Usuario usu){
        Response respuesta = new Response();
        try{
            if (BBDDConfig.conectarBD() != null) {
                if(!existeUsuario(usu)){
                    insertarUsuario(usu);
                }else{
                    respuesta.setCorrecto(false);
                    respuesta.setMensajeError("El usuario ya existe.");
                }
            } else {
                System.out.println("Error en la conexión. Comprueba datos.");
                throw new Exception("Error en la conexión. Comprueba datos.");
            }
        }catch(Exception ex){
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al iniciar sesión. Intentalo de nuevo.");
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
    
    private static Usuario buscarUsuarioByUsuarioYPassword(Usuario usu) throws Exception{
        try{
            XPathQueryService servicio;
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            StringBuilder query = new StringBuilder();
            query.append("for $u in /usuarios/usuario ");
            query.append("where $u/usu=\"").append(usu.getUsuario()).append("\" ");
            query.append("and $u/pass = \"").append(usu.getPassword()).append("\" ");
            query.append("return $u ");
            ResourceSet result = servicio.query(query.toString());
            ResourceIterator i;
            i = result.getIterator();
            XStream xStream = Usuario.generarXStreamPreparado();
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                String usuXML = (String) r.getContent();
                Usuario usuario = (Usuario)xStream.fromXML(usuXML);
                return usuario;
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
    
    private static Usuario buscarUsuarioByUsuario(Usuario usu) throws Exception{
        try{
            XPathQueryService servicio;
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            StringBuilder query = new StringBuilder();
            query.append("for $u in /usuarios/usuario ");
            query.append("where $u/usu=\"").append(usu.getUsuario()).append("\" ");
            query.append("return $u ");
            ResourceSet result = servicio.query(query.toString());
            ResourceIterator i;
            i = result.getIterator();
            XStream xStream = Usuario.generarXStreamPreparado();
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                String usuXML = (String) r.getContent();
                Usuario usuario = (Usuario)xStream.fromXML(usuXML);
                return usuario;
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
    
    private static boolean existeUsuario(Usuario usu) throws Exception{
        try{
            Usuario busqueda = buscarUsuarioByUsuario(usu);
            return busqueda != null;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private static void insertarUsuario(Usuario usu) throws Exception{
        try {
            XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            XStream xStream = Usuario.generarXStreamPreparado();
            String usuXML = xStream.toXML(usu);
            ResourceSet result = servicio.query("update insert " + usuXML + " into /usuarios");
            col.close();
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario.");
            throw e;
        }
    }
    
    private static List<Usuario> getListaUsuariosFromBD() throws Exception{
        try{
            List<Usuario> usuarios = new ArrayList<>();
            XPathQueryService servicio;
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            ResourceSet result = servicio.query("/usuarios/usuario");
            ResourceIterator i;
            i = result.getIterator();
            XStream xStream = Usuario.generarXStreamPreparado();
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                String usuXML = (String) r.getContent();
                Usuario usu = (Usuario)xStream.fromXML(usuXML);
                usuarios.add(usu);
            }
            col.close();
            return usuarios;
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

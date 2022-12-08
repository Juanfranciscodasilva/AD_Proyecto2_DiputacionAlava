package BBDD;

import Clases.Response;
import Clases.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class UsuariosAplicacionBD {

    public static File bdUsuarios = null;
    
    public static Response iniciarSesion(Usuario usu){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            Usuario usuario = buscarUsuarioByUsuarioYPassword(usu);
            if(usuario == null){
                respuesta.setCorrecto(false);
                respuesta.setMensajeError("No se ha encontrado el usuario con esas credenciales");
            }
        }catch(Exception ex){
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al iniciar sesión. Intentalo de nuevo.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static Response registrarUsuario(Usuario usu){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            if(!existeUsuario(usu)){
                insertarUsuario(usu);
            }else{
                respuesta.setCorrecto(false);
                respuesta.setMensajeError("El usuario ya existe.");
            }
        }catch(Exception ex){
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al crear el usuario. Intentalo de nuevo.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static void instanciarFichero() throws Exception{
        try{
            bdUsuarios = new File("usuarios.dat");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static Usuario buscarUsuarioByUsuarioYPassword(Usuario usu) throws Exception{
        try{
            FileInputStream input = new FileInputStream(bdUsuarios);
            ObjectInputStream objIS = new ObjectInputStream(input);
            while(input.available() != 0){
                Usuario usuario = (Usuario)objIS.readObject();
                if(usuario.getUsuario().equals(usu.getUsuario()) 
                        && usuario.getPassword().equals(usu.getPassword())){
                    return usuario;
                }
            }
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static Usuario buscarUsuarioByUsuario(Usuario usu) throws Exception{
        try{
            FileInputStream input = new FileInputStream(bdUsuarios);
            ObjectInputStream objIS = new ObjectInputStream(input);
            while(input.available() != 0){
                Usuario usuario = (Usuario)objIS.readObject();
                if(usuario.getUsuario().equals(usu.getUsuario())){
                    return usuario;
                }
            }
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static boolean existeUsuario(Usuario usu) throws Exception{
        try{
            Usuario busqueda = buscarUsuarioByUsuario(usu);
            return busqueda != null;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void insertarUsuario(Usuario usu) throws Exception{
        try {
            List<Usuario> usuarios = getListaUsuariosFromBD();
            FileOutputStream fileout = new FileOutputStream(bdUsuarios);
            ObjectOutputStream objOS = new ObjectOutputStream(fileout);
            usuarios.add(usu);
            for(Usuario u : usuarios){
                objOS.writeObject(u);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static List<Usuario> getListaUsuariosFromBD() throws Exception{
        try{
            List<Usuario> usuarios = new ArrayList<>();
            if(bdUsuarios.exists()){
                FileInputStream input = new FileInputStream(bdUsuarios);
                ObjectInputStream objIS = new ObjectInputStream(input);
                while(input.available() != 0){
                    Usuario usuario = (Usuario)objIS.readObject();
                    usuarios.add(usuario);
                }
            }
            return usuarios;
        }catch(Exception ex){
            throw ex;
        }
    }
}

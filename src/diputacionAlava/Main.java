package diputacionAlava;

import BBDD.BBDDConfig;
import BBDD.CampamentosBD;
import BBDD.PersonasBD;
import BBDD.UsuariosAplicacionBD;
import Clases.*;
import Ventanas.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    private static IniciarSesion vLogin;
    private static RegistrarUsuario vRegistrar;
    private static VPrincipal vPrincipal;
    private static CrearCampamento vCrearModificarCampamento;
    private static VerModificarEliminarCampamento vVerModificarEliminarCamp;
    private static InscribirPersona vInscribirPersona;
    private static CrearPersona vCrearPersona;
    private static RetirarPersona vRetirarPersona;
    private static VerPersonasCampamento vVerPersonasCampamento;

    public static void main(String[] args) throws Exception {
        try{
            BBDDConfig.comprobarRecursosYBD();
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error comprobando y registrando los XML base para la aplicación.","", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        vLogin = new IniciarSesion();
        vLogin.setVisible(true);
    }
    
    public static void CerrarPrograma(){
        hacerDisposeDeTodasLasVentanas();
        System.exit(0);
    }
    
    public static void abrirRegistrarUsuario(){
        vLogin.setVisible(false);
        vLogin.dispose();
        vRegistrar = new RegistrarUsuario();
        vRegistrar.setVisible(true);
    }
    
    public static void volverAlLogin(){
        vRegistrar.setVisible(false);
        vRegistrar.dispose();
        vLogin = new IniciarSesion();
        vLogin.setVisible(true);
        
    }
    
    public static void entrarALaAplicacion(){
        vLogin.setVisible(false);
        vLogin.dispose();
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void entrarACreacionDeCampamento(){
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
        vCrearModificarCampamento = new CrearCampamento(0,new Campamento());
        vCrearModificarCampamento.setVisible(true);
    }
    
    public static void entrarAModificacionDeCampamento(Campamento camp){
        vVerModificarEliminarCamp.setVisible(false);
        vVerModificarEliminarCamp.dispose();
        vCrearModificarCampamento = new CrearCampamento(1,camp);
        vCrearModificarCampamento.setVisible(true);
    }
    
    public static void cerrarCrearModificarCampamento(int opcion){
        vCrearModificarCampamento.setVisible(false);
        vCrearModificarCampamento.dispose();
        if(opcion==1){
            entrarVerModificarEliminarCamp(1);
        }else{
            vPrincipal = new VPrincipal();
            vPrincipal.setVisible(true);
        }
    }
    
    public static void entrarVerModificarEliminarCamp(int opcion){
        try{
            List<Campamento> campamentos = CampamentosBD.getAllCampamentos();
            if(vPrincipal != null){
                vPrincipal.setVisible(false);
                vPrincipal.dispose();
            }
            vVerModificarEliminarCamp = new VerModificarEliminarCampamento(opcion, campamentos);
            vVerModificarEliminarCamp.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abrir la ventana. Intentalo de nuevo.","",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void entrarCrearPersona(){
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
        vCrearPersona = new CrearPersona();
        vCrearPersona.setVisible(true);
    }
    
    public static void cerrarCrearPersona(){
        vCrearPersona.setVisible(false);
        vCrearPersona.dispose();
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void entrarRetirarPersona(int opcion){
        try{
            List<Persona> personas = PersonasBD.getAllPersonas();
            if(vPrincipal != null){
                vPrincipal.setVisible(false);
                vPrincipal.dispose();
            }
            vRetirarPersona = new RetirarPersona(personas,opcion);
            vRetirarPersona.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abrir la ventana. Intentalo de nuevo.","",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static void CerrarRetirarPersona(){
        vRetirarPersona.setVisible(false);
        vRetirarPersona.dispose();
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
     public static void entrarInscribirPersona(){
        try{
            List<Campamento> campamentos = CampamentosBD.getAllCampamentos();
            List<Persona> personas = PersonasBD.getAllPersonas();
            if(vPrincipal != null){
                vPrincipal.setVisible(false);
                vPrincipal.dispose();
            }
            vInscribirPersona = new InscribirPersona(campamentos,personas);
            vInscribirPersona.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abrir la ventana. Intentalo de nuevo.","",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void cerrarInscribirPersona(){
        vInscribirPersona.setVisible(false);
        vInscribirPersona.dispose();
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void cerrarVerModificarEliminarCamp(){
        vVerModificarEliminarCamp.setVisible(false);
        vVerModificarEliminarCamp.dispose();
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void abrirVerPersonasDeCampamento(){
        try{
            List<Campamento> campamentos = CampamentosBD.getAllCampamentosWithAllDatosPersonas();
            if(vPrincipal != null){
                vPrincipal.setVisible(false);
                vPrincipal.dispose();
            }
            vVerPersonasCampamento = new VerPersonasCampamento(campamentos);
            vVerPersonasCampamento.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abrir la ventana. Intentalo de nuevo.","",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void cerrarVerPersonasDeCampamento(){
        vVerPersonasCampamento.setVisible(false);
        vVerPersonasCampamento.dispose();
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void volverAlLoginConUsuario(Usuario usu){
        vRegistrar.setVisible(false);
        vRegistrar.dispose();
        vLogin = new IniciarSesion();
        vLogin.setVisible(true);
        vLogin.setUsuario(usu.getUsuario());
    }
    
    public static boolean iniciarSesion(Usuario usu){
        Response respuesta = UsuariosAplicacionBD.iniciarSesion(usu);
        return respuesta.isCorrecto();
    }
    
    public static void CerrarSesion(){
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
        vLogin = new IniciarSesion();
        vLogin.setVisible(true);
    }
    
    public static Response insertarUsuario(Usuario usu){
        return UsuariosAplicacionBD.registrarUsuario(usu);
    }
    
    public static Response insertarCampamento(Campamento camp){
        return CampamentosBD.registrarCampamento(camp);
    }
    
    public static Response insertarPersona(Persona per){
        return PersonasBD.registrarPersona(per);
    }
    
    public static Response insertarInscripcion(Campamento camp, Persona per){
        return CampamentosBD.registrarInscripcion(camp, per);
    }
    
    public static Response eliminarInscripcion(Persona per, Campamento camp){
        return CampamentosBD.retirarInscripcion(camp, per);
    }
    
    public static void hacerDisposeDeTodasLasVentanas(){
        if(vLogin != null){
            vLogin.dispose();
        }
        if(vRegistrar != null){
            vRegistrar.dispose();
        }
        if(vPrincipal != null){
            vPrincipal.dispose();
        }
        if(vCrearModificarCampamento != null){
            vCrearModificarCampamento.dispose();
        }
        if(vVerModificarEliminarCamp != null){
            vVerModificarEliminarCamp.dispose();
        }
        if(vInscribirPersona != null){
            vInscribirPersona.dispose();
        }
        if(vCrearPersona != null){
            vCrearPersona.dispose();
        }
        if(vRetirarPersona != null){
            vRetirarPersona.dispose();
        }
    }
    
    public static Response EliminarCampamento(Campamento camp){
        return CampamentosBD.eliminarCampamento(camp);
    }
    
    public static Response ModificarCampamento(Campamento camp){
        return CampamentosBD.modificarCampamento(camp);
    }
    
    public static List<Campamento> obtenerCampamentosByIdPersona(String dniPersona){
        List<Campamento> campamentos = new ArrayList<>();
        try{
            campamentos = CampamentosBD.getAllCampamentosFromPersona(dniPersona);
            if(campamentos == null){
                throw new Exception();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al obtener los campamentos de la persona.","",JOptionPane.ERROR_MESSAGE);
            campamentos = new ArrayList<>();
        }
        return campamentos;
    }
}

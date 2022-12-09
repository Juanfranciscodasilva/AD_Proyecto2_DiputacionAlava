package diputacionAlava;

import BBDD.BBDDConfig;
import Converters.CampamentoConverter;
import Converters.PersonaConverter;
import BBDD.CampamentosBD;
import BBDD.PersonasBD;
import BBDD.PersonasCampamentosBD;
import BBDD.UsuariosAplicacionBD;
import Clases.*;
import Ventanas.CrearCampamento;
import Ventanas.CrearPersona;
import Ventanas.IniciarSesion;
import Ventanas.InscribirPersona;
import Ventanas.RegistrarUsuario;
import Ventanas.RetirarPersona;
import Ventanas.VPrincipal;
import Ventanas.VerModificarEliminarCampamento;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.Date;
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

    public static void main(String[] args) throws Exception {
        try{
            BBDDConfig.comprobarRecursosYBD();
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error comprobando y registrando los XML base para la aplicación.","", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
//        Persona persona = new Persona();
//        persona.setDni("58046446N");
//        persona.setNombre("Juan");
//        persona.setApellido1("da silva");
//        persona.setApellido2("garcia");
//        
//        XStream xStream = Persona.generarXStreamPreparado();
//        
//        String a = xStream.toXML(persona);
//        System.out.println(a);
//        Persona perUnmarshall = (Persona)xStream.fromXML(a);
//        
//        Date fechaI = new Date();
//        Date fechaF = new Date();
//        fechaF.setTime(fechaI.getTime()+86400000);
//        Campamento camp = new Campamento(1,"camp1", "monte gorbea", fechaI, fechaF, 15);
//        camp.setPersona(persona);
      

//        xStream = Campamento.generarXStreamPreparado();
//        String b = xStream.toXML(camp);
//        System.out.println(b);
//        Campamento campUnmarshall = (Campamento)xStream.fromXML(b);
//        System.out.println(b);

//        Usuario usu = new Usuario("jfdasilva","12345Abcde");
//        XStream xStream = Usuario.generarXStreamPreparado();
//        
//        String a = xStream.toXML(usu);
//        Usuario usuMarshall = (Usuario)xStream.fromXML(a);
//        System.out.println(a);

//        vLogin = new IniciarSesion();
//        vLogin.setVisible(true);
//        vPrincipal = new VPrincipal();
//        vPrincipal.setVisible(true);
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
//        vLogin.setVisible(false);
//        vLogin.dispose();
//        vPrincipal = new VPrincipal();
//        vPrincipal.setVisible(true);
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
        return PersonasCampamentosBD.registrarInscripcion(camp, per);
    }
    
    public static Response eliminarInscripcion(Persona per, Campamento camp){
        return PersonasCampamentosBD.eliminarInscripcionByCampamentoIdAndPersonaId(camp.getId(), per.getId());
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
    }
    
    public static Response EliminarCampamento(Campamento camp){
        return CampamentosBD.eliminarCampamento(camp);
    }
    
    public static Response ModificarCampamento(Campamento camp){
        return CampamentosBD.modificarCampamento(camp);
    }
    
    public static List<Campamento> obtenerCampamentosByIdPersona(int idPersona){
        List<CampamentoPersona> listaInscripciones = PersonasCampamentosBD.getAllByPersonaId(idPersona);
        List<Campamento> campamentos = new ArrayList<>();
        try{
            if(listaInscripciones != null){
                for(CampamentoPersona ins : listaInscripciones){
                    Campamento camp = new Campamento();
                    camp.setId(ins.getIdCampamento());
                    Campamento campBuscado = CampamentosBD.findCampamentoById(camp);
                    if(campBuscado != null){
                        campamentos.add(campBuscado);
                    }
                }
            }else{
                throw new Exception();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al obtener los campamentos de la persona.","",JOptionPane.ERROR_MESSAGE);
            campamentos = new ArrayList<>();
        }
        return campamentos;
    }
}

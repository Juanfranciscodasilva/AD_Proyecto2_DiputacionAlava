package BBDD;

import java.lang.reflect.InvocationTargetException;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;

public class BBDDConfig {
    
    static String driver = "org.exist.xmldb.DatabaseImpl";
    static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/AD_Proyecto2_DiputacionAlava";
    static String usu = "admin";
    static String pass = "12345";
    static Collection col = null;
    
    public static void comprobarRecursosYBD() throws Exception{
        UsuariosAplicacionBD.comprobarXMLPrincipal();
        PersonasBD.comprobarXMLPrincipal();
        CampamentosBD.comprobarXMLPrincipal();
    }
    
    public static Collection conectarBD() throws Exception {
        try {
            Class cl = Class.forName(driver);
            Database database = (Database) cl.getDeclaredConstructor().newInstance();
            DatabaseManager.registerDatabase(database);
            col = DatabaseManager.getCollection(URI, usu, pass);
            return col;
        } catch (XMLDBException e) {
            System.out.println("Error al inicializar la BD eXist.");
            throw e;
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver de eXist.");
            throw e;
        } catch (InstantiationException e) {
            System.out.println("Error al instanciar la BD eXist.");
            throw e;
        } catch (IllegalAccessException e) {
            System.out.println("Error al instanciar la BD eXist.");
            throw e;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw e;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw e;
        }
    }
}

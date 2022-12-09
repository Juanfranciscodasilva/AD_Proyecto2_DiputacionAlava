package Clases;

import Converters.UsuarioConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.Serializable;

public class Usuario implements Serializable {
    
    public String usuario;
    
    public String password;

    public Usuario() {
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static XStream generarXStreamPreparado(){
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new UsuarioConverter());
        xStream.alias("usuario", Usuario.class);
        xStream.allowTypes(new Class[] {Usuario.class});
        return xStream;
    }
    
    
}

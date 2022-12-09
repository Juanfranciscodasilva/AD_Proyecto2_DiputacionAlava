package Converters;

import Clases.Usuario;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class UsuarioConverter implements Converter {
    
    public boolean canConvert(Class clazz) {
        return clazz.equals(Usuario.class);
    }

    public void marshal(Object objeto, HierarchicalStreamWriter writer,
        MarshallingContext context) {
        Usuario usu = (Usuario) objeto;
        writer.startNode("usu");
        writer.setValue(usu.getUsuario());
        writer.endNode();
        writer.startNode("pass");
        writer.setValue(usu.getPassword());
        writer.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader reader,
                    UnmarshallingContext context) {
            Usuario usu = new Usuario();
            reader.moveDown();
            usu.setUsuario(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            usu.setPassword(reader.getValue());
            reader.moveUp();
            return usu;
    }
}

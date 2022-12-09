package Converters;

import Clases.Persona;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class PersonaConverter implements Converter {
    
    public boolean canConvert(Class clazz) {
        return clazz.equals(Persona.class);
    }

    public void marshal(Object objeto, HierarchicalStreamWriter writer,
        MarshallingContext context) {
        Persona persona = (Persona) objeto;
        writer.startNode("dni");
        writer.setValue(persona.getDni().toUpperCase());
        writer.endNode();
        writer.startNode("nombre");
        writer.setValue(persona.getNombre());
        writer.endNode();
        writer.startNode("apellido1");
        writer.setValue(persona.getApellido1());
        writer.endNode();
        writer.startNode("apellido2");
        writer.setValue(persona.getApellido2());
        writer.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader reader,
                    UnmarshallingContext context) {
            Persona persona = new Persona();
            reader.moveDown();
            persona.setDni(reader.getValue().toUpperCase());
            reader.moveUp();
            reader.moveDown();
            persona.setNombre(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            persona.setApellido1(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            persona.setApellido2(reader.getValue());
            reader.moveUp();
            return persona;
    }
}

package Converters;

import Clases.Campamento;
import Clases.Persona;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CampamentoConverter implements Converter {
    
    String patternFecha = "dd/MM/yyyy hh:mm:ss";
    DateFormat formatoFecha = new SimpleDateFormat(patternFecha);  
    
    public boolean canConvert(Class clazz) {
        return clazz.equals(Campamento.class);
    }

    public void marshal(Object objeto, HierarchicalStreamWriter writer,
        MarshallingContext context) {
        Campamento campamento = (Campamento) objeto;
        writer.startNode("id");
        writer.setValue(String.valueOf(campamento.getId()));
        writer.endNode();
        writer.startNode("nombre");
        writer.setValue(campamento.getNombre());
        writer.endNode();
        writer.startNode("lugar");
        writer.setValue(campamento.lugar);
        writer.endNode();
        writer.startNode("fecha-inicio");
        writer.setValue(formatoFecha.format(campamento.getFechaI()));
        writer.endNode();
        writer.startNode("fecha-fin");
        writer.setValue(formatoFecha.format(campamento.getFechaF()));
        writer.endNode();
        writer.startNode("capacidad");
        writer.setValue(String.valueOf(campamento.getCapacidad()));
        writer.endNode();
        writer.startNode("personas");
        if(campamento.getPersonas() != null){
            for(Persona per : campamento.getPersonas()){
                writer.startNode("persona");
                writer.addAttribute("dni", per.getDni());
                writer.endNode();
            }
        }
        writer.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader reader,
                    UnmarshallingContext context) {
        try{
            Campamento camp = new Campamento();
            reader.moveDown();
            camp.setId(Integer.parseInt(reader.getValue().trim()));
            reader.moveUp();
            reader.moveDown();
            camp.setNombre(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            camp.setLugar(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            Date fechaInicio=new SimpleDateFormat(patternFecha).parse(reader.getValue()); 
            camp.setFechaI(fechaInicio);
            reader.moveUp();
            reader.moveDown();
            Date fechaFin=new SimpleDateFormat(patternFecha).parse(reader.getValue()); 
            camp.setFechaF(fechaFin);
            reader.moveUp();
            reader.moveDown();
            camp.setCapacidad(Integer.parseInt(reader.getValue().trim()));
            reader.moveUp();
            reader.moveDown();
            while(reader.hasMoreChildren()){
                reader.moveDown();
                String dni = reader.getAttribute("dni");
                Persona per = new Persona();
                per.setDni(dni);
                camp.setPersona(per);
            }
            reader.moveUp();
            return camp;
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error al convertir el campamento");
            return null;
        }
    }
}

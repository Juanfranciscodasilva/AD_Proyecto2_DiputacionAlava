package Clases;

import java.io.Serializable;

public class CampamentoPersona implements Serializable {
    int idCampamento;
    
    int idPersona;
    
    public CampamentoPersona(){
        
    }
    
    public CampamentoPersona(int idCampamento, int idPersona){
        this.idCampamento = idCampamento;
        this.idPersona = idPersona;
    }

    public int getIdCampamento() {
        return idCampamento;
    }

    public void setIdCampamento(int idCampamento) {
        this.idCampamento = idCampamento;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    
}

package Clases;

public class Response {

    public boolean correcto;

    public String mensajeError;

    
    public Response(){
        this.correcto = true;
        this.mensajeError = "";
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
    
}

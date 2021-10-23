package descCalendar.modelo;

import java.io.Serializable;

public class Invitacion implements Serializable{

    public static final long serialVersionUID = 3L;
    private Grupo grupo;
    private String mensaje;

    public Invitacion(Grupo grupo, String mensaje) {
        this.grupo = grupo;
        this.mensaje = mensaje;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "\n" + "Nombre del grupo: " + getGrupo().getNombre() 
                + "\nNombre del lider: " + getGrupo().getLider().getNombre() 
                + " " + getGrupo().getLider().getApellido() + "\n" + getMensaje()
                + "\n";
    }
}

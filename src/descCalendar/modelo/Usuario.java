package descCalendar.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{

    public static final long serialVersionUID = 3L;
    private String nombre;
    private String apellido;
    private String userName;
    private String direccion;
    private String correo;
    private String contrasena;
    private int telefono;
    //estado=true el usuario tiene grupo
    private boolean estado;
    private boolean lider;

    private LInvitaciones invitaciones;

    public Usuario(String nom, String ap, String un, String dir, String co, String contra, int tel) {
        nombre = nom;
        userName = un;
        apellido = ap;
        direccion = dir;
        correo = co;
        contrasena = contra;
        telefono = tel;
        estado = false;

        LInvitaciones invitaciones = new LInvitaciones();
        this.invitaciones = invitaciones;
    }

    public void setNombre(String name) {
        nombre = name;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUserName(String un) {
        userName = un;
    }

    public String getUserName() {
        return userName;
    }

    public void setApellido(String ape) {
        apellido = ape;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDirec(String direc) {
        direccion = direc;
    }

    public String getDirec() {
        return direccion;
    }

    public void setCorreo(String corre) {
        correo = corre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setContra(String contra) {
        contrasena = contra;
    }

    public String getContra() {
        return contrasena;
    }

    public void setTelf(int telf) {
        telefono = telf;
    }

    public int getTelf() {
        return telefono;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }
    
    public void setLider(boolean estado) {
        this.lider = estado;
    }

    public boolean getLider() {
        return lider;
    }

    public void setInvitaciones(LInvitaciones invitaciones) {
        this.invitaciones = invitaciones;
    }

    public LInvitaciones getInvitaciones() {
        return invitaciones;
    }

    @Override
    public String toString() {
        return "Nombre Completo:" + getNombre() + " " + getApellido() + "\n" + "Nombre de usuario: " + getUserName() + "\n" + "Dirección:"
                + getDirec() + "\n" + "Correo Electrónico: " + getCorreo() + "\n" + "Teléfono:" + getTelf()+ "\n";
    }
}

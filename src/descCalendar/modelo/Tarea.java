package descCalendar.modelo;

import java.io.File;
import java.io.Serializable;
import java.util.*;

public class Tarea implements Serializable{

    public static final long serialVersionUID = 3L;
    private int id;
    private String nombre;
    private String descripcion;
    private Usuario responsable;
    private LComentarios comentarios;
    private Calendar fEntrega;
    private LinkedList archivo;
    private String fichero;
    private boolean estado = false;

    public Tarea(String nombre, String descripcion, Usuario responsable, Calendar fEntrega) {
        LComentarios c = new LComentarios(); 
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.fEntrega = fEntrega;
        comentarios = c;
    }

    public void setArchivo(LinkedList archivo) {
        this.archivo = archivo;
    }
    public LinkedList getArchivo(){
        return archivo;
    }
    public void setFichero(String fichero) {
        this.fichero = fichero;
    }
    public String getFichero(){
        return fichero;
    }
    
    
    public void setId(int ID) {
        this.id = ID;
    }

    public int getId() {
        return id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setComentario(LComentarios comentarios) {
        this.comentarios = comentarios;
    }

    public LComentarios getLComentarios() {
        return comentarios;
    }
    
    public void agregarCom(Comentario x) {
        if(comentarios.raiz!=null){
            x.setID(comentarios.acceder(comentarios.tamanio()-1).getID()+1);
        }else{
            x.setID(0);
        }
        //x.setID(comentarios.tamanio()+1);
        comentarios.agregar(x);
    }

    public void setFEntrega(Calendar fEntrega) {
        this.fEntrega = fEntrega;
    }

    public Date getfEntrega() {
        return fEntrega.getTime();
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        String est;
        if (!getEstado()) {
            est = "Pendiente";
            if (comentarios!=null){
                return "Título: " + getNombre() + "\n" + "Responsable: " + getResponsable().getNombre() + "\n" + "Estado: "
                + est + "\n" + "Fecha de Entrega: " + getfEntrega() + "\n" + getDescripcion() + "\n" ;
            }else{
                return "Título: " + getNombre() + "\n" + "Responsable: " + getResponsable().getNombre() + "\n" + "Estado: "
                + est + "\n" + "Fecha de Entrega: " + getfEntrega() + "\n" + getDescripcion()+ "\n";
            }
        } else {
            est = "Realizado";
            if (comentarios!=null){
                return "Título: " + getNombre() + "\n" + "Responsable: " + getResponsable().getNombre() + "\n" + "Estado: "
                + est + "\n" + "Fecha de Entrega: " + getfEntrega() + "\n" + getDescripcion()+ "\n";
            }else{
                return "Título: " + getNombre() + "\n" + "Responsable: " + getResponsable().getNombre() + "\n" + "Estado: "
                + est + "\n" + "Fecha de Entrega: " + getfEntrega() + "\n" + getDescripcion()+ "\n";
            }
        }
        
    }
    
    public String toStringComentarios(){
        if(comentarios!=null){
            return getLComentarios().toString();
        }else{
            return "Ningun Comentario";
        }
    }
}

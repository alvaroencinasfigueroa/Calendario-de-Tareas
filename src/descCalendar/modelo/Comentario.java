package descCalendar.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Comentario implements Serializable{
    
    public static final long serialVersionUID = 3L;
    private int ID;
    private String autor;
    private String comentario;
    private Calendar f;

    public Comentario(String autor, String comentario) {
        this.autor = autor;
        this.comentario = comentario;
        this.f = Calendar.getInstance();
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }


    public void setFecha(Calendar f) {
        this.f = f;
    }

    public Date getfEntrega() {
        return f.getTime();
    }

    @Override
    public String toString() {
            int mes = f.get(Calendar.MONTH)+1;
            return getAutor() + "\n" 
                    +  "ID Comentario: " + getID() +  "\n" 
                    + f.get(Calendar.DAY_OF_MONTH) + "/" + mes 
                    + "/" + f.get(Calendar.YEAR) + "\n" + getComentario()+ "\n";
    }
}

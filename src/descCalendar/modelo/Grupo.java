package descCalendar.modelo;

import java.io.Serializable;

public class Grupo implements Serializable{

    public static final long serialVersionUID = 3L;
    private String nombre;
    private Usuario lider;
    private LIntegrantes integrantes;
    private LTareas tareas;
    private LHistorial historial;

    public Grupo(String nom, Usuario li) {
        LIntegrantes i = new LIntegrantes();
        LTareas t = new LTareas();
        LHistorial h = new LHistorial();
        
        nombre = nom;
        lider = li;
        integrantes = i;
        tareas = t;
        historial = h;
        
        
    }

    public void setNombre(String name) {
        nombre = name;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLider(Usuario nlider) {
        lider = nlider;
    }

    public Usuario getLider() {
        return lider;
    }

    public void setIntegrantes(LIntegrantes integrantes) {
        this.integrantes = integrantes;
    }

    public void sacarIntegrante(int pos) {
        integrantes.eliminar(pos);
    }

    public void editarIntegrante(int pos, Usuario usedit) {
        integrantes.remplazar(usedit, pos);
    }

    public LIntegrantes getListIntegrantes() {
        return integrantes;
    }

    public void agregarTarea(Tarea ntarea) {
        tareas.agregar(ntarea);
    }

    public void eliminarTarea(int pos) {
        tareas.eliminar(pos);
    }

    public void editarTarea(int pos, Tarea taedit) {
        tareas.remplazar(taedit, pos);
    }

    public LTareas getListTareas() {
        return tareas;
    }

    public void agregarHistoria(Tarea ntarea) {
        historial.agregar(ntarea);
    }

    public void eliminardHistoria(String nom) {
        historial.eliminar(nom);
    }

    public LHistorial getHistorial() {
        return historial;
    }

    @Override
    public String toString() {
        if (integrantes!=null){
        return "\n" + "Nombre:" + nombre+ "\n" + "Lider:"
                + getLider().toString() + "\n" + "\n" + "Integrantes: " + getListIntegrantes() + "\n";
        }else{
            return "\n" + "Nombre:" + nombre+ "\n" + "Lider:"
                + getLider().toString() + "\n" + "Integrantes: Vacio" + "\n";
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descCalendar.modelo;

import desCalendar.controlador.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.DefaultListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *

 */
public class Logica {
    DriverManager db;
    Connection c;
    SQLException sq;

    //usuarios contiene a los miembros/lideres de todos los grupos
    LIntegrantes usuarios = new LIntegrantes();
    LGrupos grupos = new LGrupos();

    Usuario l;
    Usuario miembro;

    private Coordinador coordinador;

    public Logica() {

        if (usuarios.raiz == null && grupos.raiz == null) {
            leerListas();
        }

    }

    public void crearGrupo(String nombre, Usuario l) {
        Grupo g = new Grupo(nombre, l);
        grupos.agregar(g);
        g.getListIntegrantes().agregar(l);
    }

    public boolean validarUsuario(String userName, String c) {
        if (usuarios.acceder(userName) != null) {
            Usuario u = usuarios.acceder(userName);
            if (u.getUserName().equals(userName) && u.getContra().equals(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarGrupo(String nombre, Usuario lider) {
        if (grupos.acceder(nombre) == null && !lider.getEstado()) {
            return true;
        }
        return false;
    }

    public boolean validarCorreo(String email) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarTelf(int i) {
        if (i > 10000000 && i < 99999999) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarContra(String password) {
        Pattern pattern = Pattern
                .compile("^(?=.*)[a-zA-Z0-9]{4,}$");

        Matcher mather = pattern.matcher(password);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarNombreUsuario(String uN) {
        if (usuarios.existe(uN)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarNombreTarea(String tarea, String nGrupo) {
        LTareas lT = grupos.acceder(nGrupo).getListTareas();
        LHistorial lH = grupos.acceder(nGrupo).getHistorial();
        if (lT.existe(tarea) || lH.existe(tarea)) {
                return false;
        } else {
            return true;
        }
    }

    public void guardarUsuario(Usuario u) {
        usuarios.agregar(u);
    }

    public void setCoordinador(Coordinador c) {
        coordinador = c;
    }

    //Usuarios sin grupo
    public String nombresMiembro(int i) {
        if (!usuarios.accederP(i).getEstado() && !usuarios.accederP(i).getLider()) {
            return usuarios.accederP(i).getUserName();
        } else {
            return null;
        }
    }

    public void invitar(String nombre, Usuario lider, String mensaje) {
        Invitacion in = new Invitacion(grupos.accederM(lider), mensaje);
        usuarios.acceder(nombre).getInvitaciones().agregar(in);
    }

    public LIntegrantes getUsuarios() {
        return usuarios;
    }

    public LGrupos getGrupos() {
        return grupos;
    }

    public DefaultComboBoxModel getNomTareas(Usuario u) {
        DefaultComboBoxModel nomTareas = new DefaultComboBoxModel();
        if (!grupos.accederM(u).getListTareas().vacio()) {
            for (int i = 0; i + 1 <= grupos.accederM(u).getListTareas().tamanio(); i++) {
                nomTareas.addElement(grupos.accederM(u).getListTareas().accederP(i).getNombre());
            }
        }
        return nomTareas;
    }

    public DefaultComboBoxModel getNomTareasRealizadas(Usuario u) {
        DefaultComboBoxModel nomTareas = new DefaultComboBoxModel();
        if (!grupos.accederM(u).getHistorial().vacio()) {
            for (int i = 0; i + 1 <= grupos.accederM(u).getHistorial().tamanio(); i++) {
                nomTareas.addElement(grupos.accederM(u).getHistorial().accederP(i).getNombre());
            }
        }
        return nomTareas;
    }

    public DefaultComboBoxModel getNomTareasUsuEsp(Usuario u) {
        DefaultComboBoxModel nomTareas = new DefaultComboBoxModel();
        for (int i = 0; i + 1 <= grupos.accederM(u).getListTareas().tamanio(); i++) {
            if (grupos.accederM(u).getListTareas().accederP(i).getResponsable().getUserName().equals(u.getUserName())) {
                nomTareas.addElement(grupos.accederM(u).getListTareas().accederP(i).getNombre());
            }
        }
        return nomTareas;
    }

    public DefaultListModel getComentarios(Usuario u, String nom) {
        DefaultListModel comentarios = new DefaultListModel();
        for (int i = 0; i + 1 <= grupos.accederM(u).getListTareas().accederNom(nom).getLComentarios().tamanio(); i++) {
            comentarios.addElement(grupos.accederM(u).getListTareas().accederNom(nom).getLComentarios().acceder(i).toString());
        }
        return comentarios;
    }

    public static Calendar fecha(int[] f) {
        Calendar fecha = new GregorianCalendar(f[0], f[1], f[2], f[3], f[4], 00);
        return fecha;
    }

    public DefaultComboBoxModel getIDComenUsuEsp(Usuario u, String nom) {
        DefaultComboBoxModel IDTareas = new DefaultComboBoxModel();
        LComentarios comentarios = grupos.accederM(u).getListTareas().accederNom(nom).getLComentarios();
        int i = comentarios.idPrimerComentario();
        if (i != 99999) {
            while (comentarios.accederID(i) != null) {
                IDTareas.addElement(comentarios.accederID(i).getID());
                i++;
            }
        }

        return IDTareas;
    }

    // Mètodo que busca tareas con characteres similares y los guarda las tareas en una lista
    public LTareas buscarCoincidenciasTareas(LTareas t, String tarea) {
        LTareas nList = new LTareas();
        int i = 0;
        while (t.accederP(i) != null) {
            if (comparar(t.accederP(i).getNombre(), tarea)) {
                nList.agregar(t.accederP(i));
            }
            i++;
        }
        return nList;
    }

    public LTareas buscarCoincidenciasTareas(LHistorial t, String tarea) {
        LTareas nList = new LTareas();
        int i = 0;
        while (t.accederP(i) != null) {
            if (comparar(t.accederP(i).getNombre(), tarea)) {
                nList.agregar(t.accederP(i));
            }
            i++;
        }
        return nList;
    }

    public LIntegrantes buscarCoincidenciasMiembros(LIntegrantes t, String nom) {
        LIntegrantes nList = new LIntegrantes();
        int i = 0;
        while (t.accederP(i) != null) {
            if (comparar(t.accederP(i).getUserName(), nom)) {
                nList.agregar(t.accederP(i));
            }
            i++;
        }
        return nList;
    }

    private boolean comparar(String p1, String p2) {
        int i = 0;
        int cont = 0;
        while (p1.length() > i && p2.length() > i) {
            if (p1.charAt(i) == p2.charAt(i)) {
                cont++;
            }
            i++;
        }
        if (cont >= p2.length()) {
            return true;
        } else {
            return false;
        }
    }

    //Archivos
    public void escribirListas() {
        try {

            ObjectOutputStream escribirUsuarios = new ObjectOutputStream(new FileOutputStream("C:/Users/Johan/Documents/NetBeansProjects/desc/Datos/Integrantes.dat"));
            escribirUsuarios.writeObject(usuarios);
            escribirUsuarios.close();

            ObjectOutputStream escribirGrupos = new ObjectOutputStream(new FileOutputStream("C:/Users/Johan/Documents/NetBeansProjects/desc/Datos/Grupos.dat"));
            escribirGrupos.writeObject(grupos);
            escribirGrupos.close();

        } catch (Exception e) {

        }
    }

    public void leerListas() {

        try {

            ObjectInputStream leyendoUsuarios = new ObjectInputStream(new FileInputStream("C:/Users/Johan/Documents/NetBeansProjects/desc/Datos/Integrantes.dat"));
            usuarios = (LIntegrantes) leyendoUsuarios.readObject();
            leyendoUsuarios.close();

            ObjectInputStream leyendoGrupos = new ObjectInputStream(new FileInputStream("C:/Users/Johan/Documents/NetBeansProjects/desc/Datos/Grupos.dat"));
            grupos = (LGrupos) leyendoGrupos.readObject();
            leyendoGrupos.close();

        } catch (Exception e) {

        }
    }

    public LinkedList leerArchivo(File fichero) {
        LinkedList archivo = new LinkedList();

        try {
            //guardando los bytes
            FileInputStream leerArchivo = new FileInputStream(fichero);
            int i = 0;
            boolean flag = true;
            while (flag) {
                int byteEntrada = leerArchivo.read();
                if (byteEntrada != -1) {
                    archivo.add(byteEntrada);
                    i++;
                } else {
                    flag = false;
                }
            }
            leerArchivo.close();
            return archivo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede adjuntar el archivo");
        }
        return null;
    }

    public String guardarArchivo(LinkedList archivo, File fichero) {
        try {
            FileOutputStream escribirArchivo = new FileOutputStream("C:/Users/Johan/Documents/NetBeansProjects/desc/Datos/" + fichero.getName());
            int i = 0;
            boolean flag = true;
            for (i = 0; i < archivo.size(); i++) {
                escribirArchivo.write((int) archivo.get(i));
            }
            escribirArchivo.close();
        } catch (Exception e) {

        }
        return "C:/Users/Johan/Documents/NetBeansProjects/desc/Datos/" + fichero.getName();
    }
    
    
    public void eliminarGrupo(LGrupos grupos, LIntegrantes usuarios, Grupo g){
        LIntegrantes lI=g.getListIntegrantes();
        int i =0;
        while(i<lI.tamanio()){
            lI.accederP(i).setEstado(false);
            usuarios.acceder(lI.accederP(i).getUserName()).setEstado(false);
            i++;
            
        }
        grupos.eliminar(g.getNombre());
        escribirListas();
    }
}

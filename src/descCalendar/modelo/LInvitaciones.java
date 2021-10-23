package descCalendar.modelo;

import java.io.Serializable;

public class LInvitaciones implements Serializable{

    public static final long serialVersionUID = 3L;
    Nodo<Invitacion> raiz;

    public LInvitaciones() {
        this.raiz = null;
    }

    public void agregar(Invitacion x) {
        if (raiz == null) {
            this.raiz = new Nodo<Invitacion>(x);
        } else {
            agregarR(raiz, x);
        }
    }

    private void agregarR(Nodo<Invitacion> tmp, Invitacion x) {
        if (tmp.sig != null) {
            agregarR(tmp.sig, x);
        } else {
            tmp.sig = new Nodo<Invitacion>(x);
        }
    }

    public void eliminar(String nombreGrupo) {

        int pos = posicion(nombreGrupo);
        Invitacion res = null;
        if (pos < tamanio()) {
            Nodo<Invitacion> tmp = raiz;
            Nodo<Invitacion> sig2;
            if (pos == tamanio() - 1) {
                if (pos == 0) {
                    raiz = null;
                } else {
                    for (int i = 0; i < pos - 1; i++) {
                        tmp = tmp.sig;
                    }
                    sig2 = tmp.sig;
                    res = sig2.dato;
                    tmp.sig = null;
                }
            } else {
                for (int i = 0; i < pos; i++) {
                    tmp = tmp.sig;
                }
                res = tmp.dato;
                sig2 = tmp.sig;
                tmp.dato = sig2.dato;
                tmp.sig = sig2.sig;
            }
        }

    }
    
    public int posicion(String nombreGrupo) {
        int i = 0;
        Nodo<Invitacion> tmp = raiz;

        while (tmp != null) {
            if (tmp.dato.getGrupo().getNombre().equals(nombreGrupo)) {
                return i;
            }
            tmp = tmp.sig;
            i++;
        }
        return 9999;
    }

    public Invitacion acceder(String nombreGrupo) {
        Nodo<Invitacion> tmp = raiz;
        int i = 0;
        if (tmp == null) {
            return null;
        } else {
            while (i < tamanio()) {
                if (tmp.dato.getGrupo().getNombre().equals(nombreGrupo)) {
                    return tmp.dato;
                }
                tmp = tmp.sig;
                i++;
            }
            return null;
        }
    }

    public Invitacion acceder(int pos) {
        if (pos >= tamanio()) {
            return null;
        } else {
            Nodo<Invitacion> tmp = raiz;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.sig;
            }
            return tmp.dato;
        }
    }

    public int tamanio() {
        if (raiz == null) {
            return 0;
        }
        Nodo tmp;
        tmp = raiz;
        int c = 1;
        while (tmp.sig != null) {
            tmp = tmp.sig;
            c++;
        }
        return c;
    }
    
    public void vaciar(){
        this.raiz=null;
    }

    @Override
    public String toString() {
        String res = "";
        if (raiz != null) {
            res = "";
            Nodo<Invitacion> tmp = raiz;
            while (tmp != null) {
                res = res + "\n" + tmp.dato.toString() + "\n";
                tmp = tmp.sig;
            }
            return res;
        } else {
            return null;
        }

    }
}

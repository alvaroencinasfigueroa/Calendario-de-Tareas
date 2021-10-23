package descCalendar.modelo;

import java.io.Serializable;

public class LHistorial implements Serializable{

    public static final long serialVersionUID = 3L;
    Nodo<Tarea> raiz;

    public LHistorial() {
        this.raiz = null;
    }

    public void agregar(Tarea x) {
        if (raiz != null) {
            x.setId(acceder(tamanio()).getId() + 1);
        } else {
            x.setId(1);
        }
        if (raiz == null && x.getEstado()) {
            this.raiz = new Nodo<Tarea>(x);
        } else {
            if (x.getEstado()) {
                agregarR(raiz, x);
            }
        }
    }

    private void agregarR(Nodo<Tarea> tmp, Tarea x) {
        if (tmp.sig != null) {
            agregarR(tmp.sig, x);
        } else {
            tmp.sig = new Nodo<Tarea>(x);
        }
    }

    public Tarea buscar(int id) {
        boolean flag = true;
        Nodo<Tarea> tmp = raiz;
        while (flag && tmp != null) {
            if (tmp.dato.getId() == id) {
                flag = false;
                return tmp.dato;
            } else {
                tmp = tmp.sig;
            }
        }
        return null;
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

    public void remplazar(Tarea t, int pos) {
        if (pos <= tamanio()) {
            Nodo<Tarea> tmp = raiz;
            int i = 1;
            while (i != pos) {
                tmp = tmp.sig;
                i++;
            }
            tmp.dato = t;
        }
    }

    public Tarea acceder(int id) {
        Nodo<Tarea> tmp = raiz;
        boolean flag = true;
        while (flag = true && tmp != null) {
            if (tmp.dato.getId() == id) {
                flag = false;
                return tmp.dato;
            } else {
                tmp = tmp.sig;
            }
        }
        return null;
    }
    
    public Tarea accederP(int pos) {
        if (pos >= tamanio()) {
            return null;
        }else{
            Nodo<Tarea> tmp = raiz;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.sig;
            }
            return tmp.dato;
        }
    }
    
    public boolean vacio() {
        if (raiz != null) {
            return false;
        } 
        return true;
    }
    
    public Tarea accederNom(String nom) {
        Nodo<Tarea> tmp = raiz;
        boolean flag = true;
        while (flag = true && tmp != null) {
            if (tmp.dato.getNombre().equals(nom)) {
                flag = false;
                return tmp.dato;
            } else {
                tmp = tmp.sig;
            }
        }
        return null;
    }

    private int posicion(String nombre) {
        int i = 0;
        Nodo<Tarea> tmp = raiz;

        while (tmp != null) {
            if (tmp.dato.getNombre().equals(nombre)) {
                return i;
            }
            i++;
            tmp = tmp.sig;
        }
        return 9999;
    }

    public void eliminar(String nom) {
        int pos = posicion(nom);
        Tarea res = null;
        if (pos < tamanio()) {
            Nodo<Tarea> tmp = raiz;
            Nodo<Tarea> sig2;
            if (pos == tamanio() - 1) {
                for (int i = 0; i < pos - 1; i++) {
                    tmp = tmp.sig;
                }
                sig2 = tmp.sig;
                res = sig2.dato;
                tmp.sig = null;
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

    public boolean existe(String tarea) {
        int i = 0;
        Nodo<Tarea> tmp = raiz;
        if (tamanio() == 0) {
            return false;
        } else {
            while (i < tamanio()) {
                if (tmp.dato.getNombre().equals(tarea)) {
                    return true;
                } else {
                    tmp = tmp.sig;
                }
                i++;
            }
            return false;
        }

    }
    
    @Override
    public String toString() {
        String res = "";
        if (raiz != null) {
            res = "";
            Nodo<Tarea> tmp = raiz;
            while (tmp != null) {
                res = res + "\n" + tmp.dato.toString() + "\n";
                tmp = tmp.sig;
            }
        }
        return res;
    }

}

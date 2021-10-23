package descCalendar.modelo;

import java.io.Serializable;

public class LGrupos implements Serializable{

    public static final long serialVersionUID = 3L;
    Nodo<Grupo> raiz;

    public LGrupos() {
        this.raiz = null;
    }

    public void agregar(Grupo x) {
        if (raiz == null) {
            this.raiz = new Nodo<Grupo>(x);
        } else {
            agregarR(raiz, x);
        }
    }

    private void agregarR(Nodo<Grupo> tmp, Grupo x) {
        if (tmp.sig != null) {
            agregarR(tmp.sig, x);
        } else {
            tmp.sig = new Nodo<Grupo>(x);
        }
    }

    public void remplazar(Grupo u, int pos) {
        if (pos <= tamanio()) {
            Nodo<Grupo> tmp = raiz;
            int i = 1;
            while (i != pos) {
                tmp = tmp.sig;
                i++;
            }
            tmp.dato = u;
        }
    }

    public boolean existe(String nom){
        int i = 0;
        Nodo<Grupo> tmp = raiz;
        if (tamanio() == 0) {
            return false;
        } else {
            while (i < tamanio()) {
                if (tmp.dato.getNombre().equals(nom)) {
                    return true;
                } else {
                    tmp = tmp.sig;
                }
                i++;
            }
            return false;
        }
    }
    
    public Grupo buscar(String nom) {
        int pos = 0;
        if (raiz != null) {
            pos = 1;
        }
        return buscarR(nom, pos);
    }

    private Grupo buscarR(String nom, int pos) {
        while (pos <= tamanio()) {
            String comp = acceder(nom).getNombre();
            if (nom.compareTo(comp) == 0) {
                return acceder(nom);
            }
            pos++;
        }
        return null;
    }

    public int posicion(String nombre) {
        int i = 0;
        Nodo<Grupo> tmp = raiz;

        while (tmp != null) {
            if (tmp.dato.getNombre().equals(nombre)) {
                return i;
            }
            i++;
            tmp = tmp.sig;
        }
        return 9999;
    }

    public int tamanio() {
        if (raiz == null) {
            return 0;
        }
        Nodo tmp = raiz;
        int c = 1;
        while (tmp.sig != null) {
            tmp = tmp.sig;
            c++;
        }
        return c;
    }
    
    public Grupo acceder(String nGrupo) {
        Nodo<Grupo> tmp = raiz;
        int i =0;
        if (raiz==null) {
            return null;
        } else {
            while (i<tamanio()) {
                if(tmp.dato.getNombre().equals(nGrupo)){
                    return tmp.dato;
                }
                tmp = tmp.sig;
                i++;
            }
            return null;
        }
    }

    public Grupo accederPos(int pos) {

        Nodo<Grupo> tmp = raiz;
        if (tmp == null) {
            return null;
        } else {
            int i = 0;
            while (i < tamanio()) {
                if (i==pos) {
                    return tmp.dato;
                } else {
                    tmp = tmp.sig;
                }
                i++;
            }
            return null;
        }
    }
    
    public Grupo accederM(Usuario miembro) {
        Nodo<Grupo> tmp = raiz;
        if (tmp == null) {
            return null;
        } else {
            int i = 0;
            while (i < tamanio()) {
                if (tmp.dato.getListIntegrantes().existe(miembro.getUserName())) {
                    return accederPos(i);
                } else {
                    tmp = tmp.sig;
                }
                i++;
            }
            return null;
        }
    }
    public void eliminar(String nom) {
        int pos = posicion(nom);
        Grupo res = null;
        if (pos < tamanio()) {
            Nodo<Grupo> tmp = raiz;
            Nodo<Grupo> sig2;
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

    @Override
    public String toString() {
        String res = "";
        if (raiz != null) {
            res = "";
            Nodo<Grupo> tmp = raiz;
            while (tmp != null) {
                
                res = res + tmp.dato.toString() + "\n";
                tmp = tmp.sig;
            }
        }
        return res;
    }
}

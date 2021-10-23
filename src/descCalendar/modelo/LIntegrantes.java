package descCalendar.modelo;

import java.io.Serializable;

public class LIntegrantes implements Serializable{

    public static final long serialVersionUID = 3L;
    Nodo raiz;

    public LIntegrantes() {
        this.raiz = null;
    }

    public void agregar(Usuario x) {
        if (raiz == null) {
            this.raiz = new Nodo<Usuario>(x);
        } else {
            agregarR(raiz, x);
        }
    }

    private void agregarR(Nodo<Usuario> tmp, Usuario x) {
        if (tmp.sig != null) {
            agregarR(tmp.sig, x);
        } else {
            tmp.sig = new Nodo<Usuario>(x);
        }
    }

    public boolean existe(String uN) {
        int i = 0;
        Nodo<Usuario> tmp = raiz;//para recorrer en la lista
        if (tamanio() == 0) {
            return false;
        } else {
            while (i < tamanio()) {
                if (tmp.dato.getUserName().equals(uN)) {
                    return true;
                } else {
                    tmp = tmp.sig;
                }
                i++;
            }
            return false;
        }

    }

    public void remplazar(Usuario u, int pos) {
        if (pos <= tamanio()) {
            Nodo<Usuario> tmp = raiz;
            int i = 1;
            while (i != pos) {
                tmp = tmp.sig;
                i++;
            }
            tmp.dato = u;
        }
    }

    public Usuario buscar(String uN) {
        int pos = 0;
        if (raiz != null) {
            pos = 1;
        }
        return buscarR(uN, pos);
    }

    //uN es el nombre de usuario
    private Usuario buscarR(String uN, int pos) {
        while (pos <= tamanio()) {
            String comp = acceder(uN).getNombre();
            if (uN.compareTo(comp) == 0) {
                return acceder(uN);
            }
            pos++;
        }
        return null;
    }
    

    public int posicion(String uN) {
        int i = 0;
        Nodo<Usuario> tmp = raiz;

        while (tmp != null) {
            if (tmp.dato.getUserName().equals(uN)) {
                return i;
            }
            tmp = tmp.sig;
            i++;
        }
        return 9999;
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

    public Usuario acceder(String uN) {
        int pos = posicion(uN);
        if (pos >= tamanio()) {
            return null;
        } else {
            Usuario res ;
            Nodo<Usuario> tmp = raiz;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.sig;
            }
            res = tmp.dato;
            return res;
        }
    }

    public Usuario accederP(int pos) {
        if (pos >= tamanio()) {
            return null;
        }else{
            Nodo<Usuario> tmp = raiz;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.sig;
            }
            return tmp.dato;
        }
    }

    public void eliminar(int pos) {
        Usuario res = null;
        if (pos < tamanio()) {
            Nodo<Usuario> tmp = raiz;
            Nodo<Usuario> sig2;
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

    
    public void eliminar2(String UserName) {
        int pos = posicion(UserName);
        Usuario res = null;
        if (pos < tamanio()) {
            Nodo<Usuario> tmp = raiz;
            Nodo<Usuario> sig2;
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
            Nodo<Usuario> tmp = raiz;
            while (tmp != null) {
                res = "\n"+ res + tmp.dato.toString() + "\n";
                tmp = tmp.sig;
            }
        }
        return res;
    }
}

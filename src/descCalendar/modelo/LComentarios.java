package descCalendar.modelo;

import java.io.Serializable;

public class LComentarios implements Serializable {

    public static final long serialVersionUID = 3L;
    Nodo<Comentario> raiz;

    public LComentarios() {
        this.raiz = null;
    }

    public void agregar(Comentario x) {
        if (raiz == null) {
            this.raiz = new Nodo<Comentario>(x);
        } else {
            agregarR(raiz, x);
        }
    }

    private void agregarR(Nodo<Comentario> tmp, Comentario x) {
        if (tmp.sig != null) {
            agregarR(tmp.sig, x);
        } else {
            tmp.sig = new Nodo<Comentario>(x);
        }
    }

    public Comentario buscar(int ID) {
        int pos = 0;
        if (raiz != null) {
            pos = 1;
        }
        return buscarR(ID, pos);
    }

    private Comentario buscarR(int ID, int pos) {
        while (pos <= tamanio()) {
            if (acceder(pos).getID() == ID) {
                return acceder(pos);
            }
            pos++;
        }
        return null;
    }

    public int posicion(int ID) {
        int i = 0;
        Nodo<Comentario> tmp = raiz;

        while (tmp != null) {
            if (tmp.dato.getID() == ID) {
                return i;
            }
            i++;
            tmp = tmp.sig;
        }
        return 9999;
    }

    public void remplazar(Comentario t, int pos) {
        if (pos <= tamanio()) {
            Nodo<Comentario> tmp = raiz;
            int i;
            i = 1;
            while (i != pos) {
                tmp = tmp.sig;
                i++;
            }
            tmp.dato = t;
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

    public Comentario acceder(int pos) {
        Nodo<Comentario> tmp = raiz;
        if (tmp == null) {
            return null;
        } else {

            for (int i = 0; i < pos; i++) {
                tmp = tmp.sig;
            }

            return tmp.dato;
        }
    }

    public void eliminar(int pos) {
        Comentario res = null;
        if (raiz.sig == null) {
            raiz = null;
        }
        if (pos < tamanio()) {
            Nodo<Comentario> tmp = raiz;
            Nodo<Comentario> sig2;

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

    public int idPrimerComentario() {
        if (raiz != null) {
            return raiz.dato.getID();
        } else {
            return 99999;
        }
    }

    public Comentario accederID(int id) {
        int i = 0;
        Nodo<Comentario> tmp = raiz;
        while (tmp != null) {
            if (tmp.dato.getID() == id) {
                return tmp.dato;
            } else {
                tmp = tmp.sig;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String res = "";
        if (raiz != null) {
            res = "";
            Nodo<Comentario> tmp = raiz;
            while (tmp != null) {
                res = res + tmp.dato.toString() + "\n";
                tmp = tmp.sig;
            }
        }
        return res;
    }
}

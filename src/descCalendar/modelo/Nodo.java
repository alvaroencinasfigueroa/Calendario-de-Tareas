package descCalendar.modelo;

import java.io.Serializable;

public class Nodo<T> implements Serializable{

    T dato;
    Nodo sig;

    public Nodo(T x) {
        dato = x;
        sig = null;
    }
}

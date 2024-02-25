/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 * Esta clase representa una lista de adyacencia utilizada en la representación de un grafo, guarda los enlaces que están conectados a cada vértice.
 * @author Jesus Ventura
 * @version 09/02/2024
 */
public class ListaAdyacencia{

    private Arco primero;
    private Arco ultimo;

    /**
     * Constructor de la clase ListaAdyacencia que inicializa la lista de adyacencia como vacía.
     */
    public ListaAdyacencia() {
        this.primero = null;
        this.ultimo = null;

    }

    /**
     * Método para verificar si hay un arco adyacente con el destino dado.
     * @param dato El destino del arco a buscar.
     * @return true si hay un arco adyacente con el destino dado, false en caso contrario.
     */
    public boolean adyacente(Object dato) {
        Arco actual;
        boolean encontrado;
        encontrado = false;
        actual = primero;
        while (actual != null && !dato.toString().equals(actual.getDestino().toString())) {
            actual = actual.getSiguiente();
        }
        if (actual != null) {
            encontrado = true;
        }
        return encontrado;
    }
    
    /**
     * Método para buscar un arco con el destino dado en la lista de adyacencia.
     * @param destino El destino del arco a buscar.
     * @return El arco encontrado o null si no se encuentra.
     */
    public Arco buscarArco(Object destino) {
        Arco arcoActual = primero;
        while (arcoActual != null) {
            if (arcoActual.getDestino().equals(destino)) {
                return arcoActual; // Se encontró el arco
            }
            arcoActual = arcoActual.getSiguiente();
        }
        return null; // No se encontró un arco que conecte con el nodo destino
    }
    
    /**
     * Método para eliminar aristas por ciudad.
     * @param ciudad La ciudad asociada a las aristas a eliminar.
     */
    public void eliminarAristasPorCiudad(Object ciudad) {
        Arco anterior = null;
        Arco actual = primero;

        // Eliminar aristas donde la ciudad es el destino
        while (actual != null) {
            if (actual.getDestino().equals(ciudad)) {
                if (anterior == null) {
                    primero = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                actual = actual.getSiguiente();
            } else {
                anterior = actual;
                actual = actual.getSiguiente();
            }
        }
    }

    /**
     * Método para verificar si la lista de adyacencia está vacía.
     * @return true si la lista de adyacencia está vacía, false en caso contrario.
     */
    public boolean esvacia() {
        return primero == null;
    }

    /**
     * Método para insertar un arco en la lista de adyacencia, manteniendo el orden ascendente por destino.
     * @param nodo El arco a insertar en la lista de adyacencia.
     */
    public void insertar(Arco nodo) {
        if (esvacia() || Integer.parseInt(nodo.getDestino().toString()) < Integer.parseInt(this.primero.getDestino().toString())) {
            nodo.setSiguiente(this.primero);
            this.primero = nodo;
        } else {
            Arco posicion = this.primero;
            while (posicion.getSiguiente() != null && Integer.parseInt(nodo.getDestino().toString()) > Integer.parseInt(posicion.getSiguiente().getDestino().toString())) {
                posicion = posicion.getSiguiente();
            }
            nodo.setSiguiente(posicion.getSiguiente());
            posicion.setSiguiente(nodo);
        }
    }
    
    /**
    * Método para agregar una nueva adyacencia con el destino especificado a la lista de adyacencia.
    * Si la adyacencia ya existe, no se realiza ninguna operación.
    * @param destino El destino de la nueva adyacencia.
    */
    public void nuevaAdyacencia(Object destino) {
        if (!adyacente(destino)) {
            Arco nodo = new Arco(destino);
            insertar(nodo);

        }

    }

    /**
    * Método para agregar una nueva adyacencia con el destino, distancia y feromonas especificados a la lista de adyacencia.
    * Si la adyacencia ya existe, no se realiza ninguna operación.
    * @param destino El destino de la nueva adyacencia.
    * @param distancia La distancia entre los nodos conectados por el arco.
    * @param feromonas El nivel de feromonas en el arco.
    */
    public void nuevaAdyacencia(Object destino, float distancia, float feromonas) {
        if (!adyacente(destino)) {
            Arco nodo = new Arco(destino, distancia, feromonas);
            insertar(nodo);

        }

    }
    
    /**
     * Método toString que devuelve una representación de cadena de la lista de adyacencia.
     * @return Una cadena que representa la lista de adyacencia.
     */
    @Override
    public String toString(){
        String cadena = "";
        Arco temporal = primero;
        while(temporal != null){
            cadena = cadena + temporal.getDestino().toString()+" ; ";
            temporal = temporal.getSiguiente();
        }
        return  cadena; 
    }

    /**
     * Método para obtener el primer arco en la lista de adyacencia.
     * @return El primer arco en la lista de adyacencia.
     */
    public Arco getPrimero() {
        return primero;
    }

    /**
     * Método para establecer el primer arco en la lista de adyacencia.
     * @param primero El nuevo primer arco en la lista de adyacencia.
     */
    public void setPrimero(Arco primero) {
        this.primero = primero;
    }

    /**
     * Método para obtener el último arco en la lista de adyacencia.
     * @return El último arco en la lista de adyacencia.
     */
    public Arco getUltimo() {
        return ultimo;
    }

    /**
     * Método para establecer el último arco en la lista de adyacencia.
     * @param ultimo El nuevo último arco en la lista de adyacencia.
     */
    public void setUltimo(Arco ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Constructor de la clase ListaAdyacencia que inicializa la lista de adyacencia con el primer y último arco especificados.
     * @param primero El primer arco en la lista de adyacencia.
     * @param ultimo El último arco en la lista de adyacencia.
     */
    public ListaAdyacencia(Arco primero, Arco ultimo) {
        this.primero = primero;
        this.ultimo = ultimo;
    }

}
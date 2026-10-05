package Estructuras;

public class ListaEnlazada<T> {
    private Nodo<T> head;
    private int size;

    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    // Metodo para agregar un elemento al final de la lista
    public void add(T data) {
        Nodo<T> newNode = new Nodo<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Nodo<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Metodo para obtener un elemento por su índice
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    // Metodo para obtener el tamaño de la lista
    public int size() {
        return size;
    }
}
public class EasyStructureData<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    /**
     * Agrega un elemento al final de la lista
     * @param element
     */
    void add(T element){
        addLast(element);
    }

    /**
     * Agrega un elemento al final de la lsta
     * @param element
     */
    void addLast(T element){
        if (isEmpty())
            inizialice(element);
        else {
            last.next = new Node<>(null,last,element);
            last = last.next;
            size ++;
        }
    }

    /**
     * Agrega un elemento al inicio de la lista
     * @param element
     */
    void addFirst(T element){
        if (isEmpty())
            inizialice(element);
        else {
            first.prev = new Node<>(first,null,element);
            size ++;
        }
    }

    /**
     * Agreaga a la lista actual otra lista l pasada por argumento
     * @param l
     */
    void addAll(EasyStructureData<T> l){
        last.next = l.first;
        l.first.prev = last;
        last = l.last;
        size += l.size;
    }

    /**
     *
     * @return la lista de elementos invertidos sin alterar la actual.
     */
    EasyStructureData<T> invertList(){
        T[] temporl = toArray();
        EasyStructureData<T> tem = new EasyStructureData<>();
        tem.addAll(temporl,false);
        return tem;
    }

    /**
     * Agrega un arreglo de elementos al final de la lista actual.
     * @param l
     * @param first es true los elementos son agregados en el orden que llegaron sino invertidos.
     */
    void addAll(T[]l,boolean first){
        if (first){
            for (int i = 0; i < l.length; i++) {
                add(l[i]);
            }
        }else{
            for (int i = l.length - 1; i > -1; i--) {
                add(l[i]);
            }
        }

    }

    /**
     * extrae el ultimo elemento agregado y lo elimina.
     * @return
     */
    T pop(){
     Node<T> temporal = last;
     last = last.prev;
     last.next = null;
     size --;
     return temporal.value;
    }

    /**
     * Agrega el elemento similar a la Pila
     * @param element
     */
    void push(T element){
        addLast(element);
    }

    /**
     * Agrega el elemento similar a la cola
     * @param element
     */
    void queue(T element){
        addFirst(element);
    }

    /**
     * Extrae el elemento similar a la cola
     * @return
     */
    T enqueue(){
        Node<T> temporal = first;
        first = first.next;
        first.prev = null;
        size --;
        return temporal.value;
    }

    /**
     *
     * @return un arreglo de los elementos de la lista.
     */
    T[] toArray(){
        Object[] array = new Object[size];
        int index = 0;
        Node<T> temporal = first;
        while (temporal != null){
            array[index ++] = temporal.value;
            temporal = temporal.next;
        }
        return (T[]) array;
    }

    /**
     * Inicializa la lista
     * @param element
     */
    private void inizialice(T element){
        Node<T> temporal = new Node<>(null,null,element);
        this.first = temporal;
        this.last = temporal;
        size ++;
    }

    /**
     *
     * @return true si la lista esta vacia.
     */
    boolean isEmpty(){return size == 0;}

    public static class Node<E>{
        Node<E> next;
        Node<E> prev;
        E value;

        public Node(Node<E> next, Node<E> prev, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }


}

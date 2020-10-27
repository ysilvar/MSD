public class EasyStructureData<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    void add(T element){
        addLast(element);
    }
    void addLast(T element){
        if (isEmpty())
            inizialice(element);
        else {
            last.next = new Node<>(null,last,element);
            last = last.next;
            size ++;
        }
    }
    void addFirst(T element){
        if (isEmpty())
            inizialice(element);
        else {
            first.prev = new Node<>(first,null,element);
            size ++;
        }
    }
    void addAll(EasyStructureData<T> l){
        last.next = l.first;
        l.first.prev = last;
        last = l.last;
        size += l.size;
    }
    EasyStructureData<T> invertList(){
        T[] temporl = toArray();
        EasyStructureData<T> tem = new EasyStructureData<>();
        tem.addAll(temporl,false);
        return tem;
    }
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
    T pop(){
     Node<T> temporal = last;
     last = last.prev;
     last.next = null;
     size --;
     return temporal.value;
    }
    void push(T element){
        addLast(element);
    }
    void queue(T element){
        addFirst(element);
    }
    T enqueue(){
        Node<T> temporal = first;
        first = first.next;
        first.prev = null;
        size --;
        return temporal.value;
    }
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
    private void inizialice(T element){
        Node<T> temporal = new Node<>(null,null,element);
        this.first = temporal;
        this.last = temporal;
        size ++;
    }
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

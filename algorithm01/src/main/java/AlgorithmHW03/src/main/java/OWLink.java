

public class OWLink<E> {
    private E link;
    private OWLink<E> next;

    public OWLink(E link) { //конструктор
        this.link = link;
    }

    public OWLink<E> getNext() {
        return next;
    }

    public void setNext(OWLink<E> l){
        this.next = l;
    }

    public E getValue() {
        return link;
    }
}

class OWList<E>{
    private OWLink<E> first;

    public boolean isEmpty(){
        return (first==null);
    }
    public void insert(E link){
        OWLink<E> l = new OWLink<>(link);
        l.setNext(first);
        this.first = l;
    }

    public OWLink<E> delete(){
        OWLink<E> t = first;
        first = first.getNext();
        return t;
    }

    public void display() {
        if (first == null) {
            System.out.println("{}");
        }
        OWLink<E> n = first;
        while(n!=null) {
            System.out.print(n.getValue()+", ");
            n = n.getNext();
        }
        System.out.println("");
    }

    public E find(E searchNode){
        OWLink<E> findNode = new OWLink<>(searchNode);
        OWLink<E> n = first;
        while(n!=null){
            if(n.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            n = n.getNext();
        }
        return null;
    }
}



import java.util.ListIterator;

public class TWLink<E>{
    private E link;
    private TWLink<E> next;
    private TWLink<E> previous;

    public TWLink(E link) { //конструктор
        this.link = link;
    }

    public TWLink<E> getNext() {
        return next;
    }

    public void setNext(TWLink<E> l) {
        if(l==null){
            this.previous=null;
        }else {
            this.next = l;
        }
    }

    public TWLink<E> getPrevious() {
        return previous;
    }

    public void setPrevious(TWLink<E> previous) {
        if(previous==null){
            this.previous=null;
        }else {
            this.previous = previous;
        }
    }

    public E getValue() {
        return link;
    }
}

class TWList<E> //implements ListIterator
         {
    private TWLink<E> first;
    private TWLink<E> last;

    public TWLink<E> getFirst() {
        return first;
    }

    public void setFirst(TWLink<E> first) {
        this.first = first;
    }

    public TWLink<E> getLast() {
        return last;
    }

    public void setLast(TWLink<E> last) {
        this.last = last;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(E link) {
        TWLink<E> f = new TWLink<>(link);
        if (first == null) {
            setFirst(f);
            setLast(f);
        } else {
            f.setNext(first);
            first.setPrevious(f);
            this.first = f;
        }

    }

    public void insertLast(E link) {
        TWLink<E> l = new TWLink<>(link);
        if (first == null) {
            setFirst(l);
            setLast(l);
        } else {
            l.setPrevious(last);
            last.setNext(l);
            this.last = l;
        }
    }

    public TWLink<E> delete() {
        if(first==last){
            first = null;
            last = null;
        }else {
            TWLink<E> t = first;
            first = first.getNext();
            return t;
        }
        return null;
    }

    public TWLink<E> deleteLast() {
        TWLink<E> t = last;
        last = last.getPrevious();
        return t;
    }

    public void display() {
        if (first == null||last == null) {
            System.out.println("{}");
        }
        TWLink<E> n = first;
        while (n!=null) {
            if(!n.equals(last)){
                System.out.print(n.getValue()+", ");
                n = n.getNext();
            }else{
                System.out.println(last.getValue()+"\n");
                break;
            }
        }
        System.out.println("");
    }

    public E find(E searchNode) {
        TWLink<E> findNode = new TWLink<>(searchNode);
        TWLink<E> n = first;
        while (n != null) {
            if (n.getValue().equals(findNode.getValue())) {
                return findNode.getValue();
            }
            n = n.getNext();
        }
        return null;
    }

//    @Override
//    public boolean hasNext() {
//        if(TWLink.next!=null) return true;
//        return false;
//    }
//
//    @Override
//    public Object next() {
//        return next;
//    }
//
//    @Override
//    public boolean hasPrevious() {
//        if(previous!=null) return true;
//        return false;
//    }
//
//    @Override
//    public Object previous() {
//        return previous;
//    }
//
//    @Override
//    public int nextIndex() {
//        return 0;
//    }
//
//    @Override
//    public int previousIndex() {
//        return 0;
//    }
//
//    @Override
//    public void remove() {
//
//    }
//
//    @Override
//    public void set(Object o) {
//
//    }
//
//    @Override
//    public void add(Object o) {
//
//    }
}

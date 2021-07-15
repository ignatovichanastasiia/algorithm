import java.util.Iterator;


public class TWLink<E> {
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
        if (l == null) {
            this.previous = null;
        } else {
            this.next = l;
        }
    }

    public TWLink<E> getPrevious() {
        return previous;
    }

    public void setPrevious(TWLink<E> previous) {
        if (previous == null) {
            this.previous = null;
        } else {
            this.previous = previous;
        }
    }

    public E getValue() {
        return link;
    }
}

class TWList<E> implements Iterable<E> {
    private TWLink<E> first;
    private TWLink<E> last;
    private int currentSize;
    private int index;

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
        TWLink<E> t = first;
        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.getNext();
        }
        return t;
    }

    public TWLink<E> deleteLast() {
        TWLink<E> t = last;
        last = last.getPrevious();
        return t;
    }

    public void display() {
        if (first == null || last == null) {
            System.out.println("{}");
        }
        TWLink<E> n = first;
        while (n != null) {
            if (!n.equals(last)) {
                System.out.print(n.getValue() + ", ");
                n = n.getNext();
            } else {
                System.out.println(last.getValue() + "\n");
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


    public int getCurrentSize() {
        currentSize = -1;
        if (first != null) {
            TWLink<E> n = first;
            index = 0;
            while (n != null) {
                n = n.getNext();
                index++;
            }
            currentSize = index + 1;
        }
        return currentSize;
    }

    public int getIndex(TWLink<E> elem) {
        index = -1;
        if (first != null) {
            TWLink<E> n = first;
            index = 0;
            while (!n.equals(elem)) {
                if (n.equals(last) && !last.equals(elem)) {
                    index = -1;
                    break;
                }
                n = n.getNext();
                index++;
            }
        }
        return index;
    }

    public TWLink<E> getElement(int index) {
        TWLink<E> n;
        if (index == 0) {
            n = first;
        } else {
            n = first;
            for (int i = 1; i <= index; i++) {
                n = n.getNext();
            }
        }
        return n;
    }

    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private int currentSize = getCurrentSize();
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < getCurrentSize() && getElement(currentIndex) != null;
            }

            @Override
            public E next() {
                return getElement(currentIndex++).getValue();
            }

            @Override
            public void remove() {
                TWLink<E> n = getElement(currentIndex);
                TWLink<E> pr = n.getPrevious();
                TWLink<E> nx = n.getNext();
                pr.setNext(nx);
                nx.setPrevious(pr);

            }
        };
        return it;
    }
}



//Попытка создать свой итератор.

//public class Iter<E> {
//    private TWLink<E> it;
//    private TWLink<E> itB;
//    private TWList<E> list;
//    private int size;
//    private int index;
//
//
//    public Iter(TWList<E> list){
//        this.list= list;
//        this.size = (getIndex(list.getLast())+1);
//        this.it = list.getFirst();
//        this.itB = list.getLast();
//    }
//
//    public int getIndex(TWLink<E> elem){
//        index = -1;
//        if(list.getFirst()!=null) {
//            TWLink<E> n = list.getFirst();
//            index = 0;
//            while (!n.equals(elem)) {
//                if(n.equals(list.getLast())&&!elem.equals(list.getLast())){
//                    index = -1;
//                    break;
//                }
//                n = n.getNext();
//                index++;
//            }
//        }
//        return index;
//    }
//
//    @Override
//    public boolean hasNext() {
//        if(it.next!=null) return true;
//        return false;
//    }
//
//    @Override
//    public Object next() {
//        return it.getNext();
//    }
//
//    @Override
//    public boolean hasPrevious() {
//        if(it.getPrevious()!=null) return true;
//        return false;
//    }
//
//    @Override
//    public Object previous() {
//        return it.getPrevious();
//    }
//
//    @Override
//    public int nextIndex() {
//        if((int ind = it.getIndex()+1)<size)return ind;
//            return 0;
//    }
//
//    @Override
//    public int previousIndex() {
//        if((int ind = it.getIndex()+1)<size)return ind;
//      return 0;
//    }
//
//    @Override
//    public void remove() {
//
//    }
//
//    @Override
//    public void set(Object o) {
//         if(Object o.
//    }
//
//    @Override
//    public void add(Object o) {
//
//    }
//}

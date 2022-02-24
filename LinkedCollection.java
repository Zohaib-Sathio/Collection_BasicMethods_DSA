
package collection;

public class LinkedCollection extends AbstractCollection{
    
    private int size;
    private final Node head = new Node();
    private class Node{
        Object object;
        Node prev, next;
        Node(){
            prev = next = this;
        }
        Node(Object object, Node prev, Node next){
            this.object = object;
            this.prev = prev;
            this.next = next;
        }
    }
    @Override
    public boolean add(Object object){
        head.prev = head.prev.next = new Node(object, head.prev, head);
        size++;
        return true;
    }
    
    //Applicable when data is of int type
    public int sum(){
        Iterator it = iterator();
        int sum = 0;
        while(it.hasNext()){
            sum += (Integer) it.next(); }
        return sum;
    }
    //Applicable when data is of int type
    public int highest(){
        Iterator it = iterator();
        int high = (Integer) it.next();
        while(it.hasNext()){
            int temp = (Integer) it.next();
            if(temp > high)
                high = temp;
        }
        return high;
    }
    //Applicable when data is of int type
    public int lowest(){
        Iterator it = iterator();
        int low = (Integer) it.next();
        while(it.hasNext()){
            int temp = (Integer) it.next();
            if(temp < low)
                low = temp;
        }
        return low;
    }
    //Applicable when data is of int type
    public float average(){
        Iterator it = iterator();
        float sum = 0;
        float total = 0;
        while(it.hasNext()){
            total++;
            sum += (Integer) it.next(); }
        return sum/total;
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public Iterator iterator() {
        return new Iterator(){
            private Node cursor = head.next;
            private boolean okToRemove = false;
            
            @Override
            public boolean hasNext() {
                return (cursor != head);
            }

            @Override
            public Object next() {
                if(cursor == head) throw new RuntimeException();
                okToRemove =true;
                Object temp = cursor.object;
                cursor = cursor.next;
                return temp;
            }

            @Override
            public void remove() {
                if(!okToRemove) throw new IllegalStateException();
                cursor.prev = cursor.prev.prev;
                cursor.prev.next = cursor;
                --size;
                okToRemove = false;
            }
        };
    }

    @Override
    public boolean contains(Object object) {
        Iterator it = iterator();
        while(it.hasNext())
            if(object.equals(it.next()))
                return true;
        return false;
    }
    
    
    
}

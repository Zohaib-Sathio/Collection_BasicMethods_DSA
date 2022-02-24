
package collection;

public class ArrayCollection extends AbstractCollection {
    
    private final int LENGTH = 16;
    private int size;
    private Object[] a = new Object[LENGTH];

    @Override
    public int size() {
        return size;
    }
    public boolean add(Object object){
        if(size == a.length){
            Object[] arr = new Object[a.length *2];
            for (int i = 0; i < a.length; i++) {
                arr[i] = a[i];
            }
            a = arr;
        }
        a[size++] = object;
        return true;
    }

    @Override
    public Iterator iterator() {
        return new Iterator(){
            private int i = 0;
            private boolean okToRemove = false;
            @Override
            public boolean hasNext(){
                return (i<size);
            }
            @Override
            public Object next(){
                if(i == size) throw new RuntimeException();
                okToRemove = true;
                return a[i++];
            }
            @Override
            public void remove(){
                if(!okToRemove) throw new IllegalStateException();
                a[--i] = a[--size];
                a[size] = null;
                okToRemove = false;
            }
        };
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
    public boolean contains(Object object) {
        Iterator it = iterator();
        while(it.hasNext())
            if(object.equals(it.next()))
                return true;
        return false;
    }

    
    }

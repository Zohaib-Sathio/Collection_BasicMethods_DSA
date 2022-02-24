
package collection;

interface collection{
    public boolean add(Object object);
    public void clear();
    public boolean contains(Object object);
    public boolean isEmpty();
    public Iterator iterator();
    public boolean remove(Object object);
    public int size();
}

interface Iterator{
    public boolean hasNext();
    public Object next();
    public void remove();
}
abstract class AbstractCollection implements collection{
    protected AbstractCollection(){
        
    }

    @Override
    public boolean add(Object object) {
        throw new IllegalStateException();
    }

    @Override
    public void clear() {
        Iterator it = iterator();
        while(it.hasNext()){
            it.next();
            it.remove();
        }
    }
    @Override
    public String toString(){
        if(isEmpty()) return "[]";
        Iterator it = iterator();
        StringBuffer buff = new StringBuffer("[" + it.next());
        while(it.hasNext()){
            buff.append(", ").append(it.next());
        }
        return (buff + "]");
    }

    @Override
    public abstract boolean contains(Object object);

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public abstract Iterator iterator();

    @Override
    public boolean remove(Object object) {
        Iterator it = iterator();
        if(object == null){
            while(it.hasNext()){
                if(it.next() == null){
                    it.remove();
                    return true;
                }
            }
        }
        else{
            while(it.hasNext()){
                if(it.next().equals(object)){
                    it.remove();
                    return true;
                }
        }
    } 
        return false;
    }

    @Override
    public abstract int size();
    
}


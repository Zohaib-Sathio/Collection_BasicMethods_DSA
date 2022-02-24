package collection;

public class Main {
    public static void main(String[] args) {
        
        //ArrayCollection Implementation
        
       ArrayCollection collection = new ArrayCollection();
       collection.add("Bag 1");
       collection.add("Bag 2");
       collection.add("Bag 3");
       collection.add("Bag 4");
       collection.add("Bag 5");
       collection.add("Bag 6");
       System.out.println(collection.toString());
       Iterator it;
       for(it = collection.iterator(); it.hasNext();){
           System.out.println(it.next());
       }
       System.out.println("Size: " + collection.size());
       
       
       
       System.out.println("Collection contains: ? " + collection.contains("Bag 4"));
       collection.remove("Bag 2");
       for(it = collection.iterator(); it.hasNext();){
           System.out.println(it.next());
       }
       System.out.println("Size: " + collection.size());
        
        //LinkedCollection Implementation

        LinkedCollection linkCol = new LinkedCollection();
        linkCol.add(13);
        linkCol.add(2);
        linkCol.add(33);
        linkCol.add(42);
        linkCol.add(5);
        System.out.println(linkCol.sum());
        System.out.println(linkCol.average());
        System.out.println(linkCol.highest());
        System.out.println(linkCol.lowest());
        System.out.println(linkCol.toString());
        
        Iterator it2;
        for(it2 = linkCol.iterator(); it2.hasNext();){
            System.out.println(it2.next());
        }
        System.out.println("Size: " + linkCol.size());
        
    }
}

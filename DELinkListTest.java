/**
 * @author Julian Chan Palomo
 * @author Ruth Castro Acosta
 */

public class DELinkListTest {
    
    /**
     * Method to test the DELinkList class
     * @param args
     */
    public static void main(String[] args) {
        DELinkList<Double> list = new DELinkList<Double>(); 
        list.insertFirst(4.99);
        list.insertFirst(2.99);
        list.insertFirst(6.99);
        list.insertFirst(8.99);
        list.displayList();    


        System.out.println("Primer elemento: " + list.getFirst());
        System.out.println("Ultimo elemento: " + list.getLast());
        System.out.println("Tamaño de la lista: " + list.getSize());
        list.insertInOrder(3.99);
        list.deleteKey(2.99);
        list.displayList(); 
        System.out.println("Posicion: " + list.findPosition(8.99));
        list.deleteAll();
        list.displayList();
    } 
}
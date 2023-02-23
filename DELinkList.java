
/**
 * @author Julian Chan Palomo
 * @author Ruth Castro Acosta
 */

public class DELinkList<T> {
    private DELink<T> first;
    private DELink<T> last; 
    
    public DELinkList() {
        first = null;
        last = null;
    }

    
    /** 
     * Method to check if the list is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return (first==null);
    }

    /** 
     * Method to insert a new link at the beginning of the list
     * @param dd
     */
    public void insertFirst(T dd) { 
        DELink<T> newLink = new DELink<T>(dd);
        if(isEmpty())
            last = newLink;
        newLink.setNext(first); 
        first = newLink;
    }

    /** 
     * Method to insert a new link at the end of the list
     * @param dd
     */
    public void insertLast(T dd) { 
        DELink<T> newLink = new DELink<T>(dd);
        if(isEmpty())
            first = newLink;
        else
            last.setNext(newLink);    
        last = newLink;
    }

    /** 
     * Method to delete the first link of the list
     */
    public void deleteFirst() {
        if(first.getNext() == null)
            last = null;
        first = first.getNext();    
    }

    /** 
     * Method to delete the last link of the list
     */
    public void deleteLast() {
        DELink<T> current = first;
        DELink<T> previous = first;
        while(current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        last = previous;
        last.setNext(null);
    }

    /** 
     * Method to display the list
     */
    public void displayList() {
        System.out.print("List (first--> ");
        DELink<T> current = first;
        while(current != null) {
            current.displayLink(); 
            current = current.getNext(); 
        }
        System.out.println("<--last)");
    }

    //1
    /**
     * Method to find the first element of the list
     */
    public T getFirst() {
        return first.getdData();
    }

    //1
    /**
     * Method to find the last element of the list
     */
    public T getLast() {
        return last.getdData();
    }

    //2
    /**
     * Method to find the size of the list
     * @return size
     */
    public int getSize(){
        int size = 0;
        DELink<T> current = first;
        while(current != null) {
            size++;
            current = current.getNext(); 
        }
        return size;
    }

    //3
    /**
     * Method to insert a new data in order
     * @param dd
     */
     
    public void insertInOrder(T dd) {
        DELink<T> newLink = new DELink<T>(dd);
        DELink<T> current = first;
        DELink<T> previous = first;
        while(current != null && ((Comparable) dd).compareTo((Comparable) current.getdData()) > 0) {
            previous = current;
            current = current.getNext(); 
        }
        if(current == first) {
            insertFirst(dd);
        } else {
            previous.setNext(newLink);
            newLink.setNext(current);
        }
    }

    //4
    /**
     * Method to update the old value to the new value
     * @param oldValue
     * @param newValue
     */
    public void updateOldtoNew(T oldValue, T newValue) {
        DELink<T> current = first;
        while (current != null) {
            if (current.getdData().equals(oldValue)) {
                current.setdData(newValue);
                return;
            }
            current = current.getNext();
        }
        System.out.println("Value not found.");
    }

    //5
    /**
     * Method to update the data in the index position
     * @param key
     * @param index
     */
    public void updatedData(T key, int index) {
        DELink<T> current = first;
        int cont = 0;
        if (isEmpty()) {
            return;
        }
        while (current != null) {
            if (cont == index) {
                current.setdData(key);
            }
            current = current.getNext();
            cont++;
        }
    }

    //6
    /**
     * Method to delete a data
     * @param key
     */
    public void deleteKey(T key) {
        DELink<T> current = first;
        DELink<T> previous = first;
        while (current != null) {
            if (current.getdData().equals(key)) {
                if (current == first) {
                    first = first.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                
            }
            previous = current;
            current = current.getNext();
        }
    }

    //7
    /**
     * Method to delete a data in the index position
     * @param index
     */
    public void deleteAt(int index) {
        DELink<T> current = first;
        if (isEmpty()) {
            return;
        }
        // caso cuando se el primer elemento de la lista en eliminar
        if (index == 0) {
            first = current.getNext();
        }
        // se almacena el elemento previo a eliminar
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.getNext();
        }

        // el indice es mayor al numero de elementos
        if (current == null || current.getNext() == null) {
            return;
        } // current.getNext es el elemento a eliminar
          // almacenamos en una variable temporal el elemento a eliminar
        current.setNext(current.getNext().getNext());
    }

    //8
    /**
     * Method to delete all the list
     */
    public void deleteAll() {
        first = null;
        last = null;
    }

    //9
    /**
     * Method to find the position of a data
     * @param value
     * @return cont
     * @return -1 if the data is not found
     */
    public int findPosition(T value) {
        DELink<T> current = first;
        int cont = 0;
        if (isEmpty()) {
            return -1;
        } else {
            while (current != null) {
                if (current.getdData().equals(value)) {
                    return cont;
                } else {
                    cont++;
                    current = current.getNext();
                }
            }

        }
        
        return -1;

    }
}
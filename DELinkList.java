class DELinkList<T> {
    private DELink<T> first;
    private DELink<T> last; 
    
    public DELinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first==null);
    }

    public void insertFirst(T dd) { 
        DELink<T> newLink = new DELink<T>(dd);
        if(isEmpty())
            last = newLink;
        newLink.setNext(first); 
        first = newLink;
    }

    public void insertLast(T dd) { 
        DELink<T> newLink = new DELink<T>(dd);
        if(isEmpty())
            first = newLink;
        else
            last.setNext(newLink);    
        last = newLink;
    }


    public DELink<T> deleteFirst() {
        DELink<T> temp = first;
        if(first.getNext() == null)
            last = null;
        first = first.getNext();
        return temp;    
    }

    public T deleteLast() {
        DELink<T> current = first;
        DELink<T> previous = first;
        while(current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        last = previous;
        last.setNext(null);
        return current.getdData();
    }

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
    public T getFirst() {
        return first.getdData();
    }

    //1
    public T getLast() {
        return last.getdData();
    }

    //2
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
    public void deleteAll() {
        first = null;
        last = null;
    }

    //9
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
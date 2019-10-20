

 
public class QueueElement<E> {
    private E e; //the element contained in this linked list
    private QueueElement<E> next; //the next element of the linked list

    /**
     * Creates queue element
     * @param e holds an element
     * @param n the reference for the next element in queue
     */
    public QueueElement (E e, QueueElement<E> n) {
        this.e = e;
        this.next = n;
    }

    /**
     * Method to set the element
     */
    public void setElement (E e) {
        this.e = e;
    }

    /**
     * Method to set the next linked list element
     */
    public void setNext (QueueElement<E> e) {
        this.next = e;
    }

    /**
     * Method to get the element.
     */
    public E getElement () {
        return this.e;
    }

    /**
     * Method to get the next linked list element
     */
    public QueueElement<E> getNext () {
        return this.next;
    }
}

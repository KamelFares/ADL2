import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Dequeue (Double-ended queue) class with exactly six operations.
 * This class serves as the basic data structure for the pyramid sort algorithm.
 */
public class Dequeue<T> {
    private LinkedList<T> data;
    
    /**
     * Constructor: Creates an empty dequeue
     */
    public Dequeue() {
        this.data = new LinkedList<>();
    }
    
    // ==================== THE SIX OPERATIONS ====================
    
    /**
     * Operation 1: Add element at the front
     */
    public void addFirst(T element) {
        data.addFirst(element);
    }
    
    /**
     * Operation 2: Add element at the rear
     */
    public void addLast(T element) {
        data.addLast(element);
    }
    
    /**
     * Operation 3: Remove and return element from the front
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        return data.removeFirst();
    }
    
    /**
     * Operation 4: Remove and return element from the rear
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        return data.removeLast();
    }
    
    /**
     * Operation 5: Peek at the front element without removing
     */
    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        return data.peekFirst();
    }
    
    /**
     * Operation 6: Peek at the rear element without removing
     */
    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        return data.peekLast();
    }
    
    // ==================== HELPER METHODS ====================
    
    /**
     * Check if dequeue is empty
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }
    
    /**
     * Get the size of the dequeue
     */
    public int size() {
        return data.size();
    }
    
    /**
     * String representation for debugging
     */
    @Override
    public String toString() {
        return data.toString();
    }
}

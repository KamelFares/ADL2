import java.util.LinkedList;

public class Dequeue<T> {
    private LinkedList<T> data;
    
    public Dequeue() {
        data = new LinkedList<>();
    }
    
    // Operation 1: Add element at the front
    public void addFirst(T element) {
        data.addFirst(element);
    }
    
    // Operation 2: Add element at the rear
    public void addLast(T element) {
        data.addLast(element);
    }
    
    // Operation 3: Remove and return element from the front (returns null if empty)
    public T removeFirst() {
        return data.pollFirst();
    }
    
    // Operation 4: Remove and return element from the rear (returns null if empty)
    public T removeLast() {
        return data.pollLast();
    }
    
    // Operation 5: Look at the front element without removing (returns null if empty)
    public T peekFirst() {
        return data.peekFirst();
    }
    
    // Operation 6: Look at the rear element without removing (returns null if empty)
    public T peekLast() {
        return data.peekLast();
    }
    
    // helper methods
    public boolean isEmpty() {
        return data.isEmpty();
    }
    
    public int size() {
        return data.size();
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}

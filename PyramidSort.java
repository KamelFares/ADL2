/**
 * PyramidSort - A recursive sorting algorithm using decks
 * 
 * Algorithm Concept:
 * The pyramid sort divides the input into 3 parts (like the 3 pyramids of Gizeh with 3 sections)
 * recursively sorts each part, and then merges them back together
 */
public class PyramidSort {
    
    private int comparisonCount = 0;
    
    public Dequeue<Integer> sort(Dequeue<Integer> input) {
        comparisonCount = 0;
        System.out.println("Starting PyramidSort on " + input.size() + " elements");
        Dequeue<Integer> result = pyramidSortRecursive(input, 0);
        System.out.println("Sorted and the stats are " + comparisonCount);
        return result;
    }
    
    
    private Dequeue<Integer> pyramidSortRecursive(Dequeue<Integer> input, int depth) {
        int size = input.size();
        
        // Base cases
        if (size == 0) {
            return new Dequeue<Integer>();
        }
        
        if (size == 1) {
            Dequeue<Integer> result = new Dequeue<Integer>();
            result.addLast(input.removeFirst());
            return result;
        }
        
        if (size == 2) {
            return sortTwo(input);
        }
        
        // Recursive case: Divide into 3 parts as the 3 pyramids of Gizeh with 3 sections using the deck as a temp memory
        printIndent(depth);
        System.out.println("Level " + depth + ": Dividing " + size + " elements into 3 parts");
        
        DivisionResult division = divideIntoThree(input);
        
        printIndent(depth);
        System.out.println("  Part1: " + division.part1.size() + " elements");
        printIndent(depth);
        System.out.println("  Part2: " + division.part2.size() + " elements");
        printIndent(depth);
        System.out.println("  Part3: " + division.part3.size() + " elements");
        
        // Recursively sort each part
        Dequeue<Integer> sorted1 = pyramidSortRecursive(division.part1, depth + 1);
        Dequeue<Integer> sorted2 = pyramidSortRecursive(division.part2, depth + 1);
        Dequeue<Integer> sorted3 = pyramidSortRecursive(division.part3, depth + 1);
        
        // Merge the three sorted dequeues
        printIndent(depth);
        System.out.println("Level " + depth + ": Merging 3 sorted parts");
        return mergeThree(sorted1, sorted2, sorted3);
    }
    
    /**
     * divide the input dequeue into 3 parts
     * Distribution strategy: Roundrobin to fix the three parts
     */
    private DivisionResult divideIntoThree(Dequeue<Integer> input) {
        Dequeue<Integer> part1 = new Dequeue<Integer>();
        Dequeue<Integer> part2 = new Dequeue<Integer>();
        Dequeue<Integer> part3 = new Dequeue<Integer>();
        
        int index = 0;
        while (!input.isEmpty()) {
            Integer element = input.removeFirst();
            
            // Round-robin distribution
            switch (index % 3) {
                case 0:
                    part1.addLast(element);
                    break;
                case 1:
                    part2.addLast(element);
                    break;
                case 2:
                    part3.addLast(element);
                    break;
            }
            index++;
        }
        
        return new DivisionResult(part1, part2, part3);
    }
    
    /**
     * Sort a dequeue with just 2 elements
     */
    private Dequeue<Integer> sortTwo(Dequeue<Integer> input) {
        Integer first = input.removeFirst();
        Integer second = input.removeFirst();
        
        Dequeue<Integer> result = new Dequeue<Integer>();
        comparisonCount++;
        
        if (first <= second) {
            result.addLast(first);
            result.addLast(second);
        } else {
            result.addLast(second);
            result.addLast(first);
        }
        
        return result;
    }
    
    /**
     * Merge three sorted dequeues into one sorted dequeue
     * This is the key operation only uses dequeue operations
     */
    private Dequeue<Integer> mergeThree(Dequeue<Integer> d1, Dequeue<Integer> d2, Dequeue<Integer> d3) {
        Dequeue<Integer> result = new Dequeue<Integer>();
        
        // Keep merging until all three dequeues are empty
        while (!d1.isEmpty() || !d2.isEmpty() || !d3.isEmpty()) {
            // Find the minimum among the front elements of non-empty dequeues
            Integer min = null;
            int minSource = 0;  // 1, 2, or 3
            
            if (!d1.isEmpty()) {
                min = d1.peekFirst();
                minSource = 1;
            }
            
            if (!d2.isEmpty()) {
                Integer val2 = d2.peekFirst();
                if (min == null || val2 < min) {
                    min = val2;
                    minSource = 2;
                }
                if (min != null) comparisonCount++;
            }
            
            if (!d3.isEmpty()) {
                Integer val3 = d3.peekFirst();
                if (min == null || val3 < min) {
                    min = val3;
                    minSource = 3;
                }
                if (min != null) comparisonCount++;
            }
            
            // Remove the min
            switch (minSource) {
                case 1:
                    result.addLast(d1.removeFirst());
                    break;
                case 2:
                    result.addLast(d2.removeFirst());
                    break;
                case 3:
                    result.addLast(d3.removeFirst());
                    break;
            }
        }
        
        return result;
    }
    
    /**
     * Helper class to hold the result of dividing into three parts
     */
    private static class DivisionResult {
        Dequeue<Integer> part1;
        Dequeue<Integer> part2;
        Dequeue<Integer> part3;
        
        DivisionResult(Dequeue<Integer> p1, Dequeue<Integer> p2, Dequeue<Integer> p3) {
            this.part1 = p1;
            this.part2 = p2;
            this.part3 = p3;
        }
    }
    
    /**
     * Print indentation for visualizing recursion depth
     */
    private void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }
    
    /**
     * Get the number of comparisons made during sorting
     */
    public int getComparisonCount() {
        return comparisonCount;
    }
}

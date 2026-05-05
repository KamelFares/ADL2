/**
 * Main class to run the Pyramid Sort demonstration
 * 
 * 
 * Algorithm Steps:
 * 1. BASE CASE: If dequeue has 0, 1, or 2 elements, sort directly
 * 2. DIVIDE: Split dequeue into 3 equal (or nearly equal) parts
 * 3. CONQUER: Recursively sort each of the 3 parts
 * 4. COMBINE: Merge the 3 sorted dequeues into one sorted dequeue
 * 
 * Key Constraints:
 * ----------------
 * - Only uses the 6 Dequeue operations (addFirst, addLast, removeFirst, 
 *   removeLast, peekFirst, peekLast)
 * - No arrays, lists, or other data structures
 * - Multiple dequeue instances are allowed
 * - Object-oriented design with multiple classes
 * - Uses recursion
 * 
 * Complexity:
 * -----------
 * Implementation Status:
 * ----------------------
 * ✓ Dequeue class with 6 operations
 * ✓ PyramidSort with recursive division into 3 parts
 * ✓ Merge operation for 3 sorted dequeues
 * ✓ Comprehensive test suite
 * ✓ Object-oriented design
 */
public class Main {
    
    public static void main(String[] args) {
        // Run the test suite
        PyramidSortTest testSuite = new PyramidSortTest();
        testSuite.runAllTests();
        
        // Interactive demonstration with a custom dataset
        demonstrateWithCustomData();
        
        visualizeAlgorithm();
    }
    
    /**
     * Demonstrate sorting with custom data
     */
    private static void demonstrateWithCustomData() {
        System.out.println("Demonstrating Pyramid Sort with custom dataset:");
        System.out.println();
        
        // Create test data
        int[] testData = {42, 17, 93, 28, 65, 11, 74, 39, 51, 86, 22, 58};
        
        System.out.println("Original data: ");
        printArray(testData);
        System.out.println();
        
        // Convert to dequeue
        Dequeue<Integer> input = new Dequeue<>();
        for (int value : testData) {
            input.addLast(value);
        }
        
        // Sort
        PyramidSort sorter = new PyramidSort();
        Dequeue<Integer> sorted = sorter.sort(input);
        
        // Display result
        System.out.println("\nSorted data:");
        while (!sorted.isEmpty()) {
            System.out.print(sorted.removeFirst());
            if (!sorted.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    /**
     * Visualize how the algorithm works with a small example
     */
    private static void visualizeAlgorithm() {
        System.out.println("Visual representation of pyramid sort on [8,3,7,1,9,2,5,4,6]:");
        System.out.println();
        System.out.println("                 [8,3,7,1,9,2,5,4,6]");
        System.out.println("                          |");
        System.out.println("          +---------------+---------------+");
        System.out.println("          |               |               |");
        System.out.println("       [8,3,7]         [1,9,2]         [5,4,6]");
        System.out.println("          |               |               |");
        System.out.println("    +-----+-----+   +-----+-----+   +-----+-----+");
        System.out.println("    |     |     |   |     |     |   |     |     |");
        System.out.println("   [8]   [3]   [7] [1]   [9]   [2] [5]   [4]   [6]");
        System.out.println("    |     |     |   |     |     |   |     |     |");
        System.out.println("   [8]   [3]   [7] [1]   [9]   [2] [5]   [4]   [6]  <- Base case");
        System.out.println("    |     |     |   |     |     |   |     |     |");
        System.out.println("    +-----+-----+   +-----+-----+   +-----+-----+");
        System.out.println("          |               |               |");
        System.out.println("       [3,7,8]         [1,2,9]         [4,5,6]  <- Merge 3 parts");
        System.out.println("          |               |               |");
        System.out.println("          +---------------+---------------+");
        System.out.println("                          |");
        System.out.println("                 [1,2,3,4,5,6,7,8,9]  <- Final result");
        System.out.println();
        System.out.println("Key insight: Division into 3 creates a pyramid-like structure!");
    }
    
    /**
     * Helper method to print an array
     */
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

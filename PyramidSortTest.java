/**
 * 03/05/2026
 * Pyramid Sort Test Suite

 *  Empty Dequeue
 *  Single Element
 *  Two Elements
 *  Three Elements (Pyramid Base Case)
 *  Small Data Set (6 elements)
 *  Medium Data Set (9 elements)
 *  Already Sorted Data
 *  Reverse Sorted Data (Worst Case, AI helped to get this test case)
 */
public class PyramidSortTest {
    
    private PyramidSort sorter;
    private int testsPassed = 0;
    private int testsTotal = 0;
    
    public PyramidSortTest() {
        this.sorter = new PyramidSort();
    }
    
    /**
     * Run all tests
     */
    public void runAllTests() {
        System.out.println("PYRAMID SORT TEST SUITE");
        System.out.println();
        
        testEmptyDequeue();
        testSingleElement();
        testTwoElements();
        testThreeElements();
        testSmallDataSet();
        testMediumDataSet();
        testAlreadySorted();
        testReverseSorted();
        
        System.out.println();
        System.out.println("TEST SUMMARY: " + testsPassed + "/" + testsTotal + " tests passed");
        if (testsPassed == testsTotal) {
            System.out.println("✓ ALL TESTS PASSED!");
        } else {
            System.out.println("✗ Some tests failed");
        }
    }
    
    // ==================== TEST CASES ====================
    
    private void testEmptyDequeue() {
        System.out.println("Test 1: Empty Dequeue");
        
        Dequeue<Integer> input = new Dequeue<>();
        Dequeue<Integer> result = sorter.sort(input);
        
        boolean passed = result.isEmpty();
        reportTest("Empty dequeue", passed);
        System.out.println();
    }
    
    private void testSingleElement() {
        System.out.println("Test 2: Single Element");
        
        Dequeue<Integer> input = createDequeue(new int[]{42});
        System.out.println("Input:  " + dequeueToString(copyDequeue(input)));
        
        Dequeue<Integer> result = sorter.sort(input);
        System.out.println("Output: " + dequeueToString(copyDequeue(result)));
        
        boolean passed = isSorted(result) && result.size() == 1;
        reportTest("Single element", passed);
        System.out.println();
    }
    
    private void testTwoElements() {
        System.out.println("Test 3: Two Elements");
        
        Dequeue<Integer> input = createDequeue(new int[]{7, 3});
        System.out.println("Input:  " + dequeueToString(copyDequeue(input)));
        
        Dequeue<Integer> result = sorter.sort(input);
        System.out.println("Output: " + dequeueToString(copyDequeue(result)));
        
        boolean passed = isSorted(result) && result.size() == 2;
        reportTest("Two elements", passed);
        System.out.println();
    }
    
    private void testThreeElements() {
        System.out.println("Test 4: Three Elements (Pyramid Base Case)");
        
        Dequeue<Integer> input = createDequeue(new int[]{9, 1, 5});
        System.out.println("Input:  " + dequeueToString(copyDequeue(input)));
        
        Dequeue<Integer> result = sorter.sort(input);
        System.out.println("Output: " + dequeueToString(copyDequeue(result)));
        
        boolean passed = isSorted(result) && result.size() == 3;
        reportTest("Three elements", passed);
        System.out.println();
    }
    
    private void testSmallDataSet() {
        System.out.println("Test 5: Small Data Set (6 elements)");
        
        Dequeue<Integer> input = createDequeue(new int[]{8, 3, 7, 1, 9, 2});
        System.out.println("Input:  " + dequeueToString(copyDequeue(input)));
        
        Dequeue<Integer> result = sorter.sort(input);
        System.out.println("Output: " + dequeueToString(copyDequeue(result)));
        
        boolean passed = isSorted(result) && result.size() == 6;
        reportTest("Small data set", passed);
        System.out.println();
    }
    
    private void testMediumDataSet() {
        System.out.println("Test 6: Medium Data Set (9 elements)");
        
        Dequeue<Integer> input = createDequeue(new int[]{15, 3, 21, 8, 11, 2, 19, 7, 14});
        System.out.println("Input:  " + dequeueToString(copyDequeue(input)));
        
        Dequeue<Integer> result = sorter.sort(input);
        System.out.println("Output: " + dequeueToString(copyDequeue(result)));
        
        boolean passed = isSorted(result) && result.size() == 9;
        reportTest("Medium data set", passed);
        System.out.println();
    }
    
    private void testAlreadySorted() {
        System.out.println("Test 7: Already Sorted Data");
        
        Dequeue<Integer> input = createDequeue(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println("Input:  " + dequeueToString(copyDequeue(input)));
        
        Dequeue<Integer> result = sorter.sort(input);
        System.out.println("Output: " + dequeueToString(copyDequeue(result)));
        
        boolean passed = isSorted(result) && result.size() == 9;
        reportTest("Already sorted", passed);
        System.out.println();
    }
    
    private void testReverseSorted() {
        System.out.println("Test 8: Reverse Sorted Data (Worst Case)");
        
        Dequeue<Integer> input = createDequeue(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println("Input:  " + dequeueToString(copyDequeue(input)));
        
        Dequeue<Integer> result = sorter.sort(input);
        System.out.println("Output: " + dequeueToString(copyDequeue(result)));
        
        boolean passed = isSorted(result) && result.size() == 9;
        reportTest("Reverse sorted", passed);
        System.out.println();
    }
    
    // ==================== HELPER METHODS ====================
    
    /**
     * Create a dequeue from an array of integers
     */
    private Dequeue<Integer> createDequeue(int[] values) {
        Dequeue<Integer> dequeue = new Dequeue<>();
        for (int value : values) {
            dequeue.addLast(value);
        }
        return dequeue;
    }
    
    /**
     * Create a copy of a dequeue (for display purposes)
     */
    private Dequeue<Integer> copyDequeue(Dequeue<Integer> original) {
        Dequeue<Integer> temp = new Dequeue<>();
        Dequeue<Integer> copy = new Dequeue<>();
        
        // Move all elements to temp
        while (!original.isEmpty()) {
            temp.addLast(original.removeFirst());
        }
        
        // Move back to original and create copy
        while (!temp.isEmpty()) {
            Integer value = temp.removeFirst();
            original.addLast(value);
            copy.addLast(value);
        }
        
        return copy;
    }
    
    /**
     * Convert dequeue to string for display
     */
    private String dequeueToString(Dequeue<Integer> dequeue) {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;
        
        while (!dequeue.isEmpty()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(dequeue.removeFirst());
            first = false;
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Check if a dequeue is sorted in ascending order
     */
    private boolean isSorted(Dequeue<Integer> dequeue) {
        if (dequeue.isEmpty() || dequeue.size() == 1) {
            return true;
        }
        
        Dequeue<Integer> temp = new Dequeue<>();
        boolean sorted = true;
        Integer previous = dequeue.removeFirst();
        temp.addLast(previous);
        
        while (!dequeue.isEmpty()) {
            Integer current = dequeue.removeFirst();
            temp.addLast(current);
            
            if (current < previous) {
                sorted = false;
            }
            previous = current;
        }
        
        // Restore the dequeue
        while (!temp.isEmpty()) {
            dequeue.addLast(temp.removeFirst());
        }
        
        return sorted;
    }
    
    /**
     * Report test result
     */
    private void reportTest(String testName, boolean passed) {
        testsTotal++;
        if (passed) {
            testsPassed++;
            System.out.println("✓ PASSED: " + testName);
        } else {
            System.out.println("✗ FAILED: " + testName);
        }
    }
}

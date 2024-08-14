package dataStructure.heap;


// in Heap root is always greater than left and right child nodes
class MinHeap {
    private final int[] heap;
    private int currentHeapCapacity;

    public MinHeap(int capacity) {
        heap = new int[capacity];
        currentHeapCapacity = 0;
    }

    /**
     * Swap the elements in the problems. Array
     *
     * @param arr         The problems. Array
     * @param firstIndex  First element index
     * @param secondIndex Second element index
     */
    private void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    /**
     * Get the Parent index for the given index: (i-1) / 2
     *
     * @param key index of the element
     * @return index of the parent element
     */
    private int parent(int key) {
        return (key - 1) / 2;
    }

    /**
     * Get the Left Child index for the given index: (2 * i) + 1
     *
     * @param key index of the element
     * @return index of the left child
     */
    private int left(int key) {
        return (2 * key) + 1;
    }

    /**
     * Get the Right Child index for the given index: (2 * i) + 2
     *
     * @param key index of the element
     * @return index of the right child
     */
    private int right(int key) {
        return (2 * key) + 2;
    }

    // -------------------------------Insertion---------------------------------------//

    /**
     * 1. Insert the new key at end
     * 2. Fix the min problems. Heap property if it is violated: heapify Up
     *
     * @param key The key to be inserted
     */
    public boolean insertKey(int key) {
        // The Heap is full
        if (currentHeapCapacity == heap.length) {
            return false;
        }
        // Insert the new key at the end
        int currentIndex = currentHeapCapacity;
        heap[currentIndex] = key;
        currentHeapCapacity++;

        // Heapify Up if heap is violated
        // Current element index is i
        heapifyUp(heap, currentIndex);
        return true;
    }

    /**
     * Heapify Up Recursive
     *
     * @param array The Array to be heapify
     * @param index Current element index
     */
    public void heapifyUp(int[] array, int index) {
        // If the index is 0, then the element is the root
        if (index == 0) {
            return;
        }
        // Calculate parent index
        int parentIndex = this.parent(index);
        // If child is smaller than parent
        if (array[index] < array[parentIndex]) {
            // Swap values
            this.swap(array, index, parentIndex);
            // Recursively heapify-up the parent
            heapifyUp(array, parentIndex);
        }
    }

    // -------------------------------Poll Max---------------------------------------//

    /**
     * 1. Replace the last element with root, and delete it.
     * 2. Fix the min problems. Heap property if it is violated: heapify Down
     *
     * @return The minimum element from the problems. Heap
     */
    public int extractMin() {
        // Edge cases when there is no element
        if (currentHeapCapacity <= 0) {
            return Integer.MAX_VALUE;
            // Edge cases when there is one element
        } else if (currentHeapCapacity == 1) {
            currentHeapCapacity--;
            return heap[0];
        }

        // Swap the root with the last element
        int root = heap[0];
        heap[0] = heap[currentHeapCapacity - 1];
        currentHeapCapacity--;
        heapifyDown(heap, 0);

        return root;
    }


    /**
     * Heapify Down Recursive
     *
     * @param array The problems. Array to be heapify
     * @param index Root index
     */
    private void heapifyDown(int[] array, int index) {
        int smallest = index;
        int leftChild = left(index);
        int rightChild = right(index);

        // Finds the smallest element among the root, left and right child
        if (leftChild < currentHeapCapacity && array[leftChild] < array[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < currentHeapCapacity && array[rightChild] < array[smallest]) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(array, index, smallest);
            heapifyDown(array, smallest);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        int[] keysToInsert = {10, 20, 15, 100, 200};
        for (int key : keysToInsert)
            minHeap.insertKey(key);

        System.out.println(minHeap.extractMin());
    }

}




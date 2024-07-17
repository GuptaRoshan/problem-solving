package dataStructure.heap;


class MinHeap {
    private final int[] heap;
    private final int capacity;
    private int currentHeapCapacity;

    public MinHeap(int n) {
        capacity = n;
        heap = new int[capacity];
        currentHeapCapacity = 0;
    }

    /**
     * Swap the elements in the problems. Array
     *
     * @param arr The problems. Array
     * @param a   First element index
     * @param b   Second element index
     */
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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

    // ----------------------------------------------------------------------//

    /**
     * 1. Insert the new key at end
     * 2. Fix the min problems. Heap property if it is violated: heapify Up
     *
     * @param key The key to be inserted
     */
    public boolean insertKey(int key) {
        // Edge case when the problems.heap is full
        if (currentHeapCapacity == capacity) {
            return false;
        }
        //Insert the new key at the end
        int i = currentHeapCapacity;
        heap[i] = key;
        currentHeapCapacity++;

        // Fix the min problems.heap property if it is violated : heapify Up
        // Last element index is i
        heapifyUp(heap, i);
        return true;
    }

    /**
     * Heapify Up Recursive
     *
     * @param array The problems Array to be heapified
     * @param index Last element index
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
        }
        // Edge cases when there is one element
        else if (currentHeapCapacity == 1) {
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
     * @param array The problems. Array to be heapified
     * @param index Root index
     */
    private void heapifyDown(int[] array, int index) {
        int l = left(index);
        int r = right(index);

        int smallest = index;
        if (l < currentHeapCapacity && array[l] < array[smallest]) {
            smallest = l;
        }
        if (r < currentHeapCapacity && array[r] < array[smallest]) {
            smallest = r;
        }
        if (smallest != index) {
            swap(array, index, smallest);
            heapifyDown(array, smallest);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        int[] keysToInsert = {10, 20, 15, 100, 200};

        for (int key : keysToInsert) {
            System.out.println(minHeap.insertKey(key));
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(minHeap.extractMin());
        }
    }

}




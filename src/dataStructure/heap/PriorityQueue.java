package dataStructure.heap;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("all")
public class PriorityQueue<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] heap;
    public int size;
    private final Comparator<? super T> comparator;


    public PriorityQueue(Comparator<? super T> comparator) {
        this.heap = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    // add from the queue and bubble up
    public void enqueue(T element) {
        ensureCapacity();
        heap[size] = element;
        heapifyUp(size);
        size++;
    }

    // remove from the queue and bubble down
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        T root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    // get the root element
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap[0];
    }

    // check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Heapify up the element at index
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (comparator.compare(heap[index], heap[parentIndex]) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Heapify down the element at index
    private void heapifyDown(int index) {
        int extremeIndex = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < size && comparator.compare(heap[leftChild], heap[extremeIndex]) > 0) {
            extremeIndex = leftChild;
        }

        if (rightChild < size && comparator.compare(heap[rightChild], heap[extremeIndex]) > 0) {
            extremeIndex = rightChild;
        }

        if (index != extremeIndex) {
            swap(index, extremeIndex);
            heapifyDown(extremeIndex);
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Increases the size of queue dynamically
    private void ensureCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    public static void main(String[] args) {
        // Max heap for integers
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        maxPQ.enqueue(3);
        maxPQ.enqueue(1);
        maxPQ.enqueue(4);
        maxPQ.enqueue(1);
        maxPQ.enqueue(5);
        maxPQ.enqueue(9);

        System.out.println("Max Heap (descending order):");
        while (!maxPQ.isEmpty()) {
            System.out.print(maxPQ.dequeue() + " ");
        }
        System.out.println();

        // Min heap for integers
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minPQ.enqueue(3);
        minPQ.enqueue(1);
        minPQ.enqueue(4);
        minPQ.enqueue(1);
        minPQ.enqueue(5);
        minPQ.enqueue(9);

        System.out.println("Min Heap (ascending order):");
        while (!minPQ.isEmpty()) {
            System.out.print(minPQ.dequeue() + " ");
        }
        System.out.println();

        // Priority queue for strings based on length
        PriorityQueue<String> stringLengthPQ = new PriorityQueue<>((a, b) -> Integer.compare(b.length(), a.length()));
        stringLengthPQ.enqueue("apple");
        stringLengthPQ.enqueue("banana");
        stringLengthPQ.enqueue("cherry");
        stringLengthPQ.enqueue("date");
        stringLengthPQ.enqueue("elderberry");

        System.out.println("String Priority Queue (based on length, longest first):");
        while (!stringLengthPQ.isEmpty()) {
            System.out.print(stringLengthPQ.dequeue() + " ");
        }

        System.out.println();
    }
}

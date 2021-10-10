import java.util.*;
public class MaxHeap<E extends Comparable<E>> extends ArrayList<E> {
    // construct an empty Heap using ArrayList
    // with root at index 0.
    // don't use binary tree for implementing the heap.
    private ArrayList<E> heap;
    int size;
    private E maxsize;
    private E root;

    public MaxHeap() {
        size = 0;
        heap = new ArrayList<>(10);
        this.root = heap.get(0); //need to populate arraylist before able to get index 0;
    }


    //helper method to do main heap sorting logic
    public heapify(){
        //get left child
        //get right child
        //if left child <= heap.size && heap[left] > heap[i]
        //root = left;
        //else
        //root = i;
        //if heap[right].compareTo(heap[root]) == 1
        //root = right;
        //if root != i
        //swap heap[i] with heap[root]
        //heapify(); recursive call to continue down the heap
    }

    // returns max value
    public E findMax() {
        return root;
    }
    private void swap(int pos1, int pos2){
        int temp = (int) heap.get(pos1); //store first variable in temp variable.
        heap.set(pos1, pos2); //assign value of first variable to second variable.
        heap.set(pos2, temp);//set second variable's value to temp.
    }
    // adds a new value to the heap at the end of the Heap and 
    // adjusts values up to the root to ensure Max heap property is satisfied.
    // parent of node at i is given by the formula (i-1)/2
    // throw appropriate exception
    public void addHeap(E val) {
        heap.set(size, val);
        int current = size;
        int parent = (current - 1) /2;
        while (heap.get(current).compareTo(heap.get(parent(current))) > 0){
            swap(parent, current);
        }
        size++;
    }

    //returns the max value at the root of the heap by swapping the last value 
    // and percolating the value down from the root to preserve max heap property
    // children of node at i are given by the formula 2i+1,2i+2, to not exceed the
    // bounds of the Heap index, namely, 0 ... size()-1.
    // throw appropriate exception
    public E removeHeap() {
        int last = (int) heap.get(size - 1);
        int leftChild = (2 * root) + 1;
        int rightChild = (2 * root) + 2;
        root = last;
        size -= 1;
        if ()
    }

    // takes a list of items E and builds the heap and then prints 
    // decreasing values of E with calls to removeHeap().  
    public void heapSort(List<E> list){

    }

    // merges the other maxheap with this maxheap to produce a new maxHeap.  
    public void heapMerge(MaxHeap<E> other){
        MaxHeap maxHeap = new MaxHeap(); //new instance of MaxHeap for testing.
    }

    //takes a list of items E and builds the heap by calls to addHeap(..)
    public void buildHeap(List<E> list) {
        for (Object item: list){//for every item in the list
            heap.addHeap(item)//add the item to the heap. Unsure how to access the heap
        }
    }
    public static void main(String[] args){

    }
}
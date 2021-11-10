import java.util.*;

public class Selection <E extends Comparable<E>> {

    private final int k = 1000000;
    private ArrayList<E> input; //this holds the values of type E from which your code will find kth largest

    public Selection() {
        int k = 1000000; //set k to one-million.
    }

    //Unordered Partial Sort
    //Time Complexity: O(k log k), since k <= n, time complexity converges to O(n).
    //First elements up to k are sorted, rest in random order.
    //kth largest element is compared to remaining values.
    //kth value is replaced if comparing value is greater than.
    //kth value stays if comparing value is equal to or less than.
    //New value is inserted into the sorted list in the correct position.
    //arraylist or setarray for sorted
    //remove current if comparing value is greater
    //size k and original size - k.
    //if changing new k, remove end value and shift list by 1 first.
    public E algorithm1(ArrayList<E> input) {
        ArrayList<E> sorted = new ArrayList<>(); //sorted array
        ArrayList<E> unsorted = new ArrayList<>(); //unsorted array
            for (int i = 0; i < k; i++) { //add elements from input array up to index k
                sorted.add(input.get(i));
            }
            for (int i = k; i < input.size(); i++){ //add all elements after index k
                unsorted.add(input.get(i));
            }
            Collections.sort(sorted); //sort sorted array
            E current = sorted.get(k - 1); //pointer to kth largest
            for (E object: unsorted){ //iterate through remaining values of unsorted
                if (current.compareTo(object) > 0){ //if current kth largest is greater than obj being compared,
                    unsorted.iterator().next();     //go to next element in unsorted
                } else if (current.compareTo(object) == 0){ //if current kth largest is equal to obj being compared,
                    unsorted.iterator().next();             //go to next element in unsorted
                } else if (current.compareTo(object) < 0){ //if current kth largest is less than obj being compared,
                    sorted.remove(current); //remove current kth largest
                    current = object;       //new kth largest is object just compared
                    sorted.add(current);    //add new kth largest to sorted array
                    Collections.sort(sorted);//resort array
                }
            }
            return current; //kth largest element
    }

    public E algorithm2(ArrayList<E> array) {
        //System.out.println(k);
        PriorityQueue<E> q = new PriorityQueue<>(k);
        for(E i: array){
            q.offer(i);

            if(q.size() > k){
                q.poll();
            }
        }
        return q.peek();
    }


    public E algorithm3(ArrayList<E> array) {
        Set<E> S = new HashSet<>();
        MaxHeap<E> heap = new MaxHeap<>();

        for (int i = 0; i < k; i++){
            S.add(array.get(i));
        }
        ArrayList<E> setArray = new ArrayList<>(S);
        heap.buildHeap(setArray);
        return heap.findMax();
    }

    public static void main(String[] args) {
        //math.rand, set range
        //.add random ints to arraylist through input

        Selection<Integer> select = new Selection<>();

        int size = 10000000;
        ArrayList<Integer> counts = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            int randNum = (int) (Math.random() * 10000000);
            counts.add(i, randNum);
        }
        select.input = counts;

        long algorithm1Start = System.currentTimeMillis();
        System.out.println("Algorithm 1 kth largest number: " + select.algorithm1(select.input));
        long algorithm1End = System.currentTimeMillis();
        long algorithm1Total = algorithm1End - algorithm1Start;
        long algorithm2Start = System.currentTimeMillis();
        System.out.println("Algorithm 2 kth largest number: " + select.algorithm2(select.input));
        long algorithm2End = System.currentTimeMillis();
        long algorithm2Total = algorithm2End - algorithm2Start;
        long algorithm3Start = System.currentTimeMillis();
        System.out.println("Algorithm 3 kth largest number: " + select.algorithm3(select.input));
        long algorithm3End = System.currentTimeMillis();
        long algorithm3Total = algorithm3End - algorithm3Start;

        System.out.println("Algorithm 1 total run time: " + algorithm1Total + " ms");
        System.out.println("Algorithm 2 total run time: " + algorithm2Total + " ms");
        System.out.println("Algorithm 3 total run time: " + algorithm3Total + " ms");
    }
}
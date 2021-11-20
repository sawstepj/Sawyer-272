import java.util.*;

public class MST {

    ConnectedComponents cc;
    PriorityQueue<Integer> queue;
    ArrayList<Edge> mst;
    int[] set;
    int[] height;
    static int numVertex;
    static int numEdges;

    public MST(int n, int m){
        numVertex = n;
        numEdges = m;
        set = new int[n];
        mst = new ArrayList<>();
        queue = new PriorityQueue<>();
        cc = new ConnectedComponents(n, m);
    }
    // finds the set number for a given vertex
    public int find(int x){
        int i = 0;
        int j;
        int r = x;
        while (set[r] !=r){
            r = set[r];
            i = x;
        }
        while (i != r){
            j = set[i];
            set[i] = r;
            i = j;
        }
        return r;
    }
    // merges one set to another
    // takes height of the trees into account
    public void merge(int a, int b) {
        if (height[a] == height[b]){
            height[a] = height[a] + 1;
            set[b] = a;
        } else if (height[a] > height[b]){
            set[b] = a;
        } else {
            set[a] = b;
        }
    }

    // Need BFS for union-find

    public static void main(String[] args){
        ConnectedComponents cc = new ConnectedComponents(numVertex + 1, numEdges);
        

    }
}

import java.io.File;
import java.util.*;

public class MST {

    ConnectedComponents cc;
    PriorityQueue<Integer> queue;
    WeightedEdge[] mst;
    int[] set;
    int[] height;
    static int numVertex;
    static int numEdges;
    int treeEdges;

    public MST(int n, int m){
        numVertex = n;
        numEdges = m;
        set = new int[n];
        mst = new WeightedEdge[numVertex];
        queue = new PriorityQueue<>();
        cc = new ConnectedComponents(n, m);
    }

    /*static class subset {
        int parent, depth;
    }*/

    public int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i){
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // finds the set number for a given vertex
    /*public int find(int x){
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
    }*/

    void merge(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].depth < subsets[yroot].depth) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].depth > subsets[yroot].depth) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].depth++;
        }
    }

    // merges one set to another
    // takes height of the trees into account
    /*public void merge(int a, int b) {
        if (height[a] == height[b]){
            height[a] = height[a] + 1;
            set[b] = a;
        } else if (height[a] > height[b]){
            set[b] = a;
        } else {
            set[a] = b;
        }
    }*/

    public WeightedEdge[] kruskal() {
        int e = 0;
        int i;

        for (i = 0; i < numVertex; ++i){
            mst[i] = new WeightedEdge();
        }

        PriorityQueue<WeightedEdge> queue = new PriorityQueue<>();

        Subset[] subsets = new Subset[numVertex];
        for (i = 0; i < numVertex; ++i) {
            subsets[i] = new Subset();
        }

        for (int v = 0; v < numVertex; ++v){
            subsets[v].parent = v;
            subsets[v].depth = 0;
        }

        while (e < numVertex - 1) {
            WeightedEdge edge = queue.poll();
            int x = find(subsets, edge.v1);
            int y = find(subsets, edge.v2);

            if (x != y) {
                mst[e++] = edge;
                merge(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in "
                + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i)
        {
            System.out.println(mst[i].v1 + " -- "
                    + mst[i].v2
                    + " == " + mst[i].weight);
            minimumCost += mst[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                + minimumCost);
        return mst;
    }

    /*public ArrayList<WeightedEdge> kruskal(){
        int n = numVertex;
        PriorityQueue<WeightedEdge> queue = new PriorityQueue<>();

        while (treeEdges < n-1){
            WeightedEdge edge = queue.poll();

            if(edge!=null) {
                int p1 = find(edge.v1);
                int p2 = find(edge.v2);
                if (p1 != p2) {
                    mst.add(edge);
                }
            }
        }
        return mst;
    }*/

    // Need BFS for union-find

    public static void main(String[] args){
        MST tree = new MST(numVertex, numEdges);

        numVertex = 50515;
        numEdges = 819306;
        String file = "artist_edges.txt";
        Graph gr = Graph.readAndStoreGraph(file);
        /*ConnectedComponents cc = new ConnectedComponents(numVertex + 1, numEdges);
        ConnectedComponents.readAndStoreGraph(file);
        cc.getComponents();
        cc.mergeComponents(1, 2);
        cc.getComponents();*/

        tree.gr.kruskal();

        for (Edge e: Graph.edgeSet) {
            gr.addEdge(e.v1, e.v2);
            System.out.print(e.v1);
            System.out.print(" ");
            System.out.print(e.v2);
            System.out.println();
        }
        System.out.println("# edges  "+ numEdges);
        gr.breadthFirstTraversal();
        System.out.println("number of Trees "+gr.numTrees);
    }
}

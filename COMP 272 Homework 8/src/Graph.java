import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
    int numVertex;
    int numEdge;
    ArrayList<LinkedList<Integer>> graph;
    ArrayList<Edge> edgeSet;
    int[] findSet;

    public Graph () {
        numVertex =0;
        numEdge =0;
        graph = new ArrayList<>();

    }

    public Graph(int vertexCount) {

        numVertex=vertexCount;
        numEdge=0;
        graph = new ArrayList<>(numVertex);
        for (int i=0;i<numVertex;i++)
            graph.add(new LinkedList<>());
    }

    // method to take input from file and add to an arrayList of edges to
    // determine the number of edges.
    // don't know how to split the numbers into separate values from the file
    // want first value and second value to come together to create an Edge
    public void edgeSetter(Scanner input) {
        String data = null;
        Edge e = null;
        while (input.hasNext()){
            input.useDelimiter("\t");
            data = input.nextLine();
            String[] pairs = data.split("\t");
            for (String string: pairs){
                //e.u = string;
            }
        }
        //return edgeSet;
    }

    public LinkedList<Integer> getNeighbors(int u) {

        return graph.get(u);
    }

    public boolean edgePresent(int u, int v) {

        return (graph.get(u).contains(v));

    }

    public void addEdge(int u, int v) {
        // lets assume that the vertices are already created.
        if (u>=0 && u<numVertex && v>=0 && v<numVertex) {
            if (!edgePresent(u,v))
                graph.get(u).add(v);

            if (!edgePresent(v,u))
                graph.get(v).add(u);
            numEdge++;
        }
        else throw new IndexOutOfBoundsException();

    }

    // Similar to edge setter but for general cases.
    // Started out with this as first input method.
    public void readIn(Scanner input) throws FileNotFoundException {
        String data = null;
        int setNumber = 0;
        ArrayList<String> positioner = new ArrayList<>();
        while (input.hasNext()){
            input.useDelimiter("\t");
            data = input.nextLine();
            positioner.add(data);
        }
        for (String s: positioner){
            if (positioner.indexOf(s) % 2 == 0){
                setNumber = Integer.parseInt(s);
            }
        }
    }
    // Depth First Search
    public void DFS(int v, boolean[] visited){
        visited[v] = true;
        for (int x : graph.get(v)){
            if (!visited[x]){
                DFS(x, visited);
            }
        }
    }

    // Breadth First Search
    public void BFS(int s) {
        boolean[] visited = new boolean[numVertex];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            s = queue.poll();

            for (int n : graph.get(s)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public int findComponent (int u){
        return 0;
    }

    public void mergeComponents(int u, int v){
        int foundU = findComponent(u);
        int foundV = findComponent(v);
    }

    /*public static void printGraph(Graph graph){
        int u = 0;
        int list_size = graph.graph.size();

        System.out.println("The contents of the graph:");
        while (u < list_size) {
            //traverse through the adjacency list and print the edges
            for (Integer edge : graph.graph.get(u)) {
                System.out.print("Vertex:" + u + ");
            }

            System.out.println();
            u++;
        }
    }*/

    // Having trouble getting input to be into a data structure.
    // Casting issues.
    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph(36692);//# of vertices in Enron file according to SNAP Standford website

        File file = new File("Email-Enron.txt");
        Scanner input = new Scanner(file);
        String data = null;
        int count = 0;
        // can't convert string data of file to integer types so that they can become
        // Vertices/Edge pairs.
        while (input.hasNext()) {
            input.useDelimiter("\t");
            data = input.next();
            count++;
        }
        count = count/2;
        System.out.println(count); // number of edges.

        //System.out.println(graph);

        //graph.readIn(input);

        //graph.edgeSetter(input);

        //printGraph(graph);

    }
}


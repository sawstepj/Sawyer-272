import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graphing {
    private final int V;
    Graph graph = new Graph();
    ArrayList<LinkedList<Integer>> vertexSets = new ArrayList<>();
    ArrayList<Edge> edgeSet;
    int[] findSet;

    public Graphing(int V){
        this.V = V;
        vertexSets = new ArrayList<>();

        for (int i = 0; i < V; i++){
            vertexSets.add(i, new LinkedList<>());
        }
    }

    public void addEdge(int u, int v){
        vertexSets.get(u).add(v);
        vertexSets.get(v).add(u);
    }


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

    public void DFS(int v, boolean[] visited){
        visited[v] = true;
        for (int x : vertexSets.get(v)){
            if (!visited[x]){
                DFS(x, visited);
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


    public static void main(String[] args) throws FileNotFoundException {
        Graphing graph = new Graphing(36692);

        File file = new File("Email-Enron.txt");
        Scanner input = new Scanner(file);

        graph.readIn(input);

    }
}

package csd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;

class Vertex {

    String vert;
    double weight;

    public Vertex(String vert, double weight) {
        this.vert = vert;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + vert + ", " + weight + ")";
    }
}

class Row {
    String name;
    ArrayList<Vertex> list;

    public Row(String name) {
        this.name = name;
        list = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String s = name + " ";
        for (Vertex vertex: list) s += "-> " + vertex;
        return s;
    }
}

class AdjList {
    ArrayList<Row> G;
    int n;
    public AdjList(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        G = new ArrayList<>();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            Row onerow = new Row(tokens[0]);
            for(int i = 1; i < tokens.length; i += 2) {
                onerow.list.add(new Vertex(tokens[i], Double.parseDouble(tokens[i+1])));
            }
            G.add(onerow);
        }
        this.n = G.size();
    }
    
    public void display() {
        System.out.println("There are" + n + "vertices");
        for (Row row: G) {
            System.out.println("\n" + row);
        }
    }
}

public class CSD3 {

    private int V;
    private ArrayList<Integer> adj[];

    public CSD3(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new ArrayList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    boolean isConnected() {
        boolean visited[] = new boolean[V];
        int i;
        for (i = 0; i < V; i++) {
            visited[i] = false;
        }
        for (i = 0; i < V; i++) {
            if (adj[i].size() != 0) {
                break;
            }
        }
        if (i == V) {
            return true;
        }
        DFSUtil(i, visited);
        for (i = 0; i < V; i++) {
            if (visited[i] == false && adj[i].size() > 0) {
                return false;
            }
        }
        return true;
    }

    int isEulerian() {
        if (isConnected() == false) {
            return 0;
        }
        int odd = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) {
                odd++;
            }
        }
        if (odd > 2) {
            return 0;
        }
        return (odd == 2) ? 1 : 2;
    }

    void test() {
        int res = isEulerian();
        switch (res) {
            case 0:
                System.out.println("graph is not Eulerian\n");
                break;
            case 1:
                System.out.println("graph has a Euler path\n");
                break;
            default:
                System.out.println("graph has a Euler cycle\n");
                break;
        }
    }

    int count = 0;
    boolean[] visited;
    int[] data;

    public void listAllHC() {
        data = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            visited[i] = false;
        }
        int start = 1;
        visited[start] = true;
        count = 1;
        data[1] = start;
        backTracking(start, start);
        visited[start] = false;
        count = 0;
    }

    void backTracking(int curr, int start) {
        if (count == V) {
            System.out.println("HC is :");
            for (int i = 0; i < V; i = i + V) {
                System.out.println(Arrays.toString(data));
            }
            return;
        }
        for (int j = 1; j <= V; j++) {
            if (!visited[j]) {
                count++;
                visited[j] = true;
                data[count] = j;
                backTracking(j, start);
                visited[j] = false;
                count--;
            }
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        CSD3 g1 = new CSD3(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.listAllHC();
        g1.test();

        CSD3 g2 = new CSD3(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        g2.listAllHC();
        g2.test();
        AdjList g3 = new AdjList("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\CSD\\src\\csd\\graph.txt");
        g3.display();
    }
}

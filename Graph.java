import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Map<Vertex, List<Vertex>> adjList;

    public Graph() {
        this.adjList = new HashMap<Vertex, List<Vertex>>();
    }

    public Set<Vertex> getVertices() {
        return adjList.keySet();
    }

    public List<Vertex> getAdjVerticesList(String label) {
        return this.adjList.get(new Vertex(label));
    }

    public void addVertex(String label) {
        adjList.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjList.values().stream().forEach(e -> e.remove(v));
        adjList.remove(v);
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjList.get(v1).add(v2);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> edgesOfV1 = adjList.get(v1);
        if (edgesOfV1 != null) {
            edgesOfV1.remove(v2);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v: adjList.keySet()) {
            sb.append(v);
            sb.append("\t=> ");
            sb.append(adjList.get(v));
            sb.append("\n");
        }
        return sb.toString();
    }
}

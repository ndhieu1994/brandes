import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Brandes {

    private Graph graph;
    private Map<Vertex, Double> centralityBetweeneess;

    public Brandes(Graph graph) {
        this.graph = graph;
        centralityBetweeneess = new HashMap<Vertex, Double>();
        for (Vertex v : graph.getVertices()) {
            centralityBetweeneess.put(v, 0.0);
        }
    }

    public void betweeness() {
        for (Vertex v: centralityBetweeneess.keySet()) {
            centralityBetweeneess.put(v, 0.0);
        }
        for (Vertex s : graph.getVertices()) {

            Stack<Vertex> stack = new Stack<>();

            Map<Vertex, List<Vertex>> pred = new HashMap<>();
            graph.getVertices().forEach(w -> pred.put(w, new ArrayList<>()));

            Map<Vertex, Integer> sigma = new HashMap<>();
            graph.getVertices().forEach(t -> sigma.put(t, 0));
            sigma.put(s, 1);

            Map<Vertex, Integer> distance = new HashMap<>();
            graph.getVertices().forEach(t -> distance.put(t, -1));
            distance.put(s, 0);

            Queue<Vertex> queue = new LinkedList<Vertex>();
            queue.add(s);
            while (!queue.isEmpty()) {
                Vertex v = queue.poll();
                stack.push(v);
                graph.getAdjVerticesList(v.toString()).forEach(w -> {
                    if (distance.get(w) < 0) {
                        queue.add(w);
                        distance.put(w, distance.get(v) + 1);
                    }
                    if (distance.get(w) == distance.get(v) + 1) {
                        sigma.put(w, sigma.get(w) + sigma.get(v));
                        pred.get(w).add(v);
                    }
                });
            }

            Map<Vertex, Double> dependency = new HashMap<>();
            graph.getVertices().forEach(v -> dependency.put(v, 0.0));
            while (!stack.isEmpty()) {
                Vertex w = stack.pop();
                for (Vertex v : pred.get(w)) {
                    double vertdep = dependency.get(v) + sigma.get(v) / sigma.get(w) * (1 + sigma.get(w));
                    // System.out.println(vertdep);
                    dependency.put(v, vertdep);
                }
                if (!(w.equals(s))) {
                    double centrW = centralityBetweeneess.get(w) + dependency.get(w);
                    // System.out.println(centrW);
                    centralityBetweeneess.put(w, centrW);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        centralityBetweeneess.forEach((v, cent) -> {
            sb.append(v);
            sb.append("\t->\t");
            sb.append(cent);
            sb.append("\n");
        });
        return sb.toString();
    }
}

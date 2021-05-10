public class Main {

    private static Graph example() {
        Graph graph = new Graph();
        graph.addVertex("Anna");
        graph.addVertex("Larry");
        graph.addVertex("Rudy");
        graph.addVertex("Linda");
        graph.addVertex("James");
        graph.addVertex("Nora");
        graph.addVertex("Ben");
        graph.addVertex("Rose");
        graph.addVertex("Carol");
        graph.addEdge("Anna", "Ben");
        graph.addEdge("Anna", "Carol");
        graph.addEdge("Anna", "Larry");
        graph.addEdge("Anna", "Nora");
        graph.addEdge("Anna", "Rose");
        graph.addEdge("Anna", "Rudy");
        graph.addEdge("Ben", "Anna");
        graph.addEdge("Carol", "Anna");
        graph.addEdge("James", "Linda");
        graph.addEdge("James", "Rudy");
        graph.addEdge("Larry", "Anna");
        graph.addEdge("Larry", "Linda");
        graph.addEdge("Linda", "James");
        graph.addEdge("Linda", "Larry");
        graph.addEdge("Nora", "Anna");
        graph.addEdge("Rose", "Anna");
        graph.addEdge("Rudy", "Anna");
        graph.addEdge("Rudy", "James");
        return graph;
    }

    private static Graph directed() {
        Graph graph = new Graph();
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addEdge("1", "5");
        graph.addEdge("1", "3");
        graph.addEdge("2", "1");
        graph.addEdge("3", "6");
        graph.addEdge("4", "6");
        graph.addEdge("5", "4");
        graph.addEdge("6", "1");
        return graph;
    }

    private static Graph undirected() {
        Graph graph = new Graph();
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("1", "5");
        graph.addEdge("1", "6");
        graph.addEdge("2", "1");
        graph.addEdge("3", "1");
        graph.addEdge("3", "6");
        graph.addEdge("4", "5");
        graph.addEdge("4", "6");
        graph.addEdge("5", "1");
        graph.addEdge("5", "4");
        graph.addEdge("6", "1");
        graph.addEdge("6", "3");
        graph.addEdge("6", "4");
        return graph;
    }


    public static void main(String[] args) {
        Graph graph = undirected();
        System.out.println(graph.toString());
        Brandes brand = new Brandes(graph);
        brand.betweeness();
        System.out.println(brand);
    }
}

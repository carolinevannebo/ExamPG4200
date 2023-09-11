package question5;

import java.util.LinkedList;

// 5.2
public class TraversingGraphs {

    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge(5, 3);
        graph.addEdge(5, 7);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 8);
        graph.addEdge(7, 8);

        System.out.println("Depth first traversal starting from vertex 5: ");
        graph.DFS(5);

        System.out.println("Breadth first traversal starting from vertex 5: ");
        graph.BFS(5);
    }

    static class Graph {
        private final int numVertices;
        private final LinkedList<Integer>[] adjacencyList;

        Graph(int numVertices) {
            this.numVertices = numVertices;
            adjacencyList = new LinkedList[numVertices];

            for (int i = 0; i < numVertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int vertex1, int vertex2) {
            adjacencyList[vertex1].add(vertex2); // directed graph
        }

        void DFS(int startingVertex) {
            boolean[] visited = new boolean[numVertices];
            DFSUtil(startingVertex, visited);
        }

        void DFSUtil(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.println(vertex);

            for (Integer neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    DFSUtil(neighbor, visited);
                }
            }
        }

        void BFS(int startingVertex) {
            boolean[] visited = new boolean[numVertices];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[startingVertex] = true;
            queue.add(startingVertex);

            while(queue.size() != 0) {
                startingVertex = queue.poll();
                System.out.println(startingVertex);

                for (int neighbor : adjacencyList[startingVertex]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
}

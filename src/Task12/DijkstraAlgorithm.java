package Task12;

import java.util.*;

public class DijkstraAlgorithm {


    private static final int MAX_VALUE = Integer.MAX_VALUE;

    private int numVertices;
    private int[][] graph;

    public DijkstraAlgorithm(int[][] adjacencyMatrix) {
        this.numVertices = adjacencyMatrix.length;
        this.graph = adjacencyMatrix;
    }

    /**
     * Computes the shortest paths from a given source vertex to all other vertices in the graph.
     *
     * @param sourceVertex the source vertex from which to find the shortest paths
     * @return an array of the shortest distances from the source vertex to each vertex in the graph
     */
    public int[] shortestPath(int sourceVertex) {
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distances, MAX_VALUE);
        Arrays.fill(visited, false);

        //for root point distance is 0:
        distances[sourceVertex] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            // searching short distance from those who is not visited
            int minVertex = findMinDistance(distances, visited);
            visited[minVertex] = true;

            // updating distances from founded vertex above to other vertexes
            for (int j = 0; j < numVertices; j++) {
                //if vertex is not visited and new distance is less than current
                if (!visited[j] && graph[minVertex][j] != 0 && distances[minVertex] != MAX_VALUE) {
                    int newDistance = distances[minVertex] + graph[minVertex][j];
                    if (newDistance < distances[j]) {
                        distances[j] = newDistance;
                    }
                }
            }
        }

        return distances;
    }
    /**
     * Finds the vertex with the minimum distance from the source vertex among the unvisited vertices.
     *
     * @param distances an array of distances representing the current shortest distances from the source vertex
     * @param visited an array indicating whether each vertex has been visited or not
     * @return the index of the vertex with the minimum distance among the unvisited vertices, or -1 if all vertices have been visited
     */
    private int findMinDistance(int[] distances, boolean[] visited) {
        int minDistance = MAX_VALUE;
        int minVertex = -1;

        // searching vertex with minimal distance from those who are not visited
        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && distances[v] < minDistance) {
                minDistance = distances[v];
                minVertex = v;
            }
        }

        return minVertex;
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 7, 9, 0, 0, 14},
                {7, 0, 10, 15, 0, 6},
                {9, 10, 0, 11, 6, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {14, 0, 2, 0, 9, 0},
        };

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(adjacencyMatrix);
        int[] distances = dijkstra.shortestPath(0);

        System.out.println("Shortest distances from the source vertex:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }
}


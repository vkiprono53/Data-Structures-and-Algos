package dsa.graphs.impl;

import java.util.LinkedList;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * @author vkiprono
 * @created 3/6/24
 */

public class AdjacencyList {
    private int vertex;
    private LinkedList<Integer>[] list;

    public AdjacencyList(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];

        for (int i = 0; i < vertex; i++) {
            list[i] = new LinkedList<>();
        }
    }

    //Adding edges
    public void addEdge(int start, int destination) {
        list[start].addLast(destination);
        list[destination].addLast(start);
    }

    //Print Graph
    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                System.out.print("Node: " + i + " Connected to : ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    //BFS :
    public void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[vertex];

        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.print(start + " -->");
            int size = list[start].size();

            for (int i = 0; i < size; i++) {
                int n = list[start].get(i);
                if (!isVisited[n]) {
                    isVisited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    //Driver code
    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(4);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(0, 3);

        adjacencyList.printGraph();
        System.out.println("BFS TRAVERSAL:::::");
        adjacencyList.bfs(0);
    }
}

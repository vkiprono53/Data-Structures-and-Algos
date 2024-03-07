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

    //DFS
    public void dfs(int start, LinkedList<Integer>[] graph) {

        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] isVisited = new boolean[vertex];
        dfs(start, graph, stack, isVisited);
        System.out.println();
    }

    //DFS utility
    public void dfs(int start, LinkedList<Integer>[] graph, Deque<Integer> stack, boolean[] isVisited) {
        //Add node to the stack:
        stack.push(start);
        //Add to the visited list:
        isVisited[start] = true;

        //Loop through the stack:
        while (!stack.isEmpty()) {
            //pop
            int top = stack.pop();
            System.out.print(top + "->");
            int size = graph[top].size();
            for (int i = 0; i < size; i++) {
                int current = graph[top].get(i);
                if (!isVisited[current]) {
                    stack.push(current);
                    isVisited[current] = true;
                    //Recursive
                  //  dfs(current, graph, stack,isVisited);
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
        System.out.println("============");
        System.out.println("DFS TRAVERSAL:::::");
        adjacencyList.dfs(0, adjacencyList.list);

    }
}

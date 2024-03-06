package dsa.graphs.impl;
import java.util.LinkedList;
/**
 * @author vkiprono
 * @created 3/6/24
 */

public class AdjacencyList {
    private int vertex;
    private LinkedList<Integer>[] list;

    public AdjacencyList(int vertex){
        this.vertex = vertex;
        list = new LinkedList[vertex];

        for (int i = 0; i < vertex; i++) {
            list[i] = new LinkedList<>();
        }
    }

    //Adding edges
    public void addEdge(int start, int destination){
        list[start].addLast(destination);
        list[destination].addLast(start);
    }

    //Print Graph
    public void printGraph(){
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0){
                System.out.print("Node: " + i + " Connected to : ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    //Driver code
    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(4);
        adjacencyList.addEdge(0,1);
        adjacencyList.addEdge(1,2);
        adjacencyList.addEdge(2,3);
        adjacencyList.addEdge(0,3);

        adjacencyList.printGraph();
    }
}

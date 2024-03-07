package dsa.graphs.questions;

/**
 * @author vkiprono
 * @created 3/7/24
 */

/**
 * LLETCODE 547. Number of Provinces
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c,
 * then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities
 * outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith
 * city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        System.out.println(numberOfProvinces.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        int len = isConnected.length;
        boolean[] isVisited = new boolean[len];

        for (int i = 0; i < len; i++){
            if (!isVisited[i]){
                result++;
                dfs(i, isVisited, isConnected);
            }
        }
        return result;
    }

    public void dfs(int current, boolean[] isVisited, int[][] isConnected){
        isVisited[current] = true;

        for (int i = 0; i < isConnected.length; i++){
            if (!isVisited[i] && isConnected[current][i] == 1){
                dfs(i, isVisited,isConnected);
            }
        }
    }
}

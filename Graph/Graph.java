package Graph;


import java.util.*;

class GraphStructure {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    GraphStructure() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertices");
        int vertices = sc.nextInt();
        for (int i = 0; i < vertices; i++) {
            System.out.println("Enter neighbours");
            int edges = sc.nextInt();
            ArrayList<Integer> ll = new ArrayList<>();
            for (int j = 0; j < edges; j++) {
                ll.add(sc.nextInt());


            }
            graph.add(ll);
        }
        sc.close();

    }

    private void dfs(boolean[] visited, int curr) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < graph.get(curr).size(); i++) {
            if (!visited[graph.get(curr).get(i)]) dfs(visited, graph.get(curr).get(i));
        }
    }

    void dfs() {
        boolean[] visited = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) dfs(visited, i);
        }
    }

    private void bfs(boolean[] visited, int curr) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(curr);
        visited[curr] = true;

        while (!q.isEmpty()) {

            int temp = q.poll();
            System.out.print(temp + " ");
            for (int i : graph.get(temp)) {
                if (!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }

            }
        }


    }

    void bfs() {
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) bfs(visited, i);
        }
    }

}

// 10 2 6 9 2 8 5 0 2 4 9 2 3 7 1 1 2 0 7 2 4 6 1 1 2 0 3
public class Graph {
    public static void main(String[] args) {
        GraphStructure g1 = new GraphStructure();
        g1.dfs();
        System.out.println();
        g1.bfs();
    }
}

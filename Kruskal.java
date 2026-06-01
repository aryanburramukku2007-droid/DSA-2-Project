import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class Kruskal {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public static void main(String[] args) {

        parent = new int[6];

        for(int i=0;i<6;i++)
            parent[i]=i;

        Edge edges[] = {
            new Edge(4,5,1),
            new Edge(1,2,2),
            new Edge(0,2,3),
            new Edge(0,1,4),
            new Edge(3,5,4),
            new Edge(1,3,5),
            new Edge(3,4,6),
            new Edge(2,3,7),
            new Edge(2,4,8),
            new Edge(1,4,9)
        };

        Arrays.sort(edges);

        int cost = 0;

        System.out.println("MST Edges:");

        for(Edge e : edges) {
            int x = find(e.src);
            int y = find(e.dest);

            if(x != y) {
                System.out.println(
                    e.src + " - " + e.dest +
                    " : " + e.weight);

                cost += e.weight;
                union(x,y);
            }
        }

        System.out.println("Total Cost = " + cost);
    }
}
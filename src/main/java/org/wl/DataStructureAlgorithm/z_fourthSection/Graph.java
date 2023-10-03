package org.wl.DataStructureAlgorithm.z_fourthSection;

public interface Graph {

    /*顶点数*/
    int V();

    /*边数*/
    int E();

    /*向图中添加一条边v-w*/
    void addEdge(int v, int w);

    /*和v相邻的所有顶点*/
    Iterable<Integer> adj(int v);

    /*对象的字符串表示*/
    String toString();

    /*计算v的度数*/
    static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    /*计算所有顶点的最大度数*/
    static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) max = degree(G, v);
        }
        return max;
    }

    /*计算所有顶点的平均度数*/
    static double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    /*计算自环的个数*/
    static int numberOfSelfLoops(Graph G){
        int count = 0;
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (v == w) count++;
        return count/2; // 每条边都被记过两次
    }

}

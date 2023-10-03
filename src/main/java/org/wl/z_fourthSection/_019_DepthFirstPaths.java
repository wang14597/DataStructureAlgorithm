package org.wl.z_fourthSection;

import org.wl.firstSection._007_Stack;

public class _019_DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo; // 从起点到一个顶点到已知路径上到最后一个顶点
    private final int s; // 起点

    public _019_DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }


    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        _007_Stack<Integer> path = new _007_Stack<>();
        for (int x = v; x != s ; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}

package org.wl.z_fourthSection;

import org.wl.firstSection._009_Bag;

public class _017_GraphImp implements Graph {

    private final int V; // 顶点数

    private int E; //边的数目

    private _009_Bag<Integer>[] adj; // 邻接表

    public _017_GraphImp(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (_009_Bag<Integer>[]) new _009_Bag[V]; // 创建邻接表
        for (int v = 0; v < V; v++)  // 将所有链表初始化为空
            adj[v] = new _009_Bag<Integer>();
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w); // 将w添加到v的链表中
        adj[w].add(v); // 将v添加到w的链表中
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }
}

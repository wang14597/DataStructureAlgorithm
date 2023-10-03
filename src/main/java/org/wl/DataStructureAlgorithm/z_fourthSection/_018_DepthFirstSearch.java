package org.wl.DataStructureAlgorithm.z_fourthSection;

/*
搜索连通图的经典递归算法(遍历所有的顶点和边)。
要搜索一幅图，只需用一个递归方法来遍历所有顶点。在访问其中一个顶点时:
1、 将它标记为已访问;
2、 递归地访问它的所有没有被标记过的邻居顶点。
这种方法称为深度优先搜索(DFS)
*/
public class _018_DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public _018_DepthFirstSearch(Graph G, int s) {
        this.marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}

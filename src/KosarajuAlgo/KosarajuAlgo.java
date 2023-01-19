package KosarajuAlgo;

import graph.Graph_Kos;
import graph.StatusVtx;
import graph.Vtx_Kos;

import java.util.Collections;
import java.util.Stack;

public class KosarajuAlgo {

    private int count;

    private Stack<Vtx_Kos> stack;

    private Graph_Kos graph;



    public KosarajuAlgo (Graph_Kos graph){
        this.graph = graph;
        this.stack = new Stack<>();
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void computeStrongConnComp () {
        visitGraph_pushIntoStack(StatusVtx.NOT_VISITED);
        visitGraph_computeConnComp(StatusVtx.VISITED_ONE_TIME);
    }

    private void visitGraph_pushIntoStack(StatusVtx notVisited){
        for (Vtx_Kos v : graph.getVerticesList()){  // check all the vertices in case of a not connected graph
            if(v.getStatus() == notVisited)
                dfs_pushIntoStack(notVisited, v);
        }
    }

    private void dfs_pushIntoStack(StatusVtx notVisited, Vtx_Kos startVtx) {
        startVtx.setNextStatus();
        for(Vtx_Kos v : startVtx.getAdjacencyVtxList())
            if(v.getStatus() == notVisited)
                dfs_pushIntoStack(notVisited,v);
        stack.push(startVtx);
    }

    private void visitGraph_computeConnComp (StatusVtx notVisited) {
        Collections.reverse(stack);
        for(Vtx_Kos v : stack) {
            if (v.getStatus() == StatusVtx.VISITED_ONE_TIME) {
                dfs_setConnComp(notVisited, v);
                count++;
            }
        }
    }

    private void dfs_setConnComp (StatusVtx notVisited, Vtx_Kos startVtx) {
        startVtx.setNextStatus();
        startVtx.setComponentId(count);
        for(Vtx_Kos v : startVtx.getAdjacencyTransposedVtxList())
            if(v.getStatus() == notVisited)
                dfs_setConnComp(notVisited,v);
    }



}

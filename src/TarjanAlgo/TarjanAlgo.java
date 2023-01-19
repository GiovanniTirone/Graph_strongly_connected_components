package TarjanAlgo;

import graph.Graph;
import graph.StatusVtx;
import graph.Vtx_Tar;

import java.util.Stack;

public class TarjanAlgo {

    private Graph<Vtx_Tar> graph;
    private Stack<Vtx_Tar> stack;
    private int index;
    private int connCompCounter;

    public TarjanAlgo (Graph<Vtx_Tar> graph) {
        this.graph = graph;
        this.stack = new Stack<>();
    }

    public int getConnCompCounter() {
        return connCompCounter;
    }

    public void computeConnComp () {
        for(Vtx_Tar v : graph.getVerticesList())
            if(v.getStatus() == StatusVtx.NOT_VISITED)
                dfs(v);
    }

    private void dfs (Vtx_Tar startVtx){

        startVtx.setIndex(index);
        startVtx.setLowLink(index);
        index++;
        startVtx.setNextStatus();
        stack.add(startVtx);
        startVtx.setOnStack(true);

        for(Vtx_Tar v : startVtx.getAdjacencyVtxList()){
            if(v.getStatus() == StatusVtx.NOT_VISITED) {
                dfs(v);
                startVtx.setLowLink(Math.min(startVtx.getLowLink(),v.getLowLink()));
            }
            else if(v.isOnStack()){
                startVtx.setLowLink(Math.min(startVtx.getLowLink(),v.getIndex()));
            }
        }
        
        if(startVtx.getIndex() == startVtx.getLowLink()){
            Vtx_Tar w;
            do{
              w = stack.pop();
              w.setOnStack(false);
              w.setComponentId(connCompCounter);
            }
            while(w != startVtx);
            connCompCounter++;
        }

    }

}

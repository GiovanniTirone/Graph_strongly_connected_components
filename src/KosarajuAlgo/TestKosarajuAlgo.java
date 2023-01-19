package KosarajuAlgo;

import graph.Graph_Kos;
import graph.Vtx_Kos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TestKosarajuAlgo {

    public static void main(String[] args) {

        List<Vtx_Kos> vertexList =
                createVtxList(new String[]{"a","b","c","d","e","f","g","h" });
        Graph_Kos graph = new Graph_Kos(vertexList,new ArrayList<>());

        createEdges(graph,new int[][]{
                {1,0,1},
                {1,4,0},
                {1,1,2},
                {1,1,4},
                {1,1,5},
                {1,2,3},
                {1,2,6},
                {1,3,2},
                {1,3,7},
                {1,4,5},
                {1,5,6},
                {1,6,5},
                {1,7,3},
                {1,7,6}
        });

        KosarajuAlgo ka = new KosarajuAlgo(graph);
        ka.computeStrongConnComp();
        System.out.println("number of conn comp: " + ka.getCount());
        vertexList.forEach(System.out::println);


    }

    public static List<Vtx_Kos> createVtxList (String [] names){
        AtomicInteger idCounter = new AtomicInteger(0);
        return Arrays.stream(names)
                .map(name -> new Vtx_Kos(idCounter.getAndIncrement(),name))
                .collect(Collectors.toList());
    }

    public static void createEdges (Graph_Kos graph, int [][] weight_start_target) {
        List<Vtx_Kos> vtxList = graph.getVerticesList();
        Arrays.stream(weight_start_target)
                .forEach(wst -> {
                    try {
                        graph.createEdge(wst[0],vtxList.get(wst[1]),vtxList.get(wst[2]));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

}

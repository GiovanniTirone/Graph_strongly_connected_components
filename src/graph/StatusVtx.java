package graph;

import java.util.Arrays;

public enum StatusVtx {
    NOT_VISITED,
    VISITED_ONE_TIME,
    VISITED_TWO_TIMES;

    public StatusVtx getNextStatus () {
        int currentIndex = Arrays.asList(StatusVtx.values()).indexOf(this);
        return StatusVtx.values()[currentIndex+1];
    }

}

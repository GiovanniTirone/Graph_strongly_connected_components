package graph;

public class Vtx_Tar extends Vertex<Vtx_Tar>{

    private boolean onStack;
    private int index;
    private int lowLink;

    public Vtx_Tar(int id, String name) {
        super(id, name);
    }

    public boolean isOnStack() {
        return onStack;
    }

    public void setOnStack(boolean onStack) {
        this.onStack = onStack;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLowLink() {
        return lowLink;
    }

    public void setLowLink(int lowLink) {
        this.lowLink = lowLink;
    }



}

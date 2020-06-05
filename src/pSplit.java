package src;

public class pSplit extends Thread{
    
    public pSplit(Pair p) {
        super();
        this.p = p;
    }

    @Override
    public void run(){
        Grid.getGrid().getCell(this.p).split();
    }
    
    private Pair p;
}
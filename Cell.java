import java.util.ArrayList;

public class Cell{
    // Constructors
    public Cell(int l,int w){
        p1 = l;
        p2 = w;
        this.atomsInIt = new ArrayList<>();
    }
    
    public Cell(int i,int j,int t){
        this(i,j);
        setThreshold(t);
    }

    public Cell(Pair p,int t){
        this(p.first(),p.second(),t);
    }

    public Cell(Cell cell) {
        this.threshold = cell.threshold;
        this.p1 = cell.p1;
        this.p2 = cell.p2;
        this.atomsInIt = new ArrayList<>();
        for(Atom i:cell.atomsInIt)
            this.atomsInIt.add(new Atom(i));
	}

    // Methods
    public boolean newAtom(Atom a){
        if(this.atomCount() == 0){
            putAtom(a);
            return true;
        }
        else if(a.getColor() == this.atomsInIt.get(0).getColor()){
            putAtom(a);
            return true;
        }
        else 
            return false;
    }

    public void putAtom(Atom a){
        int new_color = a.getColor();
        if(this.atomCount() != 0){
            if( this.atomsInIt.get(0).getColor() != new_color){
                controller.get().newCellCaptured(this.atomsInIt.get(0).getColor(),new_color);
                for(Atom eachAtom: atomsInIt)
                    eachAtom.setColor(new_color);
            }
        }
        else{
            controller.get().newCellEstablished(a.getColor());
        }
        this.atomsInIt.add(a);
        controller.get().AddToTlist(new Pair(this.p1, this.p2));
    }
    
    public synchronized void split(){
        if(this.atomCount() >= this.getThreshold()){
            if(this.atomCount() == this.getThreshold())
                controller.get().vacateCell(atomsInIt.get(0).getColor());
            if ((p1 >= 0)&&(p2 >=0)&&(p1<Grid.getGrid().l)&&(p2<Grid.getGrid().w)){
                if ((p1+1 >= 0)&&(p2 >=0)&&(p1+1<Grid.getGrid().l)&&(p2<Grid.getGrid().w))
                    Grid.getGrid().cellList[p1+1][p2].putAtom(atomsInIt.remove(0));
                if ((p1-1 >= 0)&&(p2 >=0)&&(p1-1<Grid.getGrid().l)&&(p2<Grid.getGrid().w))
                    Grid.getGrid().cellList[p1-1][p2].putAtom(atomsInIt.remove(0));
                if ((p1 >= 0)&&(p2-1 >=0)&&(p1<Grid.getGrid().l)&&(p2-1<Grid.getGrid().w))
                    Grid.getGrid().cellList[p1][p2-1].putAtom(atomsInIt.remove(0));
                if ((p1 >= 0)&&(p2+1 >=0)&&(p1<Grid.getGrid().l)&&(p2+1<Grid.getGrid().w))
                    Grid.getGrid().cellList[p1][p2+1].putAtom(atomsInIt.remove(0));
            }
        }
    }
    
    public void reset(){
        atomsInIt.removeAll(atomsInIt);
    }
    
    // Setters
    public void setThreshold(int t){
        threshold = t;
    }
    
    // Getters
    public int getThreshold(){
        return threshold;
    }
    public int atomCount(){
        return atomsInIt.size();
    }
    public int currentOwner(){
        if(this.atomCount() == 0)
            return -1;
        return this.atomsInIt.get(0).getColor();
    }
    // Variables
    private int threshold;
    private int p1,p2;
    private ArrayList<Atom>atomsInIt;
    
    /*
     * The Access Specifiers
     * are the number of atoms in a cell going to be a number or itself going to be embeded objects? Embeded objects
    */
}
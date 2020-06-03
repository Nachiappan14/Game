

public class Grid{
    // Constructors
    public Grid(int i,int j){
        l = i;
        w = j;
        cellList = new Cell[l][w];
        lastGrid = this;
    }
    public Grid(Grid a){
        this.l = a.l;
        this.w = a.w;
        this.cellList = new Cell[this.l][this.w];
        for(int i=0;i<this.l;i++)
            for(int j=0;j<this.w;j++)
                this.cellList[i][j] = new Cell(a.cellList[i][j]);
    } 
    // Methods
    
    // Setters
    
    // Getters
    static public Grid getGrid(){
        return lastGrid;
    }
    public int getL(){
        return l;
    }
    public int getW(){
        return w;
    }

    // Variables
    int l,w;
    Cell[][] cellList;
    static Grid lastGrid;

    /*
     * what is the interface of the frontEnd we are going to use? AndroidStudio
    */
}
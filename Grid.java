
public class Grid{
    // Constructors
    public Grid(int a,int b){
        this.l = a;
        this.w = b;
        cellList = new Cell[this.l][this.w];
        for(int i=0;i<this.l;i++)
            for(int j=0;j<this.w;j++)
                this.cellList[i][j] = new Cell(i,j,(i+j==0)?2:(i*j==0)?3:4);
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
    public Cell getCell(Pair p){
        return cellList[p.first()][p.second()];
    }
    
    static public Grid getGrid(){
        return lastGrid;
    }
    public int getL(){
        return this.l;
    }
    public int getW(){
        return this.w;
    }

    // Variables
    int l,w;
    Cell[][] cellList;
    static Grid lastGrid;

    /*
     * what is the interface of the frontEnd we are going to use? AndroidStudio
    */
}
package src;

public class Grid{
    // Constructors
    public Grid(int a,int b){
        this.l = a;
        this.w = b;
        cellList = new Cell[this.l][this.w];
        for(int i=1;i<this.l-1;i++)
            for(int j=1;j<this.w-1;j++)
                this.cellList[i][j] = new Cell(i,j,4);
        for(int j=1;j<this.w-1;j++){
            this.cellList[this.l-1][j] = new Cell(this.l-1,j,3);
            this.cellList[0][j] = new Cell(0,j,3);
        }
        for(int i=1;i<this.l-1;i++){
            this.cellList[i][this.w-1] = new Cell(i,this.w-1,3);
            this.cellList[i][0] = new Cell(i,0,3);
        }
        this.cellList[0][0] = new Cell(0,0,2);
        this.cellList[this.l-1][0] = new Cell(this.l-1,0,2);
        this.cellList[0][this.w-1] = new Cell(0,this.w-1,2);
        this.cellList[this.l-1][this.w-1] = new Cell(this.l-1,this.w-1,2);
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
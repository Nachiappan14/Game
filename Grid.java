import java.util.ArrayList;

public class Grid{
    // Constructors
    public Grid(int l,int w){
        cellList = new ArrayList<>();
        // TODO : decide the method and complete the constructor
        // is it going to be a 1d array(we can use some calculations in this case to maintain it) or 2d array or arraylist?
    }
    
    // Methods
    
    // Setters
    
    // Getters
    public Grid getGrid(){
        return this;
        // can we make this static method and make it return the last created object of the grid ?
    }

    // Variables
    ArrayList<Cell> cellList;
    /*
     * who's the controller of the game ? {depending on this answer we might have to create new classes or add many methods}
     * how is the size of the grid decided ?
     * what data structure is to be used to hold the cells in the grid ?
     * where is the number of the grids owned by a player maintained ?
     * what is the interface of the frontEnd we are going to use?
    */
}
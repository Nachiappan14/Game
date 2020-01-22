import java.util.ArrayList;

public class Grid{
    // Constructors
    public Grid(int l,int w){
        cellList = new ArrayList<>();
        // TODO : decide the method and complete the constructor
        // is it going to be a 1d array(we can use some calculations in this case to maintain it) or 2d array or arraylist? 2d array
    }
    // copyconstructor for the grid to maintian the previous value

    // Methods
        // SplitToNeighbours
            // the threading is to be done in this
        // Setters
    
    // Getters
    static public Grid getGrid(){
        return this;
        // can we make this static method and make it return the last created object of the grid ? static
    }

    // Variables
    ArrayList<Cell> cellList;// make this array

    /*
     * who's the controller of the game ? {depending on this answer we might have to create new classes or add many methods} A new class required 
     * how is the size of the grid decided ? nope
     * what data structure is to be used to hold the cells in the grid ? Array of Arrays
     * where is the number of the grids owned by a player maintained ? the New class
     * what is the interface of the frontEnd we are going to use? AndroidStudio
    */
}
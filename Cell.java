public class Cell{
    // Constructors
    public Cell(){
        // TODO: the method and parameter of the function to be decided
        //  also number of constructors?
    }
    // Methods
    public void putAtom(){
        // TODO: The function pattern and the type of transfer(as in like the atom is sent as object or some other stuff like color is going to be sent) to be decided
    }
    
    // Setters
    public void setThreshold(int t){
        threshold = t;
        // is it required or just the constructor must do this instantiation?
    }
    
    // Getters
    public int getThreshold(){
        return threshold;
    }

    // Variables
    private int threshold;
    
    /*
     * Are we going to have the threshold as a variable? or the Cell as the basic class and the types of cells as a derieved one ?
     * The Access Specifiers
     * are the number of atoms in a cell going to be a number or itself going to be embeded objects?
    */
}
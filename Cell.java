public class Cell{
    // Constructors
    public Cell(){
        // TODO: the method and parameter of the function to be decided
        //  also number of constructors?
    }
    // A constructor assigning the thereshold
    // Methods
    public void putAtom(){
        // decide the threading sratergy
        // check fot the crossing of the treshold and take appropriate
        // TODO: The function pattern and the type of transfer(as in like the atom is sent as object or some other stuff like color is going to be sent) to be decided
    }
        // build a reset  method in it
    
    // Setters
    // remove the set function
    public void setThreshold(int t){
        threshold = t;
        // is it required or just the constructor must do this instantiation?
    }
    
    // Getters
    public int getThreshold(){
        return threshold;
    }
    // add a getter to return the number of atoms at present

    // Variables
    private int threshold;
    // add the atoms in the arrayList named atomsInIt 
    
    /*
     * Are we going to have the threshold as a variable? or the Cell as the basic class and the types of cells as a derieved one ? The threshold one must work
     * The Access Specifiers
     * are the number of atoms in a cell going to be a number or itself going to be embeded objects? Embeded objects
    */
}
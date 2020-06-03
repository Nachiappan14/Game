import java.util.List;

public class controller {
    public controller(){
        // TODO: fill the required variables
        LastController = this;
    }

    public void AddToTlist(Pair a){
        TList.add(a);
    }

    public void game(){
        int moveNumber = 0;
        while(!endGame){
            if(this.playerActive.get(moveNumber % numberOfPlayers) == true){
                // TODO: the code for the game goes here
            }
            moveNumber += 1;
        }
    }

    public void getMove(int player_id){
        //TODO: a function to get the position of the click and eventualy be linked to display part
    }

    public void makeMove(Pair pos){
        // TODO: the required work processing for the made move
    }

    public static controller get(){
        return LastController;
    }

	public synchronized void newCellCaptured(int old_owner, int new_owner) {
        this.cellsCaptured.set(old_owner, this.cellsCaptured.get(old_owner)-1);
        this.cellsCaptured.set(new_owner, this.cellsCaptured.get(new_owner)+1);
        if(this.cellsCaptured.get(old_owner)==0)
            this.kick(old_owner);
	}

	private void kick(int owner_id) {
        this.playerActive.set(owner_id,false);
        playersInGame -= 1;
        if(playersInGame == 1)
            endGame = true;
        // kick the player out of the game
    }

    public synchronized void newCellEstablished(int new_owner) {
        this.cellsCaptured.set(new_owner, this.cellsCaptured.get(new_owner)+1);
    }

    int numberOfPlayers;
    List<Pair> TList;
    List<Player> PList;// decide if this is wanted
    List<Integer> cellsCaptured;
    static controller LastController;
    List<Boolean> playerActive;
    int playersInGame;
    boolean endGame;

    /*
     * Maintain the Player as a seperate object or just put it as variables here?
    */
}
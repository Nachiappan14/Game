package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class controller {
    public controller(int numberOfPlayers,int grid_len,int grid_wid){
        this.numberOfPlayers = numberOfPlayers;
        this.gameGrid = new Grid(grid_len, grid_wid);
        this.previousVersion = new Grid(this.gameGrid);
        this.playersInGame = numberOfPlayers;
        this.playerActive = new ArrayList<Boolean>(Collections.nCopies(this.numberOfPlayers,true));
        this.cellsCaptured = new ArrayList<>(Collections.nCopies(this.numberOfPlayers,0));
        this.TList = new ArrayList<>();
        this.endGame = false;
        LastController = this;
        cin = new Scanner(System.in);
        out = new text_view();
        // this.game();
    }

    public void AddToTlist(Pair a){
        TList.add(a);
    }

    public void game(){
        int moveNumber = 0;
        while(!endGame){
            int playerToMove = moveNumber % this.numberOfPlayers;
            if(this.playerActive.get(playerToMove) == true){
                Pair movePos = this.getMove(moveNumber);
                while(!this.makeMove(movePos,new Atom(playerToMove))){
                    // Alert that the previous input is assumed to be invalid (Enhancement)
                    movePos = this.getMove(moveNumber);
                }
                out.render();
            }
            moveNumber += 1;
        }
        System.out.println("THE WINNER IS PLAYER NUMBER<Indexed 0> ="+ this.playerActive.indexOf(true));
    }

    public Pair getMove(int player_id){
        return out.read(player_id);
        //This function to get the position of the click and eventualy be linked to display part for taking input
    }

    public boolean makeMove(Pair pos,Atom a){
        boolean result;
        try{
            result = this.gameGrid.getCell(pos).newAtom(a);
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            result = false;
        }
        if(result){
            ArrayList<pSplit> currentThreads;
            while (!TList.isEmpty()){
                currentThreads = new ArrayList<>();
                Iterator<Pair> itr = TList.iterator();
                while(itr.hasNext()){
                    Pair p = itr.next();
                    itr.remove();
                    pSplit spliter = new pSplit(p);
                    currentThreads.add(spliter);
                }
                for(pSplit p : currentThreads)
                    p.start();
                try{
                    for(pSplit p: currentThreads)
                        p.join();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        return result;
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
            this.endGame = true;
        // kick the player out of the game
    }

    public synchronized void newCellEstablished(int new_owner) {
        this.cellsCaptured.set(new_owner, this.cellsCaptured.get(new_owner)+1);
    }

    public synchronized void vacateCell(int owner) {
        this.cellsCaptured.set(owner,this.cellsCaptured.get(owner)-1);
    }

    public void animateMove(Pair src,Pair dst,Atom a){
        out.animateAtom(src,dst,a);
    }

    public Grid getGrid() {
		return this.gameGrid;
    }
    
    int numberOfPlayers;
    ArrayList<Pair> TList;
    // List<Player> PList;// decide if this is wanted
    List<Integer> cellsCaptured;
    static controller LastController;
    List<Boolean> playerActive;
    int playersInGame;
    boolean endGame;
    Grid gameGrid;
    Grid previousVersion;
    java.util.Scanner cin;
    view out;
    /*
     * Maintain the Player as a seperate object or just put it as variables here?
    */
}
import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private int moves;  // It's good to explicitly initialize this to 0

    public Bear(boolean polar){
        this.polar = polar;
        this.moves = 0;  // Initialize moves
    }

    public Color getColor() {
        // Returns color based on the polar flag
        return polar ? Color.WHITE : Color.BLACK;
    }

    public String toString(){
        // Alternates between / and \ on each move
        return moves % 2 == 0 ? "/" : "\\";
    }

    public Action getMove(CritterInfo info){
        // Increment moves counter here, assuming each call to getMove corresponds to a move
        moves++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;  // Explicitly return LEFT when other conditions don't apply
        }
    }
}

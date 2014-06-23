import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by richiethomas on 6/21/14.
 */
public class Board {

    private List<String> moves;
    private PrintStream out;

    public Board(PrintStream out, List<String> moves) {
        this.moves = moves;
        this.out = out;
    }

    public String getMoveAtPosition(int space) {
        return moves.get(space);
    }

    public Boolean isPositionTaken(int move) {
        return !moves.get(move).equals(" ");
    }

    public void setMoveForPlayer(int move, Player player) {
        moves.set(move, player.getSymbol());
    }

    public boolean isFull() {
        return !moves.contains(" ");
    }

    public void draw() {
        String text = String.format(
                "%s|%s|%s\n" +
                        "-----\n" +
                        "%s|%s|%s\n" +
                        "-----\n" +
                        "%s|%s|%s",
                getMoveAtPosition(0), getMoveAtPosition(1), getMoveAtPosition(2),
                getMoveAtPosition(3), getMoveAtPosition(4), getMoveAtPosition(5),
                getMoveAtPosition(6), getMoveAtPosition(7), getMoveAtPosition(8));
        out.println(text);
    }

    public Boolean anyRowFilled(Player player) {
        String symbol = player.getSymbol();
        if((getMoveAtPosition(0) == symbol && getMoveAtPosition(1) == symbol && getMoveAtPosition(2) == symbol) ||
            (getMoveAtPosition(3) == symbol && getMoveAtPosition(4) == symbol && getMoveAtPosition(5) == symbol) ||
            (getMoveAtPosition(7) == symbol && getMoveAtPosition(8) == symbol && getMoveAtPosition(8) == symbol)) {
            return true;
        }
        return false;
    }

    public Boolean anyColumnFilled(Player player) {
        String symbol = player.getSymbol();
        if((getMoveAtPosition(0) == symbol && getMoveAtPosition(3) == symbol && getMoveAtPosition(6) == symbol) ||
            (getMoveAtPosition(1) == symbol && getMoveAtPosition(4) == symbol && getMoveAtPosition(7) == symbol) ||
            (getMoveAtPosition(2) == symbol && getMoveAtPosition(5) == symbol && getMoveAtPosition(8) == symbol)) {
            return true;
        }
        return false;
    }

    public Boolean anyDiagonalFilled(Player player) {
        String symbol = player.getSymbol();
        if((getMoveAtPosition(0) == symbol && getMoveAtPosition(4) == symbol && getMoveAtPosition(8) == symbol) ||
            (getMoveAtPosition(2) == symbol && getMoveAtPosition(4) == symbol && getMoveAtPosition(6) == symbol)) {
            return true;
        }
        return false;
    }
}

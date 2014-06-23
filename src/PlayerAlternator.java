/**
 * Created by richiethomas on 6/22/14.
 */
public class PlayerAlternator {

    private Player currentPlayer;
    private Player playerOne;
    private Player playerTwo;

    public PlayerAlternator(Player currentPlayer, Player playerOne, Player playerTwo) {
        this.currentPlayer = currentPlayer;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Player setFirstPlayer() {
        return playerOne;
    }

    public Player toggleCurrentPlayer() {
        currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
        return currentPlayer;
    }

}

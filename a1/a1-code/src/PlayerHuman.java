import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class represents a human player of Othello and includes some possible 
 * output while moving in wrong places of the board. It can also collect the rows
 * and columns of a move.
 */
public class PlayerHuman {
	
	private static final String INVALID_INPUT_MESSAGE = "Invalid number, please enter 1-8";
	private static final String IO_ERROR_MESSAGE = "I/O Error";
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	private Othello othello;
	private char player;

	/**
	 * Constructs a new PlayerHuman with a new Othello game, and a player
	 * 
	 * @param othello	the Othello game
	 * @param player	either P1 or P2
	 */
	public PlayerHuman(Othello othello, char player) {
		
		this.othello = othello;
		this.player = player;
	}

	/**
	 * Return the Move object which represents the move of row and col.
	 * 
	 * @return Move object passed by int row and int col
	 */
	public Move getMove() {
		
		int row = getMove("row: ");
		int col = getMove("col: ");
		return new Move(row, col);
	}

	/**
	 * Return the move embedded in the message and try the value to handle
	 * any possible invalid input.
	 * 
	 * @param message  the String message contains the move number
	 * @return the move if message if valid, otherwise -1
	 */
	private int getMove(String message) {
		
		int move, lower = 0, upper = 7;
		while (true) {
			try {
				System.out.print(message);
				String line = PlayerHuman.stdin.readLine();
				move = Integer.parseInt(line);
				if (lower <= move && move <= upper) {
					return move;
				} else {
					System.out.println(INVALID_INPUT_MESSAGE);
				}
			} catch (IOException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
				break;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		return -1;
	}
}

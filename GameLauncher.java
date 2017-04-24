package GameCode;

/**
 * The main launcher for the domino game
 * @author Damani
 *
 */
public class GameLauncher {
	/**
	 * The static main method to launch the application
	 * @param args - Command line arguments for the launcher
	 */
	public static void main(String args[])
	{
		System.out.println("Domino Game launched.");
		GameModel m = GameModel.instance();
		m.playGame();
	}	
}

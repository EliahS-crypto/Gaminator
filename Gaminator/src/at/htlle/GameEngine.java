package at.htlle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import at.htlle.games.Game;
import at.htlle.guessanumber.GuessANumber;

/**
 * Eine einfache Starterklasse 
 * @author Hutter
 */
public class GameEngine
{
	private static String filename = "D:\\myObj.obj";
	private static GuessANumber guess;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		// Spiel initialisieren
		 guess = new GuessANumber();
		
		// Hier bitte das eigene Spiel aufrufen, sonst in dieser Klasse (und auch in dem Game Intrafce nichts ändern)
		
		// und starten
		play(guess);
	}

	/**
	 * Spielt das uebergebene Spiel. Diese Funktion darf nicht geaendert werden. 
	 * 
	 * 
	 * @param g zu spielendes Spiel
	 * @throws IOException
	 */
	public static void play(Game g) throws IOException
	{
		System.out.println("============== You are playing " + g.getName() + " ================");

		if(Paths.get(filename).toFile().exists()) {
			g = (Game) guess.deserialize((filename));
			System.out.println("true");
		}
		// Spiel starten und Text ausgeben
		System.out.println(g.start());

		// Von der Konsole wird immer Zeilenweise gelesen
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// Solange das Spiel nicht beendet ist
		while(g.isFinished() == false)
		{
			String eingabe = in.readLine();
			if(eingabe.equals("SAVE")) {
				guess.serialize(g, filename);
			}
			System.out.println(g.next(in.readLine()));
		}
		// Spiel mitteilen dass es beendet wurde
		System.out.println(g.stop());
	}

}

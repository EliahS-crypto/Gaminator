package at.htlle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import at.htlle.games.Game;
import at.htlle.guessanumber.GuessANumber;
import at.htlle.ms.Millionenshow;
import at.httle.ticktacktoe.createTTT;

/**
 * Eine einfache Starterklasse 
 * @author Hutter
 */
public class GameEngine
{

	private static String filename = "D:\\myGame.obj";
	private static Millionenshow m;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		// Spiel initialisieren
		 m = new Millionenshow();
		
		// Hier bitte das eigene Spiel aufrufen, sonst in dieser Klasse (und auch in dem Game Intrafce nichts ändern)
		
		// und starten
		play(m);
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
			g = (Game) Millionenshow.deserialize((filename));
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
				Millionenshow.serialize(m, filename);
			}else {
			System.out.println(g.next(eingabe));
			}
		}
		
		
		
		// Spiel mitteilen dass es beendet wurde
		System.out.println(g.stop());
	}

}

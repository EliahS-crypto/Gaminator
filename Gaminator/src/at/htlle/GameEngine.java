package at.htlle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

import at.htlle.games.Game;
import at.htlle.guessanumber.GuessANumber;
import at.htlle.ms.Millionenshow;

/**
 * Eine einfache Starterklasse
 * 
 * @author Hutter
 */
public class GameEngine {
	private static String filename = "D:\\myGame.obj";
	private static GuessANumber guess;
	private static Game mill;

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Spiel initialisieren
		mill = new Millionenshow();

		// Hier bitte das eigene Spiel aufrufen, sonst in dieser Klasse (und auch in dem
		// Game Intrafce nichts ändern)

		// und starten
		play(mill);
	}

	/**
	 * Spielt das uebergebene Spiel. Diese Funktion darf nicht geaendert werden.
	 * 
	 * 
	 * @param g zu spielendes Spiel
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void play(Game g) throws IOException, ClassNotFoundException {
		System.out.println("============== You are playing " + g.getName() + " ================");

		if (Paths.get(filename).toFile().exists()) {
			g = (Game) g.deserialize(filename);
			Paths.get(filename).toFile().delete();
		}

		// Spiel starten und Text ausgeben
		System.out.println(g.start());

		// Von der Konsole wird immer Zeilenweise gelesen
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// Solange das Spiel nicht beendet ist
		while (g.isFinished() == false) {
			String eingabe = in.readLine();
			if (eingabe.equals("SAVE")) {
				g.serialize(g, filename);
				System.out.println("Spiel gespeichert");
				break;
			} else {
				System.out.println(g.next(eingabe));
			}
		}

		// Spiel mitteilen dass es beendet wurde
		System.out.println(g.stop());
	}

}

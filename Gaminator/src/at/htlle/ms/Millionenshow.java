package at.htlle.ms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import at.htlle.GameEngine;
import at.htlle.games.Game;

public class Millionenshow implements Game, Serializable {
	
	private static final long serialVersionUID = -1559480890557480752L;
	Scanner eingabe = new Scanner(System.in);
	int fragenr = 0;
	BufferedReader br;
	private boolean finished = false;
	private boolean isSerialized = false;

	String questions[] = { "In welchem Verein spielt der Profi-Fußballer Mohammed Salah?",
			"Wie viele Knochen hat ein erwachsener Mensch?", "Ist das Herz eher links oder rechts?",
			"Ist der Amazonas oder der Nil laenger?", "Woraus bestehen Muskeln hauptsächlich?",
			"Wie sieht die Zahl 4 binär aus?" };

	String answers[] = { "Liverpool", "214", "links", "Nil", "Wasser", "0100" };

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return " Millionenshow !";
	}

	@Override
	public String start() {

		return "Wir beginnen mit den Fragen. Der Schwierigkeitsgrad wird von Frage zu Frage immer höher. Drücken Sie Enter.";
	

	}

	@Override
	public String stop() {

		return "Thank you for playing in our show";
	}

	/**
	 * Naechster Spielzug.
	 * 
	 * Wenn der Aufruf true zurÃ¼ckgibt dann weden von der Spieleengine wieder neue
	 * Eingaben abgefragt und in einem nÃ¤chsten Aufruf an die Funktion Ã¼bergeben.
	 * 
	 * Exceptions werden von der Gameengine nicht abgearbeitet und muessen daher in
	 * dieser Funktion abgefangen werden.
	 * 
	 * @param inp
	 *            Text der in der Commandline vom Benutzer eingegeben wurde.
	 */

	@Override
	public String next(String inp) {

		while (this.fragenr < this.questions.length && finished == false) {
			String naechsteFrage = questions[this.fragenr];

			System.out.println(naechsteFrage);
			inp = eingabe.next();
			if (inp.equalsIgnoreCase(answers[this.fragenr])) {
				this.fragenr++;

			}else if(inp.equals("SAVE"))
			{
				isSerialized = true;
				
			}else {
				finished = true;
				break;
				//return "Leider war das falsch. " + answers[this.fragenr] + " wäre die richtige Antwort";

			}
			stop();
		}

		return "Ende";

	}

	@Override
	public boolean isFinished() {
		return this.finished;

	}
	public boolean Serialized() {
		return this.isSerialized;
	}
	 

	@Override
	public String showSolution() {

		return "The right answers is :" + answers;
	}
	
	public static void serialize(Object obj, String filename)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
			
		}
		catch (IOException e)
		{
			System.err.println(e);
		}


		/**
		 * Deserialisiert das erste Objekt aus der Datei
		 * @param filename
		 * @return
		 */
	}
		public static Object deserialize(String filename)
		{
			Object ret = null;
			try
			{
				FileInputStream fis = new FileInputStream(filename);
				ObjectInputStream o = new ObjectInputStream(fis);
				ret =  o.readObject();
				o.close();
			}
			catch (IOException e)
			{
				System.err.println(e);
			}
			catch (ClassNotFoundException e)
			{
				System.err.println(e);
			}

			return ret;
		}
}

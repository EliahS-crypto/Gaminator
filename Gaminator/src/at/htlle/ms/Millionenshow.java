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
	int fragenr;
	BufferedReader br;
	private boolean finished = false;
	private boolean isSerialized = false;

	String questions[] = { "In welchem Verein spielt der Profi-Fuﬂballer Mohammed Salah?",
			"Wie viele Knochen hat ein erwachsener Mensch?", "Ist das Herz eher links oder rechts?",
			"Ist der Amazonas oder der Nil laenger?", "Woraus bestehen Muskeln haupts‰chlich?",
			"Wie sieht die Zahl 4 bin‰r aus?" };

	String answers[] = { "Liverpool", "214", "links", "Nil", "Wasser", "0100" };

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return " Millionenshow !";
	}

	@Override
	public String start() {
		
		if (isSerialized == true) {
			return "Du spielst nun dein voriges Spiel weiter.\n\n" + questions[this.fragenr];
		}
		fragenr = 0;
		return "Wir beginnen mit den Fragen. Der Schwierigkeitsgrad wird von Frage zu Frage immer hˆher.\n\n" + questions[fragenr];
		

	}

	@Override
	public String stop() {

		return "Thank you for playing in our show";
	}

	/**
	 * Naechster Spielzug.
	 * 
	 * Wenn der Aufruf true zur√ºckgibt dann weden von der Spieleengine wieder neue
	 * Eingaben abgefragt und in einem n√§chsten Aufruf an die Funktion √ºbergeben.
	 * 
	 * Exceptions werden von der Gameengine nicht abgearbeitet und muessen daher in
	 * dieser Funktion abgefangen werden.
	 * 
	 * @param inp Text der in der Commandline vom Benutzer eingegeben wurde.
	 */

	@Override
	public String next(String inp) {

		
		if (inp.equalsIgnoreCase(answers[this.fragenr])) {
			this.fragenr++;
			if(this.fragenr == this.questions.length) {
				this.finished = true;
				return "Richtig!!! Das waren alle Fragen";
			}
			return "Richtig! \nN‰chste Frage:\n" + questions[this.fragenr];

		}else {
			finished = true;
			return "Leider war das falsch. " + answers[this.fragenr] + " w‰re die "
					+ "richtige Antwort";

		
		}
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

	public void serialize(Object obj, String filename) {
		try {
			this.isSerialized = true;
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream o = new ObjectOutputStream(file);
			o.writeObject(obj);
			o.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

		/**
		 * Deserialisiert das erste Objekt aus der Datei
		 * 
		 * @param filename
		 * @return
		 */


	public Object deserialize(String filename) {
		Object ret = null;
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream o = new ObjectInputStream(file);
			ret = o.readObject();
			o.close();
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}

		return ret;
	}
}

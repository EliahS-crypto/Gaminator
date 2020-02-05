package at.htlle.games;

/**
 * Das Spiele Interface muss von jedem Spiel implementiert werden. Die Klasse
 * GuessANumber ist eine Art lebende Dokumentation wie dieses Interface
 * anzuwenden und zu verstehen ist.
 * 
 * Das Interface darf nicht abgeaendert werden.
 * 
 * @author Hutter
 */
public interface Game {
	/**
	 * Liefert den Namen des Spieles zurück
	 */
	public String getName();

	/**
	 * Beginnt mit dem Spiel. Hier kann das Spiel seine Hilfe ausgeben und ggf.
	 * irgendwelche initialisierungen machen
	 */
	public String start();

	/**
	 * Stoppt das Spiel. Hier kann das Spiel aufraeumarbeiten erledigen.
	 */
	public String stop();

	/**
	 * Naechster Spielzug.
	 * 
	 * Wenn der Aufruf true zurückgibt dann weden von der Spieleengine wieder neue
	 * Eingaben abgefragt und in einem nächsten Aufruf an die Funktion übergeben.
	 * 
	 * Exceptions werden von der Gameengine nicht abgearbeitet und muessen daher in
	 * dieser Funktion abgefangen werden.
	 * 
	 * @param inp Text der in der Commandline vom Benutzer eingegeben wurde.
	 */
	public String next(String inp);

	/**
	 * Methode anhand die Gameengine abfragen kann ob das Spiel bereits zu ende ist.
	 * Wenn die Funktion false zurückgibt dann wird der Spieleengine signalisiert
	 * dass das Spiel zu ende ist, und die Funktion next wird nicht mehr aufgerufen.
	 * 
	 * @return
	 */
	public boolean isFinished();

	/**
	 * Zeigt die Loesung an. Manche Spiele haben auch keine Lösung, dann sollte
	 * hier entsprechend reagiert werden.
	 */
	public String showSolution();

	public void serialize(Object obj, String filename);

	public Object deserialize(String filename);

}

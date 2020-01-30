package at.httle.ticktacktoe;

import java.util.Scanner;

import at.htlle.games.Game;

public class createTTT implements Game{
	
	Scanner eingabe = new Scanner(System.in);
	boolean finished = false;
	String [] board = null;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Tick Tack Toe";
	}

	@Override
	public String start() {
		// TODO Auto-generated method stub
		return "Lass uns starten";
	}

	@Override
	public String stop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String next(String inp) {
		board = new String [9];

		while(finished = false) {
			
			System.out.println("/---|---|---\\");
			System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
			System.out.println("|-----------|");
			System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
			System.out.println("|-----------|");
			System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
			System.out.println("/---|---|---\\");
		}
		
		return null;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String showSolution() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

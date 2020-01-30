package at.htlle.guessanumber;

import java.util.Random;

import at.htlle.games.Game;

public class GuessANumber implements Game
{
	private int myNumber;
	private final int MAX_NUMBER = 100;
	private boolean finished = false;
	private int nGuesses = 0;
	private double avgTries = 0;
	@Override
	public String start()
	{
		Random r = new java.util.Random();
		this.myNumber = r.nextInt(MAX_NUMBER);
		this.nGuesses = 0;
		this.avgTries = Math.log(this.MAX_NUMBER)/Math.log(2); 
		return this.getHelp();
	}

	@Override
	public String stop()
	{
		// Nothing to do here
		return  "Thank you for playing Guess-a-number.\n" +
				"Make a donation at paypal for me !";
	}

	@Override
	public String next(String inp) 
	{
		
		this.nGuesses ++;
		
		Integer guessed = -1;
		try
		{
			guessed = Integer.parseInt(inp);
		}
		catch(Exception e)
		{
			return e.getMessage(); 
		}
		
		if(myNumber == guessed)
		{
			this.finished = true;
			return "Correct ! " + "This quest took you " + this.nGuesses + " guesses.\n" +
				   "You " + (this.nGuesses < avgTries ? "just had luck" : "could have been better.") + ".";
		}
		
		if(myNumber < guessed)
		{
			return "The searched number is smaller";
		}
		else
		{
			return "The searched number is bigger";
		}
	}

	@Override
	public String showSolution()
	{
		return "The number was " + this.myNumber;
	}

	@Override
	public String getName()
	{
		return "Guess-A-Number";
	}

	public String getHelp()
	{
		return  "Welcome to Guess-a-number. \n" +
				"The rules are simple: You have to guess the\n" +
				"number that i am thinking of. I will give you hints\n" +
				"if the guessed number is higher or lower than the \n" +
				"entered one. The range is between 0 and " + this.MAX_NUMBER + "\n" +
				"With a bit of luck you are gonna make it below " + String.format("%.0f", avgTries) + " tries\n" +
				"Good Luck !\n";
	}

	@Override
	public boolean isFinished()
	{
		return this.finished;
	}
}

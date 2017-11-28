import java.util.Random;
import java.util.Scanner;

// Saurav Hossain ChatBot
public class ChatBotHossain 
{
	// says hi to break the ice
	public String hey() 
	{
		return "Robbie: What's up?"; // why ivan get a push error i no has brain cells anymore
	}
	
	// says stuff to keep it rolling
	public String theybetalkin(String x) 
	{
		String blah = x.toLowerCase();
		String wordz = "";
		
		if (x.equals("0"))
		{ 
			wordz += "Robbie: You got something to say?";
		}
		
		if (blah.length() == 0) 
		{
			wordz += "Robbie: You gonna say something?";
		}
		
		else if (blah.contains("lol"))
		{
			wordz += "Robbie: Say 'kek' instead you normie";
		}
		
		else if (blah.contains("hello") || blah.contains("hi") || blah.contains("hey") || blah.contains("greetings") || blah.contains("sup")) 
		{
			wordz += "Robbie: What's crakalakin homie? Wanna play a game?";
		}
		
		else if (blah.contains("yes") || blah.contains("sure") || blah.contains("ok"))
		{
		wordz += ("Aight. I've been looking forward to sharing my skills with someone.");
		ugh();
		}
		//switches to wang bot 2
		else if (x.equals("switch to 2"))
		{
			ChatBotWang chatbot1 = new ChatBotWang();
			System.out.println (chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String mmwhatchusay = in.nextLine();
			


			while (!mmwhatchusay.equals("bye"))
			{
				System.out.println (chatbot1.getResponse(mmwhatchusay));
				mmwhatchusay = in.nextLine();
			}
		}
		
		else if (x.equals("switch to 3"))
		{
			ChatBotZhu chatbot1 = new ChatBotZhu();
			System.out.println (chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String mmwhatchusay = in.nextLine();
			


			while (!mmwhatchusay.equals("bye"))
			{
				System.out.println (chatbot1.getResponse(mmwhatchusay));
				mmwhatchusay = in.nextLine();
			}
		}
		
		else if (x.equals("switch to 4"))
		{
			ChatBotSun chatbot1 = new ChatBotSun();
			System.out.println (chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String mmwhatchusay = in.nextLine();
			
		

			while (!mmwhatchusay.equals("bye"))
			{
				System.out.println (chatbot1.getResponse(mmwhatchusay));
				mmwhatchusay = in.nextLine();
			}
		}
		else if (x.contains("1"))
		{			
			
		}
		else 
		{
			wordz = randomcom();
		}
		if(x.equals("bye")) 
		{
			System.exit(0);
		}
		
		return wordz;
	}
	// runs the game with some commentary
	public static void ugh() 
	{
		System.out.println("So let's get to it.");
		System.out.println("I'm going to pick a number between 0 and 10.");
		System.out.println("Guess it and I'll let you in on something. Only guess numbers though, I don't wanna crash.");
		System.out.println("If you wanna stop, type in -1, but promise you will atleast try to beat me fair and square once");
		System.out.println("Go ahead put in a number");
		DidYouGetIt();
	}
		

	// number guessing game
	public static void DidYouGetIt()
	{
		Scanner usersguess = new Scanner(System.in);
		Random com = new Random();
		int rangeofnumberz = com.nextInt(10);
		int ug;
		boolean wowIneedthisorIwillcrash = false;
		
		
		while (wowIneedthisorIwillcrash == false) 
		{
			ug = usersguess.nextInt();
	
			if(ug == rangeofnumberz) 
			{
				wowIneedthisorIwillcrash = true;
				System.out.println("Ayy you got it." + rc());
				 
				DidYouGetIt();
				
			}
			else if(ug == -1) 
			{
			System.out.println("Alright, I'll stop playing around. What I was getting to with the numbers was...");
			System.out.println("...just look at our game," + (rangeofnumberz+2) +" people care about. You matter, don't do anything dumb.");
			System.out.println("Here, talk to my brother bot for help. \n");
			
			ChatBotWang chatbot1 = new ChatBotWang();
			System.out.println (chatbot1.getGreeting());
			Scanner in = new Scanner (System.in);
			String mmwhatchusay = in.nextLine();
			


			while (!mmwhatchusay.equals("bye"))
			{
				System.out.println (chatbot1.getResponse(mmwhatchusay));
				mmwhatchusay = in.nextLine();
			}
			
			}
			else System.out.println("Nah man, try again.");
		}
	}

	
	//  random responser
	private static String rc()
	{ 
		Random g = new Random();
		return challengephrases[g.nextInt(challengephrases.length)];
	}
	
	private static String [] challengephrases = { " Best Two out of Three.", " Bet you can't beat me again.", " Les go again bro."}; 

	private static String randomcom()
	{ 
		Random f = new Random();
		return awk[f.nextInt(awk.length)];
	}
	
	private static String [] awk = { "Oh my." , "Oh?" ,  "Ah." , " Flabbergastered", "Supercalifragalsiticexpialidocious, sorry I zoned out. Wanna play a game?"}; 




	// if i need an rgn for stuff idk i just wanted to learn to cast
	private static int rgn(int range) 
	{
		return (int) Math.random()*range; //yay I learned to cast
	}
}

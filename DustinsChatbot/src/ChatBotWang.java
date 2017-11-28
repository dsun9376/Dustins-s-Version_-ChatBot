import java.util.Random;
import java.util.Scanner;

//Dave Wang depression help bot
public class ChatBotWang
{
	int a = 0;
	Scanner s = new Scanner (System.in);
	int depressionMeter = 0;
	
	public String getGreeting()
	{
 		return "Hello this is the depression help bot service, do you currently suffer from depression?";
	}
	
	public String getResponse(String input)
	{
		input = input.toLowerCase();
		String response = "";
		// a goes up whenever you input something, a rudimentary way of counting the amount of yes and no inputed 
		// useful since the beginning of the conversation is guided and the user can basically only type in yes or no
		if (yesNoCounter(input) == true)
		{
			a ++;
		}
		if (findKeyword(input, "no") >=0 && (a == 1))
		// if you dont need help with depression then you talk with Darren's bot
		{
			System.out.println("Then you do no require my service, goodbye and have a nice day, Please consult with Darren for other issues \n");
			ChatBotZhu chatbot1 = new ChatBotZhu();
			
			System.out.println (chatbot1.getGreeting());
			String statement = s.nextLine();
			


			while (!statement.equals("Bye"))
			{
				System.out.println (chatbot1.getResponse(statement));
				statement = s.nextLine();
			}
		}
		
		else if (findKeyword(input, "yes") >=0 && (a == 1))
		{
			response =  "what can be the cause of this?";
		}
		
		// just in case people say thank you for what ever reason
		else if (input.indexOf("thank you") != -1)
		{
			response = "You are welcome";
		}
		
		/* the way to start the word search puzzle
			basically after depression meter hits -5 there will be a prompt to play the game
			or if something like i want to die is said it will prompt to play the puzzle
		*/
		else if ( (findKeyword(input, "yes") >=0 || findKeyword(input, "okay") >= 0 
				|| findKeyword(input, "sure") >= 0 || findKeyword(input, "i do") >=0) && (a  > 2))
		{
			depressionMeter += 10;
			response = wordsearchPuzzle();
		}
		
		else if ((findKeyword(input, "no") >=0 || findKeyword(input, "nah") >=0 ) && 
				response.equals("congratulatiosn you got them all right! now do you feel better?"))
		{
			depressionMeter--;
			response = "sorry I tought it would help";
		}
		
		// word search puzzle and its outputs
		// random outputs if you fail and congratulations when you pass
		// gives answers when you give up
		// if it didn't help depressionMeter goes down
		else if (findKeyword(input, "nevergiveup") >=0 || findKeyword(input, "cheerful") >=0 || 
				findKeyword(input, "optimistic") >=0  || findKeyword(input, "joyful") >=0 
				|| findKeyword(input, "brightside") >=0 || findKeyword(input, "smile") >=0) 
		{
			if ((input.indexOf("nevergiveup") !=-1 || input.indexOf("cheerful") !=-1 || 
					input.indexOf("joyful") !=-1  || input.indexOf("smile") !=-1
				|| input.indexOf("brightside") !=-1 || input.indexOf("optimistic") !=-1))
			{
				response = "congratulatiosn you got them all right! now do you feel better?";
			}
			else 
			{
				response = randomYouCanDoIt ();
			}
		}
		// if user inputs give up sends answers
		else if (input.indexOf("give up") !=-1)
		{
			response = "The answers were nevergiveup, brightside, smile, joyful, cheerful, optimistic,"
					+ System.lineSeparator() + "Don't worry about this failure doesn't mean anything";
		}
		
		else if (depressionMeter == -5)
		{
			response = "Let's change the subject, wanna play with a wordsearch puzzle";
		}
		
		// response to statements such as wanting to die :(
		else if (ifDie(input) == 2 ) 
		{
			response = "Please don't say that, do you want to do a cross word puzzle instead?";
		}
		
		else if (ifDie(input) == 1) 
		{
			depressionMeter += 10;
			response = "That is good to hear";
		}
		
		else if(input.equals("bye")) 
		{
			System.exit(0);
		}
		
		// way to toggle between bots
		else if (input.equals("switch to 1"))
		{
			ChatBotHossain chatbot1 = new ChatBotHossain();
			
			System.out.println (chatbot1.hey());
			String statement = s.nextLine();
			


			while (!statement.equals("Bye"))
			{
				System.out.println (chatbot1.theybetalkin(statement));
				statement = s.nextLine();
			}
		}
		
		else if (input.equals("switch to 3"))
		{
			ChatBotZhu chatbot1 = new ChatBotZhu();
			
			System.out.println (chatbot1.getGreeting());
			String statement = s.nextLine();
			


			while (!statement.equals("Bye"))
			{
				System.out.println (chatbot1.getResponse(statement));
				statement = s.nextLine();
			}
		}
		
		//blank return so the bot doesn't input a extra blank statement
		else if (findKeyword(input, "2",0) >= 0)
		{			
			
		}
		else if (depressionMeter <= -10)
		{
			System.out.println("This is level of sadness can not be resolved by simple means, I suggest you consult with my bot friend Darren");
			ChatBotZhu chatbot1 = new ChatBotZhu();
			
			System.out.println (chatbot1.getGreeting());
			String statement = s.nextLine();
			


			while (!statement.equals("Bye"))
			{
				System.out.println (chatbot1.getResponse(statement));
				statement = s.nextLine();
			}
		}
		
		//responses to happy/positive statements
		else if (pos(input)== true)
		{
			depressionMeter ++;
			response = getRandomResponse();
		}
		// responses to random statements
		else if (negPre(input) == true)
		{
			depressionMeter --;
			response = getRandomResponse();
		}
		
		else 
		{
			response = getRandomResponse();
		}
		
		
	return response; 
	
	}
	private boolean yesNoCounter(String input)
	{
		if (findKeyword(input, "no") >=0 || findKeyword(input, "yes") >=0)
		{
			return true;
		}
		return false;
	}
	private int ifDie (String input)
	{
		// checks for statements containing the feeling of wanting to die
		input = input.toLowerCase();
		if (findKeyword(input, "I")>=0) 
		{
			if ((findKeyword(input, "dont") >=0 || findKeyword(input, "don't") >=0) && findKeyword(input, "die") >= 0)
			{
				return 1;	
			}			
			if (input.indexOf("kill myself") != -1)	
			{
				return 2;
			}
			if ((findKeyword(input, "die") >= 0) && findKeyword(input, "want to") >=0)
			{
				return 2;
			}
			if ((findKeyword(input, "dont") >=0 || findKeyword(input, "don't") >=0) && findKeyword(input, "live") >= 0) 
			{
				return 2;
			}
			if (findKeyword(input,"suicide") >= 0) 
			{
				return 2;
			}
		}
		
	return 0;

	}
	
	private int findKeyword(String input, String goal, int startPos)
 	{
 		String phrase = input.trim().toLowerCase();
 		goal = goal.toLowerCase();

 		// The only change to incorporate the startPos is in
 		// the line below
 		int psn = phrase.indexOf(goal, startPos);

 		// Refinement--make sure the goal isn't part of a
 		// word
 		while (psn >= 0)
 		{
 			// Find the string of length 1 before and after
 			// the word
 			String before = " ", after = " ";
 			if (psn > 0)
 			{
 				before = phrase.substring(psn - 1, psn);
 			}
 			if (psn + goal.length() < phrase.length())
 			{
 				after = phrase.substring(
 						psn + goal.length(),
 						psn + goal.length() + 1);
 			}

 			// If before and after aren't letters, we've
 			// found the word
 			if (((before.compareTo("a") < 0) || (before
 					.compareTo("z") > 0)) // before is not a
 											// letter
 					&& ((after.compareTo("a") < 0) || (after
 							.compareTo("z") > 0)))
 			{
 				return psn;
 			}

 			// The last position didn't work, so let's find
 			// the next, if there is one.
 			psn = phrase.indexOf(goal, psn + 1);

 		}

 		return -1;
 	}
 	
 	/**
 	 * Search for one word in phrase.  The search is not case sensitive.
 	 * This method will check that the given goal is not a substring of a longer string
 	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
 	 * @param statement the string to search
 	 * @param goal the string to search for
 	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
 	 */
 	private int findKeyword(String input, String goal)
 	{
 		return findKeyword (input, goal, 0);
 	}
 	private boolean pos (String input)
 	// searches for positive words and or positive prefixes
 	{
 		if (input.indexOf("ben") != -1  || findKeyword(input, "love") >=0 || input.indexOf("bene") != -1 
 				|| findKeyword(input, "good") >=0 || findKeyword(input, "better") >=0)
 		{
 			return true;
 		}
 		return false;
 	}
 	
 	
 	
 	private boolean negPre (String input)
 	// looks for negative prefixes/words to lower depression meter
 	{
 		
 		if (input.indexOf("dis") != -1  || findKeyword(input, "hate") >=0 || input.indexOf("il") != -1 
 				|| input.indexOf("no") != -1)
 		{
 			return true;
 		}
 		return false;
 	}
 	
 	private String getRandomResponse ()
 // random response based on the depressionMeter
 	{
		Random r = new Random ();
		if (depressionMeter >= 0)
		{	
			return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
		}
		else if (depressionMeter < 0 && depressionMeter > -10)
		{
			return randomCheerYouUpResponses [r.nextInt(randomCheerYouUpResponses.length)];
		}
		else if (depressionMeter < 20)
		{	
			return randomYouNeedHelpResponses [r.nextInt(randomYouNeedHelpResponses.length)];
		}	
		return randomCheerYouUpResponses [r.nextInt(randomCheerYouUpResponses.length)];
	}
	
	private String [] randomHappyResponses = {"glad you are feeling better",
			"I am happier than ever before",
			"Wow!",
			"I like you",
			"You dont seem so sad",
			"That is good to hear",
	};
	private String [] randomYouNeedHelpResponses = {"This is serious please get help from an professional",
			"I am not programmed to deal with this level of depression"};
	private String [] randomCheerYouUpResponses = {"The future will always be better", "Don't worry everything will be fine", 
			"there is always someone out there that cares", "think about what you can accomplish in the future", 
			"think about all the fun memories you had"};
	
	private String wordsearchPuzzle ()
	// word search puzzle (includes some phrases)
	// words includes cheerful, joyful, nevergiveup, brightside, optimistic, smile 
	{
		return ("Let's go champ"
				+ System.lineSeparator() +
				"Please seperate the words with a space and phrases dont need spaces between words (hint there are 6 words/phrases)"
				+ System.lineSeparator() + "F A S Q C C Z D C B F C X U F"
				+ System.lineSeparator() + "I C W E D I S T H G I R B A B"
				+ System.lineSeparator() + "E J Q T F T X D E K I F C L I"
				+ System.lineSeparator() + "E M X R M S A T	E K W J T U U"
				+ System.lineSeparator() + "P L O U B I V D R C J C X I P"
				+ System.lineSeparator() + "W I I C T M Z D F F K J O X I"
				+ System.lineSeparator() + "E N R M Z I Z U U M K D Q G G"
				+ System.lineSeparator() + "G V P J S T V R L M I A V S E"
				+ System.lineSeparator() + "J L N Q Q P K F U I I N U B D"
				+ System.lineSeparator() + "O H T S N O K T J Z U K Q P I"
				+ System.lineSeparator() + "Y F A W J M S V	O H F Q E K C"
				+ System.lineSeparator() + "F R G D J H O J N H X J G K D"
				+ System.lineSeparator() + "U Q G G Q N R T C Q S W T C J"
				+ System.lineSeparator() + "L P B J J P C Q E R L G N U U"
				+ System.lineSeparator() + "Y N C K N E V E R G I V	E U P");
	}
	
	private String randomYouCanDoIt ()
	//random keep trying responses for the word search puzzle
	{
		Random g = new Random();
		return randomrandomYouCanDoIt [g.nextInt(randomrandomYouCanDoIt.length)];
	}
	private String [] randomrandomYouCanDoIt = 
	{ 
			"Oh not quite, but keep trying", "Come on don't give up", "Almost done", "You can do it!"
	};

}

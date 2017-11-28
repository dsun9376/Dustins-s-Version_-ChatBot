import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Darren Zhu
 * @version November 2017
 */

public class ChatBotZhu
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
		
		/**
		 * Get a default greeting 	
		 * @return a greeting
		 */	

		public String getGreeting()
		{
			return "My name is Darren. How can I be of service to you?";
		}
		
		/**
		 * Gives a response to a user statement
		 * 
		 * @param statement
		 *            the user statement
		 * @return a response based on the rules given
		 */
		int emotion = 0;
		public String getResponse(String statement)
		{
			String response = "";
			
			if (statement.length() == 0)
			{
				response = "If you need time to find the courage to speak, please do take it.";
			}

			else if (findKeyword(statement, "die") >= 0)
			{
				response = "Think about how this will impact the people in your life";
	            emotion--;
			}
			
			else if (findKeyword(statement, "suicide") >= 0)
			{
				response = "Suicide is not the answer.";
				emotion--;
			}
			else if (findKeyword(statement, "you dont understand") >= 0)
			{
				response = "Please explain further.";
				emotion--;
			}
			else if (findKeyword(statement, "hate") >= 0)
			{
				response = "Hate is not the answer. Love is and will always be.";
				emotion--;
			}
			else if (findKeyword(statement, "help") >= 0)
			{
				response = "Please tell me what you need help with.";
				emotion--;
			}
			else if (findKeyword(statement, "depression") >= 0)
			{
				response = "Have you tried speaking to a therapist?";
				emotion--;
			}
			else if (findKeyword(statement, "depressed") >= 0)
			{
				response = "Have you tried speaking to a therapist?";
				emotion--;
			}
			else if (findKeyword(statement, "kill") >= 0)
			{
				response = "Please refrain from doing something you might regret.";
				emotion--;
			}
			else if (findKeyword(statement, "happy") >= 0)
			{
				response = "Happiness will lead to a fulfilling life!";
				emotion++;
			}
			else if (findKeyword(statement, "thank") >= 0)
			{
				response = "It's my pleasure to help!";
				emotion++;
			}

			// Response transforming I want to statement
			else if (findKeyword(statement, "I want to", 0) >= 0)
			{
				response = transformIWantToStatement(statement);
			}
			else if (findKeyword(statement, "I need", 0) >= 0)
			{
				response = transformINeedToStatement(statement);
			}
			else if (findKeyword(statement, "I want",0) >= 0)
			{
				response = transformIWantStatement(statement);
			}
			else if (findKeyword(statement, "switch me",0) >= 0)
			{
				transfer();
			}
			else if (findKeyword(statement, "3",0) >= 0)
			{			
				
			}
			else
			{
				response = getRandomResponse();
			}
			if(statement.equals("bye")) 
			{
				System.exit(0);
			}
			
			 if (statement.equals("switch to 4"))
			{
				ChatBotSun chatbot1 = new ChatBotSun();
				System.out.println (chatbot1.getGreeting());
				Scanner in = new Scanner (System.in);
				String mmwhatchusay = in.nextLine();
				


				while (!mmwhatchusay.equals("Bye"))
				{
					System.out.println (chatbot1.getResponse(mmwhatchusay));
					mmwhatchusay = in.nextLine();
				}
			}
			 if (statement.equals("switch to 1"))
				{
					ChatBotHossain chatbot1 = new ChatBotHossain();
					System.out.println (chatbot1.hey());
					Scanner in = new Scanner (System.in);
					String mmwhatchusay = in.nextLine();
					


					while (!mmwhatchusay.equals("Bye"))
					{
						System.out.println (chatbot1.theybetalkin(mmwhatchusay));
						mmwhatchusay = in.nextLine();
					}
				}
			 else if (statement.equals("switch to 2"))
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
			
			return response;
		}
		
		/**
		 * Take a statement with "I want to <something>." and transform it into 
		 * "How would your friends and family feel if you <something>?"
		 * @param statement the user statement, assumed to contain "I want to"
		 * @return the transformed statement
		 */
		private String transformIWantToStatement(String statement)
		{
			//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			int psn = findKeyword (statement, "I want to", 0);
			String restOfStatement = statement.substring(psn + 9).trim();
			return "How would your friends and family feel if you " + restOfStatement + "?";
		}
		/**
		 * Take a statement with "I need <something>." and transform it into 
		 * "Please explain why you need <something>."
		 * @param statement the user statement, assumed to contain "I want"
		 * @return the transformed statement
		 */
		private String transformINeedToStatement(String statement)
		{
			//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			int psn = findKeyword (statement, "I need", 0);
			String restOfStatement = statement.substring(psn + 6).trim();
			return "Please explain why you need " + restOfStatement + ".";
		}

		
		/**
		 * Take a statement with "I want <something>." and transform it into 
		 * "If you <something>, what good would it do?"
		 * @param statement the user statement, assumed to contain "I want"
		 * @return the transformed statement
		 */
		private String transformIWantStatement(String statement)
		{
			//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			int psn = findKeyword (statement, "I want", 0);
			String restOfStatement = statement.substring(psn + 6).trim();
			return "If you " + restOfStatement + ", what good would it do?";
		}
		
		
		/**
		 * Take a statement with "I <something> you" and transform it into 
		 * "Why do you <something> me?"
		 * @param statement the user statement, assumed to contain "I" followed by "you"
		 * @return the transformed statement
		 */
		private String transformIYouStatement(String statement)
		{
			//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			
			int psnOfI = findKeyword (statement, "I", 0);
			int psnOfYou = findKeyword (statement, "you", psnOfI);
			
			String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
			return "Why do you " + restOfStatement + " me?";
		}
		

		
		
		/**
		 * Search for one word in phrase. The search is not case
		 * sensitive. This method will check that the given goal
		 * is not a substring of a longer string (so, for
		 * example, "I know" does not contain "no").
		 *
		 * @param statement
		 *            the string to search
		 * @param goal
		 *            the string to search for
		 * @param startPos
		 *            the character of the string to begin the
		 *            search at
		 * @return the index of the first occurrence of goal in
		 *         statement or -1 if it's not found
		 */
		private int findKeyword(String statement, String goal,
				int startPos)
		{
			String phrase = statement.trim().toLowerCase();
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
		private int findKeyword(String statement, String goal)
		{
			return findKeyword (statement, goal, 0);
		}
		


		/**
		 * Pick a default response to use if nothing else fits.
		 * @return a non-committal string
		 */
		private String getRandomResponse ()
		{
			Random r = new Random ();
			if (emotion == 0)
			{	
				return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
			}
			/**
			 * As the emotion decrease, the user is getting more frustrated so an offer in made to transfer to a different chatbot.
			 */
			if (emotion < -2)
			{	
				return "You seem frustrated. Would you like to switch to a different representative? If you do please respond with 'switch me' ";
			}	
			return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
		}
		/**
		 * transfer() returns the user to the main method where they will see the representative selection page again.
		 */
		private static void transfer()
		{
			personalrunnervhashout.main(null);
		}
		
		private String [] randomNeutralResponses = {"Please tell me more about your situation",
				"Do you want to talk more about it?",
				"Yes, please elaborate.",
				"Tell me all the good in your life.",
				"Sharing can be a form of healing.",
				"Life will always have its ups and downs.",
				"The key to fulfillment is finding something you enjoy. "
		};
		private String [] randomHappyResponses = {"Surround yourself with people who can love you!", "There is always people you can find with shared interest.", "Everyone has a place in the world."};
		
}	 
 

	import java.util.Random;

	/**
	 * A program to carry on conversations with a human user.
	 * This version:
	 * @author Mr. Levin
	 * @version September 2017
	 */ 
	public class ChatBotSun
	{
		//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
				int emotion = 0;
				/**
				 * Get a default greeting 	
				 * @return a greeting
				 */	
				public String getGreeting()
				{
					return "How are you feeling today?";
				}
				
				/**
				 * Gives a response to a user statement
				 * 
				 * @param statement
				 *            the user statement
				 * @return a response based on the rules given
				 */
				public String getResponse(String statement)
				{
					String response = "";
					
					if (statement.length() == 0)
					{
						response = "Why don't you start the conversation?";
					}
					
					if (findKeyword(statement,"sad") >=0) 
					{
						response = "Don't be that way, that is unhealthy to your body";
					   emotion --;
					}
					
					if (findKeyword(statement, "depressed") >= 0)
					{
						response = "Don't be that way, that is unhealthy to your body";
						   emotion --;
				    }
							
					if (findKeyword(statement, "don't feel well")>=0)
					{
						response = "Don't be that way, that is unhealthy to your body";
						   emotion --;
				    }
					
					else if (findKeyword(statement, "stressed") >= 0)  
					{
						response = "Why do you feel this way? Anything happened?";
			                	emotion--;
					}
					
					if  (findKeyword(statement, "chest pain") >=0 )
                    {
                    	response = "Why do you feel this way? Anything happened?";
	                	emotion--;
                    }

					if (findKeyword(statement, "crushed")>=0)
					{ 
						response = "Why do you feel this way? Anything happened?";
	                	emotion--;
					}
					
					else if ((findKeyword(statement, "abuse") >= 0) && (findKeyword(statement, "live") >=0))
					{
						response = "Don't get too excited!! Give me your address and I'll send help right away !";
						emotion++;
					}
					
					if (findKeyword(statement, "suicidal") >=0 )
					{
						response = "Don't get too excited!! Give me your address and I'll send help right away !";
						emotion++;
					}

					if (findKeyword(statement, "live") >=0)
					{
						response = "Don't get too excited!! Give me your address and I'll send help right away !";
						emotion++;
					}
					// Response transforming I want to statement
					else if (findKeyword(statement, "feel", 0) >= 0)
					{
						response = expressingEmotions(statement);
					}
					else if (findKeyword(statement, "defeated") >= 0)
					{
						response = lifeStruggle(statement);
						
					if (findKeyword(statement, "hard") >=0)
					{
						response = lifeStruggle(statement);
					}
					}
					else if (findKeyword(statement, "meaningless") >=0) 
					{
						response =lifeEmergency(statement);
					}
					
					if (findKeyword(statement, "die") >=0)
					{
						response =lifeEmergency(statement);
					}
					
					if (findKeyword(statement, "hopeless")>=0)
					{
						response =lifeEmergency(statement);
					}
					else 
					{
						if (findKeyword(statement, "better")>=0)
						{
							response = getRandomResponse();
						}
						
						if (findKeyword(statement, "I'm good now")>=0)
						response = getRandomResponse();
					}
					
					/*else
					{
					 	response = " That I'm not sure what advice to give you  either XD... You want to talk about something that I know of?"
					}*/
					
					return response;
				}
				
				// Down below are codes related to different types of responses
				// If lifeEmergency is activated, different methods of rescue will be listed on the bottom.
				private String expressingEmotions(String statement)
				{
					//  Remove the final period, if there is one
					statement = statement.trim();
					String lastChar = statement.substring(statement
							.length() - 1);
					if (lastChar.equals("."))    
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals("!"))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals ("?"))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals("..."))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals(":(" ))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
				
				
					int psn = findKeyword (statement, "I feel", 0);
					String restOfStatement = statement.substring(psn + 6).trim();
					return "Why do you feel " + restOfStatement + "?" + "Try anything in advices1() and see if you feel better";
				
				}
				
				
					

				
				/**
				 * Take a statement with "I want <something>." and transform it into 
				 * "Would you really be happy if you had <something>?"
				 * @param statement the user statement, assumed to contain "I want"
				 * @return the transformed statement
				 */
				private String lifeStruggle(String statement)
				{
					//  Remove the final period, if there is one
					statement = statement.trim();
					String lastChar = statement.substring(statement
							.length() - 1);
					if (lastChar.equals("."))    
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals("!"))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals ("?"))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals("..."))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals(":(" ))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					int psn = findKeyword (statement, "I am", 0) ;
					String restOfStatement = statement.substring(psn + 4).trim();
					return restOfStatement + "?" + " Try something in advices2() to see if you feel better)";
					}
					
				
	
				
				/**
				 * Take a statement with "I <something> you" and transform it into 
				 * "Why do you <something> me?"
				 * @param statement the user statement, assumed to contain "I" followed by "you"
				 * @return the transformed statement
				 */
				private String lifeEmergency(String statement)
				{
					//  Remove the final period, if there is one
					statement = statement.trim();
					String lastChar = statement.substring(statement
							.length() - 1);
					if (lastChar.equals("."))    
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals("!"))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals ("?"))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals("..."))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					
					if (lastChar.equals(":(" ))
					{
						statement = statement.substring(0, statement.length() - 1);
					}
					int psnOfI = findKeyword (statement, "die", 0);
					int psnOfYou = findKeyword (statement, "hopeless", psnOfI);
					
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
				private String getRandomResponse()
				{
					Random r = new Random ();
					if (emotion == 0)
					{	
						return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
					}
					if (emotion < 0)
					{	
						return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
					}	
					return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
				}
				
				private String advices1() 
				{
					Random r = new Random();
					return randomExpressingemotions [r.nextInt(randomExpressingemotions.length)];
				}
				
				private String advices2()
				{
					Random r= new Random();
					return randomLifestruggle[r.nextInt(randomLifestruggle.length)] ;
				}
				
				private String lifeSavor()
				{
					Random r= new Random();
					return randomLifesavor [r.nextInt(randomLifesavor.length)];
				}
				private String [] randomNeutralResponses = {"Interesting, tell me more",
						"Hmmm.",
						"Do you really think so?",
						"You don't say.",
						"It's all boolean to me.",
						"So, would you like to go for a walk?",
						"Could you say that again?"
				};
				private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
				private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};
				
				private String [] randomExpressingemotions =
				{
					"Set easy goals for yourself so you can always accomplish them",
					"Get enough sleep so your body recovers better",
					"Eat healthily, set up a routine for eating",
					"Exercise more, it's the best way to release stress"
				};
				private String [] randomLifestruggle =
				{ 
					"You may need an therapist to help you feel better",
					"Use 7 cups, it's a website where many listeners are there to chat ",
					"Try to find a close friend and pour every out. If you can't find anyone... your parents should do it",
					"Always do more work, people only tend to worry when they are not doing anything. If you load yourself with work, you will have no time to think about pathetic things",
					"Forget about the struggles in life, learn to enjoy everything and act optimistic at all times"
			   	};
				private String [] randomLifesavor =
				{ 
					"AMBULACE IS ON THE WAY! WE'LL BE THERE IN ONE SEC",
					"THE POLICE ARE ON THEIR WAY NOW",
					"DON'T GIVE UP ON LIFE THAT EASY",
				};
	
				 
}
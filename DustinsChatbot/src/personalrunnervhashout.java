import java.util.Scanner;

public class personalrunnervhashout 
{
	//hi
	/*Features:
	 * User can input anything within the guidelines for an enjoyable experience.
	 * User can switch between bots in any random order using the command "switch to x"
	   where x is the number of the bot in the directory.
	 *All bots are meant to help users who are suicidal and depressed. (Type in negative phrases to see how effective they are)  
	 *Bot 1 is a play bot that helps the user through playing a game.
	 *Bot 2 is a cheerful bot that consoles and brings light to life in a interesting way.
	 *Bot 3 is a honest bot that only wants the best for the user.
	 *Bot 4 is a relatable bot.
	 *
	 *Important Notes: 
	 *Heed what the bots say in the instructions for a fully functional experience.
	 */

	public static void main(String [] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.println("Welcome To Happy Sad Care Center~");
		System.out.println("Please select a representative you would like to talk to.");
		System.out.println("1.Hossain ");
		System.out.println("2.Wang ");
		System.out.println("3.Zhu ");
		System.out.println("4.Sun");
		System.out.println("To switch between bots type in 'switch to x', where x is the corresponding number of the bot.");
	
		String x = in.nextLine();
		if (x.equals("1"))
		{
			{
	 			ChatBotHossain chatbot1 = new ChatBotHossain();
	 		
	 			System.out.println (chatbot1.hey());
	 
	 			while (!x.equals("Bye"))
	 			{	
	 				System.out.println (chatbot1.theybetalkin(x));
	 				x = in.nextLine();
	 			}
	 			
	 		}
		}
		
		if (x.equals("2"))
		{
			{
	 			ChatBotWang chatbot2 = new ChatBotWang();
	 		
	 			System.out.println (chatbot2.getGreeting());	 		
	 
	 
	 			while (!x.equals("Bye"))
	 			{
	 				System.out.println (chatbot2.getResponse(x));
	 				x = in.nextLine();
	 			}
	 		}
		}
		if (x.equals("3"))
		{
			{
	 			ChatBotZhu chatbot3 = new ChatBotZhu();
	 		
	 			System.out.println (chatbot3.getGreeting());	 		
	 
	 
	 			while (!x.equals("Bye"))
	 			{
	 				System.out.println (chatbot3.getResponse(x));
	 				x = in.nextLine();
	 			}
	 		}
		}
		
		if (x.equals("4"))
		{
			{
	 			ChatBotSun chatbot4 = new ChatBotSun();
	 		
	 			System.out.println (chatbot4.getGreeting());	 		
	 
	 
	 			while (!x.equals("Bye"))
	 			{
	 				x = in.nextLine();
	 				System.out.println (chatbot4.getResponse(x));
	 			}
	 		}
		}
		if(x.equals("bye")) 
		{
			System.exit(0);
		}
		if (!x.equals("1") && !x.equals("2") && !x.equals("3") && !x.equals("4"))
		{
			System.out.println("Please using # to select an operator.");
			main(null);
		}
	}
}

}

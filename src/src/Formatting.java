package src;

//package src;

import java.util.*;

public class Formatting
{
	Scanner scanner;
	
	public Formatting()
	{
		scanner = new Scanner(System.in);
	}
	
	public String getTextInput(String output)
	{
		String input = null;
		
		try
		{
			System.out.println( "\n\n" + output );
			
			input = scanner.next();
		}catch(Exception e)
		{
			System.out.println("\n\n\"" + input + "\" is not a valid option.");
			return getTextInput(output);
		}
		
		return input.trim();
	}
	
	public int getOptionInput(String output, String [] options)
	{
		
		try
		{
			System.out.println( "\n\n" + output );
			
			for(int i = 0; i < options.length; i++)
			{
				System.out.println( "\t" + (char)(i + 97) + ") " + options[i] );
			}
			
			System.out.print( "Your choice: ");
			
			switch( scanner.next().charAt(0) )
			{
				case 'a':
				case 'A':
					if( 0 < options.length )
						return 1;
					else
					{
						System.out.println("\n\nThat was not a valid selection!");
						getOptionInput(output, options);
					}
					break;
				case 'b':
				case 'B':
					if( 1 < options.length )
						return 2;
					else
					{
						System.out.println("\n\nThat was not a valid selection!");
						getOptionInput(output, options);
					}
					break;
				case 'c':
				case 'C':
					if( 2 < options.length )
						return 3;
					else
					{
						System.out.println("\n\nThat was not a valid selection!");
						getOptionInput(output, options);
					}
					break;
				case 'd':
				case 'D':
					if( 3 < options.length )
						return 4;
					else
					{
						System.out.println("\n\nThat was not a valid selection!");
						getOptionInput(output, options);
					}
					break;
				default:
					System.out.println("\n\nThat was not a valid selection!");
					getOptionInput(output, options);
			}
			
		}catch(Exception e)
		{
			System.out.println("Error, repeating last option");
			getOptionInput(output, options);
		}
		
		return -1;
	}
}

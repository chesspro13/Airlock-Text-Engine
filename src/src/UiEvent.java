package src;

//package src;

import java.util.*;

public class UiEvent
{
	Scanner input;
	
	public UiEvent()
	{
		input = new Scanner(System.in);
	}

	public void printWithPause( Scanner script )
	{
		System.out.println( "\n" + script.nextLine().trim());
		///input.next();
	}

	public void printWithPause( String script )
	{
		System.out.println( "\n" + script.trim() );
		//input.next();
	}
}

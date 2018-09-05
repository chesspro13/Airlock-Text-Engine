package src;

//package src;

import java.util.*;
public class Interpreter
{
	GameEvent gameEvent;
	
	public Interpreter()
	{
		gameEvent = new GameEvent();
	}
	
	public void process(Scanner script)
	{
		switch( script.next() )
		{
			case "UiEvent":
				System.out.println( script.nextLine() );
				break;
		}
	}
}

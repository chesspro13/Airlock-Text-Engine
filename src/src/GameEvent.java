package src;

//package src;

import java.util.*;

public class GameEvent
{
	public void print(String event)
	{
		System.out.println("\n" + event);
	}
	
	public StoryLine changeGameState( Scanner script )
	{
		switch( script.next() )
		{
			case "Store1":
				System.out.println("changing to store");
				return StoryLine.store1;
			default:
				return StoryLine.intro;
		}
	}
	
	public void givePlayer( Scanner script, Player player, UiEvent uiEvent)
	{
		switch( script.next().trim() )
		{
			case "Money":
				player.giveMoney( script.nextInt(), uiEvent );
				break;
			default:
				System.out.println("error: command not found");
				break;
		}
	}
}

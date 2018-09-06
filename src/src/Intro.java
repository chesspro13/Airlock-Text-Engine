package src;

//package src;

import java.util.*;
public class Intro
{
	private GameEvent gameEvent;
	private UiEvent uiEvent;
	private InteractionEvent interactionEvent;
	
	PlayerOld player;
	
	Formatting input;
	
	private boolean hasSave;
	
	private boolean forceDebugSave;
	
	LinkedList userData;

	public Intro( GameEvent gameEvent, UiEvent uiEvent, InteractionEvent interactionEvent)
	{
		this.gameEvent = gameEvent;
		this.uiEvent = uiEvent;
		this.interactionEvent = interactionEvent;
		
		input = new Formatting();
		//loadSave( true );
	}

	public PlayerOld loadSave( boolean forceDebigSave )
	{
		this.forceDebugSave = forceDebigSave;
		
		if( forceDebugSave )
		{
			return new PlayerOld("Mauldin", true, PlayerRole.Theif, gameEvent, uiEvent, interactionEvent);
		}
		
		//Search file system got a save file
		hasSave = false;

		
		
		if( !hasSave )
		{
			return getPlayerInfo();
		}else
		{
			//Ask to load saved game
			return new PlayerOld("Mauldin", true, PlayerRole.Theif, gameEvent, uiEvent, interactionEvent);
		}
	}

	private PlayerOld getPlayerInfo()
	{
		userData = new LinkedList();
		int tempOption;
		String tempInput;
		
		tempOption = input.getOptionInput("Are you a boy or girl?", new String[]{"Boy", "Girl"});
		if( tempOption == 1 )
			userData.add(true);
		else
			userData.add(false);
			
		tempInput = input.getTextInput("What is your name?");
			userData.add(tempInput);
			
		tempOption = input.getOptionInput("What is your class?", new String[]{"Fighter","Magician", "Theif", "Healer"});
		switch( tempOption )
		{
			case 1:
				userData.add(PlayerRole.Fighter);
				break;
			case 2:
				userData.add(PlayerRole.Magician);
				break;
			case 3:
				userData.add(PlayerRole.Theif);
				break;
			case 4:
				userData.add(PlayerRole.Healer);
				break;
		}
		
		tempInput = "Is this information correct?\n\tGender: " + userData.get(0);
		tempInput += "\n\tName: " + userData.get(1) + "\n\tClass: " + ((PlayerRole)userData.get(2)).getRoleName();
		
		tempOption = input.getOptionInput( tempInput, new String[]{"Yes","No"});
		if( tempOption == 1 )
		{
			System.out.println( tempOption );
			//Save players data
			generatePlayerSaveFile();
			return new PlayerOld( (String)userData.get(1), (boolean)userData.get(0), (PlayerRole) userData.get(2), gameEvent, uiEvent, interactionEvent);
		}else if(tempOption == 2)
		{
			System.out.println(" talking else rout");
			return getPlayerInfo();
		}else
			return new PlayerOld("New Player", true, PlayerRole.Theif, gameEvent, uiEvent, interactionEvent);
	}
	
	private void generatePlayerSaveFile()
	{
		int [] stats;
//		0 = health
//		1 = physical attack
//		2 = physical defence
//		3 = magic attack
//		4 = magic defence
//		5 = energy
//		6 = agility
//		7 = evasion
		
	}
}

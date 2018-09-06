package src;
import Player.*;
import CharacterClasses.*;

public class Main
{
	public static void main( String [] args)
	{
		//Game game = new Game(true, true);
            CharacterCreation characterCreation = new CharacterCreation();
            characterCreation.createCharacter();
	}
}

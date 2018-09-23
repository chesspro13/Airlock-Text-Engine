package src;

//package src;
import CharacterClasses.Classes;
import IO.IO;
import Player.CharacterCreation;
import Player.Player;
import Player.PlayerIdentifier;
import java.util.*;

public class Intro {

    private GameEvent gameEvent;
    private UiEvent uiEvent;
    private IO interactionEvent;

    Player player;

    Formatting input;

    private boolean hasSave;

    private boolean forceDebugSave;

    LinkedList userData;

    public Intro(GameEvent gameEvent, UiEvent uiEvent, IO interactionEvent) {
        this.gameEvent = gameEvent;
        this.uiEvent = uiEvent;
        this.interactionEvent = interactionEvent;

        input = new Formatting();
        //loadSave( true );
    }

    public Player loadSave(boolean forceDebigSave) {
        this.forceDebugSave = forceDebigSave;

        if (forceDebugSave) {
            return new CharacterCreation().createCharacter("Mauldin", true, Classes.Fighter, PlayerIdentifier.Main, gameEvent, uiEvent, interactionEvent);
        }

        //Search file system got a save file
        hasSave = false;

        if (!hasSave) {
            return getPlayerInfo();
        } else {
            //TODO: Ask to load saved game
            return new CharacterCreation().createCharacter("Mauldin", true, Classes.Fighter, PlayerIdentifier.Main, gameEvent, uiEvent, interactionEvent);
        }
    }

    private Player getPlayerInfo() {
        userData = new LinkedList();
        int tempOption;
        String tempInput;

        tempOption = input.getOptionInput("Are you a boy or girl?", new String[]{"Boy", "Girl"});
        if (tempOption == 1) {
            userData.add(true);
        } else {
            userData.add(false);
        }

        tempInput = input.getTextInput("What is your name?");
        userData.add(tempInput);

        tempOption = input.getOptionInput("What is your class?", new String[]{"Fighter", "Healer"});
        switch (tempOption) {
            case 1:
                userData.add(Classes.Fighter);
                break;
            case 2:
                userData.add(Classes.Healer);
                break;
        }

        tempInput = "Is this information correct?\n\tGender: " + userData.get(0);
        tempInput += "\n\tName: " + userData.get(1) + "\n\tClass: " + ((PlayerRole) userData.get(2)).getRoleName();

        tempOption = input.getOptionInput(tempInput, new String[]{"Yes", "No"});
        //Information is correct
        if (tempOption == 1) {
            System.out.println(tempOption);
            //Save players data
            generatePlayerSaveFile();
            return new CharacterCreation().createCharacter((String) userData.get(1), (boolean) userData.get(0), (Classes) userData.get(2), PlayerIdentifier.Main, gameEvent, uiEvent, interactionEvent);
            //Information is incorrect
        } else if (tempOption == 2) {
            System.out.println(" talking else rout");
            return getPlayerInfo();
        } else {
            return new CharacterCreation().createCharacter("Mauldin", true, Classes.Fighter, PlayerIdentifier.Main, gameEvent, uiEvent, interactionEvent);
        }
    }

    private void generatePlayerSaveFile() {
        int[] stats;
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

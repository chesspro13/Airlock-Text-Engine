package src;

//package src;
import IO.IO;
import Player.Player;
import java.io.*;
import java.util.*;

public class Game {
    
    Interpreter scriptInterpreter;
    Scanner[] scanner;
    Intro intro;
    LinkedList<Player> player;
    StoryLine currentState;
    UiEvent uiEvent;
    GameEvent gameEvent;
    IO interactionEvent;
    Store store;
    GlobalInventory globalInventory;
    
    boolean usingComputer;
    boolean forceDebug;
    //beans

    public Game(boolean usingWindows, boolean forceDebug) {
        try {
            uiEvent = new UiEvent();
            gameEvent = new GameEvent();
            interactionEvent = new IO();
            scriptInterpreter = new Interpreter();
            globalInventory = new GlobalInventory(gameEvent, uiEvent, interactionEvent);
            intro = new Intro(gameEvent, uiEvent, interactionEvent);
            player = new LinkedList<>();
            player.add(intro.loadSave(true));
            player.get(0).setGlobalInventory(globalInventory);
            scanner = new Scanner[1];
            store = new Store(player.get(0), gameEvent, uiEvent, interactionEvent);
            
            currentState = StoryLine.intro;

            //Force character populate
            if (forceDebug) {
                for (int i = 0; i < 3; i++) {
                    player.add(intro.loadSave(forceDebug));
                }
            }
            player.get(0).getGlobalInventory().setCharacters(player);
            
            this.usingComputer = usingWindows;
            this.forceDebug = forceDebug;
            
            while (true) {
                update();
            }
        } catch (Exception e) {
            System.err.println("Error at main game engine method");
            e.printStackTrace();
        }
    }
    
    private void update() {
        switch (currentState) {
            case intro:
                try {
                    if (scanner[0] == null) {
                        if (usingComputer == true) {
                            scanner[0] = new Scanner(new File(StoryLine.intro.getFileLocationComputer()));
                        } else {
                            scanner[0] = new Scanner(new File(StoryLine.intro.getFileLocationPhone()));
                        }
                    }
                    followScript(scanner[0]);
                } catch (FileNotFoundException e) {
                    System.out.println("Unable to open intro.txt\n" + e);
                }
                break;
            case store1:
                store.startStore(forceDebug);
//				try{
//					if (scanner[1] == null)
//						scanner[1] = new Scanner(new File(StoryLine.intro.getFileLocation() ));
//					followScript( scanner[1] );
//				}catch (FileNotFoundException e)
//				{	System.out.println("Unable to open intro.txt\n" + e);	}
                break;
        }
    }
    
    private void followScript(Scanner script) {
        if (script.hasNext()) {
            switch (script.next().trim()) {
                case "EndScript":
                    script.close();
                    break;
                case "UiEvent":
                    switch (script.next().trim()) {
                        case "PrintWithPause":
                            uiEvent.printWithPause(script);
                            break;
                    }
                    break;
                case "GameEvent":
                    switch (script.next()) {
                        case "ChangeStates":
                            this.currentState = gameEvent.changeGameState(script);
                            break;
                        case "GivePlayer":
                            gameEvent.givePlayer(script, player.get(0), uiEvent);
                            break;
                    }
                    break;
                default:
                    System.out.println("error: command not found");
            }
        }
    }
}

package Player;

import CharacterClasses.BaseFighterClass;
import CharacterClasses.BaseHealerClass;
import CharacterClasses.CharacterClass;
import CharacterClasses.Classes;
import IO.IO;
import java.util.LinkedList;
import src.GameEvent;
import src.UiEvent;

public class CharacterCreation {

    private Player tempPlayer;

    public Player createCharacter(String name, boolean gender, Classes playerClass, PlayerIdentifier playerIdentifier,
             GameEvent gameEvent, UiEvent uiEvent, IO interactionEvent) {
        tempPlayer = new Player();
        setName(name);
        setGender(gender);
        createCharacterInventory(playerIdentifier);

        tempPlayer.setCharacterType(playerIdentifier);

        return tempPlayer;
    }

    public Player createCharacter(PlayerIdentifier playerIdentifier) {
        tempPlayer = new Player();
        setName("Mauldin");
        setGender(true);
        createCharacterInventory(playerIdentifier);
        setCharacterClass(Classes.Fighter);

        return tempPlayer;
    }

    //Debug method
    public LinkedList<Player> getBatchPlayers() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(createCharacter(PlayerIdentifier.Main));
        players.add(createCharacter(PlayerIdentifier.second));
        players.add(createCharacter(PlayerIdentifier.third));
        players.add(createCharacter(PlayerIdentifier.fourth));
        return players;
    }

    private void setName(String name) {
        tempPlayer.setName(name);
    }

    private void setCharacterClass(Classes playerClass) {
        CharacterClass characterClass = getCharacterClass(playerClass);
        tempPlayer.setCharacterClass(characterClass);
    }

    private void setGender(boolean isMale) {
        tempPlayer.setGender(isMale);
    }

    private void createCharacterInventory(PlayerIdentifier playerIdentifier) {
        tempPlayer.setInventory(new CharacterInventory(playerIdentifier));
    }

    private CharacterClass getCharacterClass(Classes playerClass) {
        CharacterClass characterClass = new CharacterClass();

        switch (playerClass) {
            case Fighter:
                BaseFighterClass bfc = new BaseFighterClass();
                characterClass.setCharacterClassName(bfc.getCharacterClassName());
                characterClass.setCharacterClassDescription(bfc.getCharacterClassDescription());

                characterClass.setStrength(bfc.getStrength());
                characterClass.setDextarity(bfc.getDextarity());
                characterClass.setConstitiution(bfc.getConstitiution());
                characterClass.setInteligance(bfc.getInteligance());
                characterClass.setWisdom(bfc.getWisdom());
                characterClass.setCharisma(bfc.getCharisma());

                tempPlayer.getInventory().addItem(bfc.getClassItems());
                break;
            case Healer:
                BaseHealerClass bhc = new BaseHealerClass();
                characterClass.setCharacterClassName(bhc.getCharacterClassName());
                characterClass.setCharacterClassDescription(bhc.getCharacterClassDescription());

                characterClass.setStrength(bhc.getStrength());
                characterClass.setDextarity(bhc.getDextarity());
                characterClass.setConstitiution(bhc.getConstitiution());
                characterClass.setInteligance(bhc.getInteligance());
                characterClass.setWisdom(bhc.getWisdom());
                characterClass.setCharisma(bhc.getCharisma());

                tempPlayer.getInventory().addItem(bhc.getClassItems());
                break;
        }
        return characterClass;
    }
}

package Player;

import CharacterClasses.BaseFighterClass;
import CharacterClasses.BaseHealerClass;
import CharacterClasses.CharacterClass;
import CharacterClasses.Classes;

public class CharacterCreation {

    private Player tempPlayer;
    
    public void createCharacter()
    {
        tempPlayer = new Player();
        setName("Mauldin");
        setGender(true);
        createCharacterInventory();
        setCharacterClass();
    }
    
    private void setName(String name)
    {
        tempPlayer.setName(name);
    }
    
    private void setCharacterClass()
    {
        CharacterClass characterClass = getCharacterClass();
        tempPlayer.setCharacterClass(characterClass);
    }
    
    private void setGender(boolean isMale)
    {
        tempPlayer.setGender(isMale);
    }
    
    private void createCharacterInventory()
    {
        tempPlayer.setInventory(new CharacterInventory());
    }
    
    private CharacterClass getCharacterClass()
    {
        CharacterClass characterClass = new CharacterClass();
        //TODO: add a user input to get which type of class player wants to be
        Classes temp = Classes.Fighter;
        
        switch( temp )
        {
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

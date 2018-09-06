package Player;

import CharacterClasses.BaseFighterClass;
import CharacterClasses.CharacterClass;

public class CharacterCreation {

    private Player tempPlayer;
    
    public void createCharacter()
    {
        tempPlayer = new Player();
        setName("Mauldin");
        setGender(true);
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
        
        switch( 1 )
        {
            case 1:
                BaseFighterClass bfc = new BaseFighterClass();
                characterClass.setCharacterClassName(bfc.getCharacterClassName());
                characterClass.setCharacterClassDescription(bfc.getCharacterClassDescription());

                characterClass.setStrength(bfc.getStrength());
                characterClass.setDextarity(bfc.getDextarity());
                characterClass.setConstitiution(bfc.getConstitiution());
                characterClass.setInteligance(bfc.getInteligance());
                characterClass.setWisdom(bfc.getWisdom());
                characterClass.setCharisma(bfc.getCharisma());
                
                tempPlayer.getInventory().addItem( bfc.getClassItems() );
                break;
        }
        return null;
    }
}

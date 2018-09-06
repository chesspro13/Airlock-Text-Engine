package Player;

import CharacterClasses.*;

public class Player {
    
    private String name;
    private boolean isMale;
    private CharacterInventory inventory;
    private CharacterClass characterClass;
    
    void Player(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getGender() {
        return isMale;
    }

    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    public CharacterInventory getInventory() {
        return inventory;
    }

    public void setInventory(CharacterInventory inventory) {
        this.inventory = inventory;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }
    
    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }
    
    
}

package Player;

import CharacterClasses.*;
import Combat.Attack;
import Item.BaseItem;
import Item.BaseItemArmor;
import Item.BaseItemWeapon;
import java.util.LinkedList;
import src.GlobalInventory;

public class Player {
    private GlobalInventory globalInventory;
    
    private PlayerIdentifier playerIdentifier;
    
    private String name;
    private boolean isMale;
    private CharacterInventory inventory;
    private CharacterClass characterClass;
    
    private LinkedList<Attack> attacks;
    
    public Player(){
        inventory = new CharacterInventory(playerIdentifier);
    }
    
    public void setGlobalInventory(GlobalInventory globalInventory)
    {
        this.globalInventory = globalInventory;
    }
    
    public GlobalInventory getGlobalInventory()
    {
        return globalInventory;
    }
    
    public CharacterInventory getCharacterInventory()
    {
        return inventory;
    }
    
    public void setCharacterType(PlayerIdentifier playerIdentifier)
    {
        this.playerIdentifier = playerIdentifier;
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
    
    public void equip(BaseItemArmor bia)
    {
        
    }
    
    public void equip(BaseItemWeapon biw)
    {
        
    }
    
    public void setAttacks()
    {
        LinkedList<BaseItem> equipedItem;
        equipedItem = inventory.getEquippedWeapons();
        BaseItem weapon;
        
        for ( int i = 0; i < equipedItem.size(); i++ ) {
            weapon = equipedItem.get(i);
            this.attacks.add( new Attack(weapon.getName(), new int []{1,2}, new String[]{"Fuck you", "You bitch"}));
        }
    }
    
    public LinkedList<Attack> getAttacks()
    {
        return this.attacks;
    }
}

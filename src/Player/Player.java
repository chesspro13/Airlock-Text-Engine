package Player;

import CharacterClasses.*;
import Combat.Attack;
import Item.BaseItem;
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

    public Player() {
        inventory = new CharacterInventory(playerIdentifier);
    }

    public void setGlobalInventory(GlobalInventory globalInventory) {
        this.globalInventory = globalInventory;
    }

    public GlobalInventory getGlobalInventory() {
        return globalInventory;
    }

    public CharacterInventory getCharacterInventory() {
        return inventory;
    }

    public void setCharacterType(PlayerIdentifier playerIdentifier) {
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

    public BaseItem equip(BaseItem item) {
        BaseItem oldItem = new BaseItem();

        switch (item.getItemType()) {
            case Weapon:
                if (inventory.getEquippedWeapon() != null) {
                    oldItem = inventory.getEquippedWeapon();
                }
                inventory.equipItem(item);
                return oldItem;
        }
        return null;
    }

    public void setAttacks() {
        BaseItemWeapon equipedItem = (BaseItemWeapon) inventory.getEquippedWeapon();

        this.attacks.add(new Attack(equipedItem.getName(), new int[]{equipedItem.getDamage()}, new String[]{"Fuck You", "You Bitch"}));
    }

    public LinkedList<Attack> getAttacks() {
        return this.attacks;
    }

    public int getDamage() {
        int damage = 0;
//        System.out.println("LDFKJSLKFJ\t\t" + inventory.getEquippedWeapon().getName());
        if (inventory.getEquippedWeapon() != null) {
            damage += ((BaseItemWeapon) inventory.getEquippedWeapon()).getDamage();
        }
        return damage;
    }
}

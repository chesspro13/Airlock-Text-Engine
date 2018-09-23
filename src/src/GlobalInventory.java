package src;

//package src;
import IO.IO;
import IO.OutputType;
import Item.BaseItem;
import Item.BaseItemArmor;
import Item.BaseItemWeapon;
import Item.ItemType;
import Player.Player;
import java.util.*;

public class GlobalInventory {

    LinkedList<BaseItem> allItems;

    LinkedList<Player> characters;

    private int money;

    GameEvent gameEvent;
    UiEvent uiEvent;
    IO interactionEvent;

    StoreState tab;

    public GlobalInventory(GameEvent gameEvent, UiEvent uiEvent, IO interactionEvent) {

        this.gameEvent = gameEvent;
        this.uiEvent = uiEvent;
        this.interactionEvent = interactionEvent;

        allItems = new LinkedList<>();

        money = 0;
    }
    
    public void setCharacters(LinkedList<Player> characters)
    {
        this.characters = characters;
    }

    public LinkedList<BaseItem> getWeapons() {
        LinkedList<BaseItem> weapons = new LinkedList<>();
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getItemType() == ItemType.Weapon) {
                weapons.add(allItems.get(i));
            }
        }
        return weapons;
    }

    public LinkedList<String[]> getWeaponsString() {
        LinkedList<String[]> temp = new LinkedList<String[]>();
        LinkedList<BaseItem> weapons = getWeapons();
        for (int i = 0; i < weapons.size(); i++) {
            temp.add(new String[]{weapons.get(i).getName(), weapons.get(i).getCost() + "", ((BaseItemWeapon) weapons.get(i)).getDamage() + "", ((BaseItemWeapon) weapons.get(i)).getHandsRequired() + "", weapons.get(i).getDescription()});
        }

        return temp;
    }

    public LinkedList<BaseItem> getArmor() {
        LinkedList<BaseItem> armor = new LinkedList<>();
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getItemType() == ItemType.Armor) {
                armor.add(allItems.get(i));
            }
        }
        return armor;
    }

    public LinkedList<String[]> getArmorString() {
        LinkedList<String[]> temp = new LinkedList<>();
        LinkedList<BaseItem> armor = getArmor();
        for (int i = 0; i < armor.size(); i++) {
            temp.add(new String[]{armor.get(i).getName(), armor.get(i).getCost() +"",((BaseItemArmor) armor.get(i)).getDeffence()+"",armor.get(i).getDescription()});
        }

        return temp;
    }

    public LinkedList<BaseItem> getItems() {
        LinkedList<BaseItem> item = new LinkedList<>();
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getItemType() == ItemType.GeneralItem) {
                item.add(allItems.get(i));
            }
        }
        return item;
    }

    public LinkedList<BaseItem> getPotions() {
        System.err.println("Get potion method has not been implemented yet.");
        return null;
    }

    public LinkedList<String[]> getItemsString() {
        LinkedList<String[]> temp = new LinkedList<>();
        LinkedList<BaseItem> items = getItems();
        for (int i = 0; i < items.size(); i++) {
            temp.add(new String[]{items.get(i).getName(), items.get(i).getCost() +"",items.get(i).getDescription()});
        }

        return temp;
    }

    public int getMoney() {
        return money;
    }

    public void view() {
        tab = StoreState.WeaponsTab;
        int choice;
        String header;
        LinkedList<String> endOptions = new LinkedList<>();
            endOptions.add("Tab left");
            endOptions.add("Tab Right");
            endOptions.add("Leave");

        while (true) {
            switch (tab) {
                //TODO: Add more information to inventory
                case WeaponsTab:
                    // TODO: Fix me
                    LinkedList<BaseItem> weapons = new LinkedList<>();
                    weapons = getWeapons();
                    
                    header = "<Weapon> Armor Items\tYour money: $" + getMoney();
                    String[] weaponsArray = new String[weapons.size()];
                    for (int i = 0; i < weapons.size(); i++) {
                        //System.out.println(weapons.get(i).getName() + "\t" + weapons.get(i).getCost());
                        weaponsArray[i] = weapons.get(i).getName() + "\t" + weapons.get(i).getDescription();
                    }

                    if( weapons.isEmpty() )
                        choice = interactionEvent.getOptionInput(header, endOptions);
                    else
                        choice = interactionEvent.getOptionInput(header, weapons, endOptions, OutputType.Other);
                    choice--;
                    
                    if (choice == weaponsArray.length) {
                        tab = tabLeft(tab);
                    } else if (choice == weaponsArray.length + 1) {
                        tab = tabRight(tab);
                    } else if (choice == weaponsArray.length + 2) {
                        System.err.println("GlobalInventory.view() Weapons tab returning!");
                        return;
                    } else {
                        viewWeapon(choice);
                    }
                    break;
                case ArmorTab:
                    header = "Weapon <Armor> Items\tYour money: $" + getMoney();
                    LinkedList<BaseItem> armor = getArmor();
                    String[] armorArray = new String[armor.size() + 3];
                    for (int i = 0; i < armor.size(); i++) {
                        //System.out.println(weapons.get(i).getName() + "\t" + weapons.get(i).getCost());
                        armorArray[i] = armor.get(i).getName() + "\t" + armor.get(i).getDescription();
                    }

                    if( armor.isEmpty() )
                        choice = interactionEvent.getOptionInput(header, endOptions);
                    else
                        choice = interactionEvent.getOptionInput(header, armor, endOptions, OutputType.Other);
                    choice--;
                    
                    if (choice == armorArray.length - 3) {
                        tab = tabLeft(tab);
                    } else if (choice == armorArray.length - 2) {
                        tab = tabRight(tab);
                    } else if (choice == armorArray.length - 1) {
                        return;
                    } else {
                        viewArmor(choice);
                    }
                    break;
                case ItemsTab:
                    header = "Weapon Armor <Items>\tYour money: $" + getMoney();
                    LinkedList<BaseItem> items = getGeneralItems();
                    String[] itemsArray = new String[items.size() + 3];
                    for (int i = 0; i < items.size(); i++) {
                        //System.out.println(weapons.get(i).getName() + "\t" + weapons.get(i).getCost());
                        itemsArray[i] = items.get(i).getName() + "\t" + items.get(i).getDescription();
                    }

                    if( items.isEmpty() )
                        choice = interactionEvent.getOptionInput(header, endOptions);
                    else
                        choice = interactionEvent.getOptionInput(header, items, endOptions, OutputType.Other);

                    choice--;
                    
                    if (choice == itemsArray.length - 3) {
                        tab = tabLeft(tab);
                    } else if (choice == itemsArray.length - 2) {
                        tab = tabRight(tab);
                    } else if (choice == itemsArray.length - 1) {
                        return;
                    } else {
                        viewGeneralItem(choice);
                    }
                    break;
            }
        }
    }

    private StoreState tabRight(StoreState tab) {
        switch (tab) {
            case WeaponsTab:
                return StoreState.ArmorTab;
            case ArmorTab:
                return StoreState.ItemsTab;
            case ItemsTab:
                return StoreState.WeaponsTab;
            default:
                return StoreState.WeaponsTab;
        }
    }

    private StoreState tabLeft(StoreState tab) {
        switch (tab) {
            case WeaponsTab:
                return StoreState.ItemsTab;
            case ArmorTab:
                return StoreState.WeaponsTab;
            case ItemsTab:
                return StoreState.ArmorTab;
            default:
                return StoreState.WeaponsTab;
        }
    }

    private BaseItem getWeaponFromId(int index) {
        LinkedList<BaseItem> weapons = getWeapons();
        return weapons.get(index);
    }

    private void viewWeapon(int index) {
        BaseItem viewedWeapon = getWeaponFromId(index);
        String temp = "Name: " + viewedWeapon.getName()
                + "\nAttack: " + ((BaseItemWeapon) viewedWeapon).getDamage()
                + "\nDescription: " + viewedWeapon.getDescription();

        //TODO: Reimplement Equiping items
        switch (interactionEvent.getOptionInput(temp, new String[]{"Equip", "Drop", "exit"})) {
            case 1:
                equip(allItems.get(index));
                break;
            case 2:
                removeWeapon(index);
                break;
            case 3:
                return;
        }
    }
    
    

    private BaseItem getArmorFromId(int index) {
        LinkedList<BaseItem> armors = getArmor();
        return armors.get(index);
    }

    private void viewArmor(int index) {
        BaseItem viewedArmor = getArmorFromId(index);
        String temp = "Name: " + viewedArmor.getName()
                + "\nAttack: " + ((BaseItemArmor) viewedArmor).getDeffence()
                + "\nDescription: " + viewedArmor.getDescription();

        switch (interactionEvent.getOptionInput(temp, new String[]{"Equip", "Drop", "exit"})) {
            case 1:
                //TODO: figure out multiple player thing
                //player.equip( (BaseItemArmor)armor );
                //uiEvent.printWithPause( armor.getName() + " is equiped!\nAttack: " + (player.getAttack() + armor.getDeffence()));
                break;
            case 2:
                removeArmor(index);
                break;
            case 3:
                return;
        }
    }

    private BaseItem getGeneralItemFromId(int index) {
        LinkedList<BaseItem> generalItems = getGeneralItems();
        return generalItems.get(index);
    }
    
    private void viewGeneralItem(int index) {
        BaseItem viewedGeneralItem = getGeneralItemFromId(index);
        String temp = "Name: " + viewedGeneralItem.getName()
                + "\nDescription: " + viewedGeneralItem.getDescription();

        switch (interactionEvent.getOptionInput(temp, new String[]{"use", "Drop", "exit"})) {
            case 1:
                //TODO: figure out multiple player thing
                //player.useItem( item );
                uiEvent.printWithPause("used " + viewedGeneralItem.getName());
                break;
            case 2:
                removeGeneralItem(index);
                break;
            case 3:
                return;
        }
    }

    public void addItem(BaseItem item) {
        allItems.add(item);
    }

    public void buyItem(BaseItem item) {
        this.money -= item.getCost();
        allItems.add(item);
    }

    public void removeWeapon(int index) {
        LinkedList<BaseItem> weapons = getWeapons();
        weapons.remove(index);
    }

    //Commented out to find uses. Need to change because of new inventory system
    public void removeArmor(int index) {
        LinkedList<BaseItem> armor = getArmor();
        armor.remove(index);
    }

    //Commented out to find uses. Need to change because of new inventory system
    public void removeGeneralItem(int index) {
        LinkedList<BaseItem> generalItems = getGeneralItems();
        generalItems.remove(index);
    }

    //Commented out to find uses. Need to change because of new inventory system
    public BaseItemWeapon getWeapon(int index) {
        LinkedList<BaseItem> weapons = getWeapons();
        if (index >= 0) {
            return (BaseItemWeapon) weapons.get(index);
        }
        return null;
    }

    //Commented out to find uses. Need to change because of new inventory system
    public BaseItemArmor getArmor(int index) {
        LinkedList<BaseItem> armor = getArmor();
        if (index >= 0) {
            return (BaseItemArmor) armor.get(index);
        }
        return null;
    }

    //Commented out to find uses. Need to change because of new inventory system
//	public BaseItem getItem( int index )
    public GlobalInventory() {
    }

    public void buyWeapon(BaseItem item) {
        if (removeMoney(item.getCost())) {
            uiEvent.printWithPause("Global inventory says you bought a weapon");
            allItems.add(item);
        } else {
            uiEvent.printWithPause("GlobalInventory says you don't have enough money to buy this");
        }
    }

    public void giveMoney(int money, UiEvent event) {
        this.money = money;
        event.printWithPause("Got $" + money + "!");
    }

    private boolean removeMoney(int money) {
        if (this.money < money) {
            return false;
        } else {
            this.money -= money;
            return true;
        }

    }

    public boolean sellWeapon(int index) {
        LinkedList<BaseItem> weapons = getWeapons();
        int cost = weapons.get(index).getCost();
        uiEvent.printWithPause("You got $" + cost + "!");
        giveMoney(cost, uiEvent);
        removeWeapon(index);
        return true;
    }

    public boolean sellArmor(int index) {
        LinkedList<BaseItem> armor = getArmor();
        int cost = armor.get(index).getCost();
        uiEvent.printWithPause("You got $" + cost + "!");
        giveMoney(cost, uiEvent);
        removeArmor(index);
        return true;
    }

    public boolean sellItem(int index) {
        LinkedList<BaseItem> generalItem = getGeneralItems();
        int cost = generalItem.get(index).getCost();
        uiEvent.printWithPause("You got $" + cost + "!");
        giveMoney(cost, uiEvent);
        removeGeneralItem(index);
        return true;
    }
    
    public LinkedList<BaseItem> getGeneralItems()
    {
        LinkedList<BaseItem> generalItems = new LinkedList<>();
        for (BaseItem allItem : allItems) {
            if(allItem.getItemType() == ItemType.GeneralItem)
                generalItems.add( allItem );
        }
        return generalItems;
    }

//    public LinkedList<BaseItem> getAllItemsFromAllInventories() {
//        //TODO: Implement
//        //System.err.println("Get all items from all inventories not implemented yet");
//        LinkedList<BaseItem> allItemsTemp = new LinkedList<>();
//        allItemsTemp.addAll(allItems);
//
//        for( int i = 0; i < characters.size(); i++ )
//        {
//            allItems.addAll(characters.get(i).getInventory().getInventory());
//        }
//        
//        System.out.println("Got to here");
//        
//        for (BaseItem allItem : allItemsTemp) {
//            System.out.println(allItem.getName());
//        }
//
//        return allItemsTemp;
//    }
//
//    public LinkedList<BaseItem> getAllWeaponsFromAllInventories() {
//        LinkedList<BaseItem> allItems = getAllItemsFromAllInventories();
//        LinkedList<BaseItem> allWeapons = new LinkedList<>();
//
//        for (int i = 0; i < allItems.size(); i++) {
//            if (allItems.get(i).getItemType() == ItemType.Weapon) {
//                allWeapons.add(allItems.get(i));
//            }
//        }
//
//        return allWeapons;
//    }

//    public LinkedList<String[]> getAllWeaponsFromAllInventoriesString() {
//        LinkedList<String[]> bigString = new LinkedList<>();
//        LinkedList<BaseItem> allWeapons = getAllWeaponsFromAllInventories();
//        for (int i = 0; i < allWeapons.size(); i++) {
//            BaseItemWeapon item = (BaseItemWeapon) allWeapons.get(i);
//            bigString.add(new String[]{item.getName(), item.getDamage() + "", item.getDescription()});
//        }
//
//        return bigString;
//    }
//
//    public LinkedList<BaseItem> getAllArmorFromAllInventories() {
//        LinkedList<BaseItem> allItems = getAllItemsFromAllInventories();
//        LinkedList<BaseItem> allArmor = new LinkedList<>();
//
//        for (int i = 0; i < allItems.size(); i++) {
//            if (allItems.get(i).getItemType() == ItemType.Armor) {
//                allArmor.add(allItems.get(i));
//            }
//        }
//
//        return allArmor;
//    }

//    public LinkedList<String[]> getAllArmorFromAllInventoriesString() {
//        LinkedList<String[]> bigString = new LinkedList<>();
//        LinkedList<BaseItem> allArmor = getAllArmorFromAllInventories();
//
//        for (int i = 0; i < allArmor.size(); i++) {
//            BaseItemArmor item = (BaseItemArmor) allArmor.get(i);
//            bigString.add(new String[]{item.getName(), item.getDeffence() + "", item.getDescription()});
//        }
//
//        return bigString;
//    }

//    public LinkedList<BaseItem> getAllGeneralItemsFromAllInventories() {
//        LinkedList<BaseItem> allItems = getAllItemsFromAllInventories();
//        LinkedList<BaseItem> allGeneralItems = new LinkedList<>();
//
//        for (int i = 0; i < allItems.size(); i++) {
//            if (allItems.get(i).getItemType() == ItemType.GeneralItem) {
//                allGeneralItems.add(allItems.get(i));
//            }
//        }
//
//        return allGeneralItems;
//    }

//    public LinkedList<String[]> getAllGeneralItemsFromAllInventoriesString() {
//        LinkedList<String[]> bigString = new LinkedList<>();
//        LinkedList<BaseItem> allGeneralItems = getAllGeneralItemsFromAllInventories();
//
//        for (int i = 0; i < allGeneralItems.size(); i++) {
//            BaseItem item = (BaseItem) allGeneralItems.get(i);
//            bigString.add(new String[]{item.getName(), item.getDescription()});
//        }
//
//        return bigString;
//    }

    public void viewItems() {
        LinkedList<BaseItem> all = new LinkedList<>();
        all.addAll(this.allItems);

        LinkedList<BaseItem> weapon = new LinkedList<>();
        LinkedList<BaseItem> armor = new LinkedList<>();
        LinkedList<BaseItem> items = new LinkedList<>();

        for (int i = 0; i < all.size(); i++) {
            switch (all.get(i).getItemType()) {
                case Weapon:
                    weapon.add(all.get(i));
                    break;
                case Armor:
                    armor.add(all.get(i));
                    break;
                case GeneralItem:
                case Potion:
                    items.add(all.get(i));
                    break;
            }

        }
    }
    
    private void equip(BaseItem item)
    {
        //TODO: Add text formatting
        TextFormatter tf = new TextFormatter();
        String output = "Who do you want to equip the " + item.getName() + "?";
        LinkedList<String> characterNames = new LinkedList<>();
        
        switch( item.getItemType() )
        {
            case Weapon:
                int prevousDamage = 0;
                int newDamage = 0;
                
                for (int i = 0; i < characters.size(); i++ ) {
                    prevousDamage = characters.get(i).getDamage();
                    newDamage = ((BaseItemWeapon)item).getDamage();
                    
                    if( newDamage > prevousDamage )
                        characterNames.add(characters.get(i).getName() + " +" + (newDamage - prevousDamage) );
                    else if( newDamage < prevousDamage )
                        characterNames.add(characters.get(i).getName() + " " + (newDamage - prevousDamage) );
                    else
                        characterNames.add(characters.get(i).getName() + " +0" );
                }
                
        }
        
        characterNames.add("Never mind..");
        
        int choice = interactionEvent.getOptionInput(output, characterNames);
        
        if (choice == characterNames.size() )
            return;
        
        BaseItem previouslyEquipped = characters.get(choice-1).equip(item);
        //System.err.println("previouslyEquipped: " + previouslyEquipped.getName());
        if(previouslyEquipped.getName() != null)
            addItem(previouslyEquipped);
        removeItem(item);
        
        System.out.println("Equipped the " + item.getName() + " to " + characterNames.get(choice-1));
    }
    
    private void removeItem(BaseItem item)
    {
        int index = allItems.indexOf(item);
        allItems.remove(index);
    }
    
    private void removeItem(BaseItem item, int index)
    {
        this.allItems.remove(item);
    }
    
    private LinkedList<BaseItem> getAllWeapons()
    {
        LinkedList<BaseItem> weapons = new LinkedList<>();
        
        for (BaseItem allItem : allItems) {
            if(allItem.getItemType() == ItemType.Weapon)
                weapons.add(allItem);
        }
        System.err.println("Got all weapone!");
        return weapons;
    }
    
    private LinkedList<BaseItem> getAllArmor()
    {
        LinkedList<BaseItem> armor = new LinkedList<>();
        
        for (BaseItem allItem : allItems) {
            if(allItem.getItemType() == ItemType.Armor)
                armor.add(allItem);
        }
        
        return armor;
    }
}

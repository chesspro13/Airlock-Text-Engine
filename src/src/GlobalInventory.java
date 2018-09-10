package src;

//package src;

import Item.BaseItem;
import Item.BaseItemArmor;
import Item.BaseItemWeapon;
import Item.ItemType;
import src.UiEvent;
import java.util.*;

public class GlobalInventory
{
    LinkedList<BaseItem> allItems;
    
    LinkedList<BaseItem> inventoryPlayer;
    LinkedList<BaseItem> inventorySecond;
    LinkedList<BaseItem> inventoryThird;
    LinkedList<BaseItem> inventoryFourth;
    
    private int money;
	
	
	GameEvent gameEvent;
	UiEvent uiEvent;
	InteractionEvent interactionEvent;

	
	StoreState tab;

	public GlobalInventory( GameEvent gameEvent, UiEvent uiEvent, InteractionEvent interactionEvent )
	{
		
		this.gameEvent = gameEvent;
		this.uiEvent = uiEvent;
		this.interactionEvent = interactionEvent;
		
		allItems = new LinkedList();
                
                money = 0;
	}

	public LinkedList<BaseItem> getWeapons()
	{
            LinkedList<BaseItem> weapons = new LinkedList<>();
            for (int i = 0; i < allItems.size(); i++) {
                if( allItems.get(i).getItemType() == ItemType.Weapon )
                    weapons.add(allItems.get(i));
            }
		return weapons;
	}
	
	public LinkedList<String []> getWeaponsString()
	{
		LinkedList<String []> temp = new LinkedList<String[]>();
                LinkedList<BaseItem> weapons = getWeapons();
		for( int i = 0; i < weapons.size(); i++)
                {
			temp.add( new String[]{ weapons.get(i).getName(), weapons.get(i).getCost() + "",  ((BaseItemWeapon) weapons.get(i)).getDamage() + "", ((BaseItemWeapon) weapons.get(i)).getHandsRequired() + "", weapons.get(i).getDescription() });     
		}
		
		return temp;
	}

	public LinkedList<BaseItem> getArmor()
	{
            LinkedList<BaseItem> armor = new LinkedList<>();
            for (int i = 0; i < allItems.size(); i++) {
                if( allItems.get(i).getItemType() == ItemType.Armor  )
                    armor.add(allItems.get(i));
            }
		return armor;
	}
	
	public LinkedList<String> getArmorString()
	{
		LinkedList<String> temp = new LinkedList<String>();
                LinkedList<BaseItem> armor = getArmor();
		for( int i = 0; i < armor.size(); i++)
		{
			temp.add( armor.get(i).getName() + ":" + armor.get(i).getCost() + " " + ((BaseItemArmor) armor.get(i)).getDeffence() + "/" + armor.get(i).getDescription() );     
		}

		return temp;
	}

	public LinkedList<BaseItem> getItems()
	{
            LinkedList<BaseItem> item = new LinkedList<>();
            for (int i = 0; i < allItems.size(); i++) {
                if( allItems.get(i).getItemType() == ItemType.GeneralItem )
                    item.add(allItems.get(i));
            }
            return item;
	}
        
        public LinkedList<BaseItem> getPotions()
        {
            System.err.println("Get potion method has not been implemented yet.");
            return null;
        }
	
	public LinkedList<String> getItemsString()
	{
		LinkedList<String> temp = new LinkedList<String>();
                LinkedList<BaseItem> items = getItems();
		for( int i = 0; i < items.size(); i++)
		{
			temp.add( items.get(i).getName() + ":" + items.get(i).getCost() + "/" + items.get(i).getDescription());
		}

		return temp;
	}
        
        public int getMoney()
        {
            return money;
        }

	public void view()
	{
		tab = StoreState.WeaponsTab;
		int choice;
		String header;
		String [] endOptions;
		
		while( true )
		switch( tab )
		{
			//TODO: Add more information to inventory
			case WeaponsTab:
                            // TODO: Fix me
                                LinkedList<BaseItem> weapons = getAllWeaponsFromAllInventories();
				header = "<Weapon> Armor Items\tYour money: $" + getMoney();
				String [] 	weaponsArray = new String[weapons.size()+ 3];
				for(int i = 0; i < weapons.size(); i++){
					//System.out.println(weapons.get(i).getName() + "\t" + weapons.get(i).getCost());
					weaponsArray[i] = weapons.get(i).getName() + "\t" + weapons.get(i).getDescription();
				}
				endOptions = new String[]{
					"Tab left",
					"Tab Right",
					"Leave"
				};
				choice = interactionEvent.getOptionInput( header, weapons, endOptions, 1 );
				choice--;
				System.out.println( choice + " = " + weaponsArray[choice] );
				if( choice == weaponsArray.length - 3 )
					tab = tabLeft( tab );
				else if( choice == weaponsArray.length - 1 )
					tab = tabRight( tab );
				else if( choice == weaponsArray.length - 0 )
					return;
				else
					viewWeapon(  choice );
				break;
			case ArmorTab:
				header = "Weapon <Armor> Items\tYour money: $" + getMoney();
                                LinkedList<BaseItem> armor = getAllArmorFromAllInventories();
				String [] 	armorArray = new String[armor.size()+ 3];
				for(int i = 0; i < armor.size(); i++){
					//System.out.println(weapons.get(i).getName() + "\t" + weapons.get(i).getCost());
					armorArray[i] = armor.get(i).getName() + "\t" + armor.get(i).getDescription();
				}
				endOptions = new String[]{
					"Tab left",
					"Tab Right",
					"Leave"
				};
				choice = interactionEvent.getOptionInput( header, 1, armor, endOptions);
				choice--;
				System.out.println( armorArray[choice] );
				if( choice == armorArray.length - 3 )
					tab = tabLeft( tab );
				else if( choice == armorArray.length - 2 )
					tab = tabRight( tab );
				else if( choice == armorArray.length - 1 )
					return;
				else
                                    viewArmor(choice);
				break;
			case ItemsTab:
				header = "Weapon Armor <Items>\tYour money: $" + getMoney();
                                LinkedList<BaseItem> items = getAllGeneralItemsFromAllInventories();
				String [] 	itemsArray = new String[items.size()+ 3];
				for(int i = 0; i < items.size(); i++){
					//System.out.println(weapons.get(i).getName() + "\t" + weapons.get(i).getCost());
					itemsArray[i] = items.get(i).getName() + "\t" + items.get(i).getDescription();
				}
				endOptions = new String[]{
					"Tab left",
					"Tab Right",
					"Leave"
				};
				choice = interactionEvent.getOptionInput( header, items, 1, endOptions );
				choice--;
				System.out.println( choice + " = " + itemsArray[choice] );
				if( choice == itemsArray.length - 3 )
					tab = tabLeft( tab );
				else if( choice == itemsArray.length - 2 )
					tab = tabRight( tab );
				else if( choice == itemsArray.length - 1 )
					return;
				else
                                    viewGeneralItem(choice);
				break;
		}
	}
	
	private StoreState tabRight(StoreState tab)
	{
		switch( tab )
		{
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

	private StoreState tabLeft(StoreState tab)
	{
		switch( tab )
		{
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

        private BaseItem getWeaponFromId(int index)
        {
            LinkedList<BaseItem> weapons = getAllWeaponsFromAllInventories();
            return weapons.get(index);
        }
        
	private void viewWeapon(int index)
	{
            BaseItem viewedWeapon = getWeaponFromId(index);
		String temp = "Name: " + viewedWeapon.getName()
			+ "\nAttack: " + ((BaseItemWeapon)viewedWeapon).getDamage()
			+ "\nDescription: " + viewedWeapon.getDescription();
		
                //TODO: Reimplement Equiping items
		switch( interactionEvent.getOptionInput(temp, new String[]{"Equip", "Drop", "exit"}) )
		{
			case 1:
                            //TODO: figure out multiple player thing
                            //player.equip( weapon );
                            //uiEvent.printWithPause( weapon.getName() + " is equiped!\nAttack: " + (player.getAttack() + weapon.getDamage()));
                            break;
			case 2:
                            removeWeapon(index);
				break;
			case 3:
				return;
		}
	}

        private BaseItem getArmorFromId(int index)
        {
            LinkedList<BaseItem> armors = getAllArmorFromAllInventories();
            return armors.get(index);
        }
        
	private void viewArmor(int index)
	{
            BaseItem viewedArmor = getArmorFromId(index);
		String temp = "Name: " + viewedArmor.getName()
			+ "\nAttack: " + ((BaseItemArmor)viewedArmor).getDeffence()
			+ "\nDescription: " + viewedArmor.getDescription();

		switch( interactionEvent.getOptionInput(temp, new String[]{"Equip", "Drop", "exit"}) )
		{
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
        
        private BaseItem getGeneralItemFromId(int index)
        {
            LinkedList<BaseItem> generalItems = getAllGeneralItemsFromAllInventories();
            return generalItems.get(index);
        }

	private void viewGeneralItem(int index)
	{
            BaseItem viewedGeneralItem = getGeneralItemFromId(index);
		String temp = "Name: " + viewedGeneralItem.getName()
			+ "\nDescription: " + viewedGeneralItem.getDescription();

		switch( interactionEvent.getOptionInput(temp, new String[]{"use", "Drop", "exit"}) )
		{
			case 1:
				//TODO: figure out multiple player thing
				//player.useItem( item );
				uiEvent.printWithPause( "used " + viewedGeneralItem.getName() );
				break;
			case 2:
                            removeGeneralItem(index);
				break;
			case 3:
				return;
		}
	}
	
	

	public void addItem(BaseItemWeapon weapon)
	{
		allItems.add( weapon );
		uiEvent.printWithPause( weapon.getName() + " added to your inventory!");
	}

	public void addItem(BaseItemArmor armor)
	{
		allItems.add( armor );
		uiEvent.printWithPause( armor.getName() + " added to your inventory!");
	}
        
	public void removeWeapon(int index)
	{
            LinkedList<BaseItem> weapons = getAllWeaponsFromAllInventories();
            weapons.remove(index);
	}
        
        //Commented out to find uses. Need to change because of new inventory system
	public void removeArmor(int index)
	{
            LinkedList<BaseItem> armor = getAllArmorFromAllInventories();
            armor.remove(index);
	}

        //Commented out to find uses. Need to change because of new inventory system
	public void removeGeneralItem(int index)
	{
            LinkedList<BaseItem> generalItems = getAllGeneralItemsFromAllInventories();
            generalItems.remove(index);
	}
	
        //Commented out to find uses. Need to change because of new inventory system
	public BaseItemWeapon getWeapon( int index )
	{
            LinkedList<BaseItem> weapons = getAllWeaponsFromAllInventories();
            if( index >= 0)
                return (BaseItemWeapon)weapons.get( index );
            return null;
	}

        //Commented out to find uses. Need to change because of new inventory system
	public BaseItemArmor getArmor( int index )
	{
            LinkedList<BaseItem> armor = getAllArmorFromAllInventories();
            if( index >= 0 )
		return (BaseItemArmor) armor.get( index );
            return null;
	}

        //Commented out to find uses. Need to change because of new inventory system
//	public BaseItem getItem( int index )
        
        
        

    public GlobalInventory() {
    }
        
        public void buyItem(BaseItem item)
        {
            System.err.println("BuyItem method in GlobalInventory not implemented");
        }
        
        public void buyWeapon(BaseItem item)
        {
            if( removeMoney(item.getCost()) )
            {
                uiEvent.printWithPause("Global inventory says you bought a weapon");
                allItems.add(item);
            }else
                uiEvent.printWithPause("GlobalInventory says you don't have enough money to buy this");
        }
        
        public void giveMoney(int money, UiEvent event)
        {
            this.money = money;
            event.printWithPause( "Got $" + money + "!");
        }
        
        private boolean removeMoney(int money)
        {
            if( this.money < money )
                return false;
            else
            {
                this.money -= money;
                return true;
            }
                
        }

	public boolean sellWeapon(int index)
	{
            LinkedList<BaseItem> weapons = getAllWeaponsFromAllInventories();
		int cost = weapons.get( index ).getCost();
		uiEvent.printWithPause("You got $" + cost + "!");
		giveMoney(cost, uiEvent);
		removeWeapon( index );
		return true;
	}

	public boolean sellArmor(int index)
	{
            LinkedList<BaseItem> armor = getAllArmorFromAllInventories();
		int cost = armor.get( index ).getCost();
		uiEvent.printWithPause("You got $" + cost + "!");
		giveMoney(cost, uiEvent);
		removeArmor( index );
		return true;
	}

	public boolean sellItem(int index)
	{
            LinkedList<BaseItem> generalItem = getAllGeneralItemsFromAllInventories();
		int cost = generalItem.get( index ).getCost();
		uiEvent.printWithPause("You got $" + cost + "!");
		giveMoney(cost, uiEvent);
		removeGeneralItem( index );
		return true;
	}
        
        public LinkedList<BaseItem> getAllItemsFromAllInventories()
        {
            //TODO: Implement
            System.err.println("Get all items from all inventories not implemented yet");
            LinkedList<BaseItem> allItems = this.allItems;
            
            for (int i = 0; i < inventoryPlayer.size(); i++) {
                allItems.add( inventoryPlayer.get(i) );
            }
            
            for (int i = 0; i < inventorySecond.size(); i++) {
                allItems.add( inventorySecond.get(i) );
            }
            
            for (int i = 0; i < inventoryThird.size(); i++) {
                allItems.add( inventoryThird.get(i) );
            }
            
            for (int i = 0; i < inventoryFourth.size(); i++) {
                allItems.add( inventoryFourth.get(i) );
            }
            
            
            return null;
        }
        
        public LinkedList<BaseItem> getAllWeaponsFromAllInventories()
        {
            LinkedList<BaseItem> allItems = getAllItemsFromAllInventories();
            LinkedList<BaseItem> allWeapons = new LinkedList<>();
            
            for (int i = 0; i < allItems.size(); i++) {
                if( allItems.get(i).getItemType() == ItemType.Weapon )
                    allWeapons.add(allItems.get(i));
            }
            
            return allWeapons;
        }
        
        public LinkedList<String[]> getAllWeaponsFromAllInventoriesString()
        {
            LinkedList<String[]> bigString = new LinkedList<>();
            LinkedList<BaseItem> allWeapons = getAllWeaponsFromAllInventories();
            for (int i = 0; i < allWeapons.size(); i++) {
                BaseItemWeapon item = (BaseItemWeapon)allWeapons.get(i);
                bigString.add( new String[]{item.getName(), item.getDamage()+"", item.getDescription()});
            }
            
            return bigString;
        }
        
        public LinkedList<BaseItem> getAllArmorFromAllInventories()
        {
            LinkedList<BaseItem> allItems = getAllItemsFromAllInventories();
            LinkedList<BaseItem> allArmor = new LinkedList<>();
            
            for (int i = 0; i < allItems.size(); i++) {
                if( allItems.get(i).getItemType() == ItemType.Armor )
                    allArmor.add(allItems.get(i));
            }
            
            return allArmor;
        }
        
        public LinkedList<String[]> getAllArmorFromAllInventoriesString()
        {
            LinkedList<String[]> bigString = new LinkedList<>();
            LinkedList<BaseItem> allArmor = getAllArmorFromAllInventories();
            
            for (int i = 0; i < allArmor.size(); i++) {
                BaseItemArmor item = (BaseItemArmor)allArmor.get(i);
                bigString.add(new String[]{item.getName(), item.getDeffence()+ "", item.getDescription()});
            }
            
            return bigString;
        }
        
        public LinkedList<BaseItem> getAllGeneralItemsFromAllInventories()
        {
            LinkedList<BaseItem> allItems = getAllItemsFromAllInventories();
            LinkedList<BaseItem> allGeneralItems = new LinkedList<>();
            
            for (int i = 0; i < allItems.size(); i++) {
                if( allItems.get(i).getItemType() == ItemType.GeneralItem )
                    allGeneralItems.add(allItems.get(i));
            }
            
            return allGeneralItems;
        }
        
        public LinkedList<String[]> getAllGeneralItemsFromAllInventoriesString()
        {
            LinkedList<String[]> bigString = new LinkedList<>();
            LinkedList<BaseItem> allGeneralItems = getAllGeneralItemsFromAllInventories();
            
            for (int i = 0; i < allGeneralItems.size(); i++) {
                BaseItem item = (BaseItem)allGeneralItems.get(i);
                bigString.add(new String[]{item.getName(), item.getDescription()});
            }
            
            return bigString;
        }
        
        public void viewItems()
        {
            LinkedList<BaseItem> all = getAllItemsFromAllInventories();
            
            LinkedList<BaseItem> weapon = new LinkedList<>();
            LinkedList<BaseItem> armor = new LinkedList<>();
            LinkedList<BaseItem> items = new LinkedList<>();
            
            for (int i = 0; i < all.size(); i++) {
                switch( all.get(i).getItemType() )
                {
                    case Weapon:
                        weapon.add( all.get(i) );
                        break;
                    case Armor:
                        armor.add( all.get(i) );
                        break;
                    case GeneralItem:
                    case Potion:
                        items.add( all.get(i) );
                        break;
                }
                
                
            }
        }
}

package src;

//package src;

import java.util.*;

public class Inventory
{
        //Actual inventories where everything is stored.
	LinkedList<Weapons> weapons;
	LinkedList<Armor> armor;
	LinkedList<Item> items;
	
	Player player;
	
        //Game Engine dependent :libraries"
	GameEvent gameEvent;
	UiEvent uiEvent;
	InteractionEvent interactionEvent;

	//Current state within inventory/store. Both use same names.
	StoreState tab;

        //Initiates new inventory
	public Inventory( Player player, GameEvent gameEvent, UiEvent uiEvent, InteractionEvent interactionEvent )
	{
		this.player = player;
		
		this.gameEvent = gameEvent;
		this.uiEvent = uiEvent;
		this.interactionEvent = interactionEvent;
		
		weapons = new LinkedList();
		armor = new LinkedList();
		items = new LinkedList();
	}

	public LinkedList<Weapons> getWeapons()
	{
		return weapons;
	}
	
        //Gets a list of weapons to be presented in a string. 
	public LinkedList<String []> getWeaponsString()
	{
		LinkedList<String []> temp = new LinkedList<String[]>();
		for( int i = 0; i < weapons.size(); i++)
		{
			temp.add( new String[]{ weapons.get(i).getName(), weapons.get(i).getCost() + "", weapons.get(i).getAttack() + "", weapons.get(i).getHandsRequired() + "", weapons.get(i).getDescription() });     
		}
		
		return temp;
	}

	public LinkedList<Armor> getArmor()
	{
		return armor;
	}
	
        //Gets a list of armor to be presented in a string
	public LinkedList<String []> getArmorString()
	{
		LinkedList<String []> temp = new LinkedList<String[]>();
		for( int i = 0; i < armor.size(); i++)
		{
			temp.add( new String[]{ armor.get(i).getName(), armor.get(i).getCost() + "", armor.get(i).getDeffence() + "", armor.get(i).getDescription() });     
		}

		return temp;
	}

	public LinkedList<Item> getItems()
	{
		return items;
	}
	
        //Gets a list of items to be presented in a string
	public LinkedList<String []> getItemsString()
	{
		LinkedList<String []> temp = new LinkedList<String[]>();
		for( int i = 0; i < items.size(); i++)
		{
			temp.add( new String[]{ items.get(i).getName(), items.get(i).getCost() + "", armor.get(i).getDescription() });     
		}

		return temp;
	}

        //Views the inventory.
	public void view()
	{
            //Get current tab that is in
            tab = StoreState.WeaponsTab;
            int choice;
            String header;
            String [] endOptions;

            //Loop repeats until player leaves inventory
            while( true )
                switch( tab )
                {
                        //TODO: Add more information to inventory
                        //Displayes item in weapons inventory tab, handles logic for menu navigation.
                        case WeaponsTab:
                                header = "<Weapon> Armor Items\tYour money: $" + player.getMoney();
                                String [] weaponsArray = new String[weapons.size()];
                                for(int i = 0; i < weapons.size(); i++){
                                        weaponsArray[i] = weapons.get(i).getName() + "\t" + weapons.get(i).getDescription();
                                }
                                endOptions = new String[]{
                                        "Tab left",
                                        "Tab Right",
                                        "Leave"
                                };

                                choice = interactionEvent.getOptionInput( header, weapons, endOptions, 1 );

                                //Determines if selection is within weapon array range, if not then selection is menu navigation.
                                if( choice >= weaponsArray.length )
                                    choice -= weaponsArray.length;
                                    if( choice == 1 )
                                            tab = tabLeft( tab );
                                    else if( choice == 2 )
                                            tab = tabRight( tab );
                                    else if( choice == 3 )
                                        return;
                                else
                                        viewItem( weapons.get( choice ) );
                                break;

                        //Displayes item in Armor inventory tab, handles logic for menu navigation.
                        case ArmorTab:
                                header = "Weapon <Armor> Items\tYour money: $" + player.getMoney();
                                String [] 	armorArray = new String[armor.size()];

                                for(int i = 0; i < armor.size(); i++){
                                        armorArray[i] = armor.get(i).getName() + "\t" + armor.get(i).getDescription();
                                }
                                endOptions = new String[]{
                                        "Tab left",
                                        "Tab Right",
                                        "Leave"
                                };

                                choice = interactionEvent.getOptionInput( header, 1, armor, endOptions);

                                //Determines if selection is within armor array range, if not then selection is menu navigation.
                                if( choice > armorArray.length )
                                    choice -= armorArray.length;
                                    if( choice == 1 )
                                            tab = tabLeft( tab );
                                    else if( choice == 2 )
                                            tab = tabRight( tab );
                                    else if( choice == 3 )
                                        return;
                                else
                                        viewItem( weapons.get( choice ) );
                                break;

                        case ItemsTab:
                                header = "Weapon Armor <Items>\tYour money: $" + player.getMoney();
                                String [] 	itemsArray = new String[items.size()];

                                for(int i = 0; i < items.size(); i++){
                                        itemsArray[i] = items.get(i).getName() + "\t" + items.get(i).getDescription();
                                }

                                endOptions = new String[]{
                                        "Tab left",
                                        "Tab Right",
                                        "Leave"
                                };

                                choice = interactionEvent.getOptionInput( header, items, 1, endOptions );

                                //Determines if selection is within item array range, if not then selection is menu navigation.
                                if( choice > itemsArray.length )
                                    choice -= itemsArray.length;
                                    if( choice == 1 )
                                            tab = tabLeft( tab );
                                    else if( choice == 2 )
                                            tab = tabRight( tab );
                                    else if( choice == 3 )
                                        return;
                                else
                                        viewItem( weapons.get( choice ) );
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

        //View a specific weapon
	private void viewItem(Weapons weapon)
	{
		String temp = "Name: " + weapon.getName()
			+ "\nAttack: " + weapon.getAttack()
			+ "\nDescription: " + weapon.getDescription();
		
		switch( interactionEvent.getOptionInput(temp, new String[]{"Equip", "Drop", "exit"}) )
		{
			case 1:
				player.equip( weapon );
				uiEvent.printWithPause( weapon.name() + " is equiped!\nAttack: " + (player.getAttack() + weapon.getAttack()));
				break;
			case 2:
				this.weapons.remove( weapon );
				break;
			case 3:
				return;
		}
	}

        //View a specific armor
	private void viewItem(Armor armor)
	{
		String temp = "Name: " + armor.getName()
			+ "\nAttack: " + armor.getDeffence()
			+ "\nDescription: " + armor.getDescription();

		switch( interactionEvent.getOptionInput(temp, new String[]{"Equip", "Drop", "exit"}) )
		{
			case 1:
				player.equip( armor );
				uiEvent.printWithPause( armor.name() + " is equiped!\nAttack: " + (player.getAttack() + armor.getDeffence()));
				break;
			case 2:
				this.armor.remove( armor );
				break;
			case 3:
				return;
		}
	}

        //View a specific item
	private void viewItem(Item item)
	{
		String temp = "Name: " + item.getName()
			+ "\nAttack: " + item.getEffect()
			+ "\nDescription: " + item.getDescription();

		switch( interactionEvent.getOptionInput(temp, new String[]{"use", "Drop", "exit"}) )
		{
			case 1:
				player.useItem( item );
				uiEvent.printWithPause( "used " + item.getName() );
				break;
			case 2:this.items.remove( item );
				break;
			case 3:
				return;
		}
	}
	
	

	public void addItem(Weapons weapon)
	{
		weapons.add( weapon );
		uiEvent.printWithPause( weapon.name() + " added to your inventory!");
	}

	public void addItem(Armor armor)
	{
		this.armor.add( armor );
		uiEvent.printWithPause( armor.name() + " added to your inventory!");
	}

	public void removeWeapon(int index)
	{
		weapons.remove(index);
	}

	public void removeArmor(int index)
	{
		armor.remove(index);
	}

	public void removeItem(int index)
	{
		items.remove(index);
	}
	
	public Weapons getWeapon( int index )
	{
		if( index >= 0)
			return weapons.get( index );
			return null;
	}

	public Armor getArmor( int index )
	{
		return armor.get( index );
	}

	public Item getItem( int index )
	{
		return items.get( index );
	}
}
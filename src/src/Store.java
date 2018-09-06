package src;

//package src;

import java.io.*;
import java.util.*;

public class Store
{
	PlayerOld player;
	GameEvent gameEvent;
	UiEvent uiEvent;
	InteractionEvent interactionEvent;
	Scanner scanner;

	StoreState storeState;
	StoreState lastState;

	String[] endOptions;
	
	boolean forceDebug;

	public Store(PlayerOld player, GameEvent gameEvent, UiEvent uiEvent, InteractionEvent interactionEvent)
	{
		this.player = player;
		this.gameEvent = gameEvent;
		this.uiEvent = uiEvent;
		this.interactionEvent = interactionEvent;

		storeState = storeState.Welcome;
		lastState = storeState.Welcome;
	}

	public void startStore(boolean forceDebug)
	{
		this.forceDebug = forceDebug;
//		try
//		{
//			//scanner = new Scanner(new File(StoryLine.store1.getFileLocation()));
//			update();
//		}
//		catch (FileNotFoundException e)
//		{
//			e.printStackTrace();
//			int h = 4 / 0;
//			return;
//		}

		update();
	}

	private void update()
	{

		switch(storeState)
		{
			case Welcome:
				uiEvent.printWithPause("Welcome to my store");
				if(forceDebug)
				{
					player.buyItem(Weapons.Mace);
					player.buyItem(Armor.Cloth);
				}
				switch(interactionEvent.getOptionInput("What would you like to do?", new String[]{"Buy", "Sell", "Leave"}))
				{
					case 1:
						lastState = storeState;
						this.storeState = storeState.Buying;
						break;
					case 2:
						lastState = storeState;
						this.storeState = storeState.Selling;
						break;
					case 3: //bake
						lastState = storeState;
						this.storeState = storeState.Leaving;
						break;
				}
				break;
			case Buying:
				buying();
				break;
			case Selling:
				selling();
				break;
			case Leaving:
				uiEvent.printWithPause("Good fucking job. You win the game.");
				this.storeState = null;
				break;
		}

		boolean temp = false;
		do
		{
			//temp = followScript(script);
		}while( temp );
	}

	private void buying()
	{
		StoreState tab = StoreState.WeaponsTab;
		LinkedList items = new LinkedList();
		LinkedList<String []> w;

		while(true)
		{
			String temp;
			int choice;

			switch(tab)
			{
				case WeaponsTab:
					temp = "<Weapons> Armor Items\tYour money: $" + player.getMoney();
					w  = new LinkedList<String[]>();
					
					w.add(new String [] { Weapons.Stick.getName(), Weapons.Stick.getCost() + "", Weapons.Stick.getAttack() + "",  Weapons.Stick.getHandsRequired() + "", Weapons.Stick.getDescription()});
					w.add(new String [] { Weapons.WoodenSword.getName(), Weapons.WoodenSword.getCost() + "", Weapons.WoodenSword.getAttack() + "", Weapons.WoodenSword.getHandsRequired() + "", Weapons.WoodenSword.getDescription()});
					w.add(new String [] { Weapons.Dagger.getName(), Weapons.Dagger.getCost() + "", Weapons.Dagger.getAttack() + "", Weapons.Dagger.getHandsRequired() + "", Weapons.Dagger.getDescription()});
					w.add(new String []	{ Weapons.ShortSword.getName(), Weapons.ShortSword.getCost() + "", Weapons.ShortSword.getAttack() + "", Weapons.ShortSword.getHandsRequired() + "", Weapons.ShortSword.getDescription()});
					w.add(new String []	{ Weapons.Broadsword.getName(), Weapons.Broadsword.getCost() + "", Weapons.Broadsword.getAttack() + "", Weapons.Broadsword.getHandsRequired() + "", Weapons.Broadsword.getDescription()});
					w.add(new String []	{ Weapons.Bow.getName(), Weapons.Bow.getCost() + "", Weapons.Bow.getAttack() + "", Weapons.Bow.getHandsRequired() + "", Weapons.Bow.getDescription()});
					w.add(new String []	{ Weapons.Staff.getName(), Weapons.Staff.getCost() + "", Weapons.Staff.getAttack() + "", Weapons.Staff.getHandsRequired() + "", Weapons.Staff.getDescription()});
					w.add(new String []	{ Weapons.Mace.getName(), Weapons.Mace.getCost() + "", Weapons.Mace.getAttack() + "", Weapons.Mace.getHandsRequired() + "", Weapons.Mace.getDescription()});
					w.add(new String []	{ Weapons.Hammer.getName(), Weapons.Hammer.getCost() + "", Weapons.Hammer.getAttack() + "", Weapons.Hammer.getHandsRequired() + "", Weapons.Hammer.getDescription()});
					w.add(new String []	{ Weapons.Crossbow.getName(), Weapons.Crossbow.getCost() + "", Weapons.Crossbow.getAttack() + "", Weapons.Crossbow.getHandsRequired() + "", Weapons.Crossbow.getDescription()});
					w.add(new String []	{ Weapons.Greatsword.getName(), Weapons.Greatsword.getCost() + "", Weapons.Greatsword.getAttack() + "", Weapons.Greatsword.getHandsRequired() + "", Weapons.Greatsword.getDescription()});
					endOptions = new String[]{
						"View Inventory",
						"Tab left",
						"Tab Right",
						"Leave"
					};

					choice = interactionEvent.getOptionInput(temp, w, endOptions, null, 'a');
					System.out.println(choice);
					if(choice == w.size() + endOptions.length - 3)
					{
						player.viewInventory();
						storeState = lastState;
					}
					else if(choice == w.size() + endOptions.length - 2)
						tab = tabLeft(tab);
					else if(choice == w.size() + endOptions.length - 1)
						tab = tabRight(tab);
					else if(choice == w.size() + endOptions.length - 0)
					{
						System.out.println("gfhnhff" + choice);
						storeState = StoreState.Welcome;
						return;
					}
					else	
						switch(choice)
						{
							case 1:	if(!player.buyItem(Weapons.Stick))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 2:	if(!player.buyItem(Weapons.WoodenSword))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 3:	if(!player.buyItem(Weapons.Dagger))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 4:	if(!player.buyItem(Weapons.ShortSword))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;	
							case 5:	if(!player.buyItem(Weapons.Broadsword))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 6:	if(!player.buyItem(Weapons.Bow))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 7:	if(!player.buyItem(Weapons.Staff))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 8:	if(!player.buyItem(Weapons.Mace))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 9:	if(!player.buyItem(Weapons.Hammer))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 10:	if(!player.buyItem(Weapons.Crossbow))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 11:	if(!player.buyItem(Weapons.Greatsword))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;

						}
					break;
				case ArmorTab:
					temp = "Weapons <Armor> Items\tYour money: $" + player.getMoney();
					w  = new LinkedList<String[]>();
					w.add( new String[]{ Armor.Leaf.getName(), Armor.Leaf.getCost() + "", Armor.Leaf.getDeffence() + "", Armor.Leaf.getDescription() } );
					w.add( new String[]{ Armor.Cloth.getName(), Armor.Cloth.getCost() + "", Armor.Cloth.getDeffence() + "", Armor.Cloth.getDescription() } );
					endOptions = new String[]
					{
						"View Inventory",
						"Tab left",
						"Tab Right",
						"Leave"
					}; 
					choice = interactionEvent.getOptionInput(temp, w, endOptions, new int[]{1,2,3}, 'd');
					System.out.println(choice);
					if(choice == w.size() + endOptions.length - 3)
						player.viewInventory();
					else if(choice == w.size() + endOptions.length - 2)
						tab = tabLeft(tab);
					else if(choice == w.size() + endOptions.length - 1)
						tab = tabRight(tab);
					else if(choice == w.size() + endOptions.length )
					{
						storeState = StoreState.Welcome;
						return;
					}
					else	
						switch(choice)
						{
							case 1:	if(!player.buyItem(Armor.Leaf))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 2:	if(!player.buyItem(Armor.Cloth))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;


						}
					break;
				case ItemsTab:
					temp = "Weapons Armor <Items>\tYour money: $" + player.getMoney();
					w  = new LinkedList<String[]>();
					endOptions = new String[]{
						"View Inventory",
						"Tab left",
						"Tab Right",
						"Leave"
					};
					choice = interactionEvent.getOptionInput(temp, w, endOptions, null, 'a');
					System.out.println(choice);
					if(choice == w.size() + endOptions.length - 3)
						player.viewInventory();
					else if(choice == w.size() + endOptions.length - 2)
						tab = tabLeft(tab);
					else if(choice == w.size() + endOptions.length - 1)
						tab = tabRight(tab);
					else if(choice == w.size() + endOptions.length)
					{
						storeState = StoreState.Welcome;
						return;
					}
					else	
						switch(choice)
						{
							case 1:	if(!player.buyItem(Armor.Leaf))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;
							case 2:	if(!player.buyItem(Armor.Cloth))
								{	uiEvent.printWithPause("You do not have enough money for this item.");	}	break;


						}
					break;
			}
		}
	}

	private void selling()
	{
		Inventory inventory = player.getInventory();

		LinkedList<Weapons> weapons;
		LinkedList<Armor> armor;
		LinkedList<Item> items;

		LinkedList<String []> w;
		StoreState tab = StoreState.WeaponsTab;
		String temp;
		int choice;
		String [] endItems;
		int arraySize;

		while(true)
		{
			weapons = inventory.getWeapons();
			armor = inventory.getArmor();
			items = inventory.getItems();
			switch(tab)
			{
				case WeaponsTab:
					temp = "<Weapon> Armor Items\tYour money: $" + player.getMoney();
					w  = player.getInventory().getWeaponsString();
					
					endOptions = new String[]{
						"Tab left",
						"Tab Right",
						"Leave"
					};
					//choice = -1;
					choice = interactionEvent.getOptionInput(temp, w, endOptions, null, 'b');
					
					choice--;
					//System.out.println(choice + " == " + weaponsArray[choice]);
					if(choice == w.size() + endOptions.length - 3)
						tab = tabLeft(tab);
					else if(choice == w.size() + endOptions.length - 2)
						tab = tabRight(tab);
					else if(choice == w.size() + endOptions.length - 1)
					{
						storeState = StoreState.Welcome;
						return;
					}
					if(choice < w.size() )
					{
						int confirm = interactionEvent.getOptionInput("Are you sure?", new String[]{"yes", "no"});
						if(--confirm == 0)
							player.sellWeapon(choice);
					}
					break;
				case ArmorTab:
					temp = "Weapon <Armor> Items\tYour money: $" + player.getMoney();
					w  = player.getInventory().getArmorString();
					endItems = new String[]{
						"Tab left",
						"Tab Right",
						"Leave"
					};
					choice = interactionEvent.getOptionInput(temp, w, endOptions, null, 'b');
					choice--;
					//System.out.println(choice + " == " + armorArray[choice]);
					if(choice == w.size() + endOptions.length - 3)
						tab = tabLeft(tab);
					else if(choice == w.size() + endOptions.length - 2)
						tab = tabRight(tab);
					else if(choice == w.size() + endOptions.length - 1)
					{
						storeState = StoreState.Welcome;
						return;
					}
					if(choice < armor.size())
					{
						int confirm = interactionEvent.getOptionInput("Are you sure?", new String[]{"yes", "no"});
						if(--confirm == 0)
							player.sellArmor(choice);
					}
					break;
				case ItemsTab:
					temp = "Weapon Armor <Items>\tYour money: $" + player.getMoney();
					w = player.getInventory().getItemsString();
					endOptions = new String[]{
						"Tab left",
						"Tab Right",
						"Leave"
					};
					choice = interactionEvent.getOptionInput(temp, w, endOptions, null, 'b');
					choice--;
					//System.out.println(choice + " == " + itemsArray[choice]);
					if(choice == w.size() + endOptions.length - 3)
						tab = tabLeft(tab);
					else if(choice == w.size() + endOptions.length - 2)
						tab = tabRight(tab);
					else if(choice == w.size() + endOptions.length - 1)
					{
						storeState = StoreState.Welcome;
						return;
					}
					if(choice < items.size())
					{
						int confirm = interactionEvent.getOptionInput("Are you sure?", new String[]{"yes", "no"});
						if(--confirm == 0)
							player.sellItem(choice);
					}
					break;
			}
		}
	}



	private StoreState tabRight(StoreState tab)
	{
		switch(tab)
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
		switch(tab)
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

	public boolean followScript(Scanner script)
	{
		if(script.hasNext())
			switch(script.next())
			{

			}
		return true;
	}
}



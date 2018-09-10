package src;

//package src;
import IO.IO;
import IO.OutputType;
import Item.BaseItem;
import Item.BaseItemArmor;
import Item.BaseItemWeapon;
import Item.Weapons.WeaponStick;
import Item.Weapons.Weapons;
import Player.Player;
import java.util.*;

public class Store
{
	Player player;
	GameEvent gameEvent;
	UiEvent uiEvent;
	IO interactionEvent;
	Scanner scanner;

	StoreState storeState;
	StoreState lastState;

	String[] endOptions;
	
	boolean forceDebug;

        GlobalInventory gi;
        
	public Store(Player player, GameEvent gameEvent, UiEvent uiEvent, IO interactionEvent)
	{
		this.player = player;
		this.gameEvent = gameEvent;
		this.uiEvent = uiEvent;
		this.interactionEvent = interactionEvent;

		storeState = storeState.Welcome;
		lastState = storeState.Welcome;
                
                gi = player.getGlobalInventory();
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
                                    BaseItem item = new WeaponStick();
                                    
					gi.buyWeapon(item);
        				//gi.buyItem(Armor.Cloth);
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
		LinkedList<String[]> outputArray;
                String [] extraOptions;
		while(true)
		{
			String temp;
			int choice;

			switch(tab)
			{
				case WeaponsTab:
					temp = "<Weapons> Armor Items\tYour money: $" + gi.getMoney();
					outputArray  = new LinkedList<>();
					
                                        //Working
                                        LinkedList<BaseItem> allWeapons = new Weapons().getAll();
                                        
                                        for (int i = 0; i < allWeapons.size(); i++) {
                                            outputArray.add( ((BaseItemWeapon)allWeapons.get(i)).getAllInfoForSaleArray() );
                                            //Debug:
//                                            for (int j = 0; j < outputArray.get(0).length; j++) {
//                                                System.out.println(outputArray.get(0)[j]);
//                                                
//                                            }
                                        }
                                        extraOptions = new String[]{
                                            "View Inventory",
                                            "Tab Left",
                                            "Tab Right",
                                            "Exit"};
                                        
                                        choice = interactionEvent.printOptoins(temp, outputArray, OutputType.StoreOutput, extraOptions);
					System.out.println("List size: " + outputArray.size() + "\nChoice: " + choice);
					if(choice == outputArray.size() + 1)
					{
                                                //TODO: Determine if this needs to be global inventory, local inventory, or both.
						player.getCharacterInventory().showInventoy();
						storeState = lastState;
					}
					else if(choice == outputArray.size() + 2)
						tab = tabLeft(tab);
					else if(choice == outputArray.size() + 3)
						tab = tabRight(tab);
					else if(choice == outputArray.size() + 4)
					{
						System.out.println("gfhnhff" + choice);
						storeState = StoreState.Welcome;
						return;
					}
					else
                                            if(gi.getMoney() < allWeapons.get(choice).getCost() )
                                                uiEvent.printWithPause("You do not have enough money for this item.");
                                    break;
				case ArmorTab:
					temp = "Weapons <Armor> Items\tYour money: $" + gi.getMoney();
					outputArray  = new LinkedList<String[]>();
                                        LinkedList<BaseItem> allArmor = new LinkedList<BaseItem>();
                                        
                                        for (int i = 0; i < allArmor.size(); i++) {
                                            outputArray.add( ((BaseItemArmor)allArmor.get(i)).getAllInfoForSaleArray() );
                                        }
                                        extraOptions = new String[]{
                                            "View Inventory",
                                            "Tab Left",
                                            "Tab Right",
                                            "Exit"};
                                        
                                        choice = interactionEvent.printOptoins(temp, outputArray, OutputType.StoreOutput, extraOptions);
                                        
					System.out.println(choice);
					if(choice == outputArray.size() + 1)
						gi.view();
					else if(choice == outputArray.size() + 2)
						tab = tabLeft(tab);
					else if(choice == outputArray.size() + 3)
						tab = tabRight(tab);
					else if(choice == outputArray.size() + 4 )
					{
						storeState = StoreState.Welcome;
						return;
					}
					else
                                            if(gi.getMoney() < allArmor.get(choice).getCost() )
                                                uiEvent.printWithPause("You do not have enough money for this item.");
                                    break;
				case ItemsTab:
					temp = "Weapons Armor <Items>\tYour money: $" + gi.getMoney();
					outputArray  = new LinkedList<String[]>();
                                        
                                        extraOptions = new String[]{
                                            "View Inventory",
                                            "Tab Left",
                                            "Tab Right",
                                            "Exit"};
                                        
                                        choice = interactionEvent.printOptoins(temp, outputArray, OutputType.StoreOutput, extraOptions);
                                        
					System.out.println(choice);
					if(choice == outputArray.size() + 1)
						gi.view();
					else if(choice == outputArray.size() + 2)
						tab = tabLeft(tab);
					else if(choice == outputArray.size() + 3)
						tab = tabRight(tab);
					else if(choice == outputArray.size() + 4)
					{
						storeState = StoreState.Welcome;
						return;
					}
					else
                                        
                                    break;
			}
		}
	}

	private void selling()
	{
		GlobalInventory inventory = gi;

		LinkedList<BaseItem> weapons;
		LinkedList<BaseItem> armor;
		LinkedList<BaseItem> items;

		LinkedList<String[]> w;
		StoreState tab = StoreState.WeaponsTab;
		String temp;
		int choice;
		String [] endItems;
		int arraySize;

		while(true)
		{
			weapons = gi.getWeapons();
			armor = inventory.getArmor();
			items = inventory.getItems();
			switch(tab)
			{
				case WeaponsTab:
					temp = "<Weapon> Armor Items\tYour money: $" + gi.getMoney();
					w  = gi.getAllWeaponsFromAllInventoriesString();
					
					endOptions = new String[]{
						"Tab left",
						"Tab Right",
						"Leave"
					};
					//choice = -1;
                                        choice = interactionEvent.printOptions(temp, w, OutputType.SellingOutput);
					
					choice--;
					System.out.println(choice + " == " + weapons.get(choice));
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
                                                    gi.sellWeapon(choice);
                                                    
					}
					break;
				case ArmorTab:
					temp = "Weapon <Armor> Items\tYour money: $" + gi.getMoney();
					w  = gi.getAllArmorFromAllInventoriesString();
					endItems = new String[]{
						"Tab left",
						"Tab Right",
						"Leave"
					};
                                        
                                        choice = interactionEvent.printOptions(temp, w, OutputType.SellingOutput);
                                        
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
							gi.sellArmor(choice);
					}
					break;
				case ItemsTab:
					temp = "Weapon Armor <Items>\tYour money: $" + gi.getMoney();
					w = gi.getAllGeneralItemsFromAllInventoriesString();
					endOptions = new String[]{
						"Tab left",
						"Tab Right",
						"Leave"
					};
                                        
                                        choice = interactionEvent.printOptions(temp, w, OutputType.SellingOutput);
                                        
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
							gi.sellItem(choice);
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



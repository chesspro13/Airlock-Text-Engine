package src;

//package src;

import java.util.*;

public class Player
{
	private GameEvent gameEvent;
	private UiEvent uiEvent;
	private InteractionEvent interactionEvent;
	
	private String name;
	private boolean isMale;
	private PlayerRole playerRole;
	private Inventory inventory;
	
	private int money;
	private int maxHealth;
	private int health;
	private int maxMana;
	private int mana;
	private int attack;
	 
	
	public Player(String name, boolean isMale, PlayerRole playerRole,
			GameEvent gameEvent, UiEvent uiEvent, InteractionEvent interactionEvent)
	{
		this.gameEvent = gameEvent;
		this.uiEvent = uiEvent;
		this.interactionEvent = interactionEvent;
		
		this.name = name;
		this.isMale = isMale;
		this.playerRole = playerRole;
		
		this.inventory = new Inventory( this, gameEvent, uiEvent, interactionEvent);
		
		this.money = 0;
		maxHealth = playerRole.getBaseHealth();
		health = playerRole.getBaseHealth();
		maxMana = playerRole.getBaseMana();
		mana = playerRole.getBaseMana();
	}

	public void useItem(Item item)
	{
		// TODO: Implement this method
	}

	public Inventory getInventory()
	{
		return inventory;
	}

	public void equip(Weapons weapon)
	{
		// TODO: Implement this method
	}

	public void equip(Armor armor)
	{
		// TODO: Implement this method
	}

	public void viewInventory()
	{
		inventory.view();
	}

	public boolean buyItem(Weapons weapon)
	{
		if( this.money - weapon.getCost() < 0 )
		{
			uiEvent.printWithPause("You cannot afford this item.");
			return false;
		}
		
		this.money -= weapon.getCost();
		uiEvent.printWithPause("You bought a " + weapon.getName() + "!");
		inventory.addItem( weapon );
		return true;
	}

	public boolean sellWeapon(int index)
	{
		int cost = inventory.getWeapon( index ).getCost();
		uiEvent.printWithPause("You got $" + cost + "!");
		giveMoney(cost, uiEvent);
		inventory.removeWeapon( index );
		return true;
	}

	public boolean sellArmor(int index)
	{
		int cost = inventory.getArmor( index ).getCost();
		uiEvent.printWithPause("You got $" + cost + "!");
		giveMoney(cost, uiEvent);
		inventory.removeArmor( index );
		return true;
	}

	public boolean sellItem(int index)
	{
		int cost = inventory.getWeapon( index ).getCost();
		uiEvent.printWithPause("You got $" + cost + "!");
		giveMoney(cost, uiEvent);
		inventory.removeWeapon( index );
		return true;
	}

	public boolean buyItem(Armor armor)
	{
		if( this.money - armor.getCost() < 0 )
		{
			uiEvent.printWithPause("You cannot afford this item.");
			return false;
		}

		this.money -= armor.getCost();
		uiEvent.printWithPause("You bought a " + armor.getName() + "!");
		inventory.addItem( armor );
		return true;
	}
	
	public void giveMoney(int money, UiEvent uiEvent)
	{
		this.money += money;
		uiEvent.printWithPause( "Got $" + money + "!");
	}

	public String getName()
	{
		return name;
	}
	
	public String getGender()
	{
		if( isMale )
			return "Boy";
		else
			return "Girl";
	}
	
	public boolean getIsMale()
	{
		return this.isMale;
	}
	
	public PlayerRole getPlayerRole()
	{
		return playerRole;
	}
	
	public String getPlayerRoleName()
	{
		return this.playerRole.getRoleName();
	}
	
	public int getMoney()
	{
		return this.money;
	}

	public int getMaxHealth()
	{
		return this.maxHealth;
	}

	public int getHealth()
	{
		return health;
	}

	public int getMaxMana()
	{
		return this.maxMana;
	}

	public int getMana()
	{
		return mana;
	}
	
	public int getAttack()
	{
		return attack;
	}
}

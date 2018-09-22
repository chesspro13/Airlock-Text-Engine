package src;

//package src;

public enum GameItems
{
//	0 = name
//	1 = cost
//	2 = attack
//	3 = hands
//	4 = description

	Stick("Stick", 50, 2, 1, "Just a random old stick someone found on the ground"),
	WoodenSword("Wooden Sword", 150, 12, 1, "A crappy wooden sword put together by kids"),
	Dagger("Dagger", 250, 15, 1, "Looks like it has seen its fair share of backs."),
	ShortSword("Short Sword", 300, 17, 1, "A decent sword that should so the trick"),
	Broadsword("Broadsword", 350, 21, 2, "A nice heavy sword that will do doing great damage"),
	Bow("Bow", 350, 18, 2, "A nice bow that has seen a few battles."),
	Staff("Staff",  400, 24, 2, "a wooden staff made from the tree out back."),
	Mace("Mace", 400, 25, 1, "An iron mace forged by that guy that is always drunk"),
	Hammer("Hammer", 500, 30, 2 , "Used for enamies heads and watermelon. Don't judge."),
	Crossbow("Crossbow", 550, 32 ,2, "Closest thing you will find to a gun here."),
	Greatsword("Greatsword", 700, 35, 2, "Epic.");

	private final String name;
	private final int cost;
	private final int attack;
	private final int handsRequired;
	private final String description;

	GameItems(String name, int cost, int attack, int handsRrquired, String description)
	{
		this.name = name;
		this.cost = cost;
		this.attack = attack;
		this.handsRequired = handsRrquired;
		this.description = description;
	}

	public String getName()
	{
		return name;
	}

	public int getCost()
	{
		return cost;
	}

	public int getAttack()
	{
		return attack;
	}

	public int getHandsRequired()
	{
		return handsRequired;
	}

	public String getDescription()
	{
		return description;
	}
}

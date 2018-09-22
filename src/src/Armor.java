package src;

public enum Armor
{
//	0 = name
//	1 = cost
//	2 = Deffence
//	4 = description

	Leaf("Leaf", 50, 1, "Natures clothes"),
	Cloth("Cloth", 75, 3, "Normal clothes stollen from a kid");

	private final String name;
	private final int cost;
	private final int deffence;
	private final String description;

	Armor(String name, int cost, int deffence, String description)
	{
		this.name = name;
		this.cost = cost;
		this.deffence = deffence;
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

	public int getDeffence()
	{
		return deffence;
	}
	
	public String getDescription()
	{
		return description;
	}
}

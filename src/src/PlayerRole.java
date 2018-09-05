package src;

//package src;
        
public enum PlayerRole
{
//		0 = role name
//		1 = health
//		2 = mana
//		3 = physical attack
//		4 = physical defence
//		5 = magic attack
//		6 = magic defence
//		7 = agility
//		8 = evasion
	
	Fighter("Fighter", "A fighter liked to fight", 40, 30, 15, 20, 7, 14, 12, 10),
	Magician("Magician", "A magician likes to manic", 35, 50, 8, 16, 16, 21, 13, 12),
	Theif("Theif", "A theit liked to steal", 33, 40, 13, 21, 12, 18, 19, 17),
	Healer("Healer", "A healer likes to heal", 30, 50, 8, 17, 17, 20, 15, 15);
	
	private final String roleName;
	private final String roleDescription;
	private final int baseHealth;
	private final int baseMana;
	private final int basePhysicalAttack;
	private final int baseMagicAttack;
	private final int basePhysicalDefence;
	private final int baseMagicdefence;
	private final int baseAgility;
	private final int baseEvasion;
	
	PlayerRole( String roleName, String roleDescription, int baseHealth, int baseMana, int basePhysicalAttack,
            int baseMagicAttack, int basePhysicalDefence, int baseMagicdefence, int baseAgility, int baseEvasion)
	{
            this.roleName = roleName;
            this.roleDescription = roleDescription;
            this.baseHealth = baseHealth;
            this.baseMana = baseMana;
            this.basePhysicalAttack = basePhysicalAttack;
            this.baseMagicAttack = baseMagicAttack;
            this.basePhysicalDefence = basePhysicalDefence;
            this.baseMagicdefence = baseMagicdefence;
            this.baseAgility = baseAgility;
            this.baseEvasion = baseEvasion;
	}
	
	public String getRoleName()
	{
            return this.roleName;
	}
	
	public String gerRoleDescription()
	{
            return this.roleDescription;
	}

	public int getBaseHealth()
	{
            return baseHealth;
	}

	public int getBaseMana()
	{
            return baseMana;
	}

	public int getBasePhysicalAttack()
	{
            return basePhysicalAttack;
	}

	public int getBaseMagicAttack()
	{
            return baseMagicAttack;
	}

	public int getBasePhysicalDefence()
	{
            return basePhysicalDefence;
	}

	public int getBaseMagicdefence()
	{
            return baseMagicdefence;
	}

	public int getBaseAgility()
	{
            return baseAgility;
	}

	public int getBaseEvasion()
	{
            return baseEvasion;
	}
}

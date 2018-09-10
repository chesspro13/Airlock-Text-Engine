package Combat;

import java.util.Random;

/**
 *
 * @author Chesspro13
 */
public class Attack {
    

    protected String name;
    
    protected int [] damageRange;
    
    protected String [] description;
    
    public Attack( String name, int [] damageRange, String [] description )
    {
        this.name = name;
        this.damageRange = damageRange;
        this.description = description;
    }
    
    public String getAttackName()
    {
        return name;
    }
    
    public int getDamage()
    {
        //TODO: Randomize the range of the damage and return 'random' range so attack is not always the same
        System.err.println("Attack.getDamage() is not implemented! Returning 0");
        return damageRange[0];
    }
    
    public String getAttackDescription()
    {
        //TODO: Randomize the range of the damage and return 'random' range so attack description is not always the same
        System.err.println("Attack.getAttackDescription() is not implemented! Returning 0");
        return description[0];
    }
    
}

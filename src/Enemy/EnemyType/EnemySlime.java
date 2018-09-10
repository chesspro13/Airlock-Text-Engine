package Enemy.EnemyType;

import Enemy.Enemy;
import Enemy.EnemyAttack;
import java.util.LinkedList;

/**
 *
 * @author Chesspro13
 */
public class EnemySlime extends Enemy {
    
    LinkedList<EnemyAttack> attacks;
    
    public EnemySlime()
    {
        this.name = "Slime";
        this.health = 20;
        
        this.AC = 10;
        
        this.str = 5;
        this.dex = 7;
        this.con = 8;
        this.intel = 10;
        this.wis = 7;
        this.cha = 2;
        
        attacks = new LinkedList<>();
    }
    
    public void generateAttacks()
    {
        System.err.println("EnemySlime.generateAttacks() is not implemented yet! Returned null!");
       // attacks.add(new EnemyAttack("Splash", 2, "Oh no, a slime splashed on you doing major damage"));
    }
    
}

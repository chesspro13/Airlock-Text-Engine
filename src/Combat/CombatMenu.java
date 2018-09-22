package Combat;

import Enemy.Enemy;
import java.util.LinkedList;

/**
 *
 * @author Chesspro13
 */
public class CombatMenu {

    //TODO: Create combat menu stuff
    private LinkedList<CombatPlayer> player;
    private LinkedList<Enemy> enemy;
    
    public CombatMenu( LinkedList<CombatPlayer> player, LinkedList<Enemy> enemy )
    {
        this.player = player;
        this.enemy = enemy;
    }
    
    public void playerTurn()
    {
        int round = 0;
        LinkedList<Attack> attacks;
        
        for( int i = 0; i < round; i++ )
        {
            attacks = player.get(i).getAttacks();
            System.out.print("Character: " + player.get(i).getName());
            //TODO: Print attacks with [] selector
            
            for (Attack attack : attacks) {
                System.out.println( "\t" + attack.toString());
            }
        }
    }
    
}

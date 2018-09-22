package Combat;

import Enemy.Enemy;
import Player.Player;
import java.util.LinkedList;

/**
 *
 * @author Chesspro13
 */
public class Combat {

    private CombatMenu combatMenu;
    
    private LinkedList<CombatPlayer> players;
    private LinkedList<Enemy> enemys;
    
    public Combat( LinkedList<Player> players, LinkedList<Enemy> enemys )
    {
        this.players = new LinkedList<>();
        this.enemys = enemys;
                
        for ( int i = 0; i < players.size(); i++ )
            this.players.add( new CombatPlayer( players.get(i) ) );
        
        combatMenu = new CombatMenu( this.players, enemys );
        
        combatMenu.playerTurn();
    }
    
    public void setCombatMenu()
    {
        
    }
    
}

package Combat;

import Player.Player;
import java.util.LinkedList;

/**
 *
 * @author Chesspro13
 */
public class CombatPlayer {
    
    private Player player;
    LinkedList<Attack> attacks;
    
    public CombatPlayer( Player player )
    {
        this.player = player;
    }
 
    public void setAttacks()
    {
        this.attacks = player.getAttacks();
    }
    
    public String getName()
    {
        return player.getName();
    }
    
    public LinkedList<Attack> getAttacks()
    {
        return player.getAttacks();
    }
}

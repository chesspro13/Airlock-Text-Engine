package Item.Potions.Health;

import Item.BaseItemPotion;

public class PotionHealth extends BaseItemPotion{
    
    public PotionHealth()
    {
        this.name = "Potion of Health";
        this.description = "Heals your fucking dumb ass";
        this.cost = 50;
        
        //TODO: Create script parsing to handle this
        this.effect = "Player Heal 50";
    }
    
}

package Item;

import Player.PlayerIdentifier;

public class BaseItemWeapon extends BaseItem{

    protected String type;
    protected int damage;
    protected int handed;
    
    protected PlayerIdentifier equippedBy;

    public PlayerIdentifier getEquippedBy() {
        return equippedBy;
    }

    public void setEquippedBy(PlayerIdentifier equippedBy) {
        this.equippedBy = equippedBy;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public int getHandsRequired()
    {
        return handed;
    }
    
    public String getAllInfoForSale()
    {
        return getName() + "/" + getCost() + "/" + getDamage() + "/" + getHandsRequired();
    }
    
    public String[] getAllInfoForSaleArray()
    {
        System.err.println("Getting name: " + this.getName());
        return new String[]{this.getName(), getCost()+"", getDamage()+"", getHandsRequired()+""};
    }
}

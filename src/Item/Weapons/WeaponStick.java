package Item.Weapons;

import Item.BaseItemWeapon;
import Item.ItemType;

public class WeaponStick extends BaseItemWeapon {

    public WeaponStick()
    {
        this.itemType = ItemType.Weapon;
        this.name = "Stick";
        this.cost = 50;
        this.damage = 2;
        this.handed = 1;
        this.description = "Just a random old stick someone found on the ground";
    } 
    
}

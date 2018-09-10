package Item.Weapons;

import Item.BaseItemWeapon;
import Item.ItemType;

public class WeaponWoodenSword extends BaseItemWeapon{
    
    public WeaponWoodenSword()
    {
        
        this.itemType = ItemType.Weapon;
        this.name = "Wooden Sword";
        this.cost = 150;
        this.damage = 12;
        this.handed = 1;
        this.description = "A crappy wooden sword put together by kids";
    }
    
}

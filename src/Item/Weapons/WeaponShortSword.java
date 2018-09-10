package Item.Weapons;

import Item.BaseItemWeapon;
import Item.ItemType;

public class WeaponShortSword  extends BaseItemWeapon {
    
    public WeaponShortSword()
    {
        this.itemType = ItemType.Weapon;
        this.name = "Short Sword";
        this.cost = 300;
        this.damage = 17;
        this.handed = 1;
        this.description = "A decent sword that should so the trick";
    }
    
}

package Item.Weapons;

import Item.BaseItemWeapon;
import Item.ItemType;

public class WeaponDagger extends BaseItemWeapon {
    
    public WeaponDagger()
    {
        this.itemType = ItemType.Weapon;
        this.name = "Dagger";
        this.cost = 250;
        this.damage = 15;
        this.handed = 1;
        this.description = "Looks like it has seen its fair share of backs.";
    }
}

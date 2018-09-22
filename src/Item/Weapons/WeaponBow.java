/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item.Weapons;

import Item.BaseItemWeapon;
import Item.ItemType;

/**
 *
 * @author Chesspro13
 */
public class WeaponBow extends BaseItemWeapon {
    
    public WeaponBow()
    {
        this.itemType = ItemType.Weapon;
        this.name = "Bow";
        this.cost = 350;
        this.damage = 18;
        this.handed = 2;
        this.description = "Watch out here comes my arrow, it flies super fast and kills everyone!";
    }
    
}

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
public class WeaponBroadsword extends BaseItemWeapon {
    
    public WeaponBroadsword()
    {
        this.itemType = ItemType.Weapon;
        this.name = "Short Sword";
        this.cost = 350;
        this.damage = 21;
        this.handed = 2;
        this.description = "A nice heavy sword that will do doing great damage";
    }
}

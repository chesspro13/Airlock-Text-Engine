package CharacterClasses;

import Item.BaseItem;
import Item.Potions.Health.PotionHealth;
import Item.Weapons.WeaponWoodenSword;

public class BaseFighterClass extends BaseClass{
        
    public BaseFighterClass()
    {
        characterClassType = Classes.Fighter;
        characterClassName = "Fighter";
        characterClassDescription = "Tough fighter guy...";
        
        strength = 16;
        dextarity = 9;
        constitiution = 15;
        inteligance = 13;
        wisdom = 11;
        charisma = 14;
        
        classItems = new BaseItem[]{new WeaponWoodenSword(), new PotionHealth()};
    }
}

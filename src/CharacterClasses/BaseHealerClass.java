package CharacterClasses;

import Item.BaseItem;
import Item.Potions.Health.PotionHealth;
import Item.Weapons.WeaponStick;

public class BaseHealerClass extends BaseClass{
    
    void BaseHealerClass()
    {
        characterClassType = Classes.Healer;
        characterClassName = "Cleric";
        characterClassDescription = "I need a medic!";
        
        strength = 16;
        dextarity = 8;
        constitiution = 13;
        inteligance = 10;
        wisdom = 16;
        charisma = 12;
        
        classItems = new BaseItem[]{new WeaponStick(), new PotionHealth()};
        
    }
}

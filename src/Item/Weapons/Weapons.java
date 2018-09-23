package Item.Weapons;

import Item.BaseItem;
import java.util.LinkedList;

public class Weapons {
    LinkedList<BaseItem> allWeapons;
    public Weapons()
    {
        allWeapons = new LinkedList<>();
    }
    
    public LinkedList<BaseItem> getAll()
    {
        
        allWeapons.add(new WeaponStick());
        allWeapons.add(new WeaponWoodenSword());
        allWeapons.add(new WeaponDagger());
        allWeapons.add(new WeaponShortSword());
        allWeapons.add(new WeaponBroadsword());
        allWeapons.add(new WeaponBow());
        
        if( false )
            for (int i = 0; i < allWeapons.size(); i++)
                System.out.println("Added " + allWeapons.get(i).getName() + "to master weapon list");
        
        return allWeapons;
    }
    
    
}

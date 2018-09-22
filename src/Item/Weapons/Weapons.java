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
        LinkedList<BaseItem> allWeapons = new LinkedList<>();
        getStick();
        System.out.println(allWeapons.get(0).getName());
                
        
        return allWeapons;
    }
    
    public LinkedList<BaseItem> getStick()
    {
        allWeapons.add(new WeaponStick());
        System.out.println("Added " + allWeapons.get(0).getName() + "to master weapon list");
        allWeapons.add(new WeaponWoodenSword());
        System.out.println("Added " + allWeapons.get(1).getName() + "to master weapon list");
        allWeapons.add(new WeaponDagger());
        System.out.println("Added " + allWeapons.get(2).getName() + "to master weapon list");
        allWeapons.add(new WeaponShortSword());
        System.out.println("Added " + allWeapons.get(3).getName() + "to master weapon list");
        allWeapons.add(new WeaponBroadsword());
        System.out.println("Added " + allWeapons.get(4).getName() + "to master weapon list");
        allWeapons.add(new WeaponBow());
        System.out.println("Added " + allWeapons.get(5).getName() + "to master weapon list");
                
        
        return allWeapons;
    }
    
    
}

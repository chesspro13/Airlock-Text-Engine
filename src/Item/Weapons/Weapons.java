package Item.Weapons;

import Item.BaseItem;
import java.util.LinkedList;

public class Weapons {
    
    public Weapons()
    {
        
    }
    
    public LinkedList<BaseItem> getAll()
    {
        LinkedList<BaseItem> allWeapons = new LinkedList<>();
        allWeapons.add(getStick());
        System.out.println(allWeapons.get(0).getName());
                
        
        return allWeapons;
    }
    
    public BaseItem getStick()
    {
        return new WeaponStick();
    }
    
    
}

package Player;

import Item.BaseItem;
import Item.BaseItemPotion;
import Item.BaseItemWeapon;
import Item.ItemType;
import java.util.LinkedList;

public class CharacterInventory {
    
    LinkedList<BaseItem> items;
    BaseItemPotion heldPotion;
    BaseItemWeapon equippedRightHand;
    BaseItemWeapon equippedLeftHand;
    
    public CharacterInventory()
    {
        this.items = new LinkedList<BaseItem>();
    }
    
    //Adds items to inventory
    public void addItem( BaseItem [] newItem )
    {
        int temp = newItem.length;
        System.out.println("Size of array:" + temp);
        //Checks to see which catagory the item falls under and sorts accordingly
        for (int i = 0; i < newItem.length - 1; i++) {
            if( newItem[i].getItemType() == ItemType.Weapon )
                equippedRightHand = (BaseItemWeapon) newItem[i];    
            if( newItem[i].getItemType() == ItemType.Potion )
                heldPotion = (BaseItemPotion) newItem[i];
        }
        System.out.println("Added items");
    }
    
    public void showInventoy()
    {
        if( heldPotion != null )
            System.out.println("Held potion: " + heldPotion.getName());
        if( equippedRightHand != null )
            System.out.println("Right Hand Equip: " + equippedRightHand.getName());
        if( equippedLeftHand != null )
            System.out.println("Right Hand Equip: " + equippedLeftHand.getName());
    }
}

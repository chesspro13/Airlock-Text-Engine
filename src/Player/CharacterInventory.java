package Player;

import Item.BaseItem;
import Item.BaseItemArmor;
import Item.BaseItemPotion;
import Item.BaseItemWeapon;
import Item.ItemType;
import java.util.LinkedList;

public class CharacterInventory {
    
    PlayerIdentifier playerIdentifier;
    LinkedList<BaseItem> items;
    BaseItemPotion heldPotion;//TODO: Implement
    BaseItemWeapon equippedRightHand;
    BaseItemWeapon equippedLeftHand;
    BaseItemArmor equippedArmor;
    
    public CharacterInventory(PlayerIdentifier playerIdentifier)
    {
        this.playerIdentifier = playerIdentifier;
    }
    
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
    
    //Adds items to inventory
    public void addItem( BaseItem newItem )
    {
        this.items.add(newItem);
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
    
    public void equipItem(BaseItem item)
    {
        switch( item.getItemType() )
        {
            case Weapon:
                equipWeapon(item);
                break;
            case Armor:
                equipArmor(item);
                break;
        }
    }
    
    public BaseItem getEquippedRight()
    {
        return equippedRightHand;
    }
    
    public BaseItem getEquippedLeft()
    {
        return equippedLeftHand;
    }
    
    public LinkedList<BaseItem> getEquippedWeapons()
    {
        LinkedList<BaseItem> items = new LinkedList<>();
        
        items.add(getEquippedRight() ) ;
        
        if( equippedLeftHand != null )
            items.add(getEquippedLeft()) ;
        
        return items;
    }
    
    private void equipArmor(BaseItem item)
    {
        equippedArmor = (BaseItemArmor)item;
    }
    
    private void equipWeapon(BaseItem item)
    {
        if(((BaseItemWeapon)item).getHandsRequired() == 1)
        {
            System.out.println("Hardcoded: Which hand do you want it in?\n\tRight)a\n\tLeft)b");
            if( 1 == 1 )
            {
                equippedRightHand = (BaseItemWeapon)item;
                
            }else
            {
                equippedLeftHand = (BaseItemWeapon)item;
            }
        }else
        {
            equippedRightHand = (BaseItemWeapon)item;
        }
    }
    
    public LinkedList<BaseItem> getInventory()
    {
        return items;
    }
    
    public PlayerIdentifier getPlayerIdentifier()
    {
        return playerIdentifier;
    }
}

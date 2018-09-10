package Item;

public class BaseItem {

    protected String name;
    protected String description;
    protected int cost;
    
    protected ItemType itemType;
    
    public String getName()
    {
        return name;
    }
    
    public ItemType getItemType()
    {
        return itemType;
    }
}

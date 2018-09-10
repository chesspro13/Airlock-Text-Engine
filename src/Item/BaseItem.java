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
    
    public int getCost()
    {
        return cost;
    }
    
    public String getDescription()
    {
        return description;
    }
    
//    public String getAllInfoForSaleArray()
//    {
//        return "Default sale thing";
//    }
}

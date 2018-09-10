package Item;

public class BaseItemArmor extends BaseItem{
    
    protected int deffence;
    
    public int getDeffence()
    {
        return deffence;
    }
    
    public String[] getAllInfoForSaleArray()
    {
        return new String[]{getName(), getCost()+"", getDeffence()+"", getDescription()+""};
    }
    
}

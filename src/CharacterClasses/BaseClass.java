package CharacterClasses;

/**
 *
 * @author chesspro13
 */

//Base parrent class to all character class types
public class BaseClass {
    protected String characterClassName;
    protected String characterClassDescription;
    
    protected int strength;
    protected int dextarity;
    protected int constitiution;
    protected int inteligance;
    protected int wisdom;
    protected int charisma;
    
    protected String[] classItems;

    public int getInteligance() {
        return inteligance;
    }

    public void setInteligance(int inteligance) {
        this.inteligance = inteligance;
    }
    
    protected String[] baseEquipmentWeapons;
    protected String[] baseEquipmentArmor;
    protected String[] baseEquipmentItem;

    public String getCharacterClassName() {
        return characterClassName;
    }

    public void setCharacterClassName(String characterClassName) {
        this.characterClassName = characterClassName;
    }

    public String getCharacterClassDescription() {
        return characterClassDescription;
    }

    public void setCharacterClassDescription(String characterClassDescription) {
        this.characterClassDescription = characterClassDescription;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDextarity() {
        return dextarity;
    }

    public void setDextarity(int dextarity) {
        this.dextarity = dextarity;
    }

    public int getConstitiution() {
        return constitiution;
    }

    public void setConstitiution(int constitiution) {
        this.constitiution = constitiution;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
    
    public String[] getClassItems()
    {
        return classItems;
    }
    
    
}

package CharacterClasses;

public class BaseFighterClass extends BaseClass{
        
    void BaseFighterClass()
    {
        characterClassName = "Fighter";
        characterClassDescription = "Tough fighter guy...";
        
        strength = 16;
        dextarity = 9;
        constitiution = 15;
        inteligance = 13;
        wisdom = 11;
        charisma = 14;
        
        classItems = new String[]{"Sword", "Simple_Armor", "Bo-Bo_potion"};
    }
}

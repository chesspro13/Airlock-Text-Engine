package IO;

import Item.BaseItem;
import Item.BaseItemWeapon;
import java.util.LinkedList;
import java.util.Scanner;
import src.TextFormatter;

/**
 *
 * @author Chesspro13
 */
public class IO {
    
    private Scanner scanner;
    
    public IO()
    {
        scanner = new Scanner(System.in);
    }
    
    public int printOptions(String output, LinkedList<String []> outputOptions, OutputType outputType)
    {
        TextFormatter tf = new TextFormatter();
        LinkedList<String> linkedOption = new LinkedList<>();
        tf.getMax(outputOptions);
        
        switch ( outputType )
        {
            case StoreOutput:
                //System.err.println("\n\n" + output );
                for (int i = 0; i < outputOptions.size(); i++) {
                    if (!outputOptions.isEmpty()) {
                        linkedOption.add(tf.format(output, outputOptions.get(i)));
                        //Good until up to here
                        System.out.println( linkedOption.get(i));
                    }
                }

                return getOptionInput(output, linkedOption);
        }
        return -1;
    }
    
    public int printOptoins(String output, LinkedList<String []> outputOptions, OutputType outputType, String[] endOptions)
    {
        TextFormatter tf = new TextFormatter();
        LinkedList<String> linkedOption = new LinkedList<>();
        tf.getMax(outputOptions);
        
        switch ( outputType )
        {
            case StoreOutput:
                //System.err.println("\n\n" + output );
                for (int i = 0; i < outputOptions.size(); i++) {
                    if (!outputOptions.isEmpty()) {
                        linkedOption.add(tf.format(output, outputOptions.get(i)));
                        //Good until up to here
                        System.out.println( linkedOption.get(i));
                    }
                }
                
                for(int i = 0; i < endOptions.length; i++)
                    linkedOption.add(endOptions[i]);
                

                return getOptionInput(output, linkedOption);
        }
        return -1;
    }
    
    public int getOptionInput( String output, LinkedList<BaseItem> items, LinkedList<String> endOptions, OutputType outputType )
    {
        LinkedList<String> linkedOption = new LinkedList<>();
        
        switch( items.get(0).getItemType() )
        {
            case Weapon:
                switch( outputType )
                {
                    case Other:
                        System.out.println("\n\n" + output);

                        for (int i = 0; i < items.size(); i++) {
                            linkedOption.add(items.get(i).getName() + "\t" + items.get(i).getDescription());
                        }

                        for (int i = 0; i < endOptions.size(); i++) {
                            linkedOption.add(endOptions.get(i));
                        }

                        return getOptionInput(output, linkedOption);
                    case StoreOutput:

                        System.out.println("\n\n" + output);

                        for (int i = 0; i < items.size(); i++) {
                            linkedOption.add(items.get(i).getName() + "\t" + ((BaseItemWeapon) items.get(i)).getCost());
                        }

                        for (int i = 0; i < endOptions.size(); i++) {
                            linkedOption.add(endOptions.get(i));
                        }
                        return getOptionInput(output, linkedOption);
                }
            case Armor:
                switch ( outputType ) {
                    case Other:
                        System.out.println("\n\n" + output);

                        for (int i = 0; i < items.size(); i++) {
                            linkedOption.add(items.get(i).getName() + "\t" + items.get(i).getDescription());
                        }

                        for (int i = 0; i < endOptions.size(); i++) {
                            linkedOption.add(endOptions.get(i));
                        }

                        return getOptionInput(output, linkedOption);
                    case StoreOutput:

                        System.out.println("\n\n" + output);

                        for (int i = 0; i < items.size(); i++) {
                            linkedOption.add(items.get(i).getName() + "\t" + items.get(i).getCost());
                        }

                        for (int i = 0; i < endOptions.size(); i++) {
                            linkedOption.add(endOptions.get(i));
                        }

                       return getOptionInput(output, linkedOption);
            }
            case GeneralItem:
                switch ( outputType ) {
                    case Other:
                        System.out.println("\n\n" + output);

                        for (int i = 0; i < items.size(); i++) {
                            linkedOption.add(items.get(i).getName() + "\t" + items.get(i).getDescription());
                        }

                        for (int i = 0; i < endOptions.size(); i++) {
                            linkedOption.add(endOptions.get(i));
                        }

                        return getOptionInput(output, linkedOption);
                    case StoreOutput:

                        System.out.println("\n\n" + output);

                        for (int i = 0; i < items.size(); i++) {
                            linkedOption.add(items.get(i).getName() + "\t" + items.get(i).getCost());
                        }

                        for (int i = 0; i < endOptions.size(); i++) {
                            linkedOption.add(endOptions.get(i));
                        }

                       return getOptionInput(output, linkedOption);
            }
        }
        return -1;
    }
    
    private int getWeaponInput()
    {
        System.err.println("IO.getWeaponInput() is not implemented! Returning -1!");
        return -1;
    }
    
    public int getOptionInput( String output, String [] options )
    {
        LinkedList<String> opt = new LinkedList<>();
        
        for (int i = 0; i < options.length; i++) {
            opt.add(options[i]);
        }
        return getOptionInput(output, opt);
    }

    public int getOptionInput(String output, LinkedList<String> options) {
        try {
            System.out.println(output);
            //System.out.println( "\n" + script.next() );
            for (int i = 0; i < options.size(); i++) {
                System.out.println("\t" + (char) (i + 97) + ") " + options.get(i));
            }

            System.out.print("Your choice: ");

            switch (scanner.next().charAt(0)) {
                case 'a':
                case 'A':
                    if (0 < options.size()) {
                        return 1;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'b':
                case 'B':
                    if (1 < options.size()) {
                        return 2;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'c':
                case 'C':
                    if (2 < options.size()) {
                        return 3;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'd':
                case 'D':
                    if (3 < options.size()) {
                        return 4;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'e':
                case 'E':
                    if (3 < options.size()) {
                        return 5;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'f':
                case 'F':
                    if (3 < options.size()) {
                        return 6;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'g':
                case 'G':
                    if (3 < options.size()) {
                        return 7;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'h':
                case 'H':
                    if (3 < options.size()) {
                        return 8;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'i':
                case 'I':
                    if (3 < options.size()) {
                        return 9;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'j':
                case 'J':
                    if (3 < options.size()) {
                        return 10;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'k':
                case 'K':
                    if (3 < options.size()) {
                        return 11;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'l':
                case 'L':
                    if (3 < options.size()) {
                        return 12;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'm':
                case 'M':
                    if (3 < options.size()) {
                        return 13;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'n':
                case 'N':
                    if (3 < options.size()) {
                        return 14;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'o':
                case 'O':
                    if (3 < options.size()) {
                        return 15;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'p':
                case 'P':
                    if (3 < options.size()) {
                        return 16;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'q':
                case 'Q':
                    if (3 < options.size()) {
                        return 17;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'r':
                case 'R':
                    if (3 < options.size()) {
                        return 18;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 's':
                case 'S':
                    if (3 < options.size()) {
                        return 19;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 't':
                case 'T':
                    if (3 < options.size()) {
                        return 20;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'u':
                case 'U':
                    if (3 < options.size()) {
                        return 21;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'v':
                case 'V':
                    if (3 < options.size()) {
                        return 22;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'w':
                case 'W':
                    if (3 < options.size()) {
                        return 23;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'x':
                case 'X':
                    if (3 < options.size()) {
                        return 24;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'y':
                case 'Y':
                    if (3 < options.size()) {
                        return 25;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                case 'z':
                case 'Z':
                    if (3 < options.size()) {
                        return 26;
                    } else {
                        System.out.println("\n\nThat was not a valid selection!");
                        getOptionInput(output, options);
                    }
                    break;
                default:
                    System.out.println("\n\nThat was not a valid selection!");
                    getOptionInput(output, options);
            }

        } catch (Exception e) {
            System.out.println("Error, repeating last option");
            getOptionInput(output, options);
        }

        return -1;
    }
    
}

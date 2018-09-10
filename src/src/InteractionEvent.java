//package src;
//
//import Item.BaseItem;
//import Item.BaseItemArmor;
//import java.util.*;
//
//public class InteractionEvent {
//
//    TextFormatter formatter;
//    Scanner scanner;
//
//    public InteractionEvent() {
//        formatter = new TextFormatter();
//        scanner = new Scanner(System.in);
//    }
//
//    public String getTextInput(String output) {
//        String input = null;
//
//        try {
//            System.out.println("\n\n" + output);
//
//            input = scanner.next();
//        } catch (Exception e) {
//            System.out.println("\n\n\"" + input + "\" is not a valid option.");
//            return getTextInput(output);
//        }
//
//        return getTextInput(output);
//    }
//
//    //Potentially Obsoliete
////	public int getOptionInput(String output, LinkedList<BaseItem> weapons, int h)
////	{
////		LinkedList<String> linkedOption = new LinkedList<String>();
////		LinkedList<String[]> temp = new LinkedList<String[]>();
////		for( int i = 0; i < weapons.size(); i++)
////		{
////			//temp.add( new String[]{weapons.get(i).getName());
////		}
////		
////	//	String [] temp = formatter.format(weapons);
////		
////		switch( h )
////		{
////			case 0:
////				System.out.println( "\n\n" + output );
////
////				for(int i = 0; i < weapons.size(); i++)
////				{
////					//linkedOption.add( temp[i] );
////				}
////
////				return getOptionInput( output, linkedOption );
////			case 1:
////
////				System.out.println( "\n\n" + output );
////
////				for(int i = 0; i < weapons.size(); i++)
////				{
////					linkedOption.add(weapons.get(i).getName() + "\t" + weapons.get(i).getCost());
////				}
////
////				return getOptionInput( output, linkedOption );
////		}
////		return -1;
////	}
//    public int getOptionInput(String output, LinkedList<String[]> array, String[] endOptions, int[] nums, char h) {
//        LinkedList<String> linkedOption = new LinkedList<>();
//        TextFormatter tf = new TextFormatter();
//        tf.getMax(array);
//
//        switch (h) {
//            case 'a':
//                System.out.println("\n\n" + output);
//                for (int i = 0; i < array.size(); i++) {
//                    if (!array.isEmpty()) {
//                        linkedOption.add(tf.format(output, array.get(i), new int[]{1, 2, 3, 4}));
//                    }
//                }
//
//                for (String endOption : endOptions) {
//                    linkedOption.add(endOption);
//                }
//
//                return getOptionInput(output, linkedOption);
//            case 'b':
//
//                System.out.println("\n\n" + output);
//
//                for (int i = 0; i < array.size(); i++) {
//                    linkedOption.add(tf.format(output, array.get(i), new int[]{1}));
//                }
//
//                for (int i = 0; i < endOptions.length; i++) {
//                    linkedOption.add(endOptions[i]);
//                }
//
//                return getOptionInput(output, linkedOption);
//            case 'c':
//                System.out.println("\n\n" + output);
//                for (int i = 0; i < array.size(); i++) {
//                    linkedOption.add(tf.format(output, array.get(i), new int[]{}));
//                }
//
//                for (int i = 0; i < endOptions.length; i++) {
//                    linkedOption.add(endOptions[i]);
//                }
//
//                return getOptionInput(output, linkedOption);
//            case 'd':
//                System.out.println("\n\n" + output);
//                for (int i = 0; i < array.size(); i++) {
//                    if (array.size() != 0) {
//                        linkedOption.add(tf.format(output, array.get(i), nums));
//                    }
//                }
//
//                for (int i = 0; i < endOptions.length; i++) {
//                    linkedOption.add(endOptions[i]);
//                }
//
//                return getOptionInput(output, linkedOption);
//        }
//
//        return -1;
//    }
//
//    public int getOptionInput(String output, LinkedList<BaseItem> weapons, String[] endOptions, int h) {
//        LinkedList<String> linkedOption = new LinkedList<String>();
//        //String [] temp = formatter.format(weapons);
//
//        switch (h) {
//            case 0:
//                System.out.println("\n\n" + output);
//
//                for (int i = 0; i < weapons.size(); i++) {
//                    linkedOption.add(weapons.get(i).getName() + "\t" + weapons.get(i).getDescription());
//                }
//
//                for (int i = 0; i < endOptions.length; i++) {
//                    linkedOption.add(endOptions[i]);
//                }
//
//                return getOptionInput(output, linkedOption);
//            case 1:
//
//                System.out.println("\n\n" + output);
//
//                for (int i = 0; i < weapons.size(); i++) {
//                    linkedOption.add(weapons.get(i).getName() + "\t" + weapons.get(i).getCost());
//                }
//
//                for (int i = 0; i < endOptions.length; i++) {
//                    linkedOption.add(endOptions[i]);
//                }
//
//                return getOptionInput(output, linkedOption);
//        }
//        return -1;
//    }
//
//    public int getOptionInput(String output, LinkedList<BaseItem> items, int p2, String[] endOptions) {
//        LinkedList<String> linkedOption = new LinkedList<String>();
//
//        switch (p2) {
//            case 0:
//                System.out.println("\n\n" + output);
//
//                for (int i = 0; i < items.size(); i++) {
//                    linkedOption.add(items.get(i).getName() + "\t" + items.get(i).getDescription());
//                }
//
//                for (int i = 0; i < endOptions.length; i++) {
//                    linkedOption.add(endOptions[i]);
//                }
//
//                return getOptionInput(output, linkedOption);
//            case 1:
//
//                System.out.println("\n\n" + output);
//
//                for (int i = 0; i < items.size(); i++) {
//                    linkedOption.add(items.get(i).getName() + "\t" + items.get(i).getCost());
//                }
//
//                for (int i = 0; i < endOptions.length; i++) {
//                    linkedOption.add(endOptions[i]);
//                }
//
//                return getOptionInput(output, linkedOption);
//        }
//        return -1;
//    }
//
//    public int getOptionInput(String output, int h, LinkedList<BaseItem> armor, String[] endOptions) {
//        LinkedList<String> linkedOption = new LinkedList<String>();
//
//        switch (h) {
//            case 0:
//                System.out.println("\n\n" + output);
//
//                for (int i = 0; i < armor.size(); i++) {
//                    linkedOption.add(armor.get(i).getName() + "\t" + armor.get(i).getDescription());
//                }
//
//                for (int i = 0; i < endOptions.length; i++) {
//                    linkedOption.add(endOptions[i]);
//                }
//
//                return getOptionInput(output, linkedOption);
//            case 1:
//
//                System.out.println("\n\n" + output);
//
//                for (int i = 0; i < armor.size(); i++) {
//                    linkedOption.add(armor.get(i).getName() + "\t" + armor.get(i).getCost());
//                }
//
//                for (int i = 0; i < endOptions.length; i++) {
//                    linkedOption.add(endOptions[i]);
//                }
//
//                return getOptionInput(output, linkedOption);
//        }
//        return -1;
//    }
//
//    public int getOptionInput(String output, int h, LinkedList<Armor> armor) {
//        LinkedList<String> linkedOption = new LinkedList<String>();
//        switch (h) {
//            case 0:
//                System.out.println("\n\n" + output);
//
//                for (int i = 0; i < armor.size(); i++) {
//                    linkedOption.add(armor.get(i).getName() + "\t" + armor.get(i).getDescription());
//                }
//
//                return getOptionInput(output, linkedOption);
//            case 1:
//                System.out.println("\n\n" + output);
//
//                for (int i = 0; i < armor.size(); i++) {
//                    linkedOption.add(armor.get(i).getName() + "\t" + armor.get(i).getCost());
//                }
//                return getOptionInput(output, linkedOption);
//        }
//        return -1;
//    }
//
//    public int getOptionInput(String output, String[] options) {
//        LinkedList<String> linkedOption = new LinkedList<String>();
//
//        System.out.println("\n\n" + output);
//
//        for (int i = 0; i < options.length; i++) {
//            linkedOption.add(options[i]);
//        }
//
//        return getOptionInput(output, linkedOption);
//
//    }
//
//    public int getOptionInput(String output, LinkedList<String> options) {
//        try {
//
//            //System.out.println( "\n" + script.next() );
//            for (int i = 0; i < options.size(); i++) {
//                System.out.println("\t" + (char) (i + 97) + ") " + options.get(i));
//            }
//
//            System.out.print("Your choice: ");
//
//            switch (scanner.next().charAt(0)) {
//                case 'a':
//                case 'A':
//                    if (0 < options.size()) {
//                        return 1;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'b':
//                case 'B':
//                    if (1 < options.size()) {
//                        return 2;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'c':
//                case 'C':
//                    if (2 < options.size()) {
//                        return 3;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'd':
//                case 'D':
//                    if (3 < options.size()) {
//                        return 4;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'e':
//                case 'E':
//                    if (3 < options.size()) {
//                        return 5;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'f':
//                case 'F':
//                    if (3 < options.size()) {
//                        return 6;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'g':
//                case 'G':
//                    if (3 < options.size()) {
//                        return 7;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'h':
//                case 'H':
//                    if (3 < options.size()) {
//                        return 8;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'i':
//                case 'I':
//                    if (3 < options.size()) {
//                        return 9;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'j':
//                case 'J':
//                    if (3 < options.size()) {
//                        return 10;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'k':
//                case 'K':
//                    if (3 < options.size()) {
//                        return 11;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'l':
//                case 'L':
//                    if (3 < options.size()) {
//                        return 12;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'm':
//                case 'M':
//                    if (3 < options.size()) {
//                        return 13;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'n':
//                case 'N':
//                    if (3 < options.size()) {
//                        return 14;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'o':
//                case 'O':
//                    if (3 < options.size()) {
//                        return 15;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'p':
//                case 'P':
//                    if (3 < options.size()) {
//                        return 16;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'q':
//                case 'Q':
//                    if (3 < options.size()) {
//                        return 17;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'r':
//                case 'R':
//                    if (3 < options.size()) {
//                        return 18;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 's':
//                case 'S':
//                    if (3 < options.size()) {
//                        return 19;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 't':
//                case 'T':
//                    if (3 < options.size()) {
//                        return 20;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'u':
//                case 'U':
//                    if (3 < options.size()) {
//                        return 21;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'v':
//                case 'V':
//                    if (3 < options.size()) {
//                        return 22;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'w':
//                case 'W':
//                    if (3 < options.size()) {
//                        return 23;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'x':
//                case 'X':
//                    if (3 < options.size()) {
//                        return 24;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'y':
//                case 'Y':
//                    if (3 < options.size()) {
//                        return 25;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                case 'z':
//                case 'Z':
//                    if (3 < options.size()) {
//                        return 26;
//                    } else {
//                        System.out.println("\n\nThat was not a valid selection!");
//                        getOptionInput(output, options);
//                    }
//                    break;
//                default:
//                    System.out.println("\n\nThat was not a valid selection!");
//                    getOptionInput(output, options);
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error, repeating last option");
//            getOptionInput(output, options);
//        }
//
//        return -1;
//    }
//
//    public int getOptionInput(Scanner script) {
//        LinkedList<String> options = new LinkedList<String>();
//        String output;
//        boolean tempBoolean = true;
//        String temp;
//
//        output = script.next();
//        do {
//            temp = script.next();
//            if (temp == "END") {
//                tempBoolean = false;
//            } else {
//                options.add(script.next().trim());
//            }
//
//            options.add(script.next().trim());
//        } while (tempBoolean);
//
//        for (int i = 0; i < options.size(); i++) {
//            System.out.println("\t" + (char) (i + 96) + ") " + options.get(i));
//        }
//
//        System.out.print("Your choice: ");
//
//        return getOptionInput(output, options);
//    }
//}

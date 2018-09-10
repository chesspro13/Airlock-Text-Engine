package src;


import java.util.*;
import java.lang.annotation.*;

public class TextFormatter
{
	private static final int NUM_OF_SPACES_IN_TAB = 4;
	
	private String output;
	private int maxLetters;
	private int size;
	
        //Text formatting designed to see how to format an array of items to make them into a table
	public String format( String outputArray, String [] array)
	{
		//output = outputArray;
            output = "";
		size = outputArray.length();
		
                for( int j = size; j < maxLetters; j++ )
			output += " ";
		if( array.length != 0 )
			for( int i = 0; i < array.length - 1; i++)
                        {
				output += array[i] + "\t";
                        }
		return output;
	}
	
//	public String format( String outputArray, String preArray, int [] elements)
//	{
//            String [] array = preArray.split("");
//		output = outputArray;
//		size = outputArray.length();
//		//System.out.println(maxLetters + ":" + size);
//
//		
//		for( int j = size; j < maxLetters; j++ )
//			output += " ";
//		if( elements.length != 0)
//			for( int i = 0; i < elements.length; i++)
//				output += array[elements[i]] + "\t";
//		//output += array[ elements[ elements.length -1 ] ];
//		return output;
//	}
	
        public String format( String string, int [] elements)
	{
            String [] array = string.split(" ");
		//System.out.println(maxLetters + ":" + size);

		
		for( int j = size; j < maxLetters; j++ )
			output += " ";
		if( elements.length != 0)
			for( int i = 0; i < elements.length; i++)
				output += array[elements[i]] + "\t";
		//output += array[ elements[ elements.length -1 ] ];
		return output;
	}
	
        //Max letters, for formatting stuff?
	public void getMax(LinkedList<String[]> array)
	{
		for( int i = 0; i < array.size(); i++)
			maxLetters = getMaxCount( maxLetters, array.get(i)[0].length() );
		maxLetters += 4;
	}
	
	private int getMaxCount(int max, int newNum)
	{
		if( newNum % NUM_OF_SPACES_IN_TAB == 0)
			newNum++;
		if( max < newNum )
			max = newNum;
		return max;
	}
}

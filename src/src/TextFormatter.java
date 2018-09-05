package src;


import java.util.*;
//import org.apache.http.conn.ssl.*;
import java.lang.annotation.*;public class TextFormatter
{
	private static final int NUM_OF_SPACES_IN_TAB = 4;
	
	private String output;
	private int maxLetters;
	private int size;
	
	public String format( String outputArray, String [] array, int [] elements)
	{
		output = outputArray;
		size = outputArray.length();
		//System.out.println(maxLetters + ":" + size);

		
		for( int j = size; j < maxLetters; j++ )
			output += " ";
		if( elements.length != 0)
			for( int i = 0; i < elements.length; i++)
				output += array[elements[i]] + "\t";
		//output += array[ elements[ elements.length -1 ] ];
		return output;
	}
	
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

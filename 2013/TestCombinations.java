
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TestCombinations {


	private static ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>(); // combinations
	private static ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	private static int n, k;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer tokens = new StringTokenizer(in.readLine());
		n = Integer.valueOf(tokens.nextToken());
		k = Integer.valueOf(tokens.nextToken());
		
		tokens = new StringTokenizer(in.readLine());
		while(tokens.hasMoreElements()) 
		{
			numbers.add(Integer.valueOf(tokens.nextToken()));
		}
		recursive(new ArrayList<Integer>());
		
		//Print combinations-----------
		int total = combinations.size();
		for (int i = 0; i < total; i++) 
		{
			ArrayList<Integer> comb = combinations.get(i);
			String line = "";
			for(int n : comb)
			{
				line += n + " ";
			}
			System.out.println("Combination #" + (i+1) + " : " + line);			
		}
		System.out.println("Total combinations : " + total);
	}
	
	
	public static void recursive (ArrayList<Integer> positions)
	{
		if(positions.size() == k)
			makeCombination(positions);
		else
		{
			for (int i = 0; i < numbers.size(); i++) 
			{
				boolean exist = false;
				for(int pos : positions)
				{
					if(pos == i)
					{
						exist = true;
						break;
					}
				}
				if(!exist)
				{
					ArrayList<Integer> copy = (ArrayList<Integer>)positions.clone();
					copy.add(i);
					recursive(copy);
				}					
			}
		}
	}
	
	public static void makeCombination (ArrayList<Integer> positions)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int pos : positions)
		{
			list.add(numbers.get(pos));
		}
		boolean exist = false;
		for (int i = 0; i < combinations.size(); i++) 
		{
			ArrayList<Integer> comb = combinations.get(i);
			if(areEquals(comb, list))
			{
				exist = true;
				break;
			}				
		}
		if(!exist)
			combinations.add(list);
	}
	
	
	public static boolean areEquals (ArrayList<Integer> list1, ArrayList<Integer> list2)
	{
		boolean equals = false;
		for (int i = 0; i < list1.size(); i++) 
		{
			equals = false;
			int n = list1.get(i);
			for (int j = 0; j < list2.size(); j++) 
			{
				if(n == list2.get(j))
				{
					equals = true;
					break;
				}
			}
			if(!equals)
				break;
		}
		if(equals)
			return true;
		else
			return false;
	}

}

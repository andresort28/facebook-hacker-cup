
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
	
		int cases = Integer.valueOf(in.readLine());
		StringTokenizer tokens;
		for (int i = 0; i < cases; i++) 
		{
			tokens = new StringTokenizer(in.readLine());
			int n = Integer.valueOf( tokens.nextToken());
			int k = Integer.valueOf( tokens.nextToken());
			
			tokens = new StringTokenizer(in.readLine());
			int a = Integer.valueOf( tokens.nextToken());
			int b = Integer.valueOf( tokens.nextToken());
			int c = Integer.valueOf( tokens.nextToken());
			int r = Integer.valueOf( tokens.nextToken());
					
			LinkedList<BigInteger> list = new LinkedList<BigInteger>();
			
			list.add(BigInteger.valueOf(a));
			
			for (int j = 1; j < k; j++) 
			{
				BigInteger big = ((BigInteger.valueOf(b).multiply(list.get(j-1))).add(BigInteger.valueOf(c))).mod(BigInteger.valueOf(r));
				list.add(big);
			}
			for (int j = k; j < n; j++) 
			{
				int num = getNumber(list);	
				list.removeFirst();
				list.addLast(BigInteger.valueOf(num));		
			}
			out.write("Case #" + (i+1) + ": "+ list.getLast().intValue() + "\n");
		}
		in.close();
		out.close();
		System.exit(0);	
	}
	
	public static int getNumber (LinkedList<BigInteger> list) 
	{
		LinkedList<BigInteger> copy = (LinkedList<BigInteger>)list.clone();
		Collections.sort(copy);
		int num = 0;
		BigInteger before = BigInteger.valueOf(-1);
		for (int i = 0; i < copy.size(); i++) 
		{
			BigInteger actual = copy.get(i);
			if(BigInteger.valueOf(num).compareTo(before)==1 && BigInteger.valueOf(num).compareTo(actual)==-1)
				return num;
			else
			{
				if(before.compareTo(actual) != 0)
					num++;
				before = actual;
			}
		}
		return num;
	}

}



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Mind {

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
					
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			list.add(a);
			
			for (int j = 1; j < k; j++) 
			{
				list.add(((b*list.get(j-1)) + c)%r);
			}
			System.out.println(list);
			for (int j = k; j < n; j++) 
			{
				int num = getNumber(list);	
				list.removeFirst();
				list.addLast(num);		
			}
			out.write("Case #" + (i+1) + ": "+ list.getLast() + "\n");
		}
		in.close();
		out.close();
		System.exit(0);	
	}
	
	public static int getNumber (LinkedList<Integer> list)
	{
		LinkedList<Integer> copy = (LinkedList<Integer>)list.clone();
		Collections.sort(copy);
		int num = 0;
		int before = -1;
		for (int i = 0; i < copy.size(); i++) 
		{
			int actual = copy.get(i);
			if(num > before && num < actual)
			{
				System.out.println(num);
				return num;
				
			}
			else
			{
				if(before != actual)
					num++;
				before = actual;
			}
		}
		return num;
	}

}


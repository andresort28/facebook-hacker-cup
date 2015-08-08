
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class BeautifulStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(in.readLine());
		String line = "";
		for (int i = 0; i < n; i++) 
		{
			int[] letters = new int[26];
			line = in.readLine().toLowerCase();
			for (int j = 0; j < line.length(); j++) 
			{
				int c = (int)line.charAt(j) - 97;
				if(c >= 0 && c <= 25)
					letters[c] += 1;
			}
			Arrays.sort(letters);
			int value = 26;
			int sum = 0;
			for (int j = letters.length-1; j >= 0 ; j--) 
			{
				int c = letters[j];
				if(c > 0)
				{
					sum += value*c;
					value -= 1;
				}				
			}
			out.write("Case #" + (i+1) + ": " + sum +"\n");
		}
		in.close();
		out.close();
		System.exit(0);
	}

}

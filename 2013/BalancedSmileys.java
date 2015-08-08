import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.LinkedList;

public class BalancedSmileys {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(in.readLine());
		String line;
		
		for (int i = 0; i < n; i++) 
		{
			LinkedList<boolean[]> stack = new LinkedList<boolean[]>(); 
			line = in.readLine().toLowerCase();
			String response = "YES";
			int length = line.length();
			boolean colon = false;
			for (int j = 0; j < length; j++) 
			{
				int c = (int)line.charAt(j);
				
				if (c==58)
					colon = true;				
				else if (c==40)
				{
					stack.push(new boolean[]{colon ? true:false, true});
					colon = false;
				}
				else if (c==41)
				{
					if(!stack.isEmpty())
					{
						int pos = -1;
						for (int k = 0; k < stack.size(); k++) 
						{
							boolean[] b = stack.get(k); 
							if(b[1] && !b[0])
							{
								pos = k;
								break;								
							}
							if(b[1] && b[0] && pos==-1)
								pos = k;
						}
						if(pos==-1)
						{
							if(!colon)
							{
								response = "NO";
								break;
							}
							colon = false;
						}
						else
						{
							stack.remove(pos);
							colon = false;
						}
					}
					else
					{
						if(!colon)
						{
							response = "NO";
							break;
						}
						colon = false;
					}				
				}
				else if(  (c < 97 || c>122) && c!=0 && c!=32 )
				{
					response = "NO";
					break;
				}
				
			}
			if(!stack.isEmpty() && response.equals("YES"))
			{
				for(boolean[] conj : stack)
				{
					if(!conj[0])
					{
						response = "NO";
						break;
					}
				}				
			}
			out.write("Case #"+(i+1)+": "+response+"\n");
		}
		in.close();
		out.close();
		System.exit(0);		
	}

}

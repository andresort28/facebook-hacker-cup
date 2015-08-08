
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class CardGame 
{

	private static Hashtable<Integer, BigInteger> factorials = new Hashtable<Integer, BigInteger>();
	private static Hashtable<String, BigInteger> combinatories = new Hashtable<String, BigInteger>();
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
			int n = Integer.valueOf(tokens.nextToken());
			int k = Integer.valueOf(tokens.nextToken());			
			
			int[] num = new int[n];
			tokens = new StringTokenizer(in.readLine());
			int j = 0;
			while(tokens.hasMoreElements())
			{
				num[j] = Integer.valueOf(tokens.nextToken()) % 1000000007;
				j++;
			}
			Arrays.sort(num); //esta de menor a mayor
			
			BigInteger comb = combination(n, k); // combinatoria		
			n--;
			k--;
			BigInteger sum = BigInteger.valueOf(0);
			
			for (int l = num.length-1; l >= 0; l--) 
			{
				if(comb.compareTo(BigInteger.valueOf(0)) == 1)
				{
					BigInteger times = combination(n, k); // combinatoria
					sum = sum.add(BigInteger.valueOf(num[l]).multiply(times));
					comb = comb.subtract(times);
					n--;
				}
				else
					break;
			}

			//BigInteger answer = sum.mod(BigInteger.valueOf(1000000007));
			out.write("Case #"+(i+1)+": "+ sum.toString() + "\n");
		}
		in.close();
		out.close();
		System.exit(0);
	}
	
	public static BigInteger combination (int n, int k)
	{
		if(combinatories.containsKey(n+","+k))
			return combinatories.get(n+","+k);
		else			
		{
			BigInteger big = factorial(n).divide(factorial(k).multiply(factorial(n-k)));
			combinatories.put(n+","+k, big);
			return big.mod(BigInteger.valueOf(1000000007));
		}	
	}
	
	public static BigInteger factorial (int num)
	{
	
		if(factorials.containsKey(num))
			return factorials.get(num);
		else
		{
			int pos = 1;
			for (int i = num; i >= 1; i--) 
			{
				if(factorials.containsKey(i))
				{
					pos = i;
					break;
				}					
			}
			BigInteger big = BigInteger.valueOf(1);
			if(pos != 1)
				big = factorials.get(pos);
			pos++;		
			for (int i = pos; i <= num; i++) {
				big = big.multiply(BigInteger.valueOf(i));	
			}
			factorials.put(num, big);
			return big.mod(BigInteger.valueOf(1000000007));
		}		
	}

}

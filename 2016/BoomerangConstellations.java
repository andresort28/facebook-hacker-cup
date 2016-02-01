
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Hashtable;

public class BoomerangConstellations {
	
	private static String[] points;
	private static Hashtable<String, Double> table;
	private static Hashtable<String, Integer> results;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		int t = Integer.valueOf(in.readLine());
		String line = "";
		for (int i = 0; i < t; i++) 
		{
			table = new Hashtable<String, Double>();
			results = new Hashtable<String, Integer>();
			
			int n = Integer.valueOf(in.readLine());
			points = new String[n];
			for (int j = 0; j < n; j++) 
			{
				line = in.readLine();
				points[j] = line;
			}
			
			for (int j = 0; j < points.length; j++) 
			{				
				String[] p1 = points[j].split(" ");
				int x1 = Integer.parseInt(p1[0]);
				int y1 = Integer.parseInt(p1[1]);
				
				for (int k = j+1; k < points.length; k++) 
				{
					String[] p2 = points[k].split(" ");
					int x2 = Integer.parseInt(p2[0]);
					int y2 = Integer.parseInt(p2[1]);
					
					String key  = j+","+k;
					String key_ = k+","+j;
					
					double dist = (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1);
					table.put(key, dist);
					table.put(key_, dist);
				}
			}
			//out.write("#" + (i+1) + ": " + "Distances calculated\n");
			
			int total = 0;
			for (int j = 0; j < points.length; j++) {
				for (int k = 0; k < points.length; k++) {
					if(k != j){
						total += getEvaluatedDistance(j, k, table.get(j+","+k));
					}
				}
			}			
			out.write("Case #" + (i+1) + ": " + total + "\n");
		}
		in.close();
		out.close();
		System.exit(0);
	}
	
	public static int getEvaluatedDistance (int source, int point, double dist){
		
		int count = 0;
		for (int i = 0; i < points.length; i++) {
			if(i != source && i != point)
			{
				String key = point+","+i;
				if(table.get(key) == dist)
				{
					String k1 = source + "," + point + "," + i;
					String k2 = source + "," + i + "," + point;
					String k3 = point + "," + source + "," + i;
					String k4 = point + "," + i + "," + source;
					String k5 = i + "," + source + "," + point;
					String k6 = i + "," + point + "," + source;
					
					if(!results.containsKey(k1) && !results.containsKey(k2) && !results.containsKey(k3) && !results.containsKey(k4) && 
							!results.containsKey(k5) && !results.containsKey(k6))
					{
						results.put(source + "," + point + "," + i, 1);
						count++;
					}
				}
			}
		}	
		return count;
	}
	

}

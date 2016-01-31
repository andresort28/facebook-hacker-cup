
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/A.in"))));

		String output = "";
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			long[] x = new 	long[n];
			long[] y = new 	long[n];
			
			for (int j = 0; j < n; j++) {
				x[j] = sc.nextLong();
				y[j] = sc.nextLong();
			}
			
			ArrayList<HashMap<Long, Long>> dists = new ArrayList<HashMap<Long, Long>>();
			for (int j = 0; j < n; j++) {
				dists.add(new HashMap<Long, Long>());
				for (int k = 0; k < n; k++) {
					long d = (x[j]-x[k])*(x[j]-x[k])+(y[j]-y[k])*(y[j]-y[k]);
					if (dists.get(j).containsKey(d))
						dists.get(j).put(d, dists.get(j).get(d)+1);
					else
						dists.get(j).put(d, 1l);
				}
			}
			
			long ans = 0;
			
			for (HashMap<Long, Long> map : dists) {
				for (long l : map.keySet()) {
					long v = map.get(l);
					ans += v*(v-1)/2;
				}
			}
			
			output += "Case #" + i + ": " + ans + "\n";
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/A.out"), "utf-8"));
		bw.write(output);
		bw.close();
		System.out.println("FINISH !!!!");
	}
}

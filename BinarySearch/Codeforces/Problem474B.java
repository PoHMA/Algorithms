import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	@autor PoHMA
	
	Read input
		Petr Mitrichev
*/

public class Problem474B {
	public static void main(String[] args)throws IOException {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		ProblemB solution = new ProblemB();
		solution.solve(in,out);
		out.close();
	}

	static class ProblemB{
		
		private int[] readAccrued(int n, InputReader in){
			int[] res = new int[n];
			int sum = 0;
			
			for (int i = 0; i < n; i++) {
				res[i] = in.nextInt();
				sum = sum+res[i];
				res[i] = sum;
			}

			return res;
		}

		public void solve(InputReader in, PrintWriter out){
			int n = in.nextInt();
			int[] array = readAccrued(n,in);
			int q = in.nextInt();
			for (int i = 0; i < q; i++) {
				out.println(binarySearch(in.nextInt(),array,0,n-1));
			}
		}

		public int binarySearch(int n, int[] worms, int left, int right){
			int res,mid,l,r;
			mid = 0;
			l = left;
			r = right;
			while (l <= r) {
				mid = (l+r)/2;
				if (worms[mid] == n){ 
					return mid+1;
				}else if (worms[mid] < n) 
					l = mid+1;
				else
					r = mid-1;				
			}
			
			if (worms[mid] < n) 
				res = mid+2;
			else 
				res = mid+1;
			
			
			return res;
		}

	}

	static class InputReader{
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public InputReader(InputStream stream){
			reader = new BufferedReader(new InputStreamReader(stream),32768);
			tokenizer = null;
		}
		public String next(){
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try{
					tokenizer = new StringTokenizer(reader.readLine());
				}catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt(){
			return Integer.parseInt(next());
		}

	}


}
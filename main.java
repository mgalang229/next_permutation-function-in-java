import java.io.*;
import java.util.*;

public class Main {
	static final Reader in = new Reader();
	static final PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
//		int t=in.nextInt();
		int t=1;
		for(int i=1; i<=t; ++i)
			new Solver();
		out.close();
	}
	
	static class Solver {
		Solver() {
			int[] n = {1,1,3,4};
			do {
				for(int i : n)
					out.print(i+" ");
				out.println();
			} while(next_permutation(n));
		}
		boolean next_permutation(int[] a) {
			boolean ok=false;
			int i;
			for(i=(int)a.length-2; i>=0; --i)
				if(a[i]<a[i+1]) {
					ok=true;
					break;
				}
			if(!ok)
				return false;
			int j;
			for(j=i+1; j<(int)a.length; ++j)
				if(a[j]<=a[i])
					break;
			--j;
			swap(a, i, j);
			reverse(a, i+1, a.length);
			return true;
		}
		void swap(int[] a, int i, int j) {
			int tmp=a[i];
			a[i]=a[j];
			a[j]=tmp;
		}
		void reverse(int[] a, int s, int e) {
			for(int i=s, j=e-1; i<j; ++i, --j)
				swap(a, i, j);
		}
	}
	
	static class Reader {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String next() {
			while(st==null||!st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(in.readLine());
				} catch(Exception e) {}
			}	
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
	
}

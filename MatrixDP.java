import java.util.Arrays;
import java.util.Scanner;


class MatrixDP{
	static int[][] memo;
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int numMat = scanner.nextInt();
		int[] Dim = new int[numMat+1];
		for (int i = 0; i<=numMat; i++){
			Dim[i] = scanner.nextInt();
		}
		scanner.close();
		final long startTime = System.currentTimeMillis();
		memo = new int[numMat+1][numMat+1];
		for (int i = 0;i<numMat+1; i++){
			Arrays.fill(memo[i], -1);
		}
		for (int i = 0; i<numMat; i++)
			memo[i][i+1] = 0;
		System.out.println(Time(0,numMat,Dim)); 
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );

	}
	private static int Time(int a, int b, int[] Dim){
		if (a>=b)
			throw new IllegalArgumentException("First element cannot be greater than the second element");;
		if (memo[a][b] > -1)
			return memo[a][b];
		else{
			int min = Integer.MAX_VALUE;
			int[] T = new int[b-a-1];
			for(int i = a+1; i<b; i++){
				T[i-a-1] = Time(a,i,Dim) + Time(i,b,Dim) + Dim[a]*Dim[b]*Dim[i];
				if (T[i-a-1] < min)
					min = T[i-a-1];
			}
			return min;
		}

	}

}
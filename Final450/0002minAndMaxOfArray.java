//package stu.piyush.learning;
// https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
// method 1: using linear searching
import java.util.Scanner;

public class Source {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		
		MinMax minmax = new MinMax();
		
		//int arrans[] = new int[2];
		minmax = findMinMax(arr,n);
		//minmax.setMin(arrans[0]);
		//minmax.setMin(arrans[1]);
		System.out.println(minmax);
		
	}

	private static MinMax findMinMax(int[] arr, int n) {
		//int ans[] = new int[2];
		MinMax minmax = new MinMax();
		if(n == 1) {
			//ans[0] = arr[0];
			//ans[1] = arr[0];
			minmax.setMin(arr[0]);
			minmax.setMax(arr[0]);
			return minmax;
		}
		
		minmax.setMin(arr[0]>=arr[1]?arr[1]:arr[0]);
		minmax.setMax(arr[0]>=arr[1]?arr[0]:arr[1]);
		
		if(n == 2) {	
			return minmax;
		}
		
		for(int i = 2; i < n ; i++) {
			if(arr[i] >= minmax.getMax()) {
				minmax.setMax(arr[i]);
			}
			else if(arr[i] <= minmax.getMin()) {
				minmax.setMin(arr[i]);
			}
		}
		return minmax;
	}
}

class MinMax{
	private int min;
	private int max;
	public MinMax() {}
	public MinMax(int min, int max) {
		this.setMin(min);
		this.setMax(max);
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	@Override
	public String toString() {
		return "MinMax [min=" + min + ", max=" + max + "]";
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
}

//package stu.piyush.learning;
// https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

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
	// method 1: using linear searching
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
	
	// method 2 tournament method
	private static MinMax findMinMaxTournament(int n, int i, int j, int[] arr) {
		if(i==j) {
			return new MinMax(arr[i],arr[j]);
		}
		
		if(i+1 == j) {
			int min, max;
			min = arr[i] >= arr[j] ? arr[j] : arr[i];
			max = arr[i] >= arr[j] ? arr[i] : arr[j];
			return new MinMax(min,max);
		}
		int mid = (j+i)/2;
		MinMax m1 = new MinMax();
		MinMax m2 = new MinMax();
		MinMax ans = new MinMax();
		m1 = findMinMaxTournament(n, i, mid, arr);
		m2 = findMinMaxTournament(n, mid+1, j, arr);
		if(m1.getMin() <= m2.getMin()) {
			ans.setMin(m1.getMin());
		} else {
			ans.setMin(m2.getMin());
		}
		
		if(m1.getMax() <= m2.getMax()) {
			ans.setMax(m2.getMax());
		} else {
			ans.setMax(m1.getMax());
		}
		return ans;
	}
	
	//method 3 couple method
	private static MinMax findMinMaxCouple(int n, int[] arr) {
		MinMax minmax = new MinMax();
		if(n%2 == 0) {
			minmax.setMin(arr[0] <= arr[1] ? arr[0] : arr[1]);
			minmax.setMax(arr[0] >= arr[1] ? arr[0] : arr[1]);
		} else {
			minmax.setMin(arr[0]);
			minmax.setMax(arr[0]);
		}
		
		int i = 2;
		while(i<n-1) {
			if(arr[i] > arr[i+1]) {
				if(arr[i] >= minmax.getMax()) {
					minmax.setMax(arr[i]);
				}
				if(arr[i+1] <= minmax.getMin()) {
					minmax.setMin(arr[i+1]);
				}
			} else {
				if(arr[i+1] >= minmax.getMax()) {
					minmax.setMax(arr[i+1]);
				}
				if(arr[i] <= minmax.getMin()) {
					minmax.setMin(arr[i]);
				}
			}
			i = i+2;
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

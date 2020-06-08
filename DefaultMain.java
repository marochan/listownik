package pl.edu.agh.automatedgrader.jtp2.lab1.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefaultMain implements Main  {
	static int firstElement = 0;
	static int secondElement = 1;
	static int count = 10;
	static volatile List<Integer> list = new ArrayList<Integer>();
	
	int threadCount;
	
	
	public static void main(String[] args) throws InterruptedException {
		list = new ArrayList<>();
		list.add(firstElement);
		list.add(secondElement);
		System.out.println("how many threads");
		Scanner sc =new Scanner(System.in);
		int threadCount = sc.nextInt();
		System.out.println(list); 
	
		DefaultSum[] ds = new DefaultSum[threadCount];
		for(int j = 0; j < threadCount; j++) {
			ds[j] = new DefaultSum();
		
			
		}
			
	
		
			
	}
	public synchronized List<Integer> sum(int count, int threadCount, int firstElement, int secondElement){
		this.list.add(firstElement);
		this.list.add(secondElement);
		for(int i = 2; i < count; i++) {
			list.add(firstElement+secondElement);
			firstElement = list.get(i-1);
			secondElement = list.get(i);
			System.out.println("xD");
		}
		
		return list;
	}
}

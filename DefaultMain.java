package pl.edu.agh.automatedgrader.jtp2.lab1.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DefaultMain implements Main {
	static volatile int firstElement;
	static volatile int secondElement;
	static  int count = 10;
	public static volatile  List<Integer> lista = new ArrayList<Integer>();
	public static volatile  List<Integer> list = Collections.synchronizedList(lista);
	static int threadCount;

	public static void main(String[] args) throws InterruptedException {
		list.add(0);
		list.add(1);
		
		DefaultMain dm = new DefaultMain();
		System.out.println("how many threads");
		Scanner sc = new Scanner(System.in);
		threadCount = 2;
		firstElement = 0;
		secondElement = 1;
		list = dm.sum(count, threadCount, firstElement, secondElement);
		System.out.println(list);
		
	}

	@Override
	public  List<Integer> sum(int count, int threadCount, int firstElement, int secondElement) {
		

		try {
		for(int i = 0; i < threadCount; i++) {
			DefaultSum ds = new DefaultSum();
			Thread thread = new Thread(ds);
			thread.start();
			thread.join();
			
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
}
package pl.edu.agh.automatedgrader.jtp2.lab1.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DefaultMain implements Main {
	static int firstElement = 0;
	static int secondElement = 1;
	static int count = 10;
	public static List<Integer> lista = new ArrayList<Integer>();
	public static List<Integer> list = Collections.synchronizedList(lista);
	static int threadCount;

	public static void main(String[] args) throws InterruptedException {
		
		list.add(firstElement);
		list.add(secondElement);
		System.out.println("how many threads");
		Scanner sc = new Scanner(System.in);
		threadCount = sc.nextInt();

		Main exa = new DefaultMain();
		exa.sum(count, threadCount, firstElement, secondElement);

	}

	@Override
	public  List<Integer> sum(int count, int threadCount, int firstElement, int secondElement) {
		DefaultSum[] ds = new DefaultSum[threadCount];
		synchronized(list) {
		for (int i = 0; i < DefaultMain.threadCount; i++) {

			new Thread(new DefaultSum()).start();

		}
		return list;
	}
}}

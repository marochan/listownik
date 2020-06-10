package pl.edu.agh.automatedgrader.jtp2.lab1.interfaces;

import java.lang.reflect.Method;
import java.util.List;

import java.lang.reflect.Field;

public class DefaultSum implements Sum {


	@Override
	public void run() {

		int count = getHowMany();
		List<Integer> list = getList();
		int firstElement = list.get(list.size() - 2).intValue();
		int secondElement = list.get(list.size() - 1).intValue();
		int j = 0;

		while (j < count) {
			int adder = firstElement + secondElement;
			list.add(adder);

			System.out.println(list);
			firstElement = secondElement;
			secondElement = adder;

			j++;

		}


	}

	@Override
	public int getHowMany() {

		return DefaultMain.count;
	}

	@Override
	public List<Integer> getList() {

		return DefaultMain.list;
	}
}
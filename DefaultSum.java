package pl.edu.agh.automatedgrader.jtp2.lab1.interfaces;

import java.lang.reflect.Method;
import java.util.List;

import java.lang.reflect.Field;

public class DefaultSum implements Sum {
	DefaultMain main = new DefaultMain();

	DefaultSum() {

	}

	@Override
	public void run() {

		int count = getHowMany();
		List<Integer> list = getList();

		int firstElement = list.get(list.size() - 2).intValue();
		int secondElement = list.get(list.size() - 1).intValue();
		int j = 2;
		while (j < count) {
			int adder = firstElement + secondElement;
			list.add(adder);
			System.out.println(list);
			firstElement = secondElement;
			secondElement = adder;
			if (j == count) {
				notify();
			}
			j++;
		}
		System.out.println(list);

	}

	@Override
	public int getHowMany() {

		try {
			Field[] fields = DefaultMain.class.getFields();
			for (int i = 0; i < fields.length; i++) {
				Object val = fields[i].get(main);
				if (fields[i].getName().equalsIgnoreCase("count")) {
					int number = (Integer) val;
					return number;

				}
			}

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Integer> getList() {

		List<Integer> lista = null;
		try {
			Field[] fields = DefaultMain.class.getFields();
			for (int i = 0; i < fields.length; i++) {
				Object val = fields[i].get(main);
				if (fields[i].getName().equalsIgnoreCase("list")) {
					lista = (List<Integer>) val;
					return lista;
				}
			}

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
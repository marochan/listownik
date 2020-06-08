package pl.edu.agh.automatedgrader.jtp2.lab1.interfaces;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;



import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;;

public class DefaultSum implements Sum {
	DefaultMain main = new DefaultMain();
	Thread t;
	DefaultSum(){
		t = new Thread(this);
		t.start();
		
	}
	@Override
	public void run() {
		try {
		System.out.println("im working" + " " + Thread.currentThread().getName());
		int count = getHowMany();
		List<Integer> list = getList();
		int firstElement = list.get(list.size());
		int secondElement = list.get(list.size());
		Method methodall = main.getClass().getDeclaredMethod("sum", int.class, int.class, int.class, int.class);	
		methodall.invoke(main, count, main.threadCount, firstElement, secondElement);
		
		
	} catch (NoSuchMethodException e) {
		e.printStackTrace();
	}	catch (IllegalAccessException e) { 
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}
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
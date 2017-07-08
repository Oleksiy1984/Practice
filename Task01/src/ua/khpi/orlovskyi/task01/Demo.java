package ua.khpi.orlovskyi.task01;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;


public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractList<String> list = new ArrayList<>();
		Iterator<String> it = list.iterator();
		it.remove();
		list.toString();

	}

}

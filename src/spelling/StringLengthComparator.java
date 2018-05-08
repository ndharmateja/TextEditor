package spelling;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StringLengthComparator implements Comparator<String>{
	
	@Override
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
	
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		list.add("pomegranate");
		list.add("orange");
		list.add("apple");
		list.add("banana");
		System.out.println(list);
		StringLengthComparator comparator = new StringLengthComparator();
		Collections.sort(list, comparator);
		System.out.println(list);

	}

}

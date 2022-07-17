package api.gita.commons;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		Integer value1 = Integer.valueOf((s1).split("-")[0]);
		Integer value2 = Integer.valueOf((s2).split("-")[0]);
		return (value1 > value2) ? 1 : -1;
	}

}

package arrayListCT;

import java.util.Comparator;

public class studentComparater implements Comparator<student> {
	@Override
	public int compare(student s1, student s2) {
		return Integer.compare(s1.getRollno(), s2.getRollno());
	}
	

}

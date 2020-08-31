package stage1;

import java.util.*;

//This Comparator is to compare the distance of the stars
public class Comparator3 implements Comparator<Stars> {

	@Override
	public int compare(Stars o1, Stars o2) {
		if (o1.getDis().equals(o2.getDis())) {
			return 1;
		}
		
		return o1.getDis().compareTo(o2.getDis());
	}
}

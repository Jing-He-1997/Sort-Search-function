package stage1;

import java.util.*;

//This Comparator class is to compare the magnitude of the Stars
public class Comparator2 implements Comparator<Stars> {

	@Override
	public int compare(Stars o1, Stars o2) {
		if (o1.getMag().equals(o2.getMag())) {
			return 1;
		}
		return o1.getMag().compareTo(o2.getMag());
	}

}

package stage1;

import java.util.*;

//This Comparator class is to compare the distance property of CelestialBody
public class Comparator1 implements Comparator<CelestialBody> {

	@Override
	public int compare(CelestialBody o1, CelestialBody o2) {
		if (o1.getDis().equals(o2.getDis())) {
			return 1;
		}
		return o1.getDis().compareTo(o2.getDis());
	}

}

package stage1;

import java.util.*;

//This class is to integrate all the collection and gain the answers
public class SummaryStatistics {
	private TreeMap<String, Integer> tempMap;
	private TreeSet<CelestialBody> celestialBodys;
	private TreeSet<Stars> stars;
	private TreeSet<Stars> stars2;
	private List<Planet> planets;
	private List<Messier> messiers;

	public SummaryStatistics(TreeMap<String, Integer> tempMap, TreeSet<CelestialBody> celestialBodys,
			TreeSet<Stars> stars, TreeSet<Stars> stars2, List<Planet> planets, List<Messier> messiers) {
		this.setTempMap(tempMap);
		this.setCelestialBodys(celestialBodys);
		this.setStars(stars);
		this.setStars2(stars2);
		this.setPlanets(planets);
		this.setMessiers(messiers);
	}

	public TreeMap<String, Integer> getTempMap() {
		return tempMap;
	}

	public void setTempMap(TreeMap<String, Integer> tempMap) {
		this.tempMap = tempMap;
	}

	public TreeSet<CelestialBody> getCelestialBodys() {
		return celestialBodys;
	}

	public void setCelestialBodys(TreeSet<CelestialBody> celestialBodys) {
		this.celestialBodys = celestialBodys;
	}

	public TreeSet<Stars> getStars() {
		return stars;
	}

	public void setStars(TreeSet<Stars> stars) {
		this.stars = stars;
	}

	public TreeSet<Stars> getStars2() {
		return stars2;
	}

	public void setStars2(TreeSet<Stars> stars2) {
		this.stars2 = stars2;
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	public List<Messier> getMessiers() {
		return messiers;
	}

	public void setMessiers(List<Messier> messiers) {
		this.messiers = messiers;
	}


}

package stage1;

import java.io.*;
import java.util.*;

public class AOB {

	//This method is to input specific files and output the answer
	public AOB(String file1, String file2, String file3) {
		TreeMap<String, Integer> tempMap = new TreeMap<String, Integer>();
		TreeSet<CelestialBody> celestialBodys = new TreeSet<CelestialBody>(new Comparator1());
		TreeSet<Stars> stars = new TreeSet<Stars>(new Comparator2());
		TreeSet<Stars> stars2 = new TreeSet<Stars>(new Comparator3());
		List<Planet> planets = new ArrayList<Planet>();
		List<Messier> messiers = new ArrayList<Messier>();
		//Only for the Stars file
		try {

			FileReader fr = new FileReader(file1);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			String[] strs;
			while ((str = bf.readLine()) != null) {
				Stars star = new Stars();
				//intercept the word
				strs = str.split("\\|");
				// delete the extra space
				star.setName(strs[0].trim());
				star.setRA(Double.parseDouble(strs[1].trim()));
				star.setDec(Double.parseDouble(strs[2].trim()));
				star.setMag(Double.parseDouble(strs[3].trim()));
				star.setDis(Double.parseDouble(strs[4].trim()));
				star.setStarType(strs[5].trim());
				star.setCon(strs[6].trim());
				stars.add(star);
				stars2.add(star);
				celestialBodys.add(star);
				//use treemap to calculate and store constellation data in the stars list
				String key = star.getCon();
				if (key.length() > 0) {
					if (!tempMap.containsKey(key)) {
						tempMap.put(key, 1);
					} else {
						int value = tempMap.get(key);
						value++;
						tempMap.put(key, value);
					}
				}
			}

			bf.close();
			fr.close();
			// exception situation
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.out.println("Run Correct file");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.out.println(nfe);
			System.exit(1);
		}

		try {
			FileReader fr = new FileReader(file2);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			String[] strs;
			while ((str = bf.readLine()) != null) {
				Messier messier = new Messier();
				strs = str.split("\\|");
				messier.setName("M" + strs[0].trim());
				messier.setRA(Double.parseDouble(strs[1].trim()));
				messier.setDec(Double.parseDouble(strs[2].trim()));
				messier.setMag(Double.parseDouble(strs[3].trim()));
				messier.setDis(Double.parseDouble(strs[4].trim()));
				messier.setCon(strs[5].trim());
				messier.setDes(strs[6].trim());
				celestialBodys.add(messier);
				messiers.add(messier);
				//use treemap to calculate and store constellation data in the messier list
				String key = messier.getCon();
				if (key.length() > 0) {
					if (!tempMap.containsKey(key)) {
						tempMap.put(key, 1);
					} else {
						int value = tempMap.get(key);
						value++;
						tempMap.put(key, value);
					}

				}

			}

			bf.close();
			fr.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.out.println("Run Correct file");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.out.println(nfe);
			System.exit(1);
		}

		try {
			FileReader fr = new FileReader(file3);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			String[] strs;
			while ((str = bf.readLine()) != null) {
				Planet planet = new Planet();
				strs = str.split("\\s+");
				planet.setName(strs[0].trim());
				planet.setRA(Double.parseDouble(strs[1].trim()));
				planet.setDec(Double.parseDouble(strs[2].trim()));
				planet.setMag(Double.parseDouble(strs[3].trim()));
				planet.setDis(Double.parseDouble(strs[4].trim()));
				celestialBodys.add(planet);
				planets.add(planet);
			}
			
			bf.close();
			fr.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.out.println("Run Correct file");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.out.println(nfe);
			System.exit(1);
		}
        //create new SummaryStatistics class object
		SummaryStatistics statistics = getSummaryStatistics(tempMap, celestialBodys, stars, stars2, planets, messiers);

		toString(statistics);

	}

	public static SummaryStatistics getSummaryStatistics(TreeMap<String, Integer> tempMap, TreeSet<CelestialBody> celestialBodys,
			TreeSet<Stars> stars, TreeSet<Stars> stars2, List<Planet> planets, List<Messier> messiers) {
		SummaryStatistics statistics = new SummaryStatistics(tempMap, celestialBodys, stars, stars2, planets, messiers);
		return statistics;
	}

	// gain the answers
	public void toString(SummaryStatistics statistics) {
		
		// the number of planets, stars and messier
		int Q1 = statistics.getPlanets().size();
		int Q2 = statistics.getMessiers().size();
		int Q3 = statistics.getStars().size();

		// use iterator to gain the shortest and the longest distance of the celestial body
		Iterator<CelestialBody> i4_5 = statistics.getCelestialBodys().iterator();
		List<CelestialBody> celestialBodies1 = new ArrayList<CelestialBody>();
		//to store Q4 answer
		List<String> Q4 = new ArrayList<String>();
		//to store Q5 answer
		List<String> Q5 = new ArrayList<String>();
		while (i4_5.hasNext()) {
			celestialBodies1.add(i4_5.next());
		}
		for (int i = 0; i < celestialBodies1.size(); i++) {
			if (celestialBodies1.get(i).getDis().equals(statistics.getCelestialBodys().first().getDis())) {
				Q4.add(celestialBodies1.get(i).getName());
			}
			if (celestialBodies1.get(i).getDis().equals(statistics.getCelestialBodys().last().getDis())) {
				Q5.add(celestialBodies1.get(i).getName());
			}

		}
		// use iterator to gain the shortest distance of the stars
		Iterator<Stars> i6 = statistics.getStars().iterator();
		List<Stars> stars2 = new ArrayList<Stars>();
		// to store Q6 number
		List<String> Q6 = new ArrayList<String>();
		while (i6.hasNext()) {
			stars2.add(i6.next());
		}
		for (int i = 0; i < stars2.size(); i++) {
			if (stars2.get(i).getDis().equals(statistics.getStars2().first().getDis())) {
				Q6.add(stars2.get(i).getName());
			}

		}
		// use iterator to gain the smallest and the biggest magnitude of the stars
		Iterator<Stars> i7_8 = statistics.getStars().iterator();
		List<Stars> stars1 = new ArrayList<Stars>();
		//to store Q7 answer
		List<String> Q7 = new ArrayList<String>();
		//to store Q8 answer
		List<String> Q8 = new ArrayList<String>();
		while (i7_8.hasNext()) {
			stars1.add(i7_8.next());
		}
		for (int i = 0; i < stars1.size(); i++) {
			if (stars1.get(i).getMag().equals(statistics.getStars().first().getMag())) {
				Q7.add(stars1.get(i).getName());
			}
			if (stars1.get(i).getMag().equals(statistics.getStars().last().getMag())) {
				Q8.add(stars1.get(i).getName());
			}

		}
		// gain the Q9 answer
		int Q9 = statistics.getTempMap().size();

		// to sort the treemap according to the value
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
				statistics.getTempMap().entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		List<String> treemap = new ArrayList<String>();
		//store Q10 number
		List<String> Q10 = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : list) {
			treemap.add(entry.getKey());
		}
		for (int i = 0; i < treemap.size(); i++) {
			if (treemap.get(i).equals(treemap.get(treemap.size() - 1))) {
				Q10.add(treemap.get(i));
			}
		}

		System.out.println("Q1:" + Q1 + " Q2:" + Q2 + " Q3:" + Q3 + " Q4:" + Q4 + " Q5:" + Q5 + " Q6:" + Q6 + " Q7:"
				+ Q7 + " Q8:" + Q8 + " Q9:" + Q9 + " Q10:" + Q10);

	}

	public static void main(String[] args) {
		AOB aob = new AOB(args[0], args[1], args[2]);
	}
}
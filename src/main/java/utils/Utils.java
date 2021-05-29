package utils;

import java.util.ArrayList;

public class Utils {
	
	public ArrayList<Character> separarCaracteres(String string) {
		ArrayList<Character> algarismos = new ArrayList<Character>();
		for (char c : string.toCharArray()) {
			algarismos.add(c);
		}
		return algarismos;
	}
	
}

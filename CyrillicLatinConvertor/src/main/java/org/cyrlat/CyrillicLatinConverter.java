package org.cyrlat;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains methods for conversion between latin and Serbian 
 * cyrillic texts.
 * 
 * Example of use:
 * CyrillicLatinConverter.latinToCyrillic("Some latin text")
 * 
 * @author Milorad Kukic
 * @version 1.0, July 2012
 */
public class CyrillicLatinConverter {

	static char[] cyrilic = new char[] {
			'\u0410', 	'\u0430',	//A
			'\u0411',	'\u0431',	//B
			'\u0412', 	'\u0432',	//V
			'\u0413', 	'\u0433',	//G
			'\u0414',	'\u0434',	//D
			'\u0402',	'\u0452',	//?
			'\u0415', 	'\u0435',	//E
			'\u0416',	'\u0436',	//?
			'\u0417',	'\u0437',	//Z			
			'\u0418',	'\u0438',	//I
			'\u0408',	'\u0458',	//J
			'\u041A',	'\u043A',	//K
			'\u041B',	'\u043B',	//L
			'\u0409',	'\u0459',	//Lj
			'\u041C',	'\u043C',	//M
			'\u041D',	'\u043D',	//N
			'\u040A',	'\u045A',	//Nj
			'\u041E', 	'\u043E',	//O
			'\u041F',	'\u043F', 	//P
			'\u0420',	'\u0440',	//R
			'\u0421',	'\u0441',	//S
			'\u0422',	'\u0442',	//T
			'\u040B',	'\u045B',	//?
			'\u0423',	'\u0443',	//U
			'\u0424',	'\u0444',	//F
			'\u0425',	'\u0445',	//H
			'\u0426',	'\u0446',	//C	
			'\u0427', 	'\u0447',	//?
			'\u040F',	'\u045F',	//D?
			'\u0428',	'\u0448'	//?
	};
	
	static String[] latin = new String[] {
			"A", 		"a",
			"B",		"b",
			"V",		"v",
			"G",		"g",
			"D",		"d",
			"\u0110",	"\u0111",
			"E",		"e",
			"\u017D",	"\u017E",
			"Z",		"z",
			"I",		"i",
			"J",		"j",
			"K",		"k",
			"L",		"l",
			"Lj",		"lj",
			"M",		"m",
			"N",		"n",
			"Nj",		"nj",
			"O",		"o",
			"P",		"p",
			"R",		"r",
			"S",		"s",
			"T",		"t",
			"\u0106",	"\u0107",
			"U",		"u",
			"F",		"f",
			"H",		"h",
			"C",		"c",
			"\u010C",	"\u010D",
			"D\u017E",	"d\u017E",
			"\u0160",	"\u0161"};
	
	/**
	 * Mapping of cyrillic characters to latin characters.
	 */
	static Map<Character, String> cyrMapping = new HashMap<Character, String>();
	/**
	 * Mapping of latin characters to cyrillic characters.
	 */
	static Map<String, Character> latMapping = new HashMap<String, Character>();
		
	// Static initialization of mappings between cyrillic and latin letters.
	static {			
		for (int i=0; i < cyrilic.length; i++) {
			cyrMapping.put(new Character(cyrilic[i]), latin[i]);
			latMapping.put(latin[i], new Character(cyrilic[i]));
		}
	}

	//*************************************************************************
	//*                            API methods                                *
	//*************************************************************************
	
	/**
	 * Converts latin text to Serbian cyrillic
	 * 
	 * @param latinText - Latin text to be converted to cyrillic.
	 * 
	 * @return - Serbian cyrillic representation of given latin text.
	 * */
	public static String latinToCyrillic(String latinText) {
		StringBuffer latBuffer = new StringBuffer(latinText);
		StringBuffer cyrBuffer = new StringBuffer();

		for (int i=0; i < latBuffer.length(); i++) {
			String s = latBuffer.substring(i, i+1);
			if (i < latBuffer.length() - 1 ) {
				char c = latBuffer.charAt(i+1);
				if (((s.equals("L") || s.equals("l")
				|| s.equals("N") || s.equals("n")) && (c == 'J' || c == 'j'))) {
					s = s + 'j';
					i++;
				} else if ((s.equals("D") || s.equals("d")) 
						&& (c == '\u017D' || c == '\u017E')) {
					s = s + '\u017E';
					i++;
				}
			}
			if (latMapping.containsKey(s)) {
				cyrBuffer.append(((Character)latMapping.get(s)).charValue());
			} else {
				cyrBuffer.append(s);
			}
		}
		return cyrBuffer.toString();
	}
	
	/**
	 * Converts given Serbian cyrillic text to latin text.
	 * 
	 * @param cyrillicText - Cyrillic text to be converted to latin text.
	 * 
	 * @return latin representation of given cyrillic text.
	 * */
	public static String cyrilicToLatin(String cyrillicText) {
		StringBuffer cyrBuffer = new StringBuffer(cyrillicText);
		StringBuffer latinBuffer = new StringBuffer();
		for (int i = 0; i < cyrBuffer.length(); i++) {
			char c = cyrBuffer.charAt(i);
			Character character = new Character(c);
			if (cyrMapping.containsKey(character)) {
				latinBuffer.append(cyrMapping.get(character));
			} else {
				latinBuffer.append(c);
			}			
		}
		return latinBuffer.toString();
	}

}

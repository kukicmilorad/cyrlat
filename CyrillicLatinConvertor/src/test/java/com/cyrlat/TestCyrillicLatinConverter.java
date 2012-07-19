package com.cyrlat;

import junit.framework.TestCase;

import org.cyrlat.CyrillicLatinConverter;
import org.junit.Test;

/**
 * Test case which verify that conversion between cyrillic and latin text works
 * as expected.
 * 
 * @author Milorad Kukic
 */
public class TestCyrillicLatinConverter extends TestCase {
	
	@Test
	public void testConvertLatinToCyrillic(){
		String latinText = "Ulica Njego\u0161eva";
		String expected = "\u0423\u043B\u0438\u0446\u0430 \u040A\u0435\u0433\u043E\u0448\u0435\u0432\u0430";
		assertEquals(expected, CyrillicLatinConverter.latinToCyrillic(latinText));
		
		latinText = "Zdjelar";
		expected = "\u0417\u0434\u0458\u0435\u043B\u0430\u0440";
		assertEquals(expected, CyrillicLatinConverter.latinToCyrillic(latinText));
		
		latinText = "\u0160anji";
		expected = "\u0428\u0430\u045A\u0438";
		assertEquals(expected, CyrillicLatinConverter.latinToCyrillic(latinText));
		
		latinText = "Ljiljana";
		expected = "\u0409\u0438\u0459\u0430\u043D\u0430";
		assertEquals(expected, CyrillicLatinConverter.latinToCyrillic(latinText));
	}
	
	public void testConvertCyrillicToLatin(){
		String cyrillicText = "\u0423\u043B\u0438\u0446\u0430 \u040A\u0435\u0433\u043E\u0448\u0435\u0432\u0430";
		String expected = "Ulica Njego\u0161eva";
		assertEquals(expected, CyrillicLatinConverter.cyrilicToLatin(cyrillicText));
		
		cyrillicText = "\u0428\u0430\u045A\u0438";
		expected = "\u0160anji";
		assertEquals(expected, CyrillicLatinConverter.cyrilicToLatin(cyrillicText));
		
		cyrillicText = "\u0409\u0438\u0459\u0430\u043D\u0430";
		expected = "Ljiljana";
		assertEquals(expected, CyrillicLatinConverter.cyrilicToLatin(cyrillicText));
	}
}

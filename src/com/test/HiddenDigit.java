package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HiddenDigit {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File file = new File("files/easy/test_HiddenDigits.txt");
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			StringBuffer buff = new StringBuffer();
			for (char c : line.toCharArray()) {
				switch (c) {
				case '0':
				case 'a':
					buff.append('0');
					break;
				case '1':
				case 'b':
					buff.append('1');
					break;
				case '2':
				case 'c':
					buff.append('2');
					break;
				case '3':
				case 'd':
					buff.append('3');
					break;
				case '4':
				case 'e':
					buff.append('4');
					break;
				case '5':
				case 'f':
					buff.append('5');
					break;
				case '6':
				case 'g':
					buff.append('6');
					break;
				case '7':
				case 'h':
					buff.append('7');
					break;
				case '8':
				case 'i':
					buff.append('8');
					break;
				case '9':
				case 'j':
					buff.append('9');
				}
			}
			if (buff.length() == 0)
				buff.append("NONE");
			System.out.println(buff);
		}
	}
}
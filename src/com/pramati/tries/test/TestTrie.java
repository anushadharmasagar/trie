/** COPYRIGHT (C) 2015 Anusha. All Rights Reserved. */

package com.pramati.tries.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.pramati.tries.TrieImpl;
import com.pramati.tries.builder.TrieBuilder;
import com.pramati.tries.exceptions.NoSuchFileException;
import com.pramati.tries.utils.CleanWord;

/**
 * class to perform trie operations manually.
 * 
 * @author anusha
 *
 */
public class TestTrie {

	public static void main(String[] args) throws IOException {

		char choice;

		TrieBuilder trieBuilder = new TrieBuilder();
		TrieImpl trie = new TrieImpl();

		try {
			FileInputStream fileip = trieBuilder
					.setInputStream("/home/anusha/Desktop/words11");
			trie = trieBuilder.trieBuild(fileip);
		} catch (NoSuchFileException e) {
			throw new NoSuchFileException("no such file exists", e);
		}

		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("enter the word to be searched");
			String inword = new String();
			inword = scan.next();
			inword = CleanWord.cleanUp(inword);
			System.out.println("required word found :" + trie.search(inword));
			System.out.println("enter 'y' to continue");
			choice = scan.next().charAt(0);
		} while (choice == 'y');

		do {
			System.out.println("enter the prefix of the word");
			String prefix = new String();
			prefix = scan.next();
			prefix = CleanWord.cleanUp(prefix);
			List list = trie.prefixSearch(prefix);
			if (list == null || list.size() == 0)
				System.out.println("no element found");
			else {
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
			}
			System.out.println("enter 'y' to continue");
			choice = scan.next().charAt(0);
		} while (choice == 'y');
		scan.close();

	}

}

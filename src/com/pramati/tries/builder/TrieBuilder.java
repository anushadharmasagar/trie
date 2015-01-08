/** COPYRIGHT (C) 2015 Anusha. All Rights Reserved. */

package com.pramati.tries.builder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.pramati.tries.TrieImpl;
import com.pramati.tries.exceptions.NoSuchFileException;
import com.pramati.tries.utils.CleanWord;

/**
 * class to build trie for given input stream
 * 
 * @author anusha
 *
 */

public class TrieBuilder {

	public TrieImpl trieBuild(FileInputStream inputStream)
			throws IOException {

		TrieImpl trie = new TrieImpl();
		String word = new String();
		BufferedReader br = null;

		br = new BufferedReader(new InputStreamReader(inputStream));
		while ((word = br.readLine()) != null) {
			word = CleanWord.cleanUp(word);
			trie.add(word);
			System.out.println(word);
		}
		br.close();
		return trie;
	}
	
	public FileInputStream setInputStream(String path) throws FileNotFoundException
	{
		FileInputStream fileip = null;

		try {
			fileip = new FileInputStream(path);
		} catch (NoSuchFileException e) {
			throw new NoSuchFileException("no such file exists", e);
		}
		return fileip;
	}
}

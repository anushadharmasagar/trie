package com.pramati.tries.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.pramati.tries.Trie;
import com.pramati.tries.TrieImpl;
import com.pramati.tries.builder.TrieBuilder;

public class JunitTestTrie {

	public Trie initialize() throws IOException {
		Trie trie = new TrieImpl();
		TrieBuilder trieBuilder = new TrieBuilder();
		BufferedReader br = null;
		FileInputStream fileip = null;
		try {
			fileip = new FileInputStream("/home/anusha/Desktop/words11");
			try {
				trie = trieBuilder.trieBuild(fileip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
		return trie;
	}

	@Test
	public void testTrieOperations() throws IOException {
		JunitTestTrie obj = new JunitTestTrie();
		String[] expectedOutput1 = { "aas", "as", "a" };
		String[] expectedOutput2 = { "bas", "baal", "baals", "baath", "baaths",
				"baathist" };

		Trie trie = obj.initialize();
		try {

			assertEquals(false, trie.add(null));
			assertEquals(false, trie.add(""));
			assertEquals(true, trie.add("pramati"));
			assertEquals(true, trie.add("India"));

			assertEquals("word exists but not found", true,
					trie.search("tudes"));
			assertEquals("word dosen't exists", true, trie.search("pramati"));
			assertEquals(false, trie.search("technologies"));

			assertEquals("NO such word occured", 0,
					trie.prefixCounter("", trie));
			assertEquals(3, trie.prefixCounter("a", trie));
			assertEquals(1, trie.prefixCounter("aa", trie));
			assertEquals(6, trie.prefixCounter("ba", trie));

			assertArrayEquals(expectedOutput1, trie.prefixSearch("a").toArray());
			assertArrayEquals(expectedOutput2, trie.prefixSearch("ba").toArray());

		} catch (AssertionError ex) {
			System.out.println("exception occured " + ex);
		}
	}
}

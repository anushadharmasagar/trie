/** COPYRIGHT (C) 2015 Anusha. All Rights Reserved. */
package com.pramati.tries;

import java.util.List;

/**
 * Interface describing behavior of Trie Operations.
 * 
 * @author anusha
 *
 */
public interface Trie {

	public boolean add(String word);

	public boolean search(String word);

	public List<String> prefixSearch(String prefix);

	public int prefixCounter(String prefix, Trie trie);
}

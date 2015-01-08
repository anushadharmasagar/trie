/** COPYRIGHT (C) 2015 Anusha. All Rights Reserved. */

package com.pramati.tries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.pramati.tries.TrieNode;
import com.pramati.tries.utils.*;

/**
 * a class to implement trie structure. solves pramati assignment #1
 * 
 * @author anusha
 * @version 1.1 06/01/2015
 */

public class TrieImpl implements Trie {
	private TrieNode root;

	/**
	 * Constructor
	 **/
	public TrieImpl() {
		root = new TrieNode(' ');
	}

	/**
	 * adds string to root trie.
	 *
	 * @param word
	 *            to be added.
	 **/
	public boolean add(String word) {

		if (word == "" || word == null) {
			return false;
		}

		if (search(word))
			return false;
		TrieNode current = root;

		for (char ch : word.toCharArray()) {
			ch = Character.toLowerCase(ch);
			TrieNode child = subNode(ch, current);
			if (child != null)
				current = child;
			else {
				TrieNode[] travs = current.getChildList();
				travs[ch % 'a'] = new TrieNode(ch);
				current.setChildList(travs);
				current = subNode(ch, current);
			}
			current.setCount(current.getCount() + 1);
		}
		current.setIsEnd(true);
		return true;
	}

	/**
	 * searches string in root trie.
	 *
	 * @param word
	 *            to be searched.
	 * @return the boolean value true if string found.
	 **/
	public boolean search(String word) {

		if (word == "" || word == null) {
			return false;
		}
		word = CleanWord.cleanUp(word);
		TrieNode current = root;
		for (char ch : word.toLowerCase().toCharArray()) {
			if (subNode(ch, current) == null)
				return false;
			current = subNode(ch, current);
		}
		return current.getisEnd();
	}

	/**
	 * traverses through the root trie.
	 *
	 * @param character
	 *            to be searched.
	 * @param current
	 *            node.
	 * @return Trienode at which the character matches.
	 **/
	private TrieNode subNode(char c, TrieNode curr) {
		TrieNode[] temp = curr.getChildList();
		if (temp[c % 'a'] != null) {
			if (temp[c % 'a'].getContent() == c)
				return temp[c % 'a'];
		}
		return null;
	}

	/**
	 * search words for the given prefix
	 * 
	 * @param current
	 * @return
	 */
	public List prefixSearch(String prefix) {
		if (prefix == null || prefix.isEmpty())
			return null;

		char[] chars = prefix.toCharArray();
		TrieNode start = root;
		boolean flag = false;
		for (char c : chars) {
			TrieNode[] child = start.getChildList();
			if (child[c % 'a'] != null) {
				start = child[c % 'a'];
				flag = true;
			} else
				break;
		}

		if (flag) {
			List matches = getAllWords(start, prefix);
			return matches;
		}
		return null;
	}

	/**
	 * retrival of all words from last possible node
	 * 
	 * @param starting
	 *            node to search
	 * @param prefix
	 *            to be searched
	 * @return
	 */

	private List<String> getAllWords(TrieNode start, final String prefix) {
		List<String> resultlist = new ArrayList<String>();
		if (start == null
				|| (start.getCount() == 0 && start.getisEnd() == true)) {
			resultlist.add(prefix);
			return resultlist;
		}
		TrieNode[] travs = start.getChildList();

		for (int i = 0; i < Constants.ALPHABET_SIZE; i++) {
			if (travs[i] != null) {
				resultlist.addAll(getAllWords(travs[i],
						prefix + travs[i].getContent()));
			}
		}
		if (start.getisEnd() == true) {
			resultlist.add(prefix);
			return resultlist;
		}
		return resultlist;
	}

	public int prefixCounter(String prefix, Trie trie) {

		int count = 0;
		prefix = CleanWord.cleanUp(prefix);
		List<String> list = trie.prefixSearch(prefix);
		if (list == null || list.size() == 0)
			return count;
		else {
			for (int i = 0; i < list.size(); i++) {
				// System.out.println(list.get(i));
				count++;
			}
		}
		return count;
	}
}

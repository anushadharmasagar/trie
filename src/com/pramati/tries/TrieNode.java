/** COPYRIGHT (C) 2014 Anusha. All Rights Reserved. */

package com.pramati.tries;

import com.pramati.tries.utils.*;

/**
 * a class to implement trie structure. solves pramati assignment #1
 * 
 * @author anusha
 * @version 1.1 22/12/2014
 */

public class TrieNode {

	private char content;
	private int count;
	private boolean isEnd;
	private TrieNode[] childList;

	/**
	 * default constructor
	 */
	public TrieNode() {

	}

	/**
	 * Parameterized constructor
	 * 
	 * @param character
	 *            of which TrieNode must be created
	 */
	public TrieNode(char c) {
		childList = new TrieNode[Constants.ALPHABET_SIZE];
		isEnd = false;
		content = c;
		count = -1;
	}

	/**
	 * @return content data
	 */
	public char getContent() {
		return content;
	}

	/**
	 * 
	 * @param char data to be assigned to content
	 */
	public void setContent(char content) {
		this.content = content;
	}

	/**
	 * @return childList data
	 */
	public TrieNode[] getChildList() {
		return childList;
	}

	/**
	 * @param to
	 *            change childList values
	 */
	public void setChildList(TrieNode[] childList) {
		this.childList = childList;
	}

	/**
	 * @param to
	 *            set isEnd parameter
	 */
	public void setIsEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	/**
	 * @param to
	 *            set count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return count value
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return isEnd value
	 */
	public boolean getisEnd() {
		return isEnd;
	}

	@Override
	public String toString() {
		return "content is " + this.content + "and isEnd " + this.isEnd;
	}
}

package com.gandb.xml;

public class MatchedElement {
	private int start;
	private int length;
	private char ch[];
	boolean isProcessing = false;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public char[] getCh() {
		return ch;
	}

	public void setCh(char[] ch) {
		this.ch = ch;
	}

	public boolean isProcessing() {
		return isProcessing;
	}

	public void setProcessing(boolean isProcessing) {
		this.isProcessing = isProcessing;
	}

}

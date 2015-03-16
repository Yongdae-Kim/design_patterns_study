package com.jejunu.scratchback;

public abstract class Entry {
	public abstract String getName();

	public abstract int getSize();

	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}

	protected abstract void printList(String prefix);

	public void printList() {
		printList("");
	}

	public String toString() {
		return getName() + " (" + getSize() + ")";
	}

}

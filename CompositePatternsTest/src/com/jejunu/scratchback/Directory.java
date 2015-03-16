package com.jejunu.scratchback;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {

	private String name;
	@SuppressWarnings("rawtypes")
	private Vector directory = new Vector<>();

	public Directory(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		int size = 0;
		@SuppressWarnings("rawtypes")
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			size += entry.getSize();
		}
		return size;
	}

	@SuppressWarnings("unchecked")
	public Entry add(Entry entry) {
		directory.add(entry);
		return this;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);
		@SuppressWarnings("rawtypes")
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			entry.printList(prefix + "/" + name);
		}
	}

}

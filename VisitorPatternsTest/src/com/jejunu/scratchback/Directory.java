package com.jejunu.scratchback;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {

	private String name;
	@SuppressWarnings("rawtypes")
	private Vector dir = new Vector<>();

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
		Iterator it = dir.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			size += entry.getSize();
		}
		return size;
	}

	@SuppressWarnings("unchecked")
	public Entry add(Entry entry) {
		dir.add(entry);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public Iterator iterator() {
		return dir.iterator();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}

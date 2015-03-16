package com.jejunu.scratchback;

public class Main {
	public static void main(String[] args) {

		try {
			System.out.println("making root entries...");

			Directory rootDir = new Directory("root");
			Directory binDir = new Directory("bin");
			Directory tmpDir = new Directory("tmp");
			Directory userDir = new Directory("user");

			rootDir.add(binDir);
			rootDir.add(tmpDir);
			rootDir.add(userDir);

			binDir.add(new File("vi", 10000));
			binDir.add(new File("latex", 20000));

			rootDir.accept(new ListVisitor());

			System.out.println("");
			System.out.println("making user entries...");

			Directory kim = new Directory("kim");
			Directory lee = new Directory("lee");
			Directory kang = new Directory("kang");

			userDir.add(kim);
			userDir.add(lee);
			userDir.add(kang);

			kim.add(new File("diary.html", 100));
			kim.add(new File("composite.java", 200));

			lee.add(new File("memo.txt", 300));

			kang.add(new File("game.doc", 400));
			kang.add(new File("junk.mail", 500));

			rootDir.accept(new ListVisitor());

		} catch (FileTreatmentException e) {
			System.out.println(e.getMessage());
		}
	}
}

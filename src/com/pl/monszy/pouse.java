package com.pl.monszy;

public class pouse {

	public static void Sec(long s) {
		try {
			Thread.currentThread();
			Thread.sleep(s * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

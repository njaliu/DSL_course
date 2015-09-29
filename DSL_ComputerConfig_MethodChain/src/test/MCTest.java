package test;

import builder.*;
import entity.*;

public class MCTest {
	public static void test_script_01() {
		Computer c = ComputerBuilder.computer()
										.processor()
											.cores(2)
											.speed(2500)
											.i386()
										.disk()
											.size(150)
										.disk()
											.size(75)
											.speed(7200)
											.sata()
										.end();
		System.out.println("Done! " + c.processor.cores);	
	}
	
	public static void main(String[] args) {
		MCTest.test_script_01();
	}
}

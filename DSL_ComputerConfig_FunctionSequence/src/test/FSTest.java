package test;

import builder.ComputerBuilder;

public class FSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComputerBuilder cb = new ComputerBuilder();
		cb.test_script_01();
		System.out.println("Done! " + cb.getProcessorBuilder().cores);
	}

}

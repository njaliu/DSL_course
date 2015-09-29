package builder;

import entity.Computer;
import entity.Disk;
import entity.Processor;

public class Builder {
	static Processor processor(int cores, int speed, Processor.Type type) {
		return new Processor(cores, speed, type);
	}
	
	static int cores(int value) {
		return value;
	}
	
	static int speed(int value) {
		return value;
	}
	
	static int size(int value) {
		return value;
	}
	
	static final Processor.Type i386 = Processor.Type.i386;
	
	static final Disk.Interface SATA = Disk.Interface.SATA;
	
	static Disk disk(int size, int speed, Disk.Interface iface) {
		return new Disk(size, speed, iface);
	}
	
	static Disk disk(int size) {
		return new Disk(size, Disk.UNKNOWN_SPEED, null);
	}
	
	static Disk disk(int size, int speed) {
		return new Disk(size, speed, null);
	}
	
	static Disk disk(int size, Disk.Interface iface) {
		return new Disk(size, Disk.UNKNOWN_SPEED, iface);
	}
	
	static Computer computer(Processor p, Disk... d) {
		return new Computer(p, d);
	}
	
	//test script
	public void test_script_01() {
			computer(
				processor(
					cores(2),
					speed(2500),
					i386
				),
				disk(
					size(150)
				),
				disk(
					size(75),
					speed(7200),
					SATA
				)
			);
	}
}

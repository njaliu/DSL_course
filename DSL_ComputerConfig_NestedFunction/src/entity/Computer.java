package entity;

public class Computer {
	public Processor processor;
	public Disk[] disks;
	
	public Computer(Processor processor, Disk[] disks) {
		this.processor = processor;
		this.disks = disks;
	}
}

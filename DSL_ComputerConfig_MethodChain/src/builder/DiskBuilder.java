package builder;

import entity.Computer;
import entity.Disk;

public class DiskBuilder {
	private int size;
	private int speed;
	private Disk.Interface iface;
	private ComputerBuilder parent;
	
	public DiskBuilder(ComputerBuilder parent) {
		this.parent = parent;
	}
	
	public DiskBuilder size(int arg) {
		this.size = arg;
		return this;
	}
	
	public DiskBuilder speed(int arg) {
		this.speed = arg;
		return this;
	}
	
	public DiskBuilder sata() {
		this.iface = Disk.Interface.SATA;
		return this;
	}
	
	public DiskBuilder disk() {
		return parent.disk();
	}
	
	public Disk getValue() {
		return new Disk(size, speed, iface);
	}
	
	public Computer end() {
		return parent.end();
	}
}

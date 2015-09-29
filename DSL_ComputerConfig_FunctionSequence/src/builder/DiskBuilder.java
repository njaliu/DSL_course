package builder;

import entity.Computer;
import entity.Disk;

public class DiskBuilder {
	public int size;
	public int speed;
	public Disk.Interface iface;
	
	public Disk getValue() {
		return new Disk(size, speed, iface);
	}
}

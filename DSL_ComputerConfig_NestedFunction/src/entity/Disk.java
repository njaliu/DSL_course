package entity;

public class Disk {
	int size;
	int speed;
	public static final int UNKNOWN_SPEED = -1234;
	
	public enum Interface {
		SATA, SATA1, SATA2;
	}
	
	Interface iface;
	
	public Disk(int size, int speed, Interface iface) {
		this.size = size;
		this.speed = speed;
		this.iface = iface;
	}
}

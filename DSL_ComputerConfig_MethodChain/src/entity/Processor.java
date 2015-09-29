package entity;

public class Processor {
	public int cores;
	public int speed;
	
	public enum Type {
		i386, i586, i686;
	}
	
	Type type;
	
	public Processor(int cores, int speed, Type type) {
		this.cores = cores;
		this.speed = speed;
		this.type = type;
	}
}

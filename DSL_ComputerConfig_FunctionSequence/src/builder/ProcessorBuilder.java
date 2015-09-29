package builder;

import entity.Processor;

public class ProcessorBuilder {
	private static final int DEFAULT_CORES = 1;
	private static final int DEFAULT_SPEED = -1;
	
	public int cores = DEFAULT_CORES;
	public int speed = DEFAULT_SPEED;
	public Processor.Type type;
	
	Processor getValue() {
		return new Processor(cores, speed, type);
	}
}

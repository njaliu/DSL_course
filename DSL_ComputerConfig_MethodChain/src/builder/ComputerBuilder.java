package builder;

import java.util.ArrayList;
import java.util.List;

import entity.Computer;
import entity.Disk;
import entity.Processor;

public class ComputerBuilder {
	private ProcessorBuilder currentProcessor;
	private DiskBuilder currentDisk;
	
	public ComputerBuilder() {
		
	}
	
	public static ComputerBuilder computer() {
		return new ComputerBuilder();
	}
	
	public ComputerBuilder processor() {
		currentProcessor = new ProcessorBuilder();
		return this;
	}
	
	public ComputerBuilder cores(int arg) {
		currentProcessor.cores = arg;
		return this;
	}
	
	public ComputerBuilder speed(int arg) {
		currentProcessor.speed = arg;
		return this;
	}
	
	public ComputerBuilder i386() {
		currentProcessor.type = Processor.Type.i386;
		return this;
	}
	
	List<Disk> loadedDisks = new ArrayList<Disk>();
	public DiskBuilder disk() {
		if(currentDisk != null)
			loadedDisks.add(currentDisk.getValue());
		currentDisk = new DiskBuilder(this);
		return currentDisk;
	}
	
	public Computer getValue() {
		return new Computer(currentProcessor.getValue(), disks());
	}

	public Computer end() {
		return getValue();
	}
	
	private Disk[] disks() {
		List<Disk> result = new ArrayList<Disk>();
		result.addAll(loadedDisks);
		if(currentDisk != null) 
			result.add(currentDisk.getValue());
		return result.toArray(new Disk[result.size()]);
	}
}

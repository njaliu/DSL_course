package builder;

import java.util.ArrayList;
import java.util.List;
import entity.*;

public class ComputerBuilder {
	private ProcessorBuilder processor;
	private List<DiskBuilder> disks = new ArrayList<DiskBuilder>();
	
	private ProcessorBuilder currentProcessor;
	private DiskBuilder currentDisk;
	
	void computer() {
		currentProcessor = null;
		currentDisk = null;
	}
	
	void processor() {
		currentProcessor = new ProcessorBuilder();
		processor = currentProcessor;
		currentDisk = null;
	}
	
	void disk() {
		currentDisk = new DiskBuilder();
		disks.add(currentDisk);
		currentProcessor = null;
	}
	
	void cores(int arg) {
		currentProcessor.cores = arg;
	}
	
	void i386() {
		currentProcessor.type = Processor.Type.i386;
	}
	
	void size(int arg) {
		currentDisk.size = arg;
	}
	
	void sata() {
		currentDisk.iface = Disk.Interface.SATA;
	}
	
	void speed(int arg) {
		if(currentProcessor != null) 
			currentProcessor.speed = arg;
		else if(currentDisk != null)
			currentDisk.speed = arg;
		else
			throw new IllegalStateException();
	}
	
	private Disk[] getDiskValues() {
		Disk[] result = new Disk[disks.size()];
		for(int i = 0; i < disks.size(); i++) {
			result[i] = disks.get(i).getValue();
		}
		return result;
	}
	
	Computer getValue() {
		return new Computer(processor.getValue(), getDiskValues());
	}
	
	public ProcessorBuilder getProcessorBuilder() {
		return this.processor;
	}
	
	//test script
	public void test_script_01() {
		computer();
			processor();
				cores(2);
				speed(2500);
				i386();
			disk();
				size(1500);
			disk();
				size(75);
				speed(7200);
				sata();
	}
}

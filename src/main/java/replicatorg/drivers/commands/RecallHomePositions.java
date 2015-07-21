package replicatorg.drivers.commands;

import replicatorg.drivers.Driver;
import replicatorg.drivers.RetryException;
import replicatorg.machine.model.AxisId;

import java.util.EnumSet;

public class RecallHomePositions implements DriverCommand {

	EnumSet<AxisId> axes;
	
	public RecallHomePositions(EnumSet<AxisId> axes) {
		this.axes = axes;
	}
	@Override
	public void run(Driver driver) throws RetryException {
		driver.recallHomePositions(axes);
	}
}

package replicatorg.drivers.commands;

import replicatorg.drivers.Driver;
import replicatorg.drivers.RetryException;
import replicatorg.machine.model.AxisId;

import java.util.EnumSet;

public class StoreHomePositions implements DriverCommand {

	EnumSet<AxisId> axes;
	
	public StoreHomePositions(EnumSet<AxisId> axes) {
		this.axes = axes;
	}
	@Override
	public void run(Driver driver) throws RetryException {
		driver.storeHomePositions(axes);
	}
}

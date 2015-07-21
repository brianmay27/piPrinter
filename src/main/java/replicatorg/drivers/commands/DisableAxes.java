package replicatorg.drivers.commands;

import replicatorg.drivers.Driver;
import replicatorg.drivers.RetryException;
import replicatorg.drivers.StopException;
import replicatorg.machine.model.AxisId;

import java.util.EnumSet;

public class DisableAxes implements DriverCommand {

	EnumSet<AxisId> axes;
 
	public DisableAxes(EnumSet<AxisId> axes) {
		this.axes = axes;
	}

	@Override
	public void run(Driver driver) throws RetryException, StopException {
		driver.disableAxes(axes);
	}

}

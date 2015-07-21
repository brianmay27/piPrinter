package replicatorg.app;

import replicatorg.app.gcode.MutableGCodeSource;
import replicatorg.machine.Machine;
import replicatorg.machine.MachineCallbackHandler;
import replicatorg.machine.MachineFactory;
import replicatorg.model.GCodeSource;

import java.io.File;

/**
 * Created by brian on 7/17/15.
 */
public class Printer {

    public void Print(GCodeSource source) {
        MachineCallbackHandler handler = new MachineCallbackHandler();
        Machine machine = MachineFactory.load("The Replicator Dual", handler);
        machine.connect("/dev/ttyACM0");
        machine.buildDirect(source);
        handler.getState();
    }
}

package replicatorg.app;

import replicatorg.app.gcode.MutableGCodeSource;
import replicatorg.machine.Machine;
import replicatorg.machine.MachineCallbackHandler;
import replicatorg.machine.MachineFactory;
import replicatorg.machine.MachineListener;
import replicatorg.model.GCodeSource;
import replicatorg.model.StringListSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by brian on 7/17/15.
 */
public class Printer {


    private boolean bedoccupied = false;
    private Machine machine;
    private MachineCallbackHandler handler;
    private MachineServiceListener machineListener;

    public Printer() {
        machineListener = new MachineServiceListener();
        handler = new MachineCallbackHandler();
        machine = MachineFactory.load("The Replicator Dual", handler);
        handler.addMachineListener(machineListener);
    }

    public void Print(String source) {
        if (!machineListener.isPrinting() && !bedoccupied) {
            File file = new File(source);
            GCodeSource gcode = new MutableGCodeSource(file);
            machine.connect("/dev/ttyACM0");
            machine.buildDirect(gcode);
        }
    }

    public int getProgress() {
        return machineListener.getProgress();
    }


    public void bedCleared() {
        this.bedoccupied = false;
    }
}

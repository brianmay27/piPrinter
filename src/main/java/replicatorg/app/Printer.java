package replicatorg.app;

import configuration.Settings;
import context.BeanLoader;
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


    private boolean bedOccupied = false;
    private Machine machine;
    private MachineCallbackHandler handler;
    private MachineServiceListener machineListener;
    private String machineType;
    private String port;

    public Printer() {
        Settings settings = BeanLoader.get().get(Settings.class);
        this.machineType = settings.getMachineType();
        this.port = settings.getPort();
        machineListener = new MachineServiceListener();
        handler = new MachineCallbackHandler();
        machine = MachineFactory.load(machineType, handler);
        handler.addMachineListener(machineListener);
    }

    public void Print(String source) {
        if (!machineListener.isPrinting() && !bedOccupied) {
            File file = new File(source);
            machine.connect(port);
            if (source.endsWith(".gcode")) {
                GCodeSource gcode = new MutableGCodeSource(file);
                machine.buildDirect(gcode);
            } else if (source.endsWith(".x3g")) {
                //TODO: If x3g is to be supported I need to hookup the backend
            }
        }
    }

    public int getProgress() {
        return machineListener.getProgress();
    }


    public boolean bedOccupied() {
        return bedOccupied;
    }

    public boolean isPrinting() {
        return machineListener.isPrinting();
    }

    public void cancelBuild() {
        machine.stopAll();
    }

    public void clearBed() {
        this.bedOccupied = false;
    }

    public String getStatus() {
        if (machineListener.isPrinting()) {
            return "Printing " + String.valueOf(machineListener.getProgress()) + "%";
        } else if (bedOccupied) {
            return "Bed occupied";
        } else {
            return "Ready to print";
        }
    }
}

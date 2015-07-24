package replicatorg.app;

import replicatorg.machine.MachineListener;
import replicatorg.machine.MachineProgressEvent;
import replicatorg.machine.MachineStateChangeEvent;
import replicatorg.machine.MachineToolStatusEvent;

/**
 * Created by brian on 7/22/15.
 */
public class MachineServiceListener implements MachineListener {
    private boolean isPrinting = false;
    private int progress;
    private double remaining;
    private double estimated;

    @Override
    public void machineStateChanged(MachineStateChangeEvent evt) {
        isPrinting = evt.getState().isPrinting();
        System.out.println(evt.getMessage());
    }

    @Override
    public void machineProgress(MachineProgressEvent event) {
        progress = event.getLines() / event.getTotalLines();
        remaining = event.getEstimated();
        estimated = event.getElapsed();

    }

    @Override
    public void toolStatusChanged(MachineToolStatusEvent event) {

    }

    public boolean isPrinting() {
        return isPrinting;
    }

    public int getProgress() {
        return progress;
    }

    public String getRemaining() {
        return String.valueOf(remaining);
    }

    public String getEstimated() {
        return String.valueOf(estimated);
    }
}

package print.controllers;

import org.auraframework.system.Annotations;
import replicatorg.app.Printer;
import replicatorg.app.gcode.MutableGCodeSource;
import replicatorg.model.GCodeSource;

import java.io.File;

/**
 * Created by brian on 7/17/15.
 */
@Annotations.Controller
public class PrintController {

    @Annotations.AuraEnabled
    public void Print(@Annotations.Key("file") String file) {
        Printer printer = new Printer();
        //printer.Print(file);
    }
}

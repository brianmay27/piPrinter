package print;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import configuration.Configuration;
import org.auraframework.Aura;
import org.auraframework.def.ComponentDef;
import org.auraframework.instance.Component;
import org.auraframework.system.Annotations;
import org.auraframework.system.AuraContext;
import org.auraframework.throwable.quickfix.QuickFixException;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by brian on 7/17/15.
 */
@Annotations.Model
public class fileListModel {

    public List<Component> files;
    public fileListModel() {
        Set<File> files = Sets.newHashSet();
        File root = new File(Configuration.UPLOADS);
        files = getFilesFromDisk(files, root);
        this.files = Lists.newArrayList();
        for (File file : files) {
            Map<String, Object> props = Maps.newHashMap();
            props.put("fileName", file.getName());
            props.put("path", file.getAbsolutePath());
            try {
                this.files.add((Component) Aura.getInstanceService().getInstance("markup://print:file", ComponentDef.class, props));
            } catch (QuickFixException e) {
                e.printStackTrace();
            }
        }
    }

    @Annotations.AuraEnabled
    public List<Component> getFiles() {
        return this.files;
    }

    public static Set<File> getFilesFromDisk(Set<File> files, File head) {
        File[] list = head.listFiles();
        if (list == null) {
            return files;
        }
        for (File file: list) {
            if (file.isDirectory()) {
                return getFilesFromDisk(files, file);
            } else if (file.getName().toLowerCase().endsWith(".gcode")) {
                files.add(file);
            }
        }
        return files;
    }
}

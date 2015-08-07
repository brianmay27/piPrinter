package configuration;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;
import org.apache.shiro.SecurityUtils;

import java.security.Principal;
import java.sql.SQLException;

/**
 * Created by brian on 8/7/15.
 */
public class Settings {
    private SettingsInstance settings;

    public Settings() {
        ConnectionSource cs = null;
        try {
            cs = new JdbcConnectionSource(Configuration.DATABASE);
            Dao<SettingsInstance, String> settingDao = DaoManager.createDao(cs, SettingsInstance.class);
            TableUtils.createTableIfNotExists(cs, SettingsInstance.class);
            settings = settingDao.queryForId((String)SecurityUtils.getSubject().getPrincipal());
            if (settings == null) {
                settings = new SettingsInstance();
                settingDao.create(settings);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    //I tried.
                }
            }
        }
    }

    public String getMachineType() {
        return settings.getMachineType();
    }

    public String getPort() {
        return settings.getPort();
    }

    @DatabaseTable(tableName = "settings")
    private static class SettingsInstance {
        @DatabaseField(id = true)
        private String username;
        @DatabaseField(columnName = "machineType")
        private String machineType;
        @DatabaseField(columnName = "port")
        private String port;

        protected SettingsInstance() {
            this.machineType = "The Replicator Dual";
            this.port = "/dev/ttyS80";
            this.username = (String)SecurityUtils.getSubject().getPrincipal();
        }

        public String getMachineType() {
            return machineType;
        }

        protected void setMachineType(String machineType) {
            this.machineType = machineType;
        }

        public String getPort() {
            return port;
        }

        protected void setPort(String port) {
            this.port = port;
        }
    }
}

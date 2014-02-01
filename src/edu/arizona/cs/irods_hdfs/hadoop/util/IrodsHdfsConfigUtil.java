package edu.arizona.cs.irods_hdfs.hadoop.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;

public class IrodsHdfsConfigUtil {
    
    public static final Log LOG = LogFactory.getLog(IrodsHdfsConfigUtil.class);
    
    public static final String CONFIG_IRODS_HOST = "irods.host";
    public static final String CONFIG_IRODS_PORT = "irods.port";
    public static final String CONFIG_IRODS_ZONE = "irods.zone";
    public static final String CONFIG_IRODS_USERNAME = "irods.account.username";
    public static final String CONFIG_IRODS_PASSWORD = "irods.account.password";
    public static final String CONFIG_IRODS_HOME_DIRECTORY = "irods.account.homedir";
    public static final String CONFIG_IRODS_DEFAULT_STORAGE_RESOURCE = "irods.account.resource";
    
    public static final int IRODS_PORT_DEFAULT = 1247;
    
    public static String getIrodsHost(Configuration conf) {
        return conf.get(CONFIG_IRODS_HOST);
    }
    
    public static void setIrodsHost(Configuration conf, String host) {
        conf.set(CONFIG_IRODS_HOST, host);
    }
    
    public static int getIrodsPort(Configuration conf) {
        return conf.getInt(CONFIG_IRODS_PORT, IRODS_PORT_DEFAULT);
    }
    
    public static void setIrodsPort(Configuration conf, int port) {
        conf.setInt(CONFIG_IRODS_PORT, port);
    }
    
    public static String getIrodsZone(Configuration conf) {
        return conf.get(CONFIG_IRODS_ZONE);
    }
    
    public static void setIrodsZone(Configuration conf, String zone) {
        conf.set(CONFIG_IRODS_ZONE, zone);
    }
    
    public static String getIrodsUsername(Configuration conf) {
        return conf.get(CONFIG_IRODS_USERNAME);
    }
    
    public static void setIrodsUsername(Configuration conf, String username) {
        conf.set(CONFIG_IRODS_USERNAME, username);
    }
    
    public static String getIrodsPassword(Configuration conf) {
        return conf.get(CONFIG_IRODS_PASSWORD);
    }
    
    public static void setIrodsPassword(Configuration conf, String password) {
        conf.set(CONFIG_IRODS_PASSWORD, password);
    }
    
    public static String getIrodsHomeDirectory(Configuration conf) {
        return conf.get(CONFIG_IRODS_HOME_DIRECTORY, getDefaultHomeDir(conf));
    }
    
    public static void setIrodsHomeDirectory(Configuration conf, String homedir) {
        conf.set(CONFIG_IRODS_HOME_DIRECTORY, homedir);
    }
    
    private static String getDefaultHomeDir(Configuration conf) {
        String zone = getIrodsZone(conf);
        String name = getIrodsUsername(conf);
        
        String defaultdir = "/" + zone.trim() + "/home/" + name.trim();
        return defaultdir;
    }
    
    public static String getIrodsDefaultStorageResource(Configuration conf) {
        return conf.get(CONFIG_IRODS_DEFAULT_STORAGE_RESOURCE, "");
    }
    
    public static void setIrodsDefaultStorageResource(Configuration conf, String resource) {
        conf.set(CONFIG_IRODS_DEFAULT_STORAGE_RESOURCE, resource);
    }
}
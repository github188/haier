package com.haier.connection;

import com.google.common.base.Strings;
import com.haier.common.PropertiesLoaderUtils;
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/10/31
 * Time: 15:01
 */
public class Connections {

    static class ShutDownConnections extends Thread{
        @Override
        public void run() {

            if(null != connectionPool){
                connectionPool.shutdown();
            }
        }
    }

    static BoneCP connectionPool = null;
    static {

        Properties properties =null;
        String jdbcFile="";
        try {
            jdbcFile=System.getProperty("jdbc-config");
            if(Strings.isNullOrEmpty(jdbcFile)){
                jdbcFile = "jdbc.properties";
            }
            properties = PropertiesLoaderUtils.loadAllProperties(jdbcFile);
        } catch (IOException e) {

        }
        try {

            System.out.println(properties.getProperty("jdbc.driverClass")+"\t"+properties.getProperty("jdbc.jdbcUrl")+"\t"+properties.getProperty("jdbc.name")+"\t"+properties.getProperty("jdbc.pwd"));
            Class.forName(properties.getProperty("jdbc.driverClass"));
            BoneCPConfig config = new BoneCPConfig();
            config.setJdbcUrl(properties.getProperty("jdbc.jdbcUrl"));
            config.setUsername(properties.getProperty("jdbc.name"));
            config.setPassword(properties.getProperty("jdbc.pwd"));
            config.setMinConnectionsPerPartition(5);
            config.setMaxConnectionsPerPartition(10);
            config.setPartitionCount(1);
            connectionPool = new BoneCP(config);
            Connection test=  connectionPool.getConnection();
            test.close();

            Runtime.getRuntime().addShutdownHook(new ShutDownConnections());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {
        return connectionPool.getConnection();
    }
    public static void returnConnection(Connection connection){
        if(null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
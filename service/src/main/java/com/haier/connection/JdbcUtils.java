package com.haier.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/10/31
 * Time: 15:28
 */
public class JdbcUtils {
    public static String getResultForSql(String sql) {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet set = null;
        try {
            connection = Connections.getConnection();
            pst = connection.prepareStatement(sql);
            set = pst.executeQuery();
            if (set.next()) {
                return set.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != set) {
                    set.close();
                }
                if (null != pst) {
                    pst.close();
                }
                Connections.returnConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
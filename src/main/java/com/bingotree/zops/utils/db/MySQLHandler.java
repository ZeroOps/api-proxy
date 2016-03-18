package com.bingotree.zops.utils.db;

import com.bingotree.zops.api.config.CommonConfig;

import java.sql.*;

public class MySQLHandler {

    private String connStr;
    private String user;
    private String password;
    private Connection conn;

    public MySQLHandler(){
        this.connStr = CommonConfig.MySQLConnStr;
        this.user = CommonConfig.MySQLUser;
        this.password = CommonConfig.MySQLPassword;

        this.conn();
    }

    public MySQLHandler(String connStr, String user, String password){
        this.connStr = connStr;
        this.user = user;
        this.password = password;

        this.conn();
    }

    private void conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(this.connStr, this.user, this.password);
            this.conn = conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return this.conn;
    }
}

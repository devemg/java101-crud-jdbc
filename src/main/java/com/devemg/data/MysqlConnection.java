package com.devemg.data;

import java.sql.*;

public class MysqlConnection {
    private static String connectionString = "jdbc:mysql://localhost:3306/test_products?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static String user = "root";
    private static String password = "";
    private static String host = "localhost";
    private static int port = 3306;
    private static String database ="test_products";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(connectionString,user,password);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement statement) throws SQLException {
        statement.close();
    }

    public static void close(PreparedStatement statement) throws SQLException {
        statement.close();
    }

    public static void close(Connection cnn) throws SQLException {
        cnn.close();
    }

    public static void setDatabaseUser(String userdb) {
        user = userdb;
    }

    public static void setDatabasePassword(String passwd) {
        password = passwd;
    }

    public static void reloadStringConnection() {
        StringBuilder builder = new StringBuilder("jdbc:mysql://");
        builder.append(host).append(":").append(port).append("/").append(database);
        builder.append("?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true");
        connectionString = builder.toString();
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        MysqlConnection.host = host;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        MysqlConnection.port = port;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        MysqlConnection.database = database;
    }

    public static String getConnectionString() {
        return connectionString;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

}

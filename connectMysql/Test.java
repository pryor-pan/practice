package com.panlai.connectMysql;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        connectMysql open = new connectMysql();
        Connection conn = open.getConnection();
        System.out.println(conn);
    }

}

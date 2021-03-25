package com.panlai.connectMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class check {
    public List readFirstHello() throws SQLException {
        List<Student> list =new ArrayList<Student>();
        connectMysql open = new connectMysql();
        Connection con = open.getConnection();      //连接类
        //然后创建statement类对象，用来执行SQL语句
        Statement statement=con.createStatement();          //Statement实现增删改查
        //你要执行的Sql语句
        String sql="select id,name from hello";
        //最后设置Resultset类，用来存放获取的 结果集
        ResultSet rs=statement.executeQuery(sql);           //结果集

        int Id=0;
        String name=null;
        while(rs.next()) {
            Id = rs.getInt("id");
            name=rs.getString("name");
            Student tl=new Student(Id, name);
            list.add(tl);
        }

        //最后关闭
        rs.close();
        con.close();
        return list;
    }
}


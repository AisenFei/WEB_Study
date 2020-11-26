package org.example;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlSelect {
    //实现一个方法，参数传入username和password，返回类型boolean
    public static boolean selectUser(String username,String password){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            //创建数据库连接
            MysqlDataSource ds = new MysqlDataSource();
            ds.setUrl("jdbc:mysql://localhost:3306/test?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            connection = ds.getConnection();
            System.out.println(connection);

            //第二步：创建操作命令对象Statement，并且执行操作语句
            String sql = "select count(0) flag from user where username=? and password=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);

            //处理结果集
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("flag") == 1;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            //执行某个功能，如果出现异常，建议再次抛出异常
            throw new RuntimeException("查询出错",throwables);
        }finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if(statement!=null)
                    statement.close();
                if(connection!=null)
                    connection.close();
            }catch(SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}

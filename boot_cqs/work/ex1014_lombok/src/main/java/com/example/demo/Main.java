package com.example.demo;

import lombok.ToString;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "myuser", "qwer1234");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from member");
        ResultSet resultSet = preparedStatement.executeQuery();

        while( resultSet.next() ){
            var user = new Member();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(resultSet.getInt("age"));

            // System.out.println("name" + user.getId() + " : " + user.getName());
            System.out.println(user);
        }
    }

}

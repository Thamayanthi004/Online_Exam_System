package org.apache.maven.archetypes.Online_Exam_System.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.maven.archetypes.Online_Exam_System.dto.Member;

public class MemberDAOImpl implements MemberDAO {

    Connection con;
    PreparedStatement ps;

    public MemberDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/online_exam",
                "root",
                "root"
            );

            System.out.println("Connection established ");

        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }

    @Override
    public void register(Member m) {

        try {
            ps = con.prepareStatement(
                "INSERT INTO member VALUES (?, ?, ?)"
            );

            ps.setInt(1, m.getUserId());
            ps.setString(2, m.getName());
            ps.setString(3, m.getEmail());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Member registered successfully ");
            } else {
                System.out.println("Registration failed ");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

	
}
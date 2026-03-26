package org.apache.maven.archetypes.Online_Exam_System.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.archetypes.Online_Exam_System.dto.Question;
	public class QuestionDAOImpl implements QuestionDAO {

	    Connection con;
	    PreparedStatement ps;
	    public QuestionDAOImpl() {
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
	    public void addQuestion(Question q) {
	        try {
	            ps = con.prepareStatement(
	                "INSERT INTO question VALUES (?, ?, ?, ?, ?, ?, ?)"
	            );

	            ps.setInt(1, q.getQuestionId());
	            ps.setString(2, q.getQuestionText());
	            ps.setString(3, q.getOptionA());
	            ps.setString(4, q.getOptionB());
	            ps.setString(5, q.getOptionC());
	            ps.setString(6, q.getOptionD());
	            ps.setString(7, q.getCorrectAnswer());

	            int rows = ps.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Question added successfully ");
	            }

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	    @Override
	    public void updateQuestion(Question q) {
	        try {
	            ps = con.prepareStatement(
	                "UPDATE question SET questionText=?, optionA=?, optionB=?, optionC=?, optionD=?, correctAnswer=? WHERE questionId=?"
	            );

	            ps.setString(1, q.getQuestionText());
	            ps.setString(2, q.getOptionA());
	            ps.setString(3, q.getOptionB());
	            ps.setString(4, q.getOptionC());
	            ps.setString(5, q.getOptionD());
	            ps.setString(6, q.getCorrectAnswer());
	            ps.setInt(7, q.getQuestionId());

	            int rows = ps.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Question updated successfully");
	            } else {
	                System.out.println("Question not found");
	            }

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	    @Override
	    public List<Question> getAllQuestions() {

	        List<Question> list = new ArrayList<>();

	        try {
	            ps = con.prepareStatement("SELECT * FROM question");

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                Question q = new Question();

	                q.setQuestionId(rs.getInt("questionId"));
	                q.setQuestionText(rs.getString("questionText"));
	                q.setOptionA(rs.getString("optionA"));
	                q.setOptionB(rs.getString("optionB"));
	                q.setOptionC(rs.getString("optionC"));
	                q.setOptionD(rs.getString("optionD"));
	                q.setCorrectAnswer(rs.getString("correctAnswer"));

	                list.add(q);
	            }

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        return list;
	    }
	}



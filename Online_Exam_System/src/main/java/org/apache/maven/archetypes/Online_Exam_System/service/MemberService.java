package org.apache.maven.archetypes.Online_Exam_System.service;

import java.util.List;
import java.util.Scanner;

import org.apache.maven.archetypes.Online_Exam_System.dao.MemberDAOImpl;
import org.apache.maven.archetypes.Online_Exam_System.dao.QuestionDAOImpl;
import org.apache.maven.archetypes.Online_Exam_System.dto.Member;
import org.apache.maven.archetypes.Online_Exam_System.dto.Question;
public class MemberService {

	    MemberDAOImpl memberDao = new MemberDAOImpl();
	    QuestionDAOImpl questionDao = new QuestionDAOImpl();
	    Scanner sc = new Scanner(System.in);
	    public void register() {

	        System.out.print("Enter User ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Email: ");
	        String email = sc.nextLine();

	        Member m = new Member(id, name, email);

	        memberDao.register(m);
	    }

	    public void giveExam() {

	        List<Question> list = questionDao.getAllQuestions();

	        if (list.isEmpty()) {
	            System.out.println("No questions available ❌");
	            return;
	        }

	        int score = 0;

	        for (Question q : list) {

	            System.out.println("\n" + q.getQuestionText());
	            System.out.println("A. " + q.getOptionA());
	            System.out.println("B. " + q.getOptionB());
	            System.out.println("C. " + q.getOptionC());
	            System.out.println("D. " + q.getOptionD());

	            System.out.print("Your Answer: ");
	            String ans = sc.nextLine();

	            if (ans.equalsIgnoreCase(q.getCorrectAnswer())) {
	                score++;
	            }
	        }

	        System.out.println("\n Your Score: " + score + "/" + list.size());
	    }
	}


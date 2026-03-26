package org.apache.maven.archetypes.Online_Exam_System.service;

import java.util.List;
import java.util.Scanner;

import org.apache.maven.archetypes.Online_Exam_System.dao.QuestionDAOImpl;
import org.apache.maven.archetypes.Online_Exam_System.dto.Question;

public class QuestionService {

	    QuestionDAOImpl dao = new QuestionDAOImpl();
	    Scanner sc = new Scanner(System.in);
	    public void addQuestion() {

	        System.out.print("Enter Question ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Question: ");
	        String q = sc.nextLine();

	        System.out.print("Option A: ");
	        String a = sc.nextLine();

	        System.out.print("Option B: ");
	        String b = sc.nextLine();

	        System.out.print("Option C: ");
	        String c = sc.nextLine();

	        System.out.print("Option D: ");
	        String d = sc.nextLine();

	        System.out.print("Correct Answer (A/B/C/D): ");
	        String ans = sc.nextLine();

	        Question question = new Question(id, q, a, b, c, d, ans);

	        dao.addQuestion(question);
	    }
	    public void updateQuestion() {

	        System.out.print("Enter Question ID to update: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter New Question: ");
	        String q = sc.nextLine();

	        System.out.print("Option A: ");
	        String a = sc.nextLine();

	        System.out.print("Option B: ");
	        String b = sc.nextLine();

	        System.out.print("Option C: ");
	        String c = sc.nextLine();

	        System.out.print("Option D: ");
	        String d = sc.nextLine();

	        System.out.print("Correct Answer: ");
	        String ans = sc.nextLine();

	        Question question = new Question(id, q, a, b, c, d, ans);

	        dao.updateQuestion(question);
	    }
	    public void viewQuestions() {

	        List<Question> list = dao.getAllQuestions();

	        if (list.isEmpty()) {
	            System.out.println("No questions available");
	        } else {
	            for (Question q : list) {
	                System.out.println("----------------------------");
	                System.out.println("ID: " + q.getQuestionId());
	                System.out.println("Q: " + q.getQuestionText());
	                System.out.println("A: " + q.getOptionA());
	                System.out.println("B: " + q.getOptionB());
	                System.out.println("C: " + q.getOptionC());
	                System.out.println("D: " + q.getOptionD());
	                System.out.println("Answer: " + q.getCorrectAnswer());
	            }
	        }
	    }
	}


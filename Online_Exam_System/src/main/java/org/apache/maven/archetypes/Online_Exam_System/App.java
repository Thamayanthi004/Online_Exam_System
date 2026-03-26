package org.apache.maven.archetypes.Online_Exam_System;
import java.util.Scanner;

import org.apache.maven.archetypes.Online_Exam_System.service.MemberService;
import org.apache.maven.archetypes.Online_Exam_System.service.QuestionService;


public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QuestionService qs = new QuestionService(); 
        MemberService ms = new MemberService();     

        while (true) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {

                case 1:
                    while (true) {

                        System.out.println("\n--- Admin Menu ---");
                        System.out.println("1. Add Question");
                        System.out.println("2. Update Question");
                        System.out.println("3. View Questions");
                        System.out.println("4. Back");

                        System.out.print("Enter your choice: ");
                        int adminChoice = sc.nextInt();
                        sc.nextLine();

                        switch (adminChoice) {
                            case 1:
                                qs.addQuestion();
                                break;
                            case 2:
                                qs.updateQuestion();
                                break;
                            case 3:
                                qs.viewQuestions();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid choice ❌");
                        }

                        if (adminChoice == 4) break;
                    }
                    break;

                case 2:
                    while (true) {

                        System.out.println("\n--- User Menu ---");
                        System.out.println("1. Register");
                        System.out.println("2. Give Exam");
                        System.out.println("3. Back");

                        System.out.print("Enter your choice: ");
                        int userChoice = sc.nextInt();
                        sc.nextLine();

                        switch (userChoice) {
                            case 1:
                                ms.register();
                                break;
                            case 2:
                                ms.giveExam();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }

                        if (userChoice == 3) break;
                    }
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

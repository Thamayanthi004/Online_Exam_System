package org.apache.maven.archetypes.Online_Exam_System.dao;

import java.util.List;

import org.apache.maven.archetypes.Online_Exam_System.dto.Question;

public interface QuestionDAO {
	 void addQuestion(Question q);
	    void updateQuestion(Question q);
	    List<Question> getAllQuestions();
}

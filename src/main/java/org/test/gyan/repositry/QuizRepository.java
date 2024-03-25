package org.test.gyan.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.gyan.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}

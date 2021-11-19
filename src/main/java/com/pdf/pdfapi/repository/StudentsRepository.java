package com.pdf.pdfapi.repository;

import com.pdf.pdfapi.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Long> {
}

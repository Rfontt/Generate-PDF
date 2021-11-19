package com.pdf.pdfapi.form;

import com.pdf.pdfapi.model.Students;
import lombok.Data;

@Data
public class StudentsForm {
    private Long id;
    private String name;
    private String email;

    public Students convert() {
        return new Students(name, email);
    }
}

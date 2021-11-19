package com.pdf.pdfapi.form;

import com.pdf.pdfapi.model.SalaryForEmployee;
import lombok.Data;

@Data
public class SalaryForEmployeeForm {
    private Long id;
    private String name;
    private Float salary;

    public SalaryForEmployee convert() {
        return new SalaryForEmployee(name, salary);
    }
}

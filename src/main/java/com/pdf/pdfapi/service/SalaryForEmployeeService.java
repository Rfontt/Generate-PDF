package com.pdf.pdfapi.service;

import com.pdf.pdfapi.dto.SalaryForEmployeeDTO;
import com.pdf.pdfapi.form.SalaryForEmployeeForm;
import com.pdf.pdfapi.model.SalaryForEmployee;
import com.pdf.pdfapi.repository.SalaryForEmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SalaryForEmployeeService {
    private SalaryForEmployeeRepository salaryForEmployeeRepository;

    public SalaryForEmployee save(SalaryForEmployeeForm form) {
        SalaryForEmployee salaryForEmployee = form.convert();
        salaryForEmployeeRepository.save(salaryForEmployee);

        return salaryForEmployee;
    }
}

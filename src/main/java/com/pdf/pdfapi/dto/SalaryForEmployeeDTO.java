package com.pdf.pdfapi.dto;

import com.pdf.pdfapi.model.SalaryForEmployee;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class SalaryForEmployeeDTO {
    private Long id;
    private String name;
    private Float salary;

    public SalaryForEmployeeDTO(SalaryForEmployee salaryForEmployees) {
        this.id = salaryForEmployees.getId();
        this.name = salaryForEmployees.getName();
        this.salary = salaryForEmployees.getSalary();
    }

    public List<SalaryForEmployeeDTO> convert(List<SalaryForEmployee> salaryForEmployees) {
        return salaryForEmployees.stream().map(SalaryForEmployeeDTO::new).collect(Collectors.toList());
    }
}

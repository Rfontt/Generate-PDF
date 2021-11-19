package com.pdf.pdfapi.controller;

import com.pdf.pdfapi.dto.SalaryForEmployeeDTO;
import com.pdf.pdfapi.form.SalaryForEmployeeForm;
import com.pdf.pdfapi.model.SalaryForEmployee;
import com.pdf.pdfapi.service.SalaryForEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/salary-employee")
public class SalaryForEmployeeController {
    @Autowired
    private SalaryForEmployeeService salaryForEmployeeService;

    @PostMapping
    public ResponseEntity<SalaryForEmployeeDTO> save(@RequestBody SalaryForEmployeeForm form, UriComponentsBuilder uriComponentsBuilder) {
        SalaryForEmployee salary = salaryForEmployeeService.save(form);

        URI uri = uriComponentsBuilder.path("/salary-employee/{id}").buildAndExpand(salary.getId()).toUri();

        return ResponseEntity.created(uri).body(new SalaryForEmployeeDTO(salary));
    }
}

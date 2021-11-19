package com.pdf.pdfapi.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class SalaryForEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String name;
    @NotNull
    @Column(nullable = false)
    private Float salary;

    public SalaryForEmployee() {}

    public SalaryForEmployee(String name, Float salary) {
        this.name = name;
        this.salary = salary;
    }
}

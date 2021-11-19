package com.pdf.pdfapi.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column( nullable = false )
    private String name;
    @NotNull
    @Column( nullable = false )
    private String email;

    public Students() {}

    public Students(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

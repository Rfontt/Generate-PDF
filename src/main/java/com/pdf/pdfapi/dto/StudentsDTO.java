package com.pdf.pdfapi.dto;

import com.pdf.pdfapi.model.Students;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentsDTO {
    private Long id;
    private String name;
    private String email;

    public StudentsDTO(Students studies) {
        this.id = studies.getId();
        this.name = studies.getName();
        this.email = studies.getEmail();
    }

    public List<StudentsDTO> convert(List<Students> studiesList) {
        return studiesList.stream().map(StudentsDTO::new).collect(Collectors.toList());
    }

}

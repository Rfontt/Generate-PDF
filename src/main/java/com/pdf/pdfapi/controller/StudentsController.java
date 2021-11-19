package com.pdf.pdfapi.controller;

import com.pdf.pdfapi.dto.StudentsDTO;
import com.pdf.pdfapi.form.StudentsForm;
import com.pdf.pdfapi.model.Students;
import com.pdf.pdfapi.repository.StudentsRepository;
import com.pdf.pdfapi.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private StudentsService studentsService;

    @PostMapping
    public ResponseEntity<StudentsDTO> save(@RequestBody StudentsForm form, UriComponentsBuilder uriComponentsBuilder) {
        Students students = studentsService.save(form);

        URI uri = uriComponentsBuilder.path("/students/{id}").buildAndExpand(students.getId()).toUri();

        return ResponseEntity.created(uri).body(new StudentsDTO(students));
    }

    @GetMapping
    public List<StudentsDTO> list() {
        Students students = new Students();
        StudentsDTO studentsDTO = new StudentsDTO(students);
        List<Students> studentsList =  studentsRepository.findAll();

        return studentsDTO.convert(studentsList);
    }

    @GetMapping("/generate-pdf")
    public ResponseEntity<InputStreamResource> generatePdf() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=students.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(this.studentsService.reportV2()));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

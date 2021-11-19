package com.pdf.pdfapi.service;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.pdf.pdfapi.form.StudentsForm;
import com.pdf.pdfapi.model.Students;
import com.pdf.pdfapi.repository.StudentsRepository;
import com.pdf.pdfapi.utils.ReportUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
@AllArgsConstructor
public class StudentsService {
    private StudentsRepository studentsRepository;

    public Students save(StudentsForm form) {
        Students students = form.convert();
        studentsRepository.save(students);

        return students;
    }

    public ByteArrayInputStream reportV2() throws IOException {
        ReportUtils report = ReportUtils.getInstance();
        report.setPageSize(PageSize.A4.rotate());

        report.addParagraph(new Paragraph("Emails of students")
                .setFontSize(28)
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(PdfFontFactory.createFont(StandardFonts.COURIER_BOLD))
        );

        report.addNewLine();
        report.openTable(1);
        report.addTableHeader("Emails");

        this.studentsRepository.findAll()
                .stream()
                .forEach(student -> {
                    report.addTableColumn(student.getEmail());
                });
        report.closeTable();
        report.closeDocument();

        return report.getByteArrayInputStream();
    }
}

package com.pdf.pdfapi.utils;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import com.pdf.pdfapi.model.Students;

import java.util.List;

public class SimpleTable {
    public void manipulatePdf(String dest, List<Students> students) throws  Exception {
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdfDocument);

        Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();

        students.stream().forEach(student -> table.addCell(student.getEmail()));

        document.add(table);
        document.close();
    }
}

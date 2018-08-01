package com.pc.conapp.report;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.pc.conapp.pojo.Contact;
import java.awt.Color;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author Przemek
 */
public class PdfReportView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        //response.setHeader("Content-Disposition", "attachment: filename=\"user_list.pdf\"");
        @SuppressWarnings("unchecked")
        List<Contact> contactList = (List<Contact>) map.get("contactList");

        PdfPTable table = new PdfPTable(5);
        document.addTitle("Contact list");
        document.addSubject("Contact list");
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.setWidthPercentage(100);
        table.getDefaultCell().setColspan(1);
        
        table.addCell("Name");
        table.addCell("Phone");
        table.addCell("E-mail");
        table.addCell("Address");
        table.addCell("Remark");
        
        for (Contact c : contactList) {
            table.addCell(c.getName());
            table.addCell(c.getPhone());
            table.addCell(c.getEmail());
            table.addCell(c.getAddress());
            table.addCell(c.getRemark());
        }
        document.add(table);
        document.close();
    }

}

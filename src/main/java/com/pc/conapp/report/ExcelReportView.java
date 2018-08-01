package com.pc.conapp.report;

import com.pc.conapp.pojo.Contact;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

/**
 *
 * @author Przemek
 */
public class ExcelReportView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment: filename=\"user_list.xlsx\"");
        
        @SuppressWarnings("unchecked")
        List<Contact> contactList = (List<Contact>) map.get("contactList");
        
        Sheet sheet = workbook.createSheet("Contact list");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Name");
        header.createCell(1).setCellValue("Phone");
        header.createCell(2).setCellValue("E-mail");
        header.createCell(3).setCellValue("Address");
        header.createCell(4).setCellValue("Remark");

        int rowNum = 1;
        for (Contact c : contactList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(c.getName());
            row.createCell(1).setCellValue(c.getPhone());
            row.createCell(2).setCellValue(c.getEmail());
            row.createCell(3).setCellValue(c.getAddress());
            row.createCell(4).setCellValue(c.getRemark());
        }
    }
}

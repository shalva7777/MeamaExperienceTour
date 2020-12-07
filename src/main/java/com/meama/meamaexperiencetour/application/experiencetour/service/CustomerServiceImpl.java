package com.meama.meamaexperiencetour.application.experiencetour.service;

import com.meama.meamaexperiencetour.application.experiencetour.storage.CustomerRepository;
import com.meama.meamaexperiencetour.application.experiencetour.storage.model.Customer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static String[] columns = new String[]{"აიდი", "სახელი,გვარი", "კომპანია", "ტელეფონი", "მეილი", "თარიღი", "მოვდივარ სტუუმართან ერთად", "კომენტარი"};
    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    public void save(Customer customer) {
        customer.setInsertDate(new Date());
        Customer save = (Customer) this.repository.save(customer);
    }

    public ByteArrayInputStream generateExcel() throws IOException {
        List<Customer> customerList = this.repository.findAll();
        return this.generateExcel(customerList);
    }

    private ByteArrayInputStream generateExcel(List<Customer> customers) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Guests");
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);

        int rowNum;
        for (rowNum = 0; rowNum < columns.length; ++rowNum) {
            Cell cell = headerRow.createCell(rowNum);
            cell.setCellValue(columns[rowNum]);
            cell.setCellStyle(headerCellStyle);
        }

        rowNum = 1;

        for (Customer customer : customers) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue((double) customer.getId());
            row.createCell(1).setCellValue(customer.getNameSurname());
            row.createCell(2).setCellValue(customer.getCompany());
            row.createCell(3).setCellValue(customer.getPhone());
            row.createCell(4).setCellValue(customer.getEmail());
            row.createCell(5).setCellValue(dateFormat.format(customer.getInsertDate()));
            row.createCell(6).setCellValue(customer.isWithGuest());
            row.createCell(7).setCellValue(customer.getComment());
        }

        for (int i = 0; i < columns.length; ++i) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        return new ByteArrayInputStream(out.toByteArray());
    }
}

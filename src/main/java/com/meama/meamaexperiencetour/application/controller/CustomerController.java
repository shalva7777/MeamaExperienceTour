package com.meama.meamaexperiencetour.application.controller;

import com.meama.meamaexperiencetour.application.experiencetour.service.CustomerService;
import com.meama.meamaexperiencetour.application.experiencetour.storage.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
@RequestMapping({""})
public class CustomerController {

    private ResponseEntity<InputStreamResource> body = null;
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping({"/"})
    public String getMenuPage() {
        return "page";
    }

    @GetMapping({"/generate-excel"})
    public String excelPage() {
        return "excel";
    }

    @PostMapping({"/save-customer"})
    @ResponseBody
    public String saveCustomer(@RequestBody Customer customer) {
        this.service.save(customer);
        return "success";
    }

    @PostMapping({"/generate-customers-excel"})
    @ResponseBody
    public String generateCustomerExcel() throws IOException {
        this.body = null;
        ByteArrayInputStream in = this.service.generateExcel();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=guarantee.xlsx");
        this.body = ((ResponseEntity.BodyBuilder) ResponseEntity.ok().headers(headers)).body(new InputStreamResource(in));
        return "success";
    }

    @GetMapping({"/download"})
    public ResponseEntity<InputStreamResource> generateDropperGuarantee() throws IOException {
        return this.body;
    }
}

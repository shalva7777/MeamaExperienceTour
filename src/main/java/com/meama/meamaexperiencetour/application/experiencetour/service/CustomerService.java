package com.meama.meamaexperiencetour.application.experiencetour.service;

import com.meama.meamaexperiencetour.application.experiencetour.storage.model.Customer;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface CustomerService {

    void save(Customer customer);

    ByteArrayInputStream generateExcel() throws IOException;
}

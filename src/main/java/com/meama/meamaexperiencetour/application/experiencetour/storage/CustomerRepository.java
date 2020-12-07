package com.meama.meamaexperiencetour.application.experiencetour.storage;

import com.meama.meamaexperiencetour.application.experiencetour.storage.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

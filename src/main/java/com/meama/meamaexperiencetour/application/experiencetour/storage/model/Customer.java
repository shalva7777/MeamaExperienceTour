package com.meama.meamaexperiencetour.application.experiencetour.storage.model;

import java.io.Serializable;
import java.util.Date;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(
        name = "Experience_tour_customer"
)
public class Customer implements Serializable {
    private static final long serialVersionUID = -3009157732242241207L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSurname;
    private String company;
    private String phone;
    private String email;
    private boolean withGuest;
    private Date insertDate;
    @Column(length = 5000)
    private String comment;

    public Customer() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSurname() {
        return this.nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isWithGuest() {
        return this.withGuest;
    }

    public void setWithGuest(boolean withGuest) {
        this.withGuest = withGuest;
    }

    public Date getInsertDate() {
        return this.insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package org.pis.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public int status;


    @OneToMany(mappedBy = "commission", fetch = FetchType.EAGER, orphanRemoval = true)
    public List<CommissionItem> CommissionItems;

    @ManyToOne
    public Company company;

    @Override
    public boolean equals(Object obj) {
        return this.getId() == ((Commission)obj).getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<CommissionItem> getCommissionItems() {
        return CommissionItems;
    }

    public void setCommissionItems(List<CommissionItem> commissionItems) {
        CommissionItems = commissionItems;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}

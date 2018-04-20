package org.pis.entity;

import org.pis.bl.commission.CoStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public Date coCreated = new Date();
    public Date coFinished;

    @Enumerated(EnumType.STRING)
    private CoStatus status = CoStatus.NEW;


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

    public Date getCoCreated() {
        return coCreated;
    }

    public void setCoCreated(Date coCreated) {
        this.coCreated = coCreated;
    }

    public Date getCoFinished() {
        return coFinished;
    }

    public void setCoFinished(Date coFinished) {
        this.coFinished = coFinished;
    }

    public CoStatus getStatus() {
        return status;
    }

    public void setStatus(CoStatus status) {
        this.status = status;
    }
}

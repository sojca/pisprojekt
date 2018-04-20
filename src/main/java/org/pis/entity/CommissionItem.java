package org.pis.entity;

import org.pis.bl.commission.CoStatus;

import javax.persistence.*;
import java.util.List;

@Entity
public class CommissionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int amount;

    @Enumerated(EnumType.STRING)
    private CoStatus status = CoStatus.NEW;

    @ManyToOne
    private Commission commission;

    @ManyToOne
    private Activity activity;

    @OneToMany(mappedBy = "commissionItem")
    private List<CommissionItemEmployee> employeeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    public CoStatus getStatus() {
        return status;
    }

    public void setStatus(CoStatus status) {
        this.status = status;
    }
}

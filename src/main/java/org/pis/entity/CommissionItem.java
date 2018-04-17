package org.pis.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class CommissionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int sequenceNo;


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

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }
}

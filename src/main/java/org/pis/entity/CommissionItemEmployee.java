package org.pis.entity;

import org.pis.entity.utils.CommissionItemEmployeeId;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CommissionItemEmployee {

    @EmbeddedId
    private CommissionItemEmployeeId id;

    private int realHour;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("commissionItemId")
    private CommissionItem commissionItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("employeeId")
    private Employee employee;


    public CommissionItemEmployeeId getId() {
        return id;
    }

    public void setId(CommissionItemEmployeeId id) {
        this.id = id;
    }

    public int getRealHour() {
        return realHour;
    }

    public void setRealHour(int realHour) {
        this.realHour = realHour;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setCommissionItem(CommissionItem commissionItem) {
        this.commissionItem = commissionItem;
    }

    public CommissionItem getCommissionItem() {
        return commissionItem;
    }


        @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CommissionItemEmployee that = (CommissionItemEmployee) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commissionItem, employee);
    }

}

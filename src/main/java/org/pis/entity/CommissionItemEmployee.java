package org.pis.entity;

import org.pis.entity.utils.CommissionItemEmployeeId;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CommissionItemEmployee {

    @EmbeddedId
    private CommissionItemEmployeeId id;

    private int expectedHour;

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

    public int getExpectedHour() {
        return expectedHour;
    }

    public void setExpectedHour(int expectedHour) {
        this.expectedHour = expectedHour;
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

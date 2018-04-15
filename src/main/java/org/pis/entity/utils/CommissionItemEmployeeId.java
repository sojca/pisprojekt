package org.pis.entity.utils;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CommissionItemEmployeeId implements Serializable{

    private int commissionItemId;
    private int employeeId;

    public CommissionItemEmployeeId(int commissionItemId, int employeeId) {
        this.commissionItemId = commissionItemId;
        this.employeeId = employeeId;
    }

    public CommissionItemEmployeeId() {
    }

    public int getCommissionItemId() {
        return commissionItemId;
    }

    public void setCommissionItemId(int commissionItemId) {
        this.commissionItemId = commissionItemId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CommissionItemEmployeeId that = (CommissionItemEmployeeId) o;
        return Objects.equals(commissionItemId, that.commissionItemId) &&
                Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commissionItemId, employeeId);
    }
}

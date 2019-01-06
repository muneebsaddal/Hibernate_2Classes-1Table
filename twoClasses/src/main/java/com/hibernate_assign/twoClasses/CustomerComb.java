package com.hibernate_assign.twoClasses;

import javax.persistence.*;

@Entity
public class CustomerComb {
	
	@Override
	public String toString() {
		return "CustomerComb [customerId=" + customerId + ", customerName=" + customerName + ", customerDetail="
				+ customerDetail + "]";
	}

	@Id
	@Column
    private int customerId;
    @Column
    private String customerName;
    @Embedded
    private CustomerDetail customerDetail;
    
    public CustomerComb() {
    	
    }

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}	
}

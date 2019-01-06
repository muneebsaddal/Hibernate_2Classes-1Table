package com.hibernate_assign.twoClasses;

import javax.persistence.*;

@Embeddable
public class CustomerDetail {

    @Override
	public String toString() {
		return "CustomerDetail [customerAddress=" + customerAddress + ", creditScore=" + creditScore + ", rewardPoints="
				+ rewardPoints + "]";
	}
	@Column
    private String customerAddress;
    @Column
    private int creditScore;
    @Column
    private int rewardPoints;
    
    public CustomerDetail() {
    	
    }

    public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
}

package pojo;

import java.util.Date;
import java.util.List;

public class Installments {
	
	private String status;
	private Date dueDate;
	private List<Amount> amount;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public List<Amount> getAmount() {
		return amount;
	}
	public void setAmount(List<Amount> amount) {
		this.amount = amount;
	}
	
	

}

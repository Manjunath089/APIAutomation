package pojo;

import java.util.Date;
import java.util.List;

public class InstallmentSchedule {
	
	private String status;
	private int totalInstallments;
	private String billPreference;
	private String customerRef;
	private String billProfileRef;
	private String scheduleSpecRef;
	
	private List<ValidFor> validFor;
	private List<TotalAmount> totalAmount;
	private List<Bills> bills;
	private List<Installments> installments;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getBillPreference() {
		return billPreference;
	}
	public void setBillPreference(String billPreference) {
		this.billPreference = billPreference;
	}
	public int getTotalInstallments() {
		return totalInstallments;
	}
	public void setTotalInstallments(int totalInstallments) {
		this.totalInstallments = totalInstallments;
	}
	public String getCustomerRef() {
		return customerRef;
	}
	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}
	public String getBillProfileRef() {
		return billProfileRef;
	}
	public void setBillProfileRef(String billProfileRef) {
		this.billProfileRef = billProfileRef;
	}
	public String getScheduleSpecRef() {
		return scheduleSpecRef;
	}
	public void setScheduleSpecRef(String scheduleSpecRef) {
		this.scheduleSpecRef = scheduleSpecRef;
	}
	public List<ValidFor> getValidFor() {
		return validFor;
	}
	public void setValidFor(List<ValidFor> validFor) {
		this.validFor = validFor;
	}
	public List<TotalAmount> getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(List<TotalAmount> totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<Bills> getBills() {
		return bills;
	}
	public void setBills(List<Bills> bills) {
		this.bills = bills;
	}
	public List<Installments> getInstallments() {
		return installments;
	}
	public void setInstallments(List<Installments> installments) {
		this.installments = installments;
	}
}

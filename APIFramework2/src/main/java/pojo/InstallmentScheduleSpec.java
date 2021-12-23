package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class InstallmentScheduleSpec {

	private String chargeOfferRef;
	private String name = null;
	private String descr= null;
	private String glid;
	private String installmentPeriod = null;
	private String installmentType = null;
	private double minPercent= 0.0d;
	private double minAmount= 0.0d;
	
	private int maxIntervalDaysNEI;
	private int maxNumNEI;
	private String expiresAt;
	private List<Qualifiers> qualifiers;
	
	
	public String getChargeOfferRef() {
		return chargeOfferRef;
	}
	public void setChargeOfferRef(String chargeOfferRef) {
		this.chargeOfferRef = chargeOfferRef;
	}
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getName() {
		return name;
	}
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public double getMinPercent() {
		return minPercent;
	}
	public void setMinPercent(double minPercent) {
		this.minPercent = minPercent;
	}
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	public double getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getGlid() {
		return glid;
	}
	public void setGlid(String glid) {
		this.glid = glid;
	}
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getInstallmentPeriod() {
		return installmentPeriod;
	}
	public void setInstallmentPeriod(String installmentPeriod) {
		this.installmentPeriod = installmentPeriod;
	}
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getInstallmentType() {
		return installmentType;
	}
	
	public void setInstallmentType(String installmentType) {
		this.installmentType = installmentType;
	}
	public int getMaxIntervalDaysNEI() {
		return maxIntervalDaysNEI;
	}
	public void setMaxIntervalDaysNEI(int maxIntervalDaysNEI) {
		this.maxIntervalDaysNEI = maxIntervalDaysNEI;
	}
	public int getMaxNumNEI() {
		return maxNumNEI;
	}
	public void setMaxNumNEI(int maxNumNEI) {
		this.maxNumNEI = maxNumNEI;
	}
	public String getExpiresAt() {
		return expiresAt;
	}
	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}
	public List<Qualifiers> getQualifiers() {
		return qualifiers;
	}
	public void setQualifiers(List<Qualifiers> qualifiers) {
		this.qualifiers = qualifiers;
	}
}

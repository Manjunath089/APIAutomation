package resources;

public enum APIResources {
	
	InstallmentScheduleSpec("/bc/webresources/v1.0/installmentManagement/v1/installmentScheduleSpec"),
	GetInstallmentScheduleSpec("/bc/webresources/v1.0/installmentManagement/v1/installmentScheduleSpec/"),
	Installment("/bc/webresources/v1.0/installmentManagement/v1/installmentSchedule/addInstallmentSchedule")
	;
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}


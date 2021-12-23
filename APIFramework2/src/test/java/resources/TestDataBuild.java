package resources;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.sun.xml.xsom.impl.scd.ParseException;

import pojo.Amount;
import pojo.Bills;
import pojo.InstallmentSchedule;
import pojo.InstallmentScheduleSpec;
import pojo.Installments;
import pojo.Qualifiers;
import pojo.TotalAmount;
import pojo.ValidFor;
import pojo.InstallmentScheduleSpec;

public class TestDataBuild extends Utils
{	
	
	public InstallmentScheduleSpec InstallmentScheduleSpecificaton(String name, String minPercent, String  minAmount, int maxIntervalDaysNEI, int maxNumNEI, String expiresAt, String installmentPeriod, String installmentType, String key, String value, String dataType, String operator) throws ParseException, java.text.ParseException 
	{
		
		InstallmentScheduleSpec In  = new InstallmentScheduleSpec();
		
		In.setChargeOfferRef("Test2");
		if(!installmentType.isEmpty())
		{
		In.setName(name+getCurrentDateTimeMS()+i);
		}
		In.setDescr("Test");
		In.setGlid("110");
		In.setInstallmentPeriod(installmentPeriod);
		if(!installmentType.isEmpty())
		{
		In.setInstallmentType(installmentType);
		}
		In.setMaxIntervalDaysNEI(maxIntervalDaysNEI);
		In.setMaxNumNEI(maxNumNEI);
		
		String percent = minPercent;
		if(!percent.isEmpty())
		{
		 In.setMinPercent(Double.parseDouble(percent));
		}
		String amount = minAmount;
		if(!amount.isEmpty())
		{
		In.setMinAmount(Double.parseDouble(amount));
		}
		In.setExpiresAt(expiresAt);
		
		String test = dataType;
		String[] myArray = test.split(",");
		String test1 = key;
		String[] myArray1 = test1.split(",");
		String test2 = operator;
		String[] myArray2 = test2.split(",");
		String test3 = value;
		String[] myArray3 = test3.split(",");
		List<Qualifiers> qList = new ArrayList<Qualifiers>();
		for (int j=0; j < myArray.length; j++)
		{
			Qualifiers q = new Qualifiers();
			q.setDataType(myArray[j]);
			q.setKey(myArray1[j]);
			q.setOperator(myArray2[j]);
			q.setValue(myArray3[j]);
			qList.add(q);
		}
		
		
//		Qualifiers q = new Qualifiers();
//		q.setDataType(dataType);
//		q.setKey(key);
//		q.setOperator(operator);
//		q.setValue(value);
//		List<Qualifiers> qList = new ArrayList<Qualifiers>();
//		qList.add(q);
		In.setQualifiers(qList);		
		return In;
	}

	public InstallmentSchedule InstallmentSchedule(String billPreference, String status, String startDateTime, String endDateTime, Integer totalInstallments, Double amount,
			 String currency, String customerRef, String billProfileRef,
			 String billId, String scheduleSpecRef, String istatus, String idueDate, Double iamount, String icurrency) throws ParseException, java.text.ParseException 
	 {
		 
		 InstallmentSchedule I = new InstallmentSchedule();
		 I.setBillPreference(billPreference);
		 I.setStatus(status);
		 List<ValidFor> qList = new ArrayList<ValidFor>();
		  ValidFor vf = new ValidFor();
		   vf.setStartDateTime(getdate(startDateTime));
		   vf.setEndDateTime(getdate(endDateTime));
		   qList.add(vf);
		   
		 I.setValidFor(qList);
		 
		 I.setTotalInstallments(totalInstallments);
		 List<TotalAmount> tList = new ArrayList<TotalAmount>();
		 TotalAmount ta = new TotalAmount();
		   ta.setAmount(amount);
		   ta.setCurrency(currency);
		   tList.add(ta);
		   
		 I.setTotalAmount(tList);
		   
		 I.setCustomerRef(customerRef);
		 I.setBillProfileRef(billProfileRef);
		 I.setScheduleSpecRef(scheduleSpecRef);
		 
		 List<Bills> bList = new ArrayList<Bills>();
		 Bills bi = new Bills();
		   bi.setBillId(billId);
		   bList.add(bi);
		   
		 I.setBills(bList);
		   
		 List<Installments> iList = new ArrayList<Installments>();
		 Installments Ii = new Installments();
		 Ii.setStatus(istatus);
		 Ii.setDueDate(getdate(idueDate));
		 	
		 	List<Amount> aList = new ArrayList<Amount>();
		 	Amount Aa = new Amount();
		 	Aa.setAmount(iamount);
		 	Aa.setCurrency(icurrency);
			aList.add(Aa);
		 Ii.setAmount(aList);
			
		 iList.add(Ii);
		 I.setInstallments(iList);
		 
		  
		  
		 return I;
	 }

}

Feature: Validating Installment Schedule Spec 

Scenario: Generating Token 
	Given generating Token 
	
	
Scenario Outline: Verifying Installment API
Given Creating an Installment "<billPreference>" "<status>" "<startDateTime>""<endDateTime>" <totalInstallments> <amount> "<currency>" "<customerRef>" "<billProfileRef>" "<billId>" "<scheduleSpecRef>" "<istatus>" "<idueDate>" <iamount> "<icurrency>"
When "Installment" API is called with invalid inputs	
Then Validate the <error> code and status in Installment output response
#Then Validate the <code> code , "<message>" , status, message and error message in output response 

Examples:
|billPreference | status | startDateTime            | endDateTime             | totalInstallments | amount | currency | customerRef               | billProfileRef             | billId               |  scheduleSpecRef                                 | istatus | idueDate               | iamount | icurrency|error|
|IMMEDIATE      | OPEN   | 2021-06-22T05:32:40.414Z | 2021-06-28T05:32:40.414Z|   2               | 500.0  |  USD     | 0.0.0.1+-account+533748+0 | 0.0.0.1+-billinfo+535284+0 | 0.0.0.1+-bill+57879+7| 0.0.0.1+-config-installment-schedule_spec+500010 | OPEN    |2021-08-28T05:32:40.414Z | 250.0  |  USD     |400  |
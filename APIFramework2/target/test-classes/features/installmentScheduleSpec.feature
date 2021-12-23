Feature: Validating Installment Schedule Spec 

Scenario: Generating Token 
	Given generating Token 
	
#Scenario Outline: Verifying Installment Schedule Spec API
#Given Creating an InstallmentSchedule Spec "<name>" "<minAmount>" "<minPercent>" <maxIntervalDaysNEI> <maxNumNEI> "<expiresAt>" "<installmentPeriod>" "<installmentType>" "<key>" "<value>" "<dataType>" "<operator>"
#When "InstallmentScheduleSpec" API is called to create
#Then Validate the <error> code and status in InstallmentScheduleSpec output response 
#
#Examples: 
#|name |minAmount |minPercent | maxIntervalDaysNEI |maxNumNEI |expiresAt                |installmentPeriod | installmentType      |key                 |value     |dataType |operator | error |
##Amount
##validAmount
#|Test |10.0      |           |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  ABCD|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |
##decimalAmount
#|Test |10.50     |           |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |
##installmentPeriod DAILY
#|Test |10.0      |           |      30            |      5   |2022-04-28T09:28:00.890Z |  DAILY           |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |
##installmentPeriod QUARTERLY
#|Test |10.0      |           |      30            |      5   |2022-04-28T09:28:00.890Z |  QUARTERLY       |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |
##installmentPeriod SEMIANNUAL
#|Test |10.0      |           |      30            |      5   |2022-04-28T09:28:00.890Z |  SEMIANNUAL      |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |
##installmentPeriod ANNUAL
#|Test |10.0      |           |      30            |      5   |2022-04-28T09:28:00.890Z |  ANNUAL          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |
##installmentType NONEQUAL_INSTALLMENT
#|Test |10.0      |           |      30            |      5   |2022-04-28T09:28:00.890Z |  QUARTERLY       |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |
##installmentType EQUAL_INSTALLMENT
#|Test |10.0      |           |      30            |      5   |2022-04-28T09:28:00.890Z |  QUARTERLY       |  EQUAL_INSTALLMENT   |/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |
##Percent
##validPercent
#|Test |          |  10.0     |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |
##decimalPercent
#|Test |          |  10.50    |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |


#Scenario: Verify Installment Scheduel Spec is created 
#	Given Get header details
#	When "GetInstallmentScheduleSpec" API is called with Get method 
#	Then Validate the 200 code and status in InstallmentScheduleSpec output response 


	
#Scenario Outline: Verifying Installment Schedule Spec API
#Given Creating an InstallmentSchedule Spec "<name>" "<minAmount>" "<minPercent>" <maxIntervalDaysNEI> <maxNumNEI> "<expiresAt>" "<installmentPeriod>" "<installmentType>" "<key>" "<value>" "<dataType>" "<operator>"
#When "InstallmentScheduleSpec" API is called with invalid inputs	
#Then Validate the <error> code and status in InstallmentScheduleSpec output response
#Then Validate the <code> code , "<message>" , status, message and error message in output response

#Examples:
#
#|name |minAmount|minPercent | maxIntervalDaysNEI |maxNumNEI |expiresAt                |installmentPeriod | installmentType      |key                 |value     |dataType |operator | error | code|message|
##InvalidAmount
#|Test |-10.0     |           |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO,/account.ACCOUNT_NO1,/account.ACCOUNT_NO2 |value123,value1,value3   |INTEGER,FLOAT,INTEGER |  GT,LE,EQ    |   400 |10122|Mandatory fields are missing |
##minAmount is zero
#|Test |  0.00    |           |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |10122|Mandatory fields are missing |
##minAmount is -ve
#|Test |-10.00    |           |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |10122|Mandatory fields are missing |
##Invalid maxIntervalDaysNEI
#|Test | 10.00    |           |     -30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |10122|Mandatory fields are missing |
##Invalid maxNumNEI
#|Test | 10.00    |           |      30            |     -5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |
##Back dated expiresAt
#|Test |10.0      |           |      30            |      5   |2010-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |
##Invalid maxNumNEI
#|Test |10.0      |           |      30            |   1500   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |
##Zero maxNumNEI
#|Test |10.0      |           |      30            |   0      |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |
##minPercent is zero
#|Test |          |  0.00     |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |
##minPercent is -ve 
#|Test |          |  -10.50   |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |
##minPercent is greater than 100 
#|Test |          |  110.0    |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |
##Invalid maxIntervalDaysNEI
#|Test |          |  10.0     |      -30           |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |
##missing name
#|     |          |  10.0     |       30           |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   400 |


#Scenario Outline: Verifying Installment Schedule Spec API
#	Given Creating an InstallmentSchedule Spec e2e "<name>" "<minAmount>" "<minPercent>" <maxIntervalDaysNEI> <maxNumNEI> "<expiresAt>" "<installmentPeriod>" "<installmentType>" "<key>" "<value>" "<dataType>" "<operator>"
#	When "InstallmentScheduleSpec" API is called to create
#	Then Validate the <error> code and status in InstallmentScheduleSpec output response 
#	And "GetInstallmentScheduleSpec" API is called with Get method with id 
#	And Validate the 200 code and status in InstallmentScheduleSpec output response 

#Examples: 
#|name |minAmount |minPercent | maxIntervalDaysNEI |maxNumNEI |expiresAt                |installmentPeriod | installmentType      |key                 |value     |dataType |operator | error |
##validAmount
#|Test |10.0      |           |      30            |      5   |2022-04-28T09:28:00.890Z | MONTHLY          |  NONEQUAL_INSTALLMENT|/account.ACCOUNT_NO |value123   |INTEGER |  GT     |   201 |



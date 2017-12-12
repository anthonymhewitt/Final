package pkgCore;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
	//TODO: Build the contructor, getters and setters for the attributes above.
	public Retirement(int YearsToWork, double AnnualReturnWorking, int YearsRetired, double AnnualReturnRetired, double RequiredIncome, double MonthlySSI) {
		iYearsToWork = YearsToWork;
		dAnnualReturnWorking = AnnualReturnWorking;
		iYearsRetired = YearsRetired;
		dAnnualReturnRetired = AnnualReturnRetired;
		dRequiredIncome =  RequiredIncome;
		dMonthlySSI = MonthlySSI;
	}
	
	public double AmountToSave()
	{
		double pv = FinanceLib.pv(dAnnualReturnRetired/12, iYearsRetired*12, dRequiredIncome - dMonthlySSI, 0, false);

		double dAmountToSave = FinanceLib.pmt(dAnnualReturnWorking/12, iYearsToWork*12, 0, pv, false);
		
		return (Math.round(dAmountToSave * 100.0) / 100.0);
	}
	
	public double TotalAmountSaved()
	{
		double dTotalAmountSaved = FinanceLib.pv(dAnnualReturnRetired/12, iYearsRetired*12, dRequiredIncome - dMonthlySSI, 0, false);

		return (-1*Math.round(dTotalAmountSaved*100.0) / 100.0);
	}
}

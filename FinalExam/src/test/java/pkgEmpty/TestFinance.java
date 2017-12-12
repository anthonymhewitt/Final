package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

import org.apache.poi.ss.formula.functions.*;
public class TestFinance {

	
	@Test 
	public void TestAmounts()
	{
		double dMonthsToWork = 40 * 12;
		double rAnnualReturnWorking = 0.07 / 12;
		double dMonthsRetired = 20 * 12;
		double rAnnaulReturnRetired = 0.02 / 12;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;
		double pv = FinanceLib.pv(rAnnaulReturnRetired, dMonthsRetired, dRequiredIncome - dMonthlySSI, 0, false);
		
		double pmt = FinanceLib.pmt(rAnnualReturnWorking, dMonthsToWork, 0, pv, false);
		
		System.out.println(pv);
		System.out.println(pmt);
	}
	
	
	@Test
	public void RetirementTest() {
		Retirement r = new Retirement(40, .07, 20, .02, 10000.00, 2642.00);
		assertEquals(554.13,r.AmountToSave(),.0001);
		assertEquals(1454485.55,r.TotalAmountSaved(),.0001);
	}

}

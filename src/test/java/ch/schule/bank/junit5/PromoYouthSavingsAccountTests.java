package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests für das Promo-Jugend-Sparkonto.
 *
 * @author Luigi Cavuoti
 * @version 1.0
 */
public class PromoYouthSavingsAccountTests
{
	/**
	 * Der Test.
	 */
	@Test
	public void test()
	{
		PromoYouthSavingsAccount a =
			new PromoYouthSavingsAccount("P-1000");

	    a.deposit(0, 99); // no bonus
		assertEquals(99, a.getBalance());

	    a.deposit(0, 100); // bonus of 1
		assertEquals(200, a.getBalance());

		a.deposit(0, 101); // again bonus of 1
		assertEquals(302, a.getBalance());
	}
}

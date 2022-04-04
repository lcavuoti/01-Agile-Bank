package ch.schule.bank.junit5;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.*;


/**
 * Tests der Klasse SalaryAccount.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class SalaryAccountTests
{
	/**
	 * Der Test.
	 */
	@Test
	public void test()
	{
		// Lohnkonto, überziehen von 1000 möglich
		SalaryAccount a = new SalaryAccount("C-1000", -1000);

	    // Einzahlen von 100 => Saldo 100
		assertTrue(a.deposit(0, 100));

	    // Abheben von 1101 darf nicht gehen
		assertFalse(a.withdraw(0, 1101));

	    // Abheben von 200 ok => Saldo -100
		assertTrue(a.withdraw(0, 200));
		assertEquals(-100, a.getBalance());

	    // Abheben bis an die Grenze => Saldo: -1000
		assertTrue(a.withdraw(0, 900));

	    // Jetzt Abheben nicht mehr möglich
		assertFalse(a.withdraw(0, 1));
	}
}

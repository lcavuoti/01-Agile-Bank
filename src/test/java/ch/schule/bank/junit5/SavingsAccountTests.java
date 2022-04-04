package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author Luigi Cavuoti
 * @version 1.0
 */
public class SavingsAccountTests
{
	@Test
	public void test()
	{
		SavingsAccount a = new SavingsAccount("S-1000");

	    assertTrue(a.deposit(0, 1000));
		assertTrue(a.withdraw(0, 1000));
		assertTrue(a.deposit(0, 1000));
		assertFalse(a.withdraw(0, 1001));
	}
}

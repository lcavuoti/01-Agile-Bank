package ch.schule.bank.junit5;

import ch.schule.Account;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static junit.framework.TestCase.*;


/**
 * Tests für die Klasse Account.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class AccountTests
{
	/**
	 * Tested die Initialisierung eines Kontos.
	 */
	@Test
	public void testInit()
	{
		Account a = new Account("A-1000");

	    assertEquals("A-1000", a.getId());
		assertEquals(0, a.getBalance());
	}

	/**
	 * Testet das Einzahlen auf ein Konto.
	 */
	@Test
	public void testDeposit()
	{
		Account a = new Account("A-1000");

	    // CHF 1.-- einzahlen
		assertTrue(a.deposit(0, 100000));
		// Saldo muss 1.-- sein
		assertEquals(100000, a.getBalance());

	    // CHF 2.00 einzahlen
		assertTrue(a.deposit(0, 200000));
	    // Saldo muss 3.-- sein
		assertEquals(300000, a.getBalance());

		// Versuch, negativen Betrag einzuzahlen
		// darf nicht gehen. Saldo muss unverändert
		// bleiben
	    assertFalse(a.deposit(0, -50000));
		assertEquals(300000, a.getBalance());
	}

	/**
	 * Testet das Abheben von einem Konto.
	 */
	@Test
	public void testWithdraw()
	{
		Account a = new Account("A-1000");

		// CHF 1.-- abheben
		assertTrue(a.withdraw(0, 100000));
		// Saldo muss -1.-- sein
		assertEquals(-100000, a.getBalance());

		// CHF 2.00 abheben
		assertTrue(a.withdraw(0, 200000));
		// Saldo muss -3.-- sein
		assertEquals(-300000, a.getBalance());

		// Versuch, negativen Betrag abzuheben
		// darf nicht gehen. Saldo muss unver�ndert
		// bleiben
		assertFalse(a.withdraw(0, -50000));
		assertEquals(-300000, a.getBalance());
	}

	@Test
	public void testReferences()
	{
		TreeMap<String, Account> m = new TreeMap<String, Account>();
	    m.put("A-1000", new Account("A-1000"));
		m.put("A-1001", new Account("A-1001"));

	    Account a, b;

		a = (Account) m.get("A-1002");
		assertNull(a);
		a = (Account) m.get("A-1001");
		assertNotNull(a);

	    b = a;
		a.deposit(0, 1000);
		assertEquals(1000, b.getBalance());
	}

	@Test
	public void testCanTransact()
	{
		Account a = new Account("A-1000");

	    assertTrue(a.canTransact(11));
		a.deposit(11, 100000);
		assertTrue(a.canTransact(11));
		assertTrue(a.canTransact(12));
		assertFalse(a.canTransact(10));
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint()
	{
		System.out.println("--- Gesamtauszüge ---");
		Account a = new Account("A-1000");

		a.deposit(0, 1000000);
		a.withdraw(1, 200000);
		a.withdraw(41, 200000);
		a.print();
	}

	/**
	 * Experimente mit print(year,month).
	 */
	@Test
	public void testMonthlyPrint()
	{
		System.out.println("--- Monatsauszüge ---");

		Account a = new Account("A-1000");

		a.deposit(0, 1000000);
		a.withdraw(1, 200000);
		a.withdraw(31, 200000);

		a.print(1970, 1);
		a.print(1970, 2);
	}

}

package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.*;


/**
 * Tests für die Klasse 'Bank'.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BankTests
{
	@Test
	public void testCreate()
	{
		Bank b = new Bank();

	    assertEquals("A-1000", b.createAccount());
		assertEquals("A-1001", b.createAccount());
	}

	@Test
	public void testDeposit()
	{
		Bank b = new Bank();
		b.createAccount();
		b.createAccount();

		assertTrue(b.deposit("A-1000", 0, 100000));
		assertEquals(100000, b.getBalance("A-1000"));

		assertEquals(0, b.getBalance("A-1001"));
		assertTrue(b.deposit("A-1001", 0, 200000));
		assertEquals(100000, b.getBalance("A-1000"));
		assertEquals(200000, b.getBalance("A-1001"));

		assertFalse(b.deposit("A-1002", 0, 200000));
		assertEquals(100000, b.getBalance("A-1000"));
		assertEquals(200000, b.getBalance("A-1001"));
	}

	@Test
	public void testWithdraw()
	{
		Bank b = new Bank();
		b.createAccount();
		b.createAccount();

		assertTrue(b.withdraw("A-1000", 0, 100000));
		assertEquals(-100000, b.getBalance("A-1000"));
		assertEquals(0, b.getBalance("A-1001"));

		assertTrue(b.withdraw("A-1001", 0, 200000));
		assertEquals(-100000, b.getBalance("A-1000"));
		assertEquals(-200000, b.getBalance("A-1001"));

		assertFalse(b.withdraw("A-1002", 0, 200000));
		assertEquals(-100000, b.getBalance("A-1000"));
		assertEquals(-200000, b.getBalance("A-1001"));
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint()
	{
		System.out.println("-- Gesamtauszüge --");
		Bank b = new Bank();

	    b.createAccount();
		b.createAccount();

	    b.deposit("A-1000", 1, 10000000);
		b.deposit("A-1001", 2, 20000000);
		b.withdraw("A-1000", 3, 1000000);
		b.withdraw("A-1001", 4, 2000000);

	    b.print("A-1000");
		b.print("A-1001");
	}

	/**
	 * Experimente mit print(year, month).
	 */
	@Test
	public void testMonthlyPrint()
	{
		System.out.println("-- Monatsauszüge --");
		Bank b = new Bank();

		b.createAccount();
		b.createAccount();

		b.deposit("A-1000", 1, 10000000);
		b.deposit("A-1001", 2, 20000000);
		b.withdraw("A-1000", 3, 1000000);
		b.withdraw("A-1001", 4, 2000000);
		b.withdraw("A-1000", 33, 1000000);
		b.withdraw("A-1001", 34, 2000000);

		b.print("A-1000", 1970, 1);
		b.print("A-1000", 1970, 2);
		b.print("A-1001", 1970, 1);
		b.print("A-1001", 1970, 2);
	}





}

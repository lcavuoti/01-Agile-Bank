package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BookingTests
{
	/**
	 * Tests f�r die Erzeugung von Buchungen.
	 */
	@Test
	public void testInitialization()
	{
		Booking b = new Booking(1, 1000);

		assertEquals(1, b.getDate());
		assertEquals(1000, b.getAmount());
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint()
	{
		Booking b;

	    b = new Booking(19000, 100000);
		b.print(0);

		b = new Booking(1, 1000000000);
		b.print(0);
	}
}

package ch.schule;

import java.util.*;

/**
 * Konto.
 * 
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */
public class Account {
	/**
	 * Die Kontonummer (kann auch Buchstaben und Sonderzeichen enthalten).
	 * 
	 * @uml.property name="id"
	 */
	private String id;

	/**
	 * Kontostand in Millirappen.
	 * 
	 * @uml.property name="balance"
	 */
	private long balance;

	/** 
	 * Die Buchungen.
	 * @uml.property name="bookings"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" aggregation="composite" inverse="account:ch.schule.m326.bank.Booking"
	 */
	private ArrayList<Booking> bookings;

	/**
	 * Erzeugt ein neues Konto.
	 * 
	 * @param id
	 *            die Kontonummer
	 */
	public Account(String id) {
		this.id = id;
		this.balance = 0;
		this.bookings = new ArrayList<Booking>();
	}

	/**
	 * Gibt die Kontonummer zur�ck.
	 * 
	 * @return die Kontonummer
	 * @uml.property name="id"
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gibt das Saldo zur�ck.
	 * 
	 * @return Saldo
	 * @uml.property name="balance"
	 */
	public long getBalance() {
		return balance;
	}

	/** 
	 * Gibt die Buchungsliste zurück
	 * @param
	 * @return
	 * @uml.property  name="bookings"
	 */
	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public boolean canTransact(int date) {
		if (bookings.isEmpty())
			return true;

		Booking b = (Booking) bookings.get(bookings.size() - 1);

		return date >= b.getDate();
	}

	/**
	 * Zahlt den gegebenen Betrag aufs Konto ein.
	 * 
	 * @param date
	 *            das Transaktionsdatum
	 * @param amount
	 *            der einzuzahlende Betrag
	 * 
	 * @return boolean <code>true</code>, falls die Einzahlung erfolgreich war,
	 *         andernfalls (z.B. bei negativem Betrag) <code>false</code>.
	 */
	public boolean deposit(int date, long amount) {
		if (amount < 0)
			return false;

		if (!canTransact(date))
			return false;

		balance += amount;
		bookings.add(new Booking(date, amount));
		return true;
	}

	/**
	 * Hebt den gegebenen Betrag vom Konto ab.
	 * 
	 * @param date
	 *            das Transaktionsdatum
	 * @param amount
	 *            der abzuhebende Betrag
	 * 
	 * @return boolean <code>true</code>, falls die Abhebung erfolgreich war,
	 *         andernfalls (z.B. bei negativem Betrag) <code>false</code>.
	 */
	public boolean withdraw(int date, long amount) {
		if (amount < 0)
			return false;

		if (!canTransact(date))
			return false;

		balance -= amount;
		// Achtung: hier Buchung mit negativem Betrag!
		bookings.add(new Booking(date, -amount));
		return true;
	}

	/**
	 * Druckt den Kontoauszug dieses Kontos.
	 */
	public void print() {
		System.out.println("Kontoauszug '" + id + "'");
		System.out.println("Datum          Betrag      Saldo");

		long balance = 0;

		for (int i = 0; i < bookings.size(); ++i) {
			Booking b = (Booking) bookings.get(i);

			b.print(balance);
			balance += b.getAmount();
		}
	}

	/**
	 * Druckt den Monats-Kontoauszug dieses Kontos.
	 * 
	 * @param year
	 *            das Jahr
	 * @param month
	 *            der Monat
	 */
	public void print(int year, int month) {
		System.out.println("Kontoauszug '" + id + "' " + "Monat: " + month
				+ "." + year);
		System.out.println("Datum          Betrag      Saldo");

		int startDate = (year - 1970) * 360 + (month - 1) * 30;
		int endDate = startDate + 30;
		long balance = 0;

		for (int i = 0; i < bookings.size(); ++i) {
			Booking b = (Booking) bookings.get(i);

			if (b.getDate() >= endDate)
				break; // Fertig, aus der Schleife springen

			if (b.getDate() >= startDate)
				b.print(balance);

			balance += b.getAmount();
		}
	}

	/** 
	 * Setter of the property <tt>bookings</tt>
	 * @param bookings  The bookings to set.
	 * @uml.property  name="bookings"
	 */
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	/** 
	 * @uml.property name="bank"
	 * @uml.associationEnd inverse="accounts:ch.schule.m326.bank.Bank"
	 */
	private Bank bank;

	/** 
	 * Getter of the property <tt>bank</tt>
	 * @return  Returns the bank.
	 * @uml.property  name="bank"
	 */
	public Bank getBank() {
		return bank;
	}

	/** 
	 * Setter of the property <tt>bank</tt>
	 * @param bank  The bank to set.
	 * @uml.property  name="bank"
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	
}

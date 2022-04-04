package ch.schule;

import java.util.*;

/**
 * Die Bank.
 *
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */
public class Bank
{
	/**
	 * Liste aller Konti.
	 */
	private TreeMap<String,Account> accounts;

	/**
	 * Nächste Kontonummer (numerisch).
	 */
	private int nextAccountId;

	/**
	 * Initialisiert eine neue Bank.
	 */
	public Bank()
	{
		this.accounts = new TreeMap<String,Account>();
		this.nextAccountId = 1000;
	}

	/**
	 * Erzeugt ein neues Konto
	 * @param id String die Kontonummer des neuen Kontos
	 * @return boolean ob das Erstellen gefunzt hat
	 */
	public String createAccount()
	{
		String id = "A-" + nextAccountId;

		nextAccountId++;
		accounts.put(id, new Account(id));

		return id;
	}

	/**
	 * Gibt den Kontostand des Kontos mit der gegebenen
	 * Kontonummer zurück.
	 *
	 * <p>
	 * Falls kein Konto mit der gesuchten Kontonummer
	 * existiert, gibt diese Methode 0 (zero) zur�ck.
	 * </p>
	 *
	 * @param id die Kontonummer
	 * @return long der Kontostand des Kontos
	 */
	public long getBalance(String id)
	{
		Account a = (Account) accounts.get(id);

	    if (a == null)
			return 0;

		return a.getBalance();
	}

	/**
	 * Zahlt den gegebenen Betrag auf das Konto mit
	 * der gegebenen Kontonummer ein.
	 *
	 * <p>
	 * Diese Methode kann <code>false</code> zur�ckgeben,
	 * falls das Konto nicht existiert, oder falls die
	 * Einzahlung auf dem Konto nicht funktioniert.
	 * </p>
	 *
	 * @param id die Kontonummer
	 * @param date das Transaktionsdatum
	 * @param amount der einzuzahlende Betrag
	 * @return boolean ob die Einzahlung erfolgreich war
	 */
	public boolean deposit(String id, int date, long amount)
	{
		// 1. Konto holen
		Account a = (Account) accounts.get(id);

		if (a == null)
			return false; // nicht gefunden

	    // Einzahlen und Erfolg zur�ckgeben
		return a.deposit(date, amount);
	}

	/**
	 * Hebt den gegebenen Betrag vom Konto mit
	 * der gegebenen Kontonummer ab.
	 *
	 * <p>
	 * Diese Methode kann <code>false</code> zur�ckgeben,
	 * falls das Konto nicht existiert, oder falls das
	 * Abheben vom Konto nicht funktioniert.
	 * </p>
	 *
	 * @param id die Kontonummer
	 * @param date das Transaktionsdatum
	 * @param amount der abzuhebende Betrag
	 * @return boolean ob das Abheben erfolgreich war
	 */
	public boolean withdraw(String id, int date,
							long amount)
	{
		// 1. Konto suchen
		Account a = (Account) accounts.get(id);

		if (a == null)
			return false; // nicht gefunden

		// Abheben und Erfolg zurückgeben
		return a.withdraw(date, amount);
	}

	/**
	 * Druckt den Kontoauszug des Kontos mit der gegebenen
	 * Kontonummer.
	 *
	 * @param id die Kontonummer des zu druckenden Kontos
	 */
	public void print(String id)
	{
      // 1. Konto suchen
      Account a = (Account) accounts.get(id);

	    if (a == null)
		    return;

	    a.print();
	}

	/**
	 * Druckt den Kontoauszug des Kontos mit der gegebenen
	 * Kontonummer f�r den gegebenen Monat.
	 *
	 * @param id die Kontonummer des zu druckenden Kontos
	 * @param year das Jahr //m�ri is gay ;-)
	 * @param month der Monat 
	 * 
	 * 
	 */
	public void print(String id, int year, int month) {
		// 1. Konto suchen
		Account a = (Account) accounts.get(id);
		if (a == null)
			return;
		a.print(year, month);
	}

}

package application.utilityclasses;

import application.exceptions.IbanException;
import domain.model.commands.PaymentCommand;

public class PaymentCommandValidation {

    public static Boolean validatePaymentCommand(PaymentCommand paymentCommand) throws Exception {
        short foundErrors = 0;
        if (paymentCommand.getRecipientIban().length() != 20) {
            foundErrors++;
            throw new IbanException("Iban wrong! Make sure length = 20 and it is correct...");

        }
        if (paymentCommand.getAuftraggeberIban().length() != 20) {
            foundErrors++;
            throw new IbanException("Iban wrong! Make sure length = 20 and it is correct...");
        }
        if (paymentCommand.getRecipientName() == null || paymentCommand.getRecipientName().length() >= 70) {
            foundErrors++;
            throw new Exception("EmpfaengerName ist leer oder laenger als 70 Zeichen!");
        }
        if (paymentCommand.getAuftraggeberName() == null || paymentCommand.getAuftraggeberName().length() >= 70) {
            foundErrors++;
            throw new Exception("Name des Auftraggebers ist leer oder laenger als 70 Zeichen!");
        }
        Double d = paymentCommand.getPaymentAmount();
        String[] amountt = d.toString().split("\\.");
        short numberOfDecimals = (short) amountt[1].length();

        if (paymentCommand.getPaymentAmount() <= 0 || numberOfDecimals > 2) {
            foundErrors++;
            throw new Exception("Betrag darf nicht kleiner als 0 sein und darf maximal 2 Nachkomma-Stellen haben!");
        }
        if (paymentCommand.getAuftraggeberAdresse() != null) {
            String adr = paymentCommand.getAuftraggeberAdresse();
            if (adr.length() >= 70) {
                foundErrors++;
                throw new Exception("Auftraggeber-Name ist laenger als 70 Zeichen!");
            }
        }
        if (paymentCommand.getRecipientAdresse() != null) {
            String adrR = paymentCommand.getRecipientAdresse();
            if (adrR.length() >= 70) {
                foundErrors++;
                throw new Exception("Empfaenger-Name ist laenger als 70 Zeichen!");
            }
        }
        if (paymentCommand.getVerwendungsZweck() != null) {
            String vzw = paymentCommand.getAuftraggeberAdresse();
            if (!(vzw.matches("^[a-zA-Z0-9]*$")) || vzw.length() >= 70) {
                foundErrors++;
                throw new Exception(
                        "Achtung: Alphanumerischer String beim Verwendungszweck eingeben, maximal 70 Zeichen.");
            }
        }
        if (paymentCommand.getZahlungsReferenz() != null) {
            String zrf = paymentCommand.getZahlungsReferenz();
            if (!(zrf.matches("^[a-zA-Z0-9]*$")) || zrf.length() >= 35) {
                foundErrors++;
                throw new Exception(
                        "Achtung: Alphanumerischer String bei der Zahlungsreferenz eingeben, maximal 35 Zeichen.");
            }
        }

        if (foundErrors > 0)
            return false;
        else
            return true;

    }

}

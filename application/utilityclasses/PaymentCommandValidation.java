package application.utilityclasses;

import java.io.IOException;

import application.exceptions.IbanException;
import domain.model.commands.PaymentCommand;
import infrastructure.repository.SimulatedDB.PaymentsDao;
import infrastructure.repository.SimulatedDB.PaymentsDaoDummyImpl;

public class PaymentCommandValidation {
    static PaymentsDao paymentsDao = new PaymentsDaoDummyImpl(); // normally should not be here, just for time reasons

    public static Boolean validatePaymentCommand(PaymentCommand paymentCommand) throws Exception {
        short foundErrors = 0;
        if (paymentCommand.getRecipientIban().length() != 20) {
            foundErrors++;
            // persist the Data to our pseudo repository / DB
            // Don`t instanciate a Payment, since it has to be aborted
            paymentsDao.insertNewAbortedPayment(paymentCommand);
            try {
                ReadOrWriteToCSV.writeToAbortedPayments(paymentCommand);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Payment aborted and saved to DB and CSV. " + " From Customer "
                    + paymentCommand.getAuftraggeberName() + " to Customer " + paymentCommand.getRecipientName()
                    + " with Amount: EUR " + paymentCommand.getPaymentAmount() + " [FromPaymentCommandService]");
            throw new IbanException("Iban wrong! Make sure length = 20 and it is correct...");

        }
        if (paymentCommand.getAuftraggeberIban().length() != 20) {
            foundErrors++;
            paymentsDao.insertNewAbortedPayment(paymentCommand);
            try {
                ReadOrWriteToCSV.writeToAbortedPayments(paymentCommand);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Payment aborted and saved to DB and CSV. " + " From Customer "
                    + paymentCommand.getAuftraggeberName() + " to Customer " + paymentCommand.getRecipientName()
                    + " with Amount: EUR " + paymentCommand.getPaymentAmount() + " [FromPaymentCommandService]");
            throw new IbanException("Iban wrong! Make sure length = 20 and it is correct...");
        }
        if (paymentCommand.getRecipientName() == null || paymentCommand.getRecipientName().length() >= 70) {
            foundErrors++;
            paymentsDao.insertNewAbortedPayment(paymentCommand);
            try {
                ReadOrWriteToCSV.writeToAbortedPayments(paymentCommand);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Payment aborted and saved to DB and CSV. " + " From Customer "
                    + paymentCommand.getAuftraggeberName() + " to Customer " + paymentCommand.getRecipientName()
                    + " with Amount: EUR " + paymentCommand.getPaymentAmount() + " [FromPaymentCommandService]");
            throw new Exception("EmpfaengerName ist leer oder laenger als 70 Zeichen!");
        }
        if (paymentCommand.getAuftraggeberName() == null || paymentCommand.getAuftraggeberName().length() >= 70) {
            foundErrors++;
            paymentsDao.insertNewAbortedPayment(paymentCommand);
            try {
                ReadOrWriteToCSV.writeToAbortedPayments(paymentCommand);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Payment aborted and saved to DB and CSV. " + " From Customer "
                    + paymentCommand.getAuftraggeberName() + " to Customer " + paymentCommand.getRecipientName()
                    + " with Amount: EUR " + paymentCommand.getPaymentAmount() + " [FromPaymentCommandService]");
            throw new Exception("Name des Auftraggebers ist leer oder laenger als 70 Zeichen!");
        }
        Double d = paymentCommand.getPaymentAmount();
        String[] amountt = d.toString().split("\\.");
        short numberOfDecimals = (short) amountt[1].length();

        if (paymentCommand.getPaymentAmount() <= 0 || numberOfDecimals > 2) {
            foundErrors++;
            paymentsDao.insertNewAbortedPayment(paymentCommand);
            try {
                ReadOrWriteToCSV.writeToAbortedPayments(paymentCommand);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Payment aborted and saved to DB and CSV. " + " From Customer "
                    + paymentCommand.getAuftraggeberName() + " to Customer " + paymentCommand.getRecipientName()
                    + " with Amount: EUR " + paymentCommand.getPaymentAmount() + " [FromPaymentCommandService]");
            throw new Exception("Betrag darf nicht kleiner als 0 sein und darf maximal 2 Nachkomma-Stellen haben!");
        }
        if (paymentCommand.getAuftraggeberAdresse() != null) {
            String adr = paymentCommand.getAuftraggeberAdresse();
            if (adr.length() >= 70) {
                foundErrors++;
                paymentsDao.insertNewAbortedPayment(paymentCommand);
                try {
                    ReadOrWriteToCSV.writeToAbortedPayments(paymentCommand);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Payment aborted and saved to DB and CSV. " + " From Customer "
                        + paymentCommand.getAuftraggeberName() + " to Customer " + paymentCommand.getRecipientName()
                        + " with Amount: EUR " + paymentCommand.getPaymentAmount() + " [FromPaymentCommandService]");
                throw new Exception("Auftraggeber-Name ist laenger als 70 Zeichen!");
            }
        }
        if (paymentCommand.getRecipientAdresse() != null) {
            String adrR = paymentCommand.getRecipientAdresse();
            if (adrR.length() >= 70) {
                foundErrors++;
                paymentsDao.insertNewAbortedPayment(paymentCommand);
                try {
                    ReadOrWriteToCSV.writeToAbortedPayments(paymentCommand);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Payment aborted and saved to DB and CSV. " + " From Customer "
                        + paymentCommand.getAuftraggeberName() + " to Customer " + paymentCommand.getRecipientName()
                        + " with Amount: EUR " + paymentCommand.getPaymentAmount() + " [FromPaymentCommandService]");
                throw new Exception("Empfaenger-Name ist laenger als 70 Zeichen!");
            }
        }
        if (paymentCommand.getVerwendungsZweck() != null) {
            String vzw = paymentCommand.getAuftraggeberAdresse();
            if (!(vzw.matches("^[a-zA-Z0-9]*$")) || vzw.length() >= 70) {
                foundErrors++;
                paymentsDao.insertNewAbortedPayment(paymentCommand);
                try {
                    ReadOrWriteToCSV.writeToAbortedPayments(paymentCommand);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Payment aborted and saved to DB and CSV. " + " From Customer "
                        + paymentCommand.getAuftraggeberName() + " to Customer " + paymentCommand.getRecipientName()
                        + " with Amount: EUR " + paymentCommand.getPaymentAmount() + " [FromPaymentCommandService]");
                throw new Exception(
                        "Achtung: Alphanumerischer String beim Verwendungszweck eingeben, maximal 70 Zeichen.");
            }
        }
        if (paymentCommand.getZahlungsReferenz() != null) {
            String zrf = paymentCommand.getZahlungsReferenz();
            if (!(zrf.matches("^[a-zA-Z0-9]*$")) || zrf.length() >= 35) {
                foundErrors++;
                paymentsDao.insertNewAbortedPayment(paymentCommand);
                try {
                    ReadOrWriteToCSV.writeToAbortedPayments(paymentCommand);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Payment aborted and saved to DB and CSV. " + " From Customer "
                        + paymentCommand.getAuftraggeberName() + " to Customer " + paymentCommand.getRecipientName()
                        + " with Amount: EUR " + paymentCommand.getPaymentAmount() + " [FromPaymentCommandService]");
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

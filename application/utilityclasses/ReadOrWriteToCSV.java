package application.utilityclasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.model.aggregates.Payment;
import domain.model.commands.PaymentCommand;
import domain.model.valueobjects.csvValueObjects.AbortedPayment;
import domain.model.valueobjects.csvValueObjects.SuccessfulPayment;

public class ReadOrWriteToCSV {

    // write to successful payments CSV
    public static void writeToSuccessfulPayments(PaymentCommand paymentCommand) throws IOException {
        // File successFile = new File("C:\\successful.csv");
        // successFile.createNewFile(); // if file already exists will do nothing
        // new FileOutputStream("C:" + File.separator + "successful.csv", true).close();

        String filePath = "D:" + File.separator + "successful.csv";
        FileWriter fileWriter = new FileWriter(filePath);
        try {

            fileWriter.append("id, auftraggIBAN, recipientIBAN, auftraggNAME, recipientNAME, amount");
            fileWriter.append(String.valueOf(paymentCommand.getPaymentId()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(paymentCommand.getAuftraggeberIban()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(paymentCommand.getRecipientIban()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(paymentCommand.getAuftraggeberName()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(paymentCommand.getRecipientName()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(paymentCommand.getPaymentAmount() + "")); // cast to String
            fileWriter.append("\n");

        } catch (FileNotFoundException e) {
            System.err.println("Could not find File");
        } catch (Exception e) {
            System.err.println("Could not write to File...");
        } finally {
            try {
                fileWriter.flush(); // flush the stream
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // write to aborted payments CSV
    public static void writeToAbortedPayments(PaymentCommand paymentCommand) throws IOException {
        // File abortedFile = new File("C:\\aborted.csv");
        new FileOutputStream("C:\\aborted.csv", true).close();
        // abortedFile.createNewFile(); // if file already exists will do nothing
        // FileOutputStream oFile = new FileOutputStream(yourFile, false);

        String filePath = "C:\\aborted.csv";
        FileWriter fileWriter = new FileWriter(filePath);

        try {

            fileWriter.append("id, auftraggIBAN, recipientIBAN, auftraggNAME, recipientNAME, amount");
            fileWriter.append("\\n");
            fileWriter.append(String.valueOf(paymentCommand.getPaymentId()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(paymentCommand.getAuftraggeberIban()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(paymentCommand.getRecipientIban()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(paymentCommand.getAuftraggeberName()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(paymentCommand.getRecipientName()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(paymentCommand.getPaymentAmount() + "")); // cast to String
            fileWriter.append("\\n");

        } catch (FileNotFoundException e) {
            System.err.println("Could not find File");
        } catch (Exception e) {
            System.err.println("Could not write to File...");
        } finally {
            try {
                fileWriter.flush(); // flush the stream
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // read successful.csv
    public static void readSuccessfulCsv() {
        // List of successful payments dummylist for reading the CSV into
        List<SuccessfulPayment> listSuccessful = new ArrayList<SuccessfulPayment>();
        BufferedReader reader = null;
        try {
            String line = "";
            reader = new BufferedReader(new FileReader("C:\\successful.csv"));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length > 0) {
                    // Create new successful payment value object to keep it seperate from the
                    // normal business logic, just for csv files

                    SuccessfulPayment successfulPayment = new SuccessfulPayment(fields[0], fields[1], fields[2],
                            fields[3], fields[4], fields[5]);

                    listSuccessful.add(successfulPayment); // add to dummy List
                }
            } // end while
            for (SuccessfulPayment successfulPayment : listSuccessful) {
                System.out.printf(
                        "[paymentId=%s, IBANAuftraggeber=%s, IBANEmpfaenger=%s, NameAuftraggeber=%s, NameEmpfaenger=%s, BetragInEuro=%s\n",
                        successfulPayment.getId(), successfulPayment.getAuftraggIban(),
                        successfulPayment.getRecipientIban(), successfulPayment.getAuftraggName(),
                        successfulPayment.getRecipientName(), successfulPayment.getAmount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    // read aborted.csv
    public static void readAbortedCsv() {
        // List of aborted payments dummylist for reading the CSV into
        List<AbortedPayment> listAborted = new ArrayList<AbortedPayment>();

        BufferedReader reader = null;
        try {
            String line = "";
            reader = new BufferedReader(new FileReader("C:\\aborted.csv"));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length > 0) {
                    // Create new successful payment value object to keep it seperate from the
                    // normal business logic, just for csv files

                    AbortedPayment abortedPayment = new AbortedPayment(fields[0], fields[1], fields[2], fields[3],
                            fields[4], fields[5]);

                    listAborted.add(abortedPayment); // add to dummy list

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}

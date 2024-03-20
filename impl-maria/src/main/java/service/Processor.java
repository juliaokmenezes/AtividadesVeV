package service;

import models.Invoice;
import models.Payment;
import models.Ticket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Processor {

    public static List<Payment> processTicket(Invoice invoice, List<Ticket> tickets) {

        List<Payment> payments = new ArrayList<>();

        double totalPaid = tickets.stream()
                .mapToDouble(Ticket::getPaidAmount)
                .peek(amount -> payments.add(new Payment(amount, "BOLETO")))
                .sum();


        if (totalPaid >= invoice.getTotalAmount()) {
            invoice.setPaid(true);
        }

        return payments;
   }
}

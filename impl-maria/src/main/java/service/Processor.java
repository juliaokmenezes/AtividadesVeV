package service;

import models.Invoice;
import models.Payment;
import models.Ticket;

import java.time.LocalDate;
import java.util.List;

public class Processor {
    public static Payment createPayment(Double value, LocalDate date) {
        return new Payment(value, date, "BOLETO");
    }

    public List<Payment> processTicket(Invoice invoice, List<Ticket> tickets) {
        return null;
    }
}

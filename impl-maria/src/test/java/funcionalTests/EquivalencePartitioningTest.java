package funcionalTests;

import models.Invoice;
import models.Payment;
import models.Ticket;
import org.junit.Test;
import service.Processor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class EquivalencePartitioningTest {

    @Test
    public void testFaturaValida() {
        Invoice invoice = new Invoice(new Date(), 100.00, "Cliente A" , false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 50.00),
                new Ticket("002", new Date(), 60.00)
        );

        List<Payment> payments = Processor.processTicket(invoice, tickets);

        assertTrue(invoice.isPaid());
        assertEquals(2, payments.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFaturaInvalida() {
        Invoice invoice = new Invoice(new Date(), -100.00, "Cliente B" , false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 50.00),
                new Ticket("002", new Date(), 60.00)
        );

        Processor.processTicket(invoice, tickets);
    }

    @Test
    public void testBoletosValidos() {
        Invoice invoice = new Invoice(new Date(), 100.00, "Cliente C", false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 50.00),
                new Ticket("002", new Date(), 60.00)
        );

        List<Payment> payments = Processor.processTicket(invoice, tickets);

        assertEquals(2, payments.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoletosInvalidos() {
        // Caso de teste para boletos inválidos com valor negativo
        Invoice invoice = new Invoice(new Date(), 100.00, "Cliente D" , false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 50.00),
                new Ticket("002", new Date(), -60.00) // Valor negativo
        );

        Processor.processTicket(invoice, tickets);
    }
}


package funcionalTests;

import org.junit.Test;
import static org.junit.Assert.*;

import models.Invoice;
import models.Ticket;
import service.Processor;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DecisionTableTest {

    @Test
    public void testValorTotalBoletosValidosFaturaPaga() {
        Invoice invoice = new Invoice(new Date(), 100.00, "Cliente A", false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 50.00),
                new Ticket("002", new Date(), 60.00)
        );

        Processor.processTicket(invoice, tickets);

        assertTrue(invoice.isPaid());
    }

    @Test
    public void testValorTotalBoletosValidosFaturaNaoPaga() {
        Invoice invoice = new Invoice(new Date(), 100.00, "Cliente B", false);
        List<Ticket> tickets = Collections.singletonList(
                new Ticket("001", new Date(), 50.00)
        );

        Processor.processTicket(invoice, tickets);

        assertFalse(invoice.isPaid());
    }

    @Test
    public void testValorTotalBoletosValidosFaturaPaga2() {
        Invoice invoice = new Invoice(new Date(), 100.00, "Cliente C", false);
        List<Ticket> tickets = Collections.singletonList(
                new Ticket("001", new Date(), 100.00)
        );

        Processor.processTicket(invoice, tickets);

        assertTrue(invoice.isPaid());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValorNegativo() {
        Invoice invoice = new Invoice(new Date(), -100.00, "Cliente D", false);
        List<Ticket> tickets = Collections.singletonList(
                new Ticket("001", new Date(), 50.00)
        );

        Processor.processTicket(invoice, tickets);
    }

    @Test
    public void testListaVaziaFaturaPaga() {
        Invoice invoice = new Invoice(new Date(), 0.00, "Cliente E", false);
        List<Ticket> tickets = Collections.emptyList();

        Processor.processTicket(invoice, tickets);

        assertTrue(invoice.isPaid());
    }
}

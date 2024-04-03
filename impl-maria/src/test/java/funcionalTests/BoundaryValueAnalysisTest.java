package funcionalTests;

import models.Invoice;
import models.Ticket;
import org.junit.Test;
import service.Processor;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BoundaryValueAnalysisTest {

    @Test
    public void testFaturaPagaComValorMinimo() {

        Invoice invoice = new Invoice(new Date(), 0.00, "Cliente A" , false);
        List<Ticket> tickets = Collections.emptyList();

        Processor.processTicket(invoice, tickets);

        assertTrue(invoice.isPaid());

    }

    @Test
    public void testFaturaNaoPagaComValorMinimoDoBoleto() {
        Invoice invoice = new Invoice(new Date(), 1.00, "Cliente B" , false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 1.00)
        );

        Processor.processTicket(invoice, tickets);

        assertFalse(invoice.isPaid());
    }

    @Test
    public void testFaturaPagaComValorMaximoDaFatura() {
        Invoice invoice = new Invoice(new Date(),  Double.MAX_VALUE, "Cliente C" , false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), Double.MAX_VALUE)
        );

        Processor.processTicket(invoice, tickets);

        assertTrue(invoice.isPaid());
    }

    @Test
    public void testFaturaPagaComValorMaximoDoBoleto() {
        Invoice invoice = new Invoice(new Date(),  Double.MAX_VALUE, "Cliente D" , false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), Double.MAX_VALUE)
        );

        Processor.processTicket(invoice, tickets);

        assertTrue(invoice.isPaid());
    }
}

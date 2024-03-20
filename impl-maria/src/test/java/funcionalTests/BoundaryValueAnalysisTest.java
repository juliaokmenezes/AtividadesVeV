package funcionalTests;

import models.Invoice;
import models.Ticket;
import org.junit.Test;
import service.Processor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BoundaryValueAnalysisTest {

    @Test
    public void testFaturaPagaComValorMinimo() {

        Invoice invoice = new Invoice(new Date(), 100.00, "Cliente A" , false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 100.00)
        );

        Processor.processTicket(invoice, tickets);

        assertTrue(invoice.isPaid());

    }

    @Test
    public void testFaturaNaoPagaComValorMenorQueMinimo() {
        // TODO
    }

    @Test
    public void testFaturaPagaComValorMaximo() {
        // TODO
    }

    @Test
    public void testFaturaNaoPagaComValorMaiorQueMaximo() {
        // TODO
    }
}

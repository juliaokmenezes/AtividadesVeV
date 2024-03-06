import models.Ticket;
import models.Invoice;
import models.Payment;
import org.junit.Test;
import service.Processor;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeradorDeBoletosTests{

    @Test
    public void testProcessamentoFaturaPaga() {
        Invoice invoice = new Invoice(new Date(), 1500.00, "Cliente Teste");
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("1", new Date(), 500.00));
        tickets.add(new Ticket("2", new Date(), 400.00));
        tickets.add(new Ticket("3", new Date(), 600.00));

        Processor processor = new Processor();
        List<Payment> pagamentos = processor.processTicket(invoice, tickets);

        assertTrue(invoice.isPayd());
        assertEquals(3, pagamentos.size());
    }

    @Test
    public void testProcessamentoFaturaNaoPaga() {
        Invoice invoice = new Invoice(new Date(), 1500.00, "Cliente Teste");
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("1", new Date(), 500.00));
        tickets.add(new Ticket("2", new Date(), 400.00));
        tickets.add(new Ticket("3", new Date(), 300.00));

        Processor processor = new Processor();
        List<Payment> pagamentos = processor.processTicket(invoice, tickets);

        assertFalse(invoice.isPayd());
        assertEquals(3, pagamentos.size());
    }


}

package junit5Tests;

import models.Invoice;
import models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Processor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Processor Test Suite")
public class ProcessorTest {

    private Invoice invoice;

    @BeforeEach
    void setUp() {
        invoice = new Invoice(new Date(), 0.00, "Cliente A", false);
    }

    @Test
    @DisplayName("Fatura Paga Com Valor Mínimo")
    void testFaturaPagaComValorMinimo() {
        List<Ticket> tickets = Collections.emptyList();
        Processor.processTicket(invoice, tickets);
        assertTrue(invoice.isPaid());
    }

    @Test
    @DisplayName("Fatura Não Paga Com Valor Mínimo Do Boleto")
    void testFaturaNaoPagaComValorMinimoDoBoleto() {
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 1.00)
        );
        Processor.processTicket(invoice, tickets);
        assertFalse(invoice.isPaid());
    }

    @Test
    @DisplayName("Valor Total Boletos Válidos: Fatura Paga")
    void testValorTotalBoletosValidosFaturaPaga() {
        invoice = new Invoice(new Date(), 100.00, "Cliente A", false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 50.00),
                new Ticket("002", new Date(), 60.00)
        );
        Processor.processTicket(invoice, tickets);
        assertTrue(invoice.isPaid());
    }

    @Test
    @DisplayName("Valor Total Boletos Válidos: Fatura Não Paga")
    void testValorTotalBoletosValidosFaturaNaoPaga() {
        invoice = new Invoice(new Date(), 100.00, "Cliente B", false);
        List<Ticket> tickets = Collections.singletonList(
                new Ticket("001", new Date(), 50.00)
        );
        Processor.processTicket(invoice, tickets);
        assertFalse(invoice.isPaid());
    }

    @Test
    @DisplayName("Valor Total Boletos Válidos: Fatura Paga 2")
    void testValorTotalBoletosValidosFaturaPaga2() {
        invoice = new Invoice(new Date(), 100.00, "Cliente C", false);
        List<Ticket> tickets = Collections.singletonList(
                new Ticket("001", new Date(), 100.00)
        );
        Processor.processTicket(invoice, tickets);
        assertTrue(invoice.isPaid());
    }

    @Test
    @DisplayName("Valor Negativo - Exceção Esperada")
    void testValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Invoice invoice = new Invoice(new Date(), -100.00, "Cliente D", false);
            List<Ticket> tickets = Collections.singletonList(
                    new Ticket("001", new Date(), 50.00)
            );
            Processor.processTicket(invoice, tickets);
        });
    }

    @Test
    @DisplayName("Lista Vazia - Fatura Paga")
    void testListaVaziaFaturaPaga() {
        invoice = new Invoice(new Date(), 0.00, "Cliente E", false);
        List<Ticket> tickets = Collections.emptyList();
        Processor.processTicket(invoice, tickets);
        assertTrue(invoice.isPaid());
    }

    @Test
    @DisplayName("Fatura Paga Com Valor Mínimo (Teste Dobrado)")
    void testFaturaPagaComValorMinimo_Duplicated() {
        List<Ticket> tickets = Collections.emptyList();
        Processor.processTicket(invoice, tickets);
        assertTrue(invoice.isPaid());
    }

    @Test
    @DisplayName("Fatura Não Paga Com Valor Mínimo Do Boleto (Teste Dobrado)")
    void testFaturaNaoPagaComValorMinimoDoBoleto_Duplicated() {
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 1.00)
        );
        Processor.processTicket(invoice, tickets);
        assertFalse(invoice.isPaid());
    }

    @Test
    @DisplayName("Valor Total Boletos Válidos: Fatura Paga (Teste Dobrado)")
    void testValorTotalBoletosValidosFaturaPaga_Duplicated() {
        invoice = new Invoice(new Date(), 100.00, "Cliente A", false);
        List<Ticket> tickets = Arrays.asList(
                new Ticket("001", new Date(), 50.00),
                new Ticket("002", new Date(), 60.00)
        );
        Processor.processTicket(invoice, tickets);
        assertTrue(invoice.isPaid());
    }

    @Test
    @DisplayName("Valor Total Boletos Válidos: Fatura Não Paga (Teste Dobrado)")
    void testValorTotalBoletosValidosFaturaNaoPaga_Duplicated() {
        invoice = new Invoice(new Date(), 100.00, "Cliente B", false);
        List<Ticket> tickets = Collections.singletonList(
                new Ticket("001", new Date(), 50.00)
        );
        Processor.processTicket(invoice, tickets);
        assertFalse(invoice.isPaid());
    }

    @Test
    @DisplayName("Valor Total Boletos Válidos: Fatura Paga 2 (Teste Dobrado)")
    void testValorTotalBoletosValidosFaturaPaga2_Duplicated() {
        invoice = new Invoice(new Date(), 100.00, "Cliente C", false);
        List<Ticket> tickets = Collections.singletonList(
                new Ticket("001", new Date(), 100.00)
        );
        Processor.processTicket(invoice, tickets);
        assertTrue(invoice.isPaid());
    }

    @Test
    @DisplayName("Valor Negativo - Exceção Esperada (Teste Dobrado)")
    void testValorNegativo_Duplicated() {
        assertThrows(IllegalArgumentException.class, () -> {
            Invoice invoice = new Invoice(new Date(), -100.00, "Cliente D", false);
            List<Ticket> tickets = Collections.singletonList(
                    new Ticket("001", new Date(), 50.00)
            );
            Processor.processTicket(invoice, tickets);
        });
    }

    @Test
    @DisplayName("Lista Vazia - Fatura Paga (Teste Dobrado)")
    void testListaVaziaFaturaPaga_Duplicated() {
        invoice = new Invoice(new Date(), 0.00, "Cliente E", false);
        List<Ticket> tickets = Collections.emptyList();
        Processor.processTicket(invoice, tickets);
        assertTrue(invoice.isPaid());
    }
}

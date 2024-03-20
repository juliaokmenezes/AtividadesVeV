package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {

    private Double amount;
    private Date date;
    private String type;

    public Payment(double amount, String ticket) {
        this.amount = amount;
        this.type = ticket;
    }
}

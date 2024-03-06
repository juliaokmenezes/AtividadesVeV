package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invoice {

    private Date date;
    private double totalAmount;
    private String clientname;
    private boolean payd;

    public Invoice(Date date, double totalAmount, String clientName) {
        this.date = date;
        this.totalAmount = totalAmount;
        this.clientname = clientName;

    }

    public void setPayd() {
        this.payd = true;
    }



}

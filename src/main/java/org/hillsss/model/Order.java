package org.hillsss.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hillsss.model.base.CreatedBase;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order extends CreatedBase {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", length = 36, nullable = false)
    private String id;
    @ManyToOne(targetEntity = Employee.class)
    @JsonIgnore
    @JoinColumn(name = "cashier", nullable = false)
    private Employee cashier;

    @Column(name = "total", nullable = false)
    private Double total;
    @Column(name = "sub_total", nullable = false)
    private Double subTotal;
    @Column(name = "tax", nullable = false)
    private Double tax;

    @ManyToOne(targetEntity = PaymentType.class)
    @JsonIgnore
    @JoinColumn(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    public Order() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getCashier() {
        return cashier;
    }

    public void setCashier(Employee cashier) {
        this.cashier = cashier;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

}

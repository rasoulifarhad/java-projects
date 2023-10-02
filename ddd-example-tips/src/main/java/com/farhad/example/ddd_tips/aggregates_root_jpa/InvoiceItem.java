package com.farhad.example.ddd_tips.aggregates_root_jpa;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_items")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvoiceItem extends AbstractEntity<InvoiceItemId>{
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

@Column(name = "description", nullable = false)
    private String description;

    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;  
    
    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "vat", nullable = false)
    private VAT vat;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @Column(name = "subtotal_excl_vat", nullable = false)
    private int subtotalExcludingVat;

    @Column(name = "subtotal_vat", nullable = false)
    private int subtotalVat;

    @Column(name = "subtotal_incl_vat", nullable = false)
    private int subtotalIncludingVat;   
    
    InvoiceItem(@NonNull Invoice invoice, @NonNull String description, @NonNull Money price, @NonNull VAT vat, int quantity) {
        super(DomainObjectId.randomId(InvoiceItemId.class));
        setInvoice(invoice);
        setDescription(description);
        setPrice(price);
        setVat(vat);
        setQuantity(quantity);
        calculateSubTotals();
    }

    @NonNull
    public Invoice invoice() {
        return invoice;
    }

    private void setInvoice(@NonNull Invoice invoice) {
        this.invoice = Objects.requireNonNull(invoice, "invoice must not be null");
    }

    @NonNull
    @JsonProperty("description")
    public String description() {
        return description;
    }

    private void setDescription(@NonNull String description) {
        this.description = Objects.requireNonNull(description, "description must not be null");
    }

    @NonNull
    @JsonProperty("price")
    public Money price() {
        return Money.valueOf(currency, price);
    }

    private void setPrice(@NonNull Money price) {
        Objects.requireNonNull(price, "price must not be null");
        this.currency = price.currency();
        this.price = price.fixedPointAmount();
    }

    @NonNull
    @JsonProperty("vat")
    public VAT vat() {
        return vat;
    }

    private void setVat(@NonNull VAT vat) {
        this.vat = Objects.requireNonNull(vat, "vat must not be null");
    }

    @JsonProperty("qty")
    public int quantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NonNull
    @JsonProperty("subtotalExcludingVat")
    public Money subtotalExcludingVat() {
        return new Money(currency, subtotalExcludingVat);
    }

    @NonNull
    @JsonProperty("subtotalIncludingVat")
    public Money subtotalIncludingVat() {
        return new Money(currency, subtotalIncludingVat);
    }

    @NonNull
    @JsonProperty("subtotalVat")
    public Money subtotalVat() {
        return new Money(currency, subtotalVat);
    }

    private void calculateSubTotals() {
        subtotalExcludingVat = price().multiply(quantity).fixedPointAmount();
        subtotalVat = vat.calculateTax(new Money(currency, subtotalExcludingVat)).fixedPointAmount();
        subtotalIncludingVat = subtotalExcludingVat + subtotalVat;
    }    
}

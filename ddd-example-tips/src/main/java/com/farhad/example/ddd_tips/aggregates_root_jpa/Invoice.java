package com.farhad.example.ddd_tips.aggregates_root_jpa;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoices")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Invoice extends AbstractAggregateRoot<InvoiceId>  implements ConcurrencySafeDomainObject{

    @Version
    private Long version;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "order_id", nullable = false)
    private OrderId orderId;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "recipient_name", nullable = false)
    private String recipientName;

    @Embedded
    private Address address;

    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;


    @Column(name = "total_excl_vat", nullable = false)
    private int totalExcludingVat;

    @Column(name = "total_vat", nullable = false)
    private int totalVat;

    @Column(name = "total_incl_vat", nullable = false)
    private int totalIncludingVat;

    @Column(name = "terms", nullable = false)
    private int terms;

    @OneToMany(mappedBy = "invoce", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InvoiceItem> items;

    public Invoice(@NonNull Instant createdOn, @NonNull OrderId orderId, int terms, @NonNull String recipientName,
                   @NonNull Address address, @NonNull Currency currency) {
        super(InvoiceId.randomId(InvoiceId.class));
        items = new HashSet<>();
        setCreatedOn(createdOn);
        setOrderId(orderId);
        setTerms(terms);
        setRecipientName(recipientName);
        setAddress(address);
        setCurrency(currency);
        calculateTotals();
    }

       @NonNull
    @JsonProperty("createdOn")
    public Instant createdOn() {
        return createdOn;
    }

    private void setCreatedOn(@NonNull Instant createdOn) {
        this.createdOn = Objects.requireNonNull(createdOn, "createdOn must not be null");
    }

    @NonNull
    @JsonProperty("orderId")
    public OrderId orderId() {
        return orderId;
    }

    private void setOrderId(@NonNull OrderId orderId) {
        this.orderId = Objects.requireNonNull(orderId, "orderId must not be null");
    }

    @JsonProperty("terms")
    public int terms() {
        return terms;
    }

    private void setTerms(int terms) {
        this.terms = terms;
        dueDate = createdOn().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(terms);
    }

    @NonNull
    @JsonProperty("dueDate")
    public LocalDate dueDate() {
        return dueDate;
    }

    @NonNull
    @JsonProperty("recipientName")
    public String recipientName() {
        return recipientName;
    }

    private void setRecipientName(@NonNull String recipientName) {
        this.recipientName = Objects.requireNonNull(recipientName, "recipientName must not be null");
    }

    @NonNull
    @JsonProperty("address")
    public Address address() {
        return address;
    }

    private void setAddress(@NonNull Address address) {
        this.address = Objects.requireNonNull(address, "address must not be null");
    }

    @NonNull
    @JsonProperty("items")
    public Stream<InvoiceItem> items() {
        return items.stream();
    }

    @NonNull
    public InvoiceItem addItem(@NonNull String description, @NonNull Money price, @NonNull VAT vat, int quantity) {
        if (price.currency() != currency) {
            throw new IllegalArgumentException("Item price must be in same currency as invoice");
        }
        InvoiceItem item = new InvoiceItem(this, description, price, vat, quantity);
        items.add(item);
        calculateTotals();
        return item;
    }

    @NonNull
    @JsonProperty("currency")
    public Currency currency() {
        return currency;
    }

    private void setCurrency(@NonNull Currency currency) {
        this.currency = Objects.requireNonNull(currency, "currency must not be null");
    }

    @NonNull
    @JsonProperty("totalExcludingVat")
    public Money totalExcludingVat() {
        return new Money(currency, totalExcludingVat);
    }

    @NonNull
    @JsonProperty("totalVat")
    public Money getTotalVat() {
        return new Money(currency, totalVat);
    }

    @NonNull
    @JsonProperty("totalIncludingVat")
    public Money totalIncludingVat() {
        return new Money(currency, totalIncludingVat);
    }

    private void calculateTotals() {
        totalExcludingVat = items()
                .map(InvoiceItem::subtotalExcludingVat)
                .reduce(new Money(currency, 0), Money::add)
                .fixedPointAmount();
        totalVat = items()
                .map(InvoiceItem::subtotalVat)
                .reduce(new Money(currency, 0), Money::add)
                .fixedPointAmount();
        totalIncludingVat = totalExcludingVat + totalVat;
    }

    @Override
    public Long version() {
        return version;
    }
}

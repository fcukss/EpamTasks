package com.epam.rd.autotasks.wallet;

import java.util.Objects;

public class Record {
    private final Account account;
    private final String recepient;
    private final Long amount;

    public Record(Account account, String recepient, Long amount) {
        this.account = account;
        this.recepient = recepient;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(account, record.account) &&
                Objects.equals(recepient, record.recepient) &&
                Objects.equals(amount, record.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, recepient, amount);
    }

    @Override
    public String toString() {
        return "Record{" +
                "account=" + account +
                ", recepient='" + recepient + '\'' +
                ", amount=" + amount +
                '}';
    }
}

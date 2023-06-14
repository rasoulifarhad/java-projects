package com.farhad.example.collections.aggregate;

import java.util.function.IntConsumer;

import lombok.Data;

@Data
public class Averager implements IntConsumer {
    private int total = 0;
    private int count = 0;

    public double average() {
        return count > 0 ? ((double)total) / count : 0.0;
    }

    @Override
    public void accept(int value) {
        total += value;
        count++;
    }

    public void combine(Averager other) {
        total += other.getTotal();
        count += other.getCount();
    }
}

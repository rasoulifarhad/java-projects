package com.farhad.example.java_tips;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class NoNeedForIfNotNullChecks {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Db db;

    public static void main(String[] args) throws ParseException {
        new NoNeedForIfNotNullChecks().demo();
    }

    private void demo() throws ParseException {
        createDbDemo();

        List<Costume> searchResult = db.search("long jacket");
        Optional<Costume> selected1 = searchResult.stream().findFirst();
        System.out.println("selection: " + selected1.map(c -> c.getDescription()).orElse("nothing"));

        List<Costume> searchResult2 = db.search(
                "long jacket",
                dateFormat.parse("2019-03-18"),
                dateFormat.parse("2019-03-24"));
        Optional<Costume> selected2 = searchResult2.stream().findFirst();
        System.out.println("selection: " + selected2.map(c -> c.getDescription()).orElse("nothing"));
    }


    private void createDbDemo() throws ParseException {
        DateRange reserved = new DateRange(
            dateFormat.parse("2019-03-20"), 
            dateFormat.parse("2019-03-22"));
        db = new Db(List.of(                
            new Costume("Snow White yellow skirt white blouse", null),
            new Costume("Short skirt costume with long jacket", reserved),
            new Costume("Knight with helmet and sword ", null),
            new Costume("Blue Jeans with long jacket", null)
        ));
    }


    static class Db{
        private final List<Costume> costumes;

        public Db(List<Costume> costumes) {
            this.costumes = new ArrayList<>(costumes);
        }

        List<Costume> search(String term, Date from, Date to) {
            DateRange range = new DateRange(from, to);
            var result = new ArrayList<Costume>();
            for (var costume : costumes) {
                if(range.notOverlap(costume.getReserved())) {
                    result.add(costume);
                }
            }
            return result;
        }

        List<Costume> search(String term) {
            var result = new ArrayList<Costume>();
            for (var costume : costumes) {
                if(costume.getDescription().toLowerCase().contains(term)) {
                    result.add(costume);
                }
            }
            return result;
        }

    }

    @RequiredArgsConstructor
    @Getter
    static class Costume {
        private final String description;
        private final DateRange reserved;
    }

    @RequiredArgsConstructor
    static class DateRange {
        final Date from;
        final Date to;

        boolean notOverlap(DateRange dateRange) {
            return !overlap(dateRange);
        }

        boolean overlap(DateRange dateRange) {
            return false;
        }

        boolean contains(Date date) {
            return false;
        }
    }


}

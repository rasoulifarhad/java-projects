package com.farhad.example.java_tips;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class AvoidNullPointerException {

    private Db db;

    public static void main(String[] args) {
        new AvoidNullPointerException().demo();
    }

    private void demo() {
        createDbDemo();
        Optional<Costume> selected1 = select("long jacket");
        System.out.println("selection: " + selected1.map(c -> c.getDescription()).orElse("nothing"));

        Optional<Costume> selected2 = select("long Costome");
        System.out.println("selection: " + selected2.map(c -> c.getDescription()).orElse("nothing"));
    }

    private Optional<Costume> select(String substribg) {
        List<Costume> serchResult = db.search(substribg);
        return serchResult.stream().findFirst();
    }

    private void createDbDemo() {
        db = new Db(List.of(                
            new Costume("Snow White yellow skirt white blouse"),
            new Costume("Short skirt costume with long jacket"),
            new Costume("Knight with helmet and sword "),
            new Costume("Blue Jeans with long jacket")
        ));
    }
    static class Db{
        private final List<Costume> costumes;

        public Db(List<Costume> costumes) {
            this.costumes = new ArrayList<>(costumes);
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
    }
}

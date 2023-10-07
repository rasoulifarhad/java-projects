package com.farhad.example.functional_interface.separating_concerns_lambda.iterations.Iteration1;

import java.awt.Color;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {
    
    private Function<Color, Color> filter;

    public Camera() {
        setFilters();
    }

    public Color capture(final Color inputColor) {
        final Color processedColor = filter.apply(inputColor);
        // ....
        return processedColor;
    }

    public void setFilters(final Function<Color, Color>... filters) {
        this.filter = 
            Stream.of(filters)
                .reduce((f, next) -> f.compose(next))
                .orElseGet(Function::identity);
    }

    public static void main(String[] args) {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured = filterInfo -> 
            System.out.println(String.format("with %s: %s", filterInfo,
                camera.capture(new Color(200, 100, 200))));

        printCaptured.accept("no filter");

        camera.setFilters(Color::brighter);
        printCaptured.accept("brighter filter");

        camera.setFilters(Color::darker);
        printCaptured.accept("darker filter");

        camera.setFilters(Color::brighter, Color::darker);
        printCaptured.accept("brighter & darker filter");

        camera.setFilters(Color::darker, Color::brighter);
        printCaptured.accept("darker & brighter filter");

    }
}

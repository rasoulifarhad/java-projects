package com.farhad.example.decorator;

public class ImageSales {

    public static void main(String[] args) {
        
        final PhotoImage image = new PhotoImage("Sunset at Tres Ríos", "2020/ifd12345.jpg");

        Print im1 = new Print(11, 8.5, image);
        addToPrintOrder(im1);

        Print im2 = 
            new Print(19, 11, 
                new Frame(
                    new Mat("Lime Green",
                        new PhotoImage("Goodbye at the S", "1968/ifd.00042.jpg"))));
        addToPrintOrder(im2);
    }

    private static void addToPrintOrder(Print image) {
        System.out.println(image.toString());
    }
}


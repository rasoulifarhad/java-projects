package com.farhad.example.generic.pecs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Summarize our learning:
 * 
 * - Use the <? extends T> wildcard if you need to retrieve object of type T from a collection.
 * - Use the <? super T> wildcard if you need to put objects of type T in a collection.
 * - If you need to satisfy both things, well, don’t use any wildcard. As simple as it is.
 * - n short, remember the term PECS. Producer extends Consumer super.
 * 
 * Object max(List src) {
 *   // ...
 * }
 * 
 * public <T extends Comparable<? super T>> T max( List<? extends T> list) {
 *  // ....
 * }
 */
@Slf4j
public class GenericFruitExample {

    static class WildcardExample {

        public static void main(String[] args) {
            
            Collection<?> coll = new ArrayList<String>();
            List<? extends Number> nums = new ArrayList<Long>();

            // compilation error
            // List<? extends Number> nums2 = new ArrayList<String>();

            // Unbounded wildcard parameterized type
            ArrayList<?> list1 = new ArrayList<String>();
            ArrayList<?> list2 = new ArrayList<Integer>();

            // Upper bounded wildcards
            // if you want the generic expression to accept all subclasses of a particular type, you will use upper-bound 
            // wildcard using “extends” keyword.

            //Cannot create a generic array of List<String>
            // List<String>[] stringLists = new List<String>[1];
        } 

        static class UpperBoundWildcard<T> {

            public static void main(String[] args) {
                List<Integer> ints = Arrays.asList(1, 2, 3, 4);
                log.info("{}", sum(ints));

                List<Double> doubles = Arrays.asList(1.5d, 2d, 3d);
                log.info("{}", sum(doubles));

                List<String> strings = Arrays.asList("1", "2");
                // compilation error    
                // log.info("{}", sum(strings));
            }
            static Number sum(List<? extends Number> numbers) {

                double s = 0.0;
                for (Number number : numbers) {
                    s += number.doubleValue();
                }
                return s;
            }
        }

        /**
         * If you want a generic expression to accept all types which are “super” type of a particular type OR parent class of a 
         * particular class then you will use a lower bound wildcard for this purpose, using ‘super’ keyword.
         */
        static class LowerBoundWildcard<T> {

            public static void addGrandChildren(List<? super GrandChildClass> grandChildrens) {
                grandChildrens.add(new GrandChildClass()    );
                log.info("{}", grandChildrens);
            }
            public static void main(String[] args) {
                //List of grand children
                List<GrandChildClass> grandChildren = new ArrayList<GrandChildClass>();
                grandChildren.add( new GrandChildClass() );
                addGrandChildren(grandChildren);

                List<ChildClass> childs = new ArrayList<ChildClass>();
                childs.add(new GrandChildClass());
                addGrandChildren(childs);

                List<SuperClass> supers = new ArrayList<SuperClass>();
                supers.add(new GrandChildClass());
                addGrandChildren(supers);
            }

            static class SuperClass {
                @Override
                public String toString(){
                    return "I am a SuperClass !!";
                }
        
            }

            static class ChildClass extends SuperClass{
                @Override
                public String toString(){
                    return "I am a ChildClass !!";
                }
        
            }

            static class GrandChildClass extends ChildClass{
                
                @Override
                public String toString(){
                    return "I am a GrandChildClass !!";
                }
                    }
        }
    }
    static class ProducerExtends {
        public static void main(String[] args) {
            //List of apples
            List<Apple> apples = new ArrayList<>();
            apples.add(new Apple());
    
            //its ok ,because apple is subtype of fruit
            List<? extends Fruit> basket = apples;
    
            // we know that in basket is only fruits
            for (Fruit fruit : basket) {
                log.info("{}", fruit);
            }
    
            // compilation error
            // basket.add( new Apple() );
            // basket.add(new Fruit());
    
        }
    }

    static class ConsumerSuper {
        public static void main(String[] args) {
            List<Apple> apples = new ArrayList<>();
            apples.add(new Apple());

            //We can assign a list of apples to a basket of apples
            List<? super Apple> basket = apples;

            basket.add(new Apple());
            basket.add(new AsianApple());
            // basket.add(new Fruit()); // compilation error

            for (Object object : basket) {
                Apple apple = (Apple) object;
                log.info("{}", apple);
            }
            for (Object object : basket) {
                log.info("{}", object);
            }
        }
    }
    static class Fruit {

        @Override
        public String toString(){
            return "I am a Fruit !!";
        }
    }

    static class Apple extends Fruit {

        @Override
        public String toString(){
            return "I am an Apple !!";
        }
    }

    static class AsianApple extends Apple {

        @Override
        public String toString(){
            return "I am an AsianApple !!";
        }
    }

}

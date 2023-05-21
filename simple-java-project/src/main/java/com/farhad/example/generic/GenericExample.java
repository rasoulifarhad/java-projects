package com.farhad.example.generic;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Bounded wildcards provide two other kinds of relationship:
 * 
 * - Covariance
 *   Upper bound wildcard parameterized type (<? extends Number>) 
 * 
 * - Contravariance
 *   Lower bound wildcard parameterized type (<? super Integer>)
 * 
 * A returned object of "unknown" type is known to be compatible with the upper bound.
 * 
 * When dealing with collections, a common rule for selecting between upper or lower bounded wildcards is PECS. credit 
 * 
 * PECS (Producer `extends`  and Consumer `super` )
 * 
 * mnemonic → Ge `t` (ex `t` end) and P `u` t (S `u` per) principle.
 * 
 * This principle states that:
 * 
 *  - Use an  extends  wildcard when you only get values out of a structure.
 * 
 *  - Use a  super  wildcard when you only put values into a structure.
 * 
 *  - And don’t use a wildcard when you both get and put.
 */
@Slf4j
public class GenericExample {
    
    public static void main(String[] args) {
        
    }

    public void assignment() {
        // List<Number> list1 = new ArrayList<Double>();           // Compilation error
        List<Integer> list2 = new ArrayList<Integer>();            // Safe
        List<? extends Number>  list3 = new ArrayList<Double>();   // Safe
        List<? super Integer>  list4 = new ArrayList<Number>();    // Safe
        // List<? super Number>  list5 = new ArrayList<Integer>(); // Compilation error
    }

    /**
     * what is accessible from the variables after assignment
     */
    public void assignmentElements() {

        // ? extends

        // list1 has an unknown type of an upper bound Number. 
        // A returned object of "unknown" type is known to be compatible with the upper bound.
        List<? extends Number>  list1 = new ArrayList<Double>();  
        Number doubleNum = list1.get(0);                    //Safe
        log.info("{}", doubleNum);

        List<? extends Number>  list2 = new ArrayList<Double>();  
        // list2.add(1d);        // Compilation error
        // list2.add(1);         // Compilation error  
        list2.add(null);       // Ok ,but not useful

        // ? super  

        List<? super Integer> list3 = new ArrayList<Integer>();

        // Number num = list3.get(0);            // Compilation error     
        // Integer intNum = list3.get(0);        // Compilation error        
        Object obj = list3.get(0);         // Ok, but not useful

        List<? super Integer> list4 = new ArrayList<Integer>();
        list4.add(10);
        // <? super Integer> 
        // means we can only assign List<Integer> or List<Number> or any supertype of Integer for assignment.
        // 
        // But for putting/consuming stuff into the container, we can use any subtype of the lower bound.
        // 
        //   - list.add(45) is fine
        //   - list.add(new A()); is also fine, suppose A extends Integer


        List<? super Integer> l1 = new ArrayList<Number>();
        List<? super Integer> l2 = new ArrayList<Comparable<Integer>>();

        l1.add(Integer.valueOf(1));
        l2.add(Integer.valueOf(1));
    }

    static class MyClass {}
    static class Driver {}
    static class Vehicle {}
    static class ClassObjects{

        public static <T> T getInstance( Class<T> claaz ) throws InstantiationException, IllegalAccessException {
            return claaz.newInstance();
        }

        public static <T> T read(Class<T> claaz, String sql) throws InstantiationException, IllegalAccessException {
            // executre sql
            T o = claaz.newInstance();
            // set properties with reflection
            return o ;
        }

        public static void main(String[] args) throws InstantiationException, IllegalAccessException {
            // Return type changes depending on what class object we pass in as parameter to the method. 
            String str = getInstance(String.class);

            // Return type changes depending on what class object we pass in as parameter to the method. 
            MyClass myClass = getInstance(MyClass.class);

            Driver driver = read(Driver.class, "select * from drivers where id=1");
            Vehicle vehicle = read(Vehicle.class, "select * from vehicles where id=1");
        }
    }
}

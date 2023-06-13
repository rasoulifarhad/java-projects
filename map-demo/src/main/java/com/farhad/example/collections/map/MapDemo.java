package com.farhad.example.collections.map;

import static com.farhad.example.models.employee.Employee.names;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.farhad.example.models.employee.Department;
import com.farhad.example.models.employee.Employee;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

@Slf4j
public class MapDemo {
    

    public void demonstrateGroupEmployeesByDepartment() {
        List<Employee> employees = new ArrayList<Employee>(Employee.factory.employees());
        
        Map<Department, List<Employee>> byDepartment = employees.stream()
                                                                .collect(Collectors.groupingBy(Employee::getDepartment));
        log.info("");
        log.info("Group Employees By Department:");
        byDepartment.keySet()
                        .forEach(dept -> log.info("{}: {}", dept.getName(), names(byDepartment.get(dept)) ) );
    }

    public void demonstrateComputeSumOfAllSalariesByDepartment() {
        List<Employee> employees = new ArrayList<Employee>(Employee.factory.employees());
        Map<Department, Integer> sumOfsalariesbyDept = 
                            employees
                                .stream()
                                .collect(
                                    Collectors.groupingBy(
                                            Employee::getDepartment, 
                                            Collectors.summingInt(Employee::getSalary)));
        log.info("");
        log.info("Sum Of All Salaries By Department:");
        sumOfsalariesbyDept.keySet()
                        .forEach(dept -> log.info("{}: {}", dept.getName(), sumOfsalariesbyDept.get(dept))  );
    }

    public void demonstrateGroupEmployeesByDepartmentAndDesignations() {
        List<Employee> employees = new ArrayList<Employee>(Employee.factory.employees());
        
        Map<Department, Map<String, List<Employee>>> byDepartmentAndDesignation = employees.stream()
                                                                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getDesignation)));
        log.info("");
        log.info("Group Employees By Department And Designation:");
        byDepartmentAndDesignation.keySet()
                .forEach(dept -> 
                        byDepartmentAndDesignation.get(dept)
                                    .keySet()
                                    .forEach(designation -> 
                                            log.info("{} - {}: {}", dept.getName(), 
                                                                    designation, 
                                                                    names(byDepartmentAndDesignation.get(dept).get(designation)))));
    }

    public void demonstrateFrequencyTable() {
        // Frequency Table
        Map<String, Integer> frequencyTable = frequencyTable(getWords());
        log.info("");
        log.info("Words Frequency Table: {}", frequencyTable);
        frequencyTable = frequencyTable(getProgrammingLanguages());
        log.info("Programming Languages Frequency Table: {}", frequencyTable);

        // frequency table in alphabetical order
        frequencyTable = sortedFrequencyTable(getWords());
        log.info("Sorted Words Frequency Table: {}", frequencyTable);
        frequencyTable = sortedFrequencyTable(getProgrammingLanguages());
        log.info("Sorted Programming Languages Frequency Table: {}", frequencyTable);

        // frequency table in the order the words first appear 
        frequencyTable = orderedFrequencyTable(getWords());
        log.info("Ordered Words Frequency Table: {}", frequencyTable);
        frequencyTable = orderedFrequencyTable(getProgrammingLanguages());
        log.info("Ordered Programming Languages Frequency Table: {}", frequencyTable);
    }

    private static List<String> getWords() {
        return Arrays.asList("if it is to be it is up to me to delegate".split(" "));
    }

    private static List<String> getProgrammingLanguages() {
        Faker faker = new Faker(new Random());
        return faker.collection(() -> faker.expression("#{options.option 'Java','Go','Rust','.Net','JavaScript'}") )
                                                        .len(10 )
                                                        .generate();
    }

    private  static Map<String, Integer> frequencyTable(List<String> tokens){
        Map<String, Integer> ft = new HashMap<>();
        tokens.forEach(
            l -> 
                ft.put(l, ( ft.get(l) != null ) ? ft.get(l) + 1 : 1) );
        return ft;
    }

    private  static Map<String, Integer> sortedFrequencyTable(List<String> tokens){
        Map<String, Integer> ft = new TreeMap<>();
        tokens.forEach(
            l -> 
                ft.put(l, ( ft.get(l) != null ) ? ft.get(l) + 1 : 1) );
        return ft;
    }

    private  static Map<String, Integer> orderedFrequencyTable(List<String> tokens){
        Map<String, Integer> ft = new LinkedHashMap<>();
        tokens.forEach(
            l -> 
                ft.put(l, ( ft.get(l) != null ) ? ft.get(l) + 1 : 1) );
        return ft;
    }

    public static <K, V> Map<K, V> newAttributeMap(Map<K, V> defaults, Map<K, V> overrides) {
        Map<K, V> map = new HashMap<>(defaults);
        map.putAll(overrides);
        return map;
    }

    // whether one Map is a submap of another 
    public static <K, V> boolean isSubMap(Map<K, V> map, Map<K, V> subMap) {
        return map.entrySet().containsAll(subMap.entrySet());
    }

    // whether two Map objects contain mappings for all of the same keys.
    public static <K, V> boolean haveSameKeys(Map<K, V> map, Map<K, V> otherMap) {
        return map.keySet().equals(otherMap.keySet());
    }

    // determines whether the attribute map conforms to these constraints and prints a detailed error message if it doesn't.
    public static <K, V> boolean validate(Map<K, V> attrMap, Set<K> requiredAttrs, Set<K> permittedAttrs) {
        Set<K> attrs = attrMap.keySet();

        if(!attrs.containsAll(requiredAttrs)) {
            Set<K> missingAttrs = new HashSet<>(requiredAttrs);
            missingAttrs.removeAll(attrs);
            log.info("Missing Required Attributes: {}", missingAttrs);
            return false;
        }

        if(!permittedAttrs.containsAll(attrs)) {
            Set<K> illegalAttrs = new HashSet<>(attrs);
            illegalAttrs.removeAll(permittedAttrs);
            log.info("Illegal Attributes: {}", illegalAttrs);
            return false;
        }
        return true;
    }

    // all the keys common to two Map objects.
    public static <K, V> Set<K> commonKeys(Map<K, V> map1, Map<K, V> map2) {
        Set<K> commonKeys = new HashSet<>(map1.keySet());
        commonKeys.retainAll(map2.keySet());
        return commonKeys;
    }

    // remove all of the key-value pairs that one Map has in common with another.
    public static <K, V> void removeCommonEntries(Map<K, V> map1, Map<K, V> map2) {
        map1.entrySet().removeAll(map2.entrySet());
    }

    // remove from one Map all of the keys that have mappings in another.
    public static <K, V> void removeCommonKeys(Map<K, V> map1, Map<K, V> map2) {
        map1.keySet().removeAll(map2.keySet());
    }

    // Suppose we have a Map, managers, that maps each employee in a company to the employee's manager. 
    // we want to know who all the "individual contributors" (or nonmanagers) are.
    // K is Employee 
    public static <K> Set<K> getIndividualContributors(Map<K, K> managers) {
        Set<K> individualContributors = new HashSet<>(managers.keySet());
        individualContributors.removeAll(managers.values());
        return individualContributors;
    }

    // Suppose we have a Map, managers, that maps each employee in a company to the employee's manager. 
    //  all the employees who report directly to some manager Like simon.
    public static <K> Set<K> getKeysWithValue(Map<K, K> map, K value) {
        // First, it makes a temporary copy of the Map, and it removes from the temporary copy all entries whose (manager) value is a key in the original Map. Remember 
        // that the original Map has an entry for each employee. Thus, the remaining entries in the temporary Map comprise all the entries from the original Map whose 
        // (manager) values are no longer employees. The keys in the temporary copy, then, represent precisely the employees that we're looking for.
        map.values().removeAll(Collections.singleton(value));
        return new HashSet<>(map.keySet());
    }

    // Once you've done this, you may have a bunch of employees whose managers no longer work for the company (if any of Simon's direct-reports were 
    // themselves managers). The following code will tell you which employees have managers who no longer works for the company.
    public static <K> Set<K> slackers(Map<K, K> map) {
        // map : like managers
        Map<K, K> m = new HashMap<>(map);
        m.values().removeAll(map.keySet());
        // return m.keySet();
        return new HashSet<>(m.keySet());
    }

    public static String alphabetize(String word) {
        char [] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    // reads a word list containing one word per line (all lowercase) and prints out all the anagram groups that meet a size criterion.
    // anagram: a word, phrase, or name formed by rearranging the letters of another, such as spar, formed from rasp.
    // An anagram group is a bunch of words, all of which contain exactly the same letters but in a different order. 
    // ُwo arguments on method: (1) the name of the dictionary file and (2) the minimum size of anagram group to print out.
    //
    // There is a standard trick for finding anagram groups: For each word in the dictionary, alphabetize the letters in the word (that is, 
    // reorder the word's letters into alphabetical order) and put an entry into a multimap, mapping the alphabetized word to the original 
    // word. For example, the word bad causes an entry mapping abd into bad to be put into the multimap. 
    public static Map<String,List<String>> anagrams(File file, int minGroupSize) {
        Map<String,List<String>> anagrams = new HashMap<>();
        try {
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                String word = s.next();
                String alphabetizedWord = alphabetize(word);
                // List<String> l = (anagrams.get(alphabetizedWord) == null ? new ArrayList<>() : anagrams.get(alphabetizedWord));
                // l.add(word);    
                // anagrams.put(alphabetizedWord, l);
                List<String> l = anagrams.get(alphabetizedWord);
                if( l == null) {
                    anagrams.put(alphabetizedWord, l = new ArrayList<>());
                }
                l.add(word);
            }
            s.close();
        } catch (Exception e) {
            log.error("Error!", e);
        }
        return anagrams;
    }

    public void demonstrateAnagrams() {
        // URL url = this.getClass().getClassLoader().getResource("com/farhad/example/collections/map/dictionary.txt");
        URL url = this.getClass().getResource("dictionary.txt");
        int minGroupSize = 8 ;
        Map<String,List<String>> anagramsMap = anagrams( new File(url.getFile()), minGroupSize);
        log.info("");
        anagramsMap
            .values()
            .stream()
            .filter(l -> l.size() >= minGroupSize)
            .forEach(l -> log.info("Size: {} List: {}", l.size(), l));

    } 

    public static void main(String[] args) {
        MapDemo demo = new MapDemo();
        demo.demonstrateGroupEmployeesByDepartment();
        demo.demonstrateComputeSumOfAllSalariesByDepartment();
        demo.demonstrateGroupEmployeesByDepartmentAndDesignations();
        demo.demonstrateFrequencyTable();
        demo.demonstrateAnagrams();
    }
}

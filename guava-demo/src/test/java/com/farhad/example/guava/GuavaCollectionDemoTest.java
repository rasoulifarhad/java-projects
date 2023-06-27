package com.farhad.example.guava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.farhad.example.guava.GuavaCollectionDemo.CastFunction;
import com.farhad.example.guava.GuavaCollectionDemo.ChildType;
import com.farhad.example.guava.GuavaCollectionDemo.ParentType;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaCollectionDemoTest {
    
    @Test 
    public void demonstrateDowncastListOfParentToListOfChild() {
        List<Number> numberList = Lists.newArrayList(Arrays.asList(1, 2, 3));

        List<Integer> integerList =  (List<Integer>) (List<? extends Number>) numberList;
        log.info("{}", integerList);

        List<ParentType> parentList = Lists.newArrayList();
        List<ChildType> childList = (List<ChildType>) (List<? extends ParentType >) parentList;
    }

    @Test
    public void demonstrateDowncastListOfParentToListOfChildWithGuva() {
        List<ParentType> parentList = Lists.newArrayList();
        List<ChildType> childList = Lists.transform(
                                            parentList, 
                                            new CastFunction<ParentType, ChildType>());

        List<Number> numberList = Lists.newArrayList(Arrays.asList(1, 2, 3));
        List<Integer> integerList = Lists.transform(
                                    numberList, 
                                    new CastFunction<Number, Integer>());
        log.info("{}", integerList);
    }

    @Test
    public void demonstrateAddindIterableToCollection() {
        Iterable<String> it = Lists.newArrayList("One", "1");
        Collection<String> col = Lists.newArrayList("Two", "2");
        Iterables.addAll(col,it);
        log.info("col: {}", col);
        log.info("it: {}", it);
    }

    @Test
    public void demonstrateCheckCollectionElementsWithMatchingRule() {
        Iterable<String> strsCollection = Lists.newArrayList("a", "bc", "def", "ghij");
        boolean contains = Iterables.any(strsCollection, new Predicate<String>() {

            @Override
            public boolean apply(String input) {
                return input.length() == 1;
            }
            
        });
        assertTrue(contains);

        contains = Iterables.find(strsCollection, new Predicate<String>() {

            @Override
            public boolean apply(String input) {
                return input.length() == 1;
            }
            
        }) != null;
        assertTrue(contains);

        Set<String> setCollection = Sets.newHashSet("a", "bc", "def", "ghij");
        contains = !Sets.filter(setCollection, new Predicate<String>() {

            @Override
            public boolean apply(String input) {
                return input.length() == 1;
            }
        }).isEmpty() ;
        assertTrue(contains);
    }

    @Test
    public void demonstrateIterablesFindWithException() {
        Set<String> setCollection = Sets.newHashSet("bc", "def", "ghij");
        Predicate<String> inputOfLengthOne = new Predicate<String>() {

            @Override
            public boolean apply(String input) {
                return input.length() == 1;
            }
        };
        assertThrows(NoSuchElementException.class, () -> Iterables.find(setCollection, inputOfLengthOne));

        String find = Iterables.find(setCollection, inputOfLengthOne, null);
        assertThat(find).isNull();

        find = Iterables.tryFind(setCollection, inputOfLengthOne).orNull();
        assertThat(find).isNull();
    }



    @Test
    public void demonstrateRemoveAllNullsFromCollection() {
        List<String> list = Lists.newArrayList("a", "bc", null, "def", null, "ghij");
        Iterable<String> listWithoutNulls = Iterables.filter(list, Predicates.notNull());
        log.info("List: {}",list);
        log.info("List without nulls: {}",listWithoutNulls);
    }

    @Test
    public void demonstrateImmutableListSetMap() {
        ImmutableList<String> immutableList = ImmutableList.of("a", "bc", "def", "ghij");
        ImmutableSet<String>  immutableSet = ImmutableSet.of("a", "bc", "def", "ghij");
        ImmutableMap<String, String>  immutableMap = ImmutableMap.of("k1", "v1", "k2", "v2", "k3", "v3");

        log.info("ImmutableList: {}", immutableList);
        log.info("ImmutableSet: {}", immutableSet);
        log.info("ImmutableMap: {}", immutableMap);

        assertThrows(UnsupportedOperationException.class, () ->  immutableList.add("test"));
        assertThrows(UnsupportedOperationException.class, () -> immutableSet.add("test"));
        assertThrows(UnsupportedOperationException.class, () -> immutableMap.put("test", "test"));
    }

    @Test
    public void demonstrateImmutableListSetMapFromMutable() {
        List<String> mmuttableList = Lists.newArrayList("a", "bc", "def", "ghij");
        ImmutableList<String> immutableList = ImmutableList.copyOf(mmuttableList);
        log.info("{}", immutableList);
        assertThat(immutableList).hasSize(4);
        assertThrows(UnsupportedOperationException.class, () -> immutableList.add("test"));

        Set<String> muttableSet = Sets.newHashSet("a", "bc", "def", "ghij");
        ImmutableSet<String> immutableSet = ImmutableSet.copyOf(muttableSet);
        log.info("{}", immutableSet);
        assertThat(immutableSet).hasSize(4);
        assertThrows(UnsupportedOperationException.class, () -> immutableSet.add("test"));

        Map<String, String> muttableMap = Maps.newHashMap();
        muttableMap.put("k1", "v1");
        ImmutableMap<String, String> immutableMap = ImmutableMap.copyOf(muttableMap);
        log.info("{}", immutableMap);
        assertThat(immutableMap).hasSize(1);
        assertThrows(UnsupportedOperationException.class, () -> immutableMap.put("test", "test"));
    }

    @Test
    public void demonstrateCollectionsStaticFactories() {
        List<Map<String, Object>> maps = new ArrayList<>();
        List<Map<String, Object>> guavaMaps = Lists.newArrayList(); // dont use, instead use ArrayList 
        List<String> names = Lists.newArrayListWithExpectedSize(50); // dont use
        List<String> names2 = Lists.newArrayListWithCapacity(50); // dont use , instead use new ArrayList<>(int)

        List<String> varHeroes = Lists.newArrayList("Kick-Ass", "Iron Man"); // dont use

        Iterable<String> heroesIterable = Lists.newArrayList("1", "3");
        List<String> heroes  = Lists.newArrayList(heroesIterable); // dont use

        Set<String> heroesSet = Sets.newHashSet(); // dont use , instead use new HashSet<>()

        Map<String, String> heroesById = Maps.newHashMap(); // dont use , instead use new HashMap<>()
    }
}

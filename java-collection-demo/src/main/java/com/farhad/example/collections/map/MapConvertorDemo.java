package com.farhad.example.collections.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapConvertorDemo {
    
    public List<Integer> convertIntegerMapKeysToList(Map<Integer,?> map) {
        Objects.requireNonNull(map);
        return new ArrayList<>(map.keySet());
    }

    public List<String> convertStringMapValuesToList(Map<?, String> map) {
        Objects.requireNonNull(map);
        return new ArrayList<>(map.values());
    }

    public List<Integer> convertIntegerMapKeysToListWithStream(Map<Integer,?> map)  {
        Objects.requireNonNull(map);
        return map.keySet()
                .stream()
                .collect(Collectors.toList());
    }

    public List<String> convertStringMapValuesToListWithStream(Map<?,String> map)  {
        Objects.requireNonNull(map);
        return map.values()
                .stream()
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public <K,V> List<K> convertGenericMapKeysToListWithStream(Map<K,V> map)  {
        Objects.requireNonNull(map);
        return map.keySet()
                .stream()
                .collect(Collectors.toList());
    }

    public <K,V> List<K> convertGenericMapKeysToListWithStreamAndLambda(Map<K,V> map)  {
        Objects.requireNonNull(map);
        List<K> list = new ArrayList<>();
        map.entrySet()
                .stream()
                .forEach(entry -> list.add(entry.getKey()));
                
        return list ;
    }

    public <K,V> List<V> convertGenericMapValuesToListWithStream(Map<K,V> map)  {
        Objects.requireNonNull(map);
        return map.values()
                .stream()
                .collect(Collectors.toList());
    }

    public <K,V> List<V> convertGenericMapValuesToListWithStreamAndLambda(Map<K,V> map)  {
        Objects.requireNonNull(map);
        List<V> list = new ArrayList<>();
        map.values()
                .stream()
                .forEach(list::add);
                
        return list ;
    }

}

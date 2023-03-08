package com.farhad.example.predicates;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class OldStyle {
    

    Map<String,Object> dataCache = new ConcurrentHashMap<>();

    public void deleteFromCache( Set<String>  deleteKeys ) {

        Iterator<Entry<String, Object>> iterator =  dataCache.entrySet().iterator();

        while ( iterator.hasNext() ) {
            Entry<String, Object> entry = iterator.next() ;
            if ( deleteKeys.contains(entry.getKey()) ) {
                iterator.remove();

            }
        }
    }

    public void deleteFromCache2( Set<String>  deleteKeys ) {

        for (String deleteKey : deleteKeys) {
            dataCache.remove(deleteKey);
        }
    }

    public void deleteFromCache3( Set<String>  deleteKeys ) {

        dataCache.entrySet().removeIf( new Predicate<Entry<String, Object>>() {

            @Override
            public boolean test(Entry<String, Object> entry) {

                return deleteKeys.contains(entry.getKey());
            }
            
        } );
    }

    public void deleteFromCache4( Set<String>  deleteKeys ) {

        dataCache.entrySet().removeIf( entry -> deleteKeys.contains(entry.getKey()) );
    }

}

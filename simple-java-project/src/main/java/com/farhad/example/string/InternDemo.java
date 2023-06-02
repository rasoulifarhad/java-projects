package com.farhad.example.string;

import static com.farhad.example.string.InternDemo.DeduplicatingInaccessibleStringUsingReflectionForBarClass.interStringInBar;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;;

@Slf4j
public class InternDemo {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        String str1 = new String(chars);
        String str2 = new String(chars);
        log.info("`str1 equals str2`: {}", str1.equals(str2));
        log.info("`str1 == str2`: {}", str1 == str2);
        log.info("`str1.intern() == str2.intern()`: {}", str1.intern() == str2.intern());

        String str3 = "bar";
        Foo foo = new Foo(str3);
        log.info("`foo.getBar() equals str3`: {}", foo.getBar().equals(str3));
        log.info("`foo.getBar() == str3`: {}", foo.getBar() == str3);

        String str4 = "bar";
        Bar bar = new Bar(str4);
        bar = interStringInBar(bar);
        log.info("`bar.getBar() equals str4`: {}", bar.getBar().equals(str4));
        log.info("`bar.getBar() == str4`: {}", bar.getBar() == str4);

    }

    @Getter
    static class Foo {

        private String bar ;
        List<String> bars;
        public Foo(String bar) {
            this.bar = (bar == null)? null : bar.intern();
        }

        public Foo(List<String> bars) {
            for (int i=0; i<bars.size(); i++) {
                String s = bars.get(i);
                bars.set(i, s != null ? s.intern() : s);
            }
            this.bars = bars;
        }
    }

    @Getter
    static class Bar {
        private String bar ;

        public Bar(String bar) {
            this.bar = bar;
        }
    }
    
    public static class DeduplicatingInaccessibleStringUsingReflectionForBarClass {

        private static Class<Bar> barClass = Bar.class;
        private static Field barField;

        static {
            try {
                barField = barClass.getDeclaredField("bar");
                barField.setAccessible(true);
            } catch (NoSuchFieldException | SecurityException e) {
                e.printStackTrace();
            }
        }

        public static Bar interStringInBar(Bar bar) throws IllegalArgumentException, IllegalAccessException {
            Objects.requireNonNull(bar);
            String barString = (String) barField.get(bar);
            Objects.requireNonNull(barString);
            barField.set(bar, barString.intern());
            return bar;
        }

    }
}

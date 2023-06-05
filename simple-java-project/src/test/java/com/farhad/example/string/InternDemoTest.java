package com.farhad.example.string;

import static com.farhad.example.string.InternDemo.DeduplicatingInaccessibleStringUsingReflectionForBarClass.interStringInBar;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.farhad.example.string.InternDemo.Bar;
import com.farhad.example.string.InternDemo.Foo;

import lombok.extern.slf4j.Slf4j;

/**
 * When the intern() method is invoked on a String object it looks the string contained by this String object in the pool, if the string 
 * is found there then the string from the pool is returned. Otherwise, this String object is added to the pool and a reference to this 
 * String object is returned.
 */
@Slf4j
public class InternDemoTest {
  
    @Test
    public void internTest() {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        String str1 = new String(chars);
        String str2 = new String(chars);

        log.info("`str1 equals str2`: {}", str1.equals(str2));
        log.info("`str1 == str2`: {}", str1 == str2);
        log.info("`str1.intern() == str2.intern()`: {}", str1.intern() == str2.intern());

        assertThat(str1).isEqualTo(str2);
        assertThat(str1 == str2).isFalse();
        assertThat(str1.intern()).isEqualTo(str2.intern());
        assertThat(str1.intern() == str2.intern()).isTrue();
    }

    @Test
    public void fooTest() {
        String str = "bar";
        Foo foo = new Foo(str);

        log.info("`foo.getBar() equals str3`: {}", foo.getBar().equals(str));
        log.info("`foo.getBar() == str3`: {}", foo.getBar() == str);

        assertThat(foo.getBar()).isEqualTo(str);
        assertThat(foo.getBar() == str).isTrue();
   }

    @Test
    public void barTest() throws Exception {

        String str = "bar";
        Bar bar = new Bar(str);
        bar = interStringInBar(bar);

        log.info("`bar.getBar() equals str4`: {}", bar.getBar().equals(str));
        log.info("`bar.getBar() == str4`: {}", bar.getBar() == str);

        assertThat(bar.getBar()).isEqualTo(str);
        assertThat(bar.getBar() == str).isTrue();
    }

    @Test
    public void anotherInternTest()  {

        String s1 = "Farhad";
        String s2 = "Farhad";
        String s3 = new String("Farhad");
        final String s4 = s3.intern();

        log.info("s1 == s2`: {}", s1 == s2); // true
        log.info("s2 == s3`: {}", s2 == s3); // false
        log.info("s3 == s4`: {}", s3 == s4); // false
        log.info("s1 == s3`: {}", s1 == s3); // false
        log.info("s1 == s4`: {}", s1 == s4); // true
        log.info("s2 == s4`: {}", s2 == s4); // true

        assertThat( s1 == s2 ).isTrue();
        assertThat( s2 == s3 ).isFalse();
        assertThat( s3 == s4 ).isFalse();
        assertThat( s1 == s3 ).isFalse();
        assertThat( s1 == s4 ).isTrue();
        assertThat( s2 == s4 ).isTrue();
    }



}


package com.farhad.example.string;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcatDemo {
    
    public static void main(String[] args) {
        
        List<String> countries = Arrays.asList(
            "USA",
            "Iran",
            "Germany",
            "Italy",
            "Uk"   
        );

        String concatedString = String.join("; ", countries);
        log.info("{}", concatedString);

        List<String> paths = Arrays.asList(
            "root",
            "home",
            "farhad",
            "README.md"   
        );
        String path =  String.format("/%s", String.join(File.separator, paths));
        log.info("{}", path);

        paths = Arrays.asList(
            "etc",
            "elasticsearch",
            "elasticsearch.yml"   
        );
        path = paths.stream()
                    .collect(Collectors.joining(File.separator, File.separator, ""));
        log.info("{}", path);

        paths = Arrays.asList(
            "var",
            "log",
            "elasticsearch",
            "my-cluster.log"   
        );
        StringJoiner joiner = new StringJoiner(File.separator, File.separator, "");
        paths.forEach(joiner::add);
        path = joiner.toString();
        log.info("{}", path);


        paths = Arrays.asList(
            "var",
            "log",
            "redis",
            "redis.log"   
        );
        Person person = new Person("Farhad Rasouli", "Terhan", 46);
        log.info("{}", person.toString(","));

        paths = Arrays.asList(
            "var",
            "log",
            "my-app",
            "%1$s",
            "my-app-%2$s"   
        );
        String prefix = File.separator;
        String suffix = ".log";
        String parameter1 = new SimpleDateFormat("yyyyMM").format(new Date());
        String parameter2 = new SimpleDateFormat("yyyyMMdd").format(new Date());;
        path = paths.stream()
                    .map(t -> String.format(t, parameter1, parameter2))
                    .collect(Collectors.joining(File.separator, prefix, suffix));
        log.info("{}", path);

        paths = Arrays.asList(
            "var",
            "log",
            "my-app",
            "%1$s",
            "my-app-%2$s"   
        );
        path = paths.stream()
                    .collect(Collectors.joining(File.separator, prefix, suffix));
        path = String.format(path, parameter1, parameter2);
        log.info("{}", path);

        String relativePath = new StringJoiner("/").add("usr").add("local").add("bin").toString();
        log.info("{}", relativePath);

        String  absolutePath = new StringJoiner("/", "/", "").add("usr").add("local").add("bin").toString();
        log.info("{}", absolutePath);

        String colonSeperatedString = String.join(":", "usr", "local", "bin");
        log.info("{}", colonSeperatedString);

        countries = Arrays.asList("USA", "Iran", "Italy", "Uk");
        String joinedContries = String.join("||", countries);
        log.info("{}", joinedContries);

    }

    @AllArgsConstructor
    static class Person {
        private String name;
        private String address;
        private int age ;

        public String toString(CharSequence delimiter) {
            return String.join(delimiter, Arrays.asList(name, address, String.valueOf(age)));
        }
    }
}

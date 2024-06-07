package com.farhad.example.design_principles03.srp.good;

import static java.util.stream.Collectors.toList;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
 
import com.farhad.example.design_principles03.srp.good.User.SubscriptionType;

public class AccessManager {

    public static boolean hasUnlimitedContentAccess(User user) {
        return SubscriptionType.VIP == user.getSubscriptionType()
                && user.getSubscriptionExpirationDate().after(new Date());
    }

    public List<Movie> getBasicContent(List<Movie> movies) {
        return movies.stream()
                .filter(m -> SubscriptionType.STANDARD.equals(m.getSubscriptionType()))
                .collect(toList());
    }

    public List<Movie> getPermiumContent(List<Movie> movies) {
        return movies.stream()
                .filter(m -> SubscriptionType.VIP.equals(m.getSubscriptionType()))
                .collect(toList());
    }

    public List<Movie> getContentsForUserWithBasicAccess(List<Movie> movies) {
        return getBasicContent(movies);
    }

    public List<Movie> getContentsForUserWithUnlimitedAccess(List<Movie> movies, User user) {
        if(SubscriptionType.VIP.equals(user.getSubscriptionType())) {
            return getPermiumContent(movies);
        }
        return new ArrayList<>();
    }
}

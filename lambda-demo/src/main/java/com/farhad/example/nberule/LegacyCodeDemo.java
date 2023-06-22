package com.farhad.example.nberule;

import java.util.HashMap;
import java.util.Map;

import com.farhad.example.nberule.LegacyCodeDemo.User.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LegacyCodeDemo {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImple();
        UserProfileRepository userProfileRepository = new UserProfileRepositoryImpl() ;
        UserService userService = new UserService(userRepository, userProfileRepository);
        initialize(userRepository, userProfileRepository);

        log.info("---------------------------------------------------------------");
        UserWithProfile userWithProfile =  userService.getUserWithProfile(Id.of("user01"));
        log.info("{}", userWithProfile);

        log.info("---------------------------------------------------------------");
        userWithProfile = userService.getUserWithProfile(Id.of("user02"));
        log.info("{}", userWithProfile);

        log.info("---------------------------------------------------------------");
        userWithProfile = userService.getUserWithProfile(Id.of("xxxxx"));
        log.info("{}", userWithProfile);
    }

    private static void initialize(UserRepository  userRepository,
                        UserProfileRepository userProfileRepository) {

            User user;
            user = new User(Id.of("user01"), "Farhad");
            userRepository.create(user);

            user = new User(Id.of("user02"), "Ali");
            userRepository.create(user);

            UserProfile userProfile;
            userProfile = new UserProfile(Id.of("user01"), "profile01");
            userProfileRepository.create(userProfile);
    }

    public interface UserRepository {
        User findById(User.Id userId);
        User create(User user);
    }

    static class UserRepositoryImple implements UserRepository {
        private static Map<Id, User> users = new HashMap<>();

        @Override
        public User findById(Id userId) {
            return users.get(userId);
        }

        @Override
        public User create(User user) {
            users.put(user.getUserId(), user);
            return user;
        }
    }

    public interface UserProfileRepository {
        UserProfile findById(User.Id userId);
        UserProfile create(UserProfile userProfile) ;
    }

    static class UserProfileRepositoryImpl implements UserProfileRepository {
        private static Map<Id, UserProfile> profiles = new HashMap<>();

        @Override
        public UserProfile findById(Id userId) {
            return profiles.get(userId);
        }

        @Override
        public UserProfile create(UserProfile userProfile) {
            profiles.put(userProfile.getUserId(), userProfile);
            return userProfile;
        }
    }

    @RequiredArgsConstructor
    static class UserService {
        private final UserRepository userRepository;
        private final UserProfileRepository userProfileRepository;

        public UserWithProfile getUserWithProfile(User.Id userId) {
            User user = userRepository.findById(userId);
            if (user == null) {
                throw new UserNotFoundException("User with Id " + userId + " not found");
            }
            UserProfile userProfile = userProfileRepository.findById(userId);
            return UserWithProfile.of(user, 
                                        userProfile == null 
                                                ? UserProfile.defaultProfile() 
                                                : userProfile);
        }
    }

    @Data
    @AllArgsConstructor
    static class User {
        private final Id userId;
        private String name;

        @Data(staticConstructor = "of")
        static class Id {
            private final String id;

            @Override
            public String toString() {
                return id;
            }
        }

        @Override
        public String toString() {
            return userId.id + "," + name;
        }
    }

    @Data 
    @AllArgsConstructor
    @NoArgsConstructor
    static class UserProfile {
        private static final UserProfile _DEFAULT_PROFILE = new UserProfile(null, "--");
        private Id userId ;
        private String profileName;

        static UserProfile defaultProfile() {
            return _DEFAULT_PROFILE;
        }

        @Override
        public String toString() {
            return profileName;
        }
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor
    static class UserWithProfile {
        private User user;;
        private UserProfile userProfile;

        @Override
        public String toString() {
            return String.format("[User: [%s], Profile: [%s] ]", user, userProfile)  ;
        }
    }

    static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}

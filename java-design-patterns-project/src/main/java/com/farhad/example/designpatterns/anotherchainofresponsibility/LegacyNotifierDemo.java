package com.farhad.example.designpatterns.anotherchainofresponsibility;

public class LegacyNotifierDemo {
    
    interface UserNotifier {
        void notify(UserProfile profile);
        void setNextNotifier(UserNotifier notifier);
    }

    static abstract class AbstractUserNotifier implements UserNotifier {
        protected UserNotifier nexNotifier;

        @Override
        public void setNextNotifier(UserNotifier notifier) {
            this.nexNotifier = notifier;
        }
    }

    static class UserProfile {

    }

}

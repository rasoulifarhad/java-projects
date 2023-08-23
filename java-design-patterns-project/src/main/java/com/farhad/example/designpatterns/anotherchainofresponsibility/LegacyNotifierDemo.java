package com.farhad.example.designpatterns.anotherchainofresponsibility;

import lombok.Data;
import lombok.RequiredArgsConstructor;

// https://github.com/yanaga/revisiting-design-patterns/blob/main/src/main/java/com/google/developers/wallet/chain/legacy/LegacyChainOfResponsibility.java
public class LegacyNotifierDemo {
    
    public static void main(String[] args) {

        UserNotifier notifier = createNotifier();

        UserProfile userProfile01 = new UserProfile(true, true, true);
        UserProfile userProfile02 = new UserProfile(false, true, true);
        UserProfile userProfile03 = new UserProfile(false, false, false);

        System.out.println();
        notifier.notify(userProfile01);
        System.out.println();
        notifier.notify(userProfile02);
        System.out.println();
        notifier.notify(userProfile03);


    }

    private static UserNotifier createNotifier() {
        GoogleWalletPassUpdateNotifier googleWalletPassUpdateNotifier = new GoogleWalletPassUpdateNotifier();
        EmailNotifier emailNotifier = new EmailNotifier();
        SmsNotifier smsNotifier = new SmsNotifier();

        googleWalletPassUpdateNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        return googleWalletPassUpdateNotifier;
    }

    interface UserNotifier {
        void notify(UserProfile profile);
        void setNextNotifier(UserNotifier notifier);
    }

    abstract static class AbstractUserNotifier implements UserNotifier {
        protected UserNotifier nexNotifier;

        @Override
        public void setNextNotifier(UserNotifier notifier) {
            this.nexNotifier = notifier;
        }
    }

    static class GoogleWalletPassUpdateNotifier extends AbstractUserNotifier {

        @Override
        public void notify(UserProfile profile) {
            if (profile.isHasGooleWalletPass()) {
                System.out.println("Google Wallet Pass updated.");
            } else if(nexNotifier != null) {
                nexNotifier.notify(profile);
            } else {
                throw new RuntimeException("No notification sent.");
            }
        }
    }

    static class EmailNotifier extends AbstractUserNotifier {

        @Override
        public void notify(UserProfile profile) {
            if (profile.isAllowsEmail()) {
                System.out.println("Email sent.");
            } else if (nexNotifier != null) {
                nexNotifier.notify(profile);
            } else {
                throw new RuntimeException("No notification sent.");
            }
        }
    }

    static class SmsNotifier extends AbstractUserNotifier {

        @Override
        public void notify(UserProfile profile) {
            if (profile.isAllowsSms()) {
                System.out.println("Sms sent.");
            } else if (nexNotifier != null) {
                nexNotifier.notify(profile);
            } else  {
                throw new RuntimeException("No notification sent.");
            }
        }
    }

    @RequiredArgsConstructor
    @Data
    static class UserProfile {
        private final boolean hasGooleWalletPass;
        private final boolean allowsEmail;
        private final boolean allowsSms;

    }

    @RequiredArgsConstructor
    @Data
    static class PassInformation {
        private final UserProfile userProfile;
    }

}

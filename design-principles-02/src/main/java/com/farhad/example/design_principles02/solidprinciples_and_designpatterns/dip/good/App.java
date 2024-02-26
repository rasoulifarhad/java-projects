package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.dip.good;

public class App {

	public void changePassword(ChangePasswordRequest changePasswordRequest, String notificationType) {
		Notifier notifier;
		switch (notificationType) {
			case "email":
				notifier = new EmailNotifier();
				break;
			case "sms":
				notifier = new SMSNotifier();
				break;

			default:
				throw new IllegalArgumentException("Unknown notification type: " + notificationType);

		}
		UserManager userManager = new UserManager(notifier);
		userManager.changePassword(changePasswordRequest.getUserName(), changePasswordRequest.getOldPassword(),
				changePasswordRequest.getNewPassword());
	}
}

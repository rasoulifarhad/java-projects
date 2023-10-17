package com.farhad.example.functional_interface.first_class_function.function_pipeline;

import java.util.function.Consumer;
import java.util.function.Function;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class Email {
	
	private final String message;

	public Email addHeader() {
		return new Email("Dear Sir/Madam:\n" + message);
	}

	public Email checkSpelling() {
		return new Email(message.replaceAll("FTW", "for the win"));
	}

	public Email addSignature() {
		return new Email(message + "\n Kind regards");
	}

	public static void main(String[] args) {

		Function<Email, Email> addHeader = Email::addHeader;
		Function<Email, Email> processingPipeline = 
				addHeader.andThen(Email::checkSpelling)
						 .andThen(Email::addSignature);
		Consumer<Email> emailPrinter = email -> System.out.println(processingPipeline.apply(email));
		Email email = new Email("Farhad");  				 
		emailPrinter.accept(email);

		emailPrinter.accept(new Email("FTW"));
		
	}

}

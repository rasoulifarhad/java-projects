package com.farhad.example.enums;

public class EnumsExtendsInterfacesDemo {
	
	interface Emotionable {
		String getIcon();
	}

	public enum Mood implements Emotionable {
		GOOD {

			@Override
			public String getIcon() {
				return ";-)";
			}
		},
		BAD {

			@Override
			public String getIcon() {
				return ";-(";
			}

		};

		public String toString() {
			return this.getIcon();
		}
	}

	public enum Emotion implements Emotionable {
		LAUGHING {
			public String toString() {
				return getIcon();
			}
		},
		CRYING {
			public String getIcon() {
				return ";-(";
			}
		};
		
		public String getIcon() {
			return ";-|";
		}

	}

	public static void main(String[] args) {
		
		System.out.println("Good mood, laughing " + Mood.GOOD + " "  + Emotion.LAUGHING);
		System.out.println("Good mood, crying " + Mood.GOOD + " " + Emotion.CRYING);
	}
}

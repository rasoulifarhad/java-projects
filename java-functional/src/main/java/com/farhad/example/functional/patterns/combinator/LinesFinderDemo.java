package com.farhad.example.functional.patterns.combinator;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// See https://java-design-patterns.com/patterns/combinator/#explanation
public class LinesFinderDemo {
	

	interface Finder {

		List<String> find(String text);

		static Finder contans(String word) {
			return txt -> Stream.of(txt.split("\n")) 
							.filter(line -> line.toLowerCase().contains(word.toLowerCase()))
							.collect(toList());
		}

		default Finder not(Finder notFinder) {
			return txt -> {
				List<String> res = this.find(txt);
				res.removeAll(notFinder.find(txt));
				return res;
			}; 
		}

		default Finder or(Finder orFinder) {
			return txt -> {
				List<String> res = this.find(txt);
				res.addAll(orFinder.find(txt));
				return res;
			};
		}

		default Finder and(Finder andFinder) {
			return txt -> 
				this.find(txt)
					.stream()
					.flatMap(line -> andFinder.find(line).stream())
					.collect(toList());
		}
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static class Finders {

		public static Finder advancedFinder(String query, String orQuery, String notQuery) {
			return
				Finder.contans(query)
					  .or(Finder.contans(orQuery))
					  .not(Finder.contans(notQuery));		
		}
		
		public static Finder FilteredFinder(String query, String... excludedQueries ) {
			
			Finder f = Finder.contans(query);
			for (String q : excludedQueries) {
				f = f.not(Finder.contans(q));
			}
			return f;
		}

		public static Finder specializedFinder(String... queries) {
			Finder finder = all();
			for (String query : queries) {
				finder = finder.and(Finder.contans(query));
			}
			return finder;
		}

		public static Finder expandedFinder(String... queries) {
			Finder finder = none();

			for (String query : queries) {
				finder = finder.or(Finder.contans(query));
			}
			return finder;
		}

		public static Finder all() {
			return txt -> Stream.of(txt.split("\n"))
							.collect(toList()); 
		}

		private static Finder none() {
			return txt -> new ArrayList<>();
		}

	}

	public static void main(String[] args) {
		
		String word = "Annabel";
		Finder annabelFinder = Finder.contans(word);
		System.out.println();
		System.out.println(annabelFinder.find(text()));

		Finder allFinder = Finders.all();
		System.out.println();
		System.out.println(allFinder.not(annabelFinder).find(text()));

		String [] queriesOr = new String[] {"many", "Annabel"};
		System.out.println();
		System.out.println(Finders.expandedFinder(queriesOr).find(text())); 


		String [] queriesAnd = new String[] {"Annabel", "my"};
		System.out.println();
		System.out.println(Finders.specializedFinder(queriesAnd).find(text()));

		System.out.println();
		System.out.println("advanced queries:");
		System.out.println(Finders.advancedFinder("it was", "kingdom", "sea").find(text()));

		System.out.println();
		System.out.println("filtered queries:");
		System.out.println(Finders.FilteredFinder("was", "many", "child").find(text()));
	}


	private static String text() {
		return
			"It was many and many a year ago,\n"
				+ "In a kingdom by the sea,\n"
				+ "That a maiden there lived whom you may know\n"
				+ "By the name of ANNABEL LEE;\n"
				+ "And this maiden she lived with no other thought\n"
				+ "Than to love and be loved by me.\n"
				+ "I was a child and she was a child,\n"
				+ "In this kingdom by the sea;\n"
				+ "But we loved with a love that was more than love-\n"
				+ "I and my Annabel Lee;\n"
				+ "With a love that the winged seraphs of heaven\n"
				+ "Coveted her and me.";
	  }	
}

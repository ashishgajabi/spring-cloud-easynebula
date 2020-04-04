package au.com.easynebula.realestatepropertymanagement;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Interview {

	public static void main(String[] args) {
//		final List<String> votes = Arrays.asList("A", "B", "A", "C", "D", "B", "A");
//
//		final Map<String, Integer> x = new HashMap<>();
//		for(final String i : votes) {
//			Integer count = x.get(i);
//			if(count == null) {
//				count = 0;
//			}
//			x.put(i, count + 1);
//		}
//
//		Map.Entry<String, Integer> entry = null;
//		for(Map.Entry<String, Integer> e : x.entrySet()) {
//			if(entry == null || e.getValue().compareTo(entry.getValue()) > 0) {
//				entry = e;
//			}
//		}
//		System.out.println(entry.getValue());

//		votes.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.co))

//		List<Integer> integers = Arrays.asList(1, 2, 4, 5, 6, 7, 89, 10, -10, 0);
//
//		integers.stream().filter(integer -> integer%2 == 0).forEach(System.out::println);
//		final Predicate<Integer> evenPredicate = integer -> integer%2 == 0;
//		System.out.println(evenPredicate.test(-10));
//
//
//		final Predicate<Integer> oddPredicate = integer -> integer%2 != 0;
//		System.out.println(oddPredicate.test(-9));
//
//		StringBuilder sb = new StringBuilder("radar");
//		sb.reverse();
//		System.out.println("radar".equals(sb.toString()));
//
//		final String originalString = "radar";
//		String reversedString = "";
//		for(int i = originalString.length() - 1; i >= 0; i--) {
//			reversedString = reversedString + originalString.charAt(i);
//		}
//		System.out.print("asds:" + originalString.equals(reversedString));
//
//		List<Integer> list = Arrays.asList(1,2,3,4,5);
//
//		System.out.println("Sum of ArrayList Integers: "+ list.stream().mapToInt(integer -> integer).sum());
//
//		final IntPredicate primePredicate = integer -> integer > 1 && IntStream.range(2, integer).noneMatch(i -> integer%i == 0);
//		System.out.println("My prime number: " + primePredicate.test(5));
//
//		List<Integer> collect = IntStream.range(0, 100).filter(primePredicate).boxed().collect(Collectors.toList());
//		System.out.println(collect);

		System.out.println(getAnagram("123321"));
		System.out.println(getAnagram("12345644444469999999999999"));
		System.out.println(getAnagram("2133326615727117001540261141407327120031612260317493998987993857958996993904815918596499598790384428"));
		System.out.println((LocalDate.now()));

	}

	public static int getAnagram(final String s) {
		int numOfOperations = 0;

		final String secondHalf = s.substring((s.length() / 2));
		String sortedSecondHalf = Stream.of(secondHalf.split("")).sorted().collect(Collectors.joining());

		final String firstHalf = s.substring(0, s.length()/2);
		String sortedFirstHalf = Stream.of(firstHalf.split("")).sorted().collect(Collectors.joining());

		for(int i = 0; i < (sortedFirstHalf.length()); i++) {
			if(sortedSecondHalf.substring(i, i + 1).equals(sortedFirstHalf.substring(i, i + 1))) {
				continue;
			}
			numOfOperations = numOfOperations + 1;
		}
		return numOfOperations;
	}
}

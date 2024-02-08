
public class SpellChecker {
	/////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}
		/////////////////////////////////////////////////////////////
	public static String tail(String str) {
		if (str.length() == 0){return "";}
		String tail = str.substring(1);
		return tail;
	}
	/////////////////////////////////////////////////////////////
	public static int levenshtein(String word1, String word2) {
		String lowercase1 = word1.toLowerCase();
		String lowercase2 = word2.toLowerCase();
		int word1Length = word1.length();
		int word2Length = word2.length();
		if (word1Length == 0){return word2Length;}
		if (word2Length == 0){return word1Length;}
		if (lowercase1.charAt(0) == lowercase2.charAt(0)) {
			return levenshtein(tail(lowercase1), tail(lowercase2));
		} 
		int first = levenshtein(tail(lowercase1), tail(lowercase2));
		int second = levenshtein(lowercase1, tail(lowercase2));
		int third = levenshtein(tail(lowercase1), lowercase2);
		return 1 + Math.min(Math.min(first, second), third);
	}
	/////////////////////////////////////////////////////////////
	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i = 0; i < 3000; i++){
			String word = in.readString();
			dictionary[i] = word;
		}
		return dictionary;
	}
	/////////////////////////////////////////////////////////////
	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
	}}



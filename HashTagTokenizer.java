

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
	//	System.out.println(dictionary[2967]); 
	//	System.out.print(existInDictionary("word", dictionary));
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i = 0; i < 3000; i++){
			String word = in.readString();
			dictionary[i] = word;
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String[] dictionary) {
		for (int i = 0; i < 3000; i++){
			if (dictionary[i].equals(word)){return true;}
		}
		return false;
	}
	
	public static void breakHashTag(String hashtag, String[] dictionary) {
		String lowercase = hashtag.toLowerCase();
        if (hashtag.isEmpty()) {// Base case: do nothing (return) if hashtag is an empty string.
            return;
        }
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) {
			if (existInDictionary(lowercase.substring(0, i), dictionary) == true){
				System.out.println(lowercase.substring(0, i));
				breakHashTag(lowercase.substring(i), dictionary);
				return;
			}

		}
        }
    }



import java.util.*;

class Text {
    private static String text = "This isnt an error, this is the correct behaviour in IntelliJ. The console is displaying the output of each test as it goes, the message Process finished with exit code 0 states that the test run was successful. If a test fails this will say something else.";
    private static String words = text.replaceAll("[^A-z| ]", "");


    static void printWordLength() {
        //String words = text.replaceAll("[^A-z| ]", "");
        System.out.println(words);
        String[] wordlist = words.split("\\s+");
        System.out.println("Number of words: " + wordlist.length);
    }

    static int countSentences() {
        String[] sentences = text.split("[!?.;]+");
        return (sentences.length);
    }

    static int countLetters() {
        String letters = text.replaceAll("[^A-z]", "");
        return (letters.length());

    }

    public static int[] countVowelsAndConsonants() {
        text = text.toLowerCase();
        int vowels = 0, consonants = 0, spaces = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                ++consonants;
            } else if (ch == ' ') {
                ++spaces;
            }
        }
        int[] returnedValue = new int[3];
        returnedValue[0]= vowels;
        returnedValue[1]= consonants;
        returnedValue[2]= spaces;

        return returnedValue;
    }

    static void repeatedWords() {

        String[] thesameword = words.toLowerCase().split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<String, Integer>();
        for (String word : thesameword) {
            Integer count = wordCounts.get(word);
            if (count == null) {
                count = 0;
            }
            wordCounts.put(word, count + 1);
        }
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        System.out.println(maxEntry);
        System.out.println(wordCounts);

    }

    static void longestWord() {
        String[] longw = words.split(" ");
        String longword = " ";
        System.out.println(Arrays.toString(longw));
        for (String s : longw) {
            //for (int j = i + 1; j < longw.length; j++) {
            if (s.length() >= longword.length()) {
                longword = s;
            }

        }

        System.out.println(longword+" is longest word with "+longword.length()+" characters");
   }
   static void topFive(){
   HashMap<String, Integer> map = new HashMap<String, Integer>();
    ArrayList<String> arrayList = new ArrayList(Arrays.asList(text.split(" ")));
        for (int i = 1; i < 6; i++) {
        int maxValue = 0;

        for (String word : arrayList) {
            Integer number = map.get(word);
            if (number == null) number = 1;
            else number = ++number;
            map.put(word, number);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        String key = getKeyFromValue(map, maxValue);
        System.out.println(" Top " + i + " = " + key);
        map.remove(key);
        arrayList.removeAll(Collections.singleton(key));
    }
}

    private static String getKeyFromValue(Map<String, Integer> hashMap, Integer value) {
        for (String word : hashMap.keySet()) {
            if (hashMap.get(word).equals(value)) {
                return word;
            }
        }
        return null;
    }

}




package task4.controller;

import task4.utils.InputHelpers;
import task4.utils.TagsProcessor;
import task4.utils.URLConnectionReader;
import task4.utils.URLContainer;
import task4.view.View;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private View view;
   static public HashMap <String, HashMap<String,Integer>> mainContainer = new HashMap<String, HashMap<String, Integer>>();
   static HashSet<String> vocabulary = new HashSet<String>();
   static String delimeter = " ";

   public Controller (View view) {
       this.view = view;
   }

    public static void processUser()  {
        createVocabularyOfUniqueWords();
        processUrls();
        searchFrequencyOfWords();
    }

    public static void  createVocabularyOfUniqueWords() {
        for (int i = 0; i < URLContainer.urls.length; i++) {
           String str = URLConnectionReader.getURLContents(URLContainer.urls[i]);
           String sonnet = TagsProcessor.extractTextFromHtmlPage(str);
           sonnet =  sonnet.replaceAll("\\p{Punct}","");
           String[] stringsContainer = sonnet.split(delimeter);
            for (int j = 0; j < stringsContainer.length; j++) {
                vocabulary.add(stringsContainer[j]);
            }
        }
        vocabulary.remove("\r");
        vocabulary.remove("\n");
        vocabulary.removeAll(Collections.singleton(""));
    }

    public static void processUrls ()  {
        String[] arrayVocab = {};
        arrayVocab = vocabulary.toArray(new String[vocabulary.size()]);
            for (int j = 0; j < arrayVocab.length; j++) {
                HashMap<String,Integer> urlsAndFreq = new HashMap<String, Integer>();
                for (int i = 0; i < URLContainer.urls.length; i++) {
                    String str = URLConnectionReader.getURLContents(URLContainer.urls[i]);
                    String sonnet = TagsProcessor.extractTextFromHtmlPage(str);
                    int wordfreq = 0;
                    Pattern pattern = Pattern.compile(arrayVocab[j]);
                    Matcher matcher = pattern.matcher(sonnet);
                    while(matcher.find()) {
                        wordfreq++;
                }
                    formMap(urlsAndFreq,URLContainer.urls[i],wordfreq);
            }
               HashMap<String,Integer> sortedUrls =  sortMap(urlsAndFreq);
                mainContainer.put(arrayVocab[j],sortedUrls);
        }
    }

    public static void formMap(HashMap <String,Integer> map, String key, int freq) {
        if (!map.containsKey(key) && freq != 0) {
            map.put(key,freq);
        }
    }

    public static HashMap<String,Integer> sortMap(HashMap<String,Integer> map) {
        Map<String, Integer> orderedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(LinkedHashMap::new,
                        (m, c) -> m.put(c.getKey(), c.getValue()),
                        LinkedHashMap::putAll);
        return (HashMap<String, Integer>) orderedMap;
    }

    public static void searchFrequencyOfWords () {
        String[] arrayVocab = {};
        arrayVocab = vocabulary.toArray(new String[vocabulary.size()]);
        for (int i = 0; i < arrayVocab.length; i++) {
            System.out.println(i + " : " +  arrayVocab[i]);
        }
        View.printMessage(View.SELECT_WORD_TO_SEARCH + View.VOCABULARY_SIZE + arrayVocab.length);
        try {
            int number = InputHelpers.measuresCheck(0,arrayVocab.length - 1);
            View.printMessage(View.WORD_INFO);
            System.out.println(mainContainer.get(arrayVocab[number]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

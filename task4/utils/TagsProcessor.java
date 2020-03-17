package task4.utils;

public class TagsProcessor {
    private final static String BR_TAG = "<BR>";
    private final static String BLOCKQUOTE_STARTING_TAG = "<BLOCKQUOTE>";
    private final static String BLOCKQUOTE_ENDING_TAG = "</BLOCKQUOTE>";

    public static String extractTextFromHtmlPage (String urlContents) {
        int start = urlContents.indexOf(BLOCKQUOTE_STARTING_TAG) + BLOCKQUOTE_STARTING_TAG.length();
        int finish = urlContents.indexOf(BLOCKQUOTE_ENDING_TAG);
        return urlContents.substring(start,finish).replaceAll(BR_TAG," ");
    }
}

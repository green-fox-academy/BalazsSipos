public class TakesLonger {
    public static void main(String... args){
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

        // When saving this quote a disk error has occured. Please fix it.
        int index = quote.indexOf(" you expect,");
        System.out.println(index);
        // Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
        // Using pieces of the quote variable (instead of just redefining the string)
        String newQuote = quote.substring(0,index);
        newQuote += " always takes longer than ";
        newQuote += quote.substring(index+1);

        System.out.println(quote);
        System.out.println(newQuote);
    }
}
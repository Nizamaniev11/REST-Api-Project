package a1qa.nizam.utilit;

public class Randomizer {


    public static String randomSymbolsString(int n, boolean digits) {

        String AlphabeticString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        if (digits) AlphabeticString += "1234567890";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index = (int) (AlphabeticString.length() * Math.random());

            sb.append(AlphabeticString.charAt(index));
        }

        return sb.toString();
    }

}

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] croaStr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String str = br.readLine();
        for (int i = 0; i < croaStr.length; i++) {
            String word = croaStr[i];

            int wordLen = word.length();

            for(int j = 0; j <= str.length() - wordLen; j++) {
                String cutStr = str.substring(j, j + wordLen);
                if (cutStr.equals(word)) {
                    str = str.substring(0, j) + "0" + str.substring(j + wordLen);
                }
            }
        }

        System.out.println(str.length());
    }
}
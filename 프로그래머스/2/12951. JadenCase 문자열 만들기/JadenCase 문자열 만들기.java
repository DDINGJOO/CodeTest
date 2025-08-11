class Solution {
public String solution(String s) {
    StringBuilder sb = new StringBuilder(s.length());
    boolean newWord = true; // 단어의 첫 문자 여부
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == ' ') {
            sb.append(c);
            newWord = true;
            continue;
        }
        if (newWord) {
            // 단어의 첫 문자
            if (Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c); // 숫자 처리
            }
            newWord = false;
        } else {
            // 단어의 첫 문자 이후
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
    }
    return sb.toString();
}
}
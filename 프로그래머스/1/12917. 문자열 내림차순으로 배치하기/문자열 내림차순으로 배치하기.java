
class Solution {
    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((v1, v2)-> -(v1-v2))
                .collect(StringBuilder :: new,
                        StringBuilder :: appendCodePoint,
                        StringBuilder :: append)
                .toString();
    }
}
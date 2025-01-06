import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genrePlayCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }


        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            songs.add(new Song(genres[i], plays[i], i));
        }

        List<String> genreOrder = new ArrayList<>(genrePlayCount.keySet());
        genreOrder.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));


        Map<String, List<Song>> songsByGenre = new HashMap<>();
        for (Song song : songs) {
            songsByGenre.computeIfAbsent(song.genre, k -> new ArrayList<>()).add(song);
        }
        for (List<Song> songList : songsByGenre.values()) {
            songList.sort((s1, s2) -> {
                if (s1.plays != s2.plays) {
                    return s2.plays - s1.plays; // 재생 횟수 내림차순
                }
                return s1.id - s2.id; // 고유 번호 오름차순
            });
        }

        List<Integer> bestAlbum = new ArrayList<>();
        for (String genre : genreOrder) {
            List<Song> sortedSongs = songsByGenre.get(genre);
            for (int i = 0; i < Math.min(sortedSongs.size(), 2); i++) {
                bestAlbum.add(sortedSongs.get(i).id);
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }

    static class Song {
        String genre;
        int plays;
        int id;

        Song(String genre, int plays, int id) {
            this.genre = genre;
            this.plays = plays;
            this.id = id;
        }
    }
}
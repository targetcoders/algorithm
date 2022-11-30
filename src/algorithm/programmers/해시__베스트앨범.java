package algorithm.programmers;
import java.util.*;

// Programmers 42579 - 베스트앨범
public class 해시__베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlay = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            totalPlay.put(genres[i], totalPlay.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Record> records = new ArrayList<>();
        for (int i=0; i<genres.length; i++) {
            Record record = new Record(i, genres[i], plays[i], totalPlay.get(genres[i]));
            records.add(record);
        }
        Collections.sort(records);

        Map<String, Boolean> visited = new HashMap<>();
        for (String genre : totalPlay.keySet()) {
            visited.put(genre, false);
        }

        List<Integer> answer = new ArrayList<>();
        int cnt = 0;
        String preGenre = "";
        for (Record r : records) {
            if (!visited.get(r.genre)) {
                if (!preGenre.equals(r.genre)) {
                    cnt = 0;
                }
                answer.add(r.index);
                ++cnt;
                if(cnt == 2) {
                    visited.put(r.genre, true);
                }
                preGenre = r.genre;
            }
        }

        int[] result = new int[answer.size()];
        for (int i=0; i<answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    static class Record implements Comparable<Record> {
        public int index;
        public String genre;
        public int play;
        public int totalPlay;

        Record(int index, String genre, int play, int totalPlay) {
            this.index = index;
            this.genre = genre;
            this.play = play;
            this.totalPlay = totalPlay;
        }

        @Override
        public String toString() {
            return "index="+index+", genre="+genre+", play="+play+", totalPlay="+totalPlay;
        }

        @Override
        public int compareTo(Record r) {
            if (totalPlay < r.totalPlay) {
                return 1;
            } else if (totalPlay==r.totalPlay) {
                if (play < r.play) {
                    return 1;
                } else if (play == r.play) {
                    if (index > r.index) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
}

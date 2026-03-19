package level1;

import java.util.ArrayList;



/**
 * Sorting and searching algorithms for the leaderboard.
 */
public class LeaderboardAlgorithms {

    /**
     * Sorts the list by score in DESCENDING order using selection sort.
     * Highest score first, lowest score last.
     */
    public static void sortByScoreDescending(ArrayList<ScoreEntry> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int maxIndex = i;

            // Find the highest score in the remaining list
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getScore() > list.get(maxIndex).getScore()) {
                    maxIndex = j;
                }
            }

            // Swap
            ScoreEntry temp = list.get(i);
            list.set(i, list.get(maxIndex));
            list.set(maxIndex, temp);
        }
    }

    /**
     * Sorts the list by username in ASCENDING order using insertion sort.
     * A -> Z
     */
    public static void sortByUsernameAscending(ArrayList<ScoreEntry> list) {
        for (int i = 1; i < list.size(); i++) {
            ScoreEntry current = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    list.get(j).getUsername().compareToIgnoreCase(current.getUsername()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, current);
        }
    }

    /**
     * Binary search for an exact username match.
     * Precondition: list must already be sorted by username ascending!
     *
     * @return index of the matching entry, or -1 if not found
     */
    public static int binarySearchByUsername(ArrayList<ScoreEntry> list, String username) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            String midUsername = list.get(mid).getUsername();
            int comparison = midUsername.compareToIgnoreCase(username);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
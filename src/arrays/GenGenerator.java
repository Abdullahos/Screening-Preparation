package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class GenGenerator {
  public static int findTime(String genome, char mutation) {

    if (genome.indexOf(mutation) == -1) {
      return 0;
    }

    int timeAfterNoMoreRemoval = 0;

    StringBuilder sb = new StringBuilder(genome);

    boolean willRemove;

    while (sb.length() > 1) {

      willRemove = false;

      boolean[] toRemove = new boolean[sb.length()];

      for (int i = 1; i < sb.length(); i++) {
        if (sb.charAt(i) == mutation) {
          toRemove[i - 1] = true;
          willRemove = true;
        }
      }

      if (!willRemove) {
        break;
      }

      StringBuilder temp = new StringBuilder();

      for (int i = 0; i < sb.length(); i++) {
        if (!toRemove[i]) {
          temp.append(sb.charAt(i));
        }
      }

      timeAfterNoMoreRemoval++;

      sb = temp;
    }

    return timeAfterNoMoreRemoval;
  }

  private int findTime2(String genome, char mutation) {
    int exist = (1 << genome.length()) - 1;
    int time = 0;

    while ((exist |= ((1 << genome.length()) - 1)) != 0) {
      time++;
      for (int i = 0; i < genome.length() - 1; i++) {
        if ((exist & (i << 1)) == 0) {
          continue;
        }

        if (genome.charAt(i + 1) == mutation) {
          exist &= (i);
        }
      }
    }
    return time;
  }

  private int findTime3(String genome, char mutation) {
    int time = 0;
    Map<Integer, Integer> effectiveNextToRemove = new HashMap<>();

    // init effectiveNextToRemove
    for (int i = 1; i < genome.length() - 1; i++) {
      if (genome.charAt(i) == mutation) {
        effectiveNextToRemove.put(i, i - 1);
      }
    }

    while (!effectiveNextToRemove.isEmpty()) {
      time++;

      for (int mut : effectiveNextToRemove.keySet()) {
        int nextIdx = effectiveNextToRemove.get(mut) - 1;
        if (nextIdx >= 0) {
          effectiveNextToRemove.put(mut, nextIdx);
        } else {
          effectiveNextToRemove.remove(mut);
        }
      }
    }

    return time;
  }

  private int naiveSol(String genome, char mutation) {
    boolean[] removed = new boolean[genome.length()];
    int time = 0;

    while (true) {
      // each full iteration == 1 time unit
      boolean nothingRemoved = true;
      for (int i = genome.length() - 1; i > 0; i--) {

        if (!removed[i] && genome.charAt(i) == mutation) {
          for (int idx = i - 1; idx >= 0; idx--) {
            if (!removed[idx]) {
              removed[idx] = true;
              nothingRemoved = false;
              break;
            }
          }
        }
      }
      if (nothingRemoved) {
          break;
      }
      time++;
    }
    return time;
  }

  private int optimizedNaiveSol(String genome, char mutation) {
    TreeSet<Integer> available = new TreeSet<>();
        int time = 0;

        for (int i = 0; i < genome.length(); i++) {
            available.add(i);
        }

        while (true) {
            // each full iteration == 1 time unit
            boolean nothingRemoved = true;
            for (int i = genome.length() - 1; i > 0; i--) {

                if (available.contains(i) && genome.charAt(i) == mutation) {
                    //log(n)
                    Integer next = available.lower(i);
                    if (next != null) {
                        nothingRemoved = false;
                        available.remove(next);
                    }
                }
            }

            if (nothingRemoved) {
                break;
            }
            time++;
        }

        return time;
    }

    //TODO: try it
//    class DisjointSet {
//
//        int[] parent;
//        int[] rank;
//        boolean[] available;
//
//        public DisjointSet(int n, boolean[] available) {
//            parent = new int[n];
//            rank = new int[n];
//            this.available = available;
//
//            for (int i = 0; i < n; i++) {
//                parent[i] = i;
//            }
//        }
//
//        int find(int x) {
//            if (x == parent[x] && available[x]) return x;
//            return parent[x] = find(parent[x]); //updating as dp instead of going all the way up every time
//        }
//
//        public boolean union(int a, int b) {
//            int parentA = find(a);
//            int parentB = find(b);
//
//            if (parentA == parentB) {
//                return false;
//            }
//
//            if (rank[parentA] < rank[parentB]) {
//                parent[parentA] = parentB;
//            } else if (rank[parentA] > rank[parentB]) {
//                parent[parentB] = parentA;
//            } else {
//                parent[parentB] = parentA;
//                rank[parentA]++;
//            }
//
//            parent[parentA] = parentB;
//
//            return true;
//        }
//
//    }

}

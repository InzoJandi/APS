/*
  * BAEKJOON ONLINE JUDGE
  * https://www.acmicpc.net
  * Problem Number: 1654
  */

 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.List;
 import java.util.Scanner;

 public class LanCableCut {

     public static void main(String[] args) throws IOException {
         Scanner scanner = new Scanner(System.in);
         int length = scanner.nextInt();
         int target = scanner.nextInt();

         List<Long> cableList = new ArrayList<>();
         for (int i = 0; i < length; i++) cableList.add(scanner.nextLong());

         Collections.sort(cableList);
         List<Long> result = binarySearch(cableList, target);
         System.out.println(Collections.max(result));
     }

     private static List<Long> binarySearch(List<Long> cableList, int target) {
         List<Long> resultList = new ArrayList<>();
         Long max = Collections.max(cableList);
         Long min = 1L;
         Long mid;

         while (min <= max) {
             mid = (min + max) / 2;
             Integer count = getCount(cableList, mid);
             if (target <= count) {
                 resultList.add(mid);
                 min = mid + 1;
             } else {
                 max = mid - 1;
             }
         }

         return resultList;
     }

     private static Integer getCount(List<Long> list, long length) {
         int count = 0;
         for (Long number : list) count += number / length;
         return count;
     }
 }

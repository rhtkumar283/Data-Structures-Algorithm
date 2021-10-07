import java.util.*;

public class HashMapPractice{
  public static void main(String[] args){
    int[] arr = {4,3,4,4,2,4};
    //System.out.println(minDelete().hMap.entrySet());
    System.out.println(minDelete(arr));
  }

  public static int minDelete(int[] array){
    HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();

    for(int i = 0; i < array.length; i++){
      hMap.put(array[i], hMap.getOrDefault(array[i], 0)+1);
    }
    int max = Integer.MIN_VALUE;
    for(Map.Entry<Integer, Integer> entry : hMap.entrySet() ) {
      max = Math.max(max , entry.getValue());
    }
    return array.length - max;
  }
}

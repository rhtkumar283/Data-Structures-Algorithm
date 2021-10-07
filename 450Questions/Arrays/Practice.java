import java.util.*;

public class Practice{

  public static void main(String[] args){
    int[] arr = {1, 0};
    // int[] res = reverse(arr);
    //
    // for(int i = 0; i < res.length; i++)
    //   System.out.print(res[i] + ", ");
    // getMinMax(arr);
    //System.out.println(kthSmallest(arr, 5));
    sort012(arr);
  }

  //Write a program to reverse an array or string
  public static int[] reverse(int[] arr){
    int start = 0;
    int end = arr.length - 1;
    int temp = 0;

    while(start < end){
      temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
    return arr;
  }

  //Maximum and minimum of an array using minimum number of comparisons
  public static void getMinMax(int[] arr){
    int min, max;
    min = (arr[0] > arr[1]) ? arr[1] : arr[0];
    max = (min == arr[0]) ? arr[1] : arr[0];

    for(int i = 2; i < arr.length; i++){
      if(arr[i] > max) max = arr[i];
      else if(arr[i] < min) min = arr[i];
    }
    System.out.println("Max: "+ max+ " Min: " + min);
  }

  //K’th Smallest/Largest Element in Unsorted Array with Distinct element
  public static int kthSmallest(int[] arr, int k){
    TreeMap<Integer, Integer> tree = new TreeMap<>();
    int count = 0;
    for(int i : arr)
      tree.put(i, tree.getOrDefault(i,0) +1);

    for(Map.Entry m : tree.entrySet()){
      count += (int)m.getValue();
      if(count == k)
        return (int)m.getKey();
    }
    return -1;
  }

  //Given an array of size N containing only 0s, 1s, and 2s;
  //sort the array in ascending order.
  public static void sort012(int[] arr){
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for(int i : arr)
      map.put(i, map.getOrDefault(i, 0) +1);
    int l = 0;
    int m = 0;
    for(int i = 0; i < map.size(); i++){
      for(int j = 0; j < map.get(i); j++){
        arr[l++] = i;
      }
    }
    for(int k = 0; k < arr.length; k++)
        System.out.print(arr[k]+" ");
  }
}

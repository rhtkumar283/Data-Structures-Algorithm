public class Sorting{

  public static void main(String[] args){
    int[] array = {334, 212, 657, 100, 423, 105};

    Sorting sort = new Sorting();
    // sort.bubbleSort(array);
    // System.out.println();
    // sort.bubbleSortModified(array);
    //sort.selectionSort2(array);
    sort.insertionSort(array);

  }

  public static void printArray(int[] array){
    for(int i = 0; i < array.length; i++)
      System.out.print(array[i]+ " ");
  }

//=======BUBBLE SORT=========//
//O(n2) : Even in best case.
  public void bubbleSort(int[] array){
    int temp;
    for(int pass = array.length -1; pass >= 0; pass--){
      for(int i = 0; i < pass; i++){
        if(array[i] > array[i+1]){
          temp = array[i];
          array[i] = array[i+1];
          array[i+1] = temp;
        }
      }
    }
    printArray(array);
  }

//Modified by adding a flag swapped which indicate if no more swaps then list is already
//sorted and can skip the remaining passes.
//Complexity improves to O(n) : for best case;
  public void bubbleSortModified(int[] array){
    int temp;
    boolean swapped = true;
    for(int pass = array.length -1; pass >= 0 && swapped; pass--){
      swapped = false;
      for(int i = 0; i < pass; i++){
        if(array[i] > array[i+1]){
          temp = array[i];
          array[i] = array[i+1];
          array[i+1] = temp;
          swapped = true;
        }
      }
    }
    printArray(array);
  }

//=======SELECTION SORT=========//
  public void selectionSort(int[] array){
    int min, temp;
    int flag = 0;

    for(int i = 0; i < array.length; i++){
      min = i;
      flag = 0;
      for(int j = i+1; j < array.length; j++){
        if(array[j] < array[min])
          min = j;
          flag = 1;
      }
      if(flag == 1){
      temp = array[min];
      array[min] = array[i];
      array[i] = temp;
      } else continue;
    }
    printArray(array);
  }

  //Selection sort: 2nd Method
  public void selectionSort2(int[] arr){
    int min, temp;

    for(int i = 0; i < arr.length-1; i++){
      min = i;
      for(int j = i+1; j < arr.length; j++){
        if(arr[min] > arr[j]) min = j;
      }
      temp = arr[min];
      arr[min] = arr[i];
      arr[i] = temp;
    }
    printArray(arr);
  }

  //===========INSERTION SORT==============//
  //[334, 212, 657, 100, 423, 105]
  public void insertionSort(int[] arr){
    int key = 0;
    //int temp = 0;
    for(int i = 1; i < arr.length; i++){
      key = arr[i];
      int j = i;
      while(j >= 1 && arr[j-1] > key){
          arr[j] = arr[j-1];
          j--;
      }
      arr[j] = key;
      // printArray(arr);
      // System.out.println();
    }
    printArray(arr);
  }

  //=========MERGE SORT===========//




}

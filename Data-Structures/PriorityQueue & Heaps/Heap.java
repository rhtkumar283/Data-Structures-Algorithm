public class Heap{
  public int[] array;
  public int count;
  public int capacity;
  public String heap_type;

  public Heap(int capacity, String heap_type){
    this.count = 0;
    this.capacity = capacity;
    this.array = new int[capacity];
    this.heap_type = heap_type;
  }

  //For node at ith location its parent will be located at i-1/2:
  public int parent(int i){
    if(i > count || i <= 0) return -1;
    return i-1 / 2;
  }

  public void heapType(){
    System.out.println(heap_type);
  }

  //For a node at ith location its children will be located at 2*i+1(left)
  //and 2*i+2(right):
  public int leftChild(int i){
    if(i >= this.count) return -1;
    int left = 2* i+1;
    return left;
  }
  public int rightChild(int i){
    if(i >= this.count) return -1;
    int right = 2* i+2;
    return right;
  }

  //For max heap the maximum element is at the root itself:
  public int getMaximum(){
    if(this.count == 0) return -1;
    return this.array[0];
  }

  //Heapifying an Element:
  public void percolateDown(int i){
    int left, right, max,temp;
    left = leftChild(i);
    right = rightChild(i);

    if(left != -1 && this.array[left] > this.array[i])
        max = left;
      else max = i;
      if(right != -1 && this.array[right] > this.array[max])
        max = right;
      if(max != i){
        temp = this.array[i];
        this.array[i] = this.array[max];
        this.array[max] = temp;
      }else return;
      percolateDown(max);
}

  //Delete from max heap:
  public void deleteMax(){
    if(count == 0) return;
    //int data  = this.array[0];
    this.array[0] = this.array[count -1];
    count--;
    percolateDown(0);
    //return data;
  }

  //Inserting in heap;
  public void insert(int data){
    int i;
      if(this.count == this.capacity)
        resizeHeap();
      if(count == 0){
        this.array[0] = data;
        count++;
        return;
      }
      this.count++;
      i = this.count -1;
      while(i > 0 && data > this.array[(i-1)/2]){
        this.array[i] = this.array[(i-1)/2];
        i = (i-1)/2;
      }
      this.array[i] = data;
  }
  public void resizeHeap(){
    System.out.println("RHT");
    int[] new_array = new int[this.capacity * 2];
    System.arraycopy(this.array, 0, new_array,0, this.count);
    this.array = new_array;
    this.capacity = capacity * 2;
  }

  void destroyHeap(){
    this.count = 0;
    this.array = null;
  }

  void printHeap(){
    if(count == 0) System.out.println("Heap is empty!");
    for(int i = 0; i < count; i++){
      System.out.print(array[i]+" ");
    }
  }

  public static void main(String[] args){
    Heap heap = new Heap(5, "MaxHeap");
    heap.heapType();
    heap.insert(10);
    heap.insert(20);
    heap.insert(30);
    heap.insert(40);
    heap.insert(25);
    heap.insert(100);
    heap.insert(25);
    heap.insert(100);

    // while(heap.count > 0){
    //   heap.deleteMax();
    //   heap.count--;
    // }

    heap.printHeap();
  }

}

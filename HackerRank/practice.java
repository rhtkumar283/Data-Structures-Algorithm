public class practice{
    public static void main(String[] args) {
        int[] array = {32,56,112,9,76,100};
        // Sum obj = new Sum();
        // int res = obj.sumArr(array);
        // System.out.println(res);

        // RightRotateArray obj = new RightRotateArray();
        // obj.rightRotate(3, array);

        LeftRotateArray obj = new LeftRotateArray();
        obj.leftRotate(3, array);
        
    }
}

class Sum{
    public int sumArr(int[] arr){
        int min =arr[0];
        for(int i = 1; i < arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}

//Right Rotating array
class RightRotateArray{
    void rightRotate(int n, int[] arr){
        System.out.print("Array before rotating: ");
        for(int t : arr){
            System.out.print(t + " ");
        }
        System.out.println();

        for(int i =0; i< n;i++){
            int j, last;
            last = arr[arr.length -1];

            for(j = arr.length-1; j > 0; j--){
                arr[j] = arr[j-1];
            }
            arr[0] = last;
        }
        System.out.print("Array after rotating: ");
        for(int t : arr){
            System.out.print( t + " ");
        }
    }
}

//Left rotating array:
class LeftRotateArray{
    void leftRotate(int n, int[] arr){
        System.out.print("Array before rotating: ");
        for(int t : arr){
            System.out.print(t + " ");
        }
        System.out.println();

        for(int i =0; i< n;i++){
            int j;
            int first = arr[0];
            //first = arr[0];
            int last = arr.length-1;

            for(j = 0; j < arr.length-1; j++){
                arr[j] = arr[j+1];
            }
            arr[last] = first;
        }
        System.out.print("Array after rotating: ");
        for(int t : arr){
            System.out.print( t + " ");
        }
    }
}
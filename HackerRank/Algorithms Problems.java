//SubArray Division
public static int birthday(List<Integer> s, int d, int m) {
int res = 0;

for(int i =0; i < s.size()-(m-1); i++){
    if(m == 1){
        if(s.get(i) == d){
            res += 1;
            continue;
        }else return 0;
    }else{
    int temp = 0;
    int j = i+1;
    while(j < m+i){
        temp = temp + s.get(j);
        j++;
    }
    if(s.get(i) + temp == d){
        res += 1;
    }
    else continue;
    }
}
return res;
}
}

//===========================//

//Divisible sum pairs:
public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
    int res = 0;

    for(int i = 0; i < ar.size() - 1; i++){
        for(int j = i+1; j < ar.size(); j++){
            if((ar.get(i) + ar.get(j)) % k == 0){
                res += 1;
                continue;
            }
            continue;
        }
    }
    return res;

    }

//===========================//

//Migratory Birds:
public static int migratoryBirds(List<Integer> arr) {
    int type1 = 0;
    int type2 = 0;
    int type3 = 0;
    int type4 = 0;
    int type5 = 0;
    int duplicate = 0;

    for(int i = 0; i< arr.size(); i++){
        int a = arr.get(i);
        switch(a){
            case 1:
                type1 += 1;
                break;
            case 2:
                type2 += 1;
                break;
            case 3:
                type3 += 1;
                break;
            case 4:
                type4 += 1;
                break;
            case 5:
                type5 += 1;
                break;
            default:
                continue;
        }
    }
    int[] temp = {type1, type2, type3, type4, type5};
    int max = 0;
    for(int j = 0; j < temp.length -1; j++){
      if(temp[max] < temp[j+1])
        max = j+1;
    }
    return max+1;
    }

//====================================//

//Sales By Match:

public static int sockMerchant(int n, List<Integer> ar) {

int result = 0;
boolean[] visited = new boolean[ar.size()];
Arrays.fill(visited, false);

for(int i = 0; i < ar.size(); i++){
    if(visited[i] == true){
        continue;
    }
    int count = 1;
    for(int j = i+1; j < ar.size(); j++){
        if(ar.get(i) == ar.get(j)){
            visited[j] = true;
            count += 1;
        }
    }
    int pairs = count / 2;
    result += pairs;
    }
    return result;
}

//=====================================//

//

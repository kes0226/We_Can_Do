import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i, j ,value= 0;
        int[] num = new int[n];
        int[] Sorted = new int[n];
        for (i = 0; i < n; i++) {
            value = Integer.parseInt(st.nextToken());
            num[i] = value;
            Sorted[i] = value;
        }

        //Sorted 정렬
        int temp=0;
        int min = 0;
        for(i=0;i<n-1;i++){
            min=i;
            for(j=i+1; j<n;j++){
                if(Sorted[j]<Sorted[i])
                    min=j;
            }
            temp = Sorted[i];
            Sorted[i] = Sorted[min];
            Sorted[min] = temp;
        }

        //중복되는 것 없이 해쉬맵 저장
        HashMap<Integer, Integer> number = new HashMap<Integer, Integer>();
        int z = 0;
        for(i=0;i<n;i++){
            if(!number.containsKey(Sorted[i])){
                number.put(Sorted[i], z);
                z++;
            }
        }

        for(i=0;i<n;i++){
            num[i] = number.get(num[i]);
        }


        // 정수 배열 출력 (테스트용)
        System.out.println("입력된 정수:");
        for (i=0;i<n;i++) {
            System.out.println(num[i]);
        }

    }
}
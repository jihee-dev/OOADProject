import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        char[] carr = br.readLine().toCharArray();
        Arrays.sort(carr);
        String answer = "";
        for(int i=carr.length-1;-1<i;i--){
            answer+=Character.toString(carr[i]);
            if(K==answer.length()){
                break;
            }
        }
        System.out.println("this is carr => " + Arrays.toString(carr));
        // System.out.println("this is arr => " + Arrays.toString(arr));

        System.out.println("ddd");
        System.out.println(answer);
    }
}





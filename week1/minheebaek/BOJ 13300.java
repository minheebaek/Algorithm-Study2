import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int k=scan.nextInt();

        int[][] school=new int[6][2];

        for(int i=0;i<n;i++){
            int s=scan.nextInt();
            int y=scan.nextInt();

            school[y-1][s]+=1;
        }
        int ans=0;
        for(int i=0;i<6;i++){
            for(int j=0;j<2;j++){
                ans+=school[i][j]/k;
                if(school[i][j]%k>0){
                    ans+=1;
                }
            }
        }
        System.out.println(ans);
    }
}
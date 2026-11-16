import java.util.Arrays;
import java.util.Random;

public class mazegen {
    int[][] arr;
    int floor=0;
    int wall=1;
    int rows;
    int cols;
    public mazegen(int r, int c){
        rows=r;
        cols=c;
        arr=new int[rows][cols];
    }
    public void print(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public int[][] generate(){
        for (int i = 0; i < arr.length; i++) {
            arr[i][0]=1;
            arr[i][arr[0].length-1]=1;
        }
        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i]=1;
            arr[arr.length-1][i]=1;
        }
        recur(rows-1,0,0,cols-1);
        return arr;
    }
    public void recur(int top,int   bottom, int left, int right){
        int start_range=bottom+2;
        int end_range=top-1;
        int y=start_range+2*(int)(Math.random()*((end_range-start_range+1)/2));
        for(int i=left+1;i<right;i++){
            arr[y][i]=1;
        }
        start_range=left+2;
        end_range=right-1;
        int x=start_range+2*(int)(Math.random()*((end_range-start_range+1)/2));
        for (int i = bottom+1; i < top; i++) {
            arr[i][x]=1;
        }
        int wall =(int) (Math.random()*4);
        if(wall!=0){
            int gap=left+1+2*(int)(Math.random()*((x-left)/2));
            arr[y][gap]=0;
        }
        if(wall!=1){
            int gap=x+1+2*(int)(Math.random()*((right-x)/2));
            arr[y][gap]=0;
        }
        if(wall!=2){
            int gap=bottom+1+2*(int)(Math.random()*((y-bottom)/2));
            arr[gap][x]=0;
        }
        if(wall!=3){
            int gap=y+1+2*(int)(Math.random()*((top-y)/2));
            arr[gap][x]=0;
        }
        if(top>y+3 && x>left+3){
            recur(top,y,left,x);
        }
        if(top>y+3 && x+3<right){
            recur(top,y,x,right);
        }
        if(bottom+3<y && x+3<right){
            recur(y,bottom,x,right);
        }
        if(bottom+3<y && x>left+3){
            recur(y,bottom,left,x);
        }
    }
    public static void main(String[] args) {
        mazegen a= new mazegen(40,70);
        a.generate();
        a.print();
    }
}

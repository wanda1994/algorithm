import java.util.ArrayList;

public class question {

	public static void main(String[] args) {
        ArrayList<String> strs= new ArrayList<>();
        for (int i = 0; i < 41; i++) {
            strs.add((i + 1)+"");
        }
        get(strs,3);
    }
 
    public static void get(ArrayList<String>strs, int n) {
        int i=0;
        while (strs.size() > 1) {
            if(n==i+1){//数到n的数字移出去
                i=0;//重新开始数
                System.out.println(strs.remove(i));
            }
            strs.add(strs.remove(0));//把第一个移动到最后一个
            i++;
        }
        System.out.println(strs.remove(0));//输出最后一个数字
    }
}

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
            if(n==i+1){//����n�������Ƴ�ȥ
                i=0;//���¿�ʼ��
                System.out.println(strs.remove(i));
            }
            strs.add(strs.remove(0));//�ѵ�һ���ƶ������һ��
            i++;
        }
        System.out.println(strs.remove(0));//������һ������
    }
}

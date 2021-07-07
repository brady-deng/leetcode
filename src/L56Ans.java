import java.util.ArrayList;
import java.util.List;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/7
 **/
public class L56Ans {
    public int[][] mergeInter(int[][] intervals) {
        int[] start = new int[10001];
        int[] end = new int[10001];
        int max = 0;
        for(int[] interval: intervals){
            start[interval[0]]++;
            end[interval[1]]++;
            max = Math.max(max,interval[1]);
        }
        List<int[]> list = new ArrayList();
        int sum = 0;
        for(int i = 0; i <= max; i++){
            if(start[i] > 0){
                int[] temp = new int[2];
                temp[0] = i;
                while(true){
                    sum += start[i];
                    sum -= end[i];
                    if(sum == 0)
                        break;
                    i++;
                }
                temp[1] = i;
                list.add(temp);
            }
        }
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}

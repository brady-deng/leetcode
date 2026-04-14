package main.java.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.java.lc.util.LUtil;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/22
 * 恶魔们抓住了公主并将她关在了地下城 dungeon 的 右下角 。地下城是由 m x n 个房间组成的二维网格。我们英勇的骑士最初被安置在 左上角 的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。

骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。

有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。

为了尽快解救公主，骑士决定每次只 向右 或 向下 移动一步。

返回确保骑士能够拯救到公主所需的最低初始健康点数。

注意：任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。

 

示例 1：


输入：dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
输出：7
解释：如果骑士遵循最佳路径：右 -> 右 -> 下 -> 下 ，则骑士的初始健康点数至少为 7 。
示例 2：

输入：dungeon = [[0]]
输出：1


failed on 
[[1,-3,3],[0,-2,0],[-3,-3,-3]]
expected
3
incr方法需要修改，考虑全局最优
 

提示：

m == dungeon.length
n == dungeon[i].length
1 <= m, n <= 200
-1000 <= dungeon[i][j] <= 1000
 **/
public class L174 {

    public static void main(String[] args) {
        int[][] nums = LUtil.inputArray2();
        System.out.println(new L174().solution(nums));
    }

    public int solution(int[][] dungeon) {
        Hp[][] temp = initHp(dungeon);
        return temp[0][0].before;
    }

    public Hp[][] initHp(int[][] dungeon) {
        Hp[][] temp = new Hp[dungeon.length][dungeon[0].length];
        temp[temp.length-1][temp[0].length-1] = new Hp();
        temp[temp.length-1][temp[0].length-1].after = Math.max(0, dungeon[temp.length-1][temp[0].length-1]) + 1;
        temp[temp.length-1][temp[0].length-1].before = dungeon[temp.length-1][temp[0].length-1] < 0 ? 1-dungeon[temp.length-1][temp[0].length-1] : 1;
        for (int i = temp.length-1; i >= 0; i--) {
            for (int j = temp[0].length-1; j >= 0; j--) {
                calculateMinimumHP(dungeon, temp, i, j);
            }
        }
        return temp;
    }

    public void calculateMinimumHP(int[][] dungeon, Hp[][] hp, int i, int j) {
        if (i == dungeon.length-1 && j == dungeon[0].length-1) {
            return;
        } else {
            hp[i][j] = new Hp();
            if (i == dungeon.length-1) {
                hp[i][j].after = hp[i][j+1].before;
            } else if (j == dungeon[0].length-1) {
                hp[i][j].after = hp[i+1][j].before;
            } else if (i < dungeon.length-1 && j < dungeon[0].length-1) {
                hp[i][j].after = Math.min(hp[i+1][j].before, hp[i][j+1].before);
            }
        }
        hp[i][j].before = dungeon[i][j] < 0 ? hp[i][j].after-dungeon[i][j] : Math.max(1, hp[i][j].after-dungeon[i][j]);
        return;
    }





    public class Hp {
        int before;
        int after;

        public Hp (int before, int after) {
            this.before = before;
            this.after = after;
        }

        public Hp () {
            this(0, 0);
        }




    }


}

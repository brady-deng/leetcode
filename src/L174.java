import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/22
 **/
public class L174 {

    public static void main(String[] args) {
        System.out.println("Please input the num n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Please input the num m:");
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        scanner.nextLine();
        for (int i = 0; i<n;i++) {
            System.out.println("Please input the nums:");
            nums[i] = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(calculateMinimumHP(nums));
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        Hp[][] res = new Hp[m][n];
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (i == 0 && j == 0) {
                    if (dungeon[i][j] <= 0) {
                        res[i][j] = new Hp(dungeon[i][j],dungeon[i][j]);
                    }
                    else {
                        res[i][j] = new Hp(1+dungeon[i][j],1+dungeon[i][j]);
                    }
                }
                else {
                    if (i > 0 && j > 0) {
                        res[i][j] = new Hp();
                        if (dungeon[i][j] >= 0) {
                            if (Math.max(res[i-1][j].getL(), res[i][j-1].getL()) >= 0) {
                                res[i][j].setL(Math.max(res[i-1][j].getL(), res[i][j-1].getL())+dungeon[i][j]);
                            }
                            else {
                                res[i][j].setL(Math.max(res[i-1][j].getL(), res[i][j-1].getL()));
                            }
                            res[i][j].setH(Math.max(res[i-1][j].getH(), res[i][j-1].getH()) + dungeon[i][j]);
                        }
                        else {
                            int tmp1 = res[i-1][j].getL() > res[i][j-1].getL()? res[i-1][j].getH() + dungeon[i][j]: res[i][j-1].getH() + dungeon[i][j];
                            int tmp2 = res[i-1][j].getL() > res[i][j-1].getL()? res[i-1][j].getL():res[i][j-1].getH();
                            if (tmp1 > tmp2) {
                                res[i][j].setL(tmp2+dungeon[i][j]);
                                if (res[i-1][j].getL() > res[i][j-1].getL()) {
                                    res[i][j].setH(res[i-1][j].getH() + dungeon[i][j]);
                                }
                                else {
                                    res[i][j].setH(res[i][j-1].getH() + dungeon[i][j]);
                                }
                            }
                            else {
                                res[i][j].setL(
                                        Math.max(tmp1, tmp2+dungeon[i][j])
                                );
                                if (res[i-1][j].getL() > res[i][j-1].getL()) {
                                    res[i][j].setH(res[i-1][j].getH() + dungeon[i][j]);
                                }
                                else {
                                    res[i][j].setH(res[i][j-1].getH() + dungeon[i][j]);
                                }
                            }

                        }
                        if (res[i][j].getL() == 0) res[i][j].setL(-1);
                    }
                    else if (i > 0) {
                        res[i][j] = new Hp();
                        if (dungeon[i][j] >= 0) {
                            if (res[i-1][j].getL()>=0) {
                                res[i][j].setL(res[i-1][j].getL()+dungeon[i][j]);
                            }
                            else {
                                res[i][j].setL(res[i-1][j].getL());
                            }
                            res[i][j].setH(res[i-1][j].getH() + dungeon[i][j]);
                        }
                        else {
                            int tmp1 = res[i-1][j].getH() + dungeon[i][j];
                            int tmp2 = res[i-1][j].getL();
                            if (tmp1 > tmp2) {
                                res[i][j].setL(tmp2+dungeon[i][j]);
                            }
                            else {
                                res[i][j].setL(
                                        Math.max(
                                                tmp2+dungeon[i][j], tmp1
                                        )
                                );
                            }
                            res[i][j].setH(res[i-1][j].getH() + dungeon[i][j]);
                        }
                        if (res[i][j].getL() == 0) res[i][j].setL(-1);
                    }
                    else {
                        res[i][j] = new Hp();
                        if (dungeon[i][j] >= 0) {
                            if (res[i][j-1].getL() >= 0) {
                                res[i][j].setL(res[i][j-1].getL()+dungeon[i][j]);
                            }
                            else {
                                res[i][j].setL(res[i][j-1].getL());
                            }
                            res[i][j].setH(res[i][j-1].getH() + dungeon[i][j]);
                        }
                        else {
                            int tmp1 = res[i][j-1].getH() + dungeon[i][j];
                            int tmp2 = res[i][j-1].getL();
                            if (tmp1 > tmp2) {
                                res[i][j].setL(tmp2 + dungeon[i][j]);
                            }
                            else {
                                res[i][j].setL(
                                        Math.max(
                                               tmp2+dungeon[i][j], tmp1
                                        )
                                );
                            }
                            res[i][j].setH(res[i][j-1].getH() + dungeon[i][j]);
                        }
                        if (res[i][j].getL() == 0) res[i][j].setL(-1);
                    }
                }
            }
        }

        return res[m-1][n-1].getL() >= 0?1:(dungeon[0][0]==-res[m-1][n-1].getL() || dungeon[0][0] == 0)?-res[m-1][n-1].getL()+2:-res[m-1][n-1].getL()+1;
    }


    public static class Hp {
        int l;
        int h;

        public Hp() {
        }

        public Hp(int l, int h) {
            this.l = l;
            this.h = h;
        }

        public void setL(int l) {
            this.l = l;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getL() {
            return l;
        }

        public int getH() {
            return h;
        }
    }
}

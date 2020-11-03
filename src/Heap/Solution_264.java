package Heap;
/*
264. 丑数 II medium 6 15
编写一个程序，找出第 n 个丑数。

丑数就是质因数只包含 2, 3, 5 的正整数。

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:

1 是丑数。
n 不超过1690。
class Ugly {
  public int[] nums = new int[1690];
  Ugly() {
    HashSet<Long> seen = new HashSet();
    PriorityQueue<Long> heap = new PriorityQueue<Long>();
    seen.add(1L);
    heap.add(1L);

    long currUgly, newUgly;
    int[] primes = new int[]{2, 3, 5};
    for(int i = 0; i < 1690; ++i) {
      currUgly = heap.poll();
      nums[i] = (int)currUgly;
      for(int j : primes) {
        newUgly = currUgly * j;
        if (!seen.contains(newUgly)) {
          seen.add(newUgly);
          heap.add(newUgly);
        }
      }
    }
  }
}

class Solution {
  public static Ugly u = new Ugly();
  public int nthUglyNumber(int n) {
    return u.nums[n - 1];
  }
}


 */
import java.util.HashSet;
import java.util.PriorityQueue;


class ugly{
        public long result[] = new long[1690];
        long cur_n,nex_n;
        public ugly(){
        HashSet<Long> hs = new HashSet<Long>();
        PriorityQueue<Long> minh = new PriorityQueue<Long>();
        int a[] = {2,3,5};
        hs.add(1l);
        minh.add(1l);
            for(int i=0;i<1690;i++){
                cur_n = minh.poll();
                result[i] = cur_n;
                for(int j=0;j<3;j++){
                    nex_n = cur_n * a[j];
                    if(!hs.contains(nex_n)){
                        hs.add(nex_n);
                        minh.add(nex_n);
                    }
                }
            }

        }
}


public class Solution_264 {
    ugly f_r = new ugly();
    public int nthUglyNumber(int n) {
        return (int)f_r.result[n-1];
    }

    public static void main(String[] args) {
        Solution_264 test = new Solution_264();
        System.out.println(test.nthUglyNumber(1407));
    }
}

package pkg774c;

import java.util.*;

public class Main
{
    static Scanner sc = new Scanner(System.in); static int min(int x, int y){return Math.min(x, y);}
    static int TEN(int x){if(x==0) return 1; return 10*TEN(x-1);} static int INF = TEN(9)+9;
    static int max(int x, int y){return Math.max(x, y);} static int abs(int x){return Math.abs(x);}
    static boolean Check(int N, int pos){ int x = (N&(1<<pos)); if(x>0) return true; return false;}
    static int Set(int N, int pos){return N|(1<<pos);} static int Toggle(int N, int pos){return N^(1<<pos);}
    static int Off(int N, int pos){if(Check(N,pos)==false) return N; return Toggle(N,pos);}
    static int in(){int a = sc.nextInt(); return a;} static void println(int n){System.out.println(n);}
    static void print(int n){System.out.print(n);} static void print(char c){System.out.print(c);}
    static void print(int arr[]){for(int a: arr) System.out.print(a + " "); System.out.println();}
    
    static ArrayList<Long>facts = new ArrayList<Long>();
    static ArrayList<Long>sums = new ArrayList<Long>();
    static long n;
    
    static int Cnt(Long x)
    {
        int ret = 0;
        while(x>0)
        {
            if(x%2==1) ret++;
            x/=2;
        }
        
        return ret;
    }
    
    static void Solve()
    {
        long i, j, k, l, m, x, y, w, p, q, t;
        
        n = sc.nextLong(); long ans = 1000000;
        int sz = facts.size();
        for(int mask=0; mask<(1<<sz); mask++)
        {
            long sum = 0, cnt = 0;
            for(i=0; i<sz; i++)
            {
                if((mask&(1<<i))>0){
                    sum = sum+facts.get((int)i); cnt++;
                }
            }
            if(sum<=n)ans = Math.min(ans, cnt+Cnt(n-sum));
        }
        
        
        System.out.println(ans);
    }
    
    public static void main(String []args)
    {
        int tc = sc.nextInt();int i, j; 
        facts.add((long)6);
        for(i=4, j=1; i<=15 ; i++, j++)
        {
            facts.add(facts.get(j-1)*i);
        }
        //System.out.println(facts.get(i-1));
        while(tc-->0)
        {
            Solve();
        }
    }
}

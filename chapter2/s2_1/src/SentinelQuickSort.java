import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-9
 * Time: 下午7:30
 * To change this template use File | Settings | File Templates.
 */
public class SentinelQuickSort {
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        int maxi = 0;
        for(int i = 0; i < a.length; ++i)
            if(less(a[maxi], a[i]))
                maxi = i;
        exch(a, maxi, a.length - 1);
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo) return;
        int j = parition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    private static int parition(Comparable[] a, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while(i < j)
        {
            while(less(a[++i], v));    //不用考虑i溢出,导致a[i]错误
            while(less(v, a[--j]));
            if(i < j)
                exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b)  < 0;
    }
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static void show(Comparable[] a)
    {
        StdOut.println(Arrays.toString(a));
    }
    private static boolean isSorted(Comparable[] a)
    {
        for(int i = 1; i < a.length; ++i)
        {
            if(less(a[i], a[i - 1])) return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        String s = StdIn.readLine();
        String[] ss = s.split(" ");
        StdRandom.shuffle(ss);
        show(ss);
        sort(ss);
        assert isSorted(ss);
        show(ss);
    }
}

package csd;

import com.sun.org.apache.xerces.internal.util.FeatureState;
import java.util.Arrays;
import java.util.Random;

class Array {

    int[] a;
    int[] temp;
    int n;

    public Array(int seed, int minSize, int maxSize, int minVal, int maxVal) {
        Random rnd;
        if (seed < 0) {
            rnd = new Random();
        } else {
            rnd = new Random(seed);
        }
        n = minSize + rnd.nextInt(maxSize - minSize + 1);
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = minVal + rnd.nextInt(maxVal - minVal + 1);
        }
    }

    void disp() {
        System.out.println(n + " " + Arrays.toString(a));
    }

    void swap(int i, int j) {
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }

    void makeCopy() {
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
    }

    void reArray() {
        for (int i = 0; i < n; i++) {
            a[i] = temp[i];
        }
    }

    boolean increase() {
        for (int i = 0; i <= n - 2; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    void shellSort() {
        makeCopy();
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = a[i];
                int j;
                for (j = i; j >= gap && a[j - gap] > temp; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
    }

    void shakerSort() {
        boolean swapped = true;
        int start = 0;
        int end = a.length;
        while (swapped == true) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }

    void select() {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }

    void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int moc = a[(left + right) / 2];
        int i = left, j = right;
        do {
            while (a[i] < moc) {
                i++;
            }
            while (a[j] > moc) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        } while (i <= j);
        quickSort(left, j);
        quickSort(i, right);
    }

    void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeSort(int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l, m, r);
        }
    }
    
    int getMax(int n)
    {
        int mx = a[0];
        for (int i = 1; i < n; i++)
            if (a[i] > mx)
                mx = a[i];
        return mx;
    }

    void countSort(int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++)
            count[(a[i] / exp) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--) {
            output[count[(a[i] / exp) % 10] - 1] = a[i];
            count[(a[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
            a[i] = output[i];
    }
    
    void radixSort(int n)
    {
        int m = getMax(n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(n, exp);
    }

}

public class CSD4 {

    public static void main(String[] args) {
        Array a = new Array(100, 5, 20, 10, 99);
        if (a.increase() == false) {
            System.out.println("Not increase");
        }
        a.disp();
        long start = System.currentTimeMillis();
        a.shellSort();
        System.out.println("Shell sort: ");
        if (a.increase()) {
            System.out.println("Increase");
        } else {
            System.out.println("Not Increase");
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Time for sorting: " + time + "ms");
        a.disp();
        a.reArray();

        a.shakerSort();
        System.out.println("Shaker sort: ");
        if (a.increase()) {
            System.out.println("Increase");
        } else {
            System.out.println("Not Increase");
        }
        a.disp();
        a.reArray();

        a.select();
        System.out.println("Selection sort: ");
        if (a.increase()) {
            System.out.println("Increase");
        } else {
            System.out.println("Not Increase");
        }
        a.disp();
        a.reArray();

        a.quickSort(0, a.n - 1);
        System.out.println("Quick sort: ");
        if (a.increase()) {
            System.out.println("Increase");
        } else {
            System.out.println("Not Increase");
        }
        a.disp();
        a.reArray();

        a.mergeSort(0, a.n - 1);
        System.out.println("Merge sort: ");
        if (a.increase()) {
            System.out.println("Increase");
        } else {
            System.out.println("Not Increase");
        }
        a.disp();
        a.reArray();
        
        a.radixSort(a.n);
        System.out.println("Radix sort: ");
        if (a.increase()) {
            System.out.println("Increase");
        } else {
            System.out.println("Not Increase");
        }
        a.disp();
        a.reArray();
    }
}

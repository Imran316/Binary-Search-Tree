package com.imran;

public class QuickSort extends Thread{
    private int[] nums;
    private int left,right;
    private int noOfThreads;

    public QuickSort(int[] nums,int left,int right,int noOfThreads) {
        this.nums = nums;
        this.left=left;
        this.right=right;
        this.noOfThreads = noOfThreads;
    }

    @Override
    public void run() {
        quickSortThreaded(nums,left,right,noOfThreads);
    }

    public void quickSortThreaded() {
        quickSortThreaded(nums,left,right,noOfThreads);
    }

    private void quickSortThreaded(int[] nums,int left,int right,int noOfThreads) {
        if(left>=right) return;
        if(noOfThreads <= 1) {
            quickSort();
            return;
        }
        int j = partition(nums,left,right);
        QuickSort t1 = new QuickSort(nums,left,j-1,(noOfThreads>>1));
        QuickSort t2 = new QuickSort(nums,j+1,right,(noOfThreads>>1));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void quickSort() {
        quickSort(this.nums,this.left,this.right);
    }

    private void quickSort(int[] nums,int left,int right) {
        if (left >= right) return;
        int j = partition(nums, left, right);
        quickSort(nums,left,j-1);
        quickSort(nums,j+1,right);
    }

    private int partition(int[] nums, int left, int right) {
        int j=left-1;
        for(int i=left;i<right;i++) {
            if(nums[i] < nums[right]) {
                j++;
                swap(nums, i, j);
            }
        }
        j++;
        swap(nums,j,right);
        return j;
    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void printArray() {
        for(int i=0;i<N;i++)
            System.out.print(String.format("%d ",nums[i]));
        System.out.println("");
    }

    private static int noOfThreadsAvailable = 8;
    private static int N = 10000000;
    private static int maxCap = 1000;

    public static void main(String[] args) {
        int[] nums = new int[N];
        for(int i=0;i<N;i++)
            nums[i] = (int) (Math.random() * maxCap);

        QuickSort quickSort = new QuickSort(nums,0,N-1,noOfThreadsAvailable);
        long start = System.currentTimeMillis();

        quickSort.quickSortThreaded();
        System.out.println(System.currentTimeMillis() - start);
//        quickSort.printArray();
    }
}

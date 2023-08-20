package com.imran;

public class MergeSort extends Thread{
    private int[] nums;
    private int left,right;
    private int noOfThreads;

    public MergeSort(int[] nums,int left,int right,int noOfThreads) {
        this.nums = nums;
        this.left = left;
        this.right = right;
        this.noOfThreads = noOfThreads;
    }

    @Override
    public void run() {
        mergeSortThreaded(nums,left,right,noOfThreads);
    }

    public void mergeSortThreadedCall() {
        mergeSortThreaded(nums,left,right,noOfThreads);
    }

    public void mergeSortThreaded(int[]nums,int left,int right,int noOfThreads) {
        if(left>=right) return;
        if(noOfThreads==1) {
            mergeSort();
            return;
        }
        System.out.println(noOfThreads);
        int mid = (left+right)>>1;
        MergeSort m1 = new MergeSort(nums,left,mid,(noOfThreads>>1));
        MergeSort m2 = new MergeSort(nums,mid+1,right,(noOfThreads>>1));

        m1.run();
        m2.run();

        try {
            m1.join();
            m2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(nums,left,mid+1,right);
    }

    public void mergeSort() {
        mergeSort(this.nums,this.left,this.right);
    }

    public void mergeSort(int[] nums,int left,int right) {
        if(left>=right) return;
        int mid = (left+right)>>1;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid+1,right);
    }

    private void merge(int[] nums,int left,int mid,int right) {
        int lSize = mid-left,rSize = right-mid+1;
        int[] leftArr = new int[lSize];
        int[] rightArr = new int[rSize];

        for(int i=left;i<mid;i++)
            leftArr[i-left] = nums[i];
        for(int i=mid;i<=right;i++)
            rightArr[i-mid] = nums[i];

        int leftIndex = 0, rightIndex=0;

        for(int i=left;i<=right;i++) {
            if(leftIndex < lSize && ( rightIndex >= rSize || leftArr[leftIndex] <= rightArr[rightIndex]))
                nums[i] = leftArr[leftIndex++];
            else
                nums[i] = rightArr[rightIndex++];
        }
    }

    public void printArray() {
        for(int i=this.left;i<=this.right;i++) {
            System.out.print(String.format("%d ",nums[i]));
        }
    }

    private static int size = 10000;
    public static void main(String[] args) {
        int nums[] = new int[size];
        for(int i=0;i<size;i++)
            nums[i] = (int) (Math.random() * size);
        int left = 0, right = size-1;

        MergeSort mergeSortAlgo = new MergeSort(nums,left,right,8);
//        mergeSortAlgo.mergeSort();
        mergeSortAlgo.mergeSortThreadedCall();
        mergeSortAlgo.printArray();
    }
}

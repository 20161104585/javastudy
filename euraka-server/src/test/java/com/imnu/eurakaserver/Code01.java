package com.imnu.eurakaserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 数据结构与算法（简单排序）
 * @Author: haole
 * @Date: 2021/7/3 9:04
 */
public class Code01 {
    public static final Logger LOGGER = LoggerFactory.getLogger(Code01.class);

    /**
     * 二进制输出函数
     *
     * @param num
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    /**
     * 数组位置交换函数
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * 选择排序
     * 工作原理是每一次从待排序的数据元素中选出最小（或最大）的一个元素，
     * 存放在序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到全部待排序的数据元素排完。
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        //先处理边界条件,数组为空或数组长度为1，不需要排序，直接return
        //LOGGER.info("选择排序执行函数开始！！！");
        if (arr == null || arr.length < 2) {
            return;
        }
        //0 ~ n-1
        //1 ~ n-1
        //2 ~ n-1
        int N = arr.length;
        //控制循环i ~ n-1
        for (int i = 0; i < N; i++) {
            //定义范围内最小值下标
            int minValueIndex = i;
            //控制循环找出最小值下标
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            //最小位与初始位交换位置
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序
     * 它重复地走访过要排序的元素列，依次比较两个相邻的元素，
     * 如果顺序（如从大到小、首字母从Z到A）错误就把他们交换过来。
     * 走访元素的工作是重复地进行直到没有相邻元素需要交换，
     * 也就是说该元素列已经排序完成。
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0 ~ n-1
        //0 ~ n-2
        //0 ~ n-3
        //控制循环0 ~ end
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            //比较两个相邻的元素，顺序就把他们交换过来。
            // 0 1   1 2   2 3   3 4   ~   end-1 end
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    /**
     * 插入排序法
     * 就是检查第i个数字，如果在它的左边的数字比它大，进行交换，
     * 这个动作一直继续下去，直到这个数字的左边数字比它还要小，就可以停止了。
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0 ~ 0 完成
        //0 ~ 1
        //0 ~ 2
        //0 ~ n-1
        //控制循环0 ~ n-1
        int N = arr.length;
//        for (int i = 1; i < N; i++) {
//            //0 1 2 3
//            for (int j = i; j - 1 >= 0 && arr[j] < arr[j - 1]; j--) {
//                swap(arr, j, j - 1);
//            }
//        }
        //控制循环0 ~ n-1
        for (int end = 1; end < N; end++) {
            //开始检查新来的数
            int newNumIndex = end;
            //如果新来的数字前边还有数，并且新来的数字比前边的小，交换位置，进行下次比较，
            while (newNumIndex - 1 >= 0 && arr[newNumIndex] < arr[newNumIndex - 1]) {
                swap(arr, newNumIndex, newNumIndex - 1);
                newNumIndex--;
            }
        }
    }

    /**
     * 数组打印
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a = -3;
//        int b = ~a;
//        System.out.println(a>>1);
//        print(a>>1);
        int[] arr = {6, 8, 1, 9, 5, 7, 4, 9, 6, 3, 5, 8, 7, 4, 2};
        printArray(arr);
        insertSort(arr);
        printArray(arr);

    }


}

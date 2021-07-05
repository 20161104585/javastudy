package com.imnu.eurakaserver;

import java.util.Arrays;

/**
 * @Description: 数据结构与算法(二分 、 复杂度 、 动态数组 、 哈希表 、 有序表)
 * @Author: haole
 * @Date: 2021/7/5 8:49
 */
public class Code03 {

    /**
     * 生成随机数组
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArry(int maxSize, int maxValue) {
        int arr[] = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return arr;
    }

    /**
     * 二分法查找的思路如下：
     * （1）首先，从数组的中间元素开始搜索，如果该元素正好是目标元素，则搜索过程结束，否则执行下一步。
     * （2）如果目标元素大于/小于中间元素，则在数组大于/小于中间元素的那一半区域查找，然后重复步骤（1）的操作。
     * （3）如果某一步数组为空，则表示找不到目标元素。
     *
     * @param arr
     * @param num
     * @return
     */
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (num == arr[mid]) {
                return true;
            } else if (num > arr[mid]) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    /**
     * 二分查找目标值最左数字
     *
     * @param arr
     * @param num
     * @return
     */
    public static int mostLeftNolessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 二分查找目标值最右数字
     *
     * @param arr
     * @param num
     * @return
     */
    public static int mostRightNolessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 最简测试二分法
     *
     * @param arr
     * @param num
     * @return
     */
    public static boolean test(int[] arr, int num) {
        for (int cur : arr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 最简测试二分最左
     *
     * @param arr
     * @param num
     * @return
     */
    public static int test2(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 最简测试二分最右
     *
     * @param arr
     * @param num
     * @return
     */
    public static int test3(int[] arr, int num) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArry(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
//            if (test(arr, value) != find(arr, value)) {
//                succeed = false;
//                break;
//            }
//            if (test2(arr, value) != mostLeftNolessNumIndex(arr, value)) {
//                succeed = false;
//                break;
//            }
            if (test3(arr, value) != mostRightNolessNumIndex(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

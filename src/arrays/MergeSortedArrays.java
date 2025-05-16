package arrays;


public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int _1Ptr = 0, _2Ptr = 0;
        int[] tmp = new int[m + n];

        int idx = 0;
        while (_1Ptr < m || _2Ptr < n) {
            if (_1Ptr == m || (_2Ptr < n && nums1[_1Ptr] >= nums2[_2Ptr])) {    //One of them may == size, so make sure u don't run out of bounds _2Ptr < n
                tmp[idx++] = nums2[_2Ptr++];
            }
            else {
                tmp[idx++] = nums1[_1Ptr++];
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            nums1[i] = tmp[i];
        }
    }

}

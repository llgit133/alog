package src.base.class01;

public class Code04_BSExist {

	//二分法查找某数是否存在
	public static boolean exist(int[] sortedArr, int num) {
		if (sortedArr == null || sortedArr.length == 0) {
			return false;
		}
		int L = 0;
		int R = sortedArr.length - 1;
		int mid = 0;
		while (L < R) {
			mid = L + ((R - L) >> 1);
			if (sortedArr[mid] == num) {return true;}
			else if (sortedArr[mid] > num) {R = mid - 1;}
			else {L = mid + 1;}
		}
		return sortedArr[L] == num;
	}

	public static void main(String[] args) {
		int[] ints = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println(exist(ints, 9));
	}
}

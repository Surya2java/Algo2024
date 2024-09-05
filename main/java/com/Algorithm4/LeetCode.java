package com.Algorithm4;

import java.math.BigInteger;
import java.util.*;

public class LeetCode {

	/*---------------------------------------< 1.  Two Sum  >---------------------------------------------------------
	Given an array of integers nums and an integer target, return indices of the two numbers
	such that they add up to target.

	You may assume that each input would have exactly one solution, and you may not use the
	same element twice.

	You can return the answer in any order.

	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	 */
	static public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int arr[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				arr[0] = map.get(nums[i]);
				arr[1] = i;
				return arr;
			} else
				map.put(target - nums[i], i);

		}
		return arr;
	}

/*--------------------------------------< 58. Length of Last Word  >----------------------------------------------------------------------

Given a string s consisting of words and spaces, return the length of the last word in the
 string.

A word is a maximal substring consisting of non-space characters

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

 */

	public static int lengthOfLastWord(String s) {

		String[] str = s.split(" ");
		return str[str.length - 1].length();
	}

	/*---------------------------------------< 217. Contains Duplicate  >---------------------------------------------------------------------------------
	 Given an integer array nums, return true if any value appears at least twice in the array,
	 and return false if every element is distinct.

	Input: nums = [1,2,3,1]
	Output: true
	 */
	public static boolean containsDuplicate(int[] nums) {


		//First method using set
/*	Set<Integer> set =new HashSet<>();
	for(int i=0;i<nums.length;i++){
		if(set.contains(nums[i]))
			return true;
		else
			set.add(nums[i]);
	}
	return false; */

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]))
				return true;
			else
				map.put(nums[i], 1);
		}
		return false;
	}

	/*--------------------------------------< 287. Find the Duplicate Number  >---------------------------------------------------------------
	Given an array of integers nums containing n + 1 integers where each integer is in the range
	 [1, n] inclusive.
	There is only one repeated number in nums, return this repeated number.
	You must solve the problem without modifying the array nums and uses only constant extra
	space.

	Input: nums = [1,3,4,2,2]
	Output: 2
	 */
	public static int findDuplicate(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {

			if (map.containsKey(nums[i]))
				return nums[i];
			else
				map.put(nums[i], 1);

		}
		return 0;
	}

	/*--------------------------------------< 231. Power of Two  >-------------------------------------------------------
	Given an integer n, return true if it is a power of two. Otherwise, return false.
	An integer n is a power of two, if there exists an integer x such that n == 2x.

	Input: n = 16
	Output: true
	Explanation: 2 to the power 4 = 16
	 */
	public static boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;
		while (n != 1) {
			if (n % 2 != 0)
				return false;
			else
				n /= 2;
		}
		return true;
	}

	/*--------------------------------------< 268. Missing Number >------------------------------------------------------------
	Given an array nums containing n distinct numbers in the range [0, n], return the only
	number in the range that is missing from the array.

	Input: nums = [3,0,1]
	Output: 2
	Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is
	 the missing number in the range since it does not appear in nums.
	 */
	public static int missingNumber(int[] nums) {
		int sum = 0;
		int n = nums.length;
		for (int i = 0; i < nums.length; i++)
			sum = sum + nums[i];
		return n * (n + 1) / 2 - sum;
	}

	/*------------------------------------< 136. Single Number >-------------------------------------------------------------------------
	Given a non-empty array of integers nums, every element appears twice except for one.
	 Find that single one.

	You must implement a solution with a linear runtime complexity and use only constant extra
	space.

	Input: nums = [2,2,1]
	Output: 1
	 */
	public static int singleNumber(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else
				map.put(nums[i], map.get(nums[i]) + 1);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == 1)
				return nums[i];
		}
		return 1;
	}

	/*-------------------------------------------< 709. To Lower Case >--------------------------------------------------------------------
	Given a string s, return the string after replacing every uppercase letter with the same
	 lowercase letter.

	Input: s = "Hello"
	Output: "hello"
	*/
	public static String toLowerCase(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
				sb.append((char) (s.charAt(i) + 32));
			else
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	/*----------------------------------------------< 9. Palindrome Number >-----------------------------------------------------------------------------
	Given an integer x, return true if x is a palindrome, and false otherwise.

	Input: x = 121
	Output: true
	Explanation: 121 reads as 121 from left to right and from right to left.

	Input: x = -121
	Output: false
	*/
	public static boolean isPalindrome(int x) {
		//First Method using String reverse  121
/*
    StringBuilder sb=new StringBuilder(String.valueOf(x));
	return sb.reverse().equals(String.valueOf(x));
 */


		//Second Method

	/*

	          if(x<0)
               return false;

          double rev=0;
          int y=x;
          while(x!=0)
          {
              double rem=x%10;
              rev=rev*10+rem;

              if(rev<=Integer.MIN_VALUE || rev>=Integer.MAX_VALUE)
              {
                  rev=0;
                  break;
              }
              x=x/10;
          }

          if(rev==y)
              return true;
          else
              return false;

    }
	 */

		//Third Method

		int actualValue = x;
		int rem = 0, reverse = 0;   // x=232
		if (x < 0)
			return false;
		while (x > 0) {
			reverse = reverse * 10 + x % 10;  //232
			x = x / 10;
		}
		if (actualValue == reverse)
			return true;
		else
			return false;
	}

	/*------------------------------------------------<  7. Reverse Integer  >-----------------------------------------------------------------------------

	Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
	the signed 32-bit integer range [-231, 231 - 1], then return 0.

	Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

	Input: x = 123
	Output: 321
	*/
	public static int reverse(int x) {

		if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE)
			return 0;

		int reverse = 0;
		while (x != 0) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}

		return reverse;
	}

	/*-----------------------------------------------< 1668. Maximum Repeating Substring  >----------------------------------------------------------------------------------
	For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. The
	word's maximum k-repeating value is the highest value k where word is k-repeating in sequence. If word is not a
	substring of sequence, word's maximum k-repeating value is 0.

	Given strings sequence and word, return the maximum k-repeating value of word in sequence.

	Input: sequence = "ababc", word = "ab"
	Output: 2
	Explanation: "abab" is a substring in "ababc".

	Input: sequence = "ababc", word = "ba"
	Output: 1
	 */
	public static int maxRepeating(String sequence, String word) {
		String sb = "";
		int count = -1;
		do {

			count++;
			sb = sb + word;
		} while (sequence.contains(sb));
		return count;
	}


/*----------------------------------------------------< 41. First Missing Positive >-------------------------------------------------------------------------------
Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Input: nums = [3,4,-1,1]
Output: 2
 */

	public static int firstMissingPositive(int[] nums) {

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++)
			set.add(nums[i]);
		int i = 1;
		do {
			if (!set.contains(i))
				return i;
			i++;
		} while (i <= nums.length);                   //while (true);   we can  also execute infinite times
		return i;
	}

	/*----------------------------------------------< 925. Long Pressed Name >------------------------------------------------------------------------------------------
	Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed,
	 and the character will be typed 1 or more times.
	You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name,
	with some characters (possibly none) being long pressed.

	Input: name = "alex", typed = "aaleex"
	Output: true
	Explanation: 'a' and 'e' in 'alex' were long pressed.

	Input: name = "saeed", typed = "ssaaedd"
	Output: false
	 */
	static public boolean isLongPressedName(String name, String typed) {
		if (name.equals(typed))
			return true;
		if (typed.length() < name.length())
			return false;
		int i = 0;
		int j = 0;
		int length = name.length();
		while (j < typed.length()) {
			if (i < length && name.charAt(i) == typed.charAt(j))
				i++;
			else {
				if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
					return false;
			}
			j++;
		}
		return i == length;
	}

	/*--------------------------------------------------<  53. Maximum Subarray  >---------------------------------------------------------------------
	Given an integer array nums, find the subarray with the largest sum, and return its sum.

	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: The subarray [4,-1,2,1] has the largest sum 6.

	Input: nums = [1]
	Output: 1
	 */
	public static int maxSubArray(int[] a) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
			max = Math.max(max, sum);
			if (sum < 0)
				sum = 0;
		}
		return max;
	}


	/*-------------------------------------------------------<  1662. Check If Two String Arrays are Equivalent   >------------------------------------------------------------------------
	Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
	A string is represented by an array if the array elements concatenated in order forms the string.

	Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
	Output: true
	Explanation:
	word1 represents string "ab" + "c" -> "abc"
	word2 represents string "a" + "bc" -> "abc"
	The strings are the same, so return true.

	Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
	Output: false
	 */
	static public boolean arrayStringsAreEqual(String[] a, String[] b) {


		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();

		for (int i = 0; i < a.length; i++)
			s1 = s1.append(a[i]);
		for (int i = 0; i < b.length; i++)
			s2 = s2.append(b[i]);

		return (s1.toString()).equals(s2.toString());
	}

	/*------------------------------------------<  1295. Find Numbers with Even Number of Digits  >----------------------------------------------------------------------
	Given an array nums of integers, return how many of them contain an even number of digits.

	Input: nums = [12,345,2,6,7896]
	Output: 2
	Explanation:
	12 contains 2 digits (even number of digits).
	345 contains 3 digits (odd number of digits).
	2 contains 1 digit (odd number of digits).
	6 contains 1 digit (odd number of digits).
	7896 contains 4 digits (even number of digits).
	Therefore only 12 and 7896 contain an even number of digits.

	Input: nums = [555,901,482,1771]
	Output: 1
	 */
	public static int findNumbers(int[] nums) {
		int countDigit = 0;
		int rem = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			while (nums[i] != 0) {
				rem = nums[i] % 10;
				count++;
				nums[i] /= 10;
			}
			if (count % 2 == 0)
				countDigit++;
		}
		return countDigit;

	}
/*--------------------------------------------< 125. Valid Palindrome >-------------------------------------------------
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Input: s = "race a car"
Output: false
 */

	public static boolean isPalindrome(String s) {

		List<Character> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122) || (s.charAt(i) >= 48 && s.charAt(i) <= 57))
				list.add(Character.toLowerCase(s.charAt(i)));
		}
		int lastIndex = list.size() - 1;
		for (int i = 0; i < list.size() || lastIndex >= 0; i++) {
			if (list.get(i) != list.get(lastIndex--))
				return false;
		}
		return true;

	}

/*----------------------------------------<  2215. Find the Difference of Two Arrays >---------------------------------------
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].

Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
 */

	static public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for (int n : nums1) set1.add(n);
		for (int n : nums2) set2.add(n);

		for (int n : set1) {
			if (!set2.contains(n))
				l1.add(n);
		}

		for (int n : set2) {
			if (!set1.contains(n))
				l2.add(n);
		}

		list.add(l1);
		list.add(l2);

		return list;
	}


/*---------------------------------------------<  867. Transpose Matrix  >-------------------------------------------
Given a 2D integer array matrix, return the transpose of matrix.
The transpose of a matrix is the matrix flipped over its main diagonal,
switching the matrix's row and column indices.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
 */

	static public int[][] transpose(int[][] matrix) {
		int trans[][] = new int[matrix[0].length][matrix.length];

		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				trans[i][j] = matrix[j][i];
			}
		}
		return trans;
	}

	/*------------------------------------------------------< 414. Third Maximum Number >----------------------------------------------
	Given an integer array nums, return the third distinct maximum number in this array. If the
	third maximum does not exist, return the maximum number.

	Input: nums = [3,2,1]
	Output: 1
	Explanation:
		  The first distinct maximum is 3.
		  The second distinct maximum is 2.
		  The third distinct maximum is 1.

	Input: nums = [1,2]
	Output: 2

	Input: nums = [2,2,3,1]
	Output: 1
	 */
	static public int thirdMax(int[] nums) {

		long firstMax = Long.MIN_VALUE;
		long secondMax = Long.MIN_VALUE;
		long thirdMax = Long.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = nums[i];
			} else if (nums[i] > secondMax && nums[i] < firstMax) {
				thirdMax = secondMax;
				secondMax = nums[i];
			} else if (nums[i] > thirdMax && nums[i] < secondMax) thirdMax = nums[i];
		}

		if (thirdMax == Long.MIN_VALUE) return (int) firstMax;

		return (int) thirdMax;
	}

/*-------------------------------------------------< 189. Rotate Array >----------------------------------------------------
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
 */

	static public int[] rotate(int[] nums, int k) {
		int array[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			array[(i + k) % nums.length] = nums[i];

		for (int i = 0; i < nums.length; i++)
			nums[i] = array[i];
		return nums;

	}
/*---------------------------------------------------------<  1572. Matrix Diagonal Sum  >----------------------------------------
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that
 are not part of the primary diagonal.

Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

 */
public static int diagonalSum(int[][] mat) {

        /* 00 01 02      d1 i==j  and d2 i+j==length-1
           10 11 12
           20 21 22
        */
	int sum = 0;
	for(int i=0;i<mat.length;i++){
		for(int j=0;j<mat.length;j++)
			if(i==j || i+j==mat.length-1)
				sum=sum+mat[i][j];

	}
	return sum;
}

/*---------------------------------------------< 1365. How Many Numbers Are Smaller Than the Current Number >-----------------------------------------
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for
each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 */
public static int[] smallerNumbersThanCurrent(int[] nums) {
	int newNums[] = new int[nums.length];
	for(int i=0;i<nums.length;i++){
		int count = 0;
		int max=nums[i];
		for(int j=0;j<nums.length;j++){
			if(max>nums[j])
				count++;
		}
		newNums[i]=count;
	}
	return newNums;
}
/*-------------------------------------------------<  557. Reverse Words in a String III  >------------------------------------------
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace
 and initial word order.

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Input: s = "Mr Ding"
Output: "rM gniD"
 */

	public static String reverseWords(String s) {
		String[] str=s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length;i++){
			for(int j=str[i].length()-1;j>=0;j--){
				sb.append(str[i].charAt(j));
			}
			sb.append(" ");
		}
		return sb.toString().trim();
	}
/*-----------------------------------------------------<  1929. Concatenation of Array  >-----------------------------------------------------
Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and
ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
Specifically, ans is the concatenation of two nums arrays. Return the array ans.

Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]

Input: nums = [1,3,2,1]
Output: [1,3,2,1,1,3,2,1]

 */
public static int[] getConcatenation(int[] nums) {

	int[] newArray = new int[nums.length*2];
	boolean flag=true;
	for(int k=0,i=0;i<nums.length;i++,k++){
		newArray[k] = nums[i];
		if(i==nums.length-1 && flag==true){
			i=-1;
			flag=false;
		}
	}
	return newArray;
}

/*--------------------------------------------------------<  1859. Sorting the Sentence  >--------------------------------------------------
A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word
consists of lowercase and uppercase English letters.

Input: s = "is2 sentence4 This1 a3"   sortSentence("is2 sentence4 This1 a3")
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.

Input: s = "Myself2 Me1 I4 and3"
Output: "Me Myself and I"
 */
public static String sortSentence(String s) {
	String[] str = s.split(" ");
	StringBuilder sb = new StringBuilder();
	Map<Integer,String> map=new HashMap<>();
	for(int i=0;i<str.length;i++){
		char mapChar= str[i].charAt(str[i].length()-1);
		int mapK = mapChar - '0';
		String mapV = str[i].substring(0,str[i].length()-1);
		map.put(mapK,mapV);
	}
	for(int i=1;i<=9;i++){
		if(map.containsKey(i))
		{
			sb.append(map.get(i));
			sb.append(" ");
		}
		else
			break;

	}
	return sb.toString().trim();

}

/*----------------------------------------------------<  26. Remove Duplicates from Sorted Array  >-------------------------------------
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
element appears only once. The relative order of the elements should be kept the same. Then return the number of
unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 */

	public static int removeDuplicates(int[] nums) {
		int j = 0;
		for(int i=1;i<nums.length;i++){
			if(nums[i]!=nums[j]){
				j++;
				nums[j]=nums[i];

			}
		}
		return j+1;
	}
/*-------------------------------------------------<  27. Remove Element  >----------------------------------------------------------------
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may
be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the
following things:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
 */
public static int removeElement(int[] nums, int val) {
	int j=0;
	for(int i=0;i<nums.length;i++) {
		if (nums[i] != val) {
			nums[j] = nums[i];
			j++;
		}
	}
	return j;
}
/*------------------------------------------------------<  69. Sqrt(x)  >-------------------------------------------------------------------
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned
integer should be non-negative as well.
You must not use any built-in exponent function or operator.

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
 */

	public static int mySqrt(int x) {

		long r=x;
		while(r*r>x){
			r=(r+x/r)/2;
		}
		return (int)r;

	}
/*-----------------------------------------------------<  1480. Running Sum of 1d Array  >----------------------------------------------------
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]

 */
public static int[] runningSum(int[] nums) {

	int sum=0;
	for(int i=0;i<nums.length;i++){
		sum=sum+nums[i];
		nums[i]=sum;
	}
	return nums;
}
/*----------------------------------------------------<  1470. Shuffle the Array  >--------------------------------------------------------------
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]
 */
public static int[] shuffle(int[] nums, int n) {

	int suffle[] = new int[nums.length];
	for(int i=0,j=0;i<nums.length;i++){
		if(i%2==0)
			suffle[i]=nums[j++];
		else
			suffle[i]=nums[n++];
	}
	return suffle;
}
/*--------------------------------------------------<  1389. Create Target Array in the Given Order  >---------------------------------------------
Given two arrays of integers nums and index. Your task is to create target array under the following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.

Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
Example 2:

Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
Output: [0,1,2,3,4]
 */

	public static int[] createTargetArray(int[] nums, int[] index) {
		List<Integer> list = new ArrayList<>();
		int x=0;
		for(int i=0;i<nums.length;i++)
			list.add(index[i],nums[i]);

		for(Integer i : list) {
			nums[x] = i;
			x++;
		}

		return nums;
	}
/*------------------------------------------------------<  387. First Unique Character in a String  >----------------------------
Given a string s, find the first non-repeating character in it and return its index.If it does not exist,return -1.


Input: s = "leetcode"
Output: 0

Input: s = "loveleetcode"
Output: 2

Input: s = "aabb"
Output: -1
 */
public static int firstUniqChar(String s) {
	for(int i=0;i<s.length();i++)
		if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i)))
			return i;
	return -1;
}

/*------------------------------------------------------<  1773. Count Items Matching a Rule  >--------------------------------------------------
ou are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of
the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.  

Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]],
       ruleKey = "color", ruleValue = "silver"
Output: 1
Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].

Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]],
       ruleKey = "type", ruleValue = "phone"
Output: 2
 */
public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

	int index=0;
	int count=0;
	if(ruleKey.equals("type"))
		index=0;
	else if(ruleKey.equals("color"))
		index=1;
	else
		index=2;

	for(int i=0;i<items.size();i++)
		if(items.get(i).get(index).equals(ruleValue))
			count++;

	return count;
}

/*-----------------------------------------------<  35. Search Insert Position  >--------------------------------------------------------------
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Input: nums = [1,3,5,6], target = 5
Output: 2

Input: nums = [1,3,5,6], target = 2
Output: 1

Input: nums = [1,3,5,6], target = 7
Output: 4
 */
public static  int searchInsert(int[] nums, int target) {

	int i=0;
	for(;i<nums.length;i++){
		if(nums[i]>=target)
			return i;
	}
	if(i==nums.length)
		return nums.length;
	else
		return 1;
}
/*---------------------------------------------------<  283. Move Zeroes  >------------------------------------------------------------------------------
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
elements. Note that you must do this in-place without making a copy of the array.

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Input: nums = [0]
Output: [0]
 */
public static  void moveZeroes(int[] nums) {

	int count = 0;
	for(int i =0 ;i<nums.length ;i++ ){

		if(nums[i]!=0){
			nums[count]=nums[i];
			count++;

		}
	}
	for(int i=count;i<nums.length;i++)
	{
		nums[i]=0;
	}
	printArray(nums);
}

/*-----------------------------------------------<  88. Merge Sorted Array  >--------------------------------------------------------
ou are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]

 */
public static void merge(int[] nums1, int m, int[] nums2, int n) {
	for(int j=0,i=m ; i<nums1.length ; i++,j++)
	{
		nums1[i] = nums2[j];
	}
	Arrays.sort(nums1);
	printArray(nums1);
}


/*----------------------------------------------<   167. Two Sum II - Input Array Is Sorted   >-------------------------------------------------
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such
that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
where 1 <= index1 < index2 <= numbers.length.Return the indices of the two numbers, index1 and index2,
added by one as an integer array [index1, index2] of length 2.The tests are generated such that there is exactly
one solution. You may not use the same element twice.   Your solution must use only constant extra space.

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]

Input: numbers = [-1,0], target = -1
Output: [1,2]
 */
public static int[] twoSum_II(int[] numbers, int target) {
	int indexArray[] = new int[2];
	int left=0,right=numbers.length-1;
	while(left!=right){
		if((numbers[left]+numbers[right])<target)
			left++;
		else if((numbers[left]+numbers[right])>target)
			right--;
		else{
			indexArray[0]=left+1;
			indexArray[1]=right+1;
			return indexArray;
		}
	}
	return indexArray;
}

/*---------------------------------------------------<  704. Binary Search  >----------------------------------------------------------------
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to
search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4


Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1

*/

	public static int binarySearch(int[] nums, int target) {

		int l=0;
		int r=nums.length-1;
		while(l<=r){
			int m=(l+r)/2;

			if(target>nums[m])
				l=m+1;
			else if(target<nums[m])
				r=m-1;
			else
				return m;

		}
		return -1;

	}
	public static void main(String[] args) {


		int[] result = twoSum(new int[]{2, 7, 11, 15}, 26);

		System.out.println("1>  1. Two Sum  :: " + result[0] + " " + result[1]);

		System.out.println("2>  58. Length of Last Word  :: " + lengthOfLastWord("Hello World JMD"));

		System.out.println("3>  217. Contains Duplicate  :: " + containsDuplicate(new int[]{1, 2, 3, 1}));

		System.out.println("4>  287. Find the Duplicate Number  :: " + findDuplicate(new int[]{1, 3, 4, 2, 2}));

		System.out.println("5>  231. Power of Two :: " + isPowerOfTwo(16));

		System.out.println("6>  268. Missing Number :: " + missingNumber(new int[]{1, 4, 3, 0}));

		System.out.println("7>  136. Single Number :: " + singleNumber(new int[]{2, 2, 1}));

		System.out.println("8>  709. To Lower Case  :: " + toLowerCase("LowEr"));

		System.out.println("9>  9. Palindrome Number  :: " + isPalindrome(323));

		System.out.println("10>  7. Reverse Integer  :: " + reverse(12345678));

		System.out.println("11>  1668. Maximum Repeating Substring  :: " + maxRepeating("ababc", "ab"));

		System.out.println("12>  41. First Missing Positive  :: " + firstMissingPositive(new int[]{3, 4, -1, 1}));

		System.out.println("13>  925. Long Pressed Name  :: " + isLongPressedName("alex", "aaleex"));

		System.out.println("14>  53. Maximum Subarray  :: " + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

		System.out.println("15>  1662. Check If Two String Arrays are Equivalent   :: " + arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));

		System.out.println("16>  1295. Find Numbers with Even Number of Digits   :: " + findNumbers(new int[]{12, 345, 2, 6, 7896}));

		System.out.println("17>  125. Valid Palindrome   :: " + isPalindrome("A man, a plan, a canal: Panama"));

		System.out.println("18>  2215. Find the Difference of Two Arrays   :: " + findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));

		System.out.println("19>  867. Transpose Matrix   :: ");
		int[][] transMatrix = transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		for (int i = 0; i < transMatrix[0].length; i++) {
			for (int j = 0; j < transMatrix.length; j++) {
				System.out.print("   " + transMatrix[i][j]);
			}
			System.out.println();
		}

		System.out.println("20>  414. Third Maximum Number   :: " + thirdMax(new int[]{3, 2, 1, 7, 5, 10, 9}));

		System.out.println("21>  189. Rotate Array   :: 1,2,3,4,5,6,7 and K=3" );
		printArray(rotate(new int[]{1,2,3,4,5,6,7},3));

		System.out.println("22>  1572. Matrix Diagonal Sum   :: "+diagonalSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}) );

		System.out.println("23>  1365. How Many Numbers Are Smaller Than the Current Number  > 8,1,2,2,3 :: ");

		printArray(smallerNumbersThanCurrent(new int[]{8,1,2,2,3}));

		System.out.println("24>  557. Reverse Words in a String III   :: "+ reverseWords("Let's take LeetCode contest"));

		System.out.println("25>  1929. Concatenation of Array  1,2,1  :: ");
		printArray( getConcatenation(new int[]{1,2,1}));

		System.out.println("26>  1859. Sorting the Sentence   :: "+sortSentence("God5 is2 The3 God1 always4"));

		System.out.println("27>  26. Remove Duplicates from Sorted Array   :: "+removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

		System.out.println("28>  27. Remove Element   :: "+removeElement(new int[]{3,2,2,3},3));

		System.out.println("29>  69. Sqrt(x)   :: "+mySqrt(16));

		System.out.println("30>  1480. Running Sum of 1d Array   1,2,3,4 :: ");
		printArray(runningSum(new int[]{1,2,3,4}));

		System.out.println("31>  1470. Shuffle the Array   2,5,1,3,4,7 for n=2 :: ");
		printArray(shuffle(new int[]{2,5,1,3,4,7},3));

		System.out.println("32>  1389. Create Target Array in the Given Order  :: ");
		printArray(createTargetArray(new int[]{0,1,2,3,4},new int[]{0,1,2,2,1}));

		System.out.println("33>  387. First Unique Character in a String  :: "+firstUniqChar("leetcodel"));

		List<List<String>> listOfLists = List.of(
				List.of("phone", "blue", "pixel"),
				List.of("computer", "silver", "lenovo"),
				List.of("phone", "gold", "iphone"));
		System.out.println("34>  1773. Count Items Matching a Rule  :: "+countMatches(listOfLists,"type", "phone"));

		System.out.println("35>  35. Search Insert Position  :: "+searchInsert(new int[]{1,3,5,6},5));

		System.out.println("36>  283. Move Zeroes  :: ");moveZeroes(new int[]{0,1,0,3,12});

		System.out.println("37>  88. Merge Sorted Array  ::  1,2,3,0,0,0  &  2,5,6 "); merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);

		System.out.println("38>  167. Two Sum II - Input Array Is Sorted , Index of Sum values :: "); printArray(twoSum_II(new int[]{2,3,4},6));

		System.out.println("39>  704. Binary Search :: "+ binarySearch(new int[]{-1,0,3,5,9,12},9 ));


	}






	
public static void printArray(int[] a) {
		System.out.print("                            ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println();
	}
}





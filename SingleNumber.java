//Works for singleNumber2 as well
class Solution {
    public int singleNumber(int[] nums) {
        /*
        Loop throught the array and add the values into tha hashmap and if there is a '1'
        as value, we return the key
        Time and space complexity = O(n)
        */
        Map<Integer,Integer> elements_in_nums = new HashMap<>();
        for(int num : nums){
            if(elements_in_nums.containsKey(num)) 
                elements_in_nums.put(num, elements_in_nums.get(num) + 1);
            else elements_in_nums.put(num ,1);
        }
        for(int key : elements_in_nums.keySet()) {
            if(elements_in_nums.get(key) == 1) return key;
        }
        return -1; //this part will never be reached because we return the key before here
    }
}

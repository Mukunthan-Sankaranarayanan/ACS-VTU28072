class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       Map<Integer,Integer>map=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        if(map.containsKey(nums[i])){
            int diff=i-map.get(nums[i]);
            if(diff<=k){
                return true;
            }
        }
        map.put(nums[i],i);
       } 
       return false;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={1,2,3,1};
        int k=3;
        System.out.println(s.containsNearbyDuplicate(nums,k));
    }
}

package neetcode.blind75;


import java.util.*;


public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
//        System.out.println(Arrays.toString(topKFrequent(nums, k)));
//        System.out.println(Arrays.toString(topKFrequentMinHeap(nums, k)));
        System.out.println(Arrays.toString(topKFrequentBucketSort(nums, k)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

// Insert all the elements in the hashmap. Key = the element, value=frequency of the element
        for(int i=0; i<nums.length; i++){
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i] , map.get(nums[i])+1);
        }

//        result = map.entrySet().stream()
//                .filter(entry->entry.getValue() >= k)
//                .mapToInt(Map.Entry::getKey)
//                .toArray();

        List<int[]> arr = new ArrayList<>();
        map.entrySet().stream().forEach(entry-> arr.add(new int[]{entry.getValue(), entry.getKey()}));

        arr.sort((a,b)-> b[0]-a[0]);

        for(int i=0; i<k; i++){
            result[i] = arr.get(i)[1];
        }


        return result;

    }

    public static int[] topKFrequentMinHeap(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        if (nums.length==0)
            return result;
        if (nums.length==1)
            return result=new int[]{nums[0]};

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            minHeap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(minHeap.size() > k)
                minHeap.poll();
        }

        for(int i=0;i<k;i++ ){
            result[i] = minHeap.poll()[1];
        }


        return result;
    }

    public static int[] topKFrequentBucketSort(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        int index=0;

        for(int num :nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int i=0;i< bucket.length; i++){
            bucket[i] = new ArrayList<>();
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 0) {
                bucket[entry.getValue()].add(entry.getKey());
            }
        }

        for(int i=nums.length; i>0 && index<k; i--) {
            if (!bucket[i].isEmpty()) {
                for(int element: bucket[i]){
                    if(index<k){
                    result[index]=element;
                    index++;
                    }
                }
            }
        }
        return result;
    }
}

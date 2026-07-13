class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            q.offer(i);
        }
        int[] result = new int[n];
        int idx = 0;
        while(!q.isEmpty()){
            int pos = q.poll();
            result[pos] = deck[idx++];
            if(!q.isEmpty()){
                q.offer(q.poll());
            }
        }
        return result;
    }
}
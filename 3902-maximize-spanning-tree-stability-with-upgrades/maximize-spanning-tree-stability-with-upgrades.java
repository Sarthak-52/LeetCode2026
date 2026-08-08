class DSU {
    int parent[];
    DSU(int n){
        parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
    }

    int find(int u){
        if(parent[u] != u)
            parent[u] = find(parent[u]);
        
        return parent[u];
    }

    boolean union(int u,int v){
        int pU = find(u);
        int pV = find(v);

        if(pU == pV)
            return false;

        if(pU < pV)
            parent[pV] = pU;
        else
            parent[pU] = pV;
        
        return true;
    }
}

class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);

        Queue<int []> q = new PriorityQueue<>((a,b)->b[2]-a[2]);

        int usedE = 0;
        int res = Integer.MAX_VALUE;

        for(int e[] : edges){
            if(e[3] == 1){
                boolean u = dsu.union(e[0],e[1]);
                if(!u)
                    return -1;
                res = Math.min(res,e[2]);
                usedE++;
            }
            else
                q.offer(e);
        }

        while(usedE < n-1 && !q.isEmpty()){
            int e[] = q.poll();

            boolean u = dsu.union(e[0],e[1]);
            if(!u)
                continue;
            
            usedE++;
            if(usedE + k > n-1)
                e[2] *= 2;
            
            res = Math.min(res,e[2]);
        }

        return usedE == n-1 ? res : -1;
    }
}
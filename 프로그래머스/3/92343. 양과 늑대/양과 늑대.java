import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
class Solution {
            /*
            모은양 보다 늑대의 수가 같거나 많으면 -> 모든양 잡아먹힘,
            root -> root 
        */
        /*
            레벨 기준 check?
            sub tree..?
             양기준으로 필요늑대 계산,,?
             늑대 기준으로 양 계산?
             
             bfs ㄱㄱ
        */
        
     private static class Info{
         int node;
         int sheep, wolf;
         HashSet<Integer> visited;
         
         public Info (int node, int sheep, int wolf, HashSet<Integer> visited)
         {
             this.node= node;
             this.sheep = sheep;
             this.wolf = wolf;
             this.visited = visited;
         }
     }
        
        
        private static ArrayList<Integer>[] Btree;
        
        private static void makeBTree(int[] info, int[][] edges)
        {
            Btree = new ArrayList[info.length];
            for(int i=0 ;i< Btree.length ; i++)
            {
                Btree[i] = new ArrayList<>();
            }
            
            for(int [] edge : edges)
            {
                Btree[edge[0]].add(edge[1]);
            }
        }
    
        
        
    
    public int solution(int[] info, int[][] edges) {
        makeBTree(info, edges);
        int maxSheep = 0;
        
        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0,1,0, new HashSet<>()));
        
        
        
        
        //BFS 
        while(!queue.isEmpty())
        {
            Info now = queue.poll();
            maxSheep = Math.max(maxSheep, now.sheep);
            
            now.visited.addAll(Btree[now.node]);
            
            
            for(int next : now.visited)
            {
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);
            
            
            
                if(info[next] == 1){
                    if(now.sheep != now.wolf +1)
                    {
                        queue.add(new Info(next,now.sheep, now.wolf +1 , set));
                    }
                }
            
                else
                {
                    queue.add(new Info(next, now.sheep +1, now.wolf, set ));
                }
            }
        }
        
        return maxSheep;
    }

}
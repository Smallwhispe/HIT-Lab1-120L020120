package P3;

import java.util.*;

public class FriendshipGraph {
    public List<Person>Vertex = new ArrayList<>();
    public List<String>name = new ArrayList<>();
    public void addVertex(Person p){
        if(name.contains(p.getname())){
            System.out.println("已经有这个人了");
        }
        else {
            Vertex.add(p);
            name.add(p.getname());
        }
    }
    public void addEdge(Person p1,Person p2){
        p1.addfriend(p2);
    }
    public int getDistance(Person p1,Person p2){//对于朋友关系图的广度搜索
        if(p1 == p2)return 0;
        Queue<Person>queue = new LinkedList<>();
        HashMap<Person, Integer> map = new HashMap<>();
        queue.offer(p1);
        map.put(p1,0);
        while(!queue.isEmpty()){
            Person m = queue.poll();
            List<Person> friend = m.getfriend();
            for(Person n : friend){
                if (!map.containsKey(n)) {
                    queue.offer(n);
                    map.put(n, map.get(m) + 1);
                    if(n == p2)return map.get(p2);
                }
            }
        }
        return -1;
    }
}

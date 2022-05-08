package P3;

import org.junit.Test;

import static org.junit.Assert.*;

public class FriendshipGraphTest {
    @Test
    public void testaddVertex(){
        FriendshipGraph g = new FriendshipGraph();
        g.addVertex(new Person("Rachel"));
        assertEquals("Rachel",g.Vertex.get(g.Vertex.size()-1).getname());
    }

    @Test
    public void testaddEdge(){
        FriendshipGraph g = new FriendshipGraph();
        Person Ross = new Person("Ross");
        Person Ben = new Person("Ben");
        g.addVertex(Ross);
        g.addVertex(Ben);
        g.addEdge(Ross,Ben);
        assertEquals(Ben,Ross.getfriend().get(Ross.getfriend().size()-1));
    }

    @Test
    public void testgetDistance(){
        FriendshipGraph g = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person karmer = new Person("Kramer");
        g.addVertex(rachel);
        g.addVertex(ross);
        g.addVertex(ben);
        g.addVertex(karmer);
        g.addEdge(rachel,ross);
        g.addEdge(ross,ben);
        g.addEdge(ben,rachel);
        assertEquals(0,g.getDistance(rachel,rachel));
        assertEquals(0,g.getDistance(ben,ben));
        assertEquals(1,g.getDistance(ross,ben));
        assertEquals(2,g.getDistance(ben,ross));
        assertEquals(-1,g.getDistance(ross,karmer));
    }
}
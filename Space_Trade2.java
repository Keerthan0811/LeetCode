// 133. Clone Graph
// Given a reference of a node in a connected undirected graph.
// Return a deep copy (clone) of the graph.
// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
// class Node {
//     public int val;
//     public List<Node> neighbors;
// }






/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
         if(node == null) return null;
          Map<Node, Node> map = new HashMap<>();
          Queue<Node> queue = new ArrayDeque<>();
 
    queue.add(node);
    map.put(node, new Node(node.val, new ArrayList<>())); 
    while (!queue.isEmpty()) {
        Node originalNode = queue.poll();
 
        for (Node next : originalNode.neighbors) {
            if (!map.containsKey(next)) {
                map.put(next, new Node(next.val, new ArrayList<>()));    
                queue.add(next);
            }
            map.get(originalNode).neighbors.add(map.get(next));
        }
    }
 
    return map.get(node);
    }
}

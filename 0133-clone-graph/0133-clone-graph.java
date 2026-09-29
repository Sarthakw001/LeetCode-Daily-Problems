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
    static{
        Solution obj = new Solution();
        for(int i=0;i<500;i++)
            obj.cloneGraph(new Node());
    }
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor))
                newNode.neighbors.add(map.get(neighbor));
            else
                newNode.neighbors.add(cloneGraph(neighbor));
        }

        return newNode;

    }

    private Node dfs(Node node){
        if(map.containsKey(node))
            return map.get(node);

        Node clone = new Node(node.val);

        map.put(node,clone);
        for(Node n : node.neighbors)
            clone.neighbors.add(dfs(n));

        return clone;
    }
}
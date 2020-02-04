package Assignment3;

import java.util.HashSet;


class Node {
    private int node_id;
    private String node_name;
    HashSet<Node> parents = null;
    HashSet<Node> children = null;
    Node() {
        parents = new HashSet<Node>();
        children = new HashSet<Node>();
    }

    void setNodeId(int node_id) {

        this.node_id=node_id;
    }

    void setNodeName(String node_name) {
        this.node_name=node_name;
    }

    int getNodeid() {

        return this.node_id;
    }
    String getNodeName() {

        return this.node_name;
    }

    void addParent(Node parent) {
        if(this.parents.contains(parent)) {
            System.out.println("The given node is already added as a parent!");
        }
        else {
            this.parents.add(parent);
        }
    }
    void addChild(Node child) {
        if(this.children.contains(child)) {
            System.out.println("The given node is already added as a child!");
        }
        else {
            this.children.add(child);
        }
    }
    void deleteParent(Node parent) {
        if(this.parents.contains(parent)) {
            this.parents.remove(parent);
        }
        else {
            System.out.println("No dependency found!");
        }
    }
    void deleteChild(Node child) {
        if(this.children.contains(child)) {
            this.children.remove(child);
        }
        else {
            System.out.println("No dependency found!");
        }
    }

    @Override
    public String toString() {
        return ("Node id-> "+this.getNodeid()+" Node name-> "+this.getNodeName());
    }
}
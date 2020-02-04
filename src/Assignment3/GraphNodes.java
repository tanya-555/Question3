package Assignment3;

import java.util.ArrayList;
import java.util.HashSet;

class GraphNodes {
    static private ArrayList<Node> nodeList=new ArrayList<Node>();

    private static final String INVALID_NODE_ID = "Invalid Node Id!";
    private static final String NO_ANCESTORS = "There are no ancestors for the given node!";
    private static final String NO_DESCENDANTS = "There are no descendants for the given node!";

    public static void createNode(int node_id,String node_name) {
        Node node=new Node();
        node.setNodeId(node_id);
        node.setNodeName(node_name);
        nodeList.add(node);
    }
    static ArrayList<Node> getNodeList() {

        return nodeList;
    }

    static void deleteNode(int node_id) {
        Node currentNode=null;
        for(Node temp:nodeList) {
            if(temp.getNodeid()==node_id) {
                currentNode=temp;
                break;
            }
        }
        if(currentNode==null) {
            System.out.println(INVALID_NODE_ID);
        } else {
            nodeList.remove(currentNode);
            for(Node temp:nodeList) {
                temp.parents.remove(currentNode);
                temp.children.remove(currentNode);
            }
            System.out.println("Node with "+node_id+" deleted!");
        }
    }
    void displayParents(Node node) {
        System.out.println("The parents of the node are ");
        for(Node parent:node.parents) {
            System.out.println(parent);
        }
    }
    void displayChildren(Node node) {
        System.out.println("The children of the node are ");
        for(Node child:node.children) {
            System.out.println(child);
        }
    }

    void displayAncestors(Node node) {
        HashSet<Node> parents=node.parents;
        if(parents==null) {
            System.out.println(NO_ANCESTORS);
            return;
        } else {
            System.out.println("Ancestors for the given node are:");
            for(Node p:parents) {
                System.out.println(p);
                displayAncestors(p);
            }
        }
    }

    void displayDescendants(Node node) {
        HashSet<Node> children=node.children;
        if(children==null) {
            System.out.println(NO_DESCENDANTS);
            return;
        } else {
            System.out.println("Descendants for the given node are :");
            for(Node child:children) {
                System.out.println(child);
                displayDescendants(child);
            }
        }

    }
}
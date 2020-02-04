package Assignment3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Assignment3 {
    static Scanner scanner =new Scanner(System.in);

    private static final String NODE_ID_ABSENT = "Node id does not exist!";
    private static final String INVALID_INPUT = "Invalid input!";
    private static final String INVALID_NODE_ID = "Invalid Node id!";

    //hash set to store unique node_id
    static HashSet<Integer> uniqueId=new HashSet<Integer>();

    public static void main(String[] args) {
        int choice=0;
        while(choice!=9) {
            System.out.println("--MENU--");
            System.out.println("1. Get Immediate Parents of a node");
            System.out.println("2. Get Immediate Chidren of a node");
            System.out.println("3. Get ancestors of a node");
            System.out.println("4. Get descendants of a node");
            System.out.println("5. Delete dependency from a tree");
            System.out.println("6. Delete a node from a tree");
            System.out.println("7. Add dependency to a tree");
            System.out.println("8. Add node to a tree");
            System.out.println("9. Exit");
            System.out.println("Select your option");
            try {
                choice = Integer.parseInt(scanner.next());
            } catch(NumberFormatException e) {
                System.out.println("Invalid choice!");
            }
            switch(choice) {
                case 1:getParents();
                    break;
                case 2:getChildren();
                    break;
                case 3:getAncestors();
                    break;
                case 4:getDescendants();
                    break;
                case 5:delDependency();
                    break;
                case 6:delNode();
                    break;
                case 7:addDependency();
                    break;
                case 8:addNode();
                    break;
                case 9:System.exit(0);
                    break;
                default:System.out.println("Invalid choice!");
            }
        }
    }
    static void getParents() {
        System.out.println("Enter node id");
        int node_id=0;
        try {
            node_id=Integer.parseInt(scanner.next());
            ArrayList<Node> nodeList=GraphNodes.getNodeList();
            Node tmpNode=null;
            for(Node tmp:nodeList) {
                if(tmp.getNodeid()==node_id) {
                    tmpNode=tmp;
                }
            }
            if(tmpNode==null) {
                System.out.println(NODE_ID_ABSENT);
            } else {
                GraphNodes graph_nodes=new GraphNodes();
                graph_nodes.displayParents(tmpNode);
            }
        } catch(NumberFormatException e) {
            System.out.println(INVALID_INPUT);
        }
    }
    static void getChildren() {
        System.out.println("Enter node id");
        int node_id=0;
        try {
            node_id=Integer.parseInt(scanner.next());
            ArrayList<Node> nodeList=GraphNodes.getNodeList();
            Node tmpNode=null;
            for(Node tmp:nodeList) {
                if(tmp.getNodeid()==node_id) {
                    tmpNode=tmp;
                }
            }
            if(tmpNode==null) {
                System.out.println(NODE_ID_ABSENT);
            } else {
                GraphNodes graph_nodes=new GraphNodes();
                graph_nodes.displayChildren(tmpNode);
            }
        } catch(NumberFormatException e) {
            System.out.println(INVALID_INPUT);
        }
    }
    static void getAncestors() {
        System.out.println("Enter node id");
        int node_id=0;
        try {
            node_id=Integer.parseInt(scanner.next());
            ArrayList<Node> nodeList=GraphNodes.getNodeList();
            Node tmpNode=null;
            for(Node tmp:nodeList) {
                if(tmp.getNodeid()==node_id) {
                    tmpNode=tmp;
                }
            }
            if(tmpNode==null) {
                System.out.println(NODE_ID_ABSENT);
            } else {
                GraphNodes graph_nodes=new GraphNodes();
                graph_nodes.displayAncestors(tmpNode);
            }
        } catch(NumberFormatException e) {
            System.out.println(INVALID_INPUT);
        }
    }
    static void getDescendants() {
        System.out.println("Enter node id");
        int node_id=0;
        try {
            node_id=Integer.parseInt(scanner.next());
            ArrayList<Node> nodeList=GraphNodes.getNodeList();
            Node tmpNode=null;
            for(Node tmp:nodeList) {
                if(tmp.getNodeid()==node_id) {
                    tmpNode=tmp;
                }
            }
            if(tmpNode==null) {
                System.out.println(NODE_ID_ABSENT);
            } else {
                GraphNodes graph_nodes=new GraphNodes();
                graph_nodes.displayDescendants(tmpNode);
            }
        } catch(NumberFormatException e) {
            System.out.println(INVALID_INPUT);
        }
    }
    static void delDependency() {
        System.out.println("Enter parent node_id");
        try {
            int parent_id=Integer.parseInt(scanner.next());
            System.out.println("Enter child node_id");
            int child_id=Integer.parseInt(scanner.next());
            ArrayList<Node> nodeList=GraphNodes.getNodeList();
            Node parent_node=null;
            Node child_node=null;
            for(Node tmp:nodeList) {
                if(tmp.getNodeid()==parent_id) {
                    parent_node=tmp;
                }
                if(tmp.getNodeid()==child_id) {
                    child_node=tmp;
                }
            }
            if(parent_node==null || child_node==null) {
                System.out.println(INVALID_NODE_ID);
            }
            else {
                parent_node.deleteChild(child_node);
                child_node.deleteParent(parent_node);
                System.out.println("Dependency removed ");
            }
        } catch(NumberFormatException e) {
            System.out.println(INVALID_INPUT);
        }
    }
    static void delNode() {
        System.out.println("Enter node id of node to be deleted");
        try {
            int node_id=Integer.parseInt(scanner.next());
            GraphNodes graph_nodes=new GraphNodes();
            graph_nodes.deleteNode(node_id);
        } catch(NumberFormatException e) {
            System.out.println(INVALID_INPUT);
        }
    }
    static void addDependency() {
        System.out.println("Enter parent node_id");
        try {
            int parent_id=Integer.parseInt(scanner.next());
            System.out.println("Enter child node_id");
            int child_id=Integer.parseInt(scanner.next());
            ArrayList<Node> nodeList=GraphNodes.getNodeList();
            Node parent_node=null;
            Node child_node=null;
            for(Node tmp:nodeList) {
                if(tmp.getNodeid()==parent_id) {
                    parent_node=tmp;
                }
                if(tmp.getNodeid()==child_id) {
                    child_node=tmp;
                }
            }
            if(parent_node==null || child_node==null) {
                System.out.println(INVALID_NODE_ID);
            }
            else {
                parent_node.addChild(child_node);
                child_node.addParent(parent_node);
                System.out.println("Dependency added ");
            }
        } catch(NumberFormatException e) {
            System.out.println(INVALID_INPUT);
        }
    }
    static void addNode() {
        System.out.println("Enter node_id");
        try {
            int node_id=Integer.parseInt(scanner.next());
            if(uniqueId.contains(node_id)) {
                System.out.println("Unique Id is required!");
            } else {
                uniqueId.add(node_id);
                System.out.println("Enter node name!");
                String node_name=scanner.next();
                GraphNodes graph_nodes=new GraphNodes();
                graph_nodes.createNode(node_id, node_name);
                System.out.println("Node added!");
            }
        } catch(NumberFormatException e) {
            System.out.println(INVALID_INPUT);
        }
    }
}




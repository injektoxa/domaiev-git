package helpers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kozlov on 7/5/2016.
 */
public class Node<T> {
    private List<Node<T>> children = new ArrayList<Node<T>>();
    private Node<T> parent = null;
    private T data = null;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setParent(Node<T> parent) {
        parent.children.add(this);
        if(this.parent!=null) {
            this.parent.children.remove(this);
        }
        this.parent = parent;
    }

    public void addChild(T data) {
        Node<T> child = new Node<T>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Node<T> child) {
        if(child.parent!=null) {
            child.parent.children.remove(child);
        }
        child.parent = this;
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if(this.children.size() == 0)
            return true;
        else
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }

    public boolean equals(Node other){
        if(!data.equals(other.data))
            return false;
        if(children.size()!=other.children.size())
            return false;
        else{
            for (int i = 0; i < children.size(); i++) {
                if(!children.get(i).equals((Node)other.children.get(i)))
                    return false;
            }
        }
        return true;
    }
}

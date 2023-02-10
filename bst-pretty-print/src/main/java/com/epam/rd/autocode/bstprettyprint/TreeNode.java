package com.epam.rd.autocode.bstprettyprint;

public class TreeNode implements PrintableTree {
    private int i;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int i) {
        this.i = i;
    }

    public TreeNode() {
    }

    @Override
    public void add(int i) {
        if (i > this.i) {
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(i);
            } else {
                this.rightChild.add(i);
            }
        } else {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(i);
            } else {
                this.leftChild.add(i);
            }
        }
    }

    @Override
    public String prettyPrint() {

        StringBuilderPlus builder = new StringBuilderPlus();
        prettyPrint(builder, "", "", "", "");

        return builder.toString();
    }

    public void print() {
        StringBuilderPlus res = new StringBuilderPlus();
        prettyPrint(res, "", "", "", "");
    }

    public void prettyPrint(StringBuilderPlus result, String prefix, String left, String mid, String right) {
        String indent = " ".repeat(String.valueOf(i).length());
        if (leftChild != null) {
            leftChild.prettyPrint(result, prefix + left + indent, " ", "┌", "│");
        }
        result.appendLine(prefix + mid + i
                + " ┐┘┤".charAt((leftChild != null ? 2 : 0)
                + (rightChild != null ? 1 : 0)));
        if (rightChild != null) {
            rightChild.prettyPrint(result, prefix + right + indent, "│", "└", " ");
        }
    }
}
class StringBuilderPlus {

    private StringBuilder sb;

    public StringBuilderPlus(){
        sb = new StringBuilder();
    }

    public void append(String str)
    {
        sb.append(str != null ? str : "");
    }

    public void appendLine(String str)
    {
        sb.append(str != null ? str.stripTrailing() : "").append(System.getProperty("line.separator"));
    }

    public String toString()
    {
        return sb.toString();
    }
}


class BinaryTree implements PrintableTree {
    private TreeNode root;

    public void Print() {
        if (root != null) {
            root.print();
        }
    }

    public void add(int i) {
        if (root == null) {
            root = new TreeNode(i);
        } else {
            root.add(i);
        }
    }

    @Override
    public String prettyPrint() {
        if (root != null) {
            return root.prettyPrint();
        }
        return "";
    }
}

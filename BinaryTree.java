package com.benjuma;

import java.util.*;

public class BinaryTree<E> {
    // Root and children
    protected E root;
    protected BinaryTree<E> left, right;

    // Constructor with only root value
    public BinaryTree(E root) {
        this.root = root;
    }

    // Constructor with root and children
    public BinaryTree(E root, BinaryTree<E> left, BinaryTree<E> right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    // PreOrder Iterator
    public class PreOrder implements Iterator<E> {
        private boolean rootDone = false;
        private Iterator<E> lIt, rIt;

        public PreOrder() {
            if (left != null) lIt = left.new PreOrder();
            if (right != null) rIt = right.new PreOrder();
        }

        public boolean hasNext() {
            return !rootDone || (lIt != null && lIt.hasNext()) || (rIt != null && rIt.hasNext());
        }

        public E next() {
            if (!rootDone) {
                rootDone = true;
                return root;
            }
            if (lIt != null && lIt.hasNext()) return lIt.next();
            if (rIt != null && rIt.hasNext()) return rIt.next();
            return null;
        }
    }

    // InOrder Iterator
    public class InOrder implements Iterator<E> {
        private boolean rootDone = false;
        private Iterator<E> lIt, rIt;

        public InOrder() {
            if (left != null) lIt = left.new InOrder();
            if (right != null) rIt = right.new InOrder();
        }

        public boolean hasNext() {
            return (lIt != null && lIt.hasNext()) || !rootDone || (rIt != null && rIt.hasNext());
        }

        public E next() {
            if (lIt != null && lIt.hasNext()) return lIt.next();
            if (!rootDone) {
                rootDone = true;
                return root;
            }
            if (rIt != null && rIt.hasNext()) return rIt.next();
            return null;
        }
    }

    // PostOrder Iterator
    public class PostOrder implements Iterator<E> {
        private boolean rootDone = false;
        private Iterator<E> lIt, rIt;

        public PostOrder() {
            if (left != null) lIt = left.new PostOrder();
            if (right != null) rIt = right.new PostOrder();
        }

        public boolean hasNext() {
            return (lIt != null && lIt.hasNext()) || (rIt != null && rIt.hasNext()) || !rootDone;
        }

        public E next() {
            if (lIt != null && lIt.hasNext()) return lIt.next();
            if (rIt != null && rIt.hasNext()) return rIt.next();
            if (!rootDone) {
                rootDone = true;
                return root;
            }
            return null;
        }
    }

    // LevelOrder Iterator
    public class LevelOrder implements Iterator<E> {
        private Queue<BinaryTree<E>> queue = new LinkedList<>();

        public LevelOrder() {
            if (BinaryTree.this != null) queue.add(BinaryTree.this);
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

        public E next() {
            BinaryTree<E> current = queue.poll();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            return current.root;
        }
    }

    // Override toString for a meaningful output
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(sb, this, "", "");
        return sb.toString();
    }

    private void toStringHelper(StringBuilder sb, BinaryTree<E> node, String prefix, String childPrefix) {
        if (node == null) return;
        sb.append(prefix).append(node.root).append("\n");
        toStringHelper(sb, node.left, childPrefix + "├── ", childPrefix + "│   ");
        toStringHelper(sb, node.right, childPrefix + "└── ", childPrefix + "    ");
    }
}

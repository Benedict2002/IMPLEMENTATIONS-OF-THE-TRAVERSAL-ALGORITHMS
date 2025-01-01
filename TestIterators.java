package com.benjuma;

import java.util.Iterator;

public class TestIterators {
    public static void main(String[] args) {
        // Construct the binary tree
        BinaryTree<String> e = new BinaryTree<>("E");
        BinaryTree<String> g = new BinaryTree<>("G");
        BinaryTree<String> h = new BinaryTree<>("H");
        BinaryTree<String> i = new BinaryTree<>("I");
        BinaryTree<String> d = new BinaryTree<>("D", null, g);
        BinaryTree<String> f = new BinaryTree<>("F", h, i);
        BinaryTree<String> b = new BinaryTree<>("B", d, e);
        BinaryTree<String> c = new BinaryTree<>("C", f, null);
        BinaryTree<String> tree = new BinaryTree<>("A", b, c);

        // Print the tree structure
        System.out.println("Tree Structure:");
        System.out.println(tree);

        // PreOrder Traversal
        System.out.print("PreOrder Traversal: ");
        for (Iterator<String> it = tree.new PreOrder(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }

        // InOrder Traversal
        System.out.print("\nInOrder Traversal: ");
        for (Iterator<String> it = tree.new InOrder(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }

        // PostOrder Traversal
        System.out.print("\nPostOrder Traversal: ");
        for (Iterator<String> it = tree.new PostOrder(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }

        // LevelOrder Traversal
        System.out.print("\nLevelOrder Traversal: ");
        for (Iterator<String> it = tree.new LevelOrder(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
    }
}

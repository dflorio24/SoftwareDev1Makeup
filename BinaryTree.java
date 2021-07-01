// Java program to construct binary tree from
// given array in level order fashion

import java.util.Arrays;
  
public class BinaryTree {
    Node root;
  
    // Tree Node
    static class Node {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
  
    // Function to insert nodes in level order
    public Node insertLevelOrder(int[] arr, Node root,
                                                int i)
    {
        
        // Base case for recursion
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            System.out.println(i + " ");
            root = temp;
            
  
            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                                            2 * i + 1  );
  
            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                                            2 * i + 2   );
        }
        return root;
    }
  
    // Function to print tree nodes in InOrder fashion
    public void inOrder(Node root)
    {
        
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data + " ");
            inOrder(root.right);
        }
    }
   
   //Function to print tree nodes post Order fashion

    public void postOrder(Node root)  
    {
          if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data + " ");
            
        }
    }

   //Function to print tree nodes pre Order fashion

     public void preOrder(Node root)  
    {
          if (root != null) {
            System.out.println(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
           
            
        }
    }
    //See if an element exists
    static boolean ifNodeExists( Node node, int key)
   {
        if (node == null)
            return false;
 
        if (node.data == key)
            return true;
 
        // recursion  on left side of tree 
        boolean leftfind = ifNodeExists(node.left, key);
   
        // node found, return
        if(leftfind) return true;
 
   
        // search on right side of tree
        boolean rightfind = ifNodeExists(node.right, key);
 
        return rightfind;
    }

     //Finding the height of the tree entails computing the maximum Height of the tree,
     //meaning the number of nodes along the longest path from the root node to the furthest
     //removed leaf node

     
    int maxHeight(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the Height of each subtree */
            int lHeight = maxHeight(node.left);
            int rHeight = maxHeight(node.right);
  
            /* use the larger one */
            if (lHeight > rHeight)
                return (lHeight + 1);
             else
                return (rHeight + 1);
        }
    }

   // This routine calculates the minimum value in the tree

    int minvalue(Node node) {
        Node current = node;
  
        
        while (current.left != null) {
            current = current.left;
        }
        return (current.data);
    }
  

    // This routine derrives the maximum value of the tree - the rightmost node
    static int maxvalue(Node node)
    {
        /* loop down to find the rightmost leaf */
        Node current = node;
        while (current.right != null)
            current = current.right;
     
        return (current.data);
    }

  
      
    // Function to find k'th largest element in BST
    // Here count denotes the number
    // of nodes processed so far
    public static Node kthSmallest(Node root, int k)
        
    {
        int count = 0;
        // base case
        if (root == null)
            return null;
      
        // search in left subtree
        Node left = kthSmallest(root.left, k);
      
        // if k'th smallest is found in left subtree, return it
        if (left != null)
            return left;
      
        // if current element is k'th smallest, return it
        count++;
        if (count == k)
            return root;
      
        // else search in right subtree
        return kthSmallest(root.right, k);
    }
      
    // Function to find k'th largest element in BST
    public static void printKthSmallest(Node root, int k)
    {
        // maintain an index to count number of
        // nodes processed so far
         int  count = 0;
         
          Node res = kthSmallest(root, k);
          if (res == null)
            System.out.println("There are less "
                        + "than k nodes in the BST");
        else
            System.out.println("K-th Smallest"
                    + " Element is " + res.data);
    }

    //Depth of Tree
    int maxDepth(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }

   //Breadth of Tree
    int maxWidth(Node node)
    {
        int maxWidth = 0;
        int width;
        int h = 3; //already gotten height of node
        int i;
 
        /* Get width of each level and compare
           the width with maximum width so far */
        for (i = 1; i <= h; i++) {
            width = getWidth(node, i);
            if (width > maxWidth)
                maxWidth = width;
        }
 
        return maxWidth;
    }
 
    /* Get width of a given level */
    int getWidth(Node node, int level)
    {
        if (node == null)
            return 0;
 
        if (level == 1)
            return 1;
        else if (level > 1)
            return getWidth(node.left, level - 1)
                + getWidth(node.right, level - 1);
        return 0;
    }
 
      
      
      
 
   
    // Driver program to test above function
    public static void main(String args[])
    {
        BinaryTree t2 = new BinaryTree();
        int arr[] = {10,20,30,40,50,60,70 };
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        System.out.println("\nElements of the Binary Tree pre Order: ");
        t2.preOrder(t2.root);
        System.out.println("\nElements of the Binary Tree In Order: ");
        t2.inOrder(t2.root);
        System.out.println("\nElements of the Binary Tree post Order: ");
        t2.postOrder(t2.root);

        //search for a particular element

         int key = 40;
         System.out.println("\nFound a Specific element " + key); 
         if (ifNodeExists(t2.root, key))
             System.out.println("YES");
         else
             System.out.println("NO");

         //Height of the Tree
          System.out.println("\nHeight of tree is : " +
                                      t2.maxHeight(t2.root));

        //Smallest element of Tree
        System.out.println("\nSmallest value of tree is " + t2.minvalue(t2.root));

        //largest element of Tree
        System.out.println("\nLargest value of tree is " + t2.maxvalue(t2.root));

       //Nth smallest element of Tree
        int n = 3;
        t2.printKthSmallest(t2.root, n);
       // System.out.println("\n" + n +"th smallest value of tree is " + t2.printKthSmallest(t2.root, n);
       //   System.out.println("\nCOME BACK TO NTH SMALLEST VALUE");

       //Deleting elements from the tree

       //Tree Reorganization and printing elements from the tree
       //System.out.println("\nTree Regorganization after delete ");

      
       //Depth First Search
       System.out.println("\nDepth of tree is : " + t2.maxDepth(t2.root));

       //Breadth First Search
       System.out.println("\nBreadth of tree is : " + t2.maxWidth(t2.root));
   
    }
}
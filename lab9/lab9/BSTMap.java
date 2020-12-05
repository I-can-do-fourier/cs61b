package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.princeton.cs.algs4.BST;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author TJU-loser
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;
        private int size;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v,int s) {
            key = k;
            value = v;
            size=s;

        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    private Node removed;

    private Node parent=null;

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {

        if(p==null){

            return null;
        }else if(key.compareTo(p.key)<0){

            return getHelper(key,p.left);

        }else if(key.compareTo(p.key)>0){

            return getHelper(key,p.right);
        }else {


                return p.value;

        }

    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {

          return getHelper(key,root);

    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {

        if(p==null){

            p=new Node(key,value,1);

            return p;
        }else if(key.compareTo(p.key)<0){

            p.left=putHelper(key,value,p.left);

        }else if(key.compareTo(p.key)>0){

            p.right=putHelper(key,value,p.right);


        }else{

            p.value=value;

        }

        p.size=1+size(p.left)+size(p.right);

        return p;
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */


    @Override
    public void put(K key, V value) {


            root=putHelper(key,value,root);


    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {


        return size(root);

    }

    private int size(Node p){

        if(p==null){

            return 0;

        }


        return p.size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {

        Set<K> keys=new HashSet<>();

        keySet(root,keys);

        return keys;
    }


    private void keySet(Node p,Set keys){

            if(p==null){

                return;

            }else{

                keys.add(p.key);
                keySet(p.left,keys);
                keySet(p.right,keys);

            }


    }

/*
    public Node find_parent(K key){

            if(key==root.key){

                return null;
            }

            if

    }
*/

    private int num_children(Node p){

        int count=0;

        if(p==null){

            return 0;
        }


        if(p.left!=null){

            count++;

        }if(p.right!=null){

            count++;

        }

        return count;

    }


    private Node find_nearest_leftnode(Node p){




        if(p.right==null){


            return p;
        }

        parent=p;

        p.size--;


        return find_nearest_leftnode(p.right);


    }



    private Node remove_reshape(Node p){

       switch (num_children(p)){


           case 0:
               return null;

           case 1:

               if(p.left!=null){

                    return p.left;

               }else {

                   return p.right;

               }

           default:



                Node new_boss=find_nearest_leftnode(p.left);
                Node temp=new_boss.left;
                Node boss_parent=parent;

               if(boss_parent!=null){

                   new_boss.left=p.left;
                   new_boss.right=p.right;




                   parent.right=temp;

               }else{

                      new_boss.right=p.right;



           }

                new_boss.size=p.size-1;

                p=null;

                return new_boss;


       }





    }


    private Node removehelper(K key,Node p){

        if(p==null){

            removed=null;
            return null;

        }else if(key.compareTo(p.key)==0){


              removed=p;



              return remove_reshape(p);


        }else if(key.compareTo(p.key)<0){


             p.left=removehelper(key,p.left);

        }else if(key.compareTo(p.key)>0){


             p.right=removehelper(key,p.right);

        }


        parent=null;

        p.size=1+size(p.left)+size(p.right);

        return p;

    }


    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {


        root=removehelper(key,root);


        if (removed==null){

            return null;
        }



        return removed.value;
        //throw new UnsupportedOperationException();
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}

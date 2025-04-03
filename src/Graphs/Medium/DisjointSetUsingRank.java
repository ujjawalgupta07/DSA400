package Graphs.Medium;

import java.util.*;

public class DisjointSetUsingRank {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSetUsingRank(int n){
        for(int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    public int findUParent(int n){
        if(n == parent.get(n)){
            return n;
        }

        int par = findUParent(parent.get(n));
        parent.set(n, par);
        return parent.get(n);
    }

    public void union(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u == ulp_v){
            return;
        }

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }
        else{
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, ulp_u + 1);
        }
    }

    public static void main(String[] args) {
        DisjointSetUsingRank ds = new DisjointSetUsingRank(4);
        ds.union(0,1);
        ds.union(1, 2);
        ds.union(2, 3);
        if(ds.findUParent(1) == ds.findUParent(4)){
            System.out.println("same parent");
        }
        else{
            System.out.println("Not same parent");
        }
        ds.union(3, 4);
        if(ds.findUParent(1) == ds.findUParent(4)){
            System.out.println("same parent");
        }
        else{
            System.out.println("Not same parent");
        }
    }

}

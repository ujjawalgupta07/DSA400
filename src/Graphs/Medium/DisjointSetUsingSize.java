package Graphs.Medium;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetUsingSize {

    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSetUsingSize(int n){

        for(int i = 0 ; i <= n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int n){
        if(n == parent.get(n)){
            return n;
        }

        int par = parent.get(n);
        parent.set(n, par);
        return parent.get(n);
    }

    public void union(int x, int y){
        int ulp_x = findUParent(x);
        int ulp_y = findUParent(y);

        if(ulp_x == ulp_y){
            return;
        }

        if(size.get(ulp_x) < size.get(ulp_y)){
            parent.set(ulp_x, ulp_y);
            size.set(ulp_y, size.get(ulp_x) + size.get(ulp_y));
        }
        else{
            parent.set(ulp_y, ulp_x);
            size.set(ulp_x, size.get(ulp_x) + size.get(ulp_y));
        }
    }

    public static void main(String[] args) {
        DisjointSetUsingSize ds = new DisjointSetUsingSize(4);
        ds.union(0,1);
        ds.union(1, 2);
        ds.union(2, 3);
        if(ds.findUParent(1) == ds.findUParent(3)){
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

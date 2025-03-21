package Graphs.Medium;

//There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
//
//You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
//
//
//
//Example 1:
//
//
//Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
//Output: 700
//Explanation:
//The graph is shown above.
//The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
//Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
//Example 2:
//
//
//Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
//Output: 200
//Explanation:
//The graph is shown above.
//The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
//Example 3:
//
//
//Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
//Output: 500
//Explanation:
//The graph is shown above.
//The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
//
//
//Constraints:
//
//1 <= n <= 100
//0 <= flights.length <= (n * (n - 1) / 2)
//flights[i].length == 3
//0 <= fromi, toi < n
//fromi != toi
//1 <= pricei <= 104
//There will not be any multiple flights between two cities.
//0 <= src, dst, k < n
//src != dst

import java.util.*;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //6.28
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(src, 0, -1));
        price[src] = 0;
        stops[src] = -1;

        while(!pq.isEmpty()){
            Pair currPair = pq.remove();
            int currCity = currPair.city;
            int currPrice = currPair.price;
            int currStops = currPair.stops;

            ArrayList<Pair> neighbourCities = adj.get(currCity);
            for(Pair neighbourCity : neighbourCities){
                if(neighbourCity.price + currPrice < price[neighbourCity.city] && currStops + 1 <= k){
                    price[neighbourCity.city] = neighbourCity.price + currPrice ;
                    stops[neighbourCity.city] = currStops + 1;
                    pq.add(new Pair(neighbourCity.city, price[neighbourCity.city], stops[neighbourCity.city]));
                }
            }
        }

        if(stops[dst] <= k){
            return price[dst];
        }
        return -1;

    }

    class Pair{
        int city;
        int price;
        int stops;

        public Pair(int city, int price){
            this.city = city;
            this.price = price;
        }

        public Pair(int city, int price, int stops){
            this.city = city;
            this.price = price;
            this.stops = stops;
        }
    }
}

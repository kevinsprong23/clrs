package com.kevinsprong;

public class RodCutting {
	
	// wrapper class to hold answer
	public static class RodCut {
		int price;
	    int[] pieceLengths;
	    
	    public RodCut(int p, int[] lens) {
	    	this.price = p;
	    	this.pieceLengths = lens;
	    }
	}
	
	// compute the answer with dp
	public static RodCut optimalCutRod(int n, int[] prices) {
		// memoization for answer
		int[] priceCache = new int[n + 1];
		int[] moveCache = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			priceCache[i] = Integer.MIN_VALUE;
			moveCache[i] = Integer.MIN_VALUE;
		}
		
		// now can recurse
		return new RodCut(
				optimalCutRodAux(n, prices, priceCache, moveCache),
				moveCache);
	}
	
	public static int optimalCutRodAux(int n, int[] prices, 
			int[] priceCache, int[] moveCache) {
		if (priceCache[n] > 0) {
			return priceCache[n];
		} 
		int q;  // local max revenue
		if (n == 0) {
			q = 0;
		} else {
			q = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++) {
				int qq = prices[i - 1] + optimalCutRodAux(n - i, prices,
						priceCache, moveCache);
				if (q < qq) {
					q = qq;
					moveCache[n] = i;
				}
			}
		}
		priceCache[n] = q;
		return q;
	}
	
	public static void printCutRodSolution(int n, int[] prices) {
		RodCut solution = optimalCutRod(n, prices);
		System.out.println("Best price = " + Integer.toString(solution.price));
		System.out.println("Best lengths:");
		while (n > 0) {
			System.out.println(solution.pieceLengths[n]);
			n -= solution.pieceLengths[n];
		}
	}
	
	// the example from CLRS
	public static void main(String[] args) {
		printCutRodSolution(7, new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30});
	}
}

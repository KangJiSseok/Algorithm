import java.util.Arrays;

class UF{
	public int[] p;

	public UF(int n){
		p = new int[n];

		for(int i=0; i<n; i++){
			p[i] = i;
		}
	}

	public boolean union(int a, int b){
		int pa = find(a), pb = find(b);

		if(pa == pb) return false;

		p[pb] = pa;
		return true;

	}

	public int find(int t){
		if(p[t] == t){
			return p[t];
		}

		return p[t] = find(p[t]);
	}
}

class L3108 {

	public int[] minimumCost(int n, int[][] edges, int[][] query) {

		UF uf = new UF(n);

		for(int i=0; i< edges.length; i++){
			int s = edges[i][0];
			int e = edges[i][1];
			uf.union(s,e);
		}

		int[] cAnd = new int[n];
		Arrays.fill(cAnd,-1);
		for(int i = 0; i<edges.length; i++){
			int findRoot = uf.find(edges[i][0]);
			cAnd[findRoot] &= edges[i][2];
		}

		int[] result = new int[query.length];
		for(int i=0; i< query.length; i++){
			int fs = uf.find(query[i][0]);
			int fe = uf.find(query[i][1]);

			if(fs == fe){
				result[i] = cAnd[fs];
			}
			else result[i] = -1;

		}

		return result;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {
	static int[] visited;
	static int T;
	static List<Character> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		list.add('1');

		while(T-- > 0){
			visited = new int[10000];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			bfs(A, B);
		}

		System.out.println(sb.toString());

	}

	static void bfs(int origin, int target){
		Queue<Main.DSLR> q = new LinkedList<>();
		q.add(new Main.DSLR(origin));

		while(!q.isEmpty()){
			Main.DSLR p = q.poll();

			if(p.n == target){
				sb.append(p.path).append("\n");
				return;
			}

			if(visited[p.D()] == 0){
				q.add(new Main.DSLR(p.D() , p.path + "D"));
				visited[p.D()] = 1;
			}
			if(visited[p.S()] == 0){
				q.add(new Main.DSLR(p.S() , p.path + "S"));
				visited[p.S()] = 1;
			}
			if(visited[p.L()] == 0){
				q.add(new Main.DSLR(p.L() , p.path + "L"));
				visited[p.L()] = 1;
			}
			if(visited[p.R()] == 0){
				q.add(new Main.DSLR(p.R() , p.path + "R"));
				visited[p.R()] = 1;
			}
		}

	}




	static class DSLR{
		int n;
		String path = "";

		public DSLR(int n){
			this.n = n;
		}

		public DSLR(int n, String path){
			this.n = n;
			this.path = path;
		}


		int D(){
			return (2 * n) % 10000;
		}

		int S(){
			return (n - 1) < 0 ? 9999 : n - 1;
		}

		int L(){
			return (n % 1000 * 10) + (int)(n / 1000);
		}

		int R(){
			return (n%10) * 1000 + (int) (n/10) ;
		}
	}
}

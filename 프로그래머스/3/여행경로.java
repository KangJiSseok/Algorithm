import java.util.Arrays;

public class 여행경로 {
	static int columnSize;
	static int[] visited;
	static String result;
	static boolean a = false;

	public String[] solution(String[][] tickets) {
		columnSize = tickets.length;
		visited = new int[columnSize];

		Arrays.sort(tickets, (o1, o2) -> {
			if(o1[0].equals(o2[0])){
				return o1[1].compareTo(o2[1]);
			}
			return o1[0].compareTo(o2[0]);
		});


		dfs("ICN",0,"ICN ",tickets);
		return result.split(" ");
	}


	public void dfs(String cur, int depth, String path ,String[][] tickets){

		if(depth == columnSize && !a){
			result = path;
			a = true;
			return;
		}

		for(int i=0; i<tickets.length; i++){
			if(cur.equals(tickets[i][0]) && visited[i] == 0){
				visited[i] = 1;
				dfs(tickets[i][1],depth+1, path + tickets[i][1] + " ", tickets);
				visited[i] = 0;
			}
		}

	}
}

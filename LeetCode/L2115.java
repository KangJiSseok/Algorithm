import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class L2115 {
	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < supplies.length; i++) {
			set.add(supplies[i]);
		}

		HashMap<String, Integer> recipeIndexMap = new HashMap<>();
		for (int i = 0; i < recipes.length; i++) {
			recipeIndexMap.put(recipes[i], i);
		}

		ArrayList<String>[] graph = new ArrayList[recipes.length];
		for (int i = 0; i < recipes.length; i++) {
			graph[i] = new ArrayList<>(ingredients.get(i));
		}

		List<String> result = new ArrayList<>();

		for (int i = 0; i < recipes.length; i++) {
			if (dfs(recipes[i], set, graph, recipeIndexMap, new HashSet<>())) {
				result.add(recipes[i]);
			}
		}

		return result;
	}

	private boolean dfs(String recipe, Set<String> set, ArrayList<String>[] graph, Map<String, Integer> recipeIndexMap, Set<String> visited) {
		if (visited.contains(recipe)) {
			return false;
		}

		if (!recipeIndexMap.containsKey(recipe)) {
			return false;
		}

		visited.add(recipe);
		int idx = recipeIndexMap.get(recipe);

		for (String ingredient : graph[idx]) {
			if (!set.contains(ingredient)) {
				if (!dfs(ingredient, set, graph, recipeIndexMap, visited)) {
					return false;
				}
			}
		}

		visited.remove(recipe);
		set.add(recipe);
		return true;
	}

}



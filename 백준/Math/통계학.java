import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 통계학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		list.sort(((o1, o2) -> {
			return Integer.compare(o1, o2);
		}));

		System.out.println(Math.round(list.stream().mapToInt(i -> i).average().orElse(0)));

		System.out.println(list.get(N / 2));

		Map<Integer, Long> freqMap = list.stream()
			.collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		long maxFreq = Collections.max(freqMap.values());

		List<Integer> modeCandidates = freqMap.entrySet().stream()
			.filter(e -> e.getValue() == maxFreq)
			.map(Map.Entry::getKey)
			.sorted()
			.collect(Collectors.toList());

		int mode = modeCandidates.size() > 1 ? modeCandidates.get(1) : modeCandidates.get(0);
		System.out.println(mode);

		System.out.println(list.stream().reduce(Integer::max).get() - list.stream().reduce(Integer::min).get());
	}
}

/**
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 */

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {

	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAO();
		List<StudentVo> list = dao.fetch();
		//System.out.println(list);
		/*
		for(StudentVo temp : list) {
			//출력하는 메소드의 인스턴스 이름을 대입하면 toString의 결과
			System.out.println(temp);
		}*/
		
		//Stream 생성 // 위에와 똑같은 결과가 생성된다.
		Stream <StudentVo> stream = list.stream();
		//데이터를 전부 출력
		//데이터를 2개 건너띄고 3개 출력
		//stream.skip(2).limit(3).forEach(data -> System.out.println(data));
		
		//남자인 데이터만 출력 // 골라낼때는 filter을 써준다.
		//stream.filter(data -> data.getGender().equals("남자")).forEach(data -> System.out.println(data));
	
		//데이터 정렬하기 - score 숫자는 - 로 오름 내림차순으로 한다.
		//stream.sorted((d1,d2) -> d1.getScore() - d2.getScore()).forEach(data -> System.out.println(data));
		//정렬 2 - 글자를 오름 내림차순(comareTo)
		//stream.sorted((d1,d2) -> d1.getName().compareTo(d2.getName())).forEach(data -> System.out.println(data));
	
		/*//받아서 출력한다.
		long cnt = stream.count();
		System.out.println(cnt);*/
		
		//Optional로 리턴되는 데이터는 한번 더 가공을 해야 합니다.
		/*
		StudentVo vo = stream.findFirst().get();
		System.out.println(vo);
		*/
		
		//score의 합계 구하기
		//숫자 데이터가 아니면 바로 합계를 구할 수 없기 때문에
		//map 메소드를 이용해서 숫자 데이터로 변경한 후 합게를 구해야 합니다.
		/*int a = stream.mapToInt(StudentVo::getScore).sum();
		System.out.println("합계 = " + a);
		*/
		//age의 평균구하기
		//double a = stream.mapToInt(StudentVo::getAge).average().getAsDouble();
		//System.out.println("평균 = " + a);
		
		//성별이 남자인 데이터의 평균 점수를 구하는데 소수 1째 자리에서 반올림해서 정수부분만 출력
		/*double a = stream.filter(data -> data.getGender().equals("남자")).mapToInt(StudentVo::getScore).average().getAsDouble();
		int score = (int)(a + 0.5);
		System.out.println("남자 평균 점수 :" + score);*/
		
		//성별이 여자 인 데이터만 가지고 List 생성
		/*List<StudentVo> list1 = stream.filter(data -> data.getGender().equals("여자")).collect(Collectors.toList());
		for(StudentVo temo : list1) {
			System.out.println(temo);
		}*/
		
		
		//이름과 점수만을 갖는 Map 으로 생성
		/*Map<String,Integer> map = 
				stream.collect(Collectors.toMap(StudentVo::getName, StudentVo::getScore));
		System.out.println(map);
		*/
		/*Map<String,Integer> map = 
		stream.collect(Collectors.toMap(StudentVo::getName, data->data.getScore()));
		System.out.println(map);
		*/
		
		//성별이 남자이고 score가 90이상인 데이터의 List를 생성해서 출력
	/*	List<StudentVo> list1 = stream.filter(data -> data.getGender().equals("남자") && data.getScore() >= 80).collect(Collectors.toList());
		for(StudentVo temp : list1) {
			System.out.println(temp);
		}*/
		//grupingBy 에 작성한 함수의 결과를 Key로 하고
		// 원래 데이터의 List를 값으로 해서 Map으로 리턴합니다.
	/*	Map<String, List<StudentVo>> map = 
		stream.collect(Collectors.groupingBy(StudentVo::getGender));
		System.out.println(map);
		*/
		//집계
		/*Map<String, IntSummaryStatistics> map = 
				stream.collect(Collectors.groupingBy(StudentVo::getGender, Collectors.summarizingInt(StudentVo::getScore)));
				System.out.println(map);
				
		*/
		
		//gender 별로 score의 합계를 정수로 출력
		Map<String, Integer> map = 
			stream.collect(Collectors.groupingBy(StudentVo::getGender, Collectors.summingInt(StudentVo::getScore)));
		//System.out.println(map);
		
		//Map의 데이터 전부 출력하기 // 키를 알지 못해도 전부 읽을 수있다 강점
		Set<String> keyset = map.keySet();
		for(String key : keyset) {
			System.out.println(key + ":" + map.get(key));
		}
		
	}

}

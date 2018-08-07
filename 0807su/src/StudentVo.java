
public class StudentVo {
	// 테이블의 각 컬럼의 값들을 저장하기 위해서 생성
	private String num;
	private String name;
	private String subject;
	private int score;
	private int age;
	private String gender;
	
	// 인스턴스 생성을 할 때 데이터를 바로 대입해서 생성하면 
	// 메소드 호출 횟수를 줄일 수 있기 때문에 생성
	public StudentVo() {
		super();
	}
	
	public StudentVo(String num, String name, String subject, int score, int age, String gender) {
		super();
		this.num = num;
		this.name = name;
		this.subject = subject;
		this.score = score;
		this.age = age;
		this.gender = gender;
	}

	// 인스턴스 변수를 private으로 생성했기 때문에
	// 인스턴스가 사용할 수 없어서 인스턴스 변수를 사용하기 위한 메소드
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	// 데이터를 빠르게 확인하기 위해서 - 디버깅(데이터를 빠르게 확인 하는 것)을 위해서
	@Override
	public String toString() {
		return "StudentVo [num=" + num + ", name=" + name + ", subject=" + subject + ", score=" + score + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
}

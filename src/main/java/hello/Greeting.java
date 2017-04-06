package hello;

import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;

public class Greeting {

	private final long id;
	private final String studentname2;
	private final long studentcode;
	private final long year22;
	private final long schoolcode;
	private final String schoolname;
	private final String Option;
	private final String State;
	private final String percent;
	private String error;

	public Greeting(long id, String studentname2, long studentcode, long year22, long schoolcode, String schoolname,
			String Option, String State, String percent) {
		this.id = id;
		this.studentname2 = studentname2;
		this.studentcode = studentcode;
		this.year22 = year22;
		this.schoolcode = schoolcode;
		this.schoolname = schoolname;
		this.Option = Option;
		this.State = State;
		this.percent=percent;
	}



	public long getYear22() {
		return year22;
	}

	public long getId() {
		return id;
	}

	public String getStudentname2() {
		return studentname2;
	}

	public long getStudentcode() {
		return studentcode;
	}

	public long getSchoolcode() {
		return schoolcode;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public String getOption() {
		return Option;
	}

	public String getState() {
		return State;
	}

	public String getPercent() {
		return percent;
	}


}

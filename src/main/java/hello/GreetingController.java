package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

	private static final String template = "L'étudiant, %s!";
	private static final String error = "Prince Kabuika";
	private static final long studentcode = 12;
	private static final long schoolcode = 1234;
	// private static final long year2 =2016;
	private static final String schoolname = "Complexe Scolaire Mr Nzita";
	private static final String Option = "Commercial Administrative";
	private static final String State = "Bas-Congo";
	private static final String percent = 13 + "%";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value={"/result/{studentname2}/{year2}"},method=RequestMethod.GET )
	
	public Greeting greeting(		
			@PathVariable(value = "studentname2") String studentname2,
			@PathVariable(value = "year2") long year2
			) {
		return new Greeting(counter.incrementAndGet(), String.format(template, studentname2), studentcode, year2,
				schoolcode, schoolname, Option, State, percent);
	}
	
	

}

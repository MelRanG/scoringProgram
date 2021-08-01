import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class StudentTest {
    private Student student;
    private Subject subject;
    private Score score;
    private BasicEvalution basicEvalution;
    private MajorEvalution majorEvalution;
    private School school;


    @Before
    public void 생성자(){
        subject = new Subject("math", 1001);
        student = new Student(20101521, "김민석", subject);
        basicEvalution = new BasicEvalution();
        majorEvalution = new MajorEvalution();
        school = School.getInstance();
    }


    @Test
    public void 학점테스트(){
        String basic = basicEvalution.getGrade(score.getPoint());
        String major = majorEvalution.getGrade(score.getPoint());
        assertThat("D", equalTo(basic));
        assertThat("F", equalTo(major));
    }

    @Test
    public void 학교테스트(){

        school.addSubject(subject);
        school.addStudent(student);

        ArrayList<Subject> subjectList = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();
        subjectList.add(subject);
        studentList.add(student);

        assertThat(school.getStudentList(), equalTo(studentList));
        assertThat(school.getSubjectList(), equalTo(subjectList));
    }

    @Test
    public void 과목에학생추가테스트(){
        subject.register(student);
    }
    @Test
    public void 학생에점수추가테스트(){
        student.addSubjectScore(score);
    }

}

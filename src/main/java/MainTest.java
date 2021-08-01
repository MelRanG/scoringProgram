public class MainTest {
    School goodSchool = School.getInstance();
    Subject korean;
    Subject math;

    GradeReport gradeReport = new GradeReport();

    public static void main(String[] args) {
        MainTest test = new MainTest();

        test.createSubject();
        test.createStudent();

        String report = test.gradeReport.getReport(); //성적 결과 생성
        System.out.println(report);
    }

    public void createSubject(){
        korean = new Subject("국어", 1001);
        math = new Subject("수학", 2002);

        goodSchool.addSubject(korean);
        goodSchool.addSubject(math);
    }

    public void createStudent(){
        Student student1 = new Student(181213, "안성원", korean);
        Student student2 = new Student(181215, "김각두", math);
        Student student3 = new Student(181219, "박성원", korean);

        goodSchool.addStudent(student1);
        goodSchool.addStudent(student2);
        goodSchool.addStudent(student3);

        korean.register(student1);
        korean.register(student2);
        korean.register(student3);

        math.register(student1);
        math.register(student2);

        addScoreForStudent(student1, korean, 95);
        addScoreForStudent(student2, math, 95);
        addScoreForStudent(student3, korean, 95);

    }

    public void addScoreForStudent(Student student, Subject subject, int point){
        Score score = new Score(student.getStudentId(), subject, point);
        student.addSubjectScore(score);
    }
}

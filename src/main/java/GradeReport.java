import java.util.ArrayList;

public class GradeReport {
    private StringBuffer buffer = new StringBuffer();
    School school = School.getInstance();

    public String getReport(){
        ArrayList<Subject> subjectList = school.getSubjectList();

        for(Subject subject: subjectList){
            makeBody(subject);
        }
        return buffer.toString();
    }

    public void makeBody(Subject subject){
        ArrayList<Student> studentList = subject.getStudentList();

        for(int i = 0; i < studentList.size(); i++){
            Student student = studentList.get(i);
            buffer.append(student.getStudentName());
            buffer.append(" | ");
            buffer.append(student.getStudentId());
            buffer.append(" | ");
            buffer.append(student.getMajorSubject().getSubjectName());

            getScoreGrade(student, subject.getSubjectId());
        }
    }

    public void getScoreGrade(Student student, int subjectId){
        ArrayList<Score> scoreList = student.getScoreList();
        int majorId = student.getMajorSubject().getSubjectId();

        GradeEvalution[] gradeEvalutions = {new BasicEvalution(), new MajorEvalution()};

        for(int i = 0; i < scoreList.size(); i++){
            Score score = scoreList.get(i);
            if(score.getSubject().getSubjectId() == subjectId){ // 학점 산출할 과목
                String grade;
                if(score.getSubject().getSubjectId() == majorId) // 필수 과목인 경우
                    grade = gradeEvalutions[0].getGrade(score.getPoint());
                else // 일반 과목인 경우
                    grade = gradeEvalutions[1].getGrade(score.getPoint());
            buffer.append(score.getPoint());
            buffer.append(":");
            buffer.append(grade);
            }
        }
    }
}

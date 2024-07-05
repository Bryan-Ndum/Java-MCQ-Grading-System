import java.util.ArrayList;
public class Exam {
//define data fields
private String courseName;
private String studentName;
private ArrayList<Integer> examQuestionScoreList;
// define constructors
public Exam(String courseName) {
this.courseName = courseName;
this.examQuestionScoreList = new ArrayList<Integer>();
}
public Exam(String studentName, String courseName, ArrayList<Integer>
examQuestionScoreList) {
this.studentName = studentName;
this.courseName = courseName;
this.examQuestionScoreList = examQuestionScoreList;
}
// define methods
public String getCourseName() {
return courseName;
}
public void setCourseName(String courseName) {
this.courseName = courseName;
}
public String getStudentName() {
return studentName;
}
public void setStudentName(String studentName) {
this.studentName = studentName;
}
public ArrayList<Integer> getExamQuestionScoreList() {
return examQuestionScoreList;
}
public void setExamQuestionScoreList(ArrayList<Integer> examQuestionScoreList)
{
this.examQuestionScoreList = examQuestionScoreList;
}
public int getExamScore() {
int score = 0; //to store total score
for (Integer questionScore : examQuestionScoreList) {
score += questionScore;
}
return score;
}
}

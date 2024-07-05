import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class TestGrading {
public static void main(String[] args) {
// Create a new Teacher instance
Teacher teacher = new Teacher("src/Grading/Solutions.txt",
"src/Grading/StudentAnswers/");
// Read the solution file and set the solution list
ArrayList<String> solutionList =
teacher.readDataFromFile(teacher.getSolutionFilePath());
teacher.setSolutionList(solutionList);
// Grade all the student exams
ArrayList<Exam> exams = teacher.gradeAllStudents();
// Print out the scores for each student
for (Exam exam : exams) {
System.out.println(exam.getStudentName() + ": " + exam.getExamScore());
}
// Write the scores to a file named StudentScore.txt
try {
FileWriter writer = new FileWriter("src/Grading/StudentScore.txt");
for (Exam exam : exams) {
writer.write(exam.getStudentName() + ": " + exam.getExamScore() + "\
n");
}
writer.close();
System.out.println("Successfully wrote the student scores to
StudentScore.txt.");
} catch (IOException e) {
System.out.println("Error writing the student scores to StudentScore.txt: "
+ e.getMessage());
}
// Write the statistical result into a text file named QuestionsStatistics.txt
try {
BufferedWriter writer = new BufferedWriter(new
FileWriter("src/Grading/StatisticsWriter.txt"));
writer.write("Question\tCorrect\tIncorrect\n");
for (int i = 0; i < solutionList.size(); i++) {
int correct = 0;
int incorrect = 0;
for (Exam exam : exams) {
ArrayList<Integer> scoreList = exam.getExamQuestionScoreList();
if (scoreList.get(i) == 1) {
correct++;
} else {
incorrect++;
}
}
writer.write("Q" + (i+1) + "\t" + correct + "\t" + incorrect + "\n");
}
writer.close();
System.out.println("Statistical result has been written to
QuestionsStatistics.txt.");
} catch (IOException e) {
System.out.println("Error: " + e.getMessage());
}
}
}

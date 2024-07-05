import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Teacher {
// define solutionFilePath and myfile variables
String solutionFilePath = "src/Grading/Solutions.txt";
File myfile = new File(solutionFilePath);
// define studentAnswersDirectoryPath and myfile2 variables
String studentAnswersDirectoryPath = "src/Grading/StudentAnswers/";
File myfile2 = new File(studentAnswersDirectoryPath);
// create an empty solutionList ArrayList
private ArrayList<String> solutionList;
// Constructor with solutionFilePath and studentAnswersDirectoryPath parameters
public Teacher(String solutionFilePath, String studentAnswersDirectoryPath) {
// set the solutionFilePath and studentAnswersDirectoryPath variables to
the constructor parameters
this.solutionFilePath = solutionFilePath;
this.studentAnswersDirectoryPath = studentAnswersDirectoryPath;
// initialize the solutionList ArrayList
this.solutionList = new ArrayList<>();
}
// Setter method for solutionFilePath variable
public void setSolutionFilePath(String solutionFilePath) {
this.solutionFilePath = solutionFilePath;
}
// Getter method for solutionFilePath variable
public String getSolutionFilePath() {
return solutionFilePath;
}
// Setter method for studentAnswersDirectoryPath variable
public void setstudentAnswersDirectoryPath(String studentAnswersDirectoryPath)
{
this.studentAnswersDirectoryPath = studentAnswersDirectoryPath;
}
// Getter method for studentAnswersDirectoryPath variable
public String getstudentAnswersDirectoryPath() {
return studentAnswersDirectoryPath;
}
// Setter method for solutionList variable
public void setSolutionList(ArrayList<String> solutionList) {
this.solutionList = solutionList;
}
// Getter method for solutionList variable
public ArrayList<String> getSolutionList() {
return solutionList;
}
// Method to read data from a file and return an ArrayList of Strings
public ArrayList<String> readDataFromFile(String filePath) {
// create an empty ArrayList to store the data from the file
ArrayList<String> dataList = new ArrayList<>();
try {
// create a Scanner object to read from the file
Scanner scanner = new Scanner(new File(filePath));
// loop through each line of the file
while (scanner.hasNextLine()) {
// read the line and remove any leading or trailing whitespace
String line = scanner.nextLine().trim();
// if the line is not empty, add it to the dataList ArrayList
if (!line.isEmpty()) {
dataList.add(line);
}
}
scanner.close(); // close the Scanner object
} catch (FileNotFoundException e) {
// if the file is not found, print an error message and exit the
program
System.out.println("Error: Could not open file " + filePath);
System.exit(1);
}
return dataList; // return the ArrayList of data from the file
}
// Create an ArrayList of solutions by calling the readDataFromFile method with
the solutionFilePath variable
public ArrayList<String> solutions = readDataFromFile(solutionFilePath);
// Method to grade one exam and return an ArrayList of scores
public ArrayList<Integer> gradingOneExam(String studentAnswerFilePath) {
// create an empty ArrayList to store the scores
ArrayList<Integer> scoreList = new ArrayList<>();
try {
// create a Scanner object to read from the student answer file
Scanner scanner = new Scanner(new File(studentAnswerFilePath));
// loop through each solution and compare it to the student's answer
for (int i = 0; i < solutionList.size(); i++) {
String solution = solutionList.get(i); // get the solution from the
solutionList ArrayList
String answer = scanner.nextLine().trim(); // read the student
if (answer.equals(solution)) {
scoreList.add(1);
} else {
scoreList.add(0);
}
}
scanner.close();
} catch (FileNotFoundException e) {
System.out.println("Error: Could not open file " +
studentAnswerFilePath);
System.exit(1);
}
return scoreList;
}
// Creating a method to grade all students
public ArrayList<Exam> gradeAllStudents() {
ArrayList<Exam> examList = new ArrayList<>();
File folder = new File(studentAnswersDirectoryPath);
File[] files = folder.listFiles();
for (File file : files) {
if (file.isFile()) {
String fileName = file.getName();
String studentName = fileName.substring(0, fileName.indexOf('.'));
ArrayList<Integer> scoreList = gradingOneExam(file.getPath());
Exam exam = new Exam(studentName, getCourseName(), scoreList);
examList.add(exam);
}
}
return examList; }
private String getCourseName() {
// assume that the course name is stored as a string constant
final String COURSE_NAME = "Introduction to Object Oriented Programming";
return COURSE_NAME;
}
}

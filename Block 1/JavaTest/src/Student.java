public class Student {
    private String courseName;
    private int credit;
    private int examScore;
    private int assignmentScore;

    public Student(String courseName, int credit, int examScore, int assignmentScore) {
        this.courseName = courseName;
        this.credit = credit;
        this.examScore = examScore;
        this.assignmentScore = assignmentScore;
    }
    public Student() {
        this.courseName = "Unknown";
        this.credit = 0;
        this.examScore = 0;
        this.assignmentScore = 0;
    }

    public Student(Student student) {
        setCourseName(student.getCourseName());
        setCredit(student.getCredit());
        setExamScore(student.getExamScore());
        setAssignmentScore(student.getAssignmentScore());
    }

    public int calcFinalScore() {
        //I know integer division but there was nothing about it sooo
        return (examScore * 6 + assignmentScore * 4) / 10;
    }

    public boolean isPassed() {
        return calcFinalScore() >= 60;
    }

    public boolean equals(Student student) {
        return student.getAssignmentScore() == getAssignmentScore() &&
                student.getCredit() == getCredit() &&
                student.getExamScore() == getExamScore() &&
                student.getCourseName().equals(getCourseName());
    }

    public String toString() {
        return "AssScore : " + getAssignmentScore() + "\n" +
                "ExamScore : " + getExamScore() + "\n" +
                "Credit : " + getCredit() + "\n" +
                "CourseName : " + getCourseName() + "\n";
    }


    public String getCourseName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    public int getExamScore() {
        return examScore;
    }

    public int getAssignmentScore() {
        return assignmentScore;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    public void setAssignmentScore(int assignmentScore) {
        this.assignmentScore = assignmentScore;
    }
}

package mn.edu.must.sqat;

public class ScholarshipCalculator {

    public String letterGrade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D"; // Засвар: > 60 байсныг >= 60 болгож засав
        return "F";
    }

    public double gpa(double[] scores) {
        if (scores == null || scores.length == 0) {
            throw new IllegalArgumentException("Scores array cannot be null or empty");
        }
        double totalPoints = 0;
        for (double score : scores) {
            String grade = letterGrade(score);
            switch (grade) {
                case "A": totalPoints += 4.0; break;
                case "B": totalPoints += 3.0; break;
                case "C": totalPoints += 2.0; break;
                case "D": totalPoints += 1.0; break;
                case "F": totalPoints += 0.0; break;
                default: break;
            }
        }
        return totalPoints / scores.length;
    }

    public int scholarship(double gpa, int credits, boolean hasViolation) {
        if (gpa < 0 || gpa > 4.0 || credits < 0) {
            throw new IllegalArgumentException("Invalid GPA or credits");
        }
        if (hasViolation) {
            return 0;
        }
        if (gpa >= 3.8 && credits >= 15) {
            return 100;
        } else if (gpa >= 3.5 && credits >= 14) {
            return 70;
        } else if (gpa >= 3.0 && credits >= 12) {
            return 50;
        }
        return 0;
    }
}

package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScholarshipCalculatorTest {

    @Test
    public void testLetterGradeA() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    public void testGpaCalculation() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        double gpa = calc.gpa(new double[]{95.0, 85.0});
        assertEquals(3.5, gpa, 0.001);
    }

    @Test
    public void testScholarshipEligible() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        int amount = calc.scholarship(3.9, 16, false);
        assertEquals(100, amount);
    }

    @Test
    public void testLetterGradeB() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        assertEquals("B", calc.letterGrade(85));
    }

    @Test
    public void testLetterGradeC() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        assertEquals("C", calc.letterGrade(75));
    }

    @Test
    public void testLetterGradeD() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        assertEquals("D", calc.letterGrade(65));
    }

    @Test
    public void testLetterGradeF() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        assertEquals("F", calc.letterGrade(40));
    }

    // --- Part D: Boundary Value Tests (Зааг утгын тестүүд) ---
    @Test
    public void testLetterGradeBoundaries() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        assertEquals("D", calc.letterGrade(60));   // Spec: 60 should be D
        assertEquals("D", calc.letterGrade(69.99));
        assertEquals("F", calc.letterGrade(59.99)); // Spec: below 60 should be F
        assertEquals("A", calc.letterGrade(100));
        assertEquals("F", calc.letterGrade(0));
    }

    @Test
    public void testGpaDefaultSwitch() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        double gpa = calc.gpa(new double[]{50.0});
        assertEquals(0.0, gpa, 0.001);
    }

    @Test
    public void testGpaExceptions() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }

    @Test
    public void testScholarshipInputExceptions() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.1, 16, false));
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 16, false));
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.5, -1, false));
    }

    @Test
    public void testScholarshipTiers() {
        ScholarshipCalculator calc = new ScholarshipCalculator();
        assertEquals(70, calc.scholarship(3.6, 15, false));
        assertEquals(50, calc.scholarship(3.2, 13, false));
        assertEquals(0, calc.scholarship(0.0, 0, false));
        assertEquals(0, calc.scholarship(3.9, 16, true));
        assertEquals(0, calc.scholarship(2.0, 5, false));
    }
}

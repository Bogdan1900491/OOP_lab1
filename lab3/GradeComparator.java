package lab3;
import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Сортування за спаданням середнього балу
        return Double.compare(s2.getAverageGrade(), s1.getAverageGrade());
    }
}

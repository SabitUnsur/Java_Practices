package Collections;

import java.util.Comparator;

public class OrderByNoteComparable implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getNote() - student2.getNote();
    }
}

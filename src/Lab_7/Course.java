package Lab_7;

import java.util.ArrayList;

public record Course(int courseID, int creditPoints, int year, String fullName, ArrayList<Student> students) {
}

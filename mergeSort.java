package arrayListCT;
import java.util.ArrayList;

public class mergeSort {
	public static void mergeSort(ArrayList<student> students, studentComparater comparator) {
        int size = students.size();
        if (size > 1) {
            int mid = size / 2;
            ArrayList<student> leftList = new ArrayList<>(students.subList(0, mid));
            ArrayList<student> rightList = new ArrayList<>(students.subList(mid, size));

            mergeSort(leftList, comparator);
            mergeSort(rightList, comparator);

            merge(students, leftList, rightList, comparator);
        }

}
	private static void merge(
            ArrayList<student> students, ArrayList<student> leftList, ArrayList<student> rightList,
            studentComparater comparator
    ) {
        int leftSize = leftList.size();
        int rightSize = rightList.size();

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (comparator.compare(leftList.get(i), rightList.get(j)) < 0) {
                students.set(k++, leftList.get(i++));
            } else {
                students.set(k++, rightList.get(j++));
            }
        }

        while (i < leftSize) {
            students.set(k++, leftList.get(i++));
        }

        while (j < rightSize) {
            students.set(k++, rightList.get(j++));
        }
    }
	public static void main(String[] args) {
        // Creating an ArrayList of 10 Student objects
        ArrayList<student> students = new ArrayList<>();
        students.add(new student(101, "John", "123 Main St"));
        students.add(new student(102, "Alice", "456 Oak St"));
        students.add(new student(103, "Bob", "789 Pine St"));
        students.add(new student(104, "Eva", "567 Elm St"));
        students.add(new student(105, "David", "890 Cedar St"));
        students.add(new student(106, "Grace", "345 Birch St"));
        students.add(new student(107, "Frank", "678 Maple St"));
        students.add(new student(108, "Helen", "901 Walnut St"));
        students.add(new student(109, "Ian", "234 Spruce St"));
        students.add(new student(110, "Jessica", "567 Pine St"));

        // Sorting the ArrayList using merge sort
        mergeSort.mergeSort(students, new studentComparater());

        // Displaying the sorted ArrayList
        for (student student : students) {
            System.out.println(student);
        }
    }
}

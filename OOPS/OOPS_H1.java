import java.util.Arrays;

public class OOPS_H1 {
    private int[] data;

    public OOPS_H1(int[] values) {
        data = values;
    }

    // // Shallow Copy Constructor
    // public OOPS_H1(OOPS_H1 original) {
    //     data = original.data;
    // }

    // // Deep Copy Constructor
    // public OOPS_H1 deepCopy() {
    //     int[] newData = new int[data.length];
    //     System.arraycopy(data, 0, newData, 0, data.length);
    //     return new OOPS_H1(newData);
    // }

    // Lazy Copy Constructor
    public OOPS_H1 lazyCopy() {
        if (data == null) {
            return new OOPS_H1(null);
        }
        return new OOPS_H1(data);
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        int[] vals = {3, 7, 9};
        OOPS_H1 original = new OOPS_H1(vals);

        // // Shallow Copy
        // OOPS_H1 shallowCopy = new OOPS_H1(original);
        // shallowCopy.showData();
        // vals[0] = 13;
        // shallowCopy.showData();

        // // Deep Copy
        // OOPS_H1 deepCopy = original.deepCopy();
        // deepCopy.showData();
        // vals[0] = 3;
        // deepCopy.showData();

        // Lazy Copy
        OOPS_H1 lazyCopy = original.lazyCopy();
        lazyCopy.showData();
        vals[0] = 13;
        lazyCopy.showData();
    }
}

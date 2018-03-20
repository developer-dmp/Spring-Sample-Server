package sample.sum;

public class Sum {

    private long id;
    private int[] a;

    public Sum(long id, int... a) {
        this.id = id;
        this.a = a;
    }

    public int getSum() {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}

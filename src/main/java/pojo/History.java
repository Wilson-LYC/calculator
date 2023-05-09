package pojo;

public class History {
    public History(double a, String op, double b, double ans) {
        this.a = a;
        this.op = op;
        this.b = b;
        this.ans = ans;
    }

    //a+b=c
    double a;
    String op;
    double b;
    double ans;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getAns() {
        return ans;
    }

    public void setAns(double ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "History{"+a+" "+op+" "+b+" = "+ans+" }";
    }
}

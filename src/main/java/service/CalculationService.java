package service;

import pojo.History;

import java.util.ArrayList;

public class CalculationService {
    double num=0;
    String op="+";

    ArrayList<History> histories=new ArrayList<>();

    /**
     * @param b 接收的数字
     */
    public void addNum(double b){
        System.out.println("CService 接收数字:"+b);
        //提交了新数字，需要计算
        double a=num;
        num=this.run(a,op,b);
        History history=new History(a,op,b,num);
        histories.add(history);
        for (History history1 : histories) {
            System.out.println(history1.toString());
        }
    }

    public double run(double a,String op,double b){
        switch (op){
            case "+":a+=b;break;
            case "-":a-=b;break;
            case "×":a*=b;break;
            case "÷":a/=b;break;
        }
        return a;
    }

    public void addOp(String op) {
        System.out.println("CService 接收操作符:"+op);
        this.op=op;
    }

    public History getLastHis() {
        return histories.get(histories.size()-1);
    }
    public void reset(){
        num=0;
        op="+";
    }
    public ArrayList<History> getHis(){
        return histories;
    }

    public void rollBack(int id){
        History history=histories.get(id);
        num=history.getAns();
        op=history.getOp();
        histories.add(history);
    }
}

package service;

import controller.MainViewController;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pojo.History;
import tool.NumTool;
import view.HistoryView;

import java.util.ArrayList;

public class MainService {
    CalculationService cService;
    MainViewController mainViewController;
    public MainService(CalculationService cService,MainViewController mainViewController) {
        this.cService = cService;
        this.mainViewController=mainViewController;
    }

    NumTool numTool=new NumTool();
    double numTemp;
    String opTemp;
    //private int addNumMode=0;

    private int lastChange=0;//0数字 1操作符 3等于号
    public void intputNum(Label firstIn,Label secondIn,String ch){
        mainViewController.setFlagZero(true);
        if(lastChange==1){
            cService.addOp(opTemp);
        }
        if(lastChange==3){
            this.clear(secondIn,2);
            cService.reset();
        }
        String s=firstIn.getText();//获取当前文本
        if(s.length()>25){
            //字符过长，禁止输入
            Alert alert=new Alert(Alert.AlertType.WARNING,"字符数超限（长度<=25）");
            alert.show();
            return;
        }
        //新增字符
        switch (ch){
            case ".":{
                if(lastChange==1 || lastChange==3){
                    this.clear(firstIn,1);
                    s="0";
                }
                //小数点
                if(s.contains("."))
                    return;
                s+=".";
                break;}
            case "-":{
                //-号
                if(s.contains("-")){
                    //有-号，删除
                    s=s.replace("-","");
                }
                else {
                    //无-号，新增
                    s="-"+s;
                }
                break;}
            default:{
                if(lastChange==1 || lastChange==3){
                    this.clear(firstIn,1);
                    s="0";
                }
                //数字
                if(s.equals("0") || s.equals("除数不能为零") || s.equals("结果未定义")){
                    //覆盖
                    s=ch;
                }else {
                    //新增
                    s+=ch;
                }
            }
        }
        //输出
        numTemp= Double.parseDouble(s);
        this.output(firstIn,s,1);
        lastChange=0;
    }
    public void inputOp(Label firstIn,Label secondIn,String newOp){
        if(lastChange==0){
            cService.addNum(numTemp);
        }
        opTemp=newOp;
        lastChange=1;
        History history=cService.getLastHis();
        String text=numTool.dts(history.getAns())
                +" "+opTemp+" ";
        this.output(secondIn,text,2);
        text=numTool.dts(history.getAns());
        numTemp=history.getAns();
        this.output(firstIn,text,1);
    }
    public void delete(Label firstIn,Label secondIn){
        if(lastChange==1){
            cService.addOp(opTemp);
        }
        if(lastChange==3){
            this.clear(secondIn,2);
            return;
        }
        lastChange=0;
        String s=firstIn.getText();//获取当前文本
        if(s.length()>25){
            //字符过长，禁止输入
            Alert alert=new Alert(Alert.AlertType.WARNING,"字符数超限（长度<=25）");
            alert.show();
            return;
        }
        //删除字符
        s=s.substring(0,s.length()-1);
        //输出
        if(s.length()<=0){
            numTemp=0;
            s="0";
        }
        else
            numTemp= Double.parseDouble(s);
        this.output(firstIn,s,1);
    }
    public void output(Label label,String s,int mode){
        if(mode==1){
            //1号框
            if(s.length()<14){
                label.setFont(new Font("Arial",36));
                label.setText(s);
            }
        else if(s.length()<30){
                label.setFont(new Font("Arial",20));
                label.setText(s);
            }
        }else {
            //2号框
            if(s.length()<14){
                label.setFont(new Font("Arial",18));
                label.setText(s);
            }
            else if(s.length()<30){
                label.setFont(new Font("Arial",12));
                label.setText(s);
            }
        }
    }
    public void clear(Label label,int mode){
        if(mode==1){
            this.output(label,"0",1);
            numTemp=0;
        }
        else {
            this.output(label,"",mode);
        }
    }
    public void equal(Label firstIn,Label secondIn){
        if(lastChange==0){
            //输入完数字，等于。说明有数字未提交，提交数字
            cService.addNum(numTemp);
            History history=cService.getLastHis();
            String text=numTool.dts(history.getA())
                    +" "+history.getOp()+" "
                    +numTool.dts(history.getB())
                    +" = ";
            this.output(secondIn,text,2);
            text=numTool.dts(history.getAns());
            if(text.equals("除数不能为零") || text.equals("结果未定义")){
                mainViewController.setFlagZero(false);
            }
            this.output(firstIn,text,1);
            if(Math.abs(history.getAns())>1.0E20 || Math.abs(history.getAns())<1.0E-15){
                Alert alert=new Alert(Alert.AlertType.WARNING,"计算精度将出现错误！请谨慎操作");
                alert.showAndWait();
            }
        }else {
            //刚输入完操作符，等于。
            cService.addOp(opTemp);
            cService.addNum(numTemp);
            History history=cService.getLastHis();
            String text=numTool.dts(history.getA())
                    +" "+history.getOp()+" "
                    +numTool.dts(history.getB())
                    +" = ";
            this.output(secondIn,text,2);
            text=numTool.dts(history.getAns());
            if(text.equals("除数不能为零") || text.equals("结果未定义")){
                mainViewController.setFlagZero(false);
            }
            this.output(firstIn,text,1);
            if(Math.abs(history.getAns())>1.0E20 || Math.abs(history.getAns())<1.0E-15){
                Alert alert=new Alert(Alert.AlertType.WARNING,"计算精度将出现错误！请谨慎操作");
                alert.showAndWait();
            }
        }
        lastChange=3;
    }
    public void ceFuntion(CalculationService cService,Label firstIn,Label secondIn){
        mainViewController.setFlagZero(true);
        int flag=lastChange;
        if(flag==3){
            cService.reset();
            this.output(firstIn,"0",1);
            numTemp=0;
            this.output(secondIn,"",2);
            opTemp="+";
            lastChange=0;
        }else {
            this.output(firstIn,"0",1);
            numTemp=0;
            lastChange=0;
        }
    }
    public void  cFuntion(CalculationService cService,Label firstIn,Label secondIn){
        mainViewController.setFlagZero(true);
        cService.reset();
        this.output(firstIn,"0",1);
        numTemp=0;
        this.output(secondIn,"",2);
        opTemp="+";
        lastChange=0;
    }

    public void rollBackSelect(Label firstIn, Label secondIn){
        mainViewController.setFlagOperation(false);
        ArrayList<History> histories=cService.getHis();
        HistoryView historyView=new HistoryView(histories,this,firstIn,secondIn,mainViewController);
        historyView.start(new Stage());
    }

    public void rollBackToId(Label firstIn, Label secondIn, int id) {
        mainViewController.setFlagOperation(true);
        cService.rollBack(id);
        History history=cService.getLastHis();
        numTemp=history.getB();
        opTemp=history.getOp();
        String text=numTool.dts(history.getA())
                +" "+history.getOp()+" "
                +numTool.dts(history.getB())
                +" = ";
        this.output(secondIn,text,2);
        text=numTool.dts(history.getAns());
        this.output(firstIn,text,1);
        lastChange=3;
    }
}

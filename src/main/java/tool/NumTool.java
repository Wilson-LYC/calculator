package tool;

import java.text.NumberFormat;

public class NumTool {
    public String dts(double x){
        String res;
        if (Math.abs(x)<1.0E15 && Math.abs(x)>1.0E-3){
            //不使用科学计数法
            NumberFormat nf = NumberFormat.getInstance();
            nf.setGroupingUsed(false);
            res = nf.format(x);
        }
        else
            res= String.valueOf(x);
        if(res.equals("Infinity"))
            res="除数不能为零";
        if(res.equals("NaN"))
            res="结果未定义";
        return res;
    }
}

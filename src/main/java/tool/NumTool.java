package tool;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumTool {
    public String dts(double x){
        String res;
        if (Math.abs(x)<1.0E12 && Math.abs(x)>1.0E-7){
            //不使用科学计数法
            DecimalFormat nf = new DecimalFormat("###############.########");
            res = nf.format(x);
        }
        else{
            res = String.valueOf(x);
        }
        if(res.equals("Infinity"))
            res="除数不能为零";
        if(res.equals("NaN"))
            res="结果未定义";
        return res;
    }
}

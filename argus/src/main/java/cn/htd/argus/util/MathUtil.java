package cn.htd.argus.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MathUtil {

	public static double getPairToDouble(BigDecimal firstNum,BigDecimal sencondNum){
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
    	//可以设置精确几位小数  
        df.setMaximumFractionDigits(2);  
        //模式 例如四舍五入  
        df.setRoundingMode(RoundingMode.HALF_UP);  
    	double sort = Double.valueOf(df.format(firstNum.doubleValue()/sencondNum.doubleValue()*100));
    	return sort;
	}
}

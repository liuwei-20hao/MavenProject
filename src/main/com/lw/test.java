package lw;

import java.math.BigDecimal;

public class test {
    public static void main(String[] args) {
        BigDecimal bige =BigDecimal.valueOf(42.2);
        BigDecimal chj1 = BigDecimal.valueOf(20.00);
        BigDecimal chj2 = BigDecimal.valueOf(20.00);
        BigDecimal chj3 = BigDecimal.valueOf(2.2);
        BigDecimal a = chj1.add(chj2).add(chj3);
        if(bige.compareTo(a)==0){
            System.out.println(a);
        }else{
            System.out.println(bige.compareTo(a));
        }
    }

}

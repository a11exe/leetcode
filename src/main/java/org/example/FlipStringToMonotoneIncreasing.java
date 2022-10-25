package org.example;

public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int one = 0;
        int flip =0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                one++;
            else
                flip++;
            flip = Math.min(one,flip);
        }
        return flip;
    }

}

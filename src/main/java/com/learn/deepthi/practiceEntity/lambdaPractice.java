package com.learn.deepthi.practiceEntity;


interface square {
 int squaring(int s);
}
class lambda implements square {
    public int squaring(int s) {
        return s*s;
    }
}
/*public class lambdaPractice {
    public static void main(String[] args) {
        lambda l = new lambda();
        //System.out.println(l.squaring(6))
        int a = l.squaring(6);
        System.out.println(a);
    }
} */ //without using lambda

public class lambdaPractice {
    public static void main(String[] args) {
        square s = a->a*a; //writing same squaring code using lambda
        System.out.println(s.squaring(6));
    }
}



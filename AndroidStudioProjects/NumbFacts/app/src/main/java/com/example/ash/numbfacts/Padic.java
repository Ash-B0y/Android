package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Padic extends AppCompatActivity {
TextView t11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padic);
        this.setTitle("P-ADIC NUMBER");
        t11 = (TextView) findViewById(R.id.textView11);
        t11.setMovementMethod(new ScrollingMovementMethod());
        String pad="\n\n"+"P-ADIC NUMBER\n\n"+"A p-adic number is an extension of the field of rationals such that congruences modulo powers of a fixed prime p are related to proximity in the so called \"p-adic metric.\"\n" +
                "\n" +
                "Any nonzero rational number x can be represented by\n" +
                "\n" +
                " x=(p^ar)/s, \t\n" +
                "(1)\n" +
                "where p is a prime number, r and s are integers not divisible by p, and a is a unique integer. Then define the p-adic norm of x by\n" +
                "\n" +
                " |x|_p=p^(-a). \t\n" +
                "(2)\n" +
                "Also define the p-adic norm\n" +
                "\n" +
                " |0|_p=0. \t\n" +
                "(3)\n" +
                "The p-adics were probably first introduced by Hensel (1897) in a paper which was concerned with the development of algebraic numbers in power series. p-adic numbers were then generalized to valuations by Kűrschák in 1913. Hasse (1923) subsequently formulated the Hasse principle, which is one of the chief applications of local field theory. Skolem's p-adic method, which is used in attacking certain Diophantine equations, is another powerful application of p-adic numbers. Another application is the theorem that the harmonic numbers H_n are never integers (except for H_1). A similar application is the proof of the von Staudt-Clausen theorem using the p-adic valuation, although the technical details are somewhat difficult. Yet another application is provided by the Mahler-Lech theorem.\n" +
                "\n" +
                "Every rational x has an \"essentially\" unique p-adic expansion (\"essentially\" since zero terms can always be added at the beginning)\n" +
                "\n" +
                " x=sum_(j=m)^inftya_jp^j, \t\n" +
                "(4)\n" +
                "with m an integer,  a_j the integers between 0 and p-1 inclusive, and where the sum is convergent with respect to p-adic valuation. If x!=0 and a_m!=0, then the expansion is unique. Burger and Struppeck (1996) show that for p a prime and n a positive integer,\n" +
                "\n" +
                " |n!|_p=p^(-(n-A_p(n))/(p-1)), \t\n" +
                "(5)\n" +
                "where the p-adic expansion of n is\n" +
                "\n" +
                " n=a_0+a_1p+a_2p^2+...+a_Lp^L, \t\n" +
                "(6)\n" +
                "and\n" +
                "\n" +
                " A_p(n)=a_0+a_1+...+a_L. \t\n" +
                "(7)\n" +
                "For sufficiently large n,\n" +
                "\n" +
                " |n!|_p<=p^(-n/(2p-2)). \t\n" +
                "(8)\n" +
                "The p-adic valuation on Q gives rise to the p-adic metric\n" +
                "\n" +
                " d(x,y)=|x-y|_p, \t\n" +
                "(9)\n" +
                "which in turn gives rise to the p-adic topology. It can be shown that the rationals, together with the p-adic metric, do not form a complete metric space. The completion of this space can therefore be constructed, and the set of p-adic numbers Q_p is defined to be this completed space.\n" +
                "\n" +
                "Just as the real numbers are the completion of the rationals Q with respect to the usual absolute valuation |x-y|, the p-adic numbers are the completion of Q with respect to the p-adic valuation |x-y|_p. The p-adic numbers are useful in solving Diophantine equations. For example, the equation X^2=2 can easily be shown to have no solutions in the field of 2-adic numbers (we simply take the valuation of both sides). Because the 2-adic numbers contain the rationals as a subset, we can immediately see that the equation has no solutions in the rationals. So we have an immediate proof of the irrationality of sqrt(2).\n" +
                "\n" +
                "This is a common argument that is used in solving these types of equations: in order to show that an equation has no solutions in Q, we show that it has no solutions in an extension field. For another example, consider X^2+1=0. This equation has no solutions in Q because it has no solutions in the reals R, and Q is a subset of  R.\n" +
                "\n" +
                "Now consider the converse. Suppose we have an equation that does have solutions in R and in all the Q_p for every prime p. Can we conclude that the equation has a solution in Q? Unfortunately, in general, the answer is no, but there are classes of equations for which the answer is yes. Such equations are said to satisfy the Hasse principle.";
               t11.setText(pad);
    }
}

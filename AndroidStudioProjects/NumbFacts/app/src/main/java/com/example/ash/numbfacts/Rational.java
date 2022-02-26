package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Rational extends AppCompatActivity {
TextView t6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rational);
        this.setTitle("RATIONAL NUMBER");
        t6 = (TextView) findViewById(R.id.textView6);
        t6.setMovementMethod(new ScrollingMovementMethod());
        String rat="\n\n"+"DEFINITION\n\n" +
                "Mathematicians have taken all the numbers in the world and sorted them into categories, based on their characteristics. Generally, the categories, or sets, go from most to least complicated: complex numbers, imaginary numbers, real numbers, rational numbers, integers, whole numbers and natural numbers. Most numbers belong to more than one category.\n" +
                "\n" +
                "Here, we'll talk specifically about the category, or set, of rational numbers. The set of rational numbers:\n" +
                "\n" +
                "Consist of positive numbers, negative numbers and zero\n" +
                "Can be written as a fraction\n" +
                "The name rational is based on the word 'ratio.' A ratio is a comparison of two or more numbers and is often written as a fraction. A number is considered a rational number if it can be written as one integer divided by another integer. Sometimes this is referred to as a simple fraction.\n" +
                "\n" +
                "The number 1/2 is a rational number because it is written as the integer 1 divided by the integer 2. The number 5 is a rational number because we can write it as 5/1. We can also write it as 15/3 or 50/10 because 15 divided by 3 or 50 divided by 10 both equal 5. The mixed number 1 ½ is also a rational number because we can write it as 3/2.\n" +
                "\n" +
                "Any number that can be rewritten as a simple fraction is a rational number. This means that natural numbers, whole numbers and integers, like 5, are all part of the set of rational numbers as well because they can be written as fractions, as are mixed numbers like 1 ½.\n" +
                "\n" +
                "Rational numbers can be positive, negative or zero. When we write a negative rational number, we put the negative sign either out in front of the fraction or with the numerator. That's the standard mathematical notation. For example, we would write -5/7 as opposed to 5/-7.\n" +
                "\n" +
                "EXAMPLES OF RATIONAL NUMBERS\n\n" +
                "We mentioned earlier that natural numbers, whole numbers and integers are also rational numbers because they can be written as fractions. The simplest way to do this is to put the number over 1. For example: We can write 7 as 7/1; we can write -3 as -3/1; and we can write 0 as 0/1. Therefore, all of these numbers are rational numbers.\n" +
                "\n" +
                "Terminating decimals are rational numbers. A terminating decimal is a decimal that ends. All terminating decimals are rational numbers because they can be converted to fractions. We can write the decimal 1.2 as 12/10 or as 6/5. We can write 3.25 in a number of ways as a fraction, but one way is 325/100.\n" +
                "\n" +
                "Repeating decimals are rational numbers. Repeating decimals are decimals that do not end, but instead eventually repeat digits. It is possible to rewrite all repeating decimals as fractions. A great example of this is .33333. . . We can write that as the fraction 1/3. Try it for yourself - divide 1 by 3! You'll quickly see how the 3 repeats.";
        t6.setText(rat);
    }
}

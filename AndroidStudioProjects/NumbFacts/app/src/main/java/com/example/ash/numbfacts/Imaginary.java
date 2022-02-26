package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Imaginary extends AppCompatActivity {
    TextView t9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imaginary);
        this.setTitle("IMAGINARY NUMBER");
        t9 = (TextView) findViewById(R.id.textView9);
        t9.setMovementMethod(new ScrollingMovementMethod());
        String img="\n\n"+"INTRODUCTION TO THE IMAGINARY NUMBERS\n\n" +
                "Learn about the imaginary unit i, about the imaginary numbers, and about square roots of negative numbers.In your study of mathematics, you may have noticed that some quadratic equations do not have any real number solutions.\n" +
                "For example, try as you may, you will never be able to find a real number solution to the equation x^2=-1x\n" +
                "\u200B2\n" +
                "\u200B\u200B =−1x, start superscript, 2, end superscript, equals, minus, 1. This is because it is impossible to square a real number and get a negative number!\n" +
                "However, a solution to the equation x^2=-1x\n" +
                "\u200B2\n" +
                "\u200B\u200B =−1x, start superscript, 2, end superscript, equals, minus, 1 does exist in a new number system called the complex number system.\n" +
                "The imaginary unit\n" +
                "The backbone of this new number system is the imaginary unit, or the number iii.\n" +
                "The following is true of the number iii:\n" +
                "i=\\sqrt{-1}i=√\n" +
                "\u200B−1\n" +
                "\u200B\n" +
                "\u200B\u200B i, equals, square root of, minus, 1, end square root\n" +
                "i^2=-1i\n" +
                "\u200B2\n" +
                "\u200B\u200B =−1i, start superscript, 2, end superscript, equals, minus, 1\n" +
                "The second property shows us that the number iii is indeed a solution to the equation x^2=-1x\n" +
                "\u200B2\n" +
                "\u200B\u200B =−1x, start superscript, 2, end superscript, equals, minus, 1. The previously unsolvable equation is now solvable with the addition of the imaginary unit!\n" +
                "Pure imaginary numbers\n" +
                "The number iii is by no means alone! By taking multiples of this imaginary unit, we can create infinitely many more pure imaginary numbers.\n" +
                "For example, 3i3i3, i, i\\sqrt{5}i√\n" +
                "\u200B5\n" +
                "\u200B\n" +
                "\u200B\u200B i, square root of, 5, end square root, and -12i−12iminus, 12, i are all examples of pure imaginary numbers, or numbers of the form bibib, i, where bbb is a nonzero real number.\n" +
                "The fact that (3i)^2=-9(3i)\n" +
                "\u200B2\n" +
                "\u200B\u200B =−9left parenthesis, 3, i, right parenthesis, start superscript, 2, end superscript, equals, minus, 9 means that 3i3i3, i is a square root of -9−9minus, 9.\n\n"+"WHY DO WE HAVE IMAGINARY NUMBERS ANYWAY?\n\n" +
                "The answer is simple. The imaginary unit iii allows us to find solutions to many equations that do not have real number solutions.\n" +
                "This may seem weird, but it is actually very common for equations to be unsolvable in one number system but solvable in another, more general number system.\n" +
                "Here are some examples with which you might be more familiar.\n" +
                "With only the counting numbers, we can't solve x+8=1x+8=1x, plus, 8, equals, 1; we need the integers for this!\n" +
                "With only the integers, we can't solve 3x-1=03x−1=03, x, minus, 1, equals, 0; we need the rational numbers for this!\n" +
                "With only the rational numbers, we can't solve x^2=2x\n" +
                "\u200B2\n" +
                "\u200B\u200B =2x, start superscript, 2, end superscript, equals, 2. Enter the irrational numbers and the real number system!\n" +
                "And so, with only the real numbers, we can't solve x^2=-1x\n" +
                "\u200B2\n" +
                "\u200B\u200B =−1x, start superscript, 2, end superscript, equals, minus, 1. We need the imaginary numbers for this!\n" +
                "As you continue to study mathematics, you will begin to see the importance of these numbers.";
        t9.setText(img);
    }
}

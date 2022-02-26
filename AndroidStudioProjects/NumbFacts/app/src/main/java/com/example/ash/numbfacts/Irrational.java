package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Irrational extends AppCompatActivity {
 TextView t7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irrational);
        this.setTitle("IRRATIONAL NUMBER");
        t7 = (TextView) findViewById(R.id.textView7);
        t7.setMovementMethod(new ScrollingMovementMethod());
        String irrat="\n\n"+"WHAT ARE IRRATIONAL NUMBERS?\n\n" +
                "Outside of mathematics, we use the word 'irrational' to mean crazy or illogical; however, to a mathematician, irrational refers to a kind of number that cannot be written as a fraction (ratio) using only positive and negative counting numbers (integers). For example, you can write the rational number 2.11 as 211/100, but you cannot turn the irrational number 'square root of 2' into an exact fraction of any kind.\n" +
                "\n" +
                "Don't assume, however, that irrational numbers have nothing to do with insanity. Legend suggests that, around 500 B.C., a guy named Hippasus was thrown overboard from a ship by the Pythagoreans, a group of Greek philosophers, as punishment for proving that the square root of 2 is irrational.\n" +
                "\n" +
                "A mental trick you can use to help you visualize whether a number is rational or irrational is to think of the number in terms of cutting pizzas. For instance, if a number is rational, you can imagine cutting pizzas into equal-sized slices described by the denominator of a fraction and then eating the number of slices described by the numerator. For example, 6/8 can be found by cutting a pizza into 8 slices and then consuming 6 of those slices.\n" +
                "\n" +
                "For a number like 3.95, you imagine cutting pizzas into a hundred slices each and then taking 395 slices. While you'll probably never be quite that hungry, you can imagine it. A negative number like -3/10 is a little tougher, but you could still visualize it if you slice pizzas into tenths and then give back 3 slices.\n" +
                "\n" +
                "It's impossible to think of the square root of 5 that way. While there might be some other way to figure out how to get exactly the square root of 5 pizzas, you can't do it by cutting the pizza into any set number of equal slices and then taking the correct share of those.\n" +
                "\n" +
                "In most cases, the best we can do to visualize an irrational number is approximate it with a decimal number.\n" +
                "\n" +
                "Let's look at some common irrational numbers.\n" +
                "\n\n" +
                "ROOTS\n\n" +
                "Some of the most common irrational numbers are roots, such as the square root of 5 or the cube root of 7. Square roots, cube roots, and roots of any higher power are often irrational, as long as they can't be simplified in a way that the radical (square root) symbol vanishes.\n" +
                "\n" +
                "Sometimes we write irrational numbers approximately as decimal numbers, but we can never do it exactly because the decimal places go on forever and never fall into a repeating pattern.As the unlucky Hippasus demonstrated, there is no way to write the square root of 2 as an exact fraction. It is irrational. (Square root of 2 = 1.41421356...).\n" +
                "\n" +
                "On the other hand, -5.2 can be written as -52/10, which means that it's a rational number, and even the Pythagoreans wouldn't issue a death sentence over it.\n" +
                "\n\n" +
                "PI\n\n" +
                "The circumference of a circle divided by its diameter is always a little more than 3. In fact, the result of this division is an irrational number that we commonly refer to as pi.\n" +
                "\n" +
                "Symbol for pi\n" +
                "pi symbol\n" +
                "Pi is part of a group of special irrational numbers that are sometimes called transcendental numbers. These numbers cannot be written as roots, like the square root of 11.\n" +
                "\n" +
                "Many people remember the first few digits of pi: 3.14. Remembering those digits can be helpful, but it is not exact since pi goes on indefinitely (pi = 3.141592...). As of 2011, people have discovered more than 5 trillion digits of pi, but we'll never get to the end of it, because there is no end!";
                t7.setText(irrat);
    }
}

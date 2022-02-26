package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Complex extends AppCompatActivity {
TextView t8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);
        this.setTitle("COMPLEX NUMBER");
        t8 = (TextView) findViewById(R.id.textView8);
        t8.setMovementMethod(new ScrollingMovementMethod());
        String comp="\n\n"+"Imaginary numbers have an intuitive explanation: they “rotate” numbers, just like negatives make a “mirror image” of a number. This insight makes arithmetic with complex numbers easier to understand, and is a great way to double-check your results. Here’s our cheatsheet:\n" +
                "\n\n" +
                "COMPLEX ARITHMETIC OPERATIONS\n\n" +
                "\n" +
                "This post will walk through the intuitive meanings.\n" +
                "\n\n" +
                "COMPLEX VARIABLES\n\n" +
                "In regular algebra, we often say “x = 3″ and all is dandy — there’s some number “x”, whose value is 3. With complex numbers, there’s a gotcha: there’s two dimensions to talk about. When writing\n" +
                "\n" +
                "\\displaystyle{z = 3 + 4i}\n" +
                "\n\n" +
                "COMPLEX NUMBER EXAMPLE\n\n" +
                "\n" +
                "we’re saying there’s a number “z” with two parts: 3 (the real part) and 4i (imaginary part). It is a bit strange how “one” number can have two parts, but we’ve been doing this for a while. We often write:\n" +
                "\n" +
                "\\displaystyle{y = 3\\frac{4}{10} = 3 + .4}\n" +
                "\n" +
                "and it doesn’t bother us that a single number “y” has both an integer part (3) and a fractional part (.4 or 4/10). Y is a combination of the two. Complex numbers are similar: they have their real and imaginary parts “contained” in a single variable (shorthand is often Re and Im).\n" +
                "\n" +
                "Unfortunately, we don’t have nice notation like (3.4) to “merge” the parts into a single number. I had an idea to write the imaginary part vertically, in fading ink, but it wasn’t very popular. So we’ll stick to the “a + bi” format.\n" +
                "\n\n" +
                "MEASURING SIZE\n\n" +
                "Because complex numbers use two independent axes, we find size (magnitude) using the Pythagorean Theorem:\n" +
                "\n\n" +
                "COMPLEX MAGNITUDE\n\n" +
                "\n" +
                "So, a number z = 3 + 4i would have a magnitude of 5. The shorthand for “magnitude of z” is this: |z|\n" +
                "\n" +
                "See how it looks like the absolute value sign? Well, in a way, it is. Magnitude measures a complex number’s “distance from zero”, just like absolute value measures a negative number’s “distance from zero”.\n" +
                "\n\n" +
                "COMPLEX ADDITION AND SUBTRACTION\n\n" +
                "We’ve seen that regular addition can be thought of as “sliding” by a number. Addition with complex numbers is similar, but we can slide in two dimensions (real or imaginary). For example:\n" +
                "\n\n" +
                "COMPLEX ADDITION\n\n" +
                "\n" +
                "Adding (3 + 4i) to (-1 + i) gives 2 + 5i.\n" +
                "\n" +
                "Again, this is a visual interpretation of how “independent components” are combined: we track the real and imaginary parts separately.\n" +
                "\n" +
                "Subtraction is the reverse of addition — it’s sliding in the opposite direction. Subtracting (1 + i) is the same as adding -1 * (1 + i), or adding (-1 – i).\n" +
                "\n\n" +
                "COMPLEX MULTIPLICATION\n\n" +
                "Here’s where the math gets interesting. When we multiply two complex numbers (x and y) to get z:\n" +
                "\n" +
                "Add the angles: angle(z) = angle(x) + angle(y)\n" +
                "Multiply the magnitudes: |z| = |x| * |y|\n" +
                "That is, the angle of z is the sum of the angles of x and y, and the magnitude of z is the product of the magnitudes. Believe it or not, the magic of complex numbers makes the math work out!\n" +
                "\n" +
                "Multiplying by the magnitude (size) makes sense — we’re used to that happening in regular multiplication (3 × 4 means you multiply 3 by 4′s size). The reason the angle addition works is more detailed, and we’ll save it for another time. (Curious? Find the sine and cosine addition formulas and compare them to how (a + bi) * (c + di) get multiplied out).\n" +
                "\n" +
                "Time for an example: let’s multiply z = 3 + 4i by itself. Before doing all the math, we know a few things:\n" +
                "\n" +
                "The resulting magnitude will be 25. z has a magnitude of 5, so |z| * |z| = 25.\n" +
                "The resulting angle will be above 90. 3 + 4i is above 45 degrees (since 3 + 3i would be 45 degrees), so twice that angle will be more than 90.\n" +
                "With our predictions on paper, we can do the math:\n" +
                "\n" +
                "\\displaystyle{(3 + 4i) * (3 + 4i) = 9 + 16i^2 + 24i = -7 + 24i}\n" +
                "\n" +
                "Time to check our results:\n" +
                "\n" +
                "Magnitude: sqrt((-7 * -7) + (24 * 24)) = sqrt(625) = 25, which matches our guess.\n" +
                "Angle: Since -7 is negative and 24i is positive, we know we are going “backwards and up”, which means we’ve crossed 90 degrees (“straight up”). Getting geeky, we compute atan(24/-7) = 106.2 degrees (keeping in mind we’re in quadrant 2). This guess checks out too.\n" +
                "Nice. While we can always do the math out, the intuition about rotations and scaling helps us check the result. If the resulting angle was less than 90 (“forward and up”, for example), or the resulting magnitude not 25, we’d know there was a mistake in our math.\n" +
                "\n\n" +
                "COMPLEX DIVISION\n\n" +
                "Division is the opposite of multiplication, just like subtraction is the opposite of addition. When dividing complex numbers (x divided by y), we:\n" +
                "\n" +
                "Subtract angles angle(z) = angle(x) – angle(y)\n" +
                "Divide by magnitude |z| = |x| / |y|\n" +
                "Sounds good. Now let’s try to do it:\n" +
                "\n" +
                "\\displaystyle{\\frac{3 + 4i}{1 + i}}\n" +
                "\n" +
                "Hrm. Where to start? How do we actually do the division? Dividing regular algebraic numbers gives me the creeps, let alone weirdness of i (Mister mister! Didya know that 1/i = -i? Just multiply both sides by i and see for yourself! Eek.). Luckily there’s a shortcut.\n" +
                "\n\n" +
                "INTRODUCING COMPLEX CONJUGATES\n\n" +
                "Our first goal of division is to subtract angles. How do we do this? Multiply by the opposite angle! This will “add” a negative angle, doing an angle subtraction.\n" +
                "\n\n" +
                "COMPLEX CONJUGATE EXAMPLE\n\n" +
                "\n" +
                "Instead of z = a + bi, think about a number z* = a – bi, called the “complex conjugate”. It has the same real part, but is the “mirror image” in the imaginary dimension. The conjugate or “imaginary reflection” has the same magnitude, but the opposite angle!\n" +
                "\n" +
                "So, multiplying by a – bi is the same as subtracting an angle. Neato.\n" +
                "\n\n" +
                "MULTIPLY COMPLEX CONJUGATE\n\n" +
                "\n" +
                "Complex conjugates are indicated by a star (z*) or bar above the number — mathematicians love to argue about these notational conventions. Either way, the conjugate is the complex number with the imaginary part flipped:\n" +
                "\n" +
                "\\displaystyle{z = a + bi}\n" +
                "\n" +
                "Note that b doesn’t have to be “negative”. If z = 3 – 4i, then z* = 3 + 4i.\n" +
                "\n\n" +
                "MULTIPLYING BY THE CONJUGATE\n\n" +
                "What happens if you multiply by the conjugate? What is z times z*? Without thinking, think about this:\n" +
                "\n" +
                "\\displaystyle{z \\cdot z^* = 1 \\cdot z \\cdot z^*}\n" +
                "\n" +
                "So we take 1 (a real number), add angle(z), and add angle (z*). But this last angle is negative — it’s a subtraction! So our final result should be a real number, since we’ve canceled the angles. The number should be |z|^2 since we scaled by the size twice.\n" +
                "\n" +
                "Now let’s do an example: \\displaystyle{(3 + 4i) * (3 - 4i) = 9 - 16i^2 = 25}\n" +
                "\n" +
                "We got a real number, like we expected! The math fans can try the algebra also:\n" +
                "\n" +
                "\\displaystyle{(a + bi) * (a - bi) = a^2 + abi - abi -b^2i^2 = a^2 + b^2 }\n" +
                "\n" +
                "Tada! The result has no imaginary parts, and is the magnitude squared. Understanding complex conjugates as a “negative rotation” lets us predict these results in a different way.\n" +
                "\n\n" +
                "SCALING YOUR NUMBERS\n\n" +
                "When multiplying by a conjugate z*, we scale by the magnitude |z*|. To reverse this effect we can divide by |z|, and to actually shrink by |z| we have to divide again. All in all, we have to divide by |z| * |z| to the original number after multiplying by the conjugate.\n" +
                "\n\n" +
                "SHOW ME THE DIVISION!\n\n" +
                "I’ve been sidestepping the division, and here’s the magic. If we want to do\n" +
                "\n" +
                "\\displaystyle{\\frac{3 + 4i}{1 + i}}\n" +
                "\n\n" +
                "WE CAN APPROACH IT INTUITIVELY:\n\n" +
                "\n" +
                "Rotate by opposite angle: multiply by (1 – i) instead of (1 + i)\n" +
                "Divide by magnitude squared: divide by |sqrt(2)|^2 = 2\n" +
                "The answer, using this approach, is:\n" +
                "\n" +
                "\\displaystyle{\\frac{3 + 4i}{1 + i} = (3 + 4i) \\cdot (1 - i) \\cdot \\frac{1}{2} = (3 - 4i^2 + 4i - 3i) \\cdot \\frac{1}{2} = \\frac{7}{2} + \\frac{1}{2}i}\n" +
                "\n" +
                "The more traditional “plug and chug” method is to multiply top and bottom by the complex conjugate:\n" +
                "\n" +
                "\\displaystyle{\\frac{3 + 4i}{1 + i} = \\frac{3 + 4i}{1 + i} \\cdot \\frac{1 - i}{1 - i} = \\frac{3 - 4i^2 + 4i - 3i}{1 - i^2} = \\frac{7 + i}{2}}\n" +
                "\n" +
                "We’re traditionally taught to “just multiply both sides by the complex conjugate” without questioning what complex division really means. But not today.\n" +
                "\n" +
                "We know what’s happening: division is subtracting an angle and shrinking the magnitude. By multiplying top and bottom by the conjugate, we subtract by the angle of (1-i), which happens to make the denominator a real number (it’s no coincidence, since it’s the exact opposite angle). We scaled both the top and bottom by the same amount, so the effects cancel. The result is to turn division into a multiplication in the numerator.\n" +
                "\n" +
                "Both approaches work (you’re usually taught the second), but it’s nice to have one to double-check the other.";
        t8.setText(comp);
    }
}

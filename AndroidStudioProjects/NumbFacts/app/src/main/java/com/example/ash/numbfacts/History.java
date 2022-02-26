package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class History extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);
        this.setTitle("NUMBER HISTORY");
        t1 = (TextView) findViewById(R.id.textView);
        t1.setMovementMethod(new ScrollingMovementMethod());
        String his="\n"+"Today's numbers, also called Hindu-Arabic numbers, are a combination of just 10 symbols or digits: 1, 2, 3, 4, 5, 6, 7, 8, 9, and 0. These digits were introduced in Europe within the XII century by Leonardo Pisano (aka Fibonacci), an Italian mathematician. L. Pisano was educated in North Africa, where he learned and later carried to Italy the now popular Hindu-Arabic numerals.\n" +
                "\n" +
                "Hindu numeral system is a pure place-value system, that is why you need a zero. Only the Hindus, within the context of Indo-European civilisations, have consistently used a zero. The Arabs, however, played an essential part in the dissemination of this numeral system.\n" +
                "\n" +
                "\n" +
                "THE EARLIEST EVIDENCE OF THE USE OF NUMBERS\n\n" +
                "All numeration systems started as simple tally marks, using single strokes to represent each additional unit...\n" +
                "\n" +
                "Our prehistoric ancestors would have had a general sensibility about amounts and quantities, and would have instinctively known the difference between one, two or many antelopes. But the intellectual leap from the concrete idea of two things to the invention of a symbol for the abstract idea of \"two\" took many ages to come about.\n" +
                "\n" +
                "Mathematics along with a formal system of numbers initially developed when civilizations settled and developed agriculture - for the measurement of plots of land, the taxation of individuals, and so on - and this first occurred in the Sumerian and Babylonian civilizations of Mesopotamia (roughly, modern Iraq) and in ancient Egypt.\n\n" +"NUMERALS, A TIME TRAVEL FROM INDIA TO EUROPE\n\n" +
                "The discovery of zero and the place-value system were inventions unique to the Indian civilization. As the Brahmi notation of the first 9 whole numbers...The numeral set used in the Middle East today is a cousin of the modern numeral set, with a common ancestor in the ancient Hindu numerals. In fact, the Eastern Arabic numerals (also called Arabic–Indic numerals) are specific numerals currently used to represent the Hindu–Arabic numeral system in conjunction with the Arabic alphabet in the countries of the Arab east, and its variant (Persian numerals) in other countries.However, the first Western use of the digits, without the zero, was reported in the Vth century by Beothius, a Roman writer. Beothius explains, in one of his geometry books, how to operate the abacus using marked small cones instead of pebbles. Those cones, upon each of which was drawn the symbol of one of the nine Hindu-Arabic digits, were called apices. Thus, the early representations of digits in Europe were called “apices”. Each apex received also an individual name: Igin for 1, Andras for 2, Ormis for 3, Arbas for 4, Quimas (or Quisnas) for 5 , Caltis (or Calctis) for 6, Zenis (or Tenis) for 7, Temenisa for 8, and Celentis (or Scelentis) for 9. The etymology of these names remains unclear, though some of them were clearly Arab numbers. The Hindu-Arabic-like figures reported by Beothius were reproduced almost everywhere with the greatest fantasy! Before adopting the Hindu-Arabic numeral system, people used the Roman figures instead, which actually are a legacy of the Etruscan period. The Roman numeration is based on a biquinary (5) system.\n" +
                "\n" +
                "To write numbers the Romans used an additive system: V + I + I = VII (7) or C + X + X + I (121), and also a substractive system: IX (I before X = 9), XCIV (X before C = 90 and I before V = 4, 90 + 4 = 94). Latin numerals were used for reckoning until late XVI century!\n"+"Other original systems of numeration were being used in the past. In the earlier 13th century, the Archdeacon John of Basingstoke introduced a notation for numbers between 1 and 99 based on a vertical stroke provided with an appendage to the left (representing units) and another to the right (tens). Divers variants of the system turn up in various Cistercian manuscripts, and were used for a variety of purposes, along with Roman and Hindu-Arabic numerals.\n" +
                "In 1533, Agrippa von Nettesheym included a description of a “vertical” variant of the ciphers in his Occult Philosophy.\n" +
                "From then on and until the 19th century, the ciphers were remembered as “Chaldaean”. In early 20th-century Germany they turned Runic and Aryan. This original numeral system later fell out of use and was forgotten.\n" +
                "Agrippa’s number-notation system called “Notae Elegantissimae” allows to write numbers from 1 up to 9999 and was primarily employed for indexing purposes, where its compactness was a great advantage. But it is also useful as a mnemonic aid, e.g. the symbol K in the example further below may mean 1414. \n\n"+"CHINESE AND JAPANESE CONTRIBUTIONS\n" +
                "\t \t \n" +
                "\n" +
                "The Ba-Gua trigrams (pron. pah-kwah, 八卦) and the Genji-Kô patterns (源氏香), antique Chinese  and Japanese symbols, are strangely enough related to mathematics and electronics. If all the entire lines of the trigrams (___) are replaced with the digit 1 and the broken lines (_ _) with the digit 0, each Ba-Gua trigram will then represent a binary number from 0 to 7. You can also notice that each number is laid in front of its complementary: 0<>7, 1<>6, 2<>5, etc.The \"Genji-Kô\" (源氏香) symbols used for the chapters of the Tale of Genji (early Japanese novel) indicate the possible groupings and subgroupings of 5 elements. For instance, if you write down \"a\", \"b\", \"c\", \"d\" and \"e\" beneath the five small red sticks of each Genji-Kô pattern, you will obtain 52 distinct ways to connect 5 variables in Boolean algebra. The linked sticks form a \"conjunction\" (AND, ∨), and the isolated sticks or groups of sticks form a \"disjunction\" (OR, ∧). The pattern at the top left represents: \n" +
                "[(\"a\" and \"d\") or (\"b\" and \"e\") or \"c\"]";
        t1.setText(his);
    }
}


package com.example.ash.otp;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static com.example.ash.otp.MainActivity.mob;


public class book extends AppCompatActivity implements OnItemSelectedListener {
    List<String> names1 = MainActivity.na;
    List<String> age1 = MainActivity.ag;
    List<String> gen1 = MainActivity.ge;
    List<String> reg1 = MainActivity.re;
    List<String> doctor = new ArrayList<String>();
    List<String> sid = new ArrayList<String>();
    Set<String> dup = new HashSet<String>();
    Set<String> dup1 = new HashSet<String>();
    Set<String> dup2 = new HashSet<String>();
    List<String> slt = new ArrayList<String>();
    List<String> dr = new ArrayList<String>();
    List<String> drchg = new ArrayList<String>();
    List<String> slstrt = new ArrayList<String>();
    List<String> slend = new ArrayList<String>();
    List<String> tid = new ArrayList<String>();
    int s = names1.size();
    ConnectionClass connectionClass;
    String doc = "";
    String sl = "";
    String na1 = "";
    String doct1 = "";
    String dep1 = "";
    String drid = "";
    String did = "";
    String chg = "";
    String slst = "";
    String slen = "";
    String brid = "";
    String dat = "";
    String docid = "";
    String slot = "";
    String hr2 = "";
    StringBuilder sb;
    boolean check;
    boolean overlap = false;
    static int flow = 0;
    static int flowcnt = 0;
    static int noflowcnt = 0;
    int day;
    int month;
    int year;
    TextView t1, t2, t3, t4, t5, t6, t7;
    Button b1;
    TimePicker ti1;
    int flcnt = 0;
    Spinner spin, spin1, spin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        this.setTitle("Book Appointment");
        t1 = (TextView) findViewById(R.id.textView6);
        t2 = (TextView) findViewById(R.id.textView7);
        t3 = (TextView) findViewById(R.id.textView8);
        t4 = (TextView) findViewById(R.id.textView9);
        t5 = (TextView) findViewById(R.id.textView10);
        t6 = (TextView) findViewById(R.id.textView20);
        t7 = (TextView) findViewById(R.id.textView18);
        b1 = (Button) findViewById(R.id.button4);
        ti1 = (TimePicker) findViewById(R.id.textClock);
        connectionClass = new ConnectionClass();
        int c1, c2;
        c1 = MainActivity.flag;
        c2 = reg.flag1;
        if (c1 == 1) {
            String n = MainActivity.name;
            String a = MainActivity.age;
            String g = MainActivity.gen;
            String r = MainActivity.reg;
            t2.setText(g);
            t3.setText(n);
            t4.setText(r);
            t5.setText(a);
            spin1 = (Spinner) findViewById(R.id.spinner2);
            List<String> doc1 = MainActivity.doc;
            ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, doc1);
            aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin1.setAdapter(aa1);
            MainActivity.flag = 0;
        }
        if (c2 == 1) {
            String n1 = reg.name;
            String a1 = reg.age;
            String g1 = reg.gen;
            String r1 = reg.reg;
            t2.setText(g1);
            t3.setText(n1);
            t4.setText(r1);
            t5.setText(a1);
            spin1 = (Spinner) findViewById(R.id.spinner2);
            List<String> doc1 = reg.dcdep;
            ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, doc1);
            aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin1.setAdapter(aa1);
            reg.flag1 = 0;
        }

        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        spin = (Spinner) findViewById(R.id.spinner);
        spin2 = (Spinner) findViewById(R.id.spinner3);
        spin.setOnItemSelectedListener(this);
        final String MOB = MainActivity.mob;
        t1.setText(MOB);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, names1);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, slt);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(aa2);
        spin2.setOnItemSelectedListener(this);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t7.setText("");
                day = datePicker.getDayOfMonth();
                month = datePicker.getMonth() + 1;
                year = datePicker.getYear();
                Calendar c = Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY, 0);
                c.set(Calendar.MINUTE, 0);
                c.set(Calendar.SECOND, 0);
                c.set(Calendar.MILLISECOND, 0);
                Date today = c.getTime();
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, month - 1);
                c.set(Calendar.DAY_OF_MONTH, day);
                c.set(Calendar.HOUR_OF_DAY, 0);
                c.set(Calendar.MINUTE, 0);
                c.set(Calendar.SECOND, 0);
                c.set(Calendar.MILLISECOND, 0);
                Date dateSpecified = c.getTime();
                SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");
                String dayOfWeek = simpledateformat.format(dateSpecified);
                if (dateSpecified.before(today)) {
                    flcnt = 1;
                    t7.setText("");
                }

                book.app slot = new book.app();
                int d = spin1.getSelectedItemPosition();
                String Drid = sid.get(d);
                slot.execute(Drid, dayOfWeek);


            }
        });
        ti1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                if (spin2 != null && spin2.getSelectedItem() != null) {
                    hr2 = "";
                    int s1 = spin2.getSelectedItemPosition();
                    String sl1 = slstrt.get(s1);
                    String sl2 = slend.get(s1);
                    if (minute >= 0 && minute <= 9) {
                        hr2 = hr2 + hourOfDay + "0" + minute;
                    } else
                        hr2 = hr2 + hourOfDay + minute;
                    Integer i1 = Integer.parseInt(sl1);
                    Integer i2 = Integer.parseInt(sl2);
                    Integer i3 = Integer.parseInt(hr2);
                    if (i3 < i1 || i3 > i2) {
                        noflowcnt++;
                        if ((noflowcnt - 1) % 3 == 0)
                            flowcnt = 0;
                        if (flow == 0 && flowcnt == 0) {
                            Toast.makeText(book.this, "Choose a time between the following :" + sl1 + " and " + sl2, Toast.LENGTH_SHORT).show();
                            flowcnt++;
                        }
                    } else {
                        dat = "";
                        docid = sid.get(spin1.getSelectedItemPosition());
                        slot = tid.get(spin2.getSelectedItemPosition());
                        day = datePicker.getDayOfMonth();
                        month = datePicker.getMonth() + 1;
                        year = datePicker.getYear();
                        dat = dat + year + "-" + month + "-" + day;
                        book.sltchk ch1 = new book.sltchk();
                        ch1.execute(docid, dat, slot, hr2);

                    }
                }


            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                {

                    if (check == false && (spin2 != null && spin2.getSelectedItem() != null) && overlap == false) {
                        doc = spin1.getSelectedItem().toString();
                        sl = spin2.getSelectedItem().toString();
                        day = datePicker.getDayOfMonth();
                        month = datePicker.getMonth() + 1;
                        year = datePicker.getYear();
                        Toast.makeText(book.this, "Slot Available for chosen time", Toast.LENGTH_SHORT).show();
                        String msg = "Greetings " + na1 + "!!!! Your appointment with " + doc + " has been successfully booked at "+hr2+" hrs on " + day + "-" + month + "-" + year;
                        book.sendssms send = new book.sendssms();
                        send.execute(msg, MOB);
                        Intent fp = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(fp);
                    } else {
                        if (overlap == true) {
                            Toast.makeText(book.this, "Slot already booked,Choose a different time ", Toast.LENGTH_SHORT).show();

                        } else {
                            String msg = "Sorry!!!!! Your Appointment could not be booked due to non availability of Doctors";
                            book.sendssms send = new book.sendssms();
                            send.execute(msg, MOB);
                            Intent fp = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(fp);
                        }
                    }
                }
            }

        });
        t6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent regi = new Intent(getBaseContext(), reg.class);
                startActivity(regi);

            }
        });
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Spinner spinner = (Spinner) arg0;
        if (spinner.getId() == R.id.spinner) {
            na1 = names1.get(position);
            int p1 = names1.indexOf(na1);
            String register = reg1.get(p1);
            String age2 = age1.get(p1);
            String gen2 = gen1.get(p1);
            t2.setText(gen2);
            t3.setText(na1);
            t4.setText(register);
            t5.setText(age2);
            book.DoLogin doLogin = new book.DoLogin();
            doLogin.execute(na1);
        } else if (spinner.getId() == R.id.spinner3) {
            int p = spin2.getSelectedItemPosition();
            String chrg = drchg.get(p);
            t7.setText(chrg);

        }

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public class DoLogin extends AsyncTask<String, String, String> {
        String z = "";
        Boolean isSuccess = false;
        String Mo = mob;

        @Override
        protected void onPreExecute() {


        }

        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(book.this, r, Toast.LENGTH_SHORT).show();

            if (isSuccess) {
                Toast.makeText(book.this, "Re-Directing", Toast.LENGTH_SHORT).show();
                ArrayAdapter aa3 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, doctor);
                aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin1.setAdapter(aa3);

            } else {
                ArrayAdapter aa3 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, doctor);
                aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin1.setAdapter(aa3);
            }

        }

        @Override
        protected String doInBackground(String... params) {
            String name = params[0];
            try {
                Connection con = connectionClass.CONN();
                if (con == null) {
                    z = "Error in connection with SQL server";
                } else {
                    doct1 = "";
                    dep1 = "";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select BRANCHID from M_Person where PERSONNM ='" + name + "'");
                    while (rs.next()) {
                        brid = rs.getString("BRANCHID");
                    }
                    rs = stmt.executeQuery("SELECT DISTINCT M_Person.PERSONNM,M_SubDepartment.subdeptnm,DrSkill.DRSKILLID,DrSkill.DRID FROM M_Person INNER JOIN M_Doctor ON M_Person.PERSONID=M_Doctor.PERSONID INNER JOIN DrSkill ON M_Doctor.DRID=DrSkill.DRID INNER JOIN M_SubDepartment ON DrSkill.SUBDEPTID=M_SubDepartment.subdeptid INNER JOIN DrBranchFee ON DrBranchFee.branchid='" + brid + "'");

                    doctor.clear();
                    sid.clear();
                    dr.clear();
                    while (rs.next()) {
                        String te = "";
                        doct1 = rs.getString("PERSONNM");
                        dep1 = rs.getString("subdeptnm");
                        drid = rs.getString("DRSKILLID");
                        did = rs.getString("DRID");
                        te = "Dr. " + doct1 + "-" + dep1;
                        doctor.add(te);
                        sid.add(drid);
                        dr.add(did);
                    }
                    if (dep1 != "") {

                        z = "Fetching Corresponding Data";
                        isSuccess = true;
                        flcnt = 0;

                    } else {
                        z = "No Doctors Available at this Branch";
                        isSuccess = false;
                        flcnt = 1;
                    }

                }


            } catch (Exception ex) {
                isSuccess = false;
                z = "Exceptions";
                ex.printStackTrace();
            }

            return z;

        }
    }

    public class sendssms extends AsyncTask<String, String, String> {

        String a = "";
        String errmsg = "";
        String tno = "";
        String tpp = "";
        String new1 = "";


        @Override
        protected void onPreExecute() {
            Toast.makeText(book.this, "Sending SMS", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(book.this, r, Toast.LENGTH_SHORT).show();
            if(check==false &&!errmsg.trim().equals(""))
                Toast.makeText(book.this, errmsg, Toast.LENGTH_SHORT).show();
            }

        @Override
        protected String doInBackground(String... params) {

            try {
                String msg = params[0];
                String user = "vignana";
                String text = msg;
                String pass = "smsvignana";
                String sender = "SAHOSP";
                String phone = params[1];
                String priority = "ndnd";
                String stype = "normal";

                HttpURLConnection conn = (HttpURLConnection) new URL("http://bhashsms.com/api/sendmsg.php?user=vignana&pass=smsvignana&sender=SAHOSP&phone=" + phone + "&text=" + text + "&priority=ndnd&stype=normal").openConnection();
                String data = user + pass + sender + phone + text + priority + stype;
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                conn.getOutputStream().write(data.getBytes("UTF-8"));
                final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = rd.readLine()) != null) {
                    //stringBuffer.append(line);
                    //Toast.makeText(getApplicationContext(), "the message is " + line, Toast.LENGTH_LONG).show();
                }
                rd.close();
                //return stringBuffer.toString();
                //sendMessage(phoneNo, otp);

            } catch (Exception e) {

                System.out.println("Error SMS " + e);
                Toast.makeText(getApplicationContext(), "the error message is" + e, Toast.LENGTH_LONG).show();
                //return "Error "+e; }
                e.printStackTrace();
            }
            if (check ==false) {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        errmsg = "Error in connection with SQL server";
                    } else {
                        String slid = "";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select MAX(tokenno)+1 as tno from DrAppointment where drappointdt='" + dat + "' and drSkillid='" + docid + "' and timeslotid='" + slot + "'");
                        while (rs.next()) {
                            tno = rs.getString("tno");
                        }
                        if(tno!=null)
                            tno=tno;
                        else
                            tno = "1";
                        rs = stmt.executeQuery("select timePerPatient from DrBranchFee where drSkillid='" + docid + "'");
                        while (rs.next()) {
                            tpp = rs.getString("timePerPatient");
                        }
                        tpp = "00:" + tpp;
                        sb = new StringBuilder(hr2);
                        sb.insert(2, ':');
                        try {
                            Date date = null;
                            Date date1 = null;
                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                            date = sdf.parse(sb.toString());
                            date1 = sdf.parse(tpp);
                            String shortTimeStr = sdf.format(date);
                            String TimeStr = sdf.format(date1);
                            String[] d1 = shortTimeStr.split(":");
                            String[] d2 = TimeStr.split(":");
                            int hor1 = Integer.parseInt(d1[0]);
                            int hor2 = Integer.parseInt(d2[0]);
                            int m1 = Integer.parseInt(d1[1]);
                            int m2 = Integer.parseInt(d2[1]);
                            int totm1 = m1 + m2;
                            if (totm1 >= 60) {
                                totm1 = totm1 - 60;
                                hor1++;
                                if (hor1 >= 24)
                                    hor1 = hor1 - 12;
                            }
                            if (totm1 >= 0 && totm1 <= 9)
                                new1 = new1 + String.valueOf(hor1) + ":" + "0" + String.valueOf(totm1);
                            else
                                new1 = new1 + String.valueOf(hor1) + ":" + String.valueOf(totm1);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        int stus = stmt.executeUpdate("insert into DrAppointment(drappointdt,drSkillid,Personid,tokenno,tokenInTime,tokenOutTime,visitid,uid,tokenStatusid,postdt,timeslotid,booksubtypeid,branchid) values('" + dat + "','" + docid + "','" + reg1.get(spin.getSelectedItemPosition()) + "','" + tno + "','" + sb.toString() + "','" + new1 + "','0','3','6',GETDATE(),'" + slot + "','4','" + brid + "')");
                        if(stus>0)
                            errmsg="Appointment Confirmed";

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



            a = "SMS sent Successfully";
            return a;
        }
    }

    public class app extends AsyncTask<String, String, String> {

        String z = "";

        @Override
        protected void onPreExecute() {
            Toast.makeText(book.this, "Checking Slot Sessions", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(book.this, z, Toast.LENGTH_SHORT).show();
            if (flcnt == 1) {
                Toast.makeText(getApplicationContext(), "Past Date is not accepted for booking an appointment!!!", Toast.LENGTH_LONG).show();
                flcnt = 0;
                check = true;
            }
            ArrayAdapter aa5 = new ArrayAdapter(getApplication(), android.R.layout.simple_spinner_item, slt);
            aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin2.setAdapter(aa5);

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                String dcid = params[0];
                String week = params[1];
                Connection con = connectionClass.CONN();
                if (con == null) {
                    z = "Error in connection with SQL server";
                } else {
                    String slid = "";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select (drChg+dbf.drhospchg)as drChg,da.TIMESLOTID,ta.timeslotnm,w.weekdaynm,ta.slotStart,ta.slotEnd from DrBranchFee dbf left join DrAvailability da on da.drchgid=dbf.drchgid left join M_TimeSlot ta on ta.timeslotid=da.TIMESLOTID left join Weekdays w on w.weekdayid=da.WEEKDAYID where dbf.drSkillid='" + dcid + "' and w.weekdaynm='" + week + "'");
                    dup.clear();
                    dup1.clear();
                    dup2.clear();
                    slt.clear();
                    drchg.clear();
                    slstrt.clear();
                    slend.clear();
                    tid.clear();

                    while (rs.next()) {
                        String sess = "";
                        slid = rs.getString("TIMESLOTID");
                        tid.add(slid);
                        sess = rs.getString("timeslotnm");
                        dup.add(sess);
                        chg = rs.getString("drChg");
                        drchg.add(chg);
                        slst = rs.getString("slotStart");
                        dup1.add(slst);
                        slen = rs.getString("slotEnd");
                        dup2.add(slen);
                    }
                    slt.addAll(dup);
                    slstrt.addAll(dup1);
                    slend.addAll(dup2);
                    Collections.sort(slstrt);
                    Collections.sort(slend);
                    dup.clear();
                    dup1.clear();
                    dup2.clear();
                    check = slt.isEmpty();
                    if (check == false) {

                        z = "Fetching slot Sessions";


                    } else {
                        z = "No Doctors Available at this Branch on your specified Appointment Date";
                    }

                }


            } catch (Exception ex) {
                z = "Exceptions";
                ex.printStackTrace();
            }

            return z;

        }
    }

    public class sltchk extends AsyncTask<String, String, String> {

        String z = "";
        String new1 = "";
        String hr = "";
        String hr1 = "";
        StringBuilder sb;

        @Override
        protected void onPreExecute() {


        }

        @Override
        protected void onPostExecute(String r) {
            {

            }

        }

        @Override
        protected String doInBackground(String... params) {
            try {

                String dcid = params[0];
                String dt = params[1];
                String slt = params[2];
                String pdt = params[3];
                Connection con = connectionClass.CONN();
                if (con == null) {
                    z = "Error in connection with SQL server";
                } else {
                    String slid = "";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select a.drSkillid,a.drappointdt,t.slotStart,t.slotEnd,a.timeslotid,a.tokenInTime,b.timePerPatient,a.tokenOutTime from DrAppointment a join DrBranchFee b on b.drSkillid=a.drSkillid join M_TimeSlot t on t.timeslotid=a.TIMESLOTID where a.drSkillid='" + dcid + "' and a.drappointdt='" + dt + "' and a.timeslotid='" + slt + "'");

                    while (rs.next()) {
                        hr = rs.getString("tokenInTime");
                        hr1 = rs.getString("timePerPatient");
                        hr1 = "00:" + hr1;
                        try {
                            new1 = "";
                            Date date = null;
                            Date date1 = null;
                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                            date = sdf.parse(hr);
                            date1 = sdf.parse(hr1);
                            String shortTimeStr = sdf.format(date);
                            String TimeStr = sdf.format(date1);
                            String[] d1 = shortTimeStr.split(":");
                            String[] d2 = TimeStr.split(":");
                            int hor1 = Integer.parseInt(d1[0]);
                            int hor2 = Integer.parseInt(d2[0]);
                            int m1 = Integer.parseInt(d1[1]);
                            int m2 = Integer.parseInt(d2[1]);
                            int totm1 = m1 + m2;
                            if (totm1 >= 60) {
                                totm1 = totm1 - 60;
                                hor1++;
                                if (hor1 >= 24)
                                    hor1 = hor1 - 12;
                            }
                            if (totm1 >= 0 && totm1 <= 9)
                                new1 = new1 + String.valueOf(hor1) + ":" + "0" + String.valueOf(totm1);
                            else
                                new1 = new1 + String.valueOf(hor1) + ":" + String.valueOf(totm1);
                            StringBuilder sb = new StringBuilder(new1);
                            sb.deleteCharAt(2);
                            Integer i1 = Integer.parseInt(sb.toString());
                            sb = new StringBuilder(shortTimeStr);
                            sb.deleteCharAt(2);
                            Integer i2 = Integer.parseInt(sb.toString());
                            Integer i3 = Integer.parseInt(pdt);
                            if (i3 > i2 && i3 < i1) {
                                overlap = true;
                                break;
                            } else
                                overlap = false;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    if (hr.equals(""))
                        overlap = false;

                }

            } catch (Exception ex) {
                z = "Exceptions";
                ex.printStackTrace();
            }

            return z;

        }
    }
}






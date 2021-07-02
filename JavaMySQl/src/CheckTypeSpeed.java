
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import static java.time.Clock.system;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class CheckTypeSpeed extends javax.swing.JFrame {

    /**
     * Creates new form CheckTypeSpeed
     */
    private String prompts,user="parvej";
    int capscount=0;
    KeyEvent evt;
    private int keypressed=0,charpos=0,pos=0;
    private double startTime,endTime,wpm=0,mxwpm;
    public void PersonalBest(String usr){
            try{     
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/typingtutor","root","");
                //String new_entry = "INSERT INTO logindb(username,password)  VALUES(?,?)";
                String sql="Select * from information where username=?";
                PreparedStatement pst1=con.prepareStatement(sql);
                pst1.setString(1, usr);
                ResultSet rs =pst1.executeQuery();
                if(rs.next()){
                     mxwpm=rs.getDouble("PersonalBest");
                   personalbest.setText("Your Personal Best is : "+new DecimalFormat("#00.00").format(mxwpm) + " wpm");
                }
                else{
                    
                }
            }
            catch(Exception e){
                
            }
    }
    CheckTypeSpeed(String ss) {
        user=ss;
        initComponents();
        PersonalBest(user);
        caponoff();
        prompts ="The average typing speed of a computer typist is just 36wpm.\n";
//                + "Touch typists are generally faster, averaging a quick 48 words per minute.\n"
//                + "The fastest typing speed ever recorded is currently an extreme 216 words per minute!\n"
//                + "Average accuracy is 92%. Bananas?\n";
        //text_to_write.setLineWrap(true);
        //textField.setFocusable(false);
        text_to_write.setFocusable(false);
        text_to_write.setText(prompts);
        setTitle("Check Typing Speed");
        setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2,size.height/2 -getHeight()/2);// to show the frame at center
        initColor();
    }
    public void caponoff(){
        boolean isOn = Toolkit.getDefaultToolkit().getLockingKeyState(evt.VK_CAPS_LOCK);
        if(!isOn){
            onoff.setBackground(Color.BLACK);
            onoff.setForeground(Color.WHITE);
            onoff.setText("OFF");
            to_lower();
        }
        else{
            onoff.setBackground(Color.GREEN);
            onoff.setForeground(Color.BLACK);
            onoff.setText("ON");
            to_capital();
        }
    }
    public void to_lower(){
        a.setText("a");b.setText("b");c.setText("c");d.setText("d");
        e.setText("e");f.setText("f");g.setText("g");h.setText("h");
        i.setText("i");j.setText("j");k.setText("k");l.setText("l");
        m.setText("m");n.setText("n");o.setText("o");p.setText("p");
        q.setText("q");r.setText("r");s.setText("s");t.setText("t");
        u.setText("u");v.setText("v");w.setText("w");x.setText("x");
        y.setText("y");z.setText("z");
    }
    public void to_capital(){
        a.setText("A");b.setText("B");c.setText("C");d.setText("D");
        e.setText("E");f.setText("F");g.setText("G");h.setText("H");
        i.setText("I");j.setText("J");k.setText("K");l.setText("L");
        m.setText("M");n.setText("N");o.setText("O");p.setText("P");
        q.setText("Q");r.setText("R");s.setText("S");t.setText("T");
        u.setText("U");v.setText("V");w.setText("W");x.setText("X");
        y.setText("Y");z.setText("Z");
    }
    public void  initColor(){
         a.setBackground(new Color(0,0,0));b.setBackground(new Color(0,0,0));
         c.setBackground(new Color(0,0,0));d.setBackground(new Color(0,0,0));
         e.setBackground(new Color(0,0,0));f.setBackground(new Color(0,0,0));
         g.setBackground(new Color(0,0,0));h.setBackground(new Color(0,0,0));
         i.setBackground(new Color(0,0,0));j.setBackground(new Color(0,0,0));
         k.setBackground(new Color(0,0,0));l.setBackground(new Color(0,0,0));
         m.setBackground(new Color(0,0,0));n.setBackground(new Color(0,0,0));
         o.setBackground(new Color(0,0,0));p.setBackground(new Color(0,0,0));
         q.setBackground(new Color(0,0,0));r.setBackground(new Color(0,0,0));
         s.setBackground(new Color(0,0,0));t.setBackground(new Color(0,0,0));
         u.setBackground(new Color(0,0,0));v.setBackground(new Color(0,0,0));
         w.setBackground(new Color(0,0,0));x.setBackground(new Color(0,0,0));
         y.setBackground(new Color(0,0,0));z.setBackground(new Color(0,0,0));
         comma.setBackground(new Color(0,0,0));fullstop.setBackground(new Color(0,0,0));
         backslash.setBackground(new Color(0,0,0));slash.setBackground(new Color(0,0,0));
         shift1.setBackground(new Color(0,0,0));shift2.setBackground(new Color(0,0,0));
         control1.setBackground(new Color(0,0,0));control2.setBackground(new Color(0,0,0));
         spacebar.setBackground(new Color(0,0,0));alt1.setBackground(new Color(0,0,0));
         alt2.setBackground(new Color(0,0,0));windows1.setBackground(new Color(0,0,0));
         windows2.setBackground(new Color(0,0,0));quote.setBackground(new Color(0,0,0));
         semicolon.setBackground(new Color(0,0,0));tildth.setBackground(new Color(0,0,0));
         one.setBackground(new Color(0,0,0));two.setBackground(new Color(0,0,0));
         three.setBackground(new Color(0,0,0));four.setBackground(new Color(0,0,0));
         five.setBackground(new Color(0,0,0));six.setBackground(new Color(0,0,0));
         seven.setBackground(new Color(0,0,0));eight.setBackground(new Color(0,0,0));
         nine.setBackground(new Color(0,0,0));zero.setBackground(new Color(0,0,0));
         enter.setBackground(new Color(0,0,0));backspace.setBackground(new Color(0,0,0));
         capslock.setBackground(new Color(0,0,0));leftbrace.setBackground(new Color(0,0,0));
         rightbrace.setBackground(new Color(0,0,0));plus.setBackground(new Color(0,0,0));
         minus.setBackground(new Color(0,0,0));
         
         a.setForeground(Color.WHITE);b.setForeground(Color.WHITE);
         c.setForeground(Color.WHITE);d.setForeground(Color.WHITE);
         e.setForeground(Color.WHITE);f.setForeground(Color.WHITE);
         g.setForeground(Color.WHITE);h.setForeground(Color.WHITE);
         i.setForeground(Color.WHITE);j.setForeground(Color.WHITE);
         k.setForeground(Color.WHITE);l.setForeground(Color.WHITE);
         m.setForeground(Color.WHITE);n.setForeground(Color.WHITE);
         o.setForeground(Color.WHITE);p.setForeground(Color.WHITE);
         q.setForeground(Color.WHITE);r.setForeground(Color.WHITE);
         s.setForeground(Color.WHITE);t.setForeground(Color.WHITE);
         u.setForeground(Color.WHITE);v.setForeground(Color.WHITE);
         w.setForeground(Color.WHITE);x.setForeground(Color.WHITE);
         y.setForeground(Color.WHITE);z.setForeground(Color.WHITE);
         comma.setForeground(Color.WHITE);fullstop.setForeground(Color.WHITE);
         backslash.setForeground(Color.WHITE);slash.setForeground(Color.WHITE);
         shift1.setForeground(Color.WHITE);shift2.setForeground(Color.WHITE);
         control1.setForeground(Color.WHITE);control2.setForeground(Color.WHITE);
         spacebar.setForeground(Color.WHITE);alt1.setForeground(Color.WHITE);
         alt2.setForeground(Color.WHITE);windows1.setForeground(Color.WHITE);
         windows2.setForeground(Color.WHITE);quote.setForeground(Color.WHITE);
         semicolon.setForeground(Color.WHITE);tildth.setForeground(Color.WHITE);
         one.setForeground(Color.WHITE);two.setForeground(Color.WHITE);
         three.setForeground(Color.WHITE);four.setForeground(Color.WHITE);
         five.setForeground(Color.WHITE);six.setForeground(Color.WHITE);
         seven.setForeground(Color.WHITE);eight.setForeground(Color.WHITE);
         nine.setForeground(Color.WHITE);zero.setForeground(Color.WHITE);
         enter.setForeground(Color.WHITE);backspace.setForeground(Color.WHITE);
         capslock.setForeground(Color.WHITE);leftbrace.setForeground(Color.WHITE);
         rightbrace.setForeground(Color.WHITE);plus.setForeground(Color.WHITE);
         minus.setForeground(Color.WHITE);
         
         
         
        
        
        
    }
    public void rightPressed(KeyEvent evt){
        int key=evt.getKeyCode();
        if(key==evt.VK_ENTER){
            enter.setBackground(Color.green);
            textfield.setText("");
            prompts=prompts.substring(charpos,prompts.length());
            charpos=0;
        }
        else if(key==evt.VK_A){
            a.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_B){
            b.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_C){
            c.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_D){
            d.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_E){
            e.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_F){
            f.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_G){
            g.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_H){
            h.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_I){
            i.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_J){
            j.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_K){
            k.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_L){
            l.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_M){
            m.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_N){
            n.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_O){
            o.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_P){
            p.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_Q){
            q.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_R){
            r.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_S){
            s.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_T){
            t.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_U){
            u.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_V){
            v.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_W){
            w.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_X){
            x.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_Y){
            y.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_Z){
            z.setBackground(Color.GREEN);
        }
        else if(key==evt.VK_SHIFT){
            if(evt.getKeyLocation()==evt.KEY_LOCATION_LEFT)shift1.setBackground(Color.GREEN);
            else shift2.setBackground(Color.green);
        }
        else if(key==evt.VK_CONTROL){
            if(evt.getKeyLocation()==evt.KEY_LOCATION_LEFT)control1.setBackground(Color.GREEN);
            else control2.setBackground(Color.green);
        }
        else if(key==evt.VK_ALT){
            if(evt.getKeyLocation()==evt.KEY_LOCATION_LEFT)alt1.setBackground(Color.GREEN);
            else alt2.setBackground(Color.green);
        }
        else if(key==evt.VK_CAPS_LOCK){
            capslock.setBackground(Color.green);
            caponoff();
        }
        else if(key==evt.VK_WINDOWS){
            if(evt.getKeyLocation()==evt.KEY_LOCATION_LEFT)windows1.setBackground(Color.GREEN);
            else windows2.setBackground(Color.green);
        }
        else if(key==evt.VK_BACK_SPACE){
            backspace.setBackground(Color.green);
        }
        else if(key==evt.VK_1){
            one.setBackground(Color.green);
        }
        else if(key==evt.VK_2){
            two.setBackground(Color.green);
        }
        else if(key==evt.VK_3){
            three.setBackground(Color.green);
        }
        else if(key==evt.VK_4){
            four.setBackground(Color.green);
        }
        else if(key==evt.VK_5){
            five.setBackground(Color.green);
        }
        else if(key==evt.VK_6){
            six.setBackground(Color.green);
        }
        else if(key==evt.VK_7){
            seven.setBackground(Color.green);
        }
        else if(key==evt.VK_8){
            eight.setBackground(Color.green);
        }
        else if(key==evt.VK_9){
            nine.setBackground(Color.green);
        }
        else if(key==evt.VK_0){
            zero.setBackground(Color.green);
        }
        else if(key==evt.VK_SPACE){
            spacebar.setBackground(Color.green);
        }
        else if(key==evt.VK_SEMICOLON){
            semicolon.setBackground(Color.green);
        }
        else if(key==evt.VK_COMMA){
            comma.setBackground(Color.green);
        }
        else if(key==evt.VK_SLASH){
            slash.setBackground(Color.green);
        }
        else if(key==evt.VK_EQUALS){
            plus.setBackground(Color.green);
        }
        else if(key==evt.VK_MINUS){
            minus.setBackground(Color.green);
        }
        else if(key==evt.VK_BACK_SLASH){
            backslash.setBackground(Color.green);
        }
        else if(key==evt.VK_OPEN_BRACKET){
            leftbrace.setBackground(Color.green);
        }
        else if(key==evt.VK_CLOSE_BRACKET){
            rightbrace.setBackground(Color.green);
        }
    }
    public void wrongPressed(KeyEvent evt){
        int key=evt.getKeyCode();
        if(key==evt.VK_ENTER){
            enter.setBackground(Color.red);
        }
        else if(key==evt.VK_A){
            a.setBackground(Color.red);
        }
        else if(key==evt.VK_B){
            b.setBackground(Color.red);
        }
        else if(key==evt.VK_C){
            c.setBackground(Color.red);
        }
        else if(key==evt.VK_D){
            d.setBackground(Color.red);
        }
        else if(key==evt.VK_E){
            e.setBackground(Color.red);
        }
        else if(key==evt.VK_F){
            f.setBackground(Color.red);
        }
        else if(key==evt.VK_G){
            g.setBackground(Color.red);
        }
        else if(key==evt.VK_H){
            h.setBackground(Color.red);
        }
        else if(key==evt.VK_I){
            i.setBackground(Color.red);
        }
        else if(key==evt.VK_J){
            j.setBackground(Color.red);
        }
        else if(key==evt.VK_K){
            k.setBackground(Color.red);
        }
        else if(key==evt.VK_L){
            l.setBackground(Color.red);
        }
        else if(key==evt.VK_M){
            m.setBackground(Color.red);
        }
        else if(key==evt.VK_N){
            n.setBackground(Color.red);
        }
        else if(key==evt.VK_O){
            o.setBackground(Color.red);
        }
        else if(key==evt.VK_P){
            p.setBackground(Color.red);
        }
        else if(key==evt.VK_Q){
            q.setBackground(Color.red);
        }
        else if(key==evt.VK_R){
            r.setBackground(Color.red);
        }
        else if(key==evt.VK_S){
            s.setBackground(Color.red);
        }
        else if(key==evt.VK_T){
            t.setBackground(Color.red);
        }
        else if(key==evt.VK_U){
            u.setBackground(Color.red);
        }
        else if(key==evt.VK_V){
            v.setBackground(Color.red);
        }
        else if(key==evt.VK_W){
            w.setBackground(Color.red);
        }
        else if(key==evt.VK_X){
            x.setBackground(Color.red);
        }
        else if(key==evt.VK_Y){
            y.setBackground(Color.red);
        }
        else if(key==evt.VK_Z){
            z.setBackground(Color.red);
        }
        else if(key==evt.VK_SHIFT){
            if(evt.getKeyLocation()==evt.KEY_LOCATION_LEFT)shift1.setBackground(Color.green);
            else shift2.setBackground(Color.green);
        }
        else if(key==evt.VK_CONTROL){
            if(evt.getKeyLocation()==evt.KEY_LOCATION_LEFT)control1.setBackground(Color.red);
            else control2.setBackground(Color.red);
        }
        else if(key==evt.VK_ALT){
            if(evt.getKeyLocation()==evt.KEY_LOCATION_LEFT)alt1.setBackground(Color.red);
            else alt2.setBackground(Color.red);
        }
        else if(key==evt.VK_CAPS_LOCK){
            capslock.setBackground(Color.red);
            caponoff();
        }
        else if(key==evt.VK_WINDOWS){
            if(evt.getKeyLocation()==evt.KEY_LOCATION_LEFT)windows1.setBackground(Color.red);
            else windows2.setBackground(Color.red);
        }
        else if(key==evt.VK_BACK_SPACE){
            backspace.setBackground(Color.green);
        }
        else if(key==evt.VK_1){
            one.setBackground(Color.red);
        }
        else if(key==evt.VK_2){
            two.setBackground(Color.red);
        }
        else if(key==evt.VK_3){
            three.setBackground(Color.red);
        }
        else if(key==evt.VK_4){
            four.setBackground(Color.red);
        }
        else if(key==evt.VK_5){
            five.setBackground(Color.red);
        }
        else if(key==evt.VK_6){
            six.setBackground(Color.red);
        }
        else if(key==evt.VK_7){
            seven.setBackground(Color.red);
        }
        else if(key==evt.VK_8){
            eight.setBackground(Color.red);
        }
        else if(key==evt.VK_9){
            nine.setBackground(Color.red);
        }
        else if(key==evt.VK_0){
            zero.setBackground(Color.red);
        }
        else if(key==evt.VK_SPACE){
            spacebar.setBackground(Color.red);
        }
        else if(key==evt.VK_SEMICOLON){
            semicolon.setBackground(Color.red);
        }
        else if(key==evt.VK_COMMA){
            comma.setBackground(Color.red);
        }
        else if(key==evt.VK_SLASH){
            slash.setBackground(Color.red);
        }
        else if(key==evt.VK_EQUALS){
            plus.setBackground(Color.red);
        }
        else if(key==evt.VK_MINUS){
            minus.setBackground(Color.red);
        }
        else if(key==evt.VK_BACK_SLASH){
            backslash.setBackground(Color.red);
        }
        else if(key==evt.VK_OPEN_BRACKET){
            leftbrace.setBackground(Color.red);
        }
        else if(key==evt.VK_CLOSE_BRACKET){
            rightbrace.setBackground(Color.red);
        }
    }
    public void calculateWPM(double st,double et){
        double timeElapsed = et - st;
        int numWords = textfield.getText().length()-textfield.getText().replaceAll(" ", "").length() - 1;
        wpm = numWords / (timeElapsed / 1000000000) * 60; 
        wpmLabel.setText("Speed: " + new DecimalFormat("#00.00").format(wpm) + " wpm");
    }
    public CheckTypeSpeed() {
        initComponents();
        PersonalBest(user);
        caponoff();
        prompts ="The average typing speed of a computer typist is just 36wpm.\n";
//                + "Touch typists are generally faster, averaging a quick 48 words per minute.\n"
//                + "The fastest typing speed ever recorded is currently an extreme 216 words per minute!\n"
//                + "Average accuracy is 92%. Bananas?\n";
        //text_to_write.setLineWrap(true);
        //textField.setFocusable(false);
        text_to_write.setFocusable(false);
        text_to_write.setText(prompts);
        setTitle("Check Typing Speed");
        setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2,size.height/2 -getHeight()/2);// to show the frame at center
        initColor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abc2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        spacebar = new javax.swing.JButton();
        alt2 = new javax.swing.JButton();
        control2 = new javax.swing.JButton();
        windows2 = new javax.swing.JButton();
        alt1 = new javax.swing.JButton();
        windows1 = new javax.swing.JButton();
        control1 = new javax.swing.JButton();
        shift1 = new javax.swing.JButton();
        shift2 = new javax.swing.JButton();
        x = new javax.swing.JButton();
        z = new javax.swing.JButton();
        c = new javax.swing.JButton();
        v = new javax.swing.JButton();
        b = new javax.swing.JButton();
        n = new javax.swing.JButton();
        m = new javax.swing.JButton();
        comma = new javax.swing.JButton();
        fullstop = new javax.swing.JButton();
        slash = new javax.swing.JButton();
        d = new javax.swing.JButton();
        s = new javax.swing.JButton();
        f = new javax.swing.JButton();
        g = new javax.swing.JButton();
        h = new javax.swing.JButton();
        j = new javax.swing.JButton();
        k = new javax.swing.JButton();
        l = new javax.swing.JButton();
        semicolon = new javax.swing.JButton();
        quote = new javax.swing.JButton();
        backslash = new javax.swing.JButton();
        a = new javax.swing.JButton();
        enter = new javax.swing.JButton();
        capslock = new javax.swing.JButton();
        q = new javax.swing.JButton();
        w = new javax.swing.JButton();
        e = new javax.swing.JButton();
        r = new javax.swing.JButton();
        t = new javax.swing.JButton();
        y = new javax.swing.JButton();
        u = new javax.swing.JButton();
        i = new javax.swing.JButton();
        o = new javax.swing.JButton();
        p = new javax.swing.JButton();
        leftbrace = new javax.swing.JButton();
        rightbrace = new javax.swing.JButton();
        tab = new javax.swing.JButton();
        one = new javax.swing.JButton();
        backspace = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        six = new javax.swing.JButton();
        seven = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        plus = new javax.swing.JButton();
        escape = new javax.swing.JButton();
        onoff = new javax.swing.JButton();
        ftwo = new javax.swing.JButton();
        fthree = new javax.swing.JButton();
        ffour = new javax.swing.JButton();
        ffive = new javax.swing.JButton();
        fsix = new javax.swing.JButton();
        fseven = new javax.swing.JButton();
        feight = new javax.swing.JButton();
        fnine = new javax.swing.JButton();
        ften = new javax.swing.JButton();
        feleven = new javax.swing.JButton();
        ftwelve = new javax.swing.JButton();
        tildth = new javax.swing.JButton();
        fone1 = new javax.swing.JButton();
        textfield = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        text_to_write = new javax.swing.JTextPane();
        wpmLabel = new javax.swing.JLabel();
        personalbest = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        gotomainmenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        abc2.setBackground(new java.awt.Color(255, 204, 204));
        abc2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 10, true));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 10, true));

        spacebar.setBackground(new java.awt.Color(0, 0, 0));
        spacebar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        spacebar.setText("SpaceBar");
        spacebar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));

        alt2.setBackground(new java.awt.Color(0, 0, 0));
        alt2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        alt2.setText("Alt");
        alt2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        alt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alt2ActionPerformed(evt);
            }
        });

        control2.setBackground(new java.awt.Color(0, 0, 0));
        control2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        control2.setText("Ctrl");
        control2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        control2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                control2ActionPerformed(evt);
            }
        });

        windows2.setBackground(new java.awt.Color(0, 0, 0));
        windows2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        windows2.setText("Win");
        windows2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        windows2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windows2ActionPerformed(evt);
            }
        });

        alt1.setBackground(new java.awt.Color(0, 0, 0));
        alt1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        alt1.setText("Alt");
        alt1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        alt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alt1ActionPerformed(evt);
            }
        });

        windows1.setBackground(new java.awt.Color(0, 0, 0));
        windows1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        windows1.setText("Win");
        windows1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        windows1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windows1ActionPerformed(evt);
            }
        });

        control1.setBackground(new java.awt.Color(0, 0, 0));
        control1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        control1.setText("Ctrl");
        control1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        control1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                control1ActionPerformed(evt);
            }
        });

        shift1.setBackground(new java.awt.Color(0, 0, 0));
        shift1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        shift1.setForeground(new java.awt.Color(255, 255, 255));
        shift1.setText("Shift");
        shift1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        shift1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shift1ActionPerformed(evt);
            }
        });

        shift2.setBackground(new java.awt.Color(0, 0, 0));
        shift2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        shift2.setText("Shift");
        shift2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        shift2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shift2ActionPerformed(evt);
            }
        });

        x.setBackground(new java.awt.Color(0, 0, 0));
        x.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        x.setText("X");
        x.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });

        z.setBackground(new java.awt.Color(0, 0, 0));
        z.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        z.setForeground(new java.awt.Color(255, 255, 255));
        z.setText("Z");
        z.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zActionPerformed(evt);
            }
        });

        c.setBackground(new java.awt.Color(0, 0, 0));
        c.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        c.setText("C");
        c.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });

        v.setBackground(new java.awt.Color(0, 0, 0));
        v.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        v.setText("V");
        v.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vActionPerformed(evt);
            }
        });

        b.setBackground(new java.awt.Color(0, 0, 0));
        b.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        b.setText("B");
        b.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });

        n.setBackground(new java.awt.Color(0, 0, 0));
        n.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        n.setText("N");
        n.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nActionPerformed(evt);
            }
        });

        m.setBackground(new java.awt.Color(0, 0, 0));
        m.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        m.setText("M");
        m.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mActionPerformed(evt);
            }
        });

        comma.setBackground(new java.awt.Color(0, 0, 0));
        comma.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        comma.setText(",");
        comma.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        comma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commaActionPerformed(evt);
            }
        });

        fullstop.setBackground(new java.awt.Color(0, 0, 0));
        fullstop.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        fullstop.setText(".");
        fullstop.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        fullstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullstopActionPerformed(evt);
            }
        });

        slash.setBackground(new java.awt.Color(0, 0, 0));
        slash.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        slash.setText("/");
        slash.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        slash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slashActionPerformed(evt);
            }
        });

        d.setBackground(new java.awt.Color(0, 0, 0));
        d.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        d.setForeground(new java.awt.Color(255, 255, 255));
        d.setText("D");
        d.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dActionPerformed(evt);
            }
        });

        s.setBackground(new java.awt.Color(0, 0, 0));
        s.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        s.setForeground(new java.awt.Color(255, 255, 255));
        s.setText("S");
        s.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sActionPerformed(evt);
            }
        });

        f.setBackground(new java.awt.Color(0, 0, 0));
        f.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        f.setForeground(new java.awt.Color(255, 255, 255));
        f.setText("F");
        f.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });

        g.setBackground(new java.awt.Color(0, 0, 0));
        g.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        g.setForeground(new java.awt.Color(255, 255, 255));
        g.setText("G");
        g.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gActionPerformed(evt);
            }
        });

        h.setBackground(new java.awt.Color(0, 0, 0));
        h.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        h.setForeground(new java.awt.Color(255, 255, 255));
        h.setText("H");
        h.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hActionPerformed(evt);
            }
        });

        j.setBackground(new java.awt.Color(0, 0, 0));
        j.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        j.setForeground(new java.awt.Color(255, 255, 255));
        j.setText("J");
        j.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        j.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActionPerformed(evt);
            }
        });

        k.setBackground(new java.awt.Color(0, 0, 0));
        k.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        k.setForeground(new java.awt.Color(255, 255, 255));
        k.setText("K");
        k.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        k.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kActionPerformed(evt);
            }
        });

        l.setBackground(new java.awt.Color(0, 0, 0));
        l.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        l.setForeground(new java.awt.Color(255, 255, 255));
        l.setText("L");
        l.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lActionPerformed(evt);
            }
        });

        semicolon.setBackground(new java.awt.Color(0, 0, 0));
        semicolon.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        semicolon.setForeground(new java.awt.Color(255, 255, 255));
        semicolon.setText(";");
        semicolon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        semicolon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semicolonActionPerformed(evt);
            }
        });

        quote.setBackground(new java.awt.Color(0, 0, 0));
        quote.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        quote.setForeground(new java.awt.Color(255, 255, 255));
        quote.setText("\"");
        quote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
        quote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quoteActionPerformed(evt);
            }
        });

        backslash.setBackground(new java.awt.Color(0, 0, 0));
        backslash.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        backslash.setForeground(new java.awt.Color(255, 255, 255));
        backslash.setText("\\");
            backslash.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            backslash.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    backslashActionPerformed(evt);
                }
            });

            a.setBackground(new java.awt.Color(0, 0, 0));
            a.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            a.setForeground(new java.awt.Color(255, 255, 255));
            a.setText("A");
            a.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            a.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    aActionPerformed(evt);
                }
            });

            enter.setBackground(new java.awt.Color(0, 0, 0));
            enter.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            enter.setForeground(new java.awt.Color(255, 255, 255));
            enter.setText("Enter");
            enter.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            enter.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    enterActionPerformed(evt);
                }
            });

            capslock.setBackground(new java.awt.Color(0, 0, 0));
            capslock.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            capslock.setForeground(new java.awt.Color(255, 255, 255));
            capslock.setText("Caps");
            capslock.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            capslock.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    capslockActionPerformed(evt);
                }
            });

            q.setBackground(new java.awt.Color(0, 0, 0));
            q.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            q.setForeground(new java.awt.Color(255, 255, 255));
            q.setText("Q");
            q.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            q.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    qActionPerformed(evt);
                }
            });

            w.setBackground(new java.awt.Color(0, 0, 0));
            w.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            w.setForeground(new java.awt.Color(255, 255, 255));
            w.setText("W");
            w.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            w.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    wActionPerformed(evt);
                }
            });

            e.setBackground(new java.awt.Color(0, 0, 0));
            e.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            e.setForeground(new java.awt.Color(255, 255, 255));
            e.setText("E");
            e.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            e.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    eActionPerformed(evt);
                }
            });

            r.setBackground(new java.awt.Color(0, 0, 0));
            r.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            r.setForeground(new java.awt.Color(255, 255, 255));
            r.setText("R");
            r.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            r.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rActionPerformed(evt);
                }
            });

            t.setBackground(new java.awt.Color(0, 0, 0));
            t.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            t.setForeground(new java.awt.Color(255, 255, 255));
            t.setText("T");
            t.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            t.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tActionPerformed(evt);
                }
            });

            y.setBackground(new java.awt.Color(0, 0, 0));
            y.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            y.setForeground(new java.awt.Color(255, 255, 255));
            y.setText("Y");
            y.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            y.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    yActionPerformed(evt);
                }
            });

            u.setBackground(new java.awt.Color(0, 0, 0));
            u.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            u.setForeground(new java.awt.Color(255, 255, 255));
            u.setText("U");
            u.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            u.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    uActionPerformed(evt);
                }
            });

            i.setBackground(new java.awt.Color(0, 0, 0));
            i.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            i.setForeground(new java.awt.Color(255, 255, 255));
            i.setText("I");
            i.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            i.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    iActionPerformed(evt);
                }
            });

            o.setBackground(new java.awt.Color(0, 0, 0));
            o.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            o.setForeground(new java.awt.Color(255, 255, 255));
            o.setText("O");
            o.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            o.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    oActionPerformed(evt);
                }
            });

            p.setBackground(new java.awt.Color(0, 0, 0));
            p.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            p.setForeground(new java.awt.Color(255, 255, 255));
            p.setText("P");
            p.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            p.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    pActionPerformed(evt);
                }
            });

            leftbrace.setBackground(new java.awt.Color(0, 0, 0));
            leftbrace.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            leftbrace.setForeground(new java.awt.Color(255, 255, 255));
            leftbrace.setText("{");
            leftbrace.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            leftbrace.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    leftbraceActionPerformed(evt);
                }
            });

            rightbrace.setBackground(new java.awt.Color(0, 0, 0));
            rightbrace.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            rightbrace.setForeground(new java.awt.Color(255, 255, 255));
            rightbrace.setText("}");
            rightbrace.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            rightbrace.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rightbraceActionPerformed(evt);
                }
            });

            tab.setBackground(new java.awt.Color(0, 0, 0));
            tab.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            tab.setForeground(new java.awt.Color(255, 255, 255));
            tab.setText("Tab");
            tab.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            tab.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tabActionPerformed(evt);
                }
            });

            one.setBackground(new java.awt.Color(0, 0, 0));
            one.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            one.setForeground(new java.awt.Color(255, 255, 255));
            one.setText("1");
            one.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            one.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    oneActionPerformed(evt);
                }
            });

            backspace.setBackground(new java.awt.Color(0, 0, 0));
            backspace.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            backspace.setForeground(new java.awt.Color(255, 255, 255));
            backspace.setText("Bkspc");
            backspace.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            backspace.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    backspaceActionPerformed(evt);
                }
            });

            two.setBackground(new java.awt.Color(0, 0, 0));
            two.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            two.setForeground(new java.awt.Color(255, 255, 255));
            two.setText("2");
            two.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            two.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    twoActionPerformed(evt);
                }
            });

            three.setBackground(new java.awt.Color(0, 0, 0));
            three.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            three.setForeground(new java.awt.Color(255, 255, 255));
            three.setText("3");
            three.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            three.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    threeActionPerformed(evt);
                }
            });

            four.setBackground(new java.awt.Color(0, 0, 0));
            four.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            four.setForeground(new java.awt.Color(255, 255, 255));
            four.setText("4");
            four.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            four.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fourActionPerformed(evt);
                }
            });

            five.setBackground(new java.awt.Color(0, 0, 0));
            five.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            five.setForeground(new java.awt.Color(255, 255, 255));
            five.setText("5");
            five.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            five.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fiveActionPerformed(evt);
                }
            });

            six.setBackground(new java.awt.Color(0, 0, 0));
            six.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            six.setForeground(new java.awt.Color(255, 255, 255));
            six.setText("6");
            six.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            six.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    sixActionPerformed(evt);
                }
            });

            seven.setBackground(new java.awt.Color(0, 0, 0));
            seven.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            seven.setForeground(new java.awt.Color(255, 255, 255));
            seven.setText("7");
            seven.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            seven.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    sevenActionPerformed(evt);
                }
            });

            eight.setBackground(new java.awt.Color(0, 0, 0));
            eight.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            eight.setForeground(new java.awt.Color(255, 255, 255));
            eight.setText("8");
            eight.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            eight.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    eightActionPerformed(evt);
                }
            });

            nine.setBackground(new java.awt.Color(0, 0, 0));
            nine.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            nine.setForeground(new java.awt.Color(255, 255, 255));
            nine.setText("9");
            nine.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            nine.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nineActionPerformed(evt);
                }
            });

            zero.setBackground(new java.awt.Color(0, 0, 0));
            zero.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            zero.setForeground(new java.awt.Color(255, 255, 255));
            zero.setText("0");
            zero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            zero.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    zeroActionPerformed(evt);
                }
            });

            minus.setBackground(new java.awt.Color(0, 0, 0));
            minus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            minus.setForeground(new java.awt.Color(255, 255, 255));
            minus.setText("-");
            minus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            minus.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    minusActionPerformed(evt);
                }
            });

            plus.setBackground(new java.awt.Color(0, 0, 0));
            plus.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            plus.setForeground(new java.awt.Color(255, 255, 255));
            plus.setText("+");
            plus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            plus.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    plusActionPerformed(evt);
                }
            });

            escape.setBackground(new java.awt.Color(0, 0, 0));
            escape.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            escape.setForeground(new java.awt.Color(255, 255, 255));
            escape.setText("Esc");
            escape.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            escape.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    escapeActionPerformed(evt);
                }
            });

            onoff.setBackground(new java.awt.Color(0, 0, 0));
            onoff.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            onoff.setForeground(new java.awt.Color(255, 255, 255));
            onoff.setText("OFF");
            onoff.setBorder(null);
            onoff.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    onoffActionPerformed(evt);
                }
            });

            ftwo.setBackground(new java.awt.Color(0, 0, 0));
            ftwo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            ftwo.setForeground(new java.awt.Color(255, 255, 255));
            ftwo.setText("F2");
            ftwo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            ftwo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ftwoActionPerformed(evt);
                }
            });

            fthree.setBackground(new java.awt.Color(0, 0, 0));
            fthree.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            fthree.setForeground(new java.awt.Color(255, 255, 255));
            fthree.setText("F3");
            fthree.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            fthree.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fthreeActionPerformed(evt);
                }
            });

            ffour.setBackground(new java.awt.Color(0, 0, 0));
            ffour.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            ffour.setForeground(new java.awt.Color(255, 255, 255));
            ffour.setText("F4");
            ffour.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            ffour.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ffourActionPerformed(evt);
                }
            });

            ffive.setBackground(new java.awt.Color(0, 0, 0));
            ffive.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            ffive.setForeground(new java.awt.Color(255, 255, 255));
            ffive.setText("F5");
            ffive.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            ffive.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ffiveActionPerformed(evt);
                }
            });

            fsix.setBackground(new java.awt.Color(0, 0, 0));
            fsix.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            fsix.setForeground(new java.awt.Color(255, 255, 255));
            fsix.setText("F6");
            fsix.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            fsix.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fsixActionPerformed(evt);
                }
            });

            fseven.setBackground(new java.awt.Color(0, 0, 0));
            fseven.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            fseven.setForeground(new java.awt.Color(255, 255, 255));
            fseven.setText("F7");
            fseven.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            fseven.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fsevenActionPerformed(evt);
                }
            });

            feight.setBackground(new java.awt.Color(0, 0, 0));
            feight.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            feight.setForeground(new java.awt.Color(255, 255, 255));
            feight.setText("F8");
            feight.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            feight.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    feightActionPerformed(evt);
                }
            });

            fnine.setBackground(new java.awt.Color(0, 0, 0));
            fnine.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            fnine.setForeground(new java.awt.Color(255, 255, 255));
            fnine.setText("F9");
            fnine.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            fnine.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fnineActionPerformed(evt);
                }
            });

            ften.setBackground(new java.awt.Color(0, 0, 0));
            ften.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            ften.setForeground(new java.awt.Color(255, 255, 255));
            ften.setText("F10");
            ften.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            ften.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ftenActionPerformed(evt);
                }
            });

            feleven.setBackground(new java.awt.Color(0, 0, 0));
            feleven.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            feleven.setForeground(new java.awt.Color(255, 255, 255));
            feleven.setText("F11");
            feleven.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            feleven.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    felevenActionPerformed(evt);
                }
            });

            ftwelve.setBackground(new java.awt.Color(0, 0, 0));
            ftwelve.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
            ftwelve.setForeground(new java.awt.Color(255, 255, 255));
            ftwelve.setText("F12");
            ftwelve.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            ftwelve.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ftwelveActionPerformed(evt);
                }
            });

            tildth.setBackground(new java.awt.Color(0, 0, 0));
            tildth.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            tildth.setForeground(new java.awt.Color(255, 255, 255));
            tildth.setText("~");
            tildth.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            tildth.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tildthActionPerformed(evt);
                }
            });

            fone1.setBackground(new java.awt.Color(0, 0, 0));
            fone1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            fone1.setForeground(new java.awt.Color(255, 255, 255));
            fone1.setText("F1");
            fone1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 5, true));
            fone1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fone1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(control1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(windows1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(alt1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(spacebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(alt2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(windows2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(control2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(shift1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(z, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(v, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comma, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(fullstop, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(slash, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(shift2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(capslock, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(k, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(semicolon, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(quote, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(backslash, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                    .addComponent(q, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(w, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(e, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(u, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(o, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(leftbrace, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rightbrace, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(escape, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tildth, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(minus, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(plus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(backspace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(fone1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ftwo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fthree, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ffour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ffive, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fsix, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fseven, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(feight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(fnine, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ften, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(feleven, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ftwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(onoff, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(onoff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ffive, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ffour, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fsix, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fthree, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftwo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fseven, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(feight, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fnine, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ften, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(feleven, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(escape, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fone1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(plus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backspace, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tildth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(e, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(w, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(q, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(u, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(o, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(leftbrace, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rightbrace, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(k, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(semicolon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quote, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(backslash, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(capslock, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(enter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(m, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(x, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(z, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(v, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fullstop, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comma, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(slash, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(shift2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spacebar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alt1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(windows1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(control1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                    .addComponent(windows2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(control2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alt2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(shift1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );

            textfield.setBackground(new java.awt.Color(0, 0, 0));
            textfield.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
            textfield.setForeground(new java.awt.Color(255, 255, 255));
            textfield.setHorizontalAlignment(javax.swing.JTextField.LEFT);
            textfield.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    textfieldActionPerformed(evt);
                }
            });
            textfield.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    textfieldKeyPressed(evt);
                }
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    textfieldKeyReleased(evt);
                }
            });

            text_to_write.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
            jScrollPane2.setViewportView(text_to_write);

            wpmLabel.setBackground(new java.awt.Color(0, 102, 102));
            wpmLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
            wpmLabel.setForeground(new java.awt.Color(0, 0, 0));
            wpmLabel.setText("Speed : 0.00 wpm");

            personalbest.setBackground(new java.awt.Color(0, 102, 102));
            personalbest.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
            personalbest.setForeground(new java.awt.Color(0, 0, 0));
            personalbest.setText("Your Personal Best Is");

            jLabel1.setFont(new java.awt.Font("Eras Medium ITC", 1, 28)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(51, 0, 0));
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Type the below text as fast as possible.  ^_~");

            gotomainmenu.setBackground(new java.awt.Color(255, 204, 204));
            gotomainmenu.setFont(new java.awt.Font("Eras Medium ITC", 1, 30)); // NOI18N
            gotomainmenu.setForeground(new java.awt.Color(51, 0, 51));
            gotomainmenu.setText("Back");
            gotomainmenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    gotomainmenuActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout abc2Layout = new javax.swing.GroupLayout(abc2);
            abc2.setLayout(abc2Layout);
            abc2Layout.setHorizontalGroup(
                abc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(textfield)
                .addComponent(jScrollPane2)
                .addGroup(abc2Layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addGroup(abc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(abc2Layout.createSequentialGroup()
                            .addComponent(personalbest, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wpmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(111, Short.MAX_VALUE))
                .addGroup(abc2Layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gotomainmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30))
            );
            abc2Layout.setVerticalGroup(
                abc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abc2Layout.createSequentialGroup()
                    .addGroup(abc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gotomainmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(abc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(wpmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(personalbest, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(abc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(abc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void fone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fone1ActionPerformed

    private void tildthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tildthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tildthActionPerformed

    private void ftwelveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftwelveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftwelveActionPerformed

    private void felevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felevenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_felevenActionPerformed

    private void ftenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftenActionPerformed

    private void fnineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnineActionPerformed

    private void feightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feightActionPerformed

    private void fsevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fsevenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fsevenActionPerformed

    private void fsixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fsixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fsixActionPerformed

    private void ffiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ffiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ffiveActionPerformed

    private void ffourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ffourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ffourActionPerformed

    private void fthreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fthreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fthreeActionPerformed

    private void ftwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftwoActionPerformed

    private void onoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onoffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onoffActionPerformed

    private void escapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escapeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escapeActionPerformed

    private void plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plusActionPerformed

    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minusActionPerformed

    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zeroActionPerformed

    private void nineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nineActionPerformed

    private void eightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eightActionPerformed

    private void sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sevenActionPerformed

    private void sixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sixActionPerformed

    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fiveActionPerformed

    private void fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fourActionPerformed

    private void threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_threeActionPerformed

    private void twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_twoActionPerformed

    private void backspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backspaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backspaceActionPerformed

    private void oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oneActionPerformed

    private void tabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabActionPerformed

    private void rightbraceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightbraceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rightbraceActionPerformed

    private void leftbraceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftbraceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leftbraceActionPerformed

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pActionPerformed

    private void oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oActionPerformed

    private void iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iActionPerformed

    private void uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uActionPerformed

    private void yActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yActionPerformed

    private void tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tActionPerformed

    private void rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rActionPerformed

    private void eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eActionPerformed

    private void wActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wActionPerformed

    private void qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qActionPerformed

    private void capslockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capslockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capslockActionPerformed

    private void enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void backslashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backslashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backslashActionPerformed

    private void quoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quoteActionPerformed

    private void semicolonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semicolonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semicolonActionPerformed

    private void lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lActionPerformed

    private void kActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kActionPerformed

    private void jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jActionPerformed

    private void hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hActionPerformed

    private void gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gActionPerformed

    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fActionPerformed

    private void sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sActionPerformed

    private void dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dActionPerformed

    private void slashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_slashActionPerformed

    private void fullstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullstopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullstopActionPerformed

    private void commaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commaActionPerformed

    private void mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mActionPerformed

    private void nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nActionPerformed

    private void bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bActionPerformed

    private void vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cActionPerformed

    private void zActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zActionPerformed
        // TODO add your handling code here:
        //jTextPane1.setText(jTextPane1.getText()+z.getText());
    }//GEN-LAST:event_zActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xActionPerformed

    private void shift2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shift2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shift2ActionPerformed

    private void shift1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shift1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shift1ActionPerformed

    private void control1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_control1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_control1ActionPerformed

    private void windows1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windows1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_windows1ActionPerformed

    private void alt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alt1ActionPerformed

    private void windows2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windows2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_windows2ActionPerformed

    private void control2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_control2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_control2ActionPerformed

    private void alt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alt2ActionPerformed

    private void textfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfieldKeyReleased
        // TODO add your handling code here:
        initColor();
    }//GEN-LAST:event_textfieldKeyReleased

    private void textfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfieldKeyPressed
        // TODO add your handling code here:
        caponoff();
        String str=textfield.getText();
        String sbstr=prompts.substring(pos,charpos);
        if(str.length()<sbstr.length()){
            textfield.setText(sbstr);
            charpos=(int)sbstr.length();
            charpos--;

        }
        if(evt.getKeyChar()==prompts.charAt(charpos)){
            keypressed++;
            //String str=textField.getText()+evt.getKeyChar();
            textfield.setText(str);
            if(keypressed==1){
                startTime= System.nanoTime();
            }
            if(charpos>=2){
                endTime=System.nanoTime();
                calculateWPM(startTime,endTime);
            }
            charpos++;
            rightPressed(evt);
            if(charpos==prompts.length()){
                
                if(wpm>mxwpm){
                    mxwpm=wpm;
                    try{     
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/typingtutor","root","");
                        //String new_entry = "INSERT INTO logindb(username,password)  VALUES(?,?)";
                        String sql="update  information set PersonalBest=? where username=?";
                        PreparedStatement pst1=con.prepareStatement(sql);
                        pst1.setDouble(1, mxwpm);
                        pst1.setString(2, user);
                        pst1.executeUpdate();
                    }
                    catch(Exception e){
                
                    }
                }
                
                final ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\Icon\\goodjob(70x70).jpg");
                JLabel label = new JLabel("Your Typing Speed is: "+new DecimalFormat("#00.00").format(wpm) + " wpm");
                label.setFont(new Font("Arial", Font.BOLD, 20));
                JOptionPane.showMessageDialog(null,label,"Congrats",2,icon);
                CheckTypeSpeed ck=new CheckTypeSpeed(user);
                setVisible(false);
                ck.setVisible(true);
            }
        }
        else{
            wrongPressed(evt);
            if((int)textfield.getText().length()>0){
                String tm=textfield.getText().substring(0,textfield.getText().length()-1);
             if(evt.getKeyCode()!= evt.VK_BACK_SPACE && evt.getKeyCode()!=evt.VK_SHIFT) 
              textfield.setText(tm);
            }
            if(charpos>=2){
                endTime=System.nanoTime();
                calculateWPM(startTime,endTime);
            }
            

        }

    }//GEN-LAST:event_textfieldKeyPressed

    private void textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_textfieldActionPerformed

    private void gotomainmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotomainmenuActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        MainMenu mn=new MainMenu(user);
        mn.setVisible(true);
    }//GEN-LAST:event_gotomainmenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckTypeSpeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckTypeSpeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckTypeSpeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckTypeSpeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckTypeSpeed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a;
    private javax.swing.JPanel abc2;
    private javax.swing.JButton alt1;
    private javax.swing.JButton alt2;
    private javax.swing.JButton b;
    private javax.swing.JButton backslash;
    private javax.swing.JButton backspace;
    private javax.swing.JButton c;
    private javax.swing.JButton capslock;
    private javax.swing.JButton comma;
    private javax.swing.JButton control1;
    private javax.swing.JButton control2;
    private javax.swing.JButton d;
    private javax.swing.JButton e;
    private javax.swing.JButton eight;
    private javax.swing.JButton enter;
    private javax.swing.JButton escape;
    private javax.swing.JButton f;
    private javax.swing.JButton feight;
    private javax.swing.JButton feleven;
    private javax.swing.JButton ffive;
    private javax.swing.JButton ffour;
    private javax.swing.JButton five;
    private javax.swing.JButton fnine;
    private javax.swing.JButton fone1;
    private javax.swing.JButton four;
    private javax.swing.JButton fseven;
    private javax.swing.JButton fsix;
    private javax.swing.JButton ften;
    private javax.swing.JButton fthree;
    private javax.swing.JButton ftwelve;
    private javax.swing.JButton ftwo;
    private javax.swing.JButton fullstop;
    private javax.swing.JButton g;
    private javax.swing.JButton gotomainmenu;
    private javax.swing.JButton h;
    private javax.swing.JButton i;
    private javax.swing.JButton j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton k;
    private javax.swing.JButton l;
    private javax.swing.JButton leftbrace;
    private javax.swing.JButton m;
    private javax.swing.JButton minus;
    private javax.swing.JButton n;
    private javax.swing.JButton nine;
    private javax.swing.JButton o;
    private javax.swing.JButton one;
    private javax.swing.JButton onoff;
    private javax.swing.JButton p;
    private javax.swing.JLabel personalbest;
    private javax.swing.JButton plus;
    private javax.swing.JButton q;
    private javax.swing.JButton quote;
    private javax.swing.JButton r;
    private javax.swing.JButton rightbrace;
    private javax.swing.JButton s;
    private javax.swing.JButton semicolon;
    private javax.swing.JButton seven;
    private javax.swing.JButton shift1;
    private javax.swing.JButton shift2;
    private javax.swing.JButton six;
    private javax.swing.JButton slash;
    private javax.swing.JButton spacebar;
    private javax.swing.JButton t;
    private javax.swing.JButton tab;
    private javax.swing.JTextPane text_to_write;
    private javax.swing.JTextField textfield;
    private javax.swing.JButton three;
    private javax.swing.JButton tildth;
    private javax.swing.JButton two;
    private javax.swing.JButton u;
    private javax.swing.JButton v;
    private javax.swing.JButton w;
    private javax.swing.JButton windows1;
    private javax.swing.JButton windows2;
    private javax.swing.JLabel wpmLabel;
    private javax.swing.JButton x;
    private javax.swing.JButton y;
    private javax.swing.JButton z;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables
}

package Machine;

import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

//import Machine.PlugboardPanel;


public class Interface extends JFrame implements ActionListener{
    private JComboBox rotor1;
    private JComboBox rotor2;
    private JComboBox rotor3;
    private JComboBox rotorTurnover1;
    private JComboBox rotorTurnover2;
    private JComboBox rotorTurnover3;
    private JComboBox reflector;
    private JButton submitButton;
    private JTextArea textArea1;
    private JTextArea textField1;
    private JButton configPlug;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JComboBox comboBox11;
    private JComboBox comboBox12;
    private JComboBox comboBox13;
    private JComboBox comboBox14;
    private JComboBox comboBox15;
    private JComboBox comboBox16;
    private JComboBox comboBox17;
    private JComboBox comboBox18;
    private JComboBox comboBox19;
    private JComboBox comboBox20;
    private String text;
    private JFrame interfaceFrame = new JFrame("Enigma");
    String[] option = {"I", "II","III","IV","V"};
    private JButton confirmButton;
    String[] plug = new String[26];
    int count =0;
    String plugLeft= new String("ZPHNMSWCIYTQEDOBLRFKUVGXJA"),plugRight = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    JPanel panel;

    private void setupSwing() {

        interfaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //interfaceFrame.setSize(new Dimension(600, 400));
        //interfaceFrame.setIconImage(new ImageIcon(Objects.requireNonNull(Main.class.getClassLoader().getResource("C:\\Users\\krmah\\Downloads\\IMG-20200318-WA0011.jpg"))).getImage());
        //panel.setSize(new Dimension(300,300));
        JLabel insertTextLevel = new JLabel("Insert Text Here:");
        insertTextLevel.setBounds(50,50,150,20);

        Container pane = interfaceFrame.getContentPane();
        //pane.setSize(new Dimension(300,300));
        textField1 = new JTextArea();
        textField1.setBackground(Color.GREEN);
        textField1.setBounds(40,75,250,200);
        textField1.setLineWrap(true);
        textField1.setWrapStyleWord(true);

        //textField1.setSize(300,30);
        //textField1.setLocation(100,100);
        //pane.add(textField1);


        JLabel reflectorLabel = new JLabel("Reflector: ");
        //reflectorLabel.setBounds(5,100,10,1);
        String[] opReflector = {"A Reflector", "B Reflector"};
        reflector = new JComboBox(opReflector);



        JLabel rotorLabel = new JLabel("Rotor 1: ");
        //rotorLabel.setBounds(5,5,10,1);
        rotor1 = new JComboBox(option);


        JLabel rotor1Label = new JLabel("Rotor 2: ");
        //rotor1Label.setBounds(5,5,10,1);
        rotor2 = new JComboBox(option);


        JLabel rotor2Label = new JLabel("Rotor 3: ");
        //rotor2Label.setBounds(5,5,10,1);

        rotor3 = new JComboBox(option);



        String[] optionTurnover = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26"};

        JLabel rotorTurnoverLabel = new JLabel("Rotor 1 Turnover Position: ");
        //rotorTurnoverLabel.setBounds(5,5,10,1);


        rotorTurnover1 = new JComboBox(optionTurnover);
        //panel.add(rotorTurnover1);

        JLabel rotorTurnover1Label = new JLabel("Rotor 2 Turnover Position: ");
        //rotorTurnover1Label.setBounds(5,5,10,1);
        //panel.add(rotorTurnover1Label);

        rotorTurnover2 = new JComboBox(optionTurnover);
        //panel.add(rotorTurnover2);

        JLabel rotorTurnover2Label = new JLabel("Rotor 3 Turnover Position: ");
        //rotorTurnover2Label.setBounds(5,5,10,1);
        //panel.add(rotorTurnover2Label);

        rotorTurnover3 = new JComboBox(optionTurnover);
        //panel.add(rotorTurnover3);


        JButton submitButton = new JButton("Submit");
        //submitButton.setPreferredSize(new Dimension(300,30));
        submitButton.addActionListener(submitButtonActionListener(interfaceFrame));
        //
        textArea1 = new JTextArea(5,50);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        configPlug = new JButton("Config Plugboard");
        configPlug.addActionListener(configPlugButtonActionListener(interfaceFrame));
        //configPlug.setSize(20,20);

        interfaceFrame.add(insertTextLevel);interfaceFrame.add(textField1);interfaceFrame.add(new JLabel());
        //interfaceFrame.add(panel,BorderLayout.BEFORE_FIRST_LINE);
        interfaceFrame.add(reflectorLabel, BorderLayout.LINE_START);interfaceFrame.add(reflector);interfaceFrame.add(new JLabel());
        interfaceFrame.add(rotorLabel);interfaceFrame.add(rotor1Label);interfaceFrame.add(rotor2Label);
        interfaceFrame.add(rotor1);interfaceFrame.add(rotor2);interfaceFrame.add(rotor3);
        interfaceFrame.add(rotorTurnoverLabel);interfaceFrame.add(rotorTurnover1Label);interfaceFrame.add(rotorTurnover2Label);
        interfaceFrame.add(rotorTurnover1);interfaceFrame.add(rotorTurnover2);interfaceFrame.add(rotorTurnover3);
        interfaceFrame.add(new JLabel());
        interfaceFrame.add(submitButton);interfaceFrame.add(new JLabel());interfaceFrame.add(new JLabel());
        interfaceFrame.add(textArea1);interfaceFrame.add(new JLabel());interfaceFrame.add(new JLabel());
        interfaceFrame.add(configPlug);


        interfaceFrame.setLayout(new GridLayout(9,3,20,25));
        interfaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interfaceFrame.pack();
        interfaceFrame.setLocationRelativeTo(null);
        interfaceFrame.setVisible(true);
        //pane.add(interfaceFrame,BorderLayout.CENTER);
    }



    public Interface() {
        setupSwing();



    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    Interface window = new Interface();
                    window.interfaceFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private ActionListener submitButtonActionListener(Frame parentFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textField1.getText();
                //System.out.println(text);
                String[] mahir = new String[7];
                Object obj = reflector.getSelectedItem();
                mahir[0] = obj.toString();
                obj = rotor1.getSelectedItem();
                mahir[1]= obj.toString();
                obj = rotor2.getSelectedItem();
                mahir[2] = obj.toString();
                obj = rotor3.getSelectedItem();
                mahir[3] = obj.toString();
                obj = rotorTurnover1.getSelectedItem();
                mahir[4] = obj.toString();
                obj = rotorTurnover2.getSelectedItem();
                mahir[5] = obj.toString();
                obj = rotorTurnover3.getSelectedItem();
                mahir[6] = obj.toString();
                if(mahir[1]==mahir[2] || mahir[3]==mahir[2] || mahir[1]==mahir[3]){
                    JOptionPane.showMessageDialog(null, "Don't select a rotor multiple times!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    Enigma encrypt = new Enigma();
                    String plug = "ZPHNMSWCIYTQEDOBLRFKUVGXJA";
                    if(plug!=null){textArea1.setText(encrypt.Enigma(text,mahir,plugLeft,plugRight));}
                }
            }
        };
    }

    private ActionListener configPlugButtonActionListener(Frame parentFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count=0;
                //StringBuilder sb = new StringBuilder();
                JFrame plugboardFrame = new JFrame("Plugboard");
                plugboardFrame.getContentPane().setLayout(new FlowLayout());

                String[] data = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
                confirmButton = new JButton("Confirm");


                confirmButton.addActionListener(confirmButtonActionListener(plugboardFrame));
                //Scanner scan = new Scanner(pbpanel.getPlugboard());
                String[] alp = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
                /**
                 list1.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e)
                {
                if(!e.getValueIsAdjusting()) {
                final List selectedValuesList = list1.getSelectedValuesList();
                System.out.println(String.valueOf(selectedValuesList));
                boolean checker = false;
                for(int x=0;x<plug.length;x++){
                if(plug[x]==String.valueOf(selectedValuesList)){checker=true;}
                }
                if(count<20&& checker==false){
                plug[count]=String.valueOf(selectedValuesList);



                if(count%2==1){
                sb.append(" = "+plug[count]+";  \n");
                plugLabel.setText(String.valueOf(sb));
                }
                else{
                sb.append(plug[count]);
                plugLabel.setText(String.valueOf(sb));

                }
                count++;
                }

                }
                }
                });
                 */


                comboBox1 = new JComboBox(alp);
                comboBox2 = new JComboBox(alp);
                comboBox3 = new JComboBox(alp);
                comboBox4 = new JComboBox(alp);
                comboBox8 = new JComboBox(alp);
                comboBox5 = new JComboBox(alp);
                comboBox9 = new JComboBox(alp);
                comboBox6 = new JComboBox(alp);
                comboBox10 = new JComboBox(alp);
                comboBox11= new JComboBox(alp);
                comboBox12= new JComboBox(alp);
                comboBox7= new JComboBox(alp);
                comboBox13 = new JComboBox(alp);
                comboBox14= new JComboBox(alp);
                comboBox15= new JComboBox(alp);
                comboBox16= new JComboBox(alp);
                comboBox17 = new JComboBox(alp);
                comboBox18= new JComboBox(alp);
                comboBox19= new JComboBox(alp);
                comboBox20= new JComboBox(alp);

                plugboardFrame.add(comboBox1);plugboardFrame.add(new JLabel("       ="));plugboardFrame.add(comboBox11);
                plugboardFrame.add(comboBox2);plugboardFrame.add(new JLabel("       ="));plugboardFrame.add(comboBox12);
                plugboardFrame.add(comboBox3);plugboardFrame.add(new JLabel("       ="));plugboardFrame.add(comboBox13);
                plugboardFrame.add(comboBox4);plugboardFrame.add(new JLabel("       ="));plugboardFrame.add(comboBox14);
                plugboardFrame.add(comboBox5);plugboardFrame.add(new JLabel("       ="));plugboardFrame.add(comboBox15);
                plugboardFrame.add(comboBox6);plugboardFrame.add(new JLabel("       ="));plugboardFrame.add(comboBox16);
                plugboardFrame.add(comboBox7);plugboardFrame.add(new JLabel("       ="));plugboardFrame.add(comboBox17);
                plugboardFrame.add(comboBox8);plugboardFrame.add(new JLabel("       ="));plugboardFrame.add(comboBox18);
                plugboardFrame.add(comboBox9);plugboardFrame.add(new JLabel("       ="));plugboardFrame.add(comboBox19);
                plugboardFrame.add(comboBox10);plugboardFrame.add(new JLabel("      ="));plugboardFrame.add(comboBox20);

                plugboardFrame.add(new JLabel());plugboardFrame.add(confirmButton);

                plugboardFrame.setLayout(new GridLayout(11,2,0,0));
                //plugLabel.setSize(20,40);
                //plugPanel.add(plugLabel);
                //plugPanel.add(list1);

                //plugboardFrame.add(plugPanel, BorderLayout.CENTER);
                //interfaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                plugboardFrame.pack();
                plugboardFrame.setLocationRelativeTo(null);
                plugboardFrame.setVisible(true);
            }
        };
    }

    private ActionListener confirmButtonActionListener(Frame parentFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List checker = new ArrayList();
                boolean checkRepeatation = false;
                Object obj1 = comboBox1.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox2.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox3.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox4.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox5.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox6.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox7.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox8.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox9.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox10.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox11.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox12.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox13.getSelectedItem();
                checker.add( String.valueOf(obj1));
                obj1 = comboBox14.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox15.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox16.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox17.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox18.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox19.getSelectedItem();
                checker.add(String.valueOf(obj1));
                obj1 = comboBox20.getSelectedItem();
                checker.add(String.valueOf(obj1));

                for(int i = 65;i<91;i++){
                    if ( (Collections.frequency(checker, String.valueOf((char)i)) )> 1 ){
                        checkRepeatation=true;
                        break;
                    }
                }
                if(checkRepeatation==true){
                    JOptionPane.showMessageDialog(null, "Don't select a letter multiple times!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{

                    int j =0;
                    String[] plugset = new String[26];
                    for(j =0;j<checker.size();j++){
                        plug[j] = String.valueOf(checker.get(j));
                    }
                    for(int k =0;k<10;k++){
                        plugset[k] = plug[k+10];
                        plugset[k+10] = plug[k];
                    }
                    for(int i = 65;i<91;i++){
                        if ( (Collections.frequency(checker, String.valueOf((char)i))) < 1 && j <26){
                            plug[j] = String.valueOf((char)i);
                            plugset[j] = String.valueOf((char)i);
                            j++;
                        }
                    }
                    plugLeft = new String(Arrays.toString(plug));
                    plugLeft = plugLeft.replace(", ", "").replace("[","").replace("]","");
                    plugRight = new String(Arrays.toString(plugset));
                    plugRight = plugRight.replace(", ", "").replace("[","").replace("]","");
                    parentFrame.setVisible(false);
                }

            }
        };
    }
    /**
    private ListSelectionEvent list1ListSelectionEvent(Frame parentFrmae){
        return new ListSelectionEvent(){
            //@Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    }
    */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

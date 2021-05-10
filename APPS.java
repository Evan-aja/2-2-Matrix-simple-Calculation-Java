import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class APPS {
    private JButton hitung;
    private JTextField Matrix_11;
    private JTextField Matrix_13;
    private JTextField Matrix_12;
    private JTextField Matrix_14;
    private JTextField Matrix_21;
    private JTextField Matrix_23;
    private JTextField hitungannya;
    private JTextField Matrix_22;
    private JTextField Matrix_24;
    private JPanel main;

    public APPS() {
        hitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                String a[]={Matrix_11.getText(),Matrix_12.getText(),Matrix_13.getText(),Matrix_14.getText()};
                String b[]={Matrix_21.getText(),Matrix_22.getText(),Matrix_23.getText(),Matrix_24.getText()};
                int[] c=new int[a.length],d=new int[b.length],e=new int[a.length];
                for(int i=0;i<a.length;i++){
                    c[i]=Integer.parseInt(a[i]);
                    d[i]=Integer.parseInt(b[i]);
                }
                if(hitungannya.getText().equals("+"))
                    for(int i=0;i<a.length;i++)
                        e[i]=c[i]+d[i];
                else if(hitungannya.getText().equals("-"))
                    for(int i=0;i<a.length;i++)
                        e[i]=c[i]-d[i];
                else if(hitungannya.getText().equals("*")){
                    e[0]=c[0]*d[0]+c[1]*d[2];
                    e[1]=c[0]*d[1]+c[1]*d[3];
                    e[2]=c[2]*d[0]+c[3]*d[2];
                    e[3]=c[2]*d[1]+c[3]*d[3];
                }

                Object [][] data={{e[0],e[1]},{e[2],e[3]}};
                createUIComponents(data);
            }
        });
    }

    public static void main(String[]args){
        JFrame window=new JFrame("Hitung Matrix 2*2");
        window.setContentPane(new APPS().main);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

    private void createUIComponents(Object [][] data) {
        // TODO: place custom component creation code here
        JPanel panel = new JPanel();
        LayoutManager layout = new BorderLayout();
        panel.setLayout(layout);
        JFrame frame = new JFrame("Hasil Perhitungan");
        String column[]={"1","2"};
        JTable tabel=new JTable(data,column);
        tabel.setFillsViewportHeight(true);
        tabel.setFont(new java.awt.Font("Open Sans", 0, 12));
        frame.getContentPane().add(tabel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}

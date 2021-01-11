package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author ��MY
 * @description��TODO
 * @date ��2021/1/11 0:18
 */
public class GUIUtil {
    //ͼƬ���λ��
    private static String imageFolder = "img";

    /**
     * @Description: ����Ƿ�Ϊ��
     * @Param: [tf, input]
     * @return: boolean
     */
    public static boolean checkEmpty(JTextField tf, String input){
        String text = tf.getText().trim();
        if(0 == text.length()){
            //����������ʾ����Ϊ��
            JOptionPane.showMessageDialog(null, input+" ����Ϊ��");
            //��ȡ���뽹��
            tf.grabFocus();

            return false;
        }
        return true;
    }

    /**
     * @Description: ��������Ƿ�������
     * @Param: [tf, input]
     * @return: boolean
     */
    public static boolean checkNumber(JTextField tf ,String input){
        //���ж������Ƿ�Ϊ��
        if(!checkEmpty(tf, input)){
            return false;
        }
        //��ȡ��������� ��ȥ�ո�
        String text = tf.getText().trim();
        try{
            Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e) {
            //������������ת���쳣 ����ʾ��ʾ����
            JOptionPane.showMessageDialog(null, input+" ��Ҫ������");
            tf.grabFocus();
            return false;
        }
    }
    
    /**
     * @describe: ����齨�����������Ƿ�Ϊ��
     * @param tf
     * @param input
     * @return boolean
     */
    public static boolean checkZero(JTextField tf,String input){
        //���չ��� �ȼ���Ƿ�Ϊ��
        if(!checkEmpty(tf, input)){
            return false;
        }
        //��ȡ��������
        String text = tf.getText().trim();

        if(0 == Integer.parseInt(text)){
            JOptionPane.showMessageDialog(null, input+ " ����Ϊ��");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    /**
     * @describe: Ϊ�������ǰ��ɫ
     * @param color
     * @param cs
     * @return void
     */
    public static void setColor(Color color, JComponent...cs){
        for (JComponent jComponent : cs) {
            jComponent.setForeground(color);
        }
    }
    /**
     * @describe: ����ť����ͼ��,��ť�ڵ�����,�Լ���ʾ����
     * @param b
     * @param fileName
     * @param tip
     * @return void
     */
    public static void setImageIcon(JButton b,String fileName,String tip){
        //��ȡͼ����Ϣ
        ImageIcon i = new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
        //���ð�ťͼ��
        b.setIcon(i);
        //�����齨����ѡ��С
        b.setPreferredSize(new Dimension(61,81));
        //������ʾ����
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }
    /**
     * @describe: ����Ƥ��
     * @param  
     * @return void
     */
    public static void useLNF(){
        try{
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ʾ������
     * @param p
     * @param strech  �������� 1��ʾ����
     */
    public static void showPanel(JPanel p,double strech){
        GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strech);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }

    /**
     * Ĭ��Ϊ0.85���������
     * @param p
     */
    public static void showPanel(JPanel p) {
        showPanel(p,0.85);
    }
}

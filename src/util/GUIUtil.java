package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author ：MY
 * @description：TODO
 * @date ：2021/1/11 0:18
 */
public class GUIUtil {
    //图片存放位置
    private static String imageFolder = "img";

    /**
     * @Description: 检测是否为空
     * @Param: [tf, input]
     * @return: boolean
     */
    public static boolean checkEmpty(JTextField tf, String input){
        String text = tf.getText().trim();
        if(0 == text.length()){
            //弹出窗口提示不能为空
            JOptionPane.showMessageDialog(null, input+" 不能为空");
            //获取输入焦点
            tf.grabFocus();

            return false;
        }
        return true;
    }

    /**
     * @Description: 检测输入是否是数字
     * @Param: [tf, input]
     * @return: boolean
     */
    public static boolean checkNumber(JTextField tf ,String input){
        //先判断输入是否为空
        if(!checkEmpty(tf, input)){
            return false;
        }
        //获取输入的内容 并去空格
        String text = tf.getText().trim();
        try{
            Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e) {
            //捕获数据类型转化异常 并显示提示窗口
            JOptionPane.showMessageDialog(null, input+" 需要是整数");
            tf.grabFocus();
            return false;
        }
    }
    
    /**
     * @describe: 检查组建的输入内容是否为零
     * @param tf
     * @param input
     * @return boolean
     */
    public static boolean checkZero(JTextField tf,String input){
        //按照惯例 先检查是否为空
        if(!checkEmpty(tf, input)){
            return false;
        }
        //获取输入内容
        String text = tf.getText().trim();

        if(0 == Integer.parseInt(text)){
            JOptionPane.showMessageDialog(null, input+ " 不能为零");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    /**
     * @describe: 为组件设置前景色
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
     * @describe: 给按钮设置图标,按钮内的文字,以及提示文字
     * @param b
     * @param fileName
     * @param tip
     * @return void
     */
    public static void setImageIcon(JButton b,String fileName,String tip){
        //获取图标信息
        ImageIcon i = new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
        //设置按钮图标
        b.setIcon(i);
        //设置组建的首选大小
        b.setPreferredSize(new Dimension(61,81));
        //设置提示文字
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }
    /**
     * @describe: 设置皮肤
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
     * 显示画板类
     * @param p
     * @param strech  组件拉伸比 1表示满屏
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
     * 默认为0.85的拉伸比例
     * @param p
     */
    public static void showPanel(JPanel p) {
        showPanel(p,0.85);
    }
}

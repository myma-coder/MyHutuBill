package gui.panel;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

/**
 * @author £ºMY
 * @description£ºTODO
 * @date £º2021/1/11 10:33
 */
public class BackupPanel extends WorkingPanel {
    private static final long serialVersionUID = 1L;

    static{
        GUIUtil.useLNF();
    }

    public static BackupPanel instance  = new BackupPanel();
    JButton bBuckup = new JButton("±¸·Ý");

    private BackupPanel(){
        GUIUtil.setColor(ColorUtil.blueColor,bBuckup);
        this.add(bBuckup);
        addListener();
    }

    public static void main(String[] args){
        GUIUtil.showPanel(BackupPanel.instance);
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {
        BackupListener listener = new BackupListener();
        bBuckup.addActionListener(listener);
    }
}

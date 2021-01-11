package gui.listener;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

/**
 * @author ��MY
 * @description��TODO
 * @date ��2021/1/11 10:34
 */
public class BackupListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        BackupPanel panel = BackupPanel.instance;
        //��ȡ���ݿ��е�mysql·��
        String mysqlPath = new ConfigService().getValueByKey(ConfigService.mysqlPath);
        //�ж�mysql������·��
        if(0 == mysqlPath.length()){
            JOptionPane.showMessageDialog(panel, "����ǰ��������mysql�İ�װ·��");
            //��ת�����ý���
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            //mysql��������ȡ����
            ConfigPanel.instance.tfMysqlPath.grabFocus();
            return ;
        }

        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".sql");
            }

            @Override
            public String getDescription() {
                return ".sql";
            }
        });
        int returnVal = fc.showSaveDialog(panel);
        File file = fc.getSelectedFile();
//		System.out.println(file);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            if(!file.getName().toLowerCase().endsWith(".sql")){
                file = new File(file.getParent(),file.getName()+".sql");
            }

            try{
                MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(panel,  "���ݳɹ�,�����ļ�λ��:\r\n"+file.getAbsolutePath());
            }catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(panel, "����ʧ��");
            }
        }

    }
}

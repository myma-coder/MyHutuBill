package gui.panel;

import javax.swing.*;

/**
 * @author ��MY
 * @description��TODO
 * @date ��2021/1/11 0:35
 */
public abstract class WorkingPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    /**
     * ��Ľ��汣�ֺ����ݿ��ͬ��
     */
    public abstract void updateDate();
    /**
     * Ϊ�������Ӽ�����
     */
    public abstract void addListener();
}

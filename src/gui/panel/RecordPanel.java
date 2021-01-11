package gui.panel;
/*
 * ���Ѽ�¼���
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

import entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends WorkingPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//����Ƥ��
	static{
		GUIUtil.useLNF();
	}
	
	public static RecordPanel instance = new RecordPanel();
	
	//��ʼ�����
	public JLabel lSpend = new JLabel("����");
	public JLabel lCategory = new JLabel("����");
	public JLabel lComment = new JLabel("��ע");
	public JLabel lDate = new JLabel("����");
	
	public JTextField tfSpend = new JTextField("0");
	
	public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
	public JComboBox<Category> cbCategory = new JComboBox<Category>(cbModel);
	public JTextField tfComment = new JTextField();
	public JXDatePicker datepick = new JXDatePicker(new Date());
	
	JButton bSubmit = new JButton("��һ��");
	
	private RecordPanel(){
		GUIUtil.setColor(ColorUtil.grayColor, lSpend,lCategory,lComment,lDate);
		GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
		JPanel pInput =new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4,2,gap,gap));
		pInput.add(lSpend);
		pInput.add(tfSpend);
		pInput.add(lCategory);
		pInput.add(cbCategory);
		pInput.add(lComment);
		pInput.add(tfComment);
		pInput.add(lDate);
		pInput.add(datepick);

		pSubmit.add(bSubmit);

		this.setLayout(new BorderLayout());
		this.add(pInput,BorderLayout.NORTH);
		this.add(pSubmit,BorderLayout.CENTER);
		
		
		//��Ӽ���
		addListener();
	}
	
//	
//	/**
//	 * ��ȡjComboBox��ѡ�е�ѡ��
//	 * @param agrs
//	 */
//	public Category getSelectedCategory(){
//		return (Category) cbCategory.getSelectedItem();
//	}
	
	public static void main(String[] agrs){
		GUIUtil.showPanel(RecordPanel.instance);
	}

	@Override
	public void updateDate() {
		//���¸�ֵcbModel�е�cs����
		cbModel.cs = new CategoryService().getCategoryWithRecordNumber();
		//������Ⱦ
		cbCategory.updateUI();
		
		//���������Ŀؼ�
		tfSpend.setText("");
		tfComment.setText("");
		if(0 != cbModel.getSize()){
			cbCategory.setSelectedItem(0);
		}
		
		datepick.setDate(new Date());
	}

	@Override
	public void addListener() {
		RecordListener listener = new RecordListener();
		
		bSubmit.addActionListener( listener);
	}
}

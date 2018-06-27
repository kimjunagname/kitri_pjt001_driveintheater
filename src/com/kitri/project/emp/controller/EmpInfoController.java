package com.kitri.project.emp.controller;

import java.awt.Color;
import java.awt.event.*;
import java.util.List;

import javax.security.auth.login.LoginContext;
import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;

import com.kitri.project.branch.service.BranchService;
import com.kitri.project.calendar.MakeCalendar;
import com.kitri.project.emp.dto.EmpInfoDto;
import com.kitri.project.emp.service.EmpInfoService;
import com.kitri.project.emp.view.EmpMain;
import com.kitri.project.job.service.JobService;
import com.kitri.project.supervisor.view.SuperAdministratorTabbedFrame;

public class EmpInfoController implements ActionListener, KeyListener, ItemListener {

	public static EmpInfoDto login;
	EmpInfoService iService;
	JobService jService;
	BranchService bService;

	EmpMain empMain;
	MakeCalendar myCalendar;
	SuperAdministratorTabbedFrame superadminMenu = new SuperAdministratorTabbedFrame();
	// JTabbedPane tabbedPane;
	// JPanel nowP;
	boolean idFlag = false;
	boolean emailFlag = false;
	String tmpId;
	String tmpEmail;

	public EmpInfoController(EmpMain empMain) {
		this.empMain = empMain;
		iService = new EmpInfoService();
		jService = new JobService();
		bService = new BranchService();
		myCalendar = new MakeCalendar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == empMain.joinBtn) { // ������ ���Թ�ư
			idFlag = false;
			emailFlag = false;
			empMain.idTf.setText("");
			empMain.pwdTf.setText("");
			List<String> list = jService.getJobNames();
			int size = list.size();
			if(empMain.joinFrame.jobC.getItemCount() != 0) {
				empMain.joinFrame.jobC.removeAll();
			}
			
			if(empMain.joinFrame.branchC.getItemCount() != 0) {
				empMain.joinFrame.branchC.removeAll();
			}
			
			for (int i = 0; i < size; i++) {
				empMain.joinFrame.jobC.add(list.get(i));
			}
			list = bService.getBranchNames();
			size = list.size();
			for (int i = 0; i < size; i++) {
				empMain.joinFrame.branchC.add(list.get(i));
			}
			
			empMain.joinFrame.yearList.removeAll();
			empMain.joinFrame.monthList.removeAll();
			empMain.joinFrame.dateList.removeAll();
			for (int i = 2018; i >= 1940; i--) {
				empMain.joinFrame.yearList.add(i+"");
			}
			
			for (int i = 0; i < 12; i++) {
				empMain.joinFrame.monthList.add((i+1)+"");
			}
			for (int i = 0; i < 28; i++) {
				empMain.joinFrame.dateList.add((i+1)+"");
			} 
			empMain.setVisible(false);
			empMain.joinFrame.setVisible(true);
			
			
		} else if (obj == empMain.joinFrame.cancelBtn) {		//������������ ��ҹ�ư
			empMain.joinFrame.idTf.setText("");
			empMain.joinFrame.pwdTf.setText("");
			empMain.joinFrame.pwdChkTf.setText("");
			empMain.joinFrame.nameTf.setText("");
//			empMain.joinFrame.yearList.setText("");
			empMain.joinFrame.yearList.removeAll();
			empMain.joinFrame.monthList.removeAll();
			empMain.joinFrame.dateList.removeAll();
			empMain.joinFrame.phoneTf.setText("");
			empMain.joinFrame.emailTf.setText("");
			empMain.joinFrame.setVisible(false);
			empMain.setVisible(true);
			
			
		} else if (obj == empMain.joinFrame.idChkBtn) {							//������������ id�ߺ�üũ��ư
			String inputId = empMain.joinFrame.idTf.getText().trim();

			if (inputId.isEmpty()) { // idTf�� �Է� ���� ���� ���
				JOptionPane.showMessageDialog(empMain.joinFrame, "���̵� �Է��� �ּ���.", "Ȯ��", JOptionPane.WARNING_MESSAGE);
				return;
			}
			idFlag = iService.checkNotExistId(inputId);
			if (idFlag) {
//			if(!inputId.equals(iService.getById(inputId).getEmp_id())) {
				JOptionPane.showMessageDialog(empMain.joinFrame, "����� �� �ִ� ���̵��Դϴ�.", "Ȯ��",	JOptionPane.INFORMATION_MESSAGE);
				tmpId = inputId;
				empMain.joinFrame.idChkBtn.setBackground(Color.GREEN);
			} else {
				JOptionPane.showMessageDialog(empMain.joinFrame, "����� �� ���� ���̵��Դϴ�.", "Ȯ��", JOptionPane.WARNING_MESSAGE);
				tmpId = "";
				return;
			}
			
			
			
		} else if (obj == empMain.joinFrame.emailChkBtn) {					//������������ email�ߺ�üũ��ư
			String inputEmail = empMain.joinFrame.emailTf.getText().trim();
			if(inputEmail.isEmpty()) {
				JOptionPane.showMessageDialog(empMain.joinFrame, "�̸��� �Է��� �ּ���.", "Ȯ��", JOptionPane.WARNING_MESSAGE);
				return;
			}
			emailFlag = iService.checkNotExistEmail(inputEmail);
			if (emailFlag) {
//			if(!inputEmail.equals(iService.getByEmail(inputEmail).getEmp_email())) {
				JOptionPane.showMessageDialog(empMain.joinFrame, "����� �� �ִ� �̸����Դϴ�.", "Ȯ��",	JOptionPane.INFORMATION_MESSAGE);
				empMain.joinFrame.emailChkBtn.setBackground(Color.GREEN);
				tmpEmail = inputEmail;
			} else {
				JOptionPane.showMessageDialog(empMain.joinFrame, "����� �� ���� �̸����Դϴ�.", "Ȯ��", JOptionPane.WARNING_MESSAGE);
				tmpEmail = "";
				return;
			}
			
			
		} else if (obj == empMain.joinFrame.joinBtn) {						 // ������������ ���Թ�ư
			String id = empMain.joinFrame.idTf.getText().trim();
			String pwd = new String(empMain.joinFrame.pwdTf.getPassword());
			String pwdChk = new String(empMain.joinFrame.pwdChkTf.getPassword());
			if (!pwd.contentEquals(pwdChk)) {
				JOptionPane.showMessageDialog(empMain.joinFrame, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "����", JOptionPane.WARNING_MESSAGE);
				empMain.joinFrame.pwdTf.requestFocus();
				return;
			} else {
				String name = empMain.joinFrame.nameTf.getText().trim();
//				String birth = empMain.joinFrame.yearList.getText().trim();
				String birth = empMain.joinFrame.yearList.getSelectedItem().trim();
				String month = empMain.joinFrame.monthList.getSelectedItem().trim();
				String date = empMain.joinFrame.dateList.getSelectedItem().trim();
				
				if(month.length() == 1) {
					birth += "0";
				}
				birth += month;
				if(date.length() == 1) {
					birth += "0";
				}
				birth += date;
//				System.out.println(birth);
				String phone = empMain.joinFrame.phoneTf.getText().trim();
				String email = empMain.joinFrame.emailTf.getText().trim();
				int job_no = empMain.joinFrame.jobC.getSelectedIndex() + 1;
				String job_name = empMain.joinFrame.jobC.getSelectedItem();
				int branch_no = empMain.joinFrame.branchC.getSelectedIndex() + 1;
				String branch_name = empMain.joinFrame.branchC.getSelectedItem();

				if ("".equals(id) || "".equals(name) || "".equals(email) || "".equals(pwd)) {
					JOptionPane.showMessageDialog(empMain.joinFrame, "*�� �ʼ� �Է»����� ��� �Է��� �ּ���.", "����",	JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (!idFlag || !id.equals(tmpId)) {
					JOptionPane.showMessageDialog(empMain.joinFrame, "���̵� �ߺ�üũ�� �ϼ���.", "����", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (!emailFlag || !email.equals(tmpEmail)) {
					JOptionPane.showMessageDialog(empMain.joinFrame, "�̸��� �ߺ�üũ�� �ϼ���.", "����", JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					EmpInfoDto emp = new EmpInfoDto();
					emp.setEmp_id(id);
					emp.setEmp_pwd(pwd);
					emp.setEmp_name(name);
					emp.setEmp_birth(birth);
					emp.setEmp_phone(phone);
					emp.setEmp_email(email);
					emp.setJob_no(job_no);
					emp.setJob_name(job_name);
					emp.setBranch_no(branch_no);
					emp.setBranch_name(branch_name);
					if (iService.joinEmp(emp) > 0) {
						// System.out.println("���Լ���");
						JOptionPane.showMessageDialog(empMain.joinFrame, "���ԵǾ����ϴ�.", "���Լ���",
								JOptionPane.INFORMATION_MESSAGE);
						empMain.joinFrame.idTf.setText("");
						empMain.joinFrame.pwdTf.setText("");
						empMain.joinFrame.pwdChkTf.setText("");
						empMain.joinFrame.nameTf.setText("");
//						empMain.joinFrame.yearList.setText("");
						empMain.joinFrame.phoneTf.setText("");
						empMain.joinFrame.emailTf.setText("");
						empMain.joinFrame.setVisible(false);
						empMain.setVisible(true);
					} else {
						System.out.println("���� ����");
					}
				}
			}
			
			
			
			
		} else if (obj == empMain.loginBtn || obj == empMain.pwdTf) { 						//������ �α��ι�ư
			String id = empMain.idTf.getText().trim();
			String pwd = new String(empMain.pwdTf.getPassword());
			System.out.println(id);
			System.out.println(pwd);
			if ("".equals(id) || "".equals(pwd)) {
				return;
			}
			if ((login = iService.loginEmp(id, pwd)) != null) {
				empMain.idTf.setText("");
				empMain.pwdTf.setText("");
				empMain.setVisible(false);
				empMain.tabFrame.nameLabel.setText(login.getEmp_name() + "��");
				empMain.tabFrame.gradeLabel.setText(login.getBranch_name() + "�� " + login.getJob_name());
				if ("�ְ�������".equals(login.getJob_name())) {
					System.out.println("E_I_Controller �ְ������� �α���");
					// empMain.contentPane.get
					// empMain.tabFrame.remove(empMain.tabFrame.workTabPanel);
					empMain.superTabFrame.nameLabel.setText(login.getEmp_name()+ "�� ȯ���մϴ�!");
					empMain.superTabFrame.gradeLabel.setText("��å : "+login.getJob_name());
					
					empMain.superTabFrame.chartPanel.branchC.removeAll();
					List<String>list = bService.getBranchNames();
					int size = list.size();
					for (int i = 0; i < size; i++) {
						empMain.superTabFrame.chartPanel.branchC.add(list.get(i));
					}
					empMain.superTabFrame.setVisible(true);
				} else if ("����������".equals(login.getJob_name())) {
					System.out.println("E_I_Controller ���������� �α���");
					empMain.tabFrame.workMainPanel.workInBtn.setVisible(false);
					empMain.tabFrame.workMainPanel.workOutBtn.setVisible(false);
					empMain.tabFrame.workMainPanel.timeMngBtn.setBounds(60, 75, 820, 360);
					empMain.tabFrame.setVisible(true);
				} else if ("����".equals(login.getJob_name())) {
					System.out.println("E_I_Controller ���� �α���");
					empMain.tabFrame.workMainPanel.workInBtn.setVisible(true);
					empMain.tabFrame.workMainPanel.workOutBtn.setVisible(true);
					empMain.tabFrame.setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(empMain, "���̵� �Ǵ� ��й�ȣ Ȯ���� �ٽ� �α����ϼ���", "�α��ν���",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			
			
			
		} else if (obj == empMain.tabFrame.infoBtn) {										//���������� �������� ��ư
			System.out.println("E_I_Controller �������� ��ư");
			empMain.editFrame.yearC.removeAll();
			empMain.editFrame.monthC.removeAll();
			empMain.editFrame.dateC.removeAll();
			for (int i = 2018; i >= 1940; i--) {
				empMain.editFrame.yearC.add(i+"");
			}
			
			for (int i = 0; i < 12; i++) {
				empMain.editFrame.monthC.add((i+1)+"");
			}
			for (int i = 0; i < 28; i++) {
				empMain.editFrame.dateC.add((i+1)+"");
			} 
			
			int emp_no = EmpInfoController.login.getEmp_no();
			EmpInfoDto login = iService.getEmpByEmpNo(emp_no);
			empMain.editFrame.idLabel.setText(login.getEmp_id());
			empMain.editFrame.nameLabel.setText(login.getEmp_name());
//			empMain.editFrame.birthTf.setText(login.getEmp_birth());
			String birth = "";
			if(!login.getEmp_birth().isEmpty()) {
				birth = login.getEmp_birth();
			}else {
				birth = "20180101";
			}
			String year = birth.substring(0, 4);
			String month = birth.substring(4, 6);
			if(month.startsWith("0")) {
				month = month.substring(1);
			}
			String date = birth.substring(6);
			if(date.startsWith("0")) {
				date = date.substring(1);
			}
			empMain.editFrame.yearC.select(year);
			empMain.editFrame.monthC.select(month);
			empMain.editFrame.dateC.select(date);
			empMain.editFrame.emailLabel.setText(login.getEmp_email());
			empMain.editFrame.jobLabel.setText(login.getJob_name());
			empMain.editFrame.branchLabel.setText(login.getBranch_name());
			empMain.editFrame.phoneTf.setText(login.getEmp_phone());
			empMain.editFrame.pwdTf.setText("");
			empMain.editFrame.pwdChkTf.setText("");
			empMain.tabFrame.setVisible(false);
			empMain.editFrame.setVisible(true);

			
			
			
		} else if (obj == empMain.editFrame.editBtn) {										//�������� �������� �������� ��ư
			EmpInfoDto editEmp = new EmpInfoDto();
			// ��й�ȣ ��ġ �� ���� ����
			String pwd = new String(empMain.editFrame.pwdTf.getPassword());
			String pwdChk = new String(empMain.editFrame.pwdChkTf.getPassword());
			if (pwd.isEmpty() || pwdChk.isEmpty()) {
				JOptionPane.showMessageDialog(empMain.joinFrame, "��й�ȣ�� �Է��ϼ���.", "����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (!pwd.contentEquals(pwdChk)) {
				JOptionPane.showMessageDialog(empMain.joinFrame, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String id = empMain.editFrame.nameLabel.getText();
//			String birth = empMain.editFrame.birthTf.getText().trim();
			String birth = empMain.editFrame.yearC.getSelectedItem().trim();
			String month = empMain.editFrame.monthC.getSelectedItem().trim();
			String date = empMain.editFrame.dateC.getSelectedItem().trim();
			if(month.length() == 1) {
				birth += "0";
			}
			birth += month;
			if(date.length() == 1) {
				birth += "0";
			}
			birth += date;
			String phone = empMain.editFrame.phoneTf.getText().trim();
			editEmp.setEmp_id(id);
			editEmp.setEmp_pwd(pwd);
			editEmp.setEmp_birth(birth);
			editEmp.setEmp_phone(phone);
			if (iService.editEmp(editEmp) > 0) {
				System.out.println("E_I_Controller �������� ����");
			} else {
				System.out.println("E_I_Controller �������� ����");
			}
			empMain.editFrame.setVisible(false);
			empMain.tabFrame.setVisible(true);

			
			
		} else if (obj == empMain.editFrame.cancelBtn) {								//�������� �������� ��� ��ư
			empMain.editFrame.setVisible(false);
			empMain.tabFrame.setVisible(true);

			
			
			
			
			// TODO �α׾ƿ� �� ��� ���� �ʱ�ȭ
		} else if (obj == empMain.tabFrame.outBtn) { 									//���������� �α׾ƿ�
			if ("�ְ�������".equals(login.getJob_name())) {
				// empMain.tabFrame.add(empMain.tabFrame.workTabPanel);
			} else if ("����������".equals(login.getJob_name())) {
				empMain.tabFrame.workMainPanel.timeMngBtn.setBounds(656, 73, 232, 361);
			}
			login = null;

			empMain.tabFrame.setVisible(false);
			empMain.tabFrame.workMainPanel.workInBtn.setEnabled(true);
			empMain.tabFrame.workMainPanel.workOutBtn.setEnabled(true);
			empMain.setVisible(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		Object obj = e.getSource();
		if(obj == empMain.joinFrame.idTf) {
			empMain.joinFrame.idChkBtn.setBackground(Color.RED);
			idFlag = false;
		}else if(obj == empMain.joinFrame.emailTf) {
			empMain.joinFrame.emailChkBtn.setBackground(Color.RED);
			emailFlag = false;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		
		if(obj == empMain.joinFrame.monthList || obj == empMain.joinFrame.yearList) {
			if(empMain.joinFrame.monthList.getSelectedItem().isEmpty() || empMain.joinFrame.yearList.getSelectedItem().isEmpty()) {
				return;
			}
			empMain.joinFrame.dateList.removeAll();
			String year = empMain.joinFrame.yearList.getSelectedItem();
			String month = empMain.joinFrame.monthList.getSelectedItem();
			int lastDate = myCalendar.calcEndDate(year, month);
//			System.out.println(year+" / " + month + " / " + lastDate);
			for (int i = 1; i <= lastDate; i++) {
				empMain.joinFrame.dateList.add(i+"");
			}
			
		}else if (obj == empMain.editFrame.yearC || obj == empMain.editFrame.monthC) {
			if(empMain.editFrame.yearC.getSelectedItem().isEmpty() || empMain.editFrame.monthC.getSelectedItem().isEmpty()) {
				return;
			}
			empMain.editFrame.dateC.removeAll();
			String year = empMain.editFrame.yearC.getSelectedItem();
			String month = empMain.editFrame.monthC.getSelectedItem();
			int lastDate = myCalendar.calcEndDate(year, month);
			for (int i = 1; i <= lastDate; i++) {
				empMain.editFrame.dateC.add(i+"");
			}
			
		}
		
	}
}
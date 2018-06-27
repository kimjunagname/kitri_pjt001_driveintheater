package com.kitri.project.superadmin.service;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;

import com.kitri.project.emp.view.EmpMain;
import com.kitri.project.movie.dto.MovieDto;
import com.kitri.project.movie.service.SuperAdminMovieDao;
import com.kitri.project.superadmin.view.SuperAdminMenu;
import com.kitri.project.superadmin.view.SuperAdminTabbedFrame;

public class SuperAdminService {
	EmpMain menu;
	SuperAdminMovieDao dao;

	public SuperAdminService(EmpMain menu) {
		this.menu = menu;
		dao = new SuperAdminMovieDao(menu);
	}

	public String openFile() {
		InputStream fis = null;
		OutputStream fos = null;

		FileDialog read = new FileDialog(menu, "열기", FileDialog.LOAD);
		read.setVisible(true);

		String fileDir = read.getDirectory();
		String fileName = read.getFile();

		String filePath = fileDir + File.separator + fileName;
		menu.superTabFrame.movieInsertPanel.imagePathF.setText(filePath);

		menu.superTabFrame.movieInsertPanel.imageL.setIcon(new ImageIcon(filePath));

		// 파일 넣기
		try {
			fis = new FileInputStream(filePath);
			fos = new FileOutputStream(fileName); // ./에 저장
			int n= 0;
			while (true) {
				n= fis.read();
				if (n == -1) 
					break;
				 fos.write(n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileName;
	}

	public int insertMovie(MovieDto dto) {
		return dao.insertMovieByAdmin(dto);
	}
}

package com.kitri.project.chart;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.kitri.project.chart.dto.PayChartDto;

public class MyChart {
	public JFreeChart barChart;
	public MyChart(String chartTitle, String categoryLabel, String valueLabel, String[] categoryStr, String[] valueStr, List<Object> list) {
		barChart = ChartFactory.createBarChart(
				chartTitle, 
				categoryLabel, 
				valueLabel, 
				createDataset(categoryStr, valueStr, list),
				PlotOrientation.HORIZONTAL, 
				true, 
				true, 
				false
		);
		CategoryPlot plot = (CategoryPlot) barChart.getPlot();
		Font myFont = null;
		myFont = barChart.getTitle().getFont();
		//차트 제목
		barChart.getTitle().setFont(new Font("굴림", myFont.getStyle(), myFont.getSize()));
		
		//가로축 제목
		myFont = plot.getDomainAxis().getLabelFont();
		plot.getDomainAxis().setLabelFont(new Font("굴림", myFont.getStyle(), myFont.getSize()));
		
		//가로축 값 레이블
		myFont = plot.getDomainAxis().getTickLabelFont();
		plot.getDomainAxis().setTickLabelFont(new Font("굴림", myFont.getStyle(), myFont.getSize()));
		
		//세로축 제목
		myFont = plot.getRangeAxis().getLabelFont();
		plot.getRangeAxis().setLabelFont(new Font("굴림", myFont.getStyle(), myFont.getSize()));
		
		//세로축 값 레이블
		myFont = plot.getRangeAxis().getTickLabelFont();
		plot.getRangeAxis().setTickLabelFont(new Font("굴림", myFont.getStyle(), myFont.getSize()));
		
		//범례
		barChart.getLegend().setItemFont(new Font("굴림", Font.PLAIN, 10));
		
	}
	
	   public CategoryDataset createDataset(String[] categoryStr, String[] valueStr, List<Object> list) {
//		   PayChartDto dto = null;
		   final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
		   
		   if(list.get(0) instanceof PayChartDto) {			//매출 통계
			   List<PayChartDto> dtoList = new ArrayList<>();
			   for(int i=0; i<list.size(); i++) {
				   dtoList.add((PayChartDto)list.get(i));
			   }
			   
			   for(int i=0; i<valueStr.length; i++) {
				   dataset.addValue(dtoList.get(i).getTicket_paytotal(), categoryStr[0], valueStr[i]);
				   dataset.addValue(dtoList.get(i).getTicket_paycash(), categoryStr[1], valueStr[i]);
				   dataset.addValue(dtoList.get(i).getTicket_paymileage(), categoryStr[2], valueStr[i]);
			   }
		   }else if(false) {								//예매율 통계
			   
		   }
		   
//	      final String total = "총매출";        //총
//	      final String cash = "CASH";        //현금
//	      final String millage = "MILEAGE";        //마일리지
//	      final String year0 = "2018";        //2018
//	      final String year1 = "2017";       //2017 
//	      final String year2 = "2016";      //2016
		  
	/*
	      dataset.addValue( 2543000.0 , total , year0 );        
	      dataset.addValue( 75000.0 , total , year1 ); 
	      dataset.addValue( 954000.0 , total , year2 );        
	*/
/*		   
	      dataset.addValue( 1543000.0 , cash , year0 );        
	      dataset.addValue( 65000.0 , cash , year1 );        
	      dataset.addValue( 950000.0 , cash , year2 );       

	      dataset.addValue( 1000000.0 , millage , year0 );        
	      dataset.addValue( 10000.0 , millage , year1 );        
	      dataset.addValue( 4000.0 , millage , year2 );        
*/
	      return dataset; 
	   }

}

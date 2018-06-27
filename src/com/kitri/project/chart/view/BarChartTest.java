package com.kitri.project.chart.view;

import javax.swing.JFrame;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset; 

public class BarChartTest extends JFrame{
   
   public BarChartTest(String type, String chartTitle) {
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         type,            
         "PRICE",            
         createDataset(),          
         PlotOrientation.HORIZONTAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
//      final String total = "ÃÑ¸ÅÃâ";        //ÃÑ
      final String cash = "CASH";        //Çö±Ý
      final String millage = "MILEAGE";        //¸¶ÀÏ¸®Áö
      final String year0 = "2018";        //2018
      final String year1 = "2017";       //2017 
      final String year2 = "2016";      //2016  
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
/*
      dataset.addValue( 2543000.0 , total , year0 );        
      dataset.addValue( 75000.0 , total , year1 ); 
      dataset.addValue( 954000.0 , total , year2 );        
*/
      dataset.addValue( 1543000.0 , cash , year0 );        
      dataset.addValue( 65000.0 , cash , year1 );        
      dataset.addValue( 950000.0 , cash , year2 );       

      dataset.addValue( 1000000.0 , millage , year0 );        
      dataset.addValue( 10000.0 , millage , year1 );        
      dataset.addValue( 4000.0 , millage , year2 );        

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
	   BarChartTest chart = new BarChartTest("YEAR", "CHART TEST");
	   chart.pack( );        
//      RefineryUtilities.centerFrameOnScreen( chart );        
	   chart.setVisible( true ); 
   }
}


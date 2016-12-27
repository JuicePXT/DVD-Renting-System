package renting2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class DVD_RENTING_SYSTEM {
	public static void old(String[] args){
				fos=new FileOutputStream("c:\\Temp\\olddvd.txt",true);
		//	String a[]=null;a[0]=dvdname.getText().trim();a[1]=dvdpublisher.getText().trim();a[2]=dvdnumber.getText().trim();a[3]=dvdprice.getText().trim();
						AbstractButton old_dvd_name_input;
						AbstractButton old_dvd_publisher_input;
						AbstractButton old_dvd_number_input;
						AbstractButton old_dvd_quantity_input;
						String temp=old_dvd_name_input.getText()+"|"+old_dvd_publisher_input.getText().trim()+"|"+old_dvd_quantity_input.getText().trim()+"|"+old_dvd_number_input.getText().trim()+"|";
				       String[] info=temp.split("\\|");
				      							
						try{  
							
						    
						    fos.write(temp.getBytes());
						
		    
		       
				}catch(Exception e1){
					e1.printStackTrace();
				}	
				
		       	}catch(Exception ex){
		       		ex.printStackTrace();
		       	}finally{
		       		try{
		       			fos.close();
		       		}catch(Exception ex){
		       			ex.printStackTrace();
		       		}
		       	}
				JOptionPane.showMessageDialog(null,"录入成功：DVD片名："+old_dvd_name_input.getText().trim()+"    DVD出版社："+old_dvd_publisher_input.getText().trim()+"    DVD编号："+old_dvd_number_input.getText().trim()+"     DVD数量："+old_dvd_quantity_input.getText(),"录入成功",JOptionPane.INFORMATION_MESSAGE);
				old_dvd_name_input.setText("");
				old_dvd_publisher_input.setText("");
				old_dvd_quantity_input.setText("");
				old_dvd_number_input.setText("");
		   
		}
		
		}else if(e.getSource()==oldbutton){
			File file=new File("c:\\Temp\\olddvd.txt");
			if(!file.exists())
			return;
				FileReader fr=null;
		        BufferedReader br=null;
		        try{ 
		        	int count=0;
		        	int a = 0;
		        	fr=new FileReader(file);
		        	br=new BufferedReader(fr);
		        	String lineStr=null;
		           String error=null;
		         while((lineStr=br.readLine())!=null){
		        	String[] info=lineStr.split("\\|");
		        
		        	 for(int i=0;i<info.length;i++){
		        		 if(old_dvd.getText().compareTo(info[i])==0) 
		        		 {
		        			 a=i;
		        			
		        		 }else{
		        			 error="未找到结果";
		        		 }
		        	 }
		        		 if(old_dvd.getText().compareTo(info[a])==0){
		        		 JOptionPane.showMessageDialog(null,"查询成功：DVD片名："+info[a]+"    DVD出版社："+info[a+1]+"    DVD数量："+info[a+2]+"    DVD编号："+info[a+3],"搜索结果",JOptionPane.INFORMATION_MESSAGE);
		        		 }
		        	  else{
			        	 JOptionPane.showMessageDialog(null,error,"搜索结果",JOptionPane.INFORMATION_MESSAGE); 
			        	
			         }
		         }
		        	
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				br.close();
				fr.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
         	}

		}else if(e.getSource()==returnrent){
			fos FileOutputStream fos=null;
			File file=new File("c:\\Temp\\rent.txt");
			File file2=new File("c:\\Temp\\reports.txt");
			if(!file.exists())
			return;
				FileReader fr=null;
				FileReader fr2=null;
		        BufferedReader br=null;
		        BufferedReader br2=null;
		        
		        try{ 
		        	int count=0;
		        	int a = 0;
		        	fr=new FileReader(file);
		        	fr2=new FileReader(file2);
		        	br=new BufferedReader(fr);
		        	br2=new BufferedReader(fr2);
		        	String lineStr=null;
		           String error=null;
		         while((lineStr=br.readLine())!=null){
		        	String[] info=lineStr.split("\\|");
		        
		        	 for(int i=0;i<info.length;i++){
		        		 if(returnuserid.getText().compareTo(info[i])==0) 
		        		 {
		        			 a=i;
		        			
		        		 }else{
		        			 error="未找到结果";
		        		 }
		        	 }
		        		 if(returnuserid.getText().compareTo(info[a])==0){
		        		 JOptionPane.showMessageDialog(null,info[a-1]+"     "+info[a+1]+"    租出日期："+info[a+3]+"月"+info[a+4]+"日   退回金额："+info[a+5],"搜索结果",JOptionPane.INFORMATION_MESSAGE);
		        		 }
		        	  else{
			        	 JOptionPane.showMessageDialog(null,error,"搜索结果",JOptionPane.INFORMATION_MESSAGE); 
			        	
			         }
		        		 String returnback="";
		        		 for(int i=0;i<a-1;i++){
		        			 returnback=returnback+info[i]+"|";
		        		 }
		        		 for(int i=a+6;i<info.length;i++){
		        			 returnback=returnback+info[i]+"|";
		        		 }fos=new FileOutputStream("c:\\Temp\\rent.txt");
			      		 fos.write(returnback.getBytes());
			      		 
			      		 String renew="";
			      		
			      		while((lineStr=br2.readLine())!=null){
			      		String[] info2=lineStr.split("\\|");
                  for(int i=0;i<info2.length;i++){
                	  if(returndvdid.getText().compareTo(info2[i])==0){
                		  a=i;
                		  break;
                	  }
			      			
			     	}
                  int x=Integer.parseInt(info2[a+2])+1;
                  info2[a+2]=Integer.toString(x);
                  for(int i=0;i<info2.length;i++){
		      			renew=renew+info2[i]+"|";
		      		}fos=new FileOutputStream("c:\\Temp\\reports.txt");
		      		 fos.write(renew.getBytes());
			      		}
			      		
			      		
		         }
		        	
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				br.close();
				fr.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
         	}
			
		}
	}
}

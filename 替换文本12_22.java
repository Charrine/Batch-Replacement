package/*

@���к�
*/ Chapter12;

import java./*@��           ��              �� */io.BufferedReader;
import java./*@��           ��              �� */io.File;
import java./*@��           ��              �� */io.FileInputStream;
import java./*@��           ��              �� */io.IOException;
import java./*@��           ��              �� */io.InputStreamReader;
import java./*@��           ��              �� */io.PrintWriter;


public class �滻�ı�12_22 {

    public static void main(String[] args) {
    	�����滻 file = new �����滻("C:\\1","C:\\2","22","33");
        file.print(file.f, 0);
    }
}
    class �����滻{

    	private String in;
    	private String out;
    	private String newStr ;
    	private String oldStr ;
    	File f;
    	�����滻(String in,String out,String oldStr,String newStr){
    		this.in=in;this.out=out;this.newStr=newStr;this.oldStr=oldStr;this.f=new File(in);
    	}
    public void print(File f, int len) {

        File[] file = this.f.listFiles();

        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory()) { //�ж��Ƿ��ļ���
                print(file[i], len + 1);
            }

            // Ϊ��ֹ����ļ�����Դ�ļ������Ը��������·�� Ҳ��������������·��
            File outPath = new File(file[i].getParent().replace(in, out));
            File readfile = new File(file[i].getAbsolutePath());

            if (!readfile.isDirectory()) {
                String filename = readfile.getName(); // �������ļ���
                String absolutepath = readfile.getAbsolutePath(); // �ļ��ľ���·��
                readFile(absolutepath, filename, i, outPath); // ���� readFile
            }
        }
    }

    public void readFile(String absolutepath, String filename,
        int index, File outPath) {
        try {
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(absolutepath), "gb2312")); // ��������ȡ�ļ�

            StringBuffer strBuffer = new StringBuffer();


            for (String temp = null; (temp = bufReader.readLine()) != null;
                    temp = null) {
                if ((temp.indexOf(oldStr) != -1) &&
                        (temp.indexOf(oldStr) != -1)) { // �жϵ�ǰ���Ƿ������Ҫ�滻�����ַ�
                    temp = temp.replace(oldStr, newStr); // �˴������滻
                }

                strBuffer.append(temp);
                strBuffer.append(System.getProperty("line.separator")); // ���з�
            }

            bufReader.close();

            if (outPath.exists() == false) { // �������ļ����Ƿ���ڣ����������ȴ���
                outPath.mkdirs();
                System.out.println("�ѳɹ���������ļ��У�" + outPath);
            }

            PrintWriter printWriter = new PrintWriter(outPath + "\\" +
                    filename, "gb2312"); // �滻������ļ�·��
            printWriter.write(strBuffer.toString().toCharArray()); //����д��
            printWriter.flush();
            printWriter.close();
            System.out.println("�� " + (index + 1) + " ���ļ�   " + absolutepath +
                "  �ѳɹ������    " + outPath + "\\" + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


  /*  public static void main(String[] args) {
        try {
            for(int k=1;k<39;k++){
            //��ȡָ���ļ����µ������ļ�
            String filepath = "F:/areaFile file = new File(filepath);/"+k;//�������Ŀ¼�ļ���·��

            if (!file.isDirectory()) {
                System.out.println("---------- ���ļ�����һ��Ŀ¼�ļ� ----------");
            } else if (file.isDirectory()) {
                System.out.println("---------- �ܺã�����һ��Ŀ¼�ļ��� ----------");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                //    String path = readfile.getPath();//�ļ�·��
                    String absolutepath = readfile.getAbsolutePath();//�ļ��ľ���·��
                    String filename = readfile.getName();//�������ļ���
                    //////// ��ʼ�����Ķ�ȡ�ļ�  ////////
                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(absolutepath)));//��������ȡ�ļ�
                    StringBuffer strBuffer = new StringBuffer();
                    String empty = "";
                    String tihuan = "";
                    for (String temp = null; (temp = bufReader.readLine()) != null; temp = null) {
//                        if(temp.indexOf("/*") != -1 && temp.indexOf("") != -1){ //�жϵ�ǰ���Ƿ������Ҫ�滻�����ַ� -1��ʾ����
//                            tihuan = temp.substring(0, 9);//�����ȡ�೤�Լ���
//                            temp = temp.replace(tihuan, empty);//�滻Ϊ����Ҫ�Ķ���
//                        }
                         if (temp != null) {
                             temp = temp.replace("2009��", "2017��").replace("@chinaacc.com", "@med66.com").replace("Ȩ��", "").replace("����", "").replaceAll("������ʿ����ʱ��/�����ص�/��������������", "��ʿִҵ�ʸ��Ա���ʱ��/�����ص�/��������������")
                             .replace("������ʿ����", "��ʿִҵ�ʸ���").replace("/������ʿ���Ա����ص�/������ʿ�ʸ�֤���Ա�������/������ʿ�ʸ��Ա����ʸ�", "/��ʿ���Ա����ص�/��ʿ�ʸ�֤���Ա�������/��ʿ�ʸ��Ա����ʸ�");//����\\��ʾת��

                        strBuffer.append(temp);
                        strBuffer.append(System.getProperty("line.separator"));//������֮��ķָ�
                         }
                    }
                    bufReader.close();
                      File tempFile = new File("F:/html/area/"+k+"/");
                      tempFile.mkdirs();
                    PrintWriter printWriter = new PrintWriter("F:/html/area/"+k+"/"+filename);//�滻��������ļ�λ�ã��м������E:/ttt ����ı��ر���������ļ��У�
                    printWriter.write(strBuffer.toString().toCharArray());
                    printWriter.flush();
                    printWriter.close();
                    System.out.println("ok �� " + (i+1) +" ���ļ������ɹ���");
                    //////// ��ȡ�����һ���ļ�����  ////////
                }
                System.out.println("---------- �����ļ�������� ----------");
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}



*/
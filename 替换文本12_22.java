package/*

@刘承函
*/ Chapter12;

import java./*@刘           承              函 */io.BufferedReader;
import java./*@刘           承              函 */io.File;
import java./*@刘           承              函 */io.FileInputStream;
import java./*@刘           承              函 */io.IOException;
import java./*@刘           承              函 */io.InputStreamReader;
import java./*@刘           承              函 */io.PrintWriter;


public class 替换文本12_22 {

    public static void main(String[] args) {
    	批量替换 file = new 批量替换("C:\\1","C:\\2","22","33");
        file.print(file.f, 0);
    }
}
    class 批量替换{

    	private String in;
    	private String out;
    	private String newStr ;
    	private String oldStr ;
    	File f;
    	批量替换(String in,String out,String oldStr,String newStr){
    		this.in=in;this.out=out;this.newStr=newStr;this.oldStr=oldStr;this.f=new File(in);
    	}
    public void print(File f, int len) {

        File[] file = this.f.listFiles();

        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory()) { //判断是否文件夹
                print(file[i], len + 1);
            }

            // 为防止输出文件覆盖源文件，所以更改输出盘路径 也可自行设置其他路径
            File outPath = new File(file[i].getParent().replace(in, out));
            File readfile = new File(file[i].getAbsolutePath());

            if (!readfile.isDirectory()) {
                String filename = readfile.getName(); // 读到的文件名
                String absolutepath = readfile.getAbsolutePath(); // 文件的绝对路径
                readFile(absolutepath, filename, i, outPath); // 调用 readFile
            }
        }
    }

    public void readFile(String absolutepath, String filename,
        int index, File outPath) {
        try {
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(absolutepath), "gb2312")); // 数据流读取文件

            StringBuffer strBuffer = new StringBuffer();


            for (String temp = null; (temp = bufReader.readLine()) != null;
                    temp = null) {
                if ((temp.indexOf(oldStr) != -1) &&
                        (temp.indexOf(oldStr) != -1)) { // 判断当前行是否存在想要替换掉的字符
                    temp = temp.replace(oldStr, newStr); // 此处进行替换
                }

                strBuffer.append(temp);
                strBuffer.append(System.getProperty("line.separator")); // 换行符
            }

            bufReader.close();

            if (outPath.exists() == false) { // 检查输出文件夹是否存在，若不存在先创建
                outPath.mkdirs();
                System.out.println("已成功创建输出文件夹：" + outPath);
            }

            PrintWriter printWriter = new PrintWriter(outPath + "\\" +
                    filename, "gb2312"); // 替换后输出文件路径
            printWriter.write(strBuffer.toString().toCharArray()); //重新写入
            printWriter.flush();
            printWriter.close();
            System.out.println("第 " + (index + 1) + " 个文件   " + absolutepath +
                "  已成功输出到    " + outPath + "\\" + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


  /*  public static void main(String[] args) {
        try {
            for(int k=1;k<39;k++){
            //读取指定文件夹下的所有文件
            String filepath = "F:/areaFile file = new File(filepath);/"+k;//给我你的目录文件夹路径

            if (!file.isDirectory()) {
                System.out.println("---------- 该文件不是一个目录文件 ----------");
            } else if (file.isDirectory()) {
                System.out.println("---------- 很好，这是一个目录文件夹 ----------");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                //    String path = readfile.getPath();//文件路径
                    String absolutepath = readfile.getAbsolutePath();//文件的绝对路径
                    String filename = readfile.getName();//读到的文件名
                    //////// 开始挨个的读取文件  ////////
                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(absolutepath)));//数据流读取文件
                    StringBuffer strBuffer = new StringBuffer();
                    String empty = "";
                    String tihuan = "";
                    for (String temp = null; (temp = bufReader.readLine()) != null; temp = null) {
//                        if(temp.indexOf("/*") != -1 && temp.indexOf("") != -1){ //判断当前行是否存在想要替换掉的字符 -1表示存在
//                            tihuan = temp.substring(0, 9);//这里截取多长自己改
//                            temp = temp.replace(tihuan, empty);//替换为你想要的东东
//                        }
                         if (temp != null) {
                             temp = temp.replace("2009年", "2017年").replace("@chinaacc.com", "@med66.com").replace("权威", "").replace("最新", "").replaceAll("初级护士报名时间/报名地点/报名条件讨论区", "护士执业资格考试报名时间/报名地点/报名条件讨论区")
                             .replace("初级护士考试", "护士执业资格考试").replace("/初级护士考试报名地点/初级护士资格证考试报名条件/初级护士资格考试报名资格", "/护士考试报名地点/护士资格证考试报名条件/护士资格考试报名资格");//两个\\表示转义

                        strBuffer.append(temp);
                        strBuffer.append(System.getProperty("line.separator"));//行与行之间的分割
                         }
                    }
                    bufReader.close();
                      File tempFile = new File("F:/html/area/"+k+"/");
                      tempFile.mkdirs();
                    PrintWriter printWriter = new PrintWriter("F:/html/area/"+k+"/"+filename);//替换后输出的文件位置（切记这里的E:/ttt 在你的本地必须有这个文件夹）
                    printWriter.write(strBuffer.toString().toCharArray());
                    printWriter.flush();
                    printWriter.close();
                    System.out.println("ok 第 " + (i+1) +" 个文件操作成功！");
                    //////// 读取兵输出一个文件结束  ////////
                }
                System.out.println("---------- 所有文件操作完毕 ----------");
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}



*/
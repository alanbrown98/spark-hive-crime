/*
 * IBM DeveloperWorks
 * move file for import to Hive and Spark
 */
package kubuntu64harness;

import java.io.File;
/**
 *
 * @author hduser
 */
public class MoveFilesUtility {
    
    public static void main(String[] args) {
       //String mypath = "/home/hduser/zdata/uk-crime/crime-stop-search";
       String mypath = "/home/hduser/zdata/uk-crime/crime-street-crime";
       
       MoveFilesUtility o1 = new MoveFilesUtility();

       o1.listFilesAndFilesSubDirectories(mypath);  
    }
     public void listFilesAndFilesSubDirectories(String directoryName){

        String dest_dir = "/home/hduser/zdata/uk-crime/spark-lake/staging/";
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
                moveUkCrimeFilesToDir( dest_dir, file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }      
    /**
     * Copy uk crime file to another directory ( for hive data load
     * @param directoryNameDestination to be listed
     */
    public void moveUkCrimeFilesToDir(String directoryNameDestination, String mypath){
        try{
           File afile =new File(mypath);
           if(!afile.isFile()) return;
           if(afile.renameTo(new File(directoryNameDestination + afile.getName()))){           
    		System.out.println("File move successful!");
    	   }else{
    		System.out.println("File  failed to move!  " + afile.getName() );
    	   }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }    
}

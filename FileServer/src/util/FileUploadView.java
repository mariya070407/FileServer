package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
public class FileUploadView {
    
    
    public void upload(FileUploadEvent event)throws IOException{
    	try {   
    		String path=FacesContext.getCurrentInstance().getExternalContext().getRealPath("/UploadedFiles");
    		File targetFolder = new File(path);    		
 
    		try(InputStream inputStream = event.getFile().getInputstream()) {
    			try(OutputStream out = new FileOutputStream(new File(targetFolder,event.getFile().getFileName()))) {
    				int read = 0;
        			byte[] bytes = new byte[1024];
        			
        			while ((read = inputStream.read(bytes)) != -1) {        				        			
        				out.write(bytes, 0, read);
        			}
    			}    		
    		} 
    	} catch (IOException e) {			
			e.printStackTrace();
		}    	
    	System.out.println("File was successfully loaded!");
    	
	}

}

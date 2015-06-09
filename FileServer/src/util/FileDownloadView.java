package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class FileDownloadView {
	private StreamedContent download;
	private String downloadID;

	public void setDownload(StreamedContent download) {
	    this.download = download;
	}

	public StreamedContent getDownload() throws Exception {
	    return download;
	}

	public void prepDownload() {	
		try {
		    File file = new File(findPath()); 
		    InputStream input = new FileInputStream(file);	    
		    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		    setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
		    
		    System.out.println("Downloaded File = " + download.getName());
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful",  "File Downloaded") );
		}
		catch (Exception ex) {
			ex.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",  "File don't downloaded") );
		}
	}

	private String findPath(){
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/UploadedFiles")+StoredFiles.files.get(downloadID);
	}
	
	public String getDownloadID() {
		return downloadID;
	}

	public void setDownloadID(String downloadID) {
		this.downloadID = downloadID;
	}
}

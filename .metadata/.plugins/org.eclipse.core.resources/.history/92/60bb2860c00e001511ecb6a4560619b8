package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class StoredFiles {
	static Map<String, String> files;

    private List<String> queryResult=new ArrayList<String>();
	private String query;

	public StoredFiles() {
		files=new HashMap<String, String>();
		
		String path=FacesContext.getCurrentInstance().getExternalContext().getRealPath("/UploadedFiles");
		File []fList;        
		File F = new File(path);
		        
		fList = F.listFiles();
		                
		for(int i=0; i<fList.length; i++)           
		{
		     if(fList[i].isFile())
		     {
		         System.out.print("!!!"+String.valueOf(i) + " - " + fList[i].getName());
		         try {
					String hash=MD5CheckSum.getMD5(new FileInputStream(fList[i].getPath()));
					files.put(hash,fList[i].getName());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		         
		     }
		}

		
	}
	
	public void submit() { 	
		for(Map.Entry<String, String> e : files.entrySet()) {
			if(e.getValue().contains(query)) queryResult.add(e.getValue()+", ID = "+ e.getKey());
        }
	}
		
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<String> getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(List<String> queryResult) {
		this.queryResult = queryResult;
	}


}

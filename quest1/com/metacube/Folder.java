package quest1.com.metacube;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Folder {

	String name;
	List<Folder> subFolders;
	Folder parent;
	Date dateAndTime;


	public Folder(String name) {
		this.name = name;
		this.subFolders = new LinkedList<Folder>();
		this.parent=null;

		this.dateAndTime = Calendar.getInstance().getTime();  

	}

	/*
	 * method for Converting dateAndTime into String 
	 * @return dateAndTime 
	 *  */
	public String getDateAndTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String dateAndTime = dateFormat.format(this.dateAndTime);  
		return dateAndTime;
	}


	/*
	 * @return subFolders in this directory
	 * */
	public List<Folder> getSubFolders() {
		return subFolders;
	}

	/*
	 * @return name of the directory
	 * */
	public String getName() {
		return name;
	}

	/*
	 * @param name of the directory
	 * */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @return parent of the directory
	 * */
	public Folder getParent() {
		return parent;
	}

	/*
	 * @param parent of the directory
	 * */
	public void setParent(Folder parent) {
		this.parent = parent;
	}

	/*
	 * @param name, name of the subFolder which is going to be create
	 * @return "true" if folder has created successfully else "false" if same name folder exist from earlier then new folder with same name will not create
	 * */
	public boolean mkdir(String folderName) {

		Folder subFolder = findSubfolder(folderName);
		if(subFolder!=null) {
			return false;
		}
		subFolder = new Folder(folderName);
		subFolder.setParent(this);
		this.subFolders.add(subFolder);
		return true;
	}
	/*
	 * @param subFolderName, name of the subFolder in which controller going to enter
	 * @return subFolder if exist else return "null"
	 * */
	public Folder cd(String subFolderName) {

		return findSubfolder(subFolderName);

	}



	/*
	 * @param currentFolder as this
	 * @return parent folder of this folder
	 * */
	public Folder bk() {

		return this.getParent();

	}

	/*
	 * @param currentFolder as this
	 * @return subFolders  of this folder
	 * */
	public List<Folder> ls() {

		return this.getSubFolders();

	}

	/*
	 * @param subFolderName which we need to find recursively in subFolders
	 * @return foundSubFolder if folder exist else
	 * */
	public Folder find(String subFolderName) {

		List<Folder>  subFolders = this.getSubFolders();
		Folder foundFolder;

		for(Folder subFolder : subFolders) {

			//if this subFolder name is equal then return true
			if(subFolderName.equals(subFolder.getName())) {
				return subFolder;
			}
		}

		for(Folder subFolder : subFolders) {
			foundFolder = subFolder.find(subFolderName);
			if(foundFolder!=null) {
				return foundFolder;
			}
		}

		return null;

	}



	/*
	 * @param name, name of the subFolder which is going to be find
	 * @return subFolder if exist else null if doesn't exist
	 * */
	private Folder findSubfolder(String folderName) {

		for(Folder subFolder : this.getSubFolders()) {
			if(folderName.equals(subFolder.getName())){
				return subFolder;
			}
		}
		return null;

	}


}
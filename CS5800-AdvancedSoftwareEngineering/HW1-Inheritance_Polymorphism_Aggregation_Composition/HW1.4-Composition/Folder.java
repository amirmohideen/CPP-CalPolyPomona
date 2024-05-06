import java.util.ArrayList;

class Folder {
  private String folderName;
  private ArrayList<File> files;
  private ArrayList<Folder> subfolders;

  public Folder(String folderName) {
    this.folderName = folderName;
    this.files = new ArrayList<File>();
    this.subfolders = new ArrayList<Folder>();
  }

  public void setFolderName(String folderName) {
    this.folderName = folderName;
  }
  
  public String getFolderName() {
    return this.folderName;
  }

  public void addFile(File file) {
    this.files.add(file);
  }

  public void removeFile(File file) {
    this.files.remove(file);
  }

  public void addFolder(Folder folder) {
    this.subfolders.add(folder);
  }

  public void removeFolder(Folder folder) {
    this.subfolders.remove(folder);
  }

  public void deleteFolderbyName(String folderName) {
    for (Folder folder : this.subfolders) {
      if (folder.getFolderName().equals(folderName)) {
        this.subfolders.remove(folder);
        return;
      }
      folder.deleteFolderbyName(folderName);
    }
  }
 
  public void printFolderFileStructure() {
    System.out.println("\n" + this.folderName);
    for (File file : this.files) {
      System.out.println("- " + file.getFileName());
    }
    for (Folder folder : this.subfolders) {
      System.out.println("- " + folder.getFolderName());
      folder.printSubfolders(1);
    }
  }

  private void printSubfolders(int depth) {
    for (File file : this.files) {
      for (int i = 0; i < depth; i++) {
        System.out.print("  ");
      }
      System.out.println("- " + file.getFileName());
    }
    for (Folder folder : this.subfolders) {
      for (int i = 0; i < depth; i++) {
        System.out.print("  ");
      }
      System.out.println("- " + folder.getFolderName());
      folder.printSubfolders(depth + 1);
    }
  }
}

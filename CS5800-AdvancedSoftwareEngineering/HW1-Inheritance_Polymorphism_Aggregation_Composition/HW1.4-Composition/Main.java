public class Main {
  public static void main(String[] args) {

    Folder demo1 = new Folder("demo1");
    Folder folderSource = new Folder("source files");
    Folder folderPhalcon = new Folder(".phalcon");
    Folder folderApp = new Folder("app");
    Folder folderConfig = new Folder("config");
    Folder folderControllers = new Folder("controllers");
    Folder folderLibrary = new Folder("library");
    Folder folderMigrations = new Folder("migrations");
    Folder folderModels = new Folder("models");
    Folder folderViews = new Folder("views");
    Folder folderCache = new Folder("cache");
    Folder folderPublic = new Folder("public");
    File fileHtaccess = new File(".htaccess");
    File fileHtrouter = new File("htrouter.php");
    File fileIndex = new File("index.html");
    Folder folderIncludePath = new Folder("Include Path");
    Folder folderRemoteFiles = new Folder("Remote files");

    demo1.addFolder(folderSource);
    demo1.addFolder(folderPhalcon);
    demo1.addFolder(folderApp);
    folderApp.addFolder(folderConfig);
    folderApp.addFolder(folderControllers);
    folderApp.addFolder(folderLibrary);
    folderApp.addFolder(folderMigrations);
    folderApp.addFolder(folderModels);
    folderApp.addFolder(folderViews);
    demo1.addFolder(folderCache);
    demo1.addFolder(folderPublic);
    folderPublic.addFile(fileHtaccess);
    folderPublic.addFile(fileHtrouter);
    folderPublic.addFile(fileIndex);
    demo1.addFolder(folderIncludePath);
    demo1.addFolder(folderRemoteFiles);

    demo1.printFolderFileStructure();

    System.out.println("\nAfter deleting 'app' folder");
    demo1.deleteFolderbyName("app");
    demo1.printFolderFileStructure();

    System.out.println("\nAfter deleting 'public' folder");
    demo1.deleteFolderbyName("public");
    demo1.printFolderFileStructure();
  }
}

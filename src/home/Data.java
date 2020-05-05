package home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Manages the saving and loading of objects and lists of objects to external files.
 * All methods are static.
 */

public class Data {


    /**
     * Saves a list of T objects to an external file. Objects must implement the Serializable interface
     * @param listToSave - List of objects to save
     * @param shoppingListFile - file path of external file
     * @param <T> - Type of objects in list
     */
    public static <T> void saveList(ObservableList<T> listToSave, String shoppingListFile){

        List<T> alist = new ArrayList(listToSave);

        try (var out = new ObjectOutputStream(new FileOutputStream(shoppingListFile))){
            out.writeObject(alist);
        } catch (Exception e){
            System.out.println("Unable to save file");
        }
    }

    /**
     * Loads a list of T objects from an external file. Objects must implement the Serializable interface
     * @param fileLocation file path of external file
     * @param <T> Type of object in list
     * @return List of objects
     * @throws Exception If list of object cant be loaded and returned
     */
    public static <T> List<T> loadList(String fileLocation) throws Exception{
        try (var in = new ObjectInputStream(new FileInputStream(fileLocation))){

            List<T> readList = (List<T>) in.readObject();
            return FXCollections.observableList(readList);

        }
    }

    /**
     * Save an object to an external file. Object must implement the Serializable interface.
     * @param anObject The object to save
     * @param objectFilePath file path of external file
     */
    public static void saveObject(Object anObject, String objectFilePath){
        try (var out = new ObjectOutputStream(new FileOutputStream(objectFilePath))){
            out.writeObject(anObject);
        } catch (Exception e){
            System.out.println("Unable to save file, is the object serializable");
        }
    }

    /**
     * Loads an object from an external file. Object must implement the Serializable interface.
     * @param objectFilePath file path of the external file
     * @param <T> Type the object is cast too
     * @return The loaded Object
     * @throws Exception If the object cant be loaded and returned.
     */
    public static <T> T loadObject(String objectFilePath) throws Exception{
        try (var in = new ObjectInputStream(new FileInputStream(objectFilePath))){

            T loadedObject = (T) in.readObject();
            return loadedObject;

        }
    }

}

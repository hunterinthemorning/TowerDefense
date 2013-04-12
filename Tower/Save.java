
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Save implements Serializable 
{ 	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void save(Object YourObject, String filePath)
    { 
     // Write to disk with FileOutputStream
		try{
			FileOutputStream f_out = new FileOutputStream(filePath);

        // Write object with ObjectOutputStream
			ObjectOutputStream obj_out = new ObjectOutputStream (f_out);

        // Write object out to disk
			obj_out.writeObject (YourObject);
			obj_out.close();

		}catch(Exception e){
			System.out.println(" Exception " + e);
		}
    } 

    public static Object load(String filePath)
    { 
        try 
        { 
        	// Read from disk using FileInputStream
        	FileInputStream f_in = new 
        		FileInputStream(filePath);

        	// Read object using ObjectInputStream
        	ObjectInputStream obj_in = 
        		new ObjectInputStream (f_in);

        	// Read an object
        	Object obj = obj_in.readObject();
        	obj_in.close();
        	
        	return obj;
        	
        } 
        catch(FileNotFoundException ex) 
        { 
            ex.printStackTrace(); 
        } 
        catch(IOException ex) 
        { 
            ex.printStackTrace(); 
        } 
        catch(ClassNotFoundException u){
        	u.printStackTrace();
        }
        
        return null;
    } 
}
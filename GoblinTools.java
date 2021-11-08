import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class GoblinTools 
{
	public static ArrayList<String> parseHobbiesFile(String filename)
	{
		ArrayList<String> out = new ArrayList<String>();
		
		return out;
	}
	public static BufferedImage getImageFromFilename(String filename)
	{
		BufferedImage image;
		try 
		{                
	        image = ImageIO.read(new File(filename));
	    } 
		catch (IOException ex) 
		{
	          System.out.println(filename + " didn't load");
	          
	          return null;
	    }
		return image;
	}
	public static Scanner getFileScanner(String filename)
	{
		Scanner out;
		try 
		{
			out = new Scanner(new File(filename));
		} 
		catch (Exception e) 
		{
			System.out.println("File " + filename + " not read");
			e.printStackTrace();
			return new Scanner(System.in);
		}
		return out;
	}
	public static Font getFont()
	{
		Font font;
		try{
			font = Font.createFont(Font.TRUETYPE_FONT, new File("DRCALIGARI.TTF")).deriveFont(32f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		} 
		catch (FontFormatException e) 
		{
			e.printStackTrace();
			return null;
		}
		return font;
	}
	/*public static ImageIcon getIconFromFilename(String filename)
	{
		ImageIcon image;
		try 
		{                
	        //image = ImageIO.read(new File(filename));
	    } 
		catch (IOException ex) 
		{
	          System.out.println(filename + " didn't load");
	          
	          //image = new BufferedImage(100, 50, 50);
	    }
		return image;
	}*/
}

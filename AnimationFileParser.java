import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class AnimationFileParser 
{
	public static ArrayList<AnimationElement> getElements(String filename, AnimationJPanel panel)
	{
		ArrayList<AnimationElement> returnList = new ArrayList<AnimationElement>();
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<String> tokens = new ArrayList<String>();
		Boolean firstElement = true;
		Scanner fileScan;
		fileScan = GoblinTools.getFileScanner(filename);
		while (fileScan.hasNext())
		{
			lines.add(fileScan.nextLine());
		}
		AnimationElement currentElement = new AnimationElement(panel);
		
		for (String s : lines)
		{
			System.out.println(s);
			tokens = new ArrayList<String>();
			for (String ss : s.split(" "))
			{
				tokens.add(ss);
			}
			
			if (tokens.get(0).equals("element"))
			{
				if (!firstElement)
				{
					returnList.add(currentElement);
				}
				firstElement = false;
				currentElement = new AnimationElement(panel);

				currentElement.setImage(GoblinTools.getImageFromFilename(tokens.get(1)));
				continue;
				
				
				
			}
			
			if  (tokens.get(0).equals("setVisibility"))
			{
				if (tokens.get(2).equals("true"))
				{
					currentElement.addCommand(new SetVisibilityCommand(Integer.parseInt(tokens.get(1)), true));
				}
				else
					currentElement.addCommand(new SetVisibilityCommand(Integer.parseInt(tokens.get(1)), false));
				
				
			}
			
			
			if  (tokens.get(0).equals("moveTo"))
			{
				currentElement.addCommand(new MoveToCommand(Integer.parseInt(tokens.get(1)), Integer.parseInt(tokens.get(2)), Integer.parseInt(tokens.get(3)), Integer.parseInt(tokens.get(4))));
				
				
			}
			
			if (tokens.get(0).equals("rotate"))
			{
				System.out.println(Double.parseDouble(tokens.get(3)));
				
				System.out.println(tokens.get(3));
				currentElement.addCommand(new RotateCommand(Integer.parseInt(tokens.get(1)), Integer.parseInt(tokens.get(2)), Double.parseDouble(tokens.get(3))));
			}
			
			
			
		}
		
		returnList.add(currentElement);
		return returnList;
	}
	
	
}

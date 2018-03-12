package uk.nhs.nhsbsa.ccchs.helpers;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class CommonMethods {

	
	Screen s = new Screen();

	
	/*
   * Enter text on a specific image on the screen
   *
   * @param imageName and text
   */
	public void Enter_Text_Textbox(String imageName, String text){
        
		s.type(imageName, text);
    
	}
	
	
	/*
	* Find on a specific image on the screen
	*
	* @param imageName
	*/
	public void Find_Image(String imageName) throws FindFailed {
        
		s.find(imageName);
    
	}
	
	
	/*
	* Find element on screen and get text
	*
	* @param imageName
	* @return String
	*/
	public String Get_Image_Text(String imageName) throws FindFailed {
		
		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
        
		String imageText = s.find(imageName).text();
		System.out.println("imageText:......... " + imageText);
			
		return imageText;
    
	}
	

	/*
	* Click on a specific image on the screen
	*
	* @param imageName
	*/
	public void Click_Image(String imageName) throws FindFailed {
        
		s.click(imageName);
    
	}
	
	
	/*
	* Right click on a specific image on the screen
	*
	* @param imageName
	*/
	public void RightClick_Image(String imageName) throws FindFailed {
        
		s.rightClick(imageName);
    
	}
	
	
	/*
	* Double click on a specific image on the screen
	*
	* @param imageName
	*/
	public void DoubleClick_Image(String imageName) throws FindFailed {
        
		s.doubleClick(imageName);
    
	}
	
	

	/*
	* Check whether an element present on the screen
	*
	* @param imageName
	*/
	public void Exists_Image(String imageName) throws FindFailed {
        
		s.exists(imageName);
    
	}
	

	/*
	* Hover on a specific image on the screen
	*
	* @param imageName
	*/
	public void Hover_Image(String imageName) throws FindFailed {
        
		s.hover(imageName);
    
	}
	
	
	/*
	* Compare specific image on the screen
	*
	* @param imageName
	*/
	public void Compare_Image(String imageName) throws FindFailed {
       
		if (s.compare(imageName) != null)
		{
			System.out.println("Compared image: " + imageName);
			
		}
		else 
		{
			throw new FindFailed("NOT Compared image: " + imageName);
			
		}

    
	}
	

	/*
	* Pattern matching for specific image on the screen
	*
	* @param imageName
	*/
	public void Pattern_Image(String imageName) throws FindFailed {
        
		//s.find(find(new Pattern(imageName).exact()));
		
		Pattern imageSearch = new Pattern(imageName).exact();
		
		if (s.find(imageSearch) != null)
		{
			System.out.println("Pattren image found: " + imageName);
			
		}
		else 
		{
			throw new FindFailed("Pattren image NOT found: " + imageName);
			
		}

	}
	
	
	/*
	* Compare specific image on the screen
	*
	* @param imageName
	*/
	public void Match_Image(String imageName) throws FindFailed {

		Match imageMatch = s.find(imageName);
		
		
		if (imageMatch != null)
		{
			System.out.println("Match image found : " + imageName);
			
		}
		else 
		{
			throw new FindFailed("Match image NOT Found: " + imageName);
			
		}
		
	}
		
	

}

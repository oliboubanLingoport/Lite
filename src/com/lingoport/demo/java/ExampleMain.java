package com.lingoport.demo.java;

import java.util.Locale;

import javax.swing.*;

import com.lingoport.demo.java.utils.I18nUtils;

// Express will scan with any change; comments, code, header, whatever


/**
 * Example file for the i18n tutorial
 * This file has a hard coded string for the title of the frame.
 *
 */
public class ExampleMain {
	
    public static void main(String[] args){
    	
    	// Parse the locale if given as an argument
    	// if should be given in the form fr_FR or en_US
    	// of de_DE_Pseudo with a variant
    	// (simplistic argument parsing)
    	Locale locale = new Locale("en", "US"); // $NON-NLS-L$
    	if (args.length > 0) {
    		// try to split the string on _
    		String localeStr[] = args[0].split("_");
    		
    		// Try to build with a variant
    		try {
    			Locale candidateLocale = new Locale(localeStr[0], localeStr[1], localeStr[2]); // $NON-NLS-L$
    			locale = candidateLocale;
    		} catch (Exception ignore) {
        		try {
        			// if bad, for whatever reason, try without variant
        			Locale candidateLocale = new Locale(localeStr[0], localeStr[1]); // $NON-NLS-L$
        			locale = candidateLocale;
        		} catch (Exception ex) {
        			// If bad, just continue with the default locale
        		}			


    		}			

    	}
    	
    	I18nUtils.setLocale(locale); 

        //-- Make an invisible frame to attach the dialog to
        JFrame frame = new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExamplePanel panel = new ExamplePanel();
        frame.getContentPane().add(panel);
	changeFont(frame, new Font("Courier", Font.BOLD,28)); // $NON-NLS-L$
        frame.pack();
        frame.setVisible(true);
        String strTitle = "Example Address Book -- " + locale;
        frame.setTitle(strTitle);
    }
	
   /**
     *  Sets the Font for all the components of one container, 
     *  traversing the tree of containers and their components.
     *  
     * @param component
     * @param font
     */
    public static void changeFont ( Component component, Font font )
    {
        component.setFont ( font );
        if ( component instanceof Container )
        {
            for ( Component child : ( ( Container ) component ).getComponents () )
            {
                changeFont ( child, font );
            }
        }
    }
}

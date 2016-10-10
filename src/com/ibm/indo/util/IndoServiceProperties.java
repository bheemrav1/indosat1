/**
 * 
 */
package com.ibm.indo.util;

import java.io.Serializable;
import java.util.Properties;

import org.apache.log4j.Logger;





/**
 * @author Alok Ranjan
 *
 */
public class IndoServiceProperties implements Serializable {
	 static final long serialVersionUID = 10000000001L;
	 private static Logger log = Logger.getLogger("crmLogger");
	 private static Properties configProp   =   null;
	 private static  volatile IndoServiceProperties  uniqueInstance;
	 private IndoServiceProperties(){ }
	    /**
		 * @Purpose to get  Instantance of ErrorIdeaSingleTon
	     * @Type    Method
		 * @return ErrorIdeaSingleTon
		 */
	 public static   IndoServiceProperties  getInstance()
	    {
	        if (uniqueInstance ==null )
	        {
	            synchronized(IndoServiceProperties.class)
	            {
	                if (uniqueInstance ==null )
	                {
	                    uniqueInstance=new IndoServiceProperties();
	                }
	            }
	        }
	        return uniqueInstance ;
	    }
	    
	    /**
		 * @Purpose to get  Instantance of ErrorIdeaSingleTon
	     * @Type    Method
		 * @return ErrorIdeaSingleTon
		 */
	    public Properties getConfigSingletonObject(){
	    	if(configProp!=null)
	    		return configProp;
	    	try {
	    		configProp = IndoContextListener.PROPERTY;
	    		log.info("Properties loaded in configProperties.");
			} catch (Exception e) {
				log.info("Exception from PROPERTIES. Properties is not found."+e.getMessage());
			}
	        return configProp;
	    }

	    public static void main(String[] args) {
	    	IndoServiceProperties confProp=IndoServiceProperties.getInstance();
	        Properties prop = confProp.getConfigSingletonObject();
	    	log.info(prop.getProperty("Testconfig"));
		}
}


/*
 * created on 		19.12.2019
 * 
 * author:			jgomez
 * 
 **/

package org.jmgomezl;

import com.vividsolutions.jump.workbench.WorkbenchContext;
import com.vividsolutions.jump.workbench.plugin.AbstractPlugIn;
import com.vividsolutions.jump.workbench.plugin.EnableCheckFactory;
import com.vividsolutions.jump.workbench.plugin.MultiEnableCheck;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;
import com.vividsolutions.jump.workbench.ui.plugin.FeatureInstaller;



public class OpenJumpPlugin extends com.vividsolutions.jump.workbench.plugin.AbstractPlugIn {

	public OpenJumpPlugin()
	{
		// TODO Auto-generated constructor stub
	}

	public OpenJumpPlugin(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void initialize(PlugInContext context) throws Exception
	{
		FeatureInstaller featureInstaller = new FeatureInstaller(context.getWorkbenchContext());
		featureInstaller.addMainMenuItem(
					this,								//exe
					new String[] {"View"}, 	//menu path
					this.getName(), //name methode .getName recieved by AbstractPlugIn 
					false,			//checkbox
					null,			//icon
					createEnableCheck(context.getWorkbenchContext())); //enable check    
	  }

	/**
	 * Action on menu item selection:
	 * creates doc to show
	 */
	  public boolean execute(PlugInContext context) throws Exception
	  {
		context.getWorkbenchFrame().getOutputFrame().createNewDocument();
		context.getWorkbenchFrame().getOutputFrame().addText("Hello, World!");
		context.getWorkbenchFrame().getOutputFrame().surface();
			
		return true;
	  }

		
	public static MultiEnableCheck createEnableCheck(WorkbenchContext workbenchContext) {
		EnableCheckFactory checkFactory = new EnableCheckFactory(workbenchContext);
		
		return new MultiEnableCheck()
		.add(checkFactory.createWindowWithLayerNamePanelMustBeActiveCheck());
	}	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("OpenJumpPlugin");
		
	}

	
	
	
}

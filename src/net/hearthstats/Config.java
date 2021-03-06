package net.hearthstats;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

public class Config {

	private static String _version;
	
	private static Wini _ini = null;
	
	public static String getUserKey() {
		return  _getIni().get("API", "userkey", String.class);
	}
	
	private static int getIntegerSetting(String group, String key, int deflt) {
		String setting = _getIni().get(group, key);
		return setting == null ? deflt : Integer.parseInt(setting); 
	}
	
	public static int getX() {
		return getIntegerSetting("ui", "x", 0);
	}
	
	public static int getY() {
		return getIntegerSetting("ui", "y", 0);
	}
	
	public static int getWidth() {
		return getIntegerSetting("ui", "width", 600);
	}
	
	public static int getHeight() {
		return getIntegerSetting("ui", "height", 700);
	}

	private static Wini _getIni() {
		if(_ini == null) {
			try {
				
				// check for build/config.ini (dev environment)
				File buildConfigFile = new File("build/config.ini");
				
				_ini = new Wini(buildConfigFile.exists() ? buildConfigFile : new File("config.ini"));
			} catch (InvalidFileFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Exception in Config: " + e.toString());
			}
		}
		return _ini;
	}

	public static boolean startMinimized() {
		return _getIni().get("ui", "startminimized").toString().matches("true");
	}
	
	public static boolean analyticsEnabled() {
		return _getIni().get("analytics", "enabled").toString().matches("true");
	}
	
	public static boolean showEventLog() {
		return _getIni().get("ui", "eventlog").toString().matches("true");
	}
	
	public static boolean mirrorGameImage() {
		return _getIni().get("ui", "mirrorgame").toString().matches("true");
	}
	
	public static boolean checkForUpdates() {
		return _getIni().get("updates", "check").toString().matches("true");
	}
	
	public static boolean showDeckNotification() {
		return _getIni().get("notifications", "deck").toString().matches("true");
	}
	
	public static boolean showScreenNotification() {
		return _getIni().get("notifications", "screen").toString().matches("true");
	}
	
	public static boolean showHsFoundNotification() {
		return _getIni().get("notifications", "hsfound").toString().matches("true");
	}
	
	public static boolean showModeNotification() {
		return _getIni().get("notifications", "mode").toString().matches("true");
	}
	
	public static boolean showHsClosedNotification() {
		return _getIni().get("notifications", "hsclosed").toString().matches("true");
	}
	
	public static boolean minimizeToTray() {
		String setting = _getIni().get("ui", "mintotray");
		return (setting == null || setting.equals("true"));
	}
	
	public static boolean showNotifications() {
		String setting = _getIni().get("notifications", "enabled");
		return (setting == null || setting.equals("true"));
	}
	
	public static String getVersion() {
		if(_version == null) {
			_version = "";
			
			InputStream in = Config.class.getResourceAsStream("/version");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            try {
				while ((strLine = br.readLine()) != null)   {
				    _version += strLine;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Exception in Config: " + e.toString());
			}
			
		}
		return _version;
	}

	public static void setCheckForUpdates(boolean b) {
		_getIni().put("updates", "check", b);
		try {
			_getIni().store();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Exception in Config: " + e.toString());
		}
	}

	public static void setUserKey(String userkey) {
		// TODO Auto-generated method stub
		_getIni().put("API", "userkey", userkey);
		try {
			_getIni().store();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Exception in Config: " + e.toString());
		}
	}
	
	private static void _setIntVal(String group, String key, int val) {
		// TODO Auto-generated method stub
		_getIni().put(group, key, val + "");
		try {
			_getIni().store();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Exception in Config: " + e.toString());
		}
	}
	public static void setX(int val) {
		_setIntVal("ui", "x", val);
	}
	public static void setY(int val) {
		_setIntVal("ui", "y", val);
	}
	public static void setWidth(int val) {
		_setIntVal("ui", "width", val);
	}
	public static void setHeight(int val) {
		_setIntVal("ui", "height", val);
	}
}

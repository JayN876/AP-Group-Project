package helpers;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;


public class PropertyLoader {
	
	private final Properties _propertProperties;
	private final String _resourcePropertyName;
	private Boolean _isLoaded;
	public PropertyLoader(String resourcePropertyName) {
		this._propertProperties = new Properties();
		this._resourcePropertyName = resourcePropertyName;
		this._isLoaded = false;
	}

	public void loadPropertyResource() {
		this._isLoaded = false;
		
		try (InputStream inputStream = PropertyLoader.class.getResourceAsStream("/"+_resourcePropertyName);){
			
			this._propertProperties.load(inputStream);
			this._isLoaded = true;
		} catch (Exception e) {
			// TODO: handle exception
			// TODO: add logger here to show
			e.printStackTrace();
			this._isLoaded = false;
		}
	}
	
	public void addKeyValue(String key, String value) {
		if(this._isLoaded != false) {
			this._propertProperties.setProperty(key, value);
		}
		else {
			
		}
	}
	
	
	public void save() {
		try {
			this._propertProperties.store(new FileOutputStream(PropertyLoader.class.getResource("/"+_resourcePropertyName).getPath()), null);
		} catch (Exception e) {
			// TODO: handle exception
			// TODO: add logger here to show 
		}
	}
	
	public Properties getProperties() {
		return this._propertProperties;
	}
}

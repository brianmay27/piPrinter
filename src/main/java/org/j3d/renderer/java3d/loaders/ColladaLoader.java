package org.j3d.renderer.java3d.loaders;

import com.sun.j3d.loaders.*;
import org.j3d.loaders.collada.ColladaParser;
import org.xml.sax.InputSource;
import replicatorg.app.Base;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Shape3D;
import java.io.*;
import java.net.URL;
import java.util.logging.Level;

public class ColladaLoader extends LoaderBase {

	public Scene load(String filename) throws FileNotFoundException,
            IncorrectFormatException, ParsingErrorException {
		File file = new File(filename);
		return loadInternal(new InputSource(new FileInputStream(file)));
	}

	public Scene load(URL url) throws FileNotFoundException,
            IncorrectFormatException, ParsingErrorException {
		assert(url != null);
        try
        {
			InputStream is = url.openStream();
			return loadInternal(new InputSource(is));
        }
        catch( InterruptedIOException ie )
        {
            // user cancelled loading
            return null;
        }
        catch( IOException e )
        {
        	Base.logger.log(Level.SEVERE,"Could not open URL "+url.toString(),e);
        	return null;
        }
	}

	public Scene load(Reader reader) throws FileNotFoundException,
            IncorrectFormatException, ParsingErrorException {
		return loadInternal(new InputSource(reader));
	}

	public Scene loadInternal(InputSource is) {
		ColladaParser parser = new ColladaParser();
		parser.parse(is);
        final SceneBase scene = new SceneBase( );
        final BranchGroup bg = new BranchGroup( );
        final Shape3D shape = new Shape3D( parser.getTotalGeometry() );
        bg.addChild( shape );
        scene.addNamedObject("Object", shape);
        scene.setSceneGroup(bg);
		return scene;
	}

}

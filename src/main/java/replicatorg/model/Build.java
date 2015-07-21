/*
 Part of the ReplicatorG project - http://www.replicat.org
 Copyright (c) 2008 Zach Smith

 Forked from Arduino: http://www.arduino.cc

 Based on Processing http://www.processing.org
 Copyright (c) 2004-05 Ben Fry and Casey Reas
 Copyright (c) 2001-04 Massachusetts Institute of Technology

 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software Foundation,
 Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package replicatorg.model;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

/**
 * Stores information about files in the current build
 */
public class Build {

	private String name;
	private boolean hasMainWindow;
	/** Name of the build, which is the name of main file, sans extension. */
	public String getName() { return name; }

	/** Name of source file, used by load().  Recognized types so far are:
	 * .stl - model file
	 * .obj - model file
	 * .dae - model file
	 * .gcode - gcode file
	 * .ngc - gcode file
	 * .zip - composite build file
	 */
	String mainFilename;

	/**
	 * The folder which the base file is located in.
	 */
	public File folder;

	/**
	 * The elements of this build.
	 */
	private Vector<BuildElement> elements = new Vector<BuildElement>();

	/**
	 * The element that this build was opened as.
	 */
	private BuildElement openedElement;
	/**
	 * Retrieve the element that this build was opened as.  If a user opens a gcode file, it should 
	 * initially display that gcode rather than the model, etc.
	 */
	public BuildElement getOpenedElement() { return openedElement; }

	
	public Build(String path) throws IOException {
		hasMainWindow = false;
		if (path == null) {
			mainFilename = null;
			name = "Untitled";
			folder = new File("~");
			BuildElement code = new BuildCode(null,null);
			openedElement = code;
			code.setModified(true);
			elements.add(code);
		} else {
			File mainFile = new File(path);
			mainFilename = mainFile.getName();
			String suffix = "";
			int lastIdx = mainFilename.lastIndexOf('.');
			if (lastIdx > 0) {
				suffix = mainFilename.substring(lastIdx+1);
				name = mainFilename.substring(0,lastIdx);
			} else {
				name = mainFilename;
			}
			String parentPath = new File(path).getParent(); 
			if (parentPath == null) {
				parentPath = ".";
			}
			folder = new File(parentPath);
			if ("stl".equalsIgnoreCase(suffix) || "obj".equalsIgnoreCase(suffix) || "dae".equalsIgnoreCase(suffix)) {
				modelFile = mainFile;
			}
			loadCode();
			loadModel();
			if (("gcode".equalsIgnoreCase(suffix) || "ngc".equalsIgnoreCase(suffix)) && getCode() != null) {
				openedElement = getCode();
			} else {
				openedElement = getModel();
			}
		}
	}

	public void reloadCode() {
		Iterator<BuildElement> iterator = elements.iterator();
		while(iterator.hasNext()) {
			BuildElement e = iterator.next();
			if (e instanceof BuildCode) {
				elements.removeElement(e);
				break;
			}
		}
		loadCode();
	}

	public void loadCode() {
		File codeFile = new File(folder, name + ".gcode");
		if (codeFile.exists()) {
			elements.add(new BuildCode(name, codeFile));
		} else {
			codeFile = new File(folder, name + ".ngc");
			if (codeFile.exists()) {
				elements.add(new BuildCode(name, codeFile));
			}
		}
	}

	File modelFile = null;

	public void loadModel() {
		if (modelFile == null || !modelFile.exists()) {
			modelFile = new File(folder, name + ".stl");
		}
		if (modelFile.exists()) {
			elements.add(new BuildModel(this, modelFile));
		}		
	}


	


	/**
	 * Return the gcode object.
	 */
	public BuildCode getCode() {
		for (BuildElement e : elements) {
			if (e instanceof BuildCode) { return (BuildCode)e; }
		}
		return null;
	}

	/**
	 * Return the model object.
	 */
	public BuildModel getModel() {
		for (BuildElement e : elements) {
			if (e instanceof BuildModel) { return (BuildModel)e; }
		}
		return null;
	}

    /**
     * The line count.
     * @return the number of lines in the gcode.
     */
    public int getLines() {
        int ret;

        BuildCode code = getCode();
        if (null != code)
            ret = countLines(code.program);
        else
            ret = 0;

        return (ret);
	}

	protected int countLines(String what) {
		return what.split("\n").length - 1;
	}

	static public String scrubComments(String what) {
		char p[] = what.toCharArray();

		int index = 0;
		while (index < p.length) {
			// for any double slash comments, ignore until the end of the line
			if ((p[index] == '/') && (index < p.length - 1)
					&& (p[index + 1] == '/')) {
				p[index++] = ' ';
				p[index++] = ' ';
				while ((index < p.length) && (p[index] != '\n')) {
					p[index++] = ' ';
				}

				// check to see if this is the start of a new multiline comment.
				// if it is, then make sure it's actually terminated somewhere.
			} else if ((p[index] == '/') && (index < p.length - 1)
					&& (p[index + 1] == '*')) {
				p[index++] = ' ';
				p[index++] = ' ';
				boolean endOfRainbow = false;
				while (index < p.length - 1) {
					if ((p[index] == '*') && (p[index + 1] == '/')) {
						p[index++] = ' ';
						p[index++] = ' ';
						endOfRainbow = true;
						break;

					} else {
						index++;
					}
				}
				if (!endOfRainbow) {
					throw new RuntimeException(
							"Missing the */ from the end of a "
							+ "/* comment */");
				}
			} else { // any old character, move along
				index++;
			}
		}
		return new String(p);
	}



	/**
	 * Returns true if this is a read-only sketch. Used for the examples
	 * directory, or when sketches are loaded from read-only volumes or folders
	 * without appropriate permissions.
	 */
	public boolean isReadOnly() {
		BuildCode code = getCode();
		if (code == null) return false;
		// check to see if each modified code file can be written to
		return (code.isModified() && 
				!code.file.canWrite() &&
				code.file.exists());
	}

	/**
	 * Returns path to the main .gcode file for this sketch.
	 */
	public String getMainFilePath() {
		BuildCode code = getCode();
		if (code != null && code.file != null) {
			return code.file.getAbsolutePath();
		}
		return null;
	}

	/**
	 * @return True if any of the elements of the build are modified; false otherwise
	 */
	public boolean hasModifiedElements() {
		boolean rv = false;
		for (BuildElement e : elements) {
			if (e.isModified()) { rv = true; }
		}
		return rv;
	}

}

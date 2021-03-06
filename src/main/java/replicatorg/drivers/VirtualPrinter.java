package replicatorg.drivers;

/// A fake, but agreeable driver.

import org.w3c.dom.Node;
import replicatorg.app.Base;
import replicatorg.app.exceptions.BuildFailureException;
import replicatorg.machine.model.AxisId;
import replicatorg.machine.model.MachineModel;
import replicatorg.util.Point5d;

import javax.vecmath.Point3d;
import java.awt.*;
import java.util.EnumSet;

public class VirtualPrinter implements Driver, DriverQueryInterface {

	final String firmwareInfo = "No Firmware";
	final Version version = new Version(0,0);
	final Version minimumVersion = new Version(0,0);
	final Version preferredVersion = new Version(0,0);
  final Version minimumAccelerationVersion = new Version(0,0);
  final Version minimumJettyAccelerationVersion = new Version(0,0);
  final Version minAdvancedFeatureVersion = new Version(0,0);
	final boolean hasSoftStop = true;	
	final boolean hasEStop = true;
	
	double toolTemperature = 0;
	double toolTemperatureSetting = 0;
	double platformTemperature = 0;
	double platformTemperatureSetting = 0;
	boolean isInitialized = false;
	MachineModel machineModel = new MachineModel();
	Point5d currentPosition = new Point5d();
	Point5d maximumFeedrates = new Point5d(1,1,1,1,1);
	Point3d[] currentOffset = new Point3d[]{
			new Point3d(),
			new Point3d(),
			new Point3d(),
			new Point3d(),
			new Point3d()};
	
	@Override
	public void loadXML(Node xml) {
		// TODO Auto-generated method stub
		machineModel.loadXML(xml);
	}

	@Override
	public boolean isPassthroughDriver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void executeGCodeLine(String code) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isBufferEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void assessState() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasError() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DriverError getError() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkErrors() throws BuildFailureException {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize() throws VersionException {
		isInitialized = true;
	}

	@Override
	public void uninitialize() {
		isInitialized = false;
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return isInitialized;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public MachineModel getMachine() {
		return machineModel;
	}

	@Override
	public void setMachine(MachineModel m) {
		machineModel = m;
	}

	@Override
	public String getDriverName() {
		// TODO Auto-generated method stub
		return "VirtualPrinter";
	}

	@Override
	public String getFirmwareInfo() {
		// TODO Auto-generated method stub
		return firmwareInfo;
	}

	@Override
	public Version getVersion() {
		return version;
	}

	@Override
	public void updateManualControl() {
		// TODO Auto-generated method stub

	}

	@Override
	public Version getMinimumVersion() {
		// TODO Auto-generated method stub
		return minimumVersion;
	}
        
        @Override
	public Version getMinimumAccelerationVersion() {
		// TODO Auto-generated method stub
		return minimumAccelerationVersion;
	}

        @Override
	public Version getMinimumJettyAccelerationVersion() {
		// TODO Auto-generated method stub
		return minimumJettyAccelerationVersion;
	}

        @Override
	public Version getMinimumAdvancedFeatureVersion() {
		// TODO Auto-generated method stub
		return minAdvancedFeatureVersion;
	}

	@Override
	public Version getPreferredVersion() {
		// TODO Auto-generated method stub
		return preferredVersion;
	}
	
	@Override
	public void setCurrentPosition(Point5d p) throws RetryException {
		currentPosition = p;
	}

	@Override
	public void storeHomePositions(EnumSet<AxisId> axes) throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void recallHomePositions(EnumSet<AxisId> axes) throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean positionLost() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point5d getCurrentPosition(boolean update) {
		// Note that we don't have a 
		if (currentPosition == null) {
			currentPosition = new Point5d();
		}
		return currentPosition;
	}

	@Override
	public void invalidatePosition() {
		currentPosition = null;
	}

	@Override
	public void queuePoint(Point5d p) throws RetryException {
		currentPosition = p;
	}

	@Override
	public Point3d getOffset(int i) {
		return currentOffset[i];
	}

	@Override
	public void setOffsetX(int i, double j) {
		currentOffset[i].x = j;

	}

	@Override
	public void setOffsetY(int i, double j) {
		currentOffset[i].y = j;

	}

	@Override
	public void setOffsetZ(int i, double j) {
		currentOffset[i].z = j;

	}

	@Override
	public int getBuildToFileVersion() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setBuildToFileVersion(int version){
	}

	@Override
	public Point5d getPosition() {
		// TODO Auto-generated method stub
		return currentPosition;
	}

	
	public void requestToolChange(int toolIndex, int timeout)
			throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectTool(int toolIndex) throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFeedrateMM(double feed) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getCurrentFeedrate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAccelerationToggle(boolean on)
			throws RetryException {
		// TODO Auto-generated method stub
	}

	@Override
	public void homeAxes(EnumSet<AxisId> axes, boolean positive, double feedrate)
			throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delay(long millis) throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openClamp(int clampIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeClamp(int clampIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enableDrives() throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableDrives() throws RetryException {
		// TODO Auto-generated method stub

	}


	public void enableAxes(EnumSet<AxisId> axes) throws RetryException {
		// Not all drivers support this method.
	}
	
	public void disableAxes(EnumSet<AxisId> axes) throws RetryException {
		// Not all drivers support this method.
	}

	@Override
	public void changeGearRatio(int ratioIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readToolStatus() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getToolStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMotorDirection(int dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMotorRPM(double rpm, int toolhead) throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMotorSpeedPWM(int pwm) throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public double getMotorRPM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMotorSpeedPWM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void enableMotor() throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void enableMotor(long millis) throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableMotor() throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpindleRPM(double rpm) throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpindleSpeedPWM(int pwm) throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpindleDirection(int dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getSpindleRPM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpindleSpeedPWM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void enableSpindle() throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableSpindle() throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTemperature(double temperature) throws RetryException {
		toolTemperature = temperature;
		toolTemperatureSetting = temperature;
	}

	@Override
	public void setTemperature(double temperature, int toolhead) throws RetryException {
		toolTemperature = temperature;
		toolTemperatureSetting = temperature;
	}

	@Override
	public void readTemperature() {
	}

	@Override
	@Deprecated
	public double getTemperature() {
		return toolTemperature;
	}

	@Override
	public double getTemperature(int toolheadIndex) {
		return toolTemperature;
	}

	@Override
	public double getTemperatureSetting() {
		return toolTemperatureSetting;
	}

	@Override
	public void setPlatformTemperature(double temperature)
			throws RetryException {
		platformTemperature = temperature;
		platformTemperatureSetting = temperature;
	}

	@Override
	public void setPlatformTemperature(double temperature, int toolhead) throws RetryException {
		platformTemperature = temperature;
		platformTemperatureSetting = temperature;
	}

	
	@Override
	public void readPlatformTemperature() {
	}

	@Override
	public double getPlatformTemperature() {
		return platformTemperature;
	}

	/** relies on timing to have the 'right selected toolhead', deprecated */
	@Override
	@Deprecated
	public double getPlatformTemperature(int toolheadIndex) {
		return platformTemperature;
	}

	@Override
	public double getPlatformTemperatureSetting() {
		return platformTemperatureSetting;
	}

	@Override
	public void setChamberTemperature(double temperature) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readChamberTemperature() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getChamberTemperature() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void enableFloodCoolant() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableFloodCoolant() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enableMistCoolant() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableMistCoolant() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enableFan() throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableFan() throws RetryException {
		// TODO Auto-generated method stub

	}
	
	@Override 
	public void setAutomatedBuildPlatformRunning(boolean state) throws RetryException {
		//TODO: manually added
	}
	
	@Override
	public void openValve() throws RetryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeValve() throws RetryException {
		// TODO Auto-generated method stub

	}

	public void setStepperVoltage(int stepperId, int referenceValue)
	{
		Base.logger.finer("VirtualPrinter::setStepperVoltage");
		//generated method stub
	}

	public int getStepperVoltage(int stepperId)
	{
		Base.logger.finer("VirtualPrinter::setStepperVoltage");
		return 0;
		//generated method stub
	}
	

	public void storeStepperVoltage(int stepperId, int referenceValue)
	{
		Base.logger.finer("VirtualPrinter::storeStepperVoltage");
		//generated method stub
	}

	
	public void setLedStrip(Color color, int effectId)
	{
		Base.logger.finer("VirtualPrinter::setLedStrip");
		//generated method stub
	}
	
	
	public void sendBeep(int frequencyHz, int durationMs,int effect) throws RetryException
	{
		Base.logger.finer("VirtualPrinter::sendBeep");
		//generated method stub
	}

	
	@Override
	public void openCollet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeCollet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unpause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop(boolean abort) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasSoftStop() {
		// TODO Auto-generated method stub
		return hasSoftStop;
	}

	@Override
	public boolean hasEmergencyStop() {
		// TODO Auto-generated method stub
		return hasEStop;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean heartbeat() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point5d getMaximumFeedrates() {
		// TODO Auto-generated method stub
		return maximumFeedrates;
	}

	@Override
	public boolean hasAutomatedBuildPlatform() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void readAllTemperatures() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readAllPlatformTemperatures() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void setMotorDirection(int dir, int toolhead) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMotorSpeedPWM(int pwm, int toolhead) throws RetryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableMotor(int toolhead) throws RetryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableMotor(long millis, int toolhead) throws RetryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableMotor(int toolhead) throws RetryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableFan(int toolhead) throws RetryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableFan(int toolhead) throws RetryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutomatedBuildPlatformRunning(boolean state, int toolhead)
			throws RetryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	//// get machine or situation specific configs
	public String getConfigValue(String value, String baseline) {
		return baseline;
	}
}
